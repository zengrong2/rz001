package com.fh.controller.yixunlian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.lw.pojo.yixunlian.TdActivityChargeItem;
import com.fh.lw.pojo.yixunlian.TdActivityFillInItem;
import com.fh.lw.pojo.yixunlian.TdActivitySignOtherFields;
import com.fh.lw.pojo.yixunlian.TdActivityprojectandacsign;
import com.fh.lw.pojo.yixunlian.TdActivitysign;
import com.fh.lw.pojo.yixunlian.TdUenrollandactivity;
import com.fh.service.yixunlian.ActivityFillInItemService;
import com.fh.service.yixunlian.ActivityProjectAndEnrollService;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySignService;
import com.fh.service.yixunlian.ActivitySignSqlManager;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.util.PageData;

@Controller
@RequestMapping("activitySign/")
public class ActivitySignController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private ActivitySignService service;
		//这是注入的是写sql语句的service
		@Autowired
		private ActivitySignSqlManager sqlService;
		@Autowired
		private ActivityProjectAndEnrollService ActivityProjectAndEnrollservice;
		
		@Autowired
		private ActivityFillInItemService activityFillInItemService;
		
}
