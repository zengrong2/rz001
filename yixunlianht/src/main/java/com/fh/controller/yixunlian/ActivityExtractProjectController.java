package com.fh.controller.yixunlian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.lw.pojo.yixunlian.TdActivityChargeItem;
import com.fh.lw.pojo.yixunlian.TdExtractproject;
import com.fh.service.yixunlian.ActivityExtractProjectService;
import com.fh.service.yixunlian.ActivityProjectService;
import com.fh.util.PageData;

@Controller
@RequestMapping("activityExtractProject/")
public class ActivityExtractProjectController extends BaseController{
	//这个注入的是通用mapper使用的service
			@Autowired
			private ActivityExtractProjectService service;
			/*
			 * 显示活动提成项目列表
			 * ActivityExtractProjectInfoDetail
			 */
			@RequestMapping(value="ActivityExtractProjectInfoDetail")
			public ModelAndView ActivityExtractProjectInfoDetail(){
					ModelAndView mv = this.getModelAndView();
					PageData pd = new PageData();
						try{
						pd = this.getPageData();			
						String activity_id = pd.getString("activity_id");
						
						TdExtractproject tdExtractproject = new TdExtractproject();
						tdExtractproject.setActivityId(activity_id);
						
							List<TdExtractproject> tdExtractprojecList = service.queryListByWhere(tdExtractproject);
							mv.addObject("tdExtractprojecList",tdExtractprojecList);
							mv.setViewName("system/activity/activityExtractProject_detail");
							
						} catch(Exception e){
							logger.error(e.toString(), e);
						}
						return mv;
					}
}
