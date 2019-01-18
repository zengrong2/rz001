package com.fh.controller.yixunlian;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdTaxrevenue;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.TaxRevenueService;
import com.fh.service.yixunlian.TaxRevenueSqlManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
@Controller
@RequestMapping("taxrevenue/")
public class TaxRevenueController extends BaseController{
	//这个注入的是通用mapper使用的service
	@Autowired
	private TaxRevenueService service;
	//这是注入的是写sql语句的service
	@Autowired
	private TaxRevenueSqlManager sqlService;
	@Autowired
	private UserManager um;
	 @Resource(name="fhlogService")
		private FHlogManager FHLOG;
	@RequestMapping(value="goListTaxrevenue")
	public ModelAndView goListTaxrevenue(Page page)throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("USERNAME",Jurisdiction.getUsername());
		PageData user=this.um.findByUsername(pd);//通过用户名找出用户
		String keywords = pd.getString("keywords");
		//活动名称
		if(null!=keywords&&!"".equals(keywords)) {
			pd.put("keywords", keywords);
		
			page.setPd(pd);			
		}
		
			List<TdTaxrevenue> listTaxrevenue = this.sqlService.getAllTdTaxrevenue(page);
			mv.setViewName("system/systemManager/taxrevenue_list");
		    mv.addObject("listTaxrevenue",listTaxrevenue);
			mv.addObject("QX",Jurisdiction.getHC());//按钮权限
			mv.addObject("pd", pd);
		return mv;
	}
	/*
	 * 跳转到个税和手续费添加界面
	 * goAddTaxrevenue
	 */
	@RequestMapping(value="/goAddTaxrevenue")
	public ModelAndView goAddTaxrevenue(Page page)throws Exception{
/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
*/		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/systemManager/taxrevenue_add");
		mv.addObject("msg", "saveU");
		mv.addObject("pd", pd);
		return mv;
	}
	/*
	 * 执行保存税收+手续费
	 * saveTaxrevenueInfo
	 */
	@RequestMapping(value="/saveTaxrevenueInfo")
	public ModelAndView saveTaxrevenueInfo() throws Exception{
/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
*/		logBefore(logger, Jurisdiction.getUsername()+"新增");
		ModelAndView mv = this.getModelAndView();
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("USERNAME",Jurisdiction.getUsername());
		PageData user=this.um.findByUsername(pd);//通过用户名找出用户
		TdTaxrevenue tdTaxrevenueBefore = new TdTaxrevenue();
		tdTaxrevenueBefore.setTaxrevenueStatus(1);
		TdTaxrevenue beforeRevenueStatusFor1 = service.queryOne(tdTaxrevenueBefore);
		
		if(beforeRevenueStatusFor1!=null) {
			//如果有当前税收数据情况下，有且仅有一条
			//找出之前税收状态为1的数据记录修改0变为往期的税收记录
			beforeRevenueStatusFor1.setTaxrevenueStatus(0);
		    Integer beforeRevenueStatusSet0 = service.updateSelective(beforeRevenueStatusFor1);
		    if(beforeRevenueStatusSet0==1) {
		    	//添加保存最新数据，并设置为当前税收
				TdTaxrevenue tdTaxrevenue = new TdTaxrevenue();
				tdTaxrevenue.setTaxrevenueId(this.get32UUID());
				Double taxrevenue_rates = Double.parseDouble(pd.getString("taxrevenue_rate"));
				tdTaxrevenue.setTaxrevenueRate((taxrevenue_rates/100));
				tdTaxrevenue.setTaxrevenueStatus(1);
				service.save(tdTaxrevenue);
		    }
		}else {
			//如果没有当前税收数据情况下，直接保存数据，并设置为当前税收+手续费
			TdTaxrevenue tdTaxrevenue = new TdTaxrevenue();
			tdTaxrevenue.setTaxrevenueId(this.get32UUID());
			Double taxrevenue_rates = Double.parseDouble(pd.getString("taxrevenue_rate"));
			tdTaxrevenue.setTaxrevenueRate(taxrevenue_rates/100);
			tdTaxrevenue.setTaxrevenueStatus(1);
			service.save(tdTaxrevenue);
		}
		

		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}
	/*跳转到修改界面
	 * goEditTaxRevenue
	 */
	@RequestMapping(value="/goEditTaxRevenue")
	public ModelAndView goEditTaxRevenue() throws Exception{
/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
*/		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String taxrevenue_id = pd.getString("taxrevenue_id");
		TdTaxrevenue tdTaxrevenue = service.queryById(taxrevenue_id);
		/*pd = wm.findPositionByPidd(pd);	*/
		
		mv.setViewName("system/systemManager/taxrevenue_edit");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		mv.addObject("tdTaxrevenue", tdTaxrevenue);
		return mv;
	}
	/*执行修改最新税收+手续费
	 * editTaxRevenueById
	 */
	@RequestMapping(value="/editTaxRevenueById")
	public ModelAndView editTaxRevenueById() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		String taxrevenue_id = pd.getString("taxrevenue_id");
		String taxrevenueRate = pd.getString("taxrevenueRate");
		String remark = pd.getString("remark");
		TdTaxrevenue tdTaxrevenue = service.queryById(taxrevenue_id);
		TdTaxrevenue addOldtdTaxrevenue = new TdTaxrevenue();
		addOldtdTaxrevenue.setTaxrevenueStatus(0);
		addOldtdTaxrevenue.setTaxrevenueId(this.get32UUID());
		addOldtdTaxrevenue.setTaxrevenueRate(tdTaxrevenue.getTaxrevenueRate());
		//保存修改之前的数据，添加为往期的税收
		service.save(addOldtdTaxrevenue);
		if(tdTaxrevenue.getTaxrevenueStatus()==1) {
			TdTaxrevenue tdTaxRevenueNew = new TdTaxrevenue();
			tdTaxRevenueNew.setTaxrevenueId(taxrevenue_id);
			Double taxrevenueRates = Double.parseDouble(taxrevenueRate);
			tdTaxRevenueNew.setTaxrevenueRate(taxrevenueRates/100);
			tdTaxRevenueNew.setRemark(remark);
			Integer  upDateReturn= service.updateSelective(tdTaxRevenueNew);
			if(upDateReturn==1) {
				//添加系统日志
				
				FHLOG.save(Jurisdiction.getUsername(), "修改当前税收比率"+tdTaxrevenue.getTaxrevenueRate()+"变为"+tdTaxRevenueNew.getTaxrevenueRate());
			}
		}
	
		
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	/*
	 * 删除不是当前的税收数据
	 * delTaxRevenueById
	 */
	@RequestMapping(value = "/delTaxRevenueById")
	public void delTaxRevenueById(PrintWriter out) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		String taxrevenue_id = pd.getString("taxrevenue_id");
		TdTaxrevenue tdTaxrevenue = service.queryById(taxrevenue_id);
	
	    Integer delReturn = service.deleteByWhere(tdTaxrevenue);
	    if(delReturn==1) {
			FHLOG.save(Jurisdiction.getUsername(), "删除日期为："+tdTaxrevenue.getUpdated()+"的税收+手续费"+tdTaxrevenue.getTaxrevenueRate());
	    }
	
		out.write("success");
		out.close();
	}
}
