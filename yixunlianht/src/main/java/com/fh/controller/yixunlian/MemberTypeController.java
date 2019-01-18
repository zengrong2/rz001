package com.fh.controller.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.lw.pojo.yixunlian.TdUtype;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.MemberTypeService;
import com.fh.service.yixunlian.MemberTypeSqlManager;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
@Controller
@RequestMapping("memberType/")
public class MemberTypeController  extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private MemberTypeService service;
		//这是注入的是写sql语句的service
		@Autowired
		private MemberTypeSqlManager sqlService;
		@Autowired
		private UserManager um;
		@Resource(name="fhlogService")
	    private FHlogManager FHLOG;
		@Autowired
		private ClientUserService tdUserService;
		
		@RequestMapping(value="goListUtype")
		public ModelAndView goListUtype(Page page)throws Exception {
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
				List<PageData> listMemberType = this.sqlService.getAllTdUtype(page);
				for (PageData pageData : listMemberType) {
					TdUser tdUser = new TdUser();
					tdUser.setUtypeId(pageData.getString("utype_id"));
					int countTdUser = tdUserService.queryTotalCount(tdUser);
					pageData.put("countTdUser", countTdUser);
				}
				
				/*for (TdUtype tdUtype : listMemberType) {
					TdUser tdUser = new TdUser();
					tdUser.setUtypeId(tdUtype.getUtypeId());
					int countTdUser = tdUserService.queryTotalCount(tdUser);
					tdUtype.setCountTdUser(countTdUser);
				}*/
				mv.setViewName("system/tdUser/memberType_list");
			    mv.addObject("listMemberType",listMemberType);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 修改 跳转到会员等级界面
		 * goEditMemberType
		 */
		
		@RequestMapping(value="/goEditMemberType")
		public ModelAndView goEditMemberType() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			String utype_id = pd.getString("utype_id");
			TdUtype tdUtype = service.queryById(utype_id);
			/*pd = wm.findPositionByPidd(pd);	*/		
			mv.setViewName("system/tdUser/memberType_edit");
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);			
			mv.addObject("tdUtype", tdUtype);
			return mv;
		}
		/*
		 * 执行修改会员等级设置
		 * editMemberTypeByUid
		 */
		
		@RequestMapping(value="/editMemberTypeByUid")
		public ModelAndView editMemberTypeByUid() throws Exception{
			logBefore(logger, Jurisdiction.getUsername()+"修改");
			
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			TdUtype TdUtype = new TdUtype();
		    String utype_id = pd.getString("utype_id");
		    TdUtype TdUtype2 = service.queryById(utype_id);
		    FHLOG.save(Jurisdiction.getUsername(), "修改会员"+TdUtype2.getUserType()+"等级的信息");
			
			String userType = pd.getString("userType");
			String userDay = pd.getString("userDay");
			String utypeCharge = pd.getString("utypeCharge");
			String remark = pd.getString("remark");
			
			/*Tools.isEmpty(creditrdNums);*/
			if(null!=utypeCharge&&!"".equals(utypeCharge)) {			
				Integer utypeCharges = Integer.parseInt(utypeCharge);
				TdUtype.setUtypeCharge(utypeCharges);
			}
			TdUtype.setUserDay(userDay);
			TdUtype.setUtypeId(utype_id);
			TdUtype.setUserType(userType);
			TdUtype.setRemark(remark);
			service.updateSelective(TdUtype);
		    mv.addObject("msg","success");
			mv.setViewName("save_result");
			return mv;
		}
}
