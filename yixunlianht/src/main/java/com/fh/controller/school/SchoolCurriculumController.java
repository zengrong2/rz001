package com.fh.controller.school;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.course.Chapter;
import com.fh.lw.pojo.course.Curriculum;
import com.fh.lw.pojo.school.School;
import com.fh.lw.pojo.school.SchoolMajor;
import com.fh.lw.utils.MD5;
import com.fh.service.school.ChapterManager;
import com.fh.service.school.SchoolCurriculumManager;
import com.fh.service.school.SchoolMajorManager;
import com.fh.service.school.SchoolManager;
import com.fh.service.school.SchoolTeacherManager;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
@Controller
@RequestMapping("train/")
public class SchoolCurriculumController extends BaseController{

	@Autowired
	private SchoolCurriculumManager scm;
	 @Autowired
	   	private UserManager um;
	 @Autowired
	   	private ChapterManager chapterm;
		@Autowired
		private SchoolMajorManager smservice;
		@Autowired
		private SchoolManager sservice;
		 @Resource(name="fhlogService")
			private FHlogManager FHLOG;
	@RequestMapping(value="goListTrainingCourse")
	public ModelAndView goListTrainingCourse(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("USERNAME",Jurisdiction.getUsername());
		PageData user=this.um.findByUsername(pd);//通过用户名找出用户
		
		String keywords = pd.getString("keywords"); // 关键词搜索
		if (null != keywords && !"".equals(keywords)) {
			pd.put("keywords", keywords.trim());
			page.setPd(pd);
		}
	
		pd.put("school_id", user.getInteger("school_id"));
		page.setPd(pd);
		String major_names = pd.getString("major_name"); // 学科关键词搜索
		if (null != major_names && !"".equals(major_names)) {
			pd.put("major_name", major_names);
		    List<PageData> schoolMajor = this.smservice.findSchooMajorByName(pd);
			if(schoolMajor.size()>0) {
				List<Long>  MajorId_IDS = new ArrayList<>();
				for(int i=0;i<schoolMajor.size();i++) {		
					MajorId_IDS.add(schoolMajor.get(i).getLong("major_id")) ;
				}
			
		pd.put("major_ids", MajorId_IDS);
		List<Curriculum> CurriculumList=scm.listSchoolCurriculumByName(pd);
		mv.setViewName("system/school/school_Curriculum_list");
		mv.addObject("CurriculumList",CurriculumList);
		mv.addObject("pd", pd);
		mv.addObject("school_id", user.getInteger("school_id"));
		
		
		return mv;
			}
		}
		
		List<Curriculum> CurriculumList=scm.listSchoolCurriculum(page);
		
		mv.setViewName("system/school/school_Curriculum_list");
		mv.addObject("CurriculumList",CurriculumList);
		mv.addObject("pd", pd);
		mv.addObject("school_id", user.getInteger("school_id"));
		
		
		return mv;

		
	}
	/**
	 * delSchoolCurriculumByCid
	 * 删除课程
	 */
	@RequestMapping(value = "/delSchoolCurriculumByCid")
	public void delSchoolCurriculumByCid(PrintWriter out) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "删除");
		PageData pd = new PageData();
		pd = this.getPageData();
//		pd=this.cm.findSchoolById(pd);
		this.scm.deleteSchoolCurriculumByCid(pd);
//		pd.put("companyid", 0);
//		this.um.editSchoolId(pd);
		out.write("success");
		out.close();
	}
	
	/**
	 * 添加课程界面
	 * goAddSchoolCurriculum
	 */
	@RequestMapping(value="/goAddSchoolCurriculum")
	public ModelAndView goAddSchoolCurriculum()throws Exception{
	
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<SchoolMajor> listMajor = smservice.getlistAllSchoolMajor(pd);
		mv.addObject("listMajor", listMajor);
		mv.setViewName("system/school/school_Curriculum_add");
		mv.addObject("msg", "saveU");
		mv.addObject("pd", pd);
		return mv;
	}
	/**
	 * 执行添加数据
	 */
	@RequestMapping(value="/saveSchoolCurriculumInfo")
	public ModelAndView saveSchoolCurriculumInfo() throws Exception{
	
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
		pd.put("created", time);
		pd.put("updated", time);
		pd.put("type", 1);
		scm.saveSchoolCurriculumInfo(pd);
		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}
	/**
	 * 修改界面
	 * goEditSchoolCurriculum
	 */
	@RequestMapping(value="/goEditSchoolCurriculum")
	public ModelAndView goEditSchoolCurriculum() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
