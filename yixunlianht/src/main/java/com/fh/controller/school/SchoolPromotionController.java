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
import com.fh.lw.pojo.school.School;
import com.fh.lw.utils.MD5;
import com.fh.service.school.SchoolMajorManager;
import com.fh.service.school.SchoolManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

/**
 * 学历提升
 * @author DELL
 *
 */
@Controller
@RequestMapping("school/")
public class SchoolPromotionController extends BaseController{
	String menuUrl = "school/listSchoolPromotion.do"; //菜单地址(权限用)

	@Autowired
	private SchoolManager sm;
	@Autowired
	private UserManager um;
	@RequestMapping(value="listSchoolPromotion")
	public ModelAndView listSchoolPromotion(Page page)throws Exception{
		
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("promotion", "学历提升");
		//学校类型查找
		String schoolType = pd.getString("schoolType"); 
		String keywords = pd.getString("keywords"); // 关键词搜索
		if (null != keywords && !"".equals(keywords)) {
			pd.put("keywords", keywords.trim());
			page.setPd(pd);
		}
		if (null != schoolType && !"".equals(schoolType)) {
			pd.put("schoolType", schoolType.trim());
			page.setPd(pd);
		}
		String is_checks = pd.getString("is_check"); 
		if (null != is_checks && !"".equals(is_checks)) {
			Integer is_check =Integer.parseInt(is_checks);
			
			page.setPd(pd);
		}
		page.setPd(pd);
		List<School> promotionSchoolList=this.sm.listPromotionSchool(page);
		mv.setViewName("system/school/school_promotion_list");
		mv.addObject("promotionSchoolList",promotionSchoolList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());//按钮权限
		
		return mv;

		
	}
	/**
	 * 删除学历提升学校
	 * deleteSchoolProById
	 */
	
	@RequestMapping(value = "/deleteSchoolProById")
	public void deleteSchoolProById(PrintWriter out) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "删除");
		PageData pd = new PageData();
		pd = this.getPageData();
//		pd=this.cm.findSchoolById(pd);
		this.sm.deleteS(pd);
//		this.sm.deleteSchoolProById(pd);
//		pd.put("companyid", 0);
//		this.um.editSchoolId(pd);
		out.write("success");
		out.close();
	}
	/**修改界面
	 * goEditSchoolPro
	 */
	@RequestMapping(value="/goEditSchoolPro")
	public ModelAndView goEditSchoolPro() throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
//		int company_id=Integer.parseInt(pd.getString("company_id"));
		pd =sm.findSchoolById(pd);
//	    pd= sm.getSchoolProById(pd);	
		mv.setViewName("system/school/school_Promotion_edit");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		return mv;
	}
	/**
	 * 执行修改
	 */
	@RequestMapping(value="/editSchoolProById")
	public ModelAndView editSchoolProById() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			pd.put("update_time", time);
			sm.editS(pd);
//			sm.editSchoolPro(pd);;	//执行修改
			
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	/**添加界面
	 * goAddSchoolPro
	 */
	@RequestMapping(value="/goAddSchoolPro")
	public ModelAndView goAddSchoolPro()throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/school/school_add");
		mv.addObject("msg", "saveU");
		mv.addObject("pd", pd);
		mv.addObject("schoolPro","schoolPro");
		return mv;
	}
	/**
	 * 执行保存
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/saveSchoolProInfo")
	public ModelAndView saveSchoolProInfo() throws Exception{
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
		pd.put("created", time);
		pd.put("updated", time);
		pd.put("type", 1);
		sm.saveS(pd);
//		sm.saveSchoolProInfo(pd);
		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}
}
