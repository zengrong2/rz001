package com.fh.controller.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.controller.base.BaseController;
import com.fh.service.yixunlian.PersonalneedsService;
import com.fh.service.yixunlian.TdAddressService;

@Controller
@RequestMapping("tdPersonalneeds/")
public class TdPersonalneedsController extends BaseController{
	//这个注入的是通用mapper使用的service
	@Autowired
    private PersonalneedsService service;
}
