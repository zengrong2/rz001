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
import com.fh.lw.pojo.yixunlian.TdEngagendustry;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.EngageIndustryService;
import com.fh.service.yixunlian.EngageIndustrySqlManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

//行业类型表
@Controller
@RequestMapping("engageIndustry/")
public class EngageIndustryController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private EngageIndustryService service;
		//这是注入的是写sql语句的service
		@Autowired
		private EngageIndustrySqlManager sqlService;
		@Autowired
		private UserManager um;
		@Resource(name="fhlogService")
		private FHlogManager FHLOG;
		@Autowired
		private ClientUserService clientUserservice;
		
		@RequestMapping(value="goListEngageIndustry")
		public ModelAndView goListEngageIndustry(Page page)throws Exception {
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
			/*//主办方名称检索
			String userName = pd.getString("userName");
			if(userName!=null) {			
				TdUser tdUser = new TdUser();
				tdUser.setuName(userName);
				TdUser tdUser2 = clientUserservice.queryOne(tdUser);
				//根据关键词搜索，查看该用户是否为空
				if(tdUser2!=null) {				
					pd.put("userId", tdUser2.getUserId());	
					page.setPd(pd);	
				}
			}*/
				List<TdEngagendustry> listTdEngagendustry = this.sqlService.getAllTdEngagendustry(page);
				mv.setViewName("system/tdUser/engagendustry_list");
			    mv.addObject("listTdEngagendustry",listTdEngagendustry);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 执行删除
		 * delEngageIndustryById
		 * 
		 */
		@RequestMapping(value = "/delEngageIndustryById")
		public void delEngageIndustryById(PrintWriter out) throws Exception {
			PageData pd = new PageData();
			pd = this.getPageData();
			String egid_id = pd.getString("egid_id");
			TdEngagendustry tdEngagendustry = service.queryById(egid_id);
			FHLOG.save(Jurisdiction.getUsername(), "删除从事行业"+tdEngagendustry.getEgidName());
			logBefore(logger, Jurisdiction.getUsername() + "删除活动"+tdEngagendustry.getEgidName());
		  /*  this.service.deleteActivityByAid(activity_id);*/
			TdEngagendustry tdEngagendustry2 = new TdEngagendustry();
			tdEngagendustry2.setEgidId(egid_id);
		     this.service.deleteByWhere(tdEngagendustry2);
			out.write("success");
			out.close();
		}
		/*
		 * 跳转到修改界面
		 * goEditEngageIndustry
		 */
		@RequestMapping(value="/goEditEngageIndustry")
		public ModelAndView goEditEngageIndustry() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			String egid_id = pd.getString("egid_id");
			TdEngagendustry tdEngagendustry = service.queryById(egid_id);
			/*pd = wm.findPositionByPidd(pd);	*/
			
			mv.setViewName("system/tdUser/engagendustry_edit");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
			mv.addObject("tdEngagendustry", tdEngagendustry);
			return mv;
		}
		/*
		 * 执行修改
		 * editEngageIndustryById
		 */
		@RequestMapping(value="/editEngageIndustryById")
		public ModelAndView editEngageIndustryById() throws Exception{
			logBefore(logger, Jurisdiction.getUsername()+"修改");
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			TdEngagendustry tdEngagendustry = new TdEngagendustry();
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time=format.format(date);
			pd.put("update_time", time);
		
			tdEngagendustry.setEgidName(pd.getString("egidName"));
			tdEngagendustry.setEgidId(pd.getString("egid_id"));
			tdEngagendustry.setRemark(pd.getString("remark"));
			service.update(tdEngagendustry);	//执行修改,？？传参数	
			mv.addObject("msg","success");
			mv.setViewName("save_result");
			return mv;
		}
		/*
		 * 跳转到添加界面
		 * goAddEngageIndustry
		 */
		@RequestMapping(value="/goAddEngageIndustry")
		public ModelAndView goAddEngageIndustry(Page page)throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			mv.setViewName("system/tdUser/engagendustry_add");
			mv.addObject("msg", "saveU");
			mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 执行添加从事行业
		 * saveEngageIndustryInfo
		 */
		@RequestMapping(value="/saveEngageIndustryInfo")
		public ModelAndView saveEngageIndustryInfo() throws Exception{
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
			TdEngagendustry tdEngagendustry = new TdEngagendustry();
			tdEngagendustry.setEgidName(pd.getString("egid_name"));
			tdEngagendustry.setEgidId(this.get32UUID());
			
			service.save(tdEngagendustry);//??添加参数

			mv.addObject("msg","success");
		    mv.setViewName("save_result");		
			return mv;
		}
}
