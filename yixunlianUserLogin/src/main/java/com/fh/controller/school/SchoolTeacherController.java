package com.fh.controller.school;

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
import com.fh.lw.pojo.school.SchoolTeacher;
import com.fh.service.school.SchoolManager;
import com.fh.service.school.SchoolTeacherManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("school/teacher")
public class SchoolTeacherController extends BaseController{
	String menuUrl = "school/teacher.do"; //菜单地址(权限用)
	@Autowired
	private SchoolTeacherManager service;
	@Autowired
	private UserManager um;
	@Autowired
	private SchoolManager sservice;
	
	@RequestMapping(value="listSchoolTeacher")
	public ModelAndView listSchoolMajor(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("USERNAME",Jurisdiction.getUsername());
		PageData user=this.um.findByUsername(pd);//通过用户名找出用户
		String user_id=user.getString("USER_ID");
		pd.put("user_id", user_id);
		PageData school=this.sservice.findSchoolByUid(pd);//通过登录人的用户id找到学校
		page.setPd(school);
		List<SchoolTeacher> stList=this.service.listAllSchoolTeacher(page);
		mv.setViewName("system/school/school_teacher_list");
		mv.addObject("qList",stList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	
	/**
	 * 去新增页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="goAddSt")
	public ModelAndView goAddU()throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/school/school_teacher_add");
		mv.addObject("msg", "saveSt");
		mv.addObject("pd", pd);
		return mv;
	}
	/**保存
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="saveSt")
	public ModelAndView saveS( ) throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		logBefore(logger, Jurisdiction.getUsername()+"新增");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		pd.put("create_time", time);
		pd.put("update_time", time);
		pd.put("USERNAME",Jurisdiction.getUsername());
		PageData user=this.um.findByUsername(pd);//通过用户名找出用户
		String user_id=user.getString("USER_ID");
		pd.put("user_id", user_id);
		PageData school=this.sservice.findSchoolByUid(pd);//通过登录人的用户id找到学校
		pd.put("school_id", school.get("school_id"));
		pd.put("is_check", 0);
		this.sservice.editState(pd);//更新审核状态
		this.service.saveSt(pd);
		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}
	@RequestMapping(value = "/deleteSt")
	public void deleteU(PrintWriter out) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "删除");
		PageData pd = new PageData();
		pd = this.getPageData();
		pd=this.service.findSchoolTeacherById(pd);
		this.service.deleteSt(pd);
		out.write("success");
		out.close();
	}
}
