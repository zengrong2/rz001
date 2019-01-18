package com.fh.controller.yixunlian;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdSystembulletin;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.SystembulletinService;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
//体验vip的培训富文本
@Controller
@RequestMapping("experienceVipTrain/")
public class ExperienceVipTrainController  extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private SystembulletinService service;
		@Autowired
		private UserManager um;
		@RequestMapping(value="listExpVipTrain")
		public ModelAndView listExpVipTrain(Page page)throws Exception {
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("USERNAME",Jurisdiction.getUsername());
			PageData user=this.um.findByUsername(pd);//通过用户名找出用户
			String keywords = pd.getString("keywords");
			TdSystembulletin tdSystembulletin = new TdSystembulletin();
			tdSystembulletin.setSystemStatus(5);
			TdSystembulletin systembulletin = service.queryOne(tdSystembulletin);
			List<TdSystembulletin> listTdSystembulletin = new ArrayList<>();
			listTdSystembulletin.add(systembulletin);
			mv.setViewName("system/systemManager/systembulletin_soloExpVipTrain");
			mv.addObject("listTdSystembulletin",listTdSystembulletin);
			mv.addObject("QX",Jurisdiction.getHC());//按钮权限
			mv.addObject("pd", pd);
			return mv;
		}
}
