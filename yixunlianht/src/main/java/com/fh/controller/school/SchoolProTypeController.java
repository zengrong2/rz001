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
import com.fh.controller.lw.util.GetLocation;
import com.fh.entity.Page;
import com.fh.lw.pojo.educationschool.Category;
import com.fh.lw.pojo.obtainemployment.Labour;
import com.fh.lw.pojo.school.School;
import com.fh.service.school.SchoolMajorManager;
import com.fh.service.school.SchoolManager;
import com.fh.service.school.SchoolProTypeManager;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
/**
 * 升学类型
 * @author DELL
 *
 */
@Controller
@RequestMapping("schoolProType/")
public class SchoolProTypeController extends BaseController{
//	String menuUrl = "school/listSchoolProType.do"; //菜单地址(权限用)
	@Autowired
	private SchoolProTypeManager sptm;
	 @Autowired
	   	private UserManager um;
	@Autowired
	private SchoolManager service;
	@Resource(name="fhlogService")
	private FHlogManager FHLOG;
	@RequestMapping(value="listSchoolProType")
	public ModelAndView listSchoolProType(Page page)throws Exception{
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
		pd.put("school_id", user.get("school_id"));
		

		page.setPd(pd);
		List<Category> schoolProTypeList=sptm.listAllSchoolProType(page);
		mv.setViewName("system/school/school_SchoolProType_list");
		mv.addObject("schoolProTypeList",schoolProTypeList);
		mv.addObject("pd", pd);
		mv.addObject("school_id", user.getInteger("school_id"));
		mv.addObject("QX",Jurisdiction.getHC());//按钮权限		
		return mv;		
	}
	/**
	 * 升学类型修改界面
	 */
	 @RequestMapping(value="/goEditSchoolPreType")
		public ModelAndView goEditSchoolPreType() throws Exception{
//			if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
//			int company_id=Integer.parseInt(pd.getString("company_id"));
			
		    pd= sptm.getSchoolProTypeById(pd);	
			mv.setViewName("system/school/school_SchoolProType_edit");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
			return mv;
		}
	 /**
		 *  执行修改
		 */
		@RequestMapping(value="/editSchoolProTypeByCid")
		public ModelAndView editSchoolProTypeByCid() throws Exception{
			
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
				pd.put("update_time", time);
				sptm.editSchoolProType(pd);;	//执行修改
				
			mv.addObject("msg","success");
			mv.setViewName("save_result");
			return mv;
		}
		/**
		 * delSchoolPreTypeById删除
		 */
		@RequestMapping(value = "/delSchoolPreTypeById")
		public void delSchoolPreTypeById(PrintWriter out) throws Exception {
			logBefore(logger, Jurisdiction.getUsername() + "删除");
			PageData pd = new PageData();
			pd = this.getPageData();
//			pd=this.cm.findSchoolById(pd);
			this.sptm.deleteSchoolProTypeByCid(pd);
//			pd.put("companyid", 0);
//			this.um.editSchoolId(pd);
			out.write("success");
			out.close();
		}
		/**
		 * 添加
		 * goAddSchoolPreType
		 */
		@RequestMapping(value="/goAddSchoolPreType")
		public ModelAndView goAddSchoolPreType(Page page)throws Exception{
//			if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			List<School> listSchoolForProType = service.listAllSchool(page);
			mv.setViewName("system/school/school_SchoolProType_add");
			mv.addObject("msg", "saveU");
			mv.addObject("pd", pd);
			mv.addObject("listSchoolForProType", listSchoolForProType);
			return mv;
		}

		@RequestMapping(value="saveSchoolProTypeInfo")
		public ModelAndView saveSchoolProTypeInfo() throws Exception{
//			if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
			logBefore(logger, Jurisdiction.getUsername()+"新增");
			ModelAndView mv = this.getModelAndView();
			Date date=new Date();
			
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("created", time);
			pd.put("updated", time);
			
			this.sptm.saveSchoolProTypeInfo(pd);
			
			mv.addObject("msg","success");
		    mv.setViewName("save_result");		
			return mv;
		}
		/**
		 * 批量删除
		 * deleteAllSchoolProType
		 */
		@RequestMapping(value="/deleteAllSchoolProType")
		@ResponseBody
		public Object deleteAllSchoolProType() throws Exception {
//			if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
			logBefore(logger, Jurisdiction.getUsername()+"批量删除schoolProType");
			FHLOG.save(Jurisdiction.getUsername(), "批量删除schoolProType");
			PageData pd = new PageData();
			Map<String,Object> map = new HashMap<String,Object>();
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();
			String SchoolProType_IDS = pd.getString("SchoolProType_IDS");
			if(null != SchoolProType_IDS && !"".equals(SchoolProType_IDS)){
				String ArraySchoolProType_IDS[] = SchoolProType_IDS.split(",");
//				userService.deleteAllU(ArrayPosition_IDS);
				
				sptm.deleteAllSchoolProType(ArraySchoolProType_IDS);
				pd.put("msg", "ok");
			}else{
				pd.put("msg", "no");
			}
			
			pdList.add(pd);
			map.put("list", pdList);
			return AppUtil.returnObject(pd, map);
		}
		/**
		 * 升学学校列表显示升学类别
		 * goFindProSchoolType
		 */
		@RequestMapping(value="goFindProSchoolType")
		public ModelAndView goFindProSchoolType(){
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
					try{
						pd = this.getPageData();			
					
						List<Category> listCategory = this.sptm.findAllSchoolProType(pd);
						mv.setViewName("system/school/school_SchoolProTypeDetail");
						mv.addObject("schoolProTypeList",listCategory);
						mv.addObject("pd", pd);
					} catch(Exception e){
						logger.error(e.toString(), e);
					}
					return mv;
				}
}
