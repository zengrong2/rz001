package com.fh.controller.yixunlian;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdBackgroundTransferRecordinput;
import com.fh.lw.pojo.yixunlian.TdComplaint;
import com.fh.lw.pojo.yixunlian.TdPartnerBonusTransferRecordinput;
import com.fh.lw.pojo.yixunlian.TdReport;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityMusicService;
import com.fh.service.yixunlian.ActivityMusicSqlManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.ComplaintService;
import com.fh.service.yixunlian.ComplaintSqlManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

//投诉列表
@Controller
@RequestMapping("complaint/")
public class ComplaintController extends BaseController{
	//这个注入的是通用mapper使用的service
			@Autowired
			private ComplaintService service;
			//这是注入的是写sql语句的service
			@Autowired
			private ComplaintSqlManager sqlService;
			@Autowired
			private UserManager um;
		   @Resource(name="fhlogService")
			private FHlogManager FHLOG;
		   @Autowired
			private ClientUserService clientUserService;
		   @Autowired
			private ActivityService activityservice;
		   @RequestMapping(value="goListComplaint")
			public ModelAndView goListComplaint(Page page)throws Exception {
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				pd.put("USERNAME",Jurisdiction.getUsername());
				PageData user=this.um.findByUsername(pd);//通过用户名找出用户
				String keywords = pd.getString("keywords");
				//投诉人名字
				if(null!=keywords&&!"".equals(keywords)) {
					TdUser tdUser = new TdUser();
					tdUser.setMemberid(keywords);
					TdUser tdUser2 = clientUserService.queryOne(tdUser);
					if(tdUser2!=null) {
						pd.put("keywords", tdUser2.getUserId());
						page.setPd(pd);			
					}
				}
				//付款人名字检索
				String userName = pd.getString("userName");
				if(userName!=null) {			
					TdUser tdUser = new TdUser();
					
					tdUser.setuNickname(userName);
					TdUser tdUser2 = clientUserService.queryOne(tdUser);
					//根据关键词搜索，查看该用户是否为空
					if(tdUser2!=null) {				
						pd.put("keywords", tdUser2.getUserId());	
						page.setPd(pd);	
					}
				}
				
					List<PageData> listTdComplaint = this.sqlService.getAllTdComplaint(page);
					for (PageData pageData : listTdComplaint) {
						TdUser tdUser = clientUserService.queryById(pageData.getString("user_id"));
						if(tdUser!=null) {
							pageData.put("nickName", tdUser.getuNickname());
							pageData.put("memberid", tdUser.getMemberid());
						}
						TdActivity tdActivity = activityservice.queryById(pageData.getString("activity_id"));
					    if(tdActivity!=null) {
					    	pageData.put("activityName", tdActivity.getActivityName());
					    }
					}
					mv.setViewName("system/activity/complaint_list");
				    mv.addObject("listTdComplaint",listTdComplaint);
					mv.addObject("QX",Jurisdiction.getHC());//按钮权限
					mv.addObject("pd", pd);
				return mv;
			}
		   /*
		    * 删除单个投诉信息
		    * delComplaintById
		    */
			@RequestMapping(value = "/delComplaintById")
			public void delComplaintById(PrintWriter out) throws Exception {
				PageData pd = new PageData();
				pd = this.getPageData();
				String complaint_id = pd.getString("complaint_id");
				TdComplaint tdComplaint = service.queryById(complaint_id);
				FHLOG.save(Jurisdiction.getUsername(), "删除单个账单");
				
			    this.service.deleteComplaintById(complaint_id);
			
				out.write("success");
				out.close();
			}
		   /*
		    * 批量删除
		    * deleteAllComplaint
		    * complaint_IDS
		    */
			@RequestMapping(value="/deleteAllComplaint")
			@ResponseBody
			public Object deleteAllComplaint() throws Exception {
				
				FHLOG.save(Jurisdiction.getUsername(), "批量删除收入记录");
				TdComplaint tdComplaint = new TdComplaint();
				PageData pd = new PageData();
				List<PageData> pdList = new ArrayList<PageData>();
				Map<String,Object> map = new HashMap<String,Object>();
				pd = this.getPageData();
				String complaint_IDS = pd.getString("complaint_IDS");
				service.delAllTdComplaint(complaint_IDS);	
				pdList.add(pd);
				map.put("list", pdList);
				return AppUtil.returnObject(pd, map);
			}
			/*
			 * 查看用户信息通过id
			 * showUserInfoById
			 * user_id
			 */
			@RequestMapping(value="/showUserInfoById")
			public ModelAndView showUserInfoById() throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				String user_id = pd.getString("user_id");
				TdUser tdUser = clientUserService.queryById(user_id);
				/*pd = wm.findPositionByPidd(pd);	*/
				
