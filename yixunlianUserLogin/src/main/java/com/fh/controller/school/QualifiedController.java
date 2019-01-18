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
import com.fh.lw.pojo.school.Qualified;
import com.fh.service.school.QualifiedManager;
import com.fh.service.school.SchoolManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("qualified/")
public class QualifiedController extends BaseController{
	String menuUrl = "qualified.do"; //菜单地址(权限用)
	@Autowired
	private QualifiedManager service;
	@Autowired
	private UserManager um;
	@Autowired
	private SchoolManager sservice;
	
	@RequestMapping(value="listQualified")
	public ModelAndView listSchoolMajor(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("USERNAME",Jurisdiction.getUsername());
		PageData user=this.um.findByUsername(pd);//通过用户名找出用户
		String user_id=user.getString("USER_ID");
		pd.put("user_id", user_id);
		PageData school=this.sservice.findSchoolByUid(pd);//通过登录人的用户id找到学校
        if(school!=null) {       	
        	page.setPd(school);
        	List<Qualified> smList=this.service.listAllQualified(page);
        	mv.addObject("qList",smList);
        }
		
		
		mv.setViewName("system/school/qualified_list");
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	
	/**
	 * 去新增页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="goAddQ")
	public ModelAndView goAddU()throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/school/qualified_add");
		mv.addObject("msg", "saveSm");
		mv.addObject("pd", pd);
		return mv;
	}
	
	/**保存
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="saveQ")
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
		pd.put("school_name", school.get("name"));//设置学校名称
		pd.put("school_id", school.get("school_id"));
		pd.put("is_check", 0);
		this.sservice.editState(pd);//更新审核状态
		this.service.saveQ(pd);
		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}
	
	@RequestMapping(value = "/deleteQ")
	public void deleteU(PrintWriter out) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "删除");
		PageData pd = new PageData();
		pd = this.getPageData();
		pd=this.service.findQualifiedById(pd);
		this.service.deleteQ(pd);
		
		out.write("success");
		out.close();
	}
}
