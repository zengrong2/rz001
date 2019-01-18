package com.fh.controller.company;

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
import com.fh.lw.pojo.company.Company;
import com.fh.lw.pojo.company.Position;
import com.fh.lw.pojo.obtainemployment.Labour;
import com.fh.lw.pojo.user.Teacher;
import com.fh.lw.utils.MD5;
import com.fh.service.company.CompanyManager;
import com.fh.service.company.LabourWorkManager;
import com.fh.service.company.WorkManager;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@RequestMapping("company/")
@Controller
public class CompanyController extends BaseController {
	String menuUrl = "company/goListCompany.do"; //菜单地址(权限用)
	  @Autowired
		private WorkManager wm ;
	@Autowired
	private LabourWorkManager lwm ;
    @Autowired
	private CompanyManager cm;
    @Autowired
   	private UserManager um;
    @Resource(name="fhlogService")
	private FHlogManager FHLOG;
	/**
	 * 
	 * 公司列表
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="goListCompany")
	public ModelAndView goListCompany(Page page)throws Exception {
		ModelAndView mv=this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String labour_ids = pd.getString("labour_id");
		if (null != labour_ids && !"".equals(labour_ids)) {
			Integer labour_id=Integer.parseInt(labour_ids);
			page.setPd(pd);			
			
		}
		String is_recruits = pd.getString("is_recruit");
		if (null != is_recruits && !"".equals(is_recruits)) {
			Integer is_recruit=Integer.parseInt(is_recruits);
			
			pd.put("is_recruit", is_recruit);
			page.setPd(pd);			
			
		}else {
			String is_recruit = null;
			pd.put("is_recruit", is_recruit);
			page.setPd(pd);
		}
		
			
		//公司类型查找
				String companyType = pd.getString("companyType"); 
				String keywords = pd.getString("keywords"); // 关键词搜索
				if (null != keywords && !"".equals(keywords)) {
					pd.put("keywords", keywords.trim());
					page.setPd(pd);
				}
				if (null != companyType && !"".equals(companyType)) {
					pd.put("companyType", companyType.trim());
					page.setPd(pd);
				}

			page.setPd(pd);
//			List<Labour> listLabourType = this.lwm.ListLabourWordType(page);
			List<Labour> listLabourType = this.lwm.showListLabourWorkType();

			List<Company> companyList=this.cm.listCompany(page);//通过

            
			
			mv.setViewName("system/company/company_list");
			mv.addObject("companyList",companyList);
			mv.addObject("listLabourType",listLabourType);
			mv.addObject("QX",Jurisdiction.getHC());//按钮权限
			mv.addObject("pd",pd);
		return mv;
	}
    /**
     * 劳动
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/goListLaborEmployment")
	public ModelAndView goListLaborEmployment() throws Exception{
	
//		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限

//		logBefore(logger, Jurisdiction.getUsername() + "确认學生就读");
		ModelAndView mv = this.getModelAndView();

		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/company/LaborEmployment_list");
		return mv;
	}
	/**
	 *优学后台  删除公司id
	 * 
	 */
	
	@RequestMapping(value = "/deleteCompanyByCid")
	public void deleteCompanyByCid(PrintWriter out) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "删除");
		PageData pd = new PageData();
		pd = this.getPageData();
//		pd=this.cm.findSchoolById(pd);
		this.cm.deleteCompanyByCid(pd);
//		pd.put("companyid", 0);
//		this.um.editSchoolId(pd);
		out.write("success");
		out.close();
	}
	/**
	 * 修改公司
	 * goEditCompany
	 */
	@RequestMapping(value="/goEditCompany")
	public ModelAndView goEditCompany() throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
