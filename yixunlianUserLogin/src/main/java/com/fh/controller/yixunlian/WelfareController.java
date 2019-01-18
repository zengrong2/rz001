package com.fh.controller.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdMembershipwelfare;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.WelfareService;
import com.fh.service.yixunlian.WelfareSqlManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
@Controller
@RequestMapping("welfare/")
public class WelfareController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private WelfareService service;
		//这是注入的是写sql语句的service
		@Autowired
		private WelfareSqlManager sqlService;
		@Autowired
		private UserManager um;
		@Resource(name="fhlogService")
		private FHlogManager FHLOG;
		
		@RequestMapping(value="goListwelfare")
		public ModelAndView goListwelfare(Page page)throws Exception {
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("USERNAME",Jurisdiction.getUsername());
			PageData user=this.um.findByUsername(pd);//通过用户名找出用户
			String keywords = pd.getString("keywords");
			//福利名称
			if(null!=keywords&&!"".equals(keywords)) {
				pd.put("keywords", keywords);
			
				page.setPd(pd);			
			}
			/*//主办方名称检索
			String userName = pd.getString("userName");
			if(userName!=null) {			
				TdUser tdUser = new TdUser();
				tdUser.setuName(userName);
				TdUser tdUser2 = clientUserservice.queryOne(tdUser);
				//根据关键词搜索，查看该用户是否为空
				if(tdUser2!=null) {				
					pd.put("userId", tdUser2.getUserId());	
					page.setPd(pd);	
				}
			}*/
				List<TdMembershipwelfare> listMembershipwelfare = this.sqlService.getAllTdMembershipwelfare(page);
				mv.setViewName("system/memberWelfare/memberWelfare_list");
			    mv.addObject("listMembershipwelfare",listMembershipwelfare);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
			return mv;
		}
}
