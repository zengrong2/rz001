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
import com.fh.lw.pojo.yixunlian.TdActivityChargeItem;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdComplaint;
import com.fh.lw.pojo.yixunlian.TdReport;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityMusicService;
import com.fh.service.yixunlian.ActivityMusicSqlManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.ReportService;
import com.fh.service.yixunlian.ReportSqlManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("report/")
public class ReportController extends BaseController{
	//这个注入的是通用mapper使用的service
			@Autowired
			private ReportService service;
			//这是注入的是写sql语句的service
			@Autowired
			private ReportSqlManager sqlService;
			@Autowired
			private UserManager um;
		   @Resource(name="fhlogService")
			private FHlogManager FHLOG;
		   @Autowired
		  private ClientUserService clientUserService;
		   @Autowired
		  private ActivityService activityservice;
		   @RequestMapping(value="goListReport")
			public ModelAndView goListReport(Page page)throws Exception {
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				pd.put("USERNAME",Jurisdiction.getUsername());
				PageData user=this.um.findByUsername(pd);//通过用户名找出用户
				String keywords = pd.getString("keywords");
				
				//举报者会员id
				if(null!=keywords&&!"".equals(keywords)) {
					TdUser tdUser = new TdUser();
					tdUser.setMemberid(keywords);
					TdUser tdUser2 = clientUserService.queryOne(tdUser);
					if(tdUser2!=null) {
						pd.put("keywords", tdUser2.getUserId());
						page.setPd(pd);			
					}
				}
				//举报者姓名
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
					List<PageData> listTdReport = this.sqlService.getAllTdReport(page);
					for (PageData pageData : listTdReport) {
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
					mv.setViewName("system/activity/report_list");
				    mv.addObject("listTdReport",listTdReport);
					mv.addObject("QX",Jurisdiction.getHC());//按钮权限
					mv.addObject("pd", pd);
				return mv;
			}
		   /*
		    * 删除单个举报信息
		    * delReportById
		    * report_id
		    */
			@RequestMapping(value = "/delReportById")
			public void delReportById(PrintWriter out) throws Exception {
				PageData pd = new PageData();
				pd = this.getPageData();
				String report_id = pd.getString("report_id");
				TdReport tdReport = service.queryById(report_id);
				FHLOG.save(Jurisdiction.getUsername(), "删除单个账单");
				
			    this.service.deleteReportById(report_id);
			
				out.write("success");
				out.close();
			}
		   /*
		    * 批量删除多个
		    * deleteAllReport
		    * report_IDS
		    */
			@RequestMapping(value="/deleteAllReport")
			@ResponseBody
			public Object deleteAllReport() throws Exception {
				
				FHLOG.save(Jurisdiction.getUsername(), "批量删除收入记录");
				TdReport tdReport = new TdReport();
				PageData pd = new PageData();
				List<PageData> pdList = new ArrayList<PageData>();
				Map<String,Object> map = new HashMap<String,Object>();
				pd = this.getPageData();
				String report_IDS = pd.getString("report_IDS");
				service.delAllTdReport(report_IDS);	
				pdList.add(pd);
				map.put("list", pdList);
				return AppUtil.returnObject(pd, map);
			}
			/*
			 * 显示用户详情
			 * showUserDetailById
			 * user_id
			 */
			@RequestMapping(value="/showUserDetailById")
			public ModelAndView showUserDetailById() throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				String user_id = pd.getString("user_id");
				TdUser tdUser = clientUserService.queryById(user_id);
				/*pd = wm.findPositionByPidd(pd);	*/
				
				mv.setViewName("system/activity/report_userDetails");
				mv.addObject("msg", "editU");
				mv.addObject("pd", pd);
				mv.addObject("tdUser", tdUser);
				return mv;
			}
			/*
			 * 显示活动详情
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
				
				mv.setViewName("system/activity/report_activityDetails");
				mv.addObject("msg", "editU");
				mv.addObject("pd", pd);
				mv.addObject("tdActivity", tdActivity);
				return mv;
			}
			//被举报列表SoloActivityReportList
			@RequestMapping(value="SoloActivityReportList")
			public ModelAndView SoloActivityReportList(){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			try{
				pd = this.getPageData();			
			    String activity_id = pd.getString("activity_id");	
			    TdActivity tdActivity = activityservice.queryById(activity_id);
			    TdReport tdReport = new TdReport();					
			    tdReport.setActivityId(activity_id);
				List<TdReport> listTdReport = service.queryListByWhere(tdReport);
				for (TdReport tdReport2 : listTdReport) {
					TdUser tdUser = clientUserService.queryById(tdReport2.getUserId());
					if(tdUser!=null) {
						tdReport2.setReportUserName(tdUser.getuNickname());
						tdReport2.setReportUserMemberId(tdUser.getMemberid());
						tdReport2.setReportUserPhone(tdUser.getuPhone());
					}
					
				}
				mv.addObject("listTdReport",listTdReport);
				mv.addObject("tdActivity",tdActivity);
				
				mv.setViewName("system/activity/activityReportList_detail");
							
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
			return mv;
		}
	//修改举报状态updateReportState	
			@RequestMapping(value="/updateReportState")
			public ModelAndView updateReportState() throws Exception{
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				String reportId = pd.getString("reportId");				
				TdReport tdReport = service.queryById(reportId);
				String activityId = pd.getString("activityId");
				TdActivity tdActivity = activityservice.queryById(activityId);
				String isExamine = pd.getString("isExamine");
				Integer isExamines = Integer.parseInt(isExamine);				
				/*if(isExamines==0) {	
					FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":审核举报->"+tdActivity.getActivityName()+":"+);
					logBefore(logger, Jurisdiction.getUsername()+"修改:"+tdActivity.getActivityName()+"活动状态:上架活动");
				}*/
			
				service.updateReportState(reportId,isExamines);
				mv.addObject("msg","ok");
				mv.setViewName("save_result");
				return mv;
			}
}
