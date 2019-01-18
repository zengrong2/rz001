package com.fh.controller.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.lw.pojo.yixunlian.TdActivityChargeItem;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityProjectService;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.util.PageData;
//活动收费项目表
@Controller
@RequestMapping("activityProject/")
public class ActivityProjectController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private ActivityProjectService service;
		//这是注入的是写sql语句的service
	/*	@Autowired
		private ActivityProjectSqlManager sqlService;*/
		@Autowired
		private UserManager um;
		 @Resource(name="fhlogService")
		 private FHlogManager FHLOG;
		 /*
			 * 显示活动收费项目详情列表
			 * ActivityProjectInfoDetail
			 */
			@RequestMapping(value="ActivityProjectInfoDetail")
			public ModelAndView ActivityProjectInfoDetail(){
					ModelAndView mv = this.getModelAndView();
					PageData pd = new PageData();
						try{
						pd = this.getPageData();			
						String activity_id = pd.getString("activity_id");
						
						TdActivityChargeItem tdActivityChargeItem = new TdActivityChargeItem();
					
						tdActivityChargeItem.setActivityId(activity_id);
						
						List<TdActivityChargeItem> tdActivityChargeItemList = service.queryListByWhere(tdActivityChargeItem);
						
							
							mv.addObject("tdActivityChargeItemList",tdActivityChargeItemList);
							mv.setViewName("system/activity/activityProject_detail");
							
						} catch(Exception e){
							logger.error(e.toString(), e);
						}
						return mv;
					}
}
