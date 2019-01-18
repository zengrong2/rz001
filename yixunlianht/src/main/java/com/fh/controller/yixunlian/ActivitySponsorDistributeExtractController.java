package com.fh.controller.yixunlian;

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
import com.fh.lw.pojo.yixunlian.TdActivitySponsorDistributeExtract;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySponsorDistributeExtractService;
import com.fh.service.yixunlian.ActivitySponsorDistributeExtractSqlManager;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("aSponsorDisExt/")
public class ActivitySponsorDistributeExtractController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private ActivitySponsorDistributeExtractService service;
		//这是注入的是写sql语句的service
		@Autowired
		private ActivitySponsorDistributeExtractSqlManager sqlService;
		@Autowired
		private UserManager um;
		 @Resource(name="fhlogService")
		 private FHlogManager FHLOG;
		 @Autowired
		 private ClientUserService clientUserservice;
		 
		 
		    @RequestMapping(value="goListASponsorDisEx")
			public ModelAndView goListASponsorDisEx(Page page)throws Exception {
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
			
					List<TdActivitySponsorDistributeExtract> listActivitySponsorDistributeExtract = this.sqlService.getAllTdActivitySponsorDistributeExtract(page);
					mv.setViewName("system/systemManager/activitySponsorDistributeExtract_list");
				    mv.addObject("listActivitySponsorDistributeExtract",listActivitySponsorDistributeExtract);
					mv.addObject("QX",Jurisdiction.getHC());//按钮权限
					mv.addObject("pd", pd);
				return mv;
			}
		    /*
		     * 跳转到修改界面
		     * goEditaSponsorDisExt
		     */
		    @RequestMapping(value="/goEditaSponsorDisExt")
			public ModelAndView goEditaSponsorDisExt() throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				String activity_sponsor_distribute_extract_id = pd.getString("activity_sponsor_distribute_extract_id");
				TdActivitySponsorDistributeExtract tdActivitySponsorDistributeExtract = service.queryById(activity_sponsor_distribute_extract_id);
				/*pd = wm.findPositionByPidd(pd);	*/
				
				mv.setViewName("system/systemManager/activitySponsorDistributeExtract_edit");
				mv.addObject("msg", "editU");
				mv.addObject("pd", pd);
				mv.addObject("tdActivitySponsorDistributeExtract", tdActivitySponsorDistributeExtract);
				return mv;
			}
		    /*
		     * 执行修改
		     * editASponsorDisExtById
		     */
		    @RequestMapping(value="/editASponsorDisExtById")
			public ModelAndView editASponsorDisExtById() throws Exception{
				logBefore(logger, Jurisdiction.getUsername()+"修改");
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				TdActivitySponsorDistributeExtract tdActivitySponsorDistributeExtract = new TdActivitySponsorDistributeExtract();
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=format.format(date);
				String rates = pd.getString("activitySponsorDistributeExtractRate");
				Double rate =Double.parseDouble(rates); 
				String activitySponsorDistributeExtractId =  pd.getString("activitySponsorDistributeExtractId");
				tdActivitySponsorDistributeExtract.setActivitySponsorDistributeExtractId(activitySponsorDistributeExtractId);
				String activitySponsorDistributeExtractType = pd.getString("activitySponsorDistributeExtractType");
				
				tdActivitySponsorDistributeExtract.setActivitySponsorDistributeExtractRate(rate);
				tdActivitySponsorDistributeExtract.setRemark(pd.getString("remark"));
				//修改之前的比率
				TdActivitySponsorDistributeExtract before = service.queryById(activitySponsorDistributeExtractId);
				int returnResult =  service.updateSelective(tdActivitySponsorDistributeExtract);		
				//系统日志
				if(returnResult==1) {
					if("0".equals(activitySponsorDistributeExtractType) ) {
                       FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":修改活动主办方分发提成对象为主办方推荐人的提成比率:->"+
                       before.getActivitySponsorDistributeExtractRate()+"改为："+rate);
					}else if("1".equals(activitySponsorDistributeExtractType)) {
	                       FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":修改活动主办方分发提成对象为普通会员分享的提成比率:->"+
	                       before.getActivitySponsorDistributeExtractRate()+"改为："+rate);
	        		}else if("2".equals(activitySponsorDistributeExtractType)) {
	                       FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":修改活动主办方分发提成对象为拥有资源库的人分享或输出资源的提成比率:->"+
	                       before.getActivitySponsorDistributeExtractRate()+"改为："+rate);
	        		}else if("3".equals(activitySponsorDistributeExtractType)) {
	                       FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":修改活动主办方分发提成对象为公益基金的提成比率:->"+
	                       before.getActivitySponsorDistributeExtractRate()+"改为："+rate);
	        		}
				}
				mv.addObject("msg","success");
				mv.setViewName("save_result");
				return mv;
			}
}
