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
import com.fh.controller.lw.util.GetLocation;
import com.fh.entity.Page;
import com.fh.entity.system.User;
import com.fh.lw.pojo.company.Position;
import com.fh.lw.pojo.course.Curriculum;
import com.fh.lw.pojo.obtainemployment.Prejob;
import com.fh.lw.pojo.school.School;
import com.fh.lw.utils.MD5;
import com.fh.service.school.PreJobManager;
import com.fh.service.school.SchoolCurriculumManager;
import com.fh.service.school.SchoolManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
/**
 * 培训学校
 * @author DELL
 *
 */

@Controller
@RequestMapping("train/")
public class SchoolTrainController extends BaseController{
	String menuUrl = "train/goListTrainingAgency.do"; //菜单地址(权限用)
	@Autowired
	private SchoolCurriculumManager scm;
	  @Autowired
	  private SchoolManager sm ;
	  @Autowired
	   	private UserManager um;
	  @Autowired
	  private PreJobManager pjm;
	  @RequestMapping(value="goListTrainingAgency")
		public ModelAndView goListTrainingAgency(Page page)throws Exception {
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			String w_ids = pd.getString("w_id"); 
			if (null != w_ids && !"".equals(w_ids)) {
				Integer w_id=Integer.parseInt(w_ids);
			
				page.setPd(pd);
			}
			String is_checks = pd.getString("is_check"); 
			if (null != is_checks && !"".equals(is_checks)) {
				Integer is_check =Integer.parseInt(is_checks);
				
				page.setPd(pd);
			}
			//培训类型查找s
			String trainType = pd.getString("trainType"); 
			String keywords = pd.getString("keywords"); // 关键词搜索
			if (null != keywords && !"".equals(keywords)) {
				pd.put("keywords", keywords.trim());
				page.setPd(pd);
			}
			if (null != trainType && !"".equals(trainType)) {
				pd.put("trainType", trainType.trim());

				page.setPd(pd);
			}
			   
				page.setPd(pd);
				List<School> listSchoolTrain = this.sm.findListTrain(page);
				List<Prejob> listPreJobs = this.pjm.ListPreJobType();
				mv.setViewName("system/school/school_train_list");
				mv.addObject("listSchoolTrain",listSchoolTrain);
				mv.addObject("pd", pd);
				mv.addObject("listPreJobs",listPreJobs);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
			return mv;
		}
	  
	  /**
	   * deleteSchoolBysid
	   * 
	   */
	  
	  @RequestMapping(value = "/deleteTrainSchoolBysid")
		public void deleteTrainSchoolBysid(PrintWriter out) throws Exception {
			logBefore(logger, Jurisdiction.getUsername() + "删除");
			PageData pd = new PageData();
			pd = this.getPageData();
			pd=this.sm.findSchoolById(pd);
			this.sm.deleteS(pd);
			pd.put("sid", 0);
			this.um.editSchoolId(pd);
			out.write("success");
			out.close();
		}
	  /**
	   * goAddTrainSchool
	   */
	  @RequestMapping(value="/goAddTrainSchool")
		public ModelAndView goAddTrainSchool(Page page)throws Exception{
		  if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			page.setPd(pd);
			pd.put("ROLE_ID", "4a525a16517a46a8831406bef482327e");
			List<User> uList=this.um.listUserByRoldId(pd);
			
			List<Prejob> listPreJobType = this.pjm.findListPreJobType(page);

			mv.setViewName("system/school/school_train_add");
			mv.addObject("uList",uList);
			mv.addObject("msg", "saveS");
			mv.addObject("pd", pd);
			mv.addObject("listPreJobType", listPreJobType);
			return mv;
		}
	  /**
	   * 添加
	   * @return
	   * @throws Exception
	   */
	  @RequestMapping(value="/saveTrainSchoolInfo")
		public ModelAndView saveTrainSchoolInfo() throws Exception{
			if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
			logBefore(logger, Jurisdiction.getUsername()+"新增");
			ModelAndView mv = this.getModelAndView();
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("create_time", time);
			pd.put("update_time", time);
			String lng=pd.getString("lng");
			String lat=pd.getString("lat");
		   String []a=GetLocation.getArea(lng, lat);//通过经纬度获取省市区
		    pd.put("province", a[0]);//设置省
		    pd.put("city", a[1]);//设置市
		    pd.put("school_phone", "028-82687920");
		    pd.put("area", a[2]);//设置区
			this.sm.saveS(pd);
			pd.put("sid", 1);
			this.um.editSchoolId(pd);
			mv.addObject("msg","success");
		    mv.setViewName("save_result");		
			return mv;
		}
	  /**
	   * 修改goEditTrainSchool
	   */
	  @RequestMapping(value="/goEditTrainSchool")
		public ModelAndView goEditTrainSchool() throws Exception{
			if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
//			int company_id=Integer.parseInt(pd.getString("company_id"));
			
		    pd= sm.findSchoolById(pd);	
			mv.setViewName("system/school/school_train_edit");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
			return mv;
		}
	  
	  @RequestMapping(value="/editTrainSchoolByCid")
		public ModelAndView editTrainSchoolByCid() throws Exception{
			logBefore(logger, Jurisdiction.getUsername()+"修改");
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
				pd.put("update_time", time);
				sm.editS(pd);;	//执行修改
				
			mv.addObject("msg","success");
			mv.setViewName("save_result");
			return mv;
		}
	  /**
	   * showlTrainCurriculumDetailByS_id
	   * 在培训学校界面显示课程信息
	   */
	  @RequestMapping(value="showlTrainCurriculumDetailByS_id")
		public ModelAndView showlTrainCurriculumDetailByS_id(){
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
					try{
						pd = this.getPageData();			
						
						List<Curriculum> CurriculumList=scm.findTrainCurriculumDetailByS_id(pd);
						mv.setViewName("system/school/school_curriculumDetail");
						mv.addObject("CurriculumList", CurriculumList);
					} catch(Exception e){
						logger.error(e.toString(), e);
					}
					return mv;
				}
	}

