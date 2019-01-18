package com.fh.controller.school;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.student.OpinionManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@RequestMapping("opinion/")
@Controller
public class OpinionController extends BaseController{
	String menuUrl = "opinion.do"; //菜单地址(权限用)
	@Autowired
	private OpinionManager service;
	
	@RequestMapping(value="listOpinion")
	public ModelAndView listComment(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<PageData> oList=this.service.listAllOpinion(page);
		mv.setViewName("system/student/opinion_list");
		mv.addObject("oList",oList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	
	

}
