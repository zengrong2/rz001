package com.fh.controller.school;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.controller.lw.util.GetLocation;
import com.fh.entity.Page;
import com.fh.lw.pojo.company.Company;
import com.fh.lw.pojo.course.Curriculum;
import com.fh.lw.pojo.obtainemployment.Labour;
import com.fh.lw.utils.MD5;
import com.fh.service.school.ChapterManager;
import com.fh.service.school.SchoolCurriculumManager;
import com.fh.service.school.SchoolManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("train/curriculum/")
public class ChapterController extends BaseController{
	String menuUrl = "train/curriculum//listChapter.do"; //菜单地址(权限用)
	@Autowired
	private ChapterManager chapterm;
	 @Autowired
	   	private UserManager um;
	 @Autowired
		private SchoolCurriculumManager scm;
//	 /**
//	  * 章节列表
//	  * @param page
//	  * @return
//	  * @throws Exception
//	  */
//	 @RequestMapping(value="goListCourseChapter")
//		public ModelAndView goListCourseChapter(Page page)throws Exception{
//			ModelAndView mv = this.getModelAndView();
//			PageData pd = new PageData();
//			pd = this.getPageData();
//			pd.put("USERNAME",Jurisdiction.getUsername());
//			PageData user=this.um.findByUsername(pd);//通过用户名找出用户
//			
//			String keywords = pd.getString("keywords"); // 关键词搜索
//			if (null != keywords && !"".equals(keywords)) {
//				pd.put("keywords", keywords.trim());
//				page.setPd(pd);
//			}
//		
//		
//			
//			List<Curriculum> CurriculumList=scm.listSchoolCurriculum(page);
//			
//			mv.setViewName("system/school/school_Curriculum_list");
//			mv.addObject("CurriculumList",CurriculumList);
//			mv.addObject("pd", pd);
//			mv.addObject("school_id", user.getInteger("school_id"));
//			
//			
//			return mv;
//
//			
//		}
//	 
//	 
//	 
	 /**
	  * 删除章节
	  * @param out
	  * @throws Exception
	  */
		@RequestMapping(value = "/deleteChapterByCid")
		public void deleteChapterByCid(PrintWriter out) throws Exception {
			PageData pd = new PageData();
			pd = this.getPageData();
			
			this.chapterm.deleteChapterBycid(pd);
			out.write("success");
			out.close();
		}
	/**
	 * 课程添加界面
	 * goAddCurriculumChapter
	 */
	@RequestMapping(value="/goAddCurriculumChapter")
	public ModelAndView goAddCurriculumChapter()throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
//		if (0 == companyId  ||"".equals(companyId)) {
//			//查询所有的公司
//			List<Company> allCompany = this.cm.listCompany();
//			List<Labour> listLabourType = this.lwm.showListLabourWorkType();
//			mv.addObject("allCompany", allCompany);
//			mv.addObject("listLabourType", listLabourType);
//		}
		PageData curriculum = scm.getSchoolCurriculumById(pd);
		mv.setViewName("system/school/school_curriculumChapter_add");
		mv.addObject("msg", "saveU");
		mv.addObject("pd", pd);
		
		return mv;
	}
	
	/**保存用户
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveChapterInfo")
	public ModelAndView saveChapterInfo() throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		logBefore(logger, Jurisdiction.getUsername()+"新增");
		ModelAndView mv = this.getModelAndView();
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("USERNAME",Jurisdiction.getUsername());
		PageData user=this.um.findByUsername(pd);//通过用户名找出用户
		pd.put("ywyid", user.getString("USER_ID"));
		pd.put("ywyphone", user.getString("PHONE"));
		pd.put("pid", 0);
		pd.put("password",MD5.md5(pd.getString("password")));	//密码加密
		pd.put("create_time", time);
		pd.put("update_time", time);
		pd.put("type", 1);
//		wm.savePosition(pd); 					//执行保存
	
		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}
	@RequestMapping(value="addChapter")
	public ModelAndView addChapter() throws Exception{
		ModelAndView mv = this.getModelAndView();
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("update_time", time);
		
		this.chapterm.addChapter(pd);
		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}
}
