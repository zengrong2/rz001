package com.fh.controller.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.controller.base.BaseController;
import com.fh.service.yixunlian.NewsService;
import com.fh.service.yixunlian.TransactionItemService;

@Controller
@RequestMapping("tdTransactionItem/")
public class TdTransactionItemController extends BaseController{
	@Autowired
	private TransactionItemService service;
}
