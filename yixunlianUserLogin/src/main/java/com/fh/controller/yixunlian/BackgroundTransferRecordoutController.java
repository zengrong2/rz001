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
import com.fh.lw.pojo.yixunlian.TdBackgroundTransferRecordinput;
import com.fh.lw.pojo.yixunlian.TdBackgroundTransferRecordout;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.BackgroundTransferRecordinputService;
import com.fh.service.yixunlian.BackgroundTransferRecordinputSqlManager;
import com.fh.service.yixunlian.BackgroundTransferRecordoutService;
import com.fh.service.yixunlian.BackgroundTransferRecordoutSqlManager;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("backgroundTransferRecordout/")
public class BackgroundTransferRecordoutController extends BaseController{
	//这个注入的是通用mapper使用的service
	@Autowired
	private BackgroundTransferRecordoutService service;
	//这是注入的是写sql语句的service
	@Autowired
	private BackgroundTransferRecordoutSqlManager sqlService;
	@Autowired
	private UserManager um;
	@Resource(name="fhlogService")
	private FHlogManager FHLOG;
	@Autowired
	private ClientUserService clientUserService;
	
	@RequestMapping(value="goListbackgroundTransferRecordout")
	public ModelAndView goListbackgroundTransferRecordout(Page page)throws Exception {
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
		
			List<TdBackgroundTransferRecordout> listBackgroundTransferRecordout = this.sqlService.getAllTdBackgroundTransferRecordout(page);
			mv.setViewName("system/financeManager/backgroundTransferRecordout_list");
		    mv.addObject("listBackgroundTransferRecordout",listBackgroundTransferRecordout);
			mv.addObject("QX",Jurisdiction.getHC());//按钮权限
			mv.addObject("pd", pd);
		return mv;
	}
	/*
	 * 单个删除出账单
	 * delBackgroundTransferRecordoutById
	 * background_transfer_record_id
	 */
	@RequestMapping(value = "/delBackgroundTransferRecordoutById")
	public void delBackgroundTransferRecordoutById(PrintWriter out) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		String background_transfer_record_id = pd.getString("background_transfer_record_id");
		TdBackgroundTransferRecordout tdBackgroundTransferRecordout = service.queryById(background_transfer_record_id);
		FHLOG.save(Jurisdiction.getUsername(), "删除活动类型"+tdBackgroundTransferRecordout.getBackgroundTransferRecordId());
		
	    this.service.deleteBackgroundTransferRecordOutById(background_transfer_record_id);
	
		out.write("success");
		out.close();
	}
	/*
	 * 批量删除账单
	 * deleteAllBackgroundTransferRecordout
	 * BackgroundTransferRecordout_IDS
	 */
	@RequestMapping(value="/deleteAllBackgroundTransferRecordout")
	@ResponseBody
	public Object deleteAllBackgroundTransferRecordout() throws Exception {
		
		FHLOG.save(Jurisdiction.getUsername(), "批量删除收入记录");
		TdBackgroundTransferRecordout tdBackgroundTransferRecordout = new TdBackgroundTransferRecordout();
		PageData pd = new PageData();
		List<PageData> pdList = new ArrayList<PageData>();
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		String BackgroundTransferRecordout_IDS = pd.getString("BackgroundTransferRecordout_IDS");
		service.delAllBackgroundTransferRecordout(BackgroundTransferRecordout_IDS);	
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
	/*
	 * 显示支付凭证
	 * goShowOutPayOrder
	 */
	@RequestMapping(value="/goShowOutPayOrder")
	public ModelAndView goShowOutPayOrder() throws Exception{
/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
*/		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String background_transfer_record_id = pd.getString("background_transfer_record_id");
		TdBackgroundTransferRecordout tdBackgroundTransferRecordout = service.queryById(background_transfer_record_id);
		/*pd = wm.findPositionByPidd(pd);	*/
		
		mv.setViewName("system/financeManager/backgroundTransferRecordout_showPayOrder");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		mv.addObject("tdBackgroundTransferRecordout", tdBackgroundTransferRecordout);
		return mv;
	}
}
