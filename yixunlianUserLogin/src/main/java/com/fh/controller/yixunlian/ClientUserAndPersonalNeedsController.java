package com.fh.controller.yixunlian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.lw.pojo.yixunlian.TdUserandhobby;
import com.fh.lw.pojo.yixunlian.TdUserandpersonalneeds;
import com.fh.service.yixunlian.ClientUserAndHobbyService;
import com.fh.service.yixunlian.ClientUserAndPersonalNeedsService;
import com.fh.util.PageData;

@Controller
@RequestMapping("clientUserAndPersonalNeeds/")
public class ClientUserAndPersonalNeedsController extends BaseController{
	//这个注入的是通用mapper使用的service
	@Autowired
	private ClientUserAndPersonalNeedsService service;
	/*
	 * listUserUserAndPersonalNeedsDetail
	 * user_id
	 */
	@RequestMapping(value="listUserUserAndPersonalNeedsDetail")
	public ModelAndView listUserUserAndPersonalNeedsDetail(){
	ModelAndView mv = this.getModelAndView();
	PageData pd = new PageData();
		try{
			pd = this.getPageData();			
			String user_id = pd.getString("user_id");
			List<TdUserandpersonalneeds> listTdUserandpersonalneeds = this.service.getListTdUserandpersonalneeds(user_id);
					
			mv.addObject("pd",pd);
			mv.addObject("listTdUserandpersonalneeds",listTdUserandpersonalneeds);
			mv.setViewName("system/tdUser/tdUser_UserandpersonalneedsDetail");
					
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
}
