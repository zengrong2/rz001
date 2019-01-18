package com.fh.controller.yixunlian;

import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdAidFund;
import com.fh.lw.pojo.yixunlian.TdBackgroundTransferRecordinput;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityMusicService;
import com.fh.service.yixunlian.ActivityMusicSqlManager;
import com.fh.service.yixunlian.AidFundService;
import com.fh.service.yixunlian.AidFundSqlManager;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("aidFund/")
public class AidFundController extends BaseController{
	//这个注入的是通用mapper使用的service
			@Autowired
			private AidFundService service;
			//这是注入的是写sql语句的service
			@Autowired
			private AidFundSqlManager sqlService;
			@Autowired
			private UserManager um;
		   @Resource(name="fhlogService")
			private FHlogManager FHLOG;
		   @Autowired
			private ClientUserService clientUserService;
			 @RequestMapping(value="listAidFund")
				public ModelAndView listAidFund(Page page)throws Exception {
					ModelAndView mv = this.getModelAndView();
					PageData pd = new PageData();
					pd = this.getPageData();
					pd.put("USERNAME",Jurisdiction.getUsername());
					PageData user=this.um.findByUsername(pd);//通过用户名找出用户
					String keywords = pd.getString("keywords");
					//活动名称
					if(null!=keywords&&!"".equals(keywords)) {
						TdUser tdUser = new TdUser();
						tdUser.setMemberid(keywords);
						TdUser tdUserSearch  = clientUserService.queryOne(tdUser);
						if(tdUserSearch!=null) {
							pd.put("userId", tdUserSearch.getUserId());			
							page.setPd(pd);		
						}
					
						
					}
				
						List<TdAidFund> listTdAidFund = this.sqlService.getAllTdlistTdAidFund(page);
						mv.setViewName("system/aidFund/aidFund_list");
					    mv.addObject("listTdAidFund",listTdAidFund);
						mv.addObject("QX",Jurisdiction.getHC());//按钮权限
						mv.addObject("pd", pd);
					return mv;
				}
			 /*
			  * 显示支付凭证详情
			  * goShowPayOrder
			  */
				@RequestMapping(value="/goShowPayOrder")
				public ModelAndView goShowPayOrder() throws Exception{
			/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
			*/		ModelAndView mv = this.getModelAndView();
					PageData pd = new PageData();
					pd = this.getPageData();
					String af_id = pd.getString("af_id");
					TdAidFund tdAidFund = service.queryById(af_id);
					/*pd = wm.findPositionByPidd(pd);	*/
					
					mv.setViewName("system/aidFund/aidFund_showPayOrder");
					mv.addObject("msg", "editU");
					mv.addObject("pd", pd);
					mv.addObject("tdAidFund", tdAidFund);
					return mv;
				}
				/*
				 * 批量删除
				 * deleteAllaidFund
				 * AidFund_IDS
				 */
				@RequestMapping(value="/deleteAllaidFund")
				@ResponseBody
				public Object deleteAllaidFund() throws Exception {
					
					FHLOG.save(Jurisdiction.getUsername(), "批量删除活动音乐");
					TdAidFund tdAidFund = new TdAidFund();
					PageData pd = new PageData();
					List<PageData> pdList = new ArrayList<PageData>();
					Map<String,Object> map = new HashMap<String,Object>();
					pd = this.getPageData();
					String AidFund_IDS = pd.getString("AidFund_IDS");
					service.delAllAidFund(AidFund_IDS);	
					pdList.add(pd);
					map.put("list", pdList);
					return AppUtil.returnObject(pd, map);
				}
				/*
				 * 单个删除
				 * delAidFundById
				 */
				 @RequestMapping(value = "/delAidFundById")
					public void delAidFundById(PrintWriter out) throws Exception {
						PageData pd = new PageData();
						pd = this.getPageData();
						String af_id = pd.getString("af_id");
						TdAidFund tdAidFund = service.queryById(af_id);
						FHLOG.save(Jurisdiction.getUsername(), "删除助创基金记录"+tdAidFund.getUserId());
						logBefore(logger, Jurisdiction.getUsername() + "删除助创基金"+tdAidFund.getUserId());
					    this.service.deleteAidFundByAid(af_id);
					
						out.write("success");
						out.close();
					}
}
