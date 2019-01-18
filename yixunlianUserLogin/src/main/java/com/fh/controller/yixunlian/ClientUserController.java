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
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdAddress;
import com.fh.lw.pojo.yixunlian.TdHobbyAndactivitycategory;
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
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.fh.util.Tools;
@Controller
@RequestMapping("clientUser/")
public class ClientUserController extends BaseController{
	
	//这个注入的是通用mapper使用的service
	@Autowired
	private ClientUserService service;
	//这是注入的是写sql语句的service
	@Autowired
	private ClientUserSqlManager sqlService;
	@Autowired
	private UserManager um;
	@Resource(name="fhlogService")
	private FHlogManager FHLOG;
	//会员类型通用service
	@Autowired
	private MemberTypeService memberTypeservice;
	@RequestMapping(value="goListClientUser")
	public ModelAndView goListClientUser(Page page)throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("USERNAME",Jurisdiction.getUsername());
		PageData user=this.um.findByUsername(pd);//通过用户名找出用户
		String keywords = pd.getString("keywords");
		//用户名称
		if(null!=keywords&&!"".equals(keywords)) {
			pd.put("keywords", keywords);
		
			page.setPd(pd);			
		}
		//会员号检索
		String memberid = pd.getString("memberid");
		if(null!=memberid&&!"".equals(memberid)){			
	
			pd.put("memberid",memberid);	
			page.setPd(pd);	
		}
		//归属人检索
		String userRefereeNameNum = pd.getString("userRefereeNameNum");
		if(null!=userRefereeNameNum&&!"".equals(userRefereeNameNum)) {
			TdUser tdUser1 = new TdUser();
		
			tdUser1.setMemberid(userRefereeNameNum);
			TdUser userReferee = service.queryOne(tdUser1);
			if(userReferee!=null) {
				pd.put("userReferee_uid", userReferee.getUserId());
				page.setPd(pd);
			}
		}
		String userManagerNameNum = pd.getString("userManagerNameNum");
		if(null!=userManagerNameNum&&!"".equals(userManagerNameNum)) {
			TdUser tdUser2 = new TdUser();
			
			tdUser2.setMemberid(userManagerNameNum);
			TdUser userManager = service.queryOne(tdUser2);
			if(userManager!=null) {
				pd.put("userManager_uid", userManager.getUserId());
				page.setPd(pd);				
			}
		}
		String start=pd.getString("start");
		if(start!=null && !"".equals(start)) {
		start=start+" 00:00:00";
		}
		pd.put("start", start);
		String end=pd.getString("end");
		if(end !=null && !"".equals(end)) {
		end=end+" 23:59:59";
		}
		pd.put("end", end);
	/*	if(start!=null && !"".equals(start)) {
			start=start.replace(" 00:00:00","");
			pd.put("start", start);
			}
			if(end !=null && !"".equals(end)) {
			end=end.replace(" 23:59:59", "");
			pd.put("end", end);
			}*/
		//已经激活用户的列表
		pd.put("user_isactivation", 1);
		page.setPd(pd);
			List<PageData> listTdUser = this.sqlService.getAllTdUser(page);
		  for(int i=0;i<listTdUser.size();i++) {
			  PageData tdUser3 = listTdUser.get(i);
			  if(tdUser3.getString("utype_id")!=null) {
				  TdUtype TdUtype =  new TdUtype();
				  TdUtype.setUtypeId(tdUser3.getString("utype_id"));
				  TdUtype tdUtype = memberTypeservice.queryOne(TdUtype);
				  tdUser3.put("userType", tdUtype.getUserType());
			  }
			  
		    	if(tdUser3.getString("userReferee_uid")!=null) {	    		
		    		TdUser tdUserReferee = service.queryById(tdUser3.getString("userReferee_uid"));
		    		if(tdUserReferee!=null) {		    			
		    			tdUser3.put("userRefereeName",tdUserReferee.getuNickname() ) ; 
		    		}
		    	}
		    	if(tdUser3.getString("userManager_uid")!=null) {
		    		TdUser tdUserManager = service.queryById(tdUser3.getString("userManager_uid"));
		    		if(tdUserManager!=null) {
		    			tdUser3.put("userManagerName", tdUserManager.getuNickname()); 
		    		}
		    	}
			}
		  //不同级别用户统计数量
		  TdUserCount tdUserCount = service.getTdUserCount();
		  
		
			mv.setViewName("system/tdUser/tdUser_list");
		    mv.addObject("listTdUser",listTdUser);
			mv.addObject("QX",Jurisdiction.getHC());//按钮权限
			mv.addObject("pd", pd);
			mv.addObject("tdUserCount", tdUserCount);
			
