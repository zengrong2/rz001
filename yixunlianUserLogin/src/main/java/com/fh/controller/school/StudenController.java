package com.fh.controller.school;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.student.StudentRecharge;
import com.fh.service.student.StudentManager;
import com.fh.service.student.StudentRechargeManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("student/")
public class StudenController extends BaseController{
	@Autowired
	private StudentRechargeManager  srm;
	@Autowired
	private StudentManager  sm;
	
	/**
	 * 跳转到学生充值界面
	 */
	@RequestMapping(value="listStudentRecharge")
	public ModelAndView listStudentRecharge()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<StudentRecharge> srList=this.srm.studentRechargeBySId(pd);
	   
		mv.setViewName("system/student/student_recharge_list");
		mv.addObject("srList",srList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	/**
	 * 显示学生注册信息
	 */
	@RequestMapping(value="showUserInfo")
	public ModelAndView showUserInfo(Page page){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
					pd = this.getPageData();			
					page.setPd(pd);
					PageData bespoke = sm.findStudentById(pd) ;
					mv.setViewName("system/student/studentInfo_detail");
					mv.addObject("pd", bespoke);
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	
}