//		int company_id=Integer.parseInt(pd.getString("company_id"));
		
	    pd= cm.getCompanyById(pd);	
		mv.setViewName("system/company/company_edit");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		return mv;
	}
	/**
	 * editCompanyByCid  写俩个mapping
	 */
	@RequestMapping(value="/editCompanyByCid")
	public ModelAndView editCompanyByCid() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			pd.put("update_time", time);
			cm.edit(pd);;	//执行修改
			
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * goAddCompany
	 */
	@RequestMapping(value="/goAddCompany")
	public ModelAndView goAddCompany()throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<Labour> listLabourType = this.lwm.showListLabourWorkType();
		
		mv.setViewName("system/company/company_add");
		mv.addObject("msg", "saveU");
		mv.addObject("pd", pd);
		mv.addObject("listLabourType", listLabourType);
		return mv;
	}

	@RequestMapping(value="saveCompanyInfo")
	public ModelAndView saveCompanyInfo() throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		logBefore(logger, Jurisdiction.getUsername()+"新增");
		ModelAndView mv = this.getModelAndView();
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("created", time);
		pd.put("updated", time);
		String lng=pd.getString("lng");
		String lat=pd.getString("lat");
	   String []a=GetLocation.getArea(lng, lat);//通过经纬度获取省市区
	    pd.put("province", a[0]);//设置省
	    pd.put("city", a[1]);//设置市
	    pd.put("area", a[2]);//设置区
		this.cm.saveCompanyInfo(pd);
		pd.put("sid", 1);
		this.um.editSchoolId(pd);
		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}
	
	/**
	 * 修改公司招聘状态
	 * 默认为0，待上线招聘，1正在招聘中，2招聘完成
	 * updateCompanyRecruitState
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/updateCompanyRecruitState")
	public ModelAndView updateCompanyRecruitState() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		String company_ids = pd.getString("company_id");
		String is_recruits = pd.getString("is_recruit");
		Integer is_recruit=Integer.parseInt(is_recruits);
		pd.put("is_recruit", is_recruit);
		Integer company_id=Integer.parseInt(company_ids);
		pd.put("company_id", company_id);
		if(company_id!=null&&is_recruit==2) {
			pd.put("is_recruit", is_recruit);
			List<PageData> listWord = this.wm.findListPositionByCompanyId(company_id);
		    for(int i=0;i<listWord.size();i++) {
		    
		    	pd.put("p_id", listWord.get(i).getInteger("p_id"));
		    	this.wm.updateWorkState(pd);
		    }
		}
		if(company_id!=null&&is_recruit==0) {
			pd.put("is_recruit", is_recruit);
			List<PageData> listWord = this.wm.findListPositionByCompanyId(company_id);
		    for(int i=0;i<listWord.size();i++) {
		    	
		    	pd.put("p_id", listWord.get(i).getInteger("p_id"));
		    	this.wm.updateWorkState(pd);
		    }
		}
		
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			pd.put("update_time", time);
			cm.editRecruitState(pd);	//执行公司招聘状态修改
			
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	/*
	 * listCompanyAddress
	 * 显示公司详细地址
	 */
	@RequestMapping(value="listCompanyAddress")
	public ModelAndView listCompanyAddress(Page page){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
					pd = this.getPageData();			
					page.setPd(pd);
					PageData bespoke = cm.getCompanyById(pd);
					mv.setViewName("system/company/company_address");
					mv.addObject("pd", bespoke);
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	
	/**
	 * deleteAllCompany
	 * 批量删除
	 */
	@RequestMapping(value="/deleteAllCompany")
	@ResponseBody
	public Object deleteAllCompany() throws Exception {
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		logBefore(logger, Jurisdiction.getUsername()+"批量删除company");
		FHLOG.save(Jurisdiction.getUsername(), "批量删除company");
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String Company_IDS = pd.getString("Company_IDS");
		if(null != Company_IDS && !"".equals(Company_IDS)){
			String ArrayCompany_IDS[] = Company_IDS.split(",");
//			userService.deleteAllU(ArrayPosition_IDS);
			
			cm.deleteAllCompany(ArrayCompany_IDS);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
}
