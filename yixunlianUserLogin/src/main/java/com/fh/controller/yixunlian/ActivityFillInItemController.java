package com.fh.controller.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.controller.base.BaseController;
import com.fh.service.yixunlian.ActivityFillInItemService;
import com.fh.service.yixunlian.ActivitySignService;
/*
 * 活动报名填写可选项目项目
 */
@Controller
@RequestMapping("activityFillInItem/")
public class ActivityFillInItemController extends BaseController{
	//这个注入的是通用mapper使用的service
			@Autowired
			private ActivityFillInItemService service;
}
