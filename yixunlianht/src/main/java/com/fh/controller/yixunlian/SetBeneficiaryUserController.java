package com.fh.controller.yixunlian;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivityChargeItem;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdAddress;
import com.fh.lw.pojo.yixunlian.TdHobbyAndactivitycategory;
import com.fh.lw.pojo.yixunlian.TdSetBeneficiary;
import com.fh.lw.pojo.yixunlian.TdUhobby;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.lw.pojo.yixunlian.TdUserCount;
import com.fh.lw.pojo.yixunlian.TdUtype;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.ClientUserSqlManager;
import com.fh.service.yixunlian.MemberTypeService;
import com.fh.service.yixunlian.SetBeneficiaryUserService;
import com.fh.service.yixunlian.SetBeneficiaryUserSqlManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.fh.util.Tools;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("setBeneficiaryUser/")
public class SetBeneficiaryUserController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private SetBeneficiaryUserService service;
		@Autowired
		private SetBeneficiaryUserSqlManager sqlService;
		@Autowired
		private UserManager um;
		@Resource(name="fhlogService")
		private FHlogManager FHLOG;
		@Autowired
		private ClientUserService clientUserService;
		
		@RequestMapping(value="goListSetBeneficiaryUser")
		public ModelAndView goListSetBeneficiaryUser(Page page)throws Exception {
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("USERNAME",Jurisdiction.getUsername());
			PageData user=this.um.findByUsername(pd);//通过用户名找出用户
			String beneficiaryUNickname = pd.getString("beneficiaryUNickname");
			if(!"".equals(beneficiaryUNickname)&&beneficiaryUNickname!=null) {
				TdUser tdUserss = new TdUser();
				tdUserss.setuNickname(beneficiaryUNickname);
				TdUser tdUserss2 = clientUserService.queryOne(tdUserss);
				if(tdUserss2!=null) {
					
					pd.put("beneficiaryUserId", tdUserss2.getUserId());
					page.setPd(pd);
				}
			}
			String memberUNickname = pd.getString("memberUNickname");
			if(!"".equals(memberUNickname)&&memberUNickname!=null) {
				TdUser tdUsersss = new TdUser();
				tdUsersss.setuNickname(memberUNickname);
				TdUser tdUsersss3= clientUserService.queryOne(tdUsersss);
				if(tdUsersss3!=null) {
					
					pd.put("member_user_id", tdUsersss3.getUserId());
					page.setPd(pd);
				}
			}
			page.setPd(pd);
			List<PageData> listSetBeneficiaryUser = this.sqlService.getAllSetBeneficiaryUsery(page);
			for (PageData pageData : listSetBeneficiaryUser) {
				
				 TdUser tdUser1 =clientUserService.queryById(pageData.getString("beneficiary_user_id"));
				 if(tdUser1!=null) {
					 pageData.put("beneficiaryUname", tdUser1.getuNickname());
					 pageData.put("beneficiaryUMemberid", tdUser1.getMemberid());
				 }
				 TdUser tdUser2 =clientUserService.queryById(pageData.getString("member_user_id"));
				 if(tdUser2!=null) {
					 pageData.put("memberUserUname", tdUser2.getuNickname());
					 pageData.put("memberUserUMemberid", tdUser2.getMemberid());
				 }
				 
			}
			    mv.setViewName("system/tdUser/setBeneficiaryUser_list");
			
			    mv.addObject("listSetBeneficiaryUser",listSetBeneficiaryUser);
				mv.addObject("QX",Jurisdiction.getHC());//按钮权限
				mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 删除
		 * delSetBeneficiaryById
		 * beneficiary_id
		 */
		@RequestMapping(value = "/delSetBeneficiaryById")
		public void delSetBeneficiaryById(PrintWriter out) throws Exception {
			PageData pd = new PageData();
			pd = this.getPageData();
			String beneficiary_id = pd.getString("beneficiary_id");
			TdSetBeneficiary tdSetBeneficiary = service.queryById(beneficiary_id);
			if(tdSetBeneficiary!=null) {
				
				TdUser beneficiaryUser = clientUserService.queryById(tdSetBeneficiary.getBeneficiaryUserId());
				TdUser memberUser=clientUserService.queryById(tdSetBeneficiary.getMemberUserId());
				if(beneficiaryUser!=null&&memberUser!=null) {
					
					FHLOG.save(Jurisdiction.getUsername(), "删除设置收益人会员列表:-》"+
					"收益人："+beneficiaryUser.getuNickname()+"(会员号"+beneficiaryUser.getMemberid()+")"
					+"归属人:"+memberUser.getuNickname()+"(会员号"+memberUser.getMemberid()+")");
				}
				
			}
		   /* this.service.deleteTdUserByAid(user_id);*/
			tdSetBeneficiary.setBeneficiaryId(beneficiary_id);			
			this.service.deleteByWhere(tdSetBeneficiary);		
			out.write("success");
			out.close();
		}
		/*
		 * 跳转到修改界面
		 * goEditSetBeneficiary
		 * beneficiary_id
		 */
		@RequestMapping(value="/goEditSetBeneficiary")
		public ModelAndView goEditSetBeneficiary() throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			
			
			String beneficiary_id = pd.getString("beneficiary_id");
			TdSetBeneficiary tdSetBeneficiary = service.queryById(beneficiary_id);
			TdUser tdBeneficiaryUser = clientUserService.queryById(tdSetBeneficiary.getBeneficiaryUserId());
			TdUser tdMemberUser = clientUserService.queryById(tdSetBeneficiary.getMemberUserId());
			tdSetBeneficiary.setTdUserBeneficiary(tdBeneficiaryUser);
			tdSetBeneficiary.setTdUserMember(tdMemberUser);
			mv.setViewName("system/tdUser/setBeneficiaryUser_edit");
		
			mv.addObject("msg", "editU");
			mv.addObject("pd", pd);
			
			mv.addObject("tdSetBeneficiary", tdSetBeneficiary);
			return mv;
		}
		/*
		 * 执行修改
		 */
		@RequestMapping(value="/editSetBeneficiaryById")
		public ModelAndView editSetBeneficiaryById() throws Exception{
			logBefore(logger, Jurisdiction.getUsername()+"修改");
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			String beneficiaryUserMember = pd.getString("beneficiaryUserMember");
			String beneficiaryUserName = pd.getString("beneficiaryUserName");
			String memberUserMember = pd.getString("memberUserMember");
			String memberUserName = pd.getString("memberUserName");
			String beneficiary_id = pd.getString("beneficiary_id");
			String remark = pd.getString("remark");
			//收益人对象
			TdUser tdBeneficiaryUser = new TdUser();
			tdBeneficiaryUser.setMemberid(beneficiaryUserMember);
			tdBeneficiaryUser.setuNickname(beneficiaryUserName);
			TdUser beneficiaryUser = clientUserService.queryOne(tdBeneficiaryUser);
			//归属人对象
			TdUser tdMemberUserUser = new TdUser();
			tdMemberUserUser.setMemberid(memberUserMember);
			tdMemberUserUser.setuNickname(memberUserName);
			TdUser memberUser = clientUserService.queryOne(tdMemberUserUser);
			TdSetBeneficiary tdSetBeneficiary = new TdSetBeneficiary();
			if(beneficiaryUser!=null) {				
				tdSetBeneficiary.setBeneficiaryUserId(beneficiaryUser.getUserId());
			}
			if(memberUser!=null) {				
				tdSetBeneficiary.setMemberUserId(memberUser.getUserId());
			}
			tdSetBeneficiary.setBeneficiaryId(beneficiary_id);
			tdSetBeneficiary.setRemark(remark);
			service.updateSelective(tdSetBeneficiary);
			mv.addObject("msg","success");
			mv.setViewName("save_result");
			return mv;
		}
		/*
		 * 跳转到添加界面
		 * goAddSetBeneficiaryUser
		 */
		@RequestMapping(value="/goAddSetBeneficiaryUser")
		public ModelAndView goAddSetBeneficiaryUser(Page page)throws Exception{
	/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
	*/		ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			mv.setViewName("system/tdUser/setBeneficiaryUser_add");
			mv.addObject("msg", "saveU");
			mv.addObject("pd", pd);
			return mv;
		}
		/*
		 * 执行添加
		 */
		@RequestMapping(value="/setBeneficiaryInfo")
		public ModelAndView setBeneficiaryInfo() throws Exception{
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
			String beneficiaryUserMember = pd.getString("beneficiaryUserMember");
			String beneficiaryUserName = pd.getString("beneficiaryUserName");
			String memberUserMember = pd.getString("memberUserMember");
			String memberUserName = pd.getString("memberUserName");
			//收益人对象
			TdUser tdBeneficiaryUser = new TdUser();
			tdBeneficiaryUser.setMemberid(beneficiaryUserMember);
			tdBeneficiaryUser.setuNickname(beneficiaryUserName);
			TdUser beneficiaryUser = clientUserService.queryOne(tdBeneficiaryUser);
			//归属人对象
			TdUser tdMemberUserUser = new TdUser();
			tdMemberUserUser.setMemberid(memberUserMember);
			tdMemberUserUser.setuNickname(memberUserName);
			TdUser memberUser = clientUserService.queryOne(tdMemberUserUser);
			TdSetBeneficiary tdSetBeneficiary = new TdSetBeneficiary();
			if(beneficiaryUser!=null) {				
				tdSetBeneficiary.setBeneficiaryUserId(beneficiaryUser.getUserId());
			}
			if(memberUser!=null) {				
				tdSetBeneficiary.setMemberUserId(memberUser.getUserId());
			}
			tdSetBeneficiary.setBeneficiaryId(this.get32UUID());
			service.saveSelective(tdSetBeneficiary);
			
            //添加系统日志
            
			FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+"添加活动类型"+pd.getString("activitycategory_name"));
			
			mv.addObject("msg","success");
		    mv.setViewName("save_result");		
			return mv;
		}
		/*
		 * 批量删除
		 * deleteAllSetBeneficiaryUser
		 * Beneficiary_IDS
		 * 
		 */
		@RequestMapping(value="/deleteAllSetBeneficiaryUser")
		@ResponseBody
		public Object deleteAllSetBeneficiaryUser() throws Exception {
			
			FHLOG.save(Jurisdiction.getUsername(), "批量删除活动类型");
			TdSetBeneficiary tdSetBeneficiary = new TdSetBeneficiary();
			PageData pd = new PageData();
			List<PageData> pdList = new ArrayList<PageData>();
			Map<String,Object> map = new HashMap<String,Object>();
			pd = this.getPageData();
			String Beneficiary_IDS = pd.getString("Beneficiary_IDS");
			service.delAllSetBeneficiary(Beneficiary_IDS);	
			pdList.add(pd);
			map.put("list", pdList);
			return AppUtil.returnObject(pd, map);
		}
	
		/*
		 * showMemberUserResouseTryMemeberDetailById
		 * member_user_id
		 */
		@RequestMapping(value="ShowMemberUserResouseTryMemeberDetailById")
		public ModelAndView ShowMemberUserResouseTryMemeberDetailById(){
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
					try{
					pd = this.getPageData();			
					String member_user_id = pd.getString("member_user_id");
				
					List<TdUser>  tdUserList= new ArrayList<>();
					if(!"".equals(member_user_id)&&member_user_id!=null) {
						
						TdUser tdUser = new TdUser();
						tdUser.setUserrefereeUid(member_user_id);
						tdUser.setUtypeId("4");
						tdUserList = clientUserService.queryListByWhere(tdUser);
					}
						mv.addObject("tdUserList",tdUserList);
						mv.setViewName("system/tdUser/setBeneficiaryUser_tdUserListDetail");
						
					} catch(Exception e){
						logger.error(e.toString(), e);
					}
					return mv;
				}
		@RequestMapping(value="/beneficiaryByMemberidFindUNickName")
		public String beneficiaryByMemberidFindUNickName(HttpServletResponse response,HttpServletRequest request) throws Exception {
		String beneficiaryUserMember=request.getParameter("beneficiaryUserMember");
        String memberUserMember = request.getParameter("memberUserMember");
        JSONObject json = new JSONObject();
        if(!"".equals(beneficiaryUserMember)&&beneficiaryUserMember!=null) {
        	TdUser tdUser = new TdUser();
    		tdUser.setMemberid(beneficiaryUserMember);
    		TdUser tdUser2 = clientUserService.queryOne(tdUser);
    		//解析集合用的方法
    	/*	JSONArray json = new JSONArray();*/
    		
    	       /*  JSONObject jo = new JSONObject();
    	         jo.put("citycode", pLog.getCitycode());
    	         jo.put("pidcode", pLog.getPidcode());
    	         jo.put("cityname", pLog.getCityname());*/
    		
    		if(tdUser2!=null) {   			
    				json.put("uNickname", tdUser2.getuNickname());    			
    		}else {
    			json.put("uNickname","");
    		}
        }
		//
		
		if(!"".equals(memberUserMember)&&memberUserMember!=null) {
			TdUser tdUser = new TdUser();
    		tdUser.setMemberid(memberUserMember);
    		TdUser tdUser2 = clientUserService.queryOne(tdUser);
    		//解析集合用的方法
    	/*	JSONArray json = new JSONArray();*/
    		
    	       /*  JSONObject jo = new JSONObject();
    	         jo.put("citycode", pLog.getCitycode());
    	         jo.put("pidcode", pLog.getPidcode());
    	         jo.put("cityname", pLog.getCityname());*/
    	
    		if(tdUser2!=null) {
    				json.put("uNickname", tdUser2.getuNickname());
    			
    		}else {
    			json.put("uNickname","");
    		}
		}
		
	      /*   json.add(jo);*/
	    

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try {
		out = response.getWriter();
		} catch (Exception e) {
		e.printStackTrace();
		}
		//将城市的json字符串响应给jquery的ajax
		out.print(json.toString());
		out.close();
		return null;
		}
}
