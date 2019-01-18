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
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdBackgroundTransferRecordinput;
import com.fh.lw.pojo.yixunlian.TdPartnerBonusTransferRecordinput;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityMusicService;
import com.fh.service.yixunlian.ActivityMusicSqlManager;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.PartnerBonusTransferRecordinputService;
import com.fh.service.yixunlian.PartnerBonusTransferRecordinputSqlManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
@Controller
@RequestMapping("partnerBonusInput/")
public class PartnerBonusTransferRecordinputController extends BaseController{
	//这个注入的是通用mapper使用的service
			@Autowired
			private PartnerBonusTransferRecordinputService service;
			//这是注入的是写sql语句的service
			@Autowired
			private PartnerBonusTransferRecordinputSqlManager sqlService;
			@Autowired
			private UserManager um;
		   @Resource(name="fhlogService")
			private FHlogManager FHLOG;
		   @Autowired
			private ClientUserService clientUserService;
		   @RequestMapping(value="goListPartnerBonusInput")
			public ModelAndView goListPartnerBonusInput(Page page)throws Exception {
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				pd.put("USERNAME",Jurisdiction.getUsername());
				PageData user=this.um.findByUsername(pd);//通过用户名找出用户
				String keywords = pd.getString("keywords");
				//名称
				if(null!=keywords&&!"".equals(keywords)) {
					TdUser tdUser = new TdUser();
					tdUser.setMemberid(keywords);
					TdUser tdUser2 = clientUserService.queryOne(tdUser);
					if(tdUser2!=null) {
						pd.put("keywords", tdUser2.getUserId());
						page.setPd(pd);			
					}
				}
				//付款人名字检索
				String userName = pd.getString("userName");
				if(userName!=null) {			
					TdUser tdUser = new TdUser();
					
					tdUser.setuNickname(userName);
					TdUser tdUser2 = clientUserService.queryOne(tdUser);
					//根据关键词搜索，查看该用户是否为空
					if(tdUser2!=null) {				
						pd.put("keywords", tdUser2.getUserId());	
						page.setPd(pd);	
					}
				}
					List<TdPartnerBonusTransferRecordinput> listPartnerBonusTransferRecordinput = this.sqlService.getAllTdlistlistPartnerBonusTransferRecordinput(page);
					mv.setViewName("system/financeManager/partnerBonusInput_list");
				    mv.addObject("listPartnerBonusTransferRecordinput",listPartnerBonusTransferRecordinput);
					mv.addObject("QX",Jurisdiction.getHC());//按钮权限
					mv.addObject("pd", pd);
				return mv;
			}
		   /*
		    * 显示支付凭证详情
		    * showPayOrderById
		    * partner_bonus_id
		    */
		   @RequestMapping(value="/showPayOrderById")
			public ModelAndView showPayOrderById() throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				String partner_bonus_id = pd.getString("partner_bonus_id");
				TdPartnerBonusTransferRecordinput tdPartnerBonusTransferRecordinput = service.queryById(partner_bonus_id);
				/*pd = wm.findPositionByPidd(pd);	*/
				
				mv.setViewName("system/financeManager/partnerBonusInput_showPayOrder");
				mv.addObject("msg", "editU");
				mv.addObject("pd", pd);
				mv.addObject("tdPartnerBonusTransferRecordinput", tdPartnerBonusTransferRecordinput);
				return mv;
			}
		   /*
		    * 删除合伙人分红单个账单
		    * delPartnerBonusById
		    * partner_bonus_id
		    */
		
			@RequestMapping(value = "/delPartnerBonusById")
			public void delPartnerBonusById(PrintWriter out) throws Exception {
				PageData pd = new PageData();
				pd = this.getPageData();
				String partner_bonus_id = pd.getString("partner_bonus_id");
				TdPartnerBonusTransferRecordinput tdPartnerBonusTransferRecordinput = service.queryById(partner_bonus_id);
				FHLOG.save(Jurisdiction.getUsername(), "删除单个账单");
				
			    this.service.deletePartnerBonusTransferRecordinputById(partner_bonus_id);
			
				out.write("success");
				out.close();
			}
		   /*
		    * 批量删除
		    * deleteAllPartnerBonusInput
		    * partnerBonus_IDS
		    */
			@RequestMapping(value="/deleteAllPartnerBonusInput")
			@ResponseBody
			public Object deleteAllPartnerBonusInput() throws Exception {
				
				FHLOG.save(Jurisdiction.getUsername(), "批量删除收入记录");
				TdBackgroundTransferRecordinput tdBackgroundTransferRecordinput = new TdBackgroundTransferRecordinput();
				PageData pd = new PageData();
				List<PageData> pdList = new ArrayList<PageData>();
				Map<String,Object> map = new HashMap<String,Object>();
				pd = this.getPageData();
				String partnerBonus_IDS = pd.getString("partnerBonus_IDS");
				service.delAllPartnerBonusInput(partnerBonus_IDS);	
				pdList.add(pd);
				map.put("list", pdList);
				return AppUtil.returnObject(pd, map);
			}
}
