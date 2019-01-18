package com.fh.controller.yixunlian;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.ActivityTypeService;
import com.fh.service.yixunlian.ActivityTypeSqlManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
/*
 * 活动类型
 */
@Controller
@RequestMapping("activityType/")
public class ActivityTypeController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private ActivityTypeService service;
		//这是注入的是写sql语句的service
		@Autowired
		private ActivityTypeSqlManager sqlService;
		@Autowired
		private UserManager um;
		@Resource(name="fhlogService")
		private FHlogManager FHLOG;
		
		@RequestMapping(value="goListactivityType")
		public ModelAndView goListactivityType(Page page)throws Exception {
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("USERNAME",Jurisdiction.getUsername());
			PageData user=this.um.findByUsername(pd);//通过用户名找出用户
			String keywords = pd.getString("keywords");
			//活动名称
			if(null!=keywords&&!"".equals(keywords)) {
				pd.put("keywords", keywords);
			
				page.setPd(pd);			
			}
			
				List<TdActivitycategory> listActivitycategory = this.sqlService.getAllTdActivity(page);
				mv.setViewName("system/activity/activityCategory_list");
			    mv.addObject("listActivitycategory",listActivitycategory);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 删除活动类型
		 * delActivityTypeByAid
		 */
		@RequestMapping(value = "/delActivityTypeByAid")
		public void delActivityTypeByAid(PrintWriter out) throws Exception {
			PageData pd = new PageData();
			pd = this.getPageData();
			String activitycategory_id = pd.getString("activitycategory_id");
			TdActivitycategory tdActivityType = service.queryById(activitycategory_id);
			FHLOG.save(Jurisdiction.getUsername(), "删除活动类型"+tdActivityType.getActivitycategoryName());
			
		    this.service.deleteActivityTypeByAid(activitycategory_id);
		
			out.write("success");
			out.close();
		}
		
		/*
		 * 跳转到修改界面
		 * goEditActivityType
		 */
		@RequestMapping(value="/goEditActivityType")
		public ModelAndView goEditActivityType() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			String activitycategory_id = pd.getString("activitycategory_id");
			TdActivitycategory tdActivityType = service.queryById(activitycategory_id);
			/*pd = wm.findPositionByPidd(pd);	*/
			
			mv.setViewName("system/activity/activityCategory_edit");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
			mv.addObject("tdActivityType", tdActivityType);
			return mv;
		}
		
		/**
		 * 执行修改
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="/editActivityTypeByAid")
		public ModelAndView editActivityByAid() throws Exception{
			logBefore(logger, Jurisdiction.getUsername()+"修改");
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();

			String activitycategory_id = pd.getString("activitycategory_id");
			String activitycategory_name = pd.getString("activitycategory_name");
			String remark = pd.getString("remark");
			
			service.updateTdActivityType(activitycategory_id,activitycategory_name,remark);	//执行修改,？？传参数	
			//添加系统日志
			TdActivitycategory tdActivityType = service.queryById(activitycategory_id);
			FHLOG.save(Jurisdiction.getUsername(), "修改活动类型"+tdActivityType.getActivitycategoryName()+"的信息");
			mv.addObject("msg","success");
			mv.setViewName("save_result");
			return mv;
		}
		/*
		 * 跳转到添加活动类型界面
		 * goAddActivityType
		 */
		@RequestMapping(value="/goAddActivityType")
		public ModelAndView goAddActivityType(Page page)throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			mv.setViewName("system/activity/activityCategory_add");
			mv.addObject("msg", "saveU");
			mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 执行添加活动类型
		 * saveActivityTypeInfo
		 */
		@RequestMapping(value="/saveActivityTypeInfo")
		public ModelAndView saveActivityTypeInfo() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
	*/		logBefore(logger, Jurisdiction.getUsername()+"新增");
			ModelAndView mv = this.getModelAndView();
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("USERNAME",Jurisdiction.getUsername());
			PageData user=this.um.findByUsername(pd);//通过用户名找出用户
			TdActivitycategory tdActivityType = new TdActivitycategory();
		
			tdActivityType.setActivitycategoryId(this.get32UUID());
			tdActivityType.setActivitycategoryName(pd.getString("activitycategory_name"));
            service.save(tdActivityType);
            //添加系统日志
            
			FHLOG.save(Jurisdiction.getUsername(), "添加活动类型"+pd.getString("activitycategory_name"));
			
            
			mv.addObject("msg","success");
		    mv.setViewName("save_result");		
			return mv;
		}
		/*
		 * 活动类型批量删除
		 * deleteAllActivityType
		 */
		
		@RequestMapping(value="/deleteAllActivityType")
		@ResponseBody
		public Object deleteAllActivityType() throws Exception {
			
			FHLOG.save(Jurisdiction.getUsername(), "批量删除活动类型");
			TdActivitycategory tdActivityType = new TdActivitycategory();
			PageData pd = new PageData();
			List<PageData> pdList = new ArrayList<PageData>();
			Map<String,Object> map = new HashMap<String,Object>();
			pd = this.getPageData();
			String ActivityType_IDS = pd.getString("ActivityType_IDS");
			service.delAllActivity(ActivityType_IDS);	
			pdList.add(pd);
			map.put("list", pdList);
			return AppUtil.returnObject(pd, map);
		}
}

