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

import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("report/")
public class ReportController extends BaseController{
	//这个注入的是通用mapper使用的service
			@Autowired
			private ReportService service;
			@Autowired
			private ActivityService activityservice;
			@Autowired
			private ClientUserService clientUserService;
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
