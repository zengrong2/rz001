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
import com.fh.entity.Page;
import com.fh.lw.pojo.Address;
import com.fh.lw.pojo.company.Company;
import com.fh.lw.pojo.company.Position;

import com.fh.lw.pojo.obtainemployment.Labour;
import com.fh.lw.utils.MD5;
import com.fh.service.company.CompanyManager;
import com.fh.service.company.LabourWorkManager;
import com.fh.service.company.WorkManager;
import com.fh.service.company.WorkService;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@RequestMapping("work/")
@Controller
public class WorkController extends BaseController{
	String menuUrl = "work/goListWork.do"; //菜单地址(权限用)
	
    @Autowired
	private WorkManager wm ;
    @Autowired
   	private UserManager um;
    @Autowired
	private CompanyManager cm;
    @Autowired
	private LabourWorkManager lwm ;
    @Resource(name="fhlogService")
	private FHlogManager FHLOG;
	@RequestMapping(value="goListWork")
	public ModelAndView goListWork(Page page)throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		//职位招聘状态
		 String is_states = pd.getString("is_state");
		 if (null != is_states && !"".equals(is_states)) {
				Integer is_state=Integer.parseInt(is_states);
					pd.put("is_state", is_state);
					page.setPd(pd);
			}
		//工作类型类型查找
		String workType = pd.getString("labour_id"); 
		if (null != workType && !"".equals(workType)) {
			Integer labour_id=Integer.parseInt(workType);
				pd.put("labour_id", labour_id);
				page.setPd(pd);
		}
		String company_name = pd.getString("company_name"); 
		if(null != company_name && !"".equals(company_name)) {
			PageData company = cm.findCompanyByName(company_name);
			if(company!=null) {
				
				List<Position> listWord = wm.findPositionByCompanyId(company.getInteger("company_id"));
				mv.addObject("listWord",listWord);
			}
			mv.setViewName("system/company/work_list");
			mv.addObject("QX",Jurisdiction.getHC());//按钮权限
		}else {							
		String keywords = pd.getString("keywords"); // 关键词搜索
		if (null != keywords && !"".equals(keywords)) {
			pd.put("keywords", keywords.trim());
			page.setPd(pd);
		}
		
			page.setPd(pd);
			List<Labour> listLabourType = this.lwm.showListLabourWorkType();
			List<Position> listWord = this.wm.findListWord(page);
		
			mv.setViewName("system/company/work_list");
			mv.addObject("listWord",listWord);
			mv.addObject("pd",pd);
			mv.addObject("listLabourType",listLabourType);
			mv.addObject("QX",Jurisdiction.getHC());//按钮权限
		}
		return mv;
	}
	@RequestMapping(value = "/deletePositionByPid")
	public void deletePositionByPid(PrintWriter out) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "删除");
		PageData pd = new PageData();
		pd = this.getPageData();
		pd=this.wm.findPositionByPidd(pd);
		this.wm.deletePosition(pd);
		out.write("success");
		out.close();
	}
	/*
	 * 修改职位信息
	 */
	@RequestMapping(value="/goEditPostion")
	public ModelAndView goEditPostion() throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = wm.findPositionByPidd(pd);	
		mv.setViewName("system/company/work_edit");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		return mv;
	}
	@RequestMapping(value="/editPositionBypid")
	public ModelAndView editPositionBypid() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			pd.put("update_time", time);
			wm.edit(pd);;	//执行修改
			
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	/**
	 * goAddPosition
	 * 保存
	 */
	@RequestMapping(value="/goAddPosition")
	public ModelAndView goAddPosition(Page page)throws Exception{
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
	
		
//		int companyId = pd.getInteger("company_id");
//		if (0 == companyId  ||"".equals(companyId)) {
			//查询所有的公司
		
			List<Company> allCompany = this.cm.getAllCompany();
			List<Labour> listLabourType = this.lwm.showListLabourWorkType();
			mv.addObject("allCompany", allCompany);
			mv.addObject("listLabourType", listLabourType);
//		}

		mv.setViewName("system/company/work_add");
		mv.addObject("msg", "saveU");
		mv.addObject("pd", pd);
//		mv.addObject("company_id", companyId);
		

		return mv;
	}
	
	/**保存职位
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/savePositionInfo")
	public ModelAndView savePositionInfo() throws Exception{
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
//		pd.put("password",MD5.md5(pd.getString("password")));	//密码加密
		pd.put("create_time", time);
		pd.put("update_time", time);
		pd.put("type", 1);
		
		PageData company  = this.cm.getCompanyById(pd);
		//判断当前公司状态，根据公司当前状态对职位状态进行区别
		if(company!=null) {			
			if(company.getInteger("is_recruit")==1) {
				pd.put("is_state", 0);
			}else {
				pd.put("is_state", 1);
			}
		}
		wm.savePosition(pd); 					//执行保存
		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}
	/**
	 * 显示职位详情
	 * showPositionInfo
	 */
	@RequestMapping(value="showPositionInfo")
	public ModelAndView showPositionInfo(Page page){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
					pd = this.getPageData();			
					page.setPd(pd);
					PageData bespoke = wm.findPositionByPidd(pd);
					mv.setViewName("system/company/workInfo_detail");
					mv.addObject("pd", bespoke);
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	/**
	 * 显示公司详情
	 * listCompanyInfo
	 */
	@RequestMapping(value="listCompanyInfo")
	public ModelAndView listCompanyInfo(Page page){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
					pd = this.getPageData();			
					page.setPd(pd);
					PageData bespoke = cm.getCompanyById(pd);
					mv.setViewName("system/company/company_detail");
					mv.addObject("pd", bespoke);
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	/*
	 * 显示公司已经发布的职位
	 * listPositionInfo
	 */
	@RequestMapping(value="listPositionInfo")
	public ModelAndView listPositionInfo(Page page){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
					pd = this.getPageData();			
					
					List<Position> listWork = wm.getFindListWork(pd);
					mv.setViewName("system/company/company_publishPosition_detail");
					mv.addObject("listWork", listWork);
					mv.addObject("pd", pd);
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	
	/**
	 * 批量删除
	 * deleteAllPosition
	 */
	
	@RequestMapping(value="/deleteAllPosition")
	@ResponseBody
	public Object deleteAllPosition() throws Exception {
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		logBefore(logger, Jurisdiction.getUsername()+"批量删除position");
		FHLOG.save(Jurisdiction.getUsername(), "批量删除position");
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String Position_IDS = pd.getString("Position_IDS");
		if(null != Position_IDS && !"".equals(Position_IDS)){
			String ArrayPosition_IDS[] = Position_IDS.split(",");
//			userService.deleteAllU(ArrayPosition_IDS);
			
			wm.deleteAllPosition(ArrayPosition_IDS);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
	/**
	 * 改变职位状态
	 */
	@RequestMapping(value="/updatePositionState")
	public ModelAndView updatePositionState() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String company_ids = pd.getString("company_id");
		Integer company_id = Integer.parseInt(company_ids); 
		PageData companys =cm.findCompanyById(company_id);
		Integer is_recruit = companys.getInteger("is_recruit");
		if(is_recruit==1) {
			
			PageData company = cm.findCompanyById(company_id);
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			pd.put("updated", time);
			wm.editPositionState(pd);	//执行职位招聘状态修改
			
			mv.addObject("msg","success");
		}
		mv.addObject("msg","error");
		mv.setViewName("save_result");
		return mv;
	}
}
