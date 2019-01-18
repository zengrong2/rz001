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
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdBackgroundTransferRecordinput;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityTypeService;
import com.fh.service.yixunlian.ActivityTypeSqlManager;
import com.fh.service.yixunlian.BackgroundTransferRecordinputService;
import com.fh.service.yixunlian.BackgroundTransferRecordinputSqlManager;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("backgroundTransferRecordinput/")
public class BackgroundTransferRecordinputController extends BaseController{
	//这个注入的是通用mapper使用的service
			@Autowired
			private BackgroundTransferRecordinputService service;
			//这是注入的是写sql语句的service
			@Autowired
			private BackgroundTransferRecordinputSqlManager sqlService;
			@Autowired
			private UserManager um;
			@Resource(name="fhlogService")
			private FHlogManager FHLOG;
			@Autowired
			private ClientUserService clientUserService;
			
			@RequestMapping(value="goListbackgroundTransferRecordinput")
			public ModelAndView goListbackgroundTransferRecordinput(Page page)throws Exception {
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
				
					List<TdBackgroundTransferRecordinput> listBackgroundTransferRecordinput = this.sqlService.getAllTdBackgroundTransferRecordinput(page);
					mv.setViewName("system/financeManager/backgroundTransferRecordinput_list");
				    mv.addObject("listBackgroundTransferRecordinput",listBackgroundTransferRecordinput);
					mv.addObject("QX",Jurisdiction.getHC());//按钮权限
					mv.addObject("pd", pd);
				return mv;
			}
			/*
			 * 单个删除转账激励
			 * delBackgroundTransferRecordinputById
			 * background_transfer_record_id
			 */
			@RequestMapping(value = "/delBackgroundTransferRecordinputById")
			public void delBackgroundTransferRecordinputById(PrintWriter out) throws Exception {
				PageData pd = new PageData();
				pd = this.getPageData();
				String background_transfer_record_id = pd.getString("background_transfer_record_id");
				TdBackgroundTransferRecordinput tdBackgroundTransferRecordinput = service.queryById(background_transfer_record_id);
				FHLOG.save(Jurisdiction.getUsername(), "删除活动类型"+tdBackgroundTransferRecordinput.getTransferSingleNumber());
				
			    this.service.deleteBackgroundTransferRecordinputById(background_transfer_record_id);
			
				out.write("success");
				out.close();
			}
			/*
			 * 批量删除
			 * deleteAllBackgroundTransferRecordinput
			 * BackgroundTransferRecordinput_IDS
			 */
			
			@RequestMapping(value="/deleteAllBackgroundTransferRecordinput")
			@ResponseBody
			public Object deleteAllBackgroundTransferRecordinput() throws Exception {
				
				FHLOG.save(Jurisdiction.getUsername(), "批量删除收入记录");
				TdBackgroundTransferRecordinput tdBackgroundTransferRecordinput = new TdBackgroundTransferRecordinput();
				PageData pd = new PageData();
				List<PageData> pdList = new ArrayList<PageData>();
				Map<String,Object> map = new HashMap<String,Object>();
				pd = this.getPageData();
				String BackgroundTransferRecordinput_IDS = pd.getString("BackgroundTransferRecordinput_IDS");
				service.delAllBackgroundTransferRecordinput(BackgroundTransferRecordinput_IDS);	
				pdList.add(pd);
				map.put("list", pdList);
				return AppUtil.returnObject(pd, map);
			}
			/*
			 * 显示支付凭证
			 * goShowPayOrder
			 * background_transfer_record_id
			 */
			@RequestMapping(value="/goShowPayOrder")
			public ModelAndView goShowPayOrder() throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				String background_transfer_record_id = pd.getString("background_transfer_record_id");
				TdBackgroundTransferRecordinput tdBackgroundTransferRecordinput = service.queryById(background_transfer_record_id);
				/*pd = wm.findPositionByPidd(pd);	*/
				
				mv.setViewName("system/financeManager/backgroundTransferRecordinput_showPayOrder");
				mv.addObject("msg", "editU");
				mv.addObject("pd", pd);
				mv.addObject("tdBackgroundTransferRecordinput", tdBackgroundTransferRecordinput);
				return mv;
			}
}