				mv.setViewName("system/activity/complaint_userDetails");
				mv.addObject("msg", "editU");
				mv.addObject("pd", pd);
				mv.addObject("tdUser", tdUser);
				return mv;
			}
			/*
			 * 查看活动信息通过id
			 * showActivityDetailById
			 * activity_id
			 */
			@RequestMapping(value="/showActivityDetailById")
			public ModelAndView showActivityDetailById() throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				String activity_id = pd.getString("activity_id");
				TdActivity tdActivity = activityservice.queryById(activity_id);
				/*pd = wm.findPositionByPidd(pd);	*/
				
				mv.setViewName("system/activity/complaint_activityDetails");
				mv.addObject("msg", "editU");
				mv.addObject("pd", pd);
				mv.addObject("tdActivity", tdActivity);
				return mv;
			}
			//
			//被投诉列表SoloActivityComplaintList
			@RequestMapping(value="SoloActivityComplaintList")
			public ModelAndView SoloActivityComplaintList(){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			try{
				pd = this.getPageData();			
			    String activity_id = pd.getString("activity_id");	
			    TdActivity tdActivity = activityservice.queryById(activity_id);
			    TdComplaint tdComplaint = new TdComplaint();					
			    tdComplaint.setActivityId(activity_id);
				List<TdComplaint> listTdComplaint = service.queryListByWhere(tdComplaint);
				for (TdComplaint tdComplaint2 : listTdComplaint) {
					TdUser tdUser = clientUserService.queryById(tdComplaint2.getUserId());
					if(tdUser!=null) {
						tdComplaint2.setComplaintUserName(tdUser.getuNickname());
						tdComplaint2.setComplaintUserMemberId(tdUser.getMemberid());
						tdComplaint2.setComplaintUserPhone(tdUser.getuPhone());
					}
					
				}
				mv.addObject("listTdComplaint",listTdComplaint);
				mv.addObject("tdActivity",tdActivity);
				
				mv.setViewName("system/activity/activityComplaintList_detail");
							
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
			return mv;
		}
			//updateComplaintState
			//修改投诉状态	
			@RequestMapping(value="/updateComplaintState")
			public ModelAndView updateComplaintState() throws Exception{
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				String complaintId = pd.getString("complaintId");				
				TdComplaint tdComplaint = service.queryById(complaintId);
				String activityId = pd.getString("activityId");
				TdActivity tdActivity = activityservice.queryById(activityId);
				String isExamine = pd.getString("isExamine");
				Integer isExamines = Integer.parseInt(isExamine);				
				/*if(isExamines==0) {	
					FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":审核举报->"+tdActivity.getActivityName()+":"+);
					logBefore(logger, Jurisdiction.getUsername()+"修改:"+tdActivity.getActivityName()+"活动状态:上架活动");
				}*/
			   System.out.println("isExamines"+isExamines);
				service.updateComplaintState(complaintId,isExamines);
				mv.addObject("msg","ok");
				mv.setViewName("save_result");
				return mv;
			}
}