//		int company_id=Integer.parseInt(pd.getString("company_id"));
		
	    pd= scm.getSchoolCurriculumById(pd);	
	    List<SchoolMajor> listMajor = smservice.getlistAllSchoolMajor(pd);
	    pd.put("USERNAME",Jurisdiction.getUsername());
	    PageData user=this.um.findByUsername(pd);//通过用户名找出用户
	    pd.put("school_id", user.getInteger("school_id"));
	    PageData SchoolMajor = smservice.findSchoolMajorById(pd);
	    if(SchoolMajor!=null) {
	    	
	    mv.addObject("major_name", SchoolMajor.getString("major_name"));
	    }
	    mv.addObject("listMajor", listMajor);
		mv.setViewName("system/school/school_Curriculum_edit");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		return mv;
	}
	/**
	 * 执行修改
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/editSchoolCurriculum")
	public ModelAndView editSchoolCurriculum() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			pd.put("update_time", time);
			scm.editSchoolCurriculum(pd);;	//执行修改
			
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	/**
	 * 显示该课程章节目录信息详情
	 * showCurriculumChapterInfo
	 */
	
			@RequestMapping(value="showCurriculumChapterInfo")
			public ModelAndView showCurriculumChapterInfo(Page page){
					ModelAndView mv = this.getModelAndView();
					PageData pd = new PageData();
						try{
							pd = this.getPageData();			
							page.setPd(pd);
							List<Chapter> listChapter=chapterm.findListChapterByCurriculumId(pd);
							
							mv.setViewName("system/school/school_curriculum_chapterDetail");
							mv.addObject("listChapter", listChapter);
							mv.addObject("pd", pd);


						} catch(Exception e){
							logger.error(e.toString(), e);
						}
						return mv;
					}
			/**
			 * 显示课程学科信息
			 * showCurriculumMajorInfo
			 */

			@RequestMapping(value="showCurriculumMajorInfo")
			public ModelAndView showCurriculumMajorInfo(Page page){
					ModelAndView mv = this.getModelAndView();
					PageData pd = new PageData();
						try{
							pd = this.getPageData();			
							page.setPd(pd);
							PageData listChapter=smservice.findSchoolMajorById(pd) ;
							
							mv.setViewName("system/school/school_curriculum_majorDetail");
							mv.addObject("pd", listChapter);
							

						} catch(Exception e){
							logger.error(e.toString(), e);
						}
						return mv;
					}
			/**
			 * 显示课程学校信息
			 * @param page
			 * @return
			 */
			@RequestMapping(value="showCurriculumSchoolInfo")
			public ModelAndView showCurriculumSchoolInfo(Page page){
					ModelAndView mv = this.getModelAndView();
					PageData pd = new PageData();
						try{
							pd = this.getPageData();			
							page.setPd(pd);
							PageData listChapter=sservice.findSchoolById(pd);
							
							mv.setViewName("system/school/school_curriculum_schoolDetail");
							mv.addObject("pd", listChapter);
							

						} catch(Exception e){
							logger.error(e.toString(), e);
						}
						return mv;
					}
			/**
			 * deleteAllCurriculum
			 * 批量删除
			 */
			@RequestMapping(value="/deleteAllCurriculum")
			@ResponseBody
			public Object deleteAllCurriculum() throws Exception {
				logBefore(logger, Jurisdiction.getUsername()+"批量删除Curriculum");
				FHLOG.save(Jurisdiction.getUsername(), "批量删除Curriculum");
				PageData pd = new PageData();
				Map<String,Object> map = new HashMap<String,Object>();
				pd = this.getPageData();
				List<PageData> pdList = new ArrayList<PageData>();
				String Curriculum_IDS = pd.getString("Curriculum_IDS");
				if(null != Curriculum_IDS && !"".equals(Curriculum_IDS)){
					String ArrayCurriculum_IDS[] = Curriculum_IDS.split(",");
//					userService.deleteAllU(ArrayPosition_IDS);
					
					scm.deleteAllCurriculum(ArrayCurriculum_IDS);
					pd.put("msg", "ok");
				}else{
					pd.put("msg", "no");
				}
				
				pdList.add(pd);
				map.put("list", pdList);
				return AppUtil.returnObject(pd, map);
			}
}
