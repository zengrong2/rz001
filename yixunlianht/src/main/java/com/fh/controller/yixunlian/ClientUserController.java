package com.fh.controller.yixunlian;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

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
import com.fh.entity.system.User;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivityChargeItem;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdAddress;
import com.fh.lw.pojo.yixunlian.TdEngagendustry;
import com.fh.lw.pojo.yixunlian.TdEverjoin;
import com.fh.lw.pojo.yixunlian.TdHobbyAndactivitycategory;
import com.fh.lw.pojo.yixunlian.TdOrganizerInfo;
import com.fh.lw.pojo.yixunlian.TdOverJoinActivityTemp;
import com.fh.lw.pojo.yixunlian.TdUhobby;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.lw.pojo.yixunlian.TdUserCount;
import com.fh.lw.pojo.yixunlian.TdUserandhobby;
import com.fh.lw.pojo.yixunlian.TdUserandpersonalneeds;
import com.fh.lw.pojo.yixunlian.TdUtype;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.ActivityTypeService;
import com.fh.service.yixunlian.ClientUserAndHobbyService;
import com.fh.service.yixunlian.ClientUserAndPersonalNeedsService;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.ClientUserSqlManager;
import com.fh.service.yixunlian.EngageIndustryService;
import com.fh.service.yixunlian.EverjoinActivityService;
import com.fh.service.yixunlian.MemberTypeService;
import com.fh.service.yixunlian.OrganizerInfoService;
import com.fh.service.yixunlian.TdAddressService;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.fh.util.Tools;
import com.github.pagehelper.PageHelper;
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
	@Autowired
	private OrganizerInfoService organizerInfoService;
	@Autowired
	private EngageIndustryService engageIndustryService;
	//会员类型通用service
	@Autowired
	private MemberTypeService memberTypeservice;
	//用户和兴趣爱好的第三方表
	@Autowired
	private ClientUserAndHobbyService clientUserAndHobbyService;
	//用户和需求的第三方表
	@Autowired
	private ClientUserAndPersonalNeedsService clientUserAndPersonalNeedsService;
	//曾经参与
	@Autowired
	private EverjoinActivityService everjoinActivityService;
	//活动
	@Autowired
	private ActivityService activityService;
	//活动类型
	@Autowired
	private ActivityTypeService activityTypeService;
	//地址
	@Autowired
	private TdAddressService tdAddressService;
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
		String registerStart = "";
		String start=pd.getString("start");
		if(start!=null && !"".equals(start)) {
			
			registerStart=start+" 00:00:00";
		}
		pd.put("registerStart", registerStart);
		String end=pd.getString("end");
		String registerEnd = "";
		if(end !=null && !"".equals(end)) {
	
		registerEnd=end+" 23:59:59";
		}
		pd.put("registerEnd", registerEnd);
		//会员升级时间 memberStart
		String memberStart=pd.getString("memberStart");
		String memberStartTime = "";
		if(memberStart!=null && !"".equals(memberStart)) {
			
			memberStartTime=memberStart+" 00:00:00";
		}
		pd.put("memberStartTime", memberStartTime);
		
		String memberEnd=pd.getString("memberEnd");
		String memberEndTime = "";
		if(memberEnd!=null && !"".equals(memberEnd)) {
			
			memberEndTime=memberEnd+" 00:00:00";
		}
		pd.put("memberEndTime", memberEndTime);
		//会员等级
		String UType_IDs = pd.getString("UType_IDs");
		if(!"".equals(UType_IDs)&&UType_IDs!=null) {
			pd.put("UType_IDs", UType_IDs);
		}
		//用户区域
		String cityCode_IDs = pd.getString("cityCode_IDs");
		if(!"".equals(cityCode_IDs)&&cityCode_IDs!=null) {
			pd.put("cityCode_IDs", cityCode_IDs);
		}
	/*	if(start!=null && !"".equals(start)) {
			start=start.replace(" 00:00:00","");
			pd.put("start", start);
			}
			if(end !=null && !"".equals(end)) {
			end=end.replace(" 23:59:59", "");
			pd.put("end", end);
			}*/
		//已经激活用户的列表
		pd.put("user_isactivation", 2);
		page.setPd(pd);
		if("3f9660f63a6b4d4cbf51a2bc455ca497".equals(user.getString("ROLE_ID"))) {			
			String citycode = user.getString("citycode");
			pd.put("citycode", citycode);
			page.setPd(pd);
		}
		//搜索运用中心
		String USER_IDs = pd.getString("USER_IDs");
		if(!"".equals(USER_IDs)&&USER_IDs!=null) {
			pd.put("userManager_uid", USER_IDs);
			page.setPd(pd);
		}
	List<PageData> listTdUser = this.sqlService.getAllTdUser(page);
		  for(int i=0;i<listTdUser.size();i++) {
			  PageData tdUser3 = listTdUser.get(i);
			  int isJoinTrain = service.getIsJoinTrain(tdUser3.getString("user_id"));
			  //是否参加应用培训
			  tdUser3.put("isJoinTrain", isJoinTrain);
			  //省市区  省
			  if(!"".equals(tdUser3.getString("province_citycode"))&&tdUser3.getString("province_citycode")!=null) {
				  TdAddress tdAddressProvince = tdAddressService.queryById(tdUser3.getString("province_citycode"));				  
				 if(tdAddressProvince!=null) {
					 tdUser3.put("ProvCityName", tdAddressProvince.getCityname());					 
				 }
			  }//市
			  if(!"".equals(tdUser3.getString("city_citycode"))&&tdUser3.getString("city_citycode")!=null) {
				  TdAddress tdAddressProvince = tdAddressService.queryById(tdUser3.getString("city_citycode"));				  
				  if(tdAddressProvince!=null) {
					  tdUser3.put("CityCityName", tdAddressProvince.getCityname());					  
				  }
			  }//区县
			  if(!"".equals(tdUser3.getString("area_citycode"))&&tdUser3.getString("area_citycode")!=null) {
				  TdAddress tdAddressProvince = tdAddressService.queryById(tdUser3.getString("area_citycode"));				  
				 if(tdAddressProvince!=null) {
					 tdUser3.put("AreaCityName", tdAddressProvince.getCityname());
					 
				 }
			  }
			  if(tdUser3.getString("utype_id")!=null) {
				  TdUtype TdUtype =  new TdUtype();
				  TdUtype.setUtypeId(tdUser3.getString("utype_id"));
				  TdUtype tdUtype = memberTypeservice.queryOne(TdUtype);
				  if(tdUtype!=null) {
					  tdUser3.put("userType", tdUtype.getUserType());
				  }
			  }
			  
		    	if(tdUser3.getString("userReferee_uid")!=null) {	    		
		    		TdUser tdUserReferee = service.queryById(tdUser3.getString("userReferee_uid"));
		    		if(tdUserReferee!=null) {		    			
		    			tdUser3.put("userRefereeName",tdUserReferee.getuNickname() ) ; 
		    		}else {
		    			//推荐人为运营中心
		    			pd.put("USER_ID", tdUser3.getString("userReferee_uid"));
		    			PageData sysUser=this.um.findById(pd);//通过系统用户id找出用户
		    			if(sysUser!=null) {	   
		    			tdUser3.put("userRefereeName", sysUser.getString("NAME"));
		    			}
		    	 }
		    		
		    	}
		    	if(tdUser3.getString("userManager_uid")!=null) {
		    		TdUser tdUserManager = service.queryById(tdUser3.getString("userManager_uid"));
		    		if(tdUserManager!=null) {
		    			tdUser3.put("userManagerName", tdUserManager.getuNickname()); 
		    		}else {
		    			//归属人为运营中心
		    			pd.put("USER_ID", tdUser3.getString("userManager_uid"));
		    			PageData sysUser=this.um.findById(pd);//通过系统用户id找出用户
		    			if(sysUser!=null) {	   
		    			tdUser3.put("userManagerName", sysUser.getString("NAME"));
		    			}
		    	  }
		    	}
			}
		  //不同级别用户统计数量
		  TdUserCount tdUserCount = service.getTdUserCount();
		 
		  //运营中心
		  pd.put("ROLE_ID", "3f9660f63a6b4d4cbf51a2bc455ca497");
		  List<User> listOperationCenter1 = um.listUserByRoldId(pd);
	      //总运营中心
		  pd.put("ROLE_ID", "6f65db38cda342d792f94c3ccc615d5b");
		  List<User> listOperationCenter2 = um.listUserByRoldId(pd);
		  List<User> listOperationCenter = new ArrayList<>();
		  listOperationCenter.addAll(listOperationCenter2);
		  listOperationCenter.addAll(listOperationCenter1);
		  //所有的会员等级
		 List<TdUtype>  listTdUtype=  memberTypeservice.queryAll();
		 //所有的地区
		 List<TdAddress> listTdAddress = tdAddressService.queryAll();
			mv.setViewName("system/tdUser/tdUser_list");
		    mv.addObject("listTdUser",listTdUser);
			mv.addObject("QX",Jurisdiction.getHC());//按钮权限
			mv.addObject("listOperationCenter", listOperationCenter);
			mv.addObject("pd", pd);
			mv.addObject("tdUserCount", tdUserCount);
			mv.addObject("listTdUtype", listTdUtype);
			mv.addObject("listTdAddress", listTdAddress);
		return mv;
	}
	/*
	 * 显示用户详情
	 * showTdUserDetailById
	 */
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping(value="showTdUserDetailById")
	public ModelAndView showTdUserDetailById(){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
				pd = this.getPageData();			
				String user_id = pd.getString("user_id");
				TdUser tdUser = service.queryById(user_id);
				
				if(!"".equals(tdUser.getCreditrdNum())&&tdUser.getCreditrdNum()!=null) {
					tdUser.setCreditrdNumArray(changeCreditrdNum(tdUser.getCreditrdNum()));										
				}
				TdUser tdUserManager= service.queryById(tdUser.getUsermanagerUid());
				TdUser tdUserReferee= service.queryById(tdUser.getUserrefereeUid());
				if(tdUserManager!=null) {
					tdUser.setUsermanagerName(tdUserManager.getuNickname());			
				}else {
	    			//推荐人为运营中心
	    			pd.put("USER_ID", tdUser.getUsermanagerUid());
	    			PageData sysUser=this.um.findById(pd);//通过系统用户id找出用户
	    			if(sysUser!=null) {	    				
	    				tdUser.setUsermanagerName(sysUser.getString("NAME"));	
	    			}
	    		}
				if(tdUserReferee!=null) {
					tdUser.setUserrefereeName(tdUserReferee.getuNickname());
				}else {
	    			//归属人为运营中心
	    			pd.put("USER_ID", tdUser.getUserrefereeUid());
	    			PageData sysUser=this.um.findById(pd);//通过系统用户id找出用户
	    			if(sysUser!=null) {	  
	    			tdUser.setUserrefereeName(sysUser.getString("NAME"));			
	    			}
	    	   }
				//通过会员id查会员类型
				TdUtype	memberType = memberTypeservice.queryById(tdUser.getUtypeId());
				TdEngagendustry tdEngagendustry = engageIndustryService.queryById(tdUser.getEgidId());
				//资源库人数
				int  countResouseP = service.getCountResousep(user_id);
				//兴趣爱好
				List<TdUserandhobby> listTdUserandhobby = this.clientUserAndHobbyService.getListTdUserandhobby(user_id);
				//个人需求
				List<TdUserandpersonalneeds> listTdUserandpersonalneeds = this.clientUserAndPersonalNeedsService.getListTdUserandpersonalneeds(user_id);
				//曾经参与
				TdEverjoin tdEverjoin = new TdEverjoin();
				tdEverjoin.setUserId(user_id);
				//用户参加过的集合
				List<TdEverjoin> tdEverjoinList = everjoinActivityService.queryListByWhere(tdEverjoin);
				Map<String,String> mapCategoryId = new HashMap<>();
			    List<TdActivity> listTdActivity = new ArrayList<>();
			    TdActivity tdActivity = new TdActivity();		 
			    for (TdEverjoin tdEverjoin2 : tdEverjoinList) {
			    	//通过活动id查找用户参加的活动
			    	tdActivity.setActivityId(tdEverjoin2.getActivityId());				
					TdActivity tdActivity2 = activityService.queryOne(tdActivity);
					listTdActivity.add(tdActivity2);
					//活动类别id去重，然后存放map里面
					mapCategoryId.put(tdEverjoin2.getActivitycategoryId(), tdEverjoin2.getActivitycategoryId());
			 
				}
				Set<Entry<String,String>> set = mapCategoryId.entrySet();
				//参加活动类别，参加次数，临时存放对象的集合
				List<TdOverJoinActivityTemp> tdOverJoinActivityTempList =new ArrayList<>();
				for (Entry<String, String> entry : set) { 
					TdOverJoinActivityTemp tdOverJoinActivityTemp = new TdOverJoinActivityTemp();
					tdEverjoin.setActivitycategoryId(entry.getKey());
					//通过用户id和活动类型id查询参加该类型多少次
					int overCount = everjoinActivityService.queryTotalCount(tdEverjoin);
					//通过活动类别id查到活动类别名字
					TdActivitycategory tdActivitycategory = activityTypeService.queryById(entry.getKey());
					//把参加活动类别，参加次数，放到临时存放对象里面
					tdOverJoinActivityTemp.setJoinCount(overCount);
					tdOverJoinActivityTemp.setActivityCategoryName(tdActivitycategory.getActivitycategoryName());
					tdOverJoinActivityTempList.add(tdOverJoinActivityTemp);
				}
			    	mv.addObject("listTdUserandhobby",listTdUserandhobby);
				    mv.addObject("listTdUserandpersonalneeds",listTdUserandpersonalneeds);
					mv.addObject("listTdActivity",listTdActivity);
					mv.addObject("tdOverJoinActivityTempList",tdOverJoinActivityTempList);
					mv.addObject("tdUser",tdUser);
					mv.addObject("tdEngagendustry",tdEngagendustry);
					mv.setViewName("system/tdUser/tdUserInfo_detail");
					mv.addObject("memberType",memberType);
					mv.addObject("countResouseP",countResouseP);
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
		////如果已经体验Vip则查询不包含体验vip的
		List<TdUtype> listTdUtype =new ArrayList<>();
		if(tdUser.getResourceStrategyIsexperience()==2) {
			listTdUtype = memberTypeservice.getNotExpUType();
		}//如果没有体验Vip则查询所有
		else {			
			listTdUtype=  memberTypeservice.queryAll();
		}
		
		TdUser tdUserManager= service.queryById(tdUser.getUsermanagerUid());
		TdUser tdUserReferee= service.queryById(tdUser.getUserrefereeUid());
		if(tdUserManager!=null) {
			tdUser.setUsermanagerName(tdUserManager.getuNickname());
			tdUser.setUsermanagermemberid(tdUserManager.getMemberid());
		}else {
			//推荐人为运营中心
			pd.put("USER_ID", tdUser.getUsermanagerUid());
			PageData sysUser=this.um.findById(pd);//通过系统用户id找出用户
			if(sysUser!=null) {	   
			tdUser.setUsermanagerName(sysUser.getString("NAME"));	
			}
	   }
		if(tdUserReferee!=null) {
			tdUser.setUserrefereeName(tdUserReferee.getuNickname());
			tdUser.setUserrefereememberid(tdUserReferee.getMemberid());
		}else {
			//归属人为运营中心
			pd.put("USER_ID", tdUser.getUserrefereeUid());
			PageData sysUser=this.um.findById(pd);//通过系统用户id找出用户
			if(sysUser!=null) {	   
			tdUser.setUserrefereeName(sysUser.getString("NAME"));
		
			}
	   }
		
		 //运营中心
		  pd.put("ROLE_ID", "3f9660f63a6b4d4cbf51a2bc455ca497");
		  List<User> listOperationCenter1 = um.listUserByRoldId(pd);
	      //总运营中心
		  pd.put("ROLE_ID", "6f65db38cda342d792f94c3ccc615d5b");
		  List<User> listOperationCenter2 = um.listUserByRoldId(pd);
		  List<User> listOperationCenter = new ArrayList<>();
		  listOperationCenter.addAll(listOperationCenter2);
		  listOperationCenter.addAll(listOperationCenter1);
		mv.setViewName("system/tdUser/tdUser_edit");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		mv.addObject("listOperationCenter", listOperationCenter);
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
		
		String u_nickname = pd.getString("uName");
		String uPhone = pd.getString("uPhone");
		//修改会员类型id
		String utypeId = pd.getString("utypeId");
		//会员天数String
		String memberDayss = pd.getString("memberDays");
		//会员天数转为int
		Integer memberDays = 0;
		if(null!=memberDayss&&!"".equals(memberDayss)) {
			 memberDays = Integer.parseInt(memberDayss);
        }
		
		//一：如果修改的会员类型id为普通用户id为1
		if("1".equals(utypeId)) {
			//1:如果之前的会员类型id为1
			if("1".equals(tdUser2.getUtypeId())) {
				tdUser.setUtypeId(utypeId);
				tdUser.setMemberDays(0);
				
			}//2:如果之前的会员类型id为2,3,5,6，会员非体验
			else if("2".equals(tdUser2.getUtypeId())||"3".equals(tdUser2.getUtypeId())||
					"5".equals(tdUser2.getUtypeId())||"6".equals(tdUser2.getUtypeId())) {
			  	findManagerCenter(userId,0);
			  	tdUser.setUtypeId(utypeId);
				tdUser.setMemberDays(0);
				tdUser.setExperienceEndTime(getLocalTime());
				tdUser.setMemberEndTime(getLocalTime());
				tdUser.setIsVip(0);
				tdUser.setUtypeName("普通会员");
				
				
			}//3:如果之前的会员类型id为4,vip体验
			else if("4".equals(tdUser2.getUtypeId())) {
			 	findManagerCenter(userId,1);
			  	tdUser.setUtypeId(utypeId);
				tdUser.setMemberDays(0);
				
				tdUser.setExperienceEndTime(getLocalTime());
				tdUser.setMemberEndTime(getLocalTime());
				tdUser.setIsVip(0);
				tdUser.setUtypeName("普通会员");
				tdUser.setResourceStrategyIsexperience(2);
			}
		}//二：如果修改的会员类型id为4体验vip 
		else if("4".equals(utypeId)) {
			//1:如果之前的会员类型id为1
			if("1".equals(tdUser2.getUtypeId())) {
				tdUser.setUtypeId(utypeId);
				tdUser.setUtypeName("VIP体验客户经理");
				tdUser.setMemberDays(memberDays);
				//如果改为体验，之前会员结束时间改为当前
				tdUser.setMemberEndTime(getLocalTime());
				tdUser.setExperienceTime(getLocalTime());
				tdUser.setExperienceEndTime(fixTimeByDays(getLocalTime(), 1, memberDays));
				tdUser.setIsVip(1);
				tdUser.setResourceStrategyIsexperience(1);
			}//2:如果之前的会员类型id为2,3,5,6，会员非体验
			else if("2".equals(tdUser2.getUtypeId())||"3".equals(tdUser2.getUtypeId())||
					"5".equals(tdUser2.getUtypeId())||"6".equals(tdUser2.getUtypeId())) {
				tdUser.setUtypeId(utypeId);
			
				tdUser.setUtypeName("VIP体验客户经理");
				tdUser.setMemberDays(memberDays);
				//如果改为体验，之前会员结束时间改为当前
				tdUser.setMemberEndTime(getLocalTime());
				tdUser.setExperienceTime(getLocalTime());
				tdUser.setExperienceEndTime(fixTimeByDays(getLocalTime(), 1, memberDays));
				tdUser.setIsVip(1);
				tdUser.setResourceStrategyIsexperience(1);
			}//3:如果之前的会员类型id为4,vip体验,
			else if("4".equals(tdUser2.getUtypeId())) {
				tdUser.setResourceStrategyIsexperience(1);
				tdUser.setMemberDays(memberDays);
				//如果改为体验，之前会员结束时间改为当前
				tdUser.setMemberEndTime(getLocalTime());
				if(memberDays==0) {
					tdUser.setUtypeId("1");
					tdUser.setUtypeName("普通用户");
				
					tdUser.setExperienceEndTime(getLocalTime());
					tdUser.setIsVip(0);
					//自动归属，向上紧缩,如果当前用户类型为体验vip  《
					
				}
				//如果修改天数大于之前天数则加
				else if(memberDays>tdUser2.getMemberDays()&&tdUser2.getMemberDays()>=0) {
					int countFinalDays = memberDays-tdUser2.getMemberDays();
					tdUser.setExperienceEndTime(fixTimeByDays(tdUser2.getExperienceEndTime(), 1, countFinalDays));
					tdUser.setIsVip(1);
					tdUser.setUtypeId(utypeId);
					tdUser.setUtypeName("VIP体验客户经理");
				
				}//如果修改天数小于之前天数则加
				else if(tdUser2.getMemberDays()>=memberDays&&memberDays>0) {
					int countFinalDays = tdUser2.getMemberDays()-memberDays;
					tdUser.setExperienceEndTime(fixTimeByDays(tdUser2.getExperienceEndTime(), 0, countFinalDays));
					tdUser.setIsVip(1);
					tdUser.setUtypeId(utypeId);
					tdUser.setUtypeName("VIP体验客户经理");
					
				}
			}
		}//三：如果修改的会员类型id为2，3，5，6vip
		else if("2".equals(utypeId)||"3".equals(utypeId)||"5".equals(utypeId)||"6".equals(utypeId)) {
			//1:如果之前的会员类型id为1
			if("1".equals(tdUser2.getUtypeId())) {
				tdUser.setUtypeId(utypeId);
				tdUser.setMemberDays(memberDays);
				if("6".equals(utypeId)) {
					tdUser.setIsVip(1);
					tdUser.setUtypeName("钻石客户经理");
				}
				if("2".equals(utypeId)) {
					tdUser.setIsVip(1);
					tdUser.setUtypeName("普通客户经理");
				}
				if("3".equals(utypeId)) {
					tdUser.setIsVip(1);
					tdUser.setUtypeName("VIP客户经理");
				}
				if("5".equals(utypeId)) {
					tdUser.setIsVip(1);
					tdUser.setUtypeName("VIP试用客户经理");
				}
				//如果改为vip，体验结束时间变为当前
				tdUser.setExperienceEndTime(getLocalTime());
				tdUser.setMemberStartTime(getLocalTime());	
				tdUser.setMemberEndTime(fixTimeByDays(getLocalTime(), 1, memberDays));
			
			}//2:如果之前的会员类型id为2,3,5,6，会员非体验
			else if("2".equals(tdUser2.getUtypeId())||"3".equals(tdUser2.getUtypeId())||
					"5".equals(tdUser2.getUtypeId())||"6".equals(tdUser2.getUtypeId())) {
				tdUser.setMemberDays(memberDays);
				tdUser.setUtypeId(utypeId);
				tdUser.setMemberEndTime(getLocalTime());
				//如果改为vip，体验结束时间变为当前
				tdUser.setExperienceEndTime(getLocalTime());
				//修改天数大于之前天数
				if(tdUser2.getMemberDays()<memberDays&&tdUser2.getMemberDays()>=0) {
					int curmemberDays = memberDays-tdUser2.getMemberDays();						
					tdUser.setMemberEndTime(fixTimeByDays(tdUser2.getMemberEndTime(), 1, curmemberDays));
				}
				//修改天数小于等于之前天数
				if(tdUser2.getMemberDays()>=memberDays&&memberDays>0) {
					int curmemberDays = tdUser2.getMemberDays()-memberDays;		
					tdUser.setMemberEndTime(fixTimeByDays(tdUser2.getMemberEndTime(), 0, curmemberDays));
				}
				if("2".equals(utypeId)) {
					
					tdUser.setUtypeName("普通客户经理");
					tdUser.setIsVip(1);
				
				}else if("3".equals(utypeId)) {
					tdUser.setUtypeName("VIP客户经理");
					tdUser.setIsVip(1);
				}else if("5".equals(utypeId)) {
					tdUser.setUtypeName("VIP试用客户经理");
					tdUser.setIsVip(1);
					
				}else if("6".equals(utypeId)) {
					tdUser.setUtypeName("钻石客户经理");
					tdUser.setIsVip(1);
				}
				if(memberDays==0) {
					tdUser.setUtypeId("1");
					tdUser.setUtypeName("普通用户");					
					tdUser.setIsVip(0);
					tdUser.setMemberEndTime(getLocalTime());
				}
				
			}//3:如果之前的会员类型id为4,vip体验
			else if("4".equals(tdUser2.getUtypeId())) {
				//如果改为vip，体验结束时间变为当前
				tdUser.setExperienceEndTime(getLocalTime());
				tdUser.setResourceStrategyIsexperience(2);
                   if("2".equals(utypeId)) {
					
					tdUser.setUtypeName("普通客户经理");
					tdUser.setIsVip(1);
				
				}else if("3".equals(utypeId)) {
					tdUser.setUtypeName("VIP客户经理");
					tdUser.setIsVip(1);
				}else if("5".equals(utypeId)) {
					tdUser.setUtypeName("VIP试用客户经理");
					tdUser.setIsVip(1);
					
				}else if("6".equals(utypeId)) {
					tdUser.setUtypeName("钻石客户经理");
					tdUser.setIsVip(1);
				}
				
				tdUser.setUtypeId(utypeId);
				
				tdUser.setMemberStartTime(getLocalTime());
				tdUser.setMemberDays(memberDays);
			    tdUser.setMemberEndTime(fixTimeByDays(getLocalTime(), 1, memberDays));
			   
				
			}
		}

		String memberid = pd.getString("memberid");
		String creditrdNums = pd.getString("creditrdNum");
		/*Tools.isEmpty(creditrdNums);*/
		if(null!=creditrdNums&&!"".equals(creditrdNums)) {			
			Integer creditrdNum = Integer.parseInt(creditrdNums);
			tdUser.setCreditrdNum(creditrdNum);
		}
	
		
		//通过客户经理会员号，查找推荐人id
		//推荐人为运营中心
		//判断通过推荐人会员号，查找推荐人id
		String userrefereeName = pd.getString("userrefereeName");
		String usermanagerName = pd.getString("userManagerUids");
		String USER_IDs = pd.getString("USER_IDs");
/*		System.out.println("q"+userrefereeName+"w"+usermanagerName+"e"+USER_IDs);
*/
		
		if(!"".equals(USER_IDs)&&USER_IDs!=null) {
		User sysUser = um.getUserById(USER_IDs);
		//1先找到系统运营中心
		if(sysUser!=null) {
		
			tdUser.setUserrefereeUid(sysUser.getUSER_ID());
			tdUser.setUserrefereeName(sysUser.getNAME());
			tdUser.setUsermanagerUid(sysUser.getUSER_ID());
			tdUser.setUsermanagerName(sysUser.getNAME());
			  if(!tdUser2.getUsermanagerUid().equals(sysUser.getUSER_ID())) {
             	 tdUser.setResourceAddTime(getLocalTime());
             	
             }
			
		}else {
			//2如果系统运营中心找不到，则根据推荐人找到
			if(!"".equals(userrefereeName)) {
				
				TdUser tdUsers = new TdUser();
				/*tdUsers.setuName(userrefereeName);*/
				tdUsers.setMemberid(userrefereeName);
				TdUser tdUserReferee = service.queryOne(tdUsers);
				System.out.println("zz"+tdUserReferee.getUserId());
				if(tdUserReferee!=null) {
					//如果推荐人有资源库，则该修改的用户的推荐人和归属人都为这个推荐人
					if("2".equals(tdUserReferee.getUtypeId())||"3".equals(tdUserReferee.getUtypeId())
							||"4".equals(tdUserReferee.getUtypeId())||"5".equals(tdUserReferee.getUtypeId())
							||"6".equals(tdUserReferee.getUtypeId())) {
						        tdUser.setUserrefereeUid(tdUserReferee.getUserId());
						        tdUser.setUserrefereeName(tdUserReferee.getuNickname());
								tdUser.setUsermanagerUid(tdUserReferee.getUserId());	
								tdUser.setUsermanagerName(tdUserReferee.getuNickname());
								/*tdUser.setResourceAddTime(getLocalTime());*/
								
								 if(!tdUser2.getUsermanagerUid().equals(tdUserReferee.getUserId())) {
					             	 tdUser.setResourceAddTime(getLocalTime());
					             	
					             }
					}
					 //如果推荐人没有资源库的功能，则该修改的用户的推荐人改为该推荐人，则该修改的用户的归属人 给这个推荐人的归属人	
					 else if("1".equals(tdUserReferee.getUtypeId())) {
								  tdUser.setUserrefereeUid(tdUserReferee.getUserId());
							      tdUser.setUserrefereeName(tdUserReferee.getuNickname());
							      
							if(!"".equals(tdUserReferee.getUsermanagerUid())&&tdUserReferee.getUsermanagerUid()!=null) {
								  TdUser UserrefereeManager = service.queryById(tdUserReferee.getUsermanagerUid());
								  if(UserrefereeManager!=null) {
									  tdUser.setUsermanagerUid(UserrefereeManager.getUserId());	
									  tdUser.setUsermanagerName(UserrefereeManager.getuNickname());
/*									  tdUser.setResourceAddTime(getLocalTime());
 * 
*/								
									  if(!tdUser2.getUsermanagerUid().equals(UserrefereeManager.getUserId())) {
							             	 tdUser.setResourceAddTime(getLocalTime());
							             	
							             }
									  }else {
									  User finalSysUser = um.getUserById(tdUserReferee.getUsermanagerUid());
									 if(finalSysUser!=null) {
										  tdUser.setUsermanagerUid(finalSysUser.getUSER_ID());	
										  tdUser.setUsermanagerName(finalSysUser.getNAME());
										 
										  if(!tdUser2.getUsermanagerUid().equals(finalSysUser.getUSER_ID())) {
								             	 tdUser.setResourceAddTime(getLocalTime());
								             	
								             }
									 }else {

										 tdUser.setUsermanagerUid("ce6c9f55600e4602a2051ea130af74d8");	
										 tdUser.setUsermanagerName("总运营中心");
										  if(!tdUser2.getUsermanagerUid().equals("ce6c9f55600e4602a2051ea130af74d8")) {
								             	 tdUser.setResourceAddTime(getLocalTime());
								             	
								             }
										 
									 }
								  }
							}
							
							}
				}
			}
		}
	}else {
		
		if(!"".equals(userrefereeName)) {
		
			TdUser tdUsers = new TdUser();
			/*tdUsers.setuName(userrefereeName);*/
			tdUsers.setMemberid(userrefereeName);
			TdUser tdUserReferee = service.queryOne(tdUsers);
			if(tdUserReferee!=null) {
				//如果推荐人有资源库，则该修改的用户的推荐人和归属人都为这个推荐人
				if("2".equals(tdUserReferee.getUtypeId())||"3".equals(tdUserReferee.getUtypeId())
						||"4".equals(tdUserReferee.getUtypeId())||"5".equals(tdUserReferee.getUtypeId())
						||"6".equals(tdUserReferee.getUtypeId())) {
					        tdUser.setUserrefereeUid(tdUserReferee.getUserId());
					        tdUser.setUserrefereeName(tdUserReferee.getuNickname());
							tdUser.setUsermanagerUid(tdUserReferee.getUserId());	
							tdUser.setUsermanagerName(tdUserReferee.getuNickname());
/*							tdUser.setResourceAddTime(getLocalTime());
*/							
                            if(!tdUser2.getUsermanagerUid().equals(tdUserReferee.getUserId())) {
                            	 tdUser.setResourceAddTime(getLocalTime());
                            	
                            }
                           
                          
				}
				 //如果推荐人没有资源库的功能，则该修改的用户的推荐人改为该推荐人，则该修改的用户的归属人 给这个推荐人的归属人	
				 else if("1".equals(tdUserReferee.getUtypeId())) {
							  tdUser.setUserrefereeUid(tdUserReferee.getUserId());
						      tdUser.setUserrefereeName(tdUserReferee.getuNickname());
						if(!"".equals(tdUserReferee.getUsermanagerUid())&&tdUserReferee.getUsermanagerUid()!=null) {
							  TdUser UserrefereeManager = service.queryById(tdUserReferee.getUsermanagerUid());
							  if(UserrefereeManager!=null) {
								  tdUser.setUsermanagerUid(UserrefereeManager.getUserId());	
								  tdUser.setUsermanagerName(UserrefereeManager.getuNickname());
								 /* tdUser.setResourceAddTime(getLocalTime());*/
								  if(!tdUser2.getUsermanagerUid().equals(UserrefereeManager.getUserId())) {
		                            	 tdUser.setResourceAddTime(getLocalTime());
		                            	
		                            }
								 
							  }else {
								  User finalSysUser = um.getUserById(tdUserReferee.getUsermanagerUid());
									 if(finalSysUser!=null) {
										  tdUser.setUsermanagerUid(finalSysUser.getUSER_ID());	
										  tdUser.setUsermanagerName(finalSysUser.getNAME());
										  if(!tdUser2.getUsermanagerUid().equals(finalSysUser.getUSER_ID())) {
				                            	 tdUser.setResourceAddTime(getLocalTime());
				                            	
				                            }
										 
									 }else {
											
										 tdUser.setUsermanagerUid("ce6c9f55600e4602a2051ea130af74d8");	
										 tdUser.setUsermanagerName("总运营中心");
										  if(!tdUser2.getUsermanagerUid().equals("ce6c9f55600e4602a2051ea130af74d8")) {
				                            	 tdUser.setResourceAddTime(getLocalTime());
				                            	
				                            }
										
									 }
							  }
						}
						      
						}
			}
		}
		
	
	}
		
		
		String remark = pd.getString("remark");
		
		tdUser.setUserId(userId);
		/*tdUser.setuName(uName);*/
		tdUser.setuNickname(u_nickname);
		tdUser.setuPhone(uPhone);
		/*tdUser.setUtypeId(utypeId);*/
		tdUser.setMemberid(memberid);
		tdUser.setIsSpecialActivitytypeUser(Integer.parseInt(pd.getString("isSpecialActivitytypeUser")));
		
		
		tdUser.setRemark(remark);
	
		service.updateSelective(tdUser);
/*		service.updateTdActivityType(activitycategory_id,activitycategory_name,remark);	//执行修改,？？传参数	
*/		mv.addObject("msg","success");
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
		/*String keywords = pd.getString("keywords");
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
		String userRefereeName = pd.getString("userRefereeName");
		if(null!=userRefereeName&&!"".equals(userRefereeName)) {
			TdUser tdUser1 = new TdUser();
			tdUser1.setuName(userRefereeName);
			TdUser userReferee = service.queryOne(tdUser1);
			if(userReferee!=null) {
				pd.put("userReferee_uid", userReferee.getUserId());
				page.setPd(pd);
			}
		}
		String userManagerName = pd.getString("userManagerName");
		if(null!=userManagerName&&!"".equals(userManagerName)) {
			TdUser tdUser2 = new TdUser();
			tdUser2.setuName(userManagerName);
			TdUser userManager = service.queryOne(tdUser2);
			if(userManager!=null) {
				pd.put("userManager_uid", userManager.getUserId());
				page.setPd(pd);				
			}
		}*/
		//用户未激活
		pd.put("user_isactivation1", "0");
		
		page.setPd(pd);
			List<PageData> listTdUser = this.sqlService.getAllTdUser(page);
		  for(int i=0;i<listTdUser.size();i++) {
			  PageData tdUser3 = listTdUser.get(i);
		    	if(tdUser3.getString("userReferee_uid")!=null) {	    		
		    		TdUser tdUserReferee = service.queryById(tdUser3.getString("userReferee_uid"));
		    		if(tdUserReferee!=null) {		    			
		    			tdUser3.put("userRefereeName",tdUserReferee.getuNickname() ) ; 
		    		}else {
		    			//归属人为运营中心
		    			pd.put("USER_ID", tdUser3.getString("userReferee_uid"));
		    			PageData sysUser=this.um.findById(pd);//通过系统用户id找出用户
		    			if(sysUser!=null) {	 
		    			tdUser3.put("userRefereeName", sysUser.getString("NAME"));	
		    			}
		    	   }
		    	}
		    	if(tdUser3.getString("userManager_uid")!=null) {
		    		TdUser tdUserManager = service.queryById(tdUser3.getString("userManager_uid"));
		    		if(tdUserManager!=null) {
		    			tdUser3.put("userManagerName", tdUserManager.getuNickname()); 
		    		}else {
		    			//归属人为运营中心
		    			pd.put("USER_ID", tdUser3.getString("userManager_uid"));
		    			PageData sysUser=this.um.findById(pd);//通过系统用户id找出用户
		    			if(sysUser!=null) {	 
		    			tdUser3.put("userManagerName", sysUser.getString("NAME"));	
		    			}
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
		
		}else {
			//归属人为运营中心
			pd.put("USER_ID", tdUser.getUsermanagerUid());
			PageData sysUser=this.um.findById(pd);//通过系统用户id找出用户
			if(sysUser!=null) {	
			tdUser.setUsermanagerName(sysUser.getString("NAME"));
			
			}
	   }
		if(tdUserReferee!=null) {
			tdUser.setUserrefereeName(tdUserReferee.getuNickname());
			tdUser.setUserrefereememberid(tdUserReferee.getMemberid());
		}else {
			//归属人为运营中心
			pd.put("USER_ID", tdUser.getUserrefereeUid());
			PageData sysUser=this.um.findById(pd);//通过系统用户id找出用户
			if(sysUser!=null) {	
			tdUser.setUserrefereeName(sysUser.getString("NAME"));
			
			}
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
		
		/*String uName = pd.getString("uName");
		String uPhone = pd.getString("uPhone");
		String utypeId = pd.getString("utypeId");
		String memberid = pd.getString("memberid");
		String creditrdNums = pd.getString("creditrdNum");
		Tools.isEmpty(creditrdNums);
		if(null!=creditrdNums&&!"".equals(creditrdNums)) {			
			Integer creditrdNum = Integer.parseInt(creditrdNums);
			tdUser.setCreditrdNum(creditrdNum);
		}*/
		/*//判断通过推荐人姓名，查找推荐人id userrefereeName
		String userrefereeName = pd.getString("userrefereeName");
		TdUser tdUsers = new TdUser();
		tdUsers.setuName(userrefereeName);
		TdUser tdUserReferee = service.queryOne(tdUsers);
		if(tdUserReferee!=null) {
			tdUser.setUserrefereeUid(tdUserReferee.getUserId());
		}
		//通过客户经理姓名，查找推荐人id
		String usermanagerName = pd.getString("usermanagerName");
		TdUser tdUsers3 = new TdUser();
		tdUsers3.setuName(usermanagerName);
		TdUser TdUserManager = service.queryOne(tdUsers3);
		if(TdUserManager!=null) {
			tdUser.setUsermanagerUid(TdUserManager.getUserId());
		}*/
	    /*
	     * 通过会员号查询  推荐人用户id
	     */
		String memberid = pd.getString("memberid");
		/*if("".equals(memberid)&& memberid!=null) {*/
		TdUser tdUsers3 = new TdUser();
		
		tdUsers3.setMemberid(memberid);
		TdUser tdUserReferee = service.queryOne(tdUsers3);
		if(tdUserReferee!=null) {
	
			tdUser.setUserrefereeUid(tdUserReferee.getUserId());
			tdUser.setUsermanagerUid(tdUserReferee.getUserId());
			//修改资源锁定时间，只要tdUser.setUsermanagerUid(tdUserReferee.getUserId());就改
			 if(!tdUser2.getUsermanagerUid().equals(tdUserReferee.getUserId())) {
             	 tdUser.setResourceAddTime(getLocalTime());
             	
             }
			
		}
		
		/*//时间String转化为int类型
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
		}*/
		String remark = pd.getString("remark");
		
		tdUser.setUserId(userId);
		/*tdUser.setuName(uName);
		tdUser.setuPhone(uPhone);
		tdUser.setUtypeId(utypeId);
		tdUser.setMemberid(memberid);*/
		tdUser.setRemark(remark);		
		service.updateSelective(tdUser);
	/*	}*/
     	mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	//修改推荐人会员号
	//通过推荐人会员，查找推荐人的归属人，把这个归属人改为修改当前用户的归属人
	//1:先找推荐人，1如果推荐人有资源库能力，则推荐人和归属人都是这个人，
	//3如果没有，则该用户的推荐人为查询到的这个推荐人，该用户的归属人为，查询到的推荐人的归属人
	@RequestMapping(value="/byRefereeMemberidFindUserManagerName")
	public String byRefereeMemberidFindUserManagerName(HttpServletResponse response,HttpServletRequest request) throws Exception {
	String memberid=request.getParameter("memberid");
	TdUser tdUser = new TdUser();
	tdUser.setMemberid(memberid);
	//1推荐人
	TdUser tdUserReferee = service.queryOne(tdUser);
	/*User sysUser = um.getUserById(memberid);*/
	//解析集合用的方法
/*	JSONArray json = new JSONArray();*/
	
       /*  JSONObject jo = new JSONObject();
         jo.put("citycode", pLog.getCitycode());
         jo.put("pidcode", pLog.getPidcode());
         jo.put("cityname", pLog.getCityname());*/
	JSONObject json = new JSONObject();
	if(tdUserReferee!=null) {
		//2;推荐人有资源库，该用户的推荐人和归属人都是该推荐人
		if("2".equals(tdUserReferee.getUtypeId())||"3".equals(tdUserReferee.getUtypeId())
				||"4".equals(tdUserReferee.getUtypeId())||"5".equals(tdUserReferee.getUtypeId())
				||"6".equals(tdUserReferee.getUtypeId())) {
			
			json.put("userRefereeName",tdUserReferee.getuNickname());//推荐人姓名
			json.put("ManagerUserId",tdUserReferee.getUserId());//归属人id
			json.put("uNickname",tdUserReferee.getuNickname());//归属人姓名
		}//3：推荐人没有资源库，该用户的推荐人还是该推荐人，该用户的归属人，为推荐人的归属人
		else if("1".equals(tdUserReferee.getUtypeId())) {
			json.put("userRefereeName",tdUserReferee.getuNickname());
			if(!"".equals(tdUserReferee.getUsermanagerUid())&&tdUserReferee.getUsermanagerUid()!=null) {
				  TdUser UserrefereeManager = service.queryById(tdUserReferee.getUsermanagerUid());
				  if(UserrefereeManager!=null) {
					  json.put("ManagerUserId",UserrefereeManager.getUserId());
					  json.put("uNickname",UserrefereeManager.getuNickname());//归属人姓名
				  }else {					  
					 
					  User finalSysUser = um.getUserById(tdUserReferee.getUsermanagerUid());
					  if(finalSysUser!=null) {
						  json.put("ManagerUserId",finalSysUser.getUSER_ID());
						  json.put("uNickname",finalSysUser.getNAME());//归属人姓名
					  }else {
						  json.put("ManagerUserId","查无此人");
						  json.put("uNickname","查无此人");//归属人姓名
					  }
				  }
			}
			
		}
	}else {
		  json.put("userRefereeName","查无此人");
		  json.put("ManagerUserId","查无此人");
		  json.put("uNickname","查无此人");//归属人姓名
	}

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
	
	/*
	 * 通过会员号获取该会员的姓名
	 * ByMemberidFindUserrefereeName
	 */
	@RequestMapping(value="/ByMemberidFindUserrefereeName")
	public String ByMemberidFindUserrefereeName(HttpServletResponse response,HttpServletRequest request) throws Exception {
	String memberid=request.getParameter("memberid");

	
	TdUser tdUser = new TdUser();
	tdUser.setMemberid(memberid);
	TdUser tdUser2 = service.queryOne(tdUser);
	//解析集合用的方法
/*	JSONArray json = new JSONArray();*/
	
       /*  JSONObject jo = new JSONObject();
         jo.put("citycode", pLog.getCitycode());
         jo.put("pidcode", pLog.getPidcode());
         jo.put("cityname", pLog.getCityname());*/
	JSONObject json = new JSONObject();
	if(tdUser2!=null) {
		if(tdUser2.getUtypeId()=="1") {
			json.put("uNickname","");
		}else {
			json.put("uNickname", tdUser2.getuNickname());
		}
	}else {
		json.put("uNickname","");
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
	//获取当前时间
	public  final static String getLocalTime() {
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		return time;
	}
	//修改会员和体验vip的结束时间
	public final static String fixTimeByDays(String beforeTime,int countType,int dayCount) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
		long day  =  dayCount*24*3600;
		
		long finalDay = 0;
	    if(day<0) {
	    	finalDay=-day;
	    }else {
	    	finalDay = day;
	    }
		//0获取之前会员结束时间 并计算时间
	    Date beforeEndTime=format.parse(beforeTime);	
		long   fixAfterTime = 0;
		if(countType==0) {			
			   fixAfterTime= (beforeEndTime.getTime()/1000)-finalDay;
		}else if(countType==1) {
			   fixAfterTime= (beforeEndTime.getTime()/1000)+finalDay;
		}
		
		String finalTime = format.format(new Date(Long.valueOf(fixAfterTime*1000)));	  
	    return finalTime;
	}
	
	public static void main(String[] args) throws ParseException {
	/*	System.out.println(fixTimeByDays(getLocalTime(), 1, 6000));*/
		
		/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dt = simpleDateFormat.format("Sun Dec 30 00:00:00 CST 2018");
		System.out.println("c"+dt);*/
/*		String dateString = "Sun Dec 30 00:00:00 CST 2018";
*/		/*String dateString = "Thu Sep 07 2017 00:00:00 GMT+0800 (中国标准时间) 00:00:00";
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z", Locale.ENGLISH);
		Date dd = sdf.parse(dateString); //将字符串改为date的格式
 		String resDate= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(dd);
		System.out.println(resDate);*/

		
		String dateStr = "Sun Dec 30 00:00:00 CST 2018";
	
	System.out.println("m"+sdcFormatTimeToStringTime(dateStr));
		
	 /*	Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		System.out.println("d"+time);*/
		
		/*SimpleDateFormat format2 =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      String time="1970-01-06 11:45:55";
	      Date date = format2.parse(time);
	      System.out.print("Format To times:"+date.getTime());
		*/
		//2
	/*	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int fixDays2 =30;				
		long day  =  fixDays2*(24*60*60*1000);
		String  beforeTime = "2018-12-20 17:19:23";
		//0获取之前会员结束时间 并计算时间
	     Date beforeEndTime=format.parse(beforeTime);
		System.out.println("t"+beforeEndTime.getTime());
		long   fixAfterTime= beforeEndTime.getTime()-day;
		String finalTime = format.format(new Date(Long.valueOf(fixAfterTime)));
	    System.out.println("d"+finalTime);*/
		//3
		/*System.out.println(fixTimeByDays("2018-12-20 17:19:23",1,4));
		System.out.println(fixTimeByDays("2018-12-20 17:19:23",0,4));*/
	}
	//用户找到运营中心
	public final TdUser findCenter(String userId) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();		
		
		TdUser tdUserBefore = service.queryById(userId);
		TdUser tempUser = new TdUser();
		if(tdUserBefore!=null) {
			if(!"".equals(tdUserBefore.getCityCitycode())||tdUserBefore.getCityCitycode()!=null) {
		    	//第一步先找市运营中心
		    	pd.put("cityCode", tdUserBefore.getCityCitycode());
		    	//运行中心
		    	pd.put("ROLE_ID", "3f9660f63a6b4d4cbf51a2bc455ca497");
		        PageData sysUserPageDataCity =um.getSysUserCityCode(pd);
		        if(sysUserPageDataCity!=null) {
		        	tempUser.setUsermanagerUid(sysUserPageDataCity.getString("USER_ID"));
		        	tempUser.setUsermanagerName(sysUserPageDataCity.getString("NAME"));
		        	/*returnResult =  service.updateSelective(tdUser3);*/
		        }else {
		        	//如果市运营中心找不到，第二部找省运营中心
		        	if(!"".equals(tdUserBefore.getProvinceCitycode())||tdUserBefore.getProvinceCitycode()!=null) {
		        		pd.put("cityCode", tdUserBefore.getProvinceCitycode());
		        		pd.put("ROLE_ID", "3f9660f63a6b4d4cbf51a2bc455ca497");
				        PageData sysUserPageDataProvince =um.getSysUserCityCode(pd);
				        if(sysUserPageDataProvince!=null) {
				        	tempUser.setUsermanagerUid(sysUserPageDataProvince.getString("USER_ID"));
				        	tempUser.setUsermanagerName(sysUserPageDataProvince.getString("NAME"));        	
				        	/*returnResult =  service.updateSelective(tdUser3);*/
				        }else {
				        	//如果省运营中心找不到,第三部找总运营中心
				        	//修改这个？？uid
				        	tempUser.setUsermanagerUid("ce6c9f55600e4602a2051ea130af74d8");
				        	tempUser.setUsermanagerName("总运营中心"); 
				        
				        }
		        	}
		        }
		        
		    }
		}
		return tempUser;
	}
	
	//通过用户id,查找归属的运营中心，0为vip降级，1为体验降级
	public final  int findManagerCenter(String userId,Integer sum) throws Exception {
/*		System.out.println("userId"+userId);
*/		int returnResult = 0;
		PageData pd = new PageData();
		pd = this.getPageData();
		
		TdUser  tdUserBefore = new TdUser();
		tdUserBefore.setUsermanagerUid(userId);
		List<TdUser> listTdUser = service.queryListByWhere(tdUserBefore);
		for (TdUser tdUser3 : listTdUser) {
			if(sum==0) {
				
				 if(!"".equals(tdUser3.getCityCitycode())||tdUser3.getCityCitycode()!=null) {
				    	//第一步先找市运营中心
				    	pd.put("cityCode", tdUser3.getCityCitycode());
				    	//运行中心
				    	pd.put("ROLE_ID", "3f9660f63a6b4d4cbf51a2bc455ca497");
				        PageData sysUserPageDataCity =um.getSysUserCityCode(pd);
				        if(sysUserPageDataCity!=null) {
				        	tdUser3.setUsermanagerUid(sysUserPageDataCity.getString("USER_ID"));
				        	tdUser3.setUsermanagerName(sysUserPageDataCity.getString("NAME"));
				        	returnResult =  service.updateSelective(tdUser3);
				        }else {
				        	//如果市运营中心找不到，第二部找省运营中心
				        	if(!"".equals(tdUser3.getProvinceCitycode())||tdUser3.getProvinceCitycode()!=null) {
				        		pd.put("cityCode", tdUser3.getProvinceCitycode());
				        		pd.put("ROLE_ID", "3f9660f63a6b4d4cbf51a2bc455ca497");
						        PageData sysUserPageDataProvince =um.getSysUserCityCode(pd);
						        if(sysUserPageDataProvince!=null) {
						        	tdUser3.setUsermanagerUid(sysUserPageDataProvince.getString("USER_ID"));
						        	tdUser3.setUsermanagerName(sysUserPageDataProvince.getString("NAME"));        	
						        	returnResult =  service.updateSelective(tdUser3);
						        }else {
						        	//如果省运营中心找不到,第三部找总运营中心
						        
						        	tdUser3.setUsermanagerUid("ce6c9f55600e4602a2051ea130af74d8");
						        	tdUser3.setUsermanagerName("总运营中心"); 
						        	returnResult =  service.updateSelective(tdUser3);
						        }
				        	}
				        }
				        
				    }
							
				    }
			else if(sum==1) {
		    	TdUser tdUser =service.queryById(userId);
		    	if(tdUser!=null) {
		    		TdUser tdUser2 = service.queryById(tdUser.getUsermanagerUid());
		    	 if(tdUser2!=null) {

				    	if("2".equals(tdUser2.getUtypeId())||"3".equals(tdUser2.getUtypeId())||
				    			"4".equals(tdUser2.getUtypeId())||"5".equals(tdUser2.getUtypeId())||"6".equals(tdUser2.getUtypeId())) {
				    		tdUser3.setUsermanagerUid(tdUser2.getUserId());
				        	tdUser3.setUsermanagerName(tdUser2.getuNickname()); 
				        	returnResult =  service.updateSelective(tdUser3);
				    	}else {
				    		if(!"".equals(tdUser3.getCityCitycode())||tdUser3.getCityCitycode()!=null) {
						    	//第一步先找市运营中心
						    	pd.put("cityCode", tdUser3.getCityCitycode());
						    	//运行中心
						    	pd.put("ROLE_ID", "3f9660f63a6b4d4cbf51a2bc455ca497");
						        PageData sysUserPageDataCity =um.getSysUserCityCode(pd);
						        if(sysUserPageDataCity!=null) {
						        	tdUser3.setUsermanagerUid(sysUserPageDataCity.getString("USER_ID"));
						        	tdUser3.setUsermanagerName(sysUserPageDataCity.getString("NAME"));
						        	returnResult =  service.updateSelective(tdUser3);
						        }else {
						        	//如果市运营中心找不到，第二部找省运营中心
						        	if(!"".equals(tdUser3.getProvinceCitycode())||tdUser3.getProvinceCitycode()!=null) {
						        		pd.put("cityCode", tdUser3.getProvinceCitycode());
						        		pd.put("ROLE_ID", "3f9660f63a6b4d4cbf51a2bc455ca497");
								        PageData sysUserPageDataProvince =um.getSysUserCityCode(pd);
								        if(sysUserPageDataProvince!=null) {
								        	tdUser3.setUsermanagerUid(sysUserPageDataProvince.getString("USER_ID"));
								        	tdUser3.setUsermanagerName(sysUserPageDataProvince.getString("NAME"));        	
								        	returnResult =  service.updateSelective(tdUser3);
								        }else {
								        	//如果省运营中心找不到,第三部找总运营中心
								        
								        	tdUser3.setUsermanagerUid("ce6c9f55600e4602a2051ea130af74d8");
								        	tdUser3.setUsermanagerName("总运营中心"); 
								        	returnResult =  service.updateSelective(tdUser3);
								        }
						        	}
						        }
						        
						    }
				    	}
				    }
		    }
				}
			}
		   
		
		return returnResult;
	}
//信用值计算
	public  final static Integer[] changeCreditrdNum(Integer sum ) {
		/*int a = sum/divider;*/
		/*int remark1 = sum/1250;
		int remark2 = sum%1250/250;
		int remark3 = sum%1250%250/50;
		int remark4 = sum%1250%250%50/10;
		int remark5 = sum%1250%250%50%10;*/
	
		int remark1 = sum/250;
		int remark2 = sum%250/50;
		int remark3 = sum%250%50/10;
		int remark4 = sum%250%50%10;
	    Integer creditrdNums[] = {0,0,0,0};
	    creditrdNums[0] = remark1;
	    creditrdNums[1] = remark2;
	    creditrdNums[2] = remark3;
	    creditrdNums[3] = remark4;
	   /* creditrdNums[4] = remark5; */
		return creditrdNums;
	}
	
	//Sun Dec 30 00:00:00 CST 2018  时间格式转变为2018-12-30 00:00:00时间格式
	public  static String sdcFormatTimeToStringTime(String sdcFormatTime) throws ParseException {
		String dateStr = sdcFormatTime;
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		Date date = (Date) sdf.parse(dateStr);
		String formatStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		return formatStr;
		
	}
}