		return mv;
	}
	/*
	 * 显示用户详情
	 * showTdUserDetailById
	 */
	@RequestMapping(value="showTdUserDetailById")
	public ModelAndView showTdUserDetailById(){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
				pd = this.getPageData();			
				String user_id = pd.getString("user_id");
				TdUser tdUser = service.queryById(user_id);
				TdUser tdUserManager= service.queryById(tdUser.getUsermanagerUid());
				TdUser tdUserReferee= service.queryById(tdUser.getUserrefereeUid());
				if(tdUserManager!=null) {
					tdUser.setUsermanagerName(tdUserManager.getuNickname());			
				}
				if(tdUserReferee!=null) {
					tdUser.setUserrefereeName(tdUserReferee.getuNickname());
				}
				//通过会员id查会员类型
				TdUtype	memberType = memberTypeservice.queryById(tdUser.getUtypeId());
					mv.addObject("tdUser",tdUser);
					mv.setViewName("system/tdUser/tdUserInfo_detail");
					
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	
	/*
	 * 删除用户
	 * delUserByUid
	 */
	@RequestMapping(value = "/delUserByUid")
	public void delUserByUid(PrintWriter out) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		String user_id = pd.getString("user_id");
		TdUser tdUser = service.queryById(user_id);
		FHLOG.save(Jurisdiction.getUsername(), "删除用户"+tdUser.getuNickname());
		
	   /* this.service.deleteTdUserByAid(user_id);*/
		tdUser.setUserId(user_id);
		this.service.deleteByWhere(tdUser);
	
		out.write("success");
		out.close();
	}
	
	/*
	 * 跳转到修改用户界面
	 * goEditUser
	 */
	@RequestMapping(value="/goEditUser")
	public ModelAndView goEditUser() throws Exception{
/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
*/		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		
		String user_id = pd.getString("user_id");
		TdUser tdUser = service.queryById(user_id);
		/*pd = wm.findPositionByPidd(pd);	*/
		//通过会员id查会员类型
		TdUtype	memberType = memberTypeservice.queryById(tdUser.getUtypeId());
		//会员类型列表
		List<TdUtype> listTdUtype=  memberTypeservice.queryAll();
		
		TdUser tdUserManager= service.queryById(tdUser.getUsermanagerUid());
		TdUser tdUserReferee= service.queryById(tdUser.getUserrefereeUid());
		if(tdUserManager!=null) {
			tdUser.setUsermanagerName(tdUserManager.getuNickname());			
		}
		if(tdUserReferee!=null) {
			tdUser.setUserrefereeName(tdUserReferee.getuNickname());
		}
		mv.setViewName("system/tdUser/tdUser_edit");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		mv.addObject("listTdUtype", listTdUtype);
		mv.addObject("memberType", memberType);
		mv.addObject("tdUser", tdUser);
		return mv;
	}
	/*
	 * 执行修改用户
	 */
	@RequestMapping(value="/editTdUserByUid")
	public ModelAndView editTdUserByUid() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改");
		
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		TdUser tdUser = new TdUser();
	    String userId = pd.getString("userId");
	    TdUser tdUser2 = service.queryById(userId);
	    FHLOG.save(Jurisdiction.getUsername(), "修改用户"+tdUser2.getuNickname()+"的信息");
		
		String uName = pd.getString("uName");
		String uPhone = pd.getString("uPhone");
		String utypeId = pd.getString("utypeId");
		String memberid = pd.getString("memberid");
		String creditrdNums = pd.getString("creditrdNum");
		/*Tools.isEmpty(creditrdNums);*/
		if(null!=creditrdNums&&!"".equals(creditrdNums)) {			
			Integer creditrdNum = Integer.parseInt(creditrdNums);
			tdUser.setCreditrdNum(creditrdNum);
		}
		//判断通过推荐人姓名，查找推荐人id
		String userrefereeName = pd.getString("userrefereeName");
		TdUser tdUsers = new TdUser();
		tdUsers.setuName(userrefereeName);
		TdUser tdUserReferee = service.queryOne(tdUsers);
		if(tdUserReferee!=null) {
			tdUser.setUserrefereeUid(tdUserReferee.getUserId());
		}
		//通过客户经理姓名，查找推荐人id
		String usermanagerName = pd.getString("usermanagerName");
		TdUser tdUsers2 = new TdUser();
		tdUsers2.setuName(usermanagerName);
		TdUser TdUserManager = service.queryOne(tdUsers2);
		if(TdUserManager!=null) {
			tdUser.setUsermanagerUid(TdUserManager.getUserId());
		}
		//时间String转化为int类型
		String memberDayss = pd.getString("memberDays");
		if(null!=memberDayss&&!"".equals(memberDayss)) {
			Integer memberDays = Integer.parseInt(memberDayss);
			tdUser.setMemberDays(memberDays);
		}
		//体验String转化为int类型
		String resourceStrategyIsexperiences = pd.getString("resourceStrategyIsexperience");
		if(null!=resourceStrategyIsexperiences&&!"".equals(resourceStrategyIsexperiences)) {
			Integer resourceStrategyIsexperience = Integer.parseInt(resourceStrategyIsexperiences);
			tdUser.setResourceStrategyIsexperience(resourceStrategyIsexperience);
		}
		String remark = pd.getString("remark");
		
		tdUser.setUserId(userId);
		tdUser.setuName(uName);
		tdUser.setuPhone(uPhone);
		tdUser.setUtypeId(utypeId);
		tdUser.setMemberid(memberid);
		
		
		
		tdUser.setRemark(remark);
	
		service.updateSelective(tdUser);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	/*
	 *跳转到添加用户界面//暂时不用
	 *goAddUser
	 */
	@RequestMapping(value="/goAddUser")
	public ModelAndView goAddUser(Page page)throws Exception{
/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
*/		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/tdUser/tdUser_add");
		mv.addObject("msg", "saveU");
		mv.addObject("pd", pd);
		return mv;
	}
	
	/*
	 * 查封用户状态
	 * updateUserClosedDoorState
	 */
	@RequestMapping(value="/updateUserClosedDoorState")
	public ModelAndView updateUserClosedDoorState() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String user_id = pd.getString("user_id");
		TdUser tdActivity = service.queryById(user_id);
		String closedUserStatuss = pd.getString("closed_user_status");
		Integer closedUserStatus = Integer.parseInt(closedUserStatuss);
		if(closedUserStatus==0) {	
			FHLOG.save(Jurisdiction.getUsername(), "查封用户"+tdActivity.getuNickname());

/*			logBefore(logger, Jurisdiction.getUsername()+"修改"+tdActivity.getActivityName()+"活动状态:上架活动");
*/		}else {
			FHLOG.save(Jurisdiction.getUsername(), "解封用户"+tdActivity.getuNickname());

/*			logBefore(logger, Jurisdiction.getUsername()+"修改"+tdActivity.getActivityName()+"活动状态：下架活动");
*/
		}
	
		service.updateActivityState(user_id,closedUserStatus);
		
		mv.setViewName("save_result");
		return mv;
	}
	
	/*
	 * 用户锁定管理列表
	 * listResourceLocking
	 * 
	 */
	@RequestMapping(value="listResourceLocking")
	public ModelAndView listResourceLocking(Page page)throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("USERNAME",Jurisdiction.getUsername());
		PageData user=this.um.findByUsername(pd);//通过用户名找出用户
		
		
	    String open_id = pd.getString("open_id");
		//微信号名称
		if(null!=open_id&&!"".equals(open_id)) {
			pd.put("open_id", open_id);
		
			page.setPd(pd);			
		}
	
		//用户未激活
		pd.put("user_isactivation", 0);
		page.setPd(pd);
			List<PageData> listTdUser = this.sqlService.getAllTdUser(page);
		  for(int i=0;i<listTdUser.size();i++) {
			  PageData tdUser3 = listTdUser.get(i);
		    	if(tdUser3.getString("userReferee_uid")!=null) {	    		
		    		TdUser tdUserReferee = service.queryById(tdUser3.getString("userReferee_uid"));
		    		if(tdUserReferee!=null) {		    			
		    			tdUser3.put("userRefereeName",tdUserReferee.getuNickname() ) ; 
		    		}
		    	}
		    	if(tdUser3.getString("userManager_uid")!=null) {
		    		TdUser tdUserManager = service.queryById(tdUser3.getString("userManager_uid"));
		    		if(tdUserManager!=null) {
		    			tdUser3.put("userManagerName", tdUserManager.getuNickname()); 
		    		}
		    	}
			}
			mv.setViewName("system/tdUser/tdUserResourceLocking_list");
		    mv.addObject("listTdUser",listTdUser);
			mv.addObject("QX",Jurisdiction.getHC());//按钮权限
			mv.addObject("pd", pd);
		return mv;
	}
	/*
	 * 修改用户资源锁定，跳转到修改界面
	 * goEditUserResourceLocking
	 */
	@RequestMapping(value="/goEditUserResourceLocking")
	public ModelAndView goEditUserResourceLocking() throws Exception{
/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
*/		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		
		String user_id = pd.getString("user_id");
		TdUser tdUser = service.queryById(user_id);
		/*pd = wm.findPositionByPidd(pd);	*/
		/*//通过会员id查会员类型
		TdUtype	memberType = memberTypeservice.queryById(tdUser.getUtypeId());
		//会员类型列表
		List<TdUtype> listTdUtype=  memberTypeservice.queryAll();*/
		
		TdUser tdUserManager= service.queryById(tdUser.getUsermanagerUid());
		TdUser tdUserReferee= service.queryById(tdUser.getUserrefereeUid());
		if(tdUserManager!=null) {
			tdUser.setUsermanagerName(tdUserManager.getuNickname());
		
		}
		if(tdUserReferee!=null) {
			tdUser.setUserrefereeName(tdUserReferee.getuNickname());
			tdUser.setUserrefereememberid(tdUserReferee.getMemberid());
		}
		mv.setViewName("system/tdUser/tdUserResourceLocking_edit");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		/*mv.addObject("listTdUtype", listTdUtype);
		mv.addObject("memberType", memberType);*/
		mv.addObject("tdUser", tdUser);
		return mv;
	}
	/**
	 * 执行修改用户资源锁定
	 * editTdUserResourceLockingByUid
	 */
	@RequestMapping(value="/editTdUserResourceLockingByUid")
	public ModelAndView editTdUserResourceLockingByUid() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改");
		
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		TdUser tdUser = new TdUser();
	    String userId = pd.getString("userId");
	    TdUser tdUser2 = service.queryById(userId);
	    FHLOG.save(Jurisdiction.getUsername(), "修改用户"+tdUser2.getuNickname()+"资源锁定的信息");
		
	
	    /*
	     * 通过会员号查询  推荐人用户id
	     */
		String memberid = pd.getString("memberid");
		
		TdUser tdUsers3 = new TdUser();
		tdUsers3.setMemberid(memberid);
		TdUser tdUserReferee = service.queryOne(tdUsers3);
		if(tdUserReferee!=null) {
			
			
			tdUser.setUserrefereeUid(tdUserReferee.getUserId());
		}
	
		String remark = pd.getString("remark");
		
		tdUser.setUserId(userId);
		
		tdUser.setRemark(remark);
		
		service.updateSelective(tdUser);
     	mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	/*
	 * 通过会员号获取该会员的姓名
	 * ByMemberidFindUserrefereeName
	 */
	@RequestMapping(value="/ByMemberidFindUserrefereeName")
	public String ByMemberidFindUserrefereeName(HttpServletResponse response,HttpServletRequest request) throws Exception {
	String memberid=request.getParameter("memberid");

	
	TdUser tdUser = new TdUser();
	tdUser.setMemberid(memberid);
	TdUser TdUser = service.queryOne(tdUser);
	//解析集合用的方法
/*	JSONArray json = new JSONArray();*/
	
       /*  JSONObject jo = new JSONObject();
         jo.put("citycode", pLog.getCitycode());
         jo.put("pidcode", pLog.getPidcode());
         jo.put("cityname", pLog.getCityname());*/
	JSONObject json = new JSONObject();
	json.put("uNickname", TdUser.getuNickname());
      /*   json.add(jo);*/
    
	System.out.println("memberid"+memberid);
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
