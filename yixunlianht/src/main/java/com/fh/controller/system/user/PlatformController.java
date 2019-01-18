package com.fh.controller.system.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.lw.pojo.finance.LunBo;
import com.fh.lw.pojo.school.Platform;
import com.fh.service.school.PlatformManager;
import com.fh.service.system.user.LuBoManager;
import com.fh.util.PageData;

@Controller
@RequestMapping("platform/")
public class PlatformController extends BaseController{
	@Autowired
	private PlatformManager pfm;

	@RequestMapping(value="toEdit")
	public ModelAndView toEdit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			pd = pfm.listPlatform(pd);
			mv.addObject("pd", pd);				//放入视图容器
			mv.setViewName("system/user/platform");
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * 保存编辑
	 * @param 
	 * @return
	 */
	@RequestMapping(value="edit")
	public ModelAndView edit()throws Exception{
		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			pfm.editP(pd);
		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}

}
