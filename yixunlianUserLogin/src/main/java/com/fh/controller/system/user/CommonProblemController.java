package com.fh.controller.system.user;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.system.user.CommonProblemManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("problem/")
public class CommonProblemController extends BaseController{
	@Autowired
	private CommonProblemManager pm;
	@RequestMapping(value = "listProblem")
	public ModelAndView listGrp(Page page) {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try {
			pd = this.getPageData();
			page.setPd(pd);
			List<PageData> problemList = pm.problemlistPage(page);
			mv.setViewName("system/user/problem_list");
			mv.addObject("problemList", problemList);
			mv.addObject("pd", pd);
			mv.addObject("QX", Jurisdiction.getHC()); // 按钮权限
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return mv;
	}
	/**
	 * 去新增
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/goAdd")
	public ModelAndView goAddP() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/user/problem_add");
		mv.addObject("pd", pd);
		return mv;
	}
	
		@RequestMapping(value = "/saveP")
		public ModelAndView saveP() throws Exception {
		
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			pd.put("updated", time); // 更新时间
			pd.put("created", time);//创建时间
			this.pm.saveP(pd);
			mv.addObject("msg", "success");
			mv.setViewName("save_result");
			return mv;
		}
		
		@RequestMapping(value = "/goEdit")
		public ModelAndView goEdit() throws Exception {
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			pd=this.pm.getProblemById(pd);
			mv.setViewName("system/user/problem_edit");
			mv.addObject("pd", pd);
			return mv;
		}
		
			@RequestMapping(value = "/editP")
			public ModelAndView editP() throws Exception {
				
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
				pd.put("updated", time); // 更新时间
				this.pm.editP(pd);
				mv.addObject("msg", "success");
				mv.setViewName("save_result");
				return mv;
			}
			
			@RequestMapping(value = "/deleteP")
			public void deleteU(PrintWriter out) throws Exception {
		
				PageData pd = new PageData();
				pd = this.getPageData();
				this.pm.deleteP(pd);
				out.write("success");
				out.close();
			}
}
