package com.fh.controller.yixunlian;

import java.beans.PropertyDescriptor;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGSelectQueryBlock.ForClause;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.company.Company;
import com.fh.lw.pojo.obtainemployment.Labour;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivityChargeItem;
import com.fh.lw.pojo.yixunlian.TdActivityprojectandacsign;
import com.fh.lw.pojo.yixunlian.TdActivitysign;
import com.fh.lw.pojo.yixunlian.TdAddress;
import com.fh.lw.pojo.yixunlian.TdComplaint;
import com.fh.lw.pojo.yixunlian.TdEverjoin;
import com.fh.lw.pojo.yixunlian.TdHobbyAndactivitycategory;
import com.fh.lw.pojo.yixunlian.TdPersonalneeds;
import com.fh.lw.pojo.yixunlian.TdReport;
import com.fh.lw.pojo.yixunlian.TdTempUser;
import com.fh.lw.pojo.yixunlian.TdTransactionItem;
import com.fh.lw.pojo.yixunlian.TdUenrollandactivity;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.lw.pojo.yixunlian.TdUserandhobby;
import com.fh.lw.utils.EasyUIResult;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;
import com.fh.service.yixunlian.ActivityProjectService;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySignService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.ActivityUenrollAndActivityService;
import com.fh.service.yixunlian.ClientUserAndHobbyService;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.ComplaintService;
import com.fh.service.yixunlian.EverjoinActivityService;
import com.fh.service.yixunlian.HobbyAndactivitycategoryService;
import com.fh.service.yixunlian.PersonalneedsService;
import com.fh.service.yixunlian.ReportService;
import com.fh.service.yixunlian.TdAddressService;
import com.fh.service.yixunlian.TransactionItemService;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("activity/")
public class ActivityController  extends BaseController{
	//这个注入的是通用mapper使用的service
	@Autowired
	private ActivityService service;
	//这是注入的是写sql语句的service
	@Autowired
	private ActivitySqlManager sqlService;
	@Autowired
	private UserManager um;
	@Resource(name="fhlogService")
	private FHlogManager FHLOG;
    @Autowired
	private ClientUserService clientUserservice;
	 //活动收费项目
	@Autowired
	private ActivityProjectService activityProjectservice;
	 //活动：报名列表：成交项目金额设置
	@Autowired
    private TransactionItemService transactionItemService;
	@Autowired
	private TdAddressService tdAddressService;
	//活动举报
	@Autowired
	private ReportService reportService;
	//活动投诉
	@Autowired
	private ComplaintService complaintService;
	//个人需求
	@Autowired
    private PersonalneedsService personalneedsService;
	//兴趣爱好和活动类别的第三方表
	@Autowired
	private HobbyAndactivitycategoryService hobbyAndactivitycategoryService;
	//用户和兴趣爱好的第三方表
	@Autowired
	private ClientUserAndHobbyService clientUserAndHobbyService;
	//曾经参与
	@Autowired
	private EverjoinActivityService everjoinActivityService;
	//报名填写项
	@Autowired
	private ActivitySignService activitySignService;
	@Autowired
	private ActivityUenrollAndActivityService activityUenrollAndActivityService;
	//logBefore(logger, Jurisdiction.getUsername() + "确认學生就读");记录日志文档
	@SuppressWarnings("unlikely-arg-type")
	//分页显示活动列表
	@RequestMapping(value="goListactivity")
	public ModelAndView goListactivity(Page page)throws Exception {
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
		//主办方名称检索
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
		
		page.setPd(pd);
		if("3f9660f63a6b4d4cbf51a2bc455ca497".equals(user.getString("ROLE_ID"))) {			
			String citycode = user.getString("citycode");
			pd.put("citycode", citycode);
			page.setPd(pd);
		}
		//sql查询出活动列表集合
			List<PageData> listActivity = this.sqlService.getAllTdActivity(page);
			if(!listActivity.isEmpty()) {
			for (PageData pageData : listActivity) {			
		    float sumSoloActivityDealMoney = 0;
	       //统计单独一个的活动成交金额			
			sumSoloActivityDealMoney = activityUenrollAndActivityService.sumSoloActivityDealMoney(pageData.getString("activity_id"));
			pageData.put("sumSoloActivityDealMoney", sumSoloActivityDealMoney);
			//待发放提成金额 ，还需要再支付出去的总额
			 float sumSoloActivityWaitPayExtract = 0;
			 sumSoloActivityWaitPayExtract = activityUenrollAndActivityService.getSumSoloActivityWaitPayExtract(pageData.getString("activity_id"));
			 pageData.put("sumSoloActivityWaitPayExtract", sumSoloActivityWaitPayExtract);
			 //统计报名人数
				TdUenrollandactivity tdUenrollandactivity = new TdUenrollandactivity();				
				tdUenrollandactivity.setActivityId(pageData.getString("activity_id"));
				pageData.put("countEnrollPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivity));
			//省市区
				if(!"".equals(pageData.getString("province_citycode"))&&pageData.getString("province_citycode")!=null) {
					TdAddress tdAddressProvince =	tdAddressService.queryById(pageData.getString("province_citycode"));
					 if(tdAddressProvince!=null) {
						   pageData.put("address1", tdAddressProvince.getCityname());				   
					   }
				}
				//市
				if(!"".equals(pageData.getString("city_citycode"))&&pageData.getString("city_citycode")!=null) {
					TdAddress tdAddressCity = tdAddressService.queryById(pageData.getString("city_citycode"));
					if(tdAddressCity!=null) {
						   pageData.put("address2", tdAddressCity.getCityname());				   
					   }
				}
				//区县
				if(!"".equals(pageData.getString("area_citycode"))&&pageData.getString("area_citycode")!=null) {
					TdAddress tdAddressArea = tdAddressService.queryById(pageData.getString("area_citycode"));
					if(tdAddressArea!=null) {
						   pageData.put("address3", tdAddressArea.getCityname());				   
					   }
				}
			 
				 //应发提成，应该支付支付出去的总额
				 float sumSoloActivityShouldPubPayExtract = 0;			
				 sumSoloActivityShouldPubPayExtract = activityUenrollAndActivityService.getSumSoloActivityShouldPubPayExtract(pageData.getString("activity_id"));
				 pageData.put("shouldPubMoney", sumSoloActivityShouldPubPayExtract);
			//被举报
			TdReport tdReport = new TdReport();
			tdReport.setActivityId(pageData.getString("activity_id"));
			pageData.put("reportCount",reportService.queryTotalCount(tdReport));
			//被投诉
			TdComplaint tdComplaint = new TdComplaint();
			tdComplaint.setActivityId(pageData.getString("activity_id"));
			pageData.put("complaintCount", complaintService.queryTotalCount(tdComplaint)) ;
			
			//客户匹配人数//1先匹配区
			int matchPersonCount = 0;
			if(!"".equals(pageData.getString("precision_demand_area_id"))&&pageData.getString("precision_demand_area_id")!=null) {
				TdAddress tdAddressArea = tdAddressService.queryById(pageData.getString("precision_demand_area_id"));
				if(tdAddressArea!=null) {
					//活动类别，查找三点依据，1兴趣爱好，2曾经参与，3，个人需求	
					//如果匹配到区县某个具体区县
					Map<String,TdUser> map=listTdUserPrecisionByActivitycategoryId(pageData.getString("activitycategory_id"),pageData.getString("precision_demand_area_id"),1);				
					matchPersonCount = map.size();
				}else {
					//如果匹配到区县的全部
					if("000000".equals(pageData.getString("precision_demand_area_id"))) {
						Map<String,TdUser> map=listTdUserPrecisionByActivitycategoryId(pageData.getString("activitycategory_id"),pageData.getString("precision_demand_area_id"),1);				
						matchPersonCount = map.size();
					}//如果区县都没有匹配成功
					else {
						//2先匹配市
						if(!"".equals(pageData.getString("precision_demand_city_id"))&&pageData.getString("precision_demand_city_id")!=null) {
							TdAddress tdAddressCity = tdAddressService.queryById(pageData.getString("precision_demand_city_id"));
                            if(tdAddressCity!=null) {
                            	//匹配到某个具体的市
            					Map<String,TdUser> map=listTdUserPrecisionByActivitycategoryId(pageData.getString("activitycategory_id"),pageData.getString("precision_demand_city_id"),2);				
            					matchPersonCount = map.size();
                            }else {
                            	//如果匹配到市的全部
                            	if("000000".equals(pageData.getString("precision_demand_city_id"))) {
                					Map<String,TdUser> map=listTdUserPrecisionByActivitycategoryId(pageData.getString("activitycategory_id"),pageData.getString("precision_demand_city_id"),2);				
                					matchPersonCount = map.size();
                            	}//如果市都没有匹配成功
                            	else {
                            		//3先匹配省
            						if(!"".equals(pageData.getString("precision_demand_province_id"))&&pageData.getString("precision_demand_province_id")!=null) {
            							TdAddress tdAddressProvince = tdAddressService.queryById(pageData.getString("precision_demand_province_id"));
                                        if(tdAddressProvince!=null) {
                        					Map<String,TdUser> map=listTdUserPrecisionByActivitycategoryId(pageData.getString("activitycategory_id"),pageData.getString("precision_demand_province_id"),3);				
                        					matchPersonCount = map.size();
                                        }else {
                    						if("000000".equals(pageData.getString("precision_demand_province_id"))) {
                            					Map<String,TdUser> map=listTdUserPrecisionByActivitycategoryId(pageData.getString("activitycategory_id"),pageData.getString("precision_demand_province_id"),3);				
                            					matchPersonCount = map.size();
                    						}
                                        }
            						}

                            	}
                            }
						}
						
					}

				}
			}
            pageData.put("matchPersonCount", matchPersonCount);
				
			
			}
			}
		    mv.setViewName("system/activity/activity_list");
		
		    mv.addObject("listActivity",listActivity);
			mv.addObject("QX",Jurisdiction.getHC());//按钮权限
			mv.addObject("pd", pd);
		return mv;
	}
	/*
	 * goAddActivity跳转到添加活动页面
	 */
	@RequestMapping(value="/goAddActivity")
	public ModelAndView goAddActivity(Page page)throws Exception{
/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
*/		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/activity/activity_add");
		mv.addObject("msg", "saveU");
		mv.addObject("pd", pd);
		return mv;
	}
	/*
	 * 执行添加活动
	 */
	@RequestMapping(value="/saveActivityInfo")
	public ModelAndView saveActivityInfo() throws Exception{
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
		TdActivity tdActivity = new TdActivity();
		service.save(tdActivity);//??添加参数

		mv.addObject("msg","success");
	    mv.setViewName("save_result");		
		return mv;
	}
	//下架活动备注下架原因
	@RequestMapping(value="/goEditActivityUnderReason")
	public ModelAndView goEditActivityUnderReason() throws Exception{
/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
*/		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/activity/activity_editUnderReason");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		return mv;
	}
	//执行下架，备注下架原因
	@RequestMapping(value="/editActivityUnderReasonById")
	public ModelAndView editActivityUnderReasonById() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String activity_id = pd.getString("activity_id");		
		TdActivity tdActivity = new TdActivity();
		tdActivity.setActivityId(activity_id);
		tdActivity.setUndercarriageReason(pd.getString("underReason"));
		tdActivity.setOnlineStatus(3);
		service.updateSelective(tdActivity);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	/*
	 * 跳转到修改界面
	 * goEditActivity
	 */
	@RequestMapping(value="/goEditActivity")
	public ModelAndView goEditActivity() throws Exception{
/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
*/		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String activity_id = pd.getString("activity_id");
		TdActivity tdActivity = service.queryById(activity_id);
		/*pd = wm.findPositionByPidd(pd);	*/
		
		mv.setViewName("system/activity/activity_edit");
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		mv.addObject("tdActivity", tdActivity);
		return mv;
	}
	/*
	 * 执行修改
	 * 
	 */
	@RequestMapping(value="/editActivityByAid")
	public ModelAndView editActivityByAid() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		TdActivity tdActivity = new TdActivity();
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		pd.put("update_time", time);
		service.update(tdActivity);	//执行修改,？？传参数	
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	//上下架活动
	//updateActivityState
	@RequestMapping(value="/updateActivityState")
	public ModelAndView updateActivityState() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String activity_id = pd.getString("activity_id");
		TdActivity tdActivity = service.queryById(activity_id);
		String is_states = pd.getString("online_status");
		
		Integer is_state = Integer.parseInt(is_states);
		
		if(is_state==1) {	
			FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":修改->"+tdActivity.getActivityName()+"活动状态:上架活动");

			logBefore(logger, Jurisdiction.getUsername()+"修改:"+tdActivity.getActivityName()+"活动状态:上架活动");
		}else {
			FHLOG.save(Jurisdiction.getUsername(),Jurisdiction.getUsername()+ ":修改->"+tdActivity.getActivityName()+"活动状态:下架活动");

			logBefore(logger, Jurisdiction.getUsername()+"修改:"+tdActivity.getActivityName()+"活动状态：下架活动");

		}
	
