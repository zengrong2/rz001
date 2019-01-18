package com.fh.controller.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.controller.base.BaseController;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.TransactionItemService;

//报名后，活动结束后，设置活动提成
@Controller
@RequestMapping("transactionItem/")
public class TransactionItemController extends BaseController{
	@Autowired
	private TransactionItemService service;
}
