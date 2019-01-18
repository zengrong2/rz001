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

import com.fh.lw.pojo.yixunlian.TdReport;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityMusicService;
import com.fh.service.yixunlian.ActivityMusicSqlManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.ComplaintService;

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
			@Autowired
			private ActivityService activityservice;
			@Autowired
			private ClientUserService clientUserService;
			//这是注入的是写sql语句的service
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
