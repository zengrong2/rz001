package com.fh.controller.system.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.lw.pojo.finance.LunBo;
import com.fh.service.system.user.LuBoManager;
import com.fh.util.PageData;

@Controller
@RequestMapping("lubo/")
public class LunBoController extends BaseController{
	@Autowired
	private LuBoManager lbm;

	@RequestMapping(value="toEdit")
	public ModelAndView toEdit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			pd = lbm.listLunBo(pd);//查出轮播图
			mv.addObject("pd", pd);				//放入视图容器
			mv.setViewName("system/user/lunbotu");
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
		try{
			PageData pd = new PageData();
			pd = this.getPageData();
			LunBo lunbo=new LunBo();
			lunbo.setLbt_id(Integer.parseInt(pd.getString("lbt_id")));
			lunbo.setLbtUrl(pd.getString("lbt_url"));
			lbm.ediL(lunbo);
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		mv.setViewName("redirect:/lubo/toEdit.do"); //保存成功跳转到列表页面
		return mv;
	}

}
