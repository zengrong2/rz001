package com.fh.controller.yixunlian;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.controller.base.BaseController;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.SysuserAndFeedbackadviceService;
import com.fh.service.yixunlian.SysuserAndFeedbackadviceSqlManager;

@Controller
@RequestMapping("sysuserAndFeedbackadvice/")
public class TdSysuserAndFeedbackadviceController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private SysuserAndFeedbackadviceService service;
		//这是注入的是写sql语句的service
		@Autowired
		private SysuserAndFeedbackadviceSqlManager sqlService;
		@Autowired
		private UserManager um;
		 @Resource(name="fhlogService")
		 private FHlogManager FHLOG;
		 @Autowired
		 private ClientUserService clientUserservice;
}
