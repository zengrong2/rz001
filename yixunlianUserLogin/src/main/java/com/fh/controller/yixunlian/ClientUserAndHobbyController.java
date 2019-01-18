package com.fh.controller.yixunlian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdEverjoin;
import com.fh.lw.pojo.yixunlian.TdUserandhobby;
import com.fh.service.yixunlian.ClientUserAndHobbyService;
import com.fh.service.yixunlian.HobbyService;
import com.fh.util.PageData;

@Controller
@RequestMapping("clientUserAndHobbyController/")
public class ClientUserAndHobbyController extends BaseController{
	//这个注入的是通用mapper使用的service
			@Autowired
			private ClientUserAndHobbyService service;
			/*
			 * listUserAndHobbyDetail
			 * user_id
			 */
			@RequestMapping(value="listUserAndHobbyDetail")
			public ModelAndView listUserAndHobbyDetail(){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
					pd = this.getPageData();			
					String user_id = pd.getString("user_id");
					List<TdUserandhobby> listTdUserandhobby = this.service.getListTdUserandhobby(user_id);
							
					mv.addObject("pd",pd);
					mv.addObject("listTdUserandhobby",listTdUserandhobby);
					mv.setViewName("system/tdUser/tdUser_UserandHobbyDetail");
							
						} catch(Exception e){
							logger.error(e.toString(), e);
						}
						return mv;
					}
}