		service.updateActivityState(activity_id,is_state);
		mv.addObject("msg","ok");
		mv.setViewName("save_result");
		return mv;
	}
	//显示活动详情showActivityDetailById
	@RequestMapping(value="showActivityDetailById")
	public ModelAndView showActivityDetailById(){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
				pd = this.getPageData();			
				String activity_id = pd.getString("activity_id");
				TdActivity tdActivity = service.queryById(activity_id);
				//省市区
				if(!"".equals(tdActivity.getPrecisionDemandProvinceId())&&tdActivity.getPrecisionDemandProvinceId()!=null) {
					TdAddress tdAddressProvince =	tdAddressService.queryById(tdActivity.getPrecisionDemandProvinceId());
					 if(tdAddressProvince!=null) {
						   tdActivity.setAddress1(tdAddressProvince.getCityname());
						  		   
					   }else {
						   if("000000".equals(tdActivity.getPrecisionDemandProvinceId())){							 
						   tdActivity.setAddress1("全国");
						   }
					   }
				}
				//市
				if(!"".equals(tdActivity.getPrecisionDemandCityId())&&tdActivity.getPrecisionDemandCityId()!=null) {
					TdAddress tdAddressCity = tdAddressService.queryById(tdActivity.getPrecisionDemandCityId());
					if(tdAddressCity!=null) {
						   tdActivity.setAddress2(tdAddressCity.getCityname());
					   }else {
						   if("000000".equals(tdActivity.getPrecisionDemandCityId())){						 
							   tdActivity.setAddress2("全省");
						   }
					   }
				}
				//区县
				if(!"".equals(tdActivity.getPrecisionDemandAreaId())&&tdActivity.getPrecisionDemandAreaId()!=null) {
					TdAddress tdAddressArea = tdAddressService.queryById(tdActivity.getPrecisionDemandAreaId());
					if(tdAddressArea!=null) {
						  			   
						   tdActivity.setAddress3(tdAddressArea.getCityname());
					}else {
						   if("000000".equals(tdActivity.getPrecisionDemandAreaId())){
							   tdActivity.setAddress3("全市");
						   }
					   }
				}
				
				  //收费项目
				TdActivityChargeItem  tdActivityChargeItem = new TdActivityChargeItem();
				tdActivityChargeItem.setActivityId(tdActivity.getActivityId());
				List<TdActivityChargeItem>	listTdActivityChargeItemByAid = activityProjectservice.queryListByWhere(tdActivityChargeItem);
				tdActivity.setListTdActivityChargeItem(listTdActivityChargeItemByAid);
				  //报名填写项全部
                List<TdActivitysign> addListTdActivitysign = activitySignService.getAddActivitySignAll(activity_id,tdActivity.getUserId());
                tdActivity.setAddListTdActivitysign(addListTdActivitysign);
				mv.addObject("tdActivity",tdActivity);
				mv.setViewName("system/activity/activityInfo_detail");
					
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	//delActivityByAid
	/*
	 * 单独删除一个活动
	 */
	@RequestMapping(value = "/delActivityByAid")
	public void delActivityByAid(PrintWriter out) throws Exception {
		PageData pd = new PageData();
		pd = this.getPageData();
		String activity_id = pd.getString("activity_id");
		TdActivity tdActivity = service.queryById(activity_id);
		FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":删除活动:->"+tdActivity.getActivityName());
		logBefore(logger, Jurisdiction.getUsername() + ":删除活动:->"+tdActivity.getActivityName());
	    this.service.deleteActivityByAid(activity_id);
	
		out.write("success");
		out.close();
	}
	
	
	//deleteAllActivity批量删除
	@RequestMapping(value="/deleteAllActivity")
	@ResponseBody
	public Object deleteAllActivity() throws Exception {
		
		
		TdActivity tdActivity = new TdActivity();
		PageData pd = new PageData();
		List<PageData> pdList = new ArrayList<PageData>();
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		String activity_IDS = pd.getString("Activity_IDS");
		String activity_ids[] = activity_IDS.split(",");
	
		//系统日志批量删除的活动名称
		StringBuffer sb = new StringBuffer();
		for (String activityId : activity_ids) {
			tdActivity.setActivityId(activityId);
			TdActivity tdActivityById = service.queryOne(tdActivity);
			sb.append("活动->:"+tdActivityById.getActivityName()+" ");
		}
		FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":批量删除活动:->"+sb.toString());

		service.delAllActivity(activity_IDS);	
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
	
	
	
	/*
	 * 项目收费成交情况
	 * ActivityProjectDealDetail
	 */
	@RequestMapping(value="ActivityProjectDealDetail")
	public ModelAndView ActivityProjectDealDetail(){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
				pd = this.getPageData();			
				String activity_id = pd.getString("activity_id");
				
				TdActivityChargeItem tdActivityChargeItem = new TdActivityChargeItem();
			
				tdActivityChargeItem.setActivityId(activity_id);
					List<TdActivityChargeItem> activityprojectandacsigns = activityProjectservice.queryListByWhere(tdActivityChargeItem);
					mv.addObject("activityprojectandacsigns",activityprojectandacsigns);
					mv.setViewName("system/activity/activityProject_detail");
					
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	
	//活动下架理由展示SoloActivityUnderReasonList
	@RequestMapping(value="SoloActivityUnderReasonList")
	public ModelAndView SoloActivityUnderReasonList(){
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
				try{
				pd = this.getPageData();			
				String activity_id = pd.getString("activity_id");
				TdActivity  tdActivity = service.queryById(activity_id);
				
				List<TdActivity> listTdActivity = new ArrayList<>();
				listTdActivity.add(tdActivity);
				mv.addObject("listTdActivity",listTdActivity);
				mv.setViewName("system/activity/activity_undercarriageReason");
					
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	//上架已经下架的活动updateActivityState
	@RequestMapping(value="/updateActivityStateUnder")
	public ModelAndView updateActivityStateUnder() throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
	
		String activityId = pd.getString("activityId");
		TdActivity tdActivity = service.queryById(activityId);
		String onlineStatus = pd.getString("onlineStatus");
		Integer onlineStatuss = Integer.parseInt(onlineStatus);				
		/*if(isExamines==0) {	
			FHLOG.save(Jurisdiction.getUsername(), Jurisdiction.getUsername()+":审核举报->"+tdActivity.getActivityName()+":"+);
			logBefore(logger, Jurisdiction.getUsername()+"修改:"+tdActivity.getActivityName()+"活动状态:上架活动");
		}*/
	
		service.updateActivityStateUnder(activityId,onlineStatuss);
		mv.addObject("msg","ok");
		mv.setViewName("save_result");
		return mv;
	}
	//精准客户资源匹配MatchUserList
	@RequestMapping(value="MatchUserList")
	public ModelAndView MatchUserList(){
			    ModelAndView mv = this.getModelAndView();
			    PageData pd = new PageData();
				try{
				pd = this.getPageData();			
				String activity_id = pd.getString("activity_id");
				TdActivity tdActivity = service.queryById(activity_id);
				//总匹配人数
				int matchPersonCount = 0;
				Map<String,TdUser> map = new HashMap<>();
				if(tdActivity!=null) {				
				//客户匹配人数//1先匹配区
				
				if(!"".equals(tdActivity.getAreaCitycode())&&tdActivity.getAreaCitycode()!=null) {
					TdAddress tdAddressArea = tdAddressService.queryById(tdActivity.getAreaCitycode());
					if(tdAddressArea!=null) {
						//活动类别，查找三点依据，1兴趣爱好，2曾经参与，3，个人需求	
						//如果匹配到区县某个具体区县
						 map=listTdUserPrecisionByActivitycategoryId(tdActivity.getActivitycategoryId(),tdActivity.getAreaCitycode(),1);				
						matchPersonCount = map.size();
					}else {
						//如果匹配到区县的全部
						if("000000".equals(tdActivity.getAreaCitycode())) {
							map=listTdUserPrecisionByActivitycategoryId(tdActivity.getActivitycategoryId(),tdActivity.getAreaCitycode(),1);				
							matchPersonCount = map.size();
						}//如果区县都没有匹配成功
						else {
							//2先匹配市
							
							if(!"".equals(tdActivity.getCityCitycode())&&tdActivity.getCityCitycode()!=null) {
								TdAddress tdAddressCity = tdAddressService.queryById(tdActivity.getCityCitycode());
	                            if(tdAddressCity!=null) {
	                            	//匹配到某个具体的市
	            					 map=listTdUserPrecisionByActivitycategoryId(tdActivity.getActivitycategoryId(),tdActivity.getCityCitycode(),2);				
	            					matchPersonCount = map.size();
	                            }else {
	                            	//如果匹配到市的全部
	                            	if("000000".equals(tdActivity.getCityCitycode())) {
	                					 map=listTdUserPrecisionByActivitycategoryId(tdActivity.getActivitycategoryId(),tdActivity.getCityCitycode(),2);				
	                					matchPersonCount = map.size();
	                            	}//如果市都没有匹配成功
	                            	else {
	                            		//3先匹配省
	                            		
	            						if(!"".equals(tdActivity.getProvinceCitycode())&&tdActivity.getProvinceCitycode()!=null) {
	            							TdAddress tdAddressProvince = tdAddressService.queryById(tdActivity.getProvinceCitycode());
	                                        if(tdAddressProvince!=null) {
	                        					 map=listTdUserPrecisionByActivitycategoryId(tdActivity.getActivitycategoryId(),tdActivity.getProvinceCitycode(),3);				
	                        					matchPersonCount = map.size();
	                                        }else {
	                    						if("000000".equals(tdActivity.getProvinceCitycode())) {
	                            					 map=listTdUserPrecisionByActivitycategoryId(tdActivity.getActivitycategoryId(),tdActivity.getProvinceCitycode(),3);				
	                            					matchPersonCount = map.size();
	                    						}
	                                        }
	            						}

	                            	}
	                            }
							}
							
						}

					}
				}
				
				}
			    //1获取的去重map集合转变为list集合
				Set<Entry<String, TdUser>> entrySet = map.entrySet();
				List<TdUser> listTdUser = new ArrayList<>();
				for (Entry<String, TdUser> entry : entrySet) {
					listTdUser.add( entry.getValue());
				}
				//2创建一个零时存放对象集合
				List<TdTempUser> listTdTempUser = new ArrayList<>();
				//3TdUser对象以归属人id作为分类集合
				  Map<String,ArrayList> ss =tdUserMapSort(listTdUser);
				  TdTempUser  tdTempUser  = new TdTempUser ();
			      Iterator it = ss.keySet().iterator();
			      while(it.hasNext()){
			      String key = (String)it.next();
			      TdUser tdUser = clientUserservice.queryById(key);
			      if(tdUser!=null) {
			    	  if(!"".equals(tdUser.getuNickname())&&tdUser.getuNickname()!=null) {
			    		  tdTempUser.setuNickName(tdUser.getuNickname());			    		  
			    	  }
			    	  if(!"".equals(tdUser.getMemberid())&&tdUser.getMemberid()!=null) {
				    	  tdTempUser.setMemberId(tdUser.getMemberid());
			    	  }
			    	  if(!"".equals(tdUser.getuPhone())&&tdUser.getuPhone()!=null) {
				    	  tdTempUser.setPhone(tdUser.getuPhone());
			    	  }
			    	  ArrayList list1 = ss.get(key);
			    	  tdTempUser.setCount(list1.size());
			    	  listTdTempUser.add(tdTempUser);
			         }
			      /* for(int i=0; i<list1.size(); i++){
			         TdUser sb = (TdUser)list1.get(i);
			         System.out.print("   "+sb.getuNickname());
			         }*/
			         }
			   //总匹配人数
			    mv.addObject("matchPersonCount",matchPersonCount);
			    //活动对象
			    mv.addObject("tdActivity",tdActivity);
			   //匹配的客户经理情况
				mv.addObject("listTdTempUser",listTdTempUser);
				mv.setViewName("system/activity/activityMatchUserList");
					
				} catch(Exception e){
					logger.error(e.toString(), e);
				}
				return mv;
			}
	
	public final  Map<String,TdUser> listTdUserPrecisionByActivitycategoryId(String activitycategory_id,String address,int type){
		//活动类别，查找三点依据，1兴趣爱好，2曾经参与，3，个人需求
		//1兴趣爱好
		TdUserandhobby tdUserandhobby =new TdUserandhobby();
		tdUserandhobby.setActivitycategoryId(activitycategory_id);
		Map<String,TdUser> map = new HashMap<>();
		List<TdUserandhobby> listTdUserAndHobby = clientUserAndHobbyService.getlistTdUserAndHobbyByActivitycategoryId(activitycategory_id);
		for (TdUserandhobby tdUserandhobby2 : listTdUserAndHobby) {
			TdUser tdUser = clientUserservice.getTdUserByAddress(tdUserandhobby2.getUserId(),address,type);
			if(tdUser!=null) {
				map.put(tdUser.getUserId(), tdUser);				
			}
		}
		//2曾经参与
		List<TdEverjoin> listTdEverjoin = everjoinActivityService.getListTdEverjoin(activitycategory_id);
		for (TdEverjoin tdEverjoin : listTdEverjoin) {
			TdUser tdUser = clientUserservice.getTdUserByAddress(tdEverjoin.getUserId(),address,type);
			if(tdUser!=null) {
				map.put(tdUser.getUserId(), tdUser);				
			}
		}
		//3个人需求
		List<TdPersonalneeds> listTdPersonalneeds =  personalneedsService.getListTdPersonalneeds(activitycategory_id);
	    for (TdPersonalneeds tdPersonalneeds : listTdPersonalneeds) {
	    	TdUser tdUser = clientUserservice.getTdUserByAddress(tdPersonalneeds.getUserId(),address,type);
	    	if(tdUser!=null) {
				map.put(tdUser.getUserId(), tdUser);				
			}
	    }
	    return map;
	}
	//集合分类
	public final static Map<String,ArrayList>  tdUserMapSort(List<TdUser> listTdUser){
        TreeMap tm=new TreeMap();
        for(int i=0;i<listTdUser.size();i++){
         TdUser s=(TdUser)listTdUser.get(i);
            if(tm.containsKey(s.getUsermanagerUid())){//
             ArrayList l11=(ArrayList)tm.get(s.getUsermanagerUid());
             l11.add(s);
            }else{
             ArrayList tem=new ArrayList();
                tem.add(s);
                tm.put(s.getUsermanagerUid(), tem);
            }
            
        }
        return tm;
    }

}
