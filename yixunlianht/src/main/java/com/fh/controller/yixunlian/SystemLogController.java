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
import com.fh.lw.pojo.yixunlian.SysFhlog;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.SystemLogService;
import com.fh.service.yixunlian.SystemLogSqlManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("systemLog/")
public class SystemLogController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private SystemLogService service;
		//这是注入的是写sql语句的service
		@Autowired
		private SystemLogSqlManager sqlService;
		@Autowired
		private UserManager um;
		@Resource(name="fhlogService")
		private FHlogManager FHLOG;
		@RequestMapping(value="goListSystemLog")
		public ModelAndView goListSystemLog(Page page)throws Exception {
			
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
		
				List<SysFhlog> listSysLog = this.sqlService.getAllSysFhlog(page);
				mv.setViewName("system/systemManager/sysFhlog_list");
			    mv.addObject("listSysLog",listSysLog);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 删除单个日志
		 * delSystemLogById
		 */
		@RequestMapping(value = "/delSystemLogById")
		public void delSystemLogById(PrintWriter out) throws Exception {
			PageData pd = new PageData();
			pd = this.getPageData();
			String FHLOG_ID = pd.getString("FHLOG_ID");
			SysFhlog sysFhlog = new SysFhlog();
			/*FHLOG.save(Jurisdiction.getUsername(), "删除用户"+tdUser.getuName());*/
			
		   /* this.service.deleteTdUserByAid(user_id);*/
			
			sysFhlog.setFhlogId(FHLOG_ID);
			this.service.deleteByWhere(sysFhlog);
			/*this.service.deleteByIds(FHLOG_ID);*/
		
			out.write("success");
			out.close();
		}
		/*
		 * 批量删除日志
		 * deleteAllSystemLog
		 */
		@RequestMapping(value="/deleteAllSystemLog")
		@ResponseBody
		public Object deleteAllSystemLog() throws Exception {
			
		/*	FHLOG.save(Jurisdiction.getUsername(), "批量删除系统日志");*/
			SysFhlog sysFhlog = new SysFhlog();
			PageData pd = new PageData();
			List<PageData> pdList = new ArrayList<PageData>();
			Map<String,Object> map = new HashMap<String,Object>();
			pd = this.getPageData();
			String systemLog_IDS = pd.getString("SystemLog_IDS");
			service.delAllSystemLog(systemLog_IDS);	
			pdList.add(pd);
			map.put("list", pdList);
			return AppUtil.returnObject(pd, map);
		}
}
