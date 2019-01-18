package com.fh.controller.yixunlian;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.apache.james.mime4j.field.datetime.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivityChargeItem;
import com.fh.lw.pojo.yixunlian.TdActivityFillInItem;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdAddress;
import com.fh.lw.pojo.yixunlian.TdComplaint;
import com.fh.lw.pojo.yixunlian.TdEverjoin;
import com.fh.lw.pojo.yixunlian.TdJournalism;
import com.fh.lw.pojo.yixunlian.TdOrganizerInfo;
import com.fh.lw.pojo.yixunlian.TdPersonalneeds;
import com.fh.lw.pojo.yixunlian.TdReport;
import com.fh.lw.pojo.yixunlian.TdUenrollandactivity;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.lw.pojo.yixunlian.TdUserandhobby;
import com.fh.service.system.fhlog.FHlogManager;
import com.fh.service.system.user.UserManager;

import com.fh.service.yixunlian.ActivityFillInItemService;
import com.fh.service.yixunlian.ActivityMusicService;
import com.fh.service.yixunlian.ActivityMusicSqlManager;
import com.fh.service.yixunlian.ActivityProjectService;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.service.yixunlian.ActivityTypeService;
import com.fh.service.yixunlian.ActivityUenrollAndActivityService;
import com.fh.service.yixunlian.ClientUserAndHobbyService;
import com.fh.service.yixunlian.ClientUserService;
import com.fh.service.yixunlian.ComplaintService;
import com.fh.service.yixunlian.EverjoinActivityService;
import com.fh.service.yixunlian.HobbyAndactivitycategoryService;
import com.fh.service.yixunlian.OrganizerInfoService;
import com.fh.service.yixunlian.OrganizerInfoSqlManager;
import com.fh.service.yixunlian.PersonalneedsService;
import com.fh.service.yixunlian.ReportService;
import com.fh.service.yixunlian.TdAddressService;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.fh.util.Tools;

//主办方信息表
@Controller
@RequestMapping("organizerInfo/")
public class OrganizerInfoController extends BaseController{
	//这个注入的是通用mapper使用的service
			@Autowired
			private OrganizerInfoService service;
			
			//这是注入的是写sql语句的service
			@Autowired
			private OrganizerInfoSqlManager sqlService;
			
			@Autowired
			private UserManager um;
		   @Resource(name="fhlogService")
			private FHlogManager FHLOG;
		   @Autowired
			private ClientUserService clientUserService;
		   @Autowired
			private ActivityService activityService;
			@Autowired
			private ActivitySqlManager activitySqlManager;
			//活动音乐
			@Autowired
			private ActivityMusicService activityMusicService;
			@Autowired
			private ActivityUenrollAndActivityService activityUenrollAndActivityService;

			//活动类别
			@Autowired
			private ActivityTypeService activityTypeService;
			//报名填写项
			@Autowired
			private ActivityFillInItemService activityFillInItemService;
			//活动收费项目和费用表
			@Autowired
			private ActivityProjectService activityProjectService;
			//地址
			@Autowired
			private TdAddressService tdAddressService;
			//举报
			@Autowired
			private ReportService reportService;
			//投诉
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
			
		   @RequestMapping(value="goListOrganizerInfo")
			public ModelAndView goListOrganizerInfo(Page page)throws Exception {
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				pd.put("USERNAME",Jurisdiction.getUsername());
				PageData user=this.um.findByUsername(pd);//通过用户名找出用户
				String keywords = pd.getString("keywords");
				//投诉人名字
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
					List<TdOrganizerInfo> listOrganizerInfo = this.sqlService.getAllTdlistOrganizerInfo(page);
					mv.setViewName("system/tdUser/organizerInfo_list");
				    mv.addObject("listOrganizerInfo",listOrganizerInfo);
					mv.addObject("QX",Jurisdiction.getHC());//按钮权限
					mv.addObject("pd", pd);
				return mv;
			}
		   /*
		    * 展示用户个人信息
		    * showUserDatailById
		    */
		   @RequestMapping(value="/showUserDatailById")
			public ModelAndView showUserDatailById() throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				String user_id = pd.getString("user_id");
				TdUser tdUser = clientUserService.queryById(user_id);
				/*pd = wm.findPositionByPidd(pd);	*/
				
				mv.setViewName("system/tdUser/organizerInfo_userDetails");
				mv.addObject("msg", "editU");
				mv.addObject("pd", pd);
				mv.addObject("tdUser", tdUser);
				return mv;
			}
		   ///////////////////////////////////////////////////
		   /*
		    * 主办方已经发布的活动列表
		    * 1已经发布
		    */
		   @SuppressWarnings("unlikely-arg-type")
		@RequestMapping(value="goListPubActivityOrganizerInfo")
		   public ModelAndView goListPubActivityOrganizerInfo(Page page)throws Exception {
						ModelAndView mv = this.getModelAndView();
						PageData pd = new PageData();
						pd = this.getPageData();
						pd.put("USERNAME",Jurisdiction.getUsername());
						/*PageData user=this.um.findByUsername(pd);//通过用户名找出用户
*/						/*TdUser tdUser = clientUserService.queryById(Jurisdiction.getUsername());*/
					    pd.put("userId", Jurisdiction.getUsername());
					    String keywords = pd.getString("keywords");
					    if(!"".equals(keywords)&&keywords!=null) {
					    	pd.put("keywords", keywords);
					    	page.setPd(pd);
					    }
					    String start=pd.getString("start");
						if(start!=null && !"".equals(start)) {
						start=start+" 00:00:00";
						pd.put("start", start);
						page.setPd(pd);
						}
						
						String end=pd.getString("end");
						if(end !=null && !"".equals(end)) {
						end=end+" 23:59:59";
						pd.put("end", end);
						page.setPd(pd);
						}
						pd.put("isAlreadyPub", 1);//已经发布的活动
						page.setPd(pd);
						List<PageData> listOrganizerInfo = activitySqlManager.getOrganizerInfoPublistActivity(page);
						for (PageData pageData : listOrganizerInfo) {
							float sumSoloActivityDealMoney = 0;
							TdOrganizerInfo tdOrganizerInfo =new TdOrganizerInfo();
							tdOrganizerInfo.setUserId(pageData.getString("user_id"));
							TdOrganizerInfo tdOrganizerInfo2 =service.queryOne(tdOrganizerInfo);
							pageData.put("userNames", tdOrganizerInfo2.getName());
							   //统计单独一个的活动成交金额							
							sumSoloActivityDealMoney = activityUenrollAndActivityService.sumSoloActivityDealMoney(pageData.getString("activity_id"));
							pageData.put("sumSoloActivityDealMoney", sumSoloActivityDealMoney);
						 
							 //统计报名人数
							TdUenrollandactivity tdUenrollandactivity = new TdUenrollandactivity();				
							tdUenrollandactivity.setActivityId(pageData.getString("activity_id"));
							pageData.put("countEnrollPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivity));
							//待发放提成金额
							 float sumSoloActivityWaitPayExtract = 0;
							 sumSoloActivityWaitPayExtract = activityUenrollAndActivityService.getSumSoloActivityWaitPayExtract(pageData.getString("activity_id"));
							 pageData.put("sumSoloActivityWaitPayExtract", sumSoloActivityWaitPayExtract);
							 //应发提成
							 float sumSoloActivityShouldPubPayExtract = 0;
							
							 sumSoloActivityShouldPubPayExtract = activityUenrollAndActivityService.getSumSoloActivityShouldPubPayExtract(pageData.getString("activity_id"));
							 pageData.put("shouldPubMoney", sumSoloActivityShouldPubPayExtract);
							 
							   //签到人数
								TdUenrollandactivity tdUenrollandactivitySignIn = new TdUenrollandactivity();				
								tdUenrollandactivitySignIn.setActivityId(pageData.getString("activity_id"));
								tdUenrollandactivitySignIn.setUsersignStatus(1);
								pageData.put("countEnrollSignInPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivitySignIn));
							 //成交人数,已经成交
								TdUenrollandactivity tdUenrollandactivityDeal = new TdUenrollandactivity();				
								tdUenrollandactivityDeal.setActivityId(pageData.getString("activity_id"));
								tdUenrollandactivityDeal.setDealStatus(1);
								pageData.put("countEnrollDealPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivityDeal));
							 
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
						mv.setViewName("system/activity/pubActivityOrganizerInfo_list");
						mv.addObject("listOrganizerInfo",listOrganizerInfo);
						mv.addObject("QX",Jurisdiction.getHC());//按钮权限
						mv.addObject("pd", pd);
						return mv;
	         }
		   //已结束
		
		   @SuppressWarnings("unlikely-arg-type")
			@RequestMapping(value="goListEndActivityOrganizerInfo")
			   public ModelAndView goListEndActivityOrganizerInfo(Page page)throws Exception {
							ModelAndView mv = this.getModelAndView();
							PageData pd = new PageData();
							pd = this.getPageData();
							pd.put("USERNAME",Jurisdiction.getUsername());
							/*PageData user=this.um.findByUsername(pd);//通过用户名找出用户
	*/						/*TdUser tdUser = clientUserService.queryById(Jurisdiction.getUsername());*/
						    pd.put("userId", Jurisdiction.getUsername());
						    String keywords = pd.getString("keywords");
						    if(!"".equals(keywords)&&keywords!=null) {
						    	pd.put("keywords", keywords);
						    	page.setPd(pd);
						    }
						    String start=pd.getString("start");
							if(start!=null && !"".equals(start)) {
							start=start+" 00:00:00";
							pd.put("start", start);
							page.setPd(pd);
							}
							
							String end=pd.getString("end");
							if(end !=null && !"".equals(end)) {
							end=end+" 23:59:59";
							pd.put("end", end);
							page.setPd(pd);
							}
							pd.put("activityStatus", 2);//查询结束的活动
							page.setPd(pd);
							
							List<PageData> listOrganizerInfo = activitySqlManager.getOrganizerInfoPublistActivity(page);
							for (PageData pageData : listOrganizerInfo) {
								float sumSoloActivityDealMoney = 0;
								TdOrganizerInfo tdOrganizerInfo =new TdOrganizerInfo();
								tdOrganizerInfo.setUserId(pageData.getString("user_id"));
								TdOrganizerInfo tdOrganizerInfo2 =service.queryOne(tdOrganizerInfo);
								pageData.put("userNames", tdOrganizerInfo2.getName());
								   //统计单独一个的活动成交金额							
								sumSoloActivityDealMoney = activityUenrollAndActivityService.sumSoloActivityDealMoney(pageData.getString("activity_id"));
								pageData.put("sumSoloActivityDealMoney", sumSoloActivityDealMoney);
							 
								 //统计报名人数
								TdUenrollandactivity tdUenrollandactivity = new TdUenrollandactivity();				
								tdUenrollandactivity.setActivityId(pageData.getString("activity_id"));
								pageData.put("countEnrollPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivity));
								//待发放提成金额
								 float sumSoloActivityWaitPayExtract = 0;
								 sumSoloActivityWaitPayExtract = activityUenrollAndActivityService.getSumSoloActivityWaitPayExtract(pageData.getString("activity_id"));
								 pageData.put("sumSoloActivityWaitPayExtract", sumSoloActivityWaitPayExtract);
								 //应发提成
								 float sumSoloActivityShouldPubPayExtract = 0;
								
								 sumSoloActivityShouldPubPayExtract = activityUenrollAndActivityService.getSumSoloActivityShouldPubPayExtract(pageData.getString("activity_id"));
								 pageData.put("shouldPubMoney", sumSoloActivityShouldPubPayExtract);
								 
								   //签到人数
									TdUenrollandactivity tdUenrollandactivitySignIn = new TdUenrollandactivity();				
									tdUenrollandactivitySignIn.setActivityId(pageData.getString("activity_id"));
									tdUenrollandactivitySignIn.setUsersignStatus(1);
									pageData.put("countEnrollSignInPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivitySignIn));
								 //成交人数,已经成交
									TdUenrollandactivity tdUenrollandactivityDeal = new TdUenrollandactivity();				
									tdUenrollandactivityDeal.setActivityId(pageData.getString("activity_id"));
									tdUenrollandactivityDeal.setDealStatus(1);
									pageData.put("countEnrollDealPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivityDeal));
								 
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
							mv.setViewName("system/activity/endActivityOrganizerInfo_list");
							mv.addObject("listOrganizerInfo",listOrganizerInfo);
							mv.addObject("QX",Jurisdiction.getHC());//按钮权限
							mv.addObject("pd", pd);
							return mv;
		         }
		   //已下架
		   @SuppressWarnings("unlikely-arg-type")
			@RequestMapping(value="goListUnderActivityOrganizerInfo")
			   public ModelAndView goListUnderActivityOrganizerInfo(Page page)throws Exception {
							ModelAndView mv = this.getModelAndView();
							PageData pd = new PageData();
							pd = this.getPageData();
							pd.put("USERNAME",Jurisdiction.getUsername());
							/*PageData user=this.um.findByUsername(pd);//通过用户名找出用户
	*/						/*TdUser tdUser = clientUserService.queryById(Jurisdiction.getUsername());*/
						    pd.put("userId", Jurisdiction.getUsername());
						    String keywords = pd.getString("keywords");
						    if(!"".equals(keywords)&&keywords!=null) {
						    	pd.put("keywords", keywords);
						    	page.setPd(pd);
						    }
						    String start=pd.getString("start");
							if(start!=null && !"".equals(start)) {
							start=start+" 00:00:00";
							pd.put("start", start);
							page.setPd(pd);
							}
							
							String end=pd.getString("end");
							if(end !=null && !"".equals(end)) {
							end=end+" 23:59:59";
							pd.put("end", end);
							page.setPd(pd);
							}
							pd.put("isUnder", 2);//查询已经下架的活动
							page.setPd(pd);
							
							List<PageData> listOrganizerInfo = activitySqlManager.getOrganizerInfoPublistActivity(page);
							for (PageData pageData : listOrganizerInfo) {
								float sumSoloActivityDealMoney = 0;
								TdOrganizerInfo tdOrganizerInfo =new TdOrganizerInfo();
								tdOrganizerInfo.setUserId(pageData.getString("user_id"));
								TdOrganizerInfo tdOrganizerInfo2 =service.queryOne(tdOrganizerInfo);
								pageData.put("userNames", tdOrganizerInfo2.getName());
								   //统计单独一个的活动成交金额							
								sumSoloActivityDealMoney = activityUenrollAndActivityService.sumSoloActivityDealMoney(pageData.getString("activity_id"));
								pageData.put("sumSoloActivityDealMoney", sumSoloActivityDealMoney);
							 
								 //统计报名人数
								TdUenrollandactivity tdUenrollandactivity = new TdUenrollandactivity();				
								tdUenrollandactivity.setActivityId(pageData.getString("activity_id"));
								pageData.put("countEnrollPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivity));
								//待发放提成金额
								 float sumSoloActivityWaitPayExtract = 0;
								 sumSoloActivityWaitPayExtract = activityUenrollAndActivityService.getSumSoloActivityWaitPayExtract(pageData.getString("activity_id"));
								 pageData.put("sumSoloActivityWaitPayExtract", sumSoloActivityWaitPayExtract);
								 //应发提成
								 float sumSoloActivityShouldPubPayExtract = 0;
								
								 sumSoloActivityShouldPubPayExtract = activityUenrollAndActivityService.getSumSoloActivityShouldPubPayExtract(pageData.getString("activity_id"));
								 pageData.put("shouldPubMoney", sumSoloActivityShouldPubPayExtract);
								 
								   //签到人数
									TdUenrollandactivity tdUenrollandactivitySignIn = new TdUenrollandactivity();				
									tdUenrollandactivitySignIn.setActivityId(pageData.getString("activity_id"));
									tdUenrollandactivitySignIn.setUsersignStatus(1);
									pageData.put("countEnrollSignInPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivitySignIn));
								 //成交人数,已经成交
									TdUenrollandactivity tdUenrollandactivityDeal = new TdUenrollandactivity();				
									tdUenrollandactivityDeal.setActivityId(pageData.getString("activity_id"));
									tdUenrollandactivityDeal.setDealStatus(1);
									pageData.put("countEnrollDealPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivityDeal));
								 
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
							mv.setViewName("system/activity/underActivityOrganizerInfo_list");
							mv.addObject("listOrganizerInfo",listOrganizerInfo);
							mv.addObject("QX",Jurisdiction.getHC());//按钮权限
							mv.addObject("pd", pd);
							return mv;
		         }
		   //草稿箱
		   @SuppressWarnings("unlikely-arg-type")
			@RequestMapping(value="goListDraftActivityOrganizerInfo")
			   public ModelAndView goListDraftActivityOrganizerInfo(Page page)throws Exception {
							ModelAndView mv = this.getModelAndView();
							PageData pd = new PageData();
							pd = this.getPageData();
							pd.put("USERNAME",Jurisdiction.getUsername());
							/*PageData user=this.um.findByUsername(pd);//通过用户名找出用户
	*/						/*TdUser tdUser = clientUserService.queryById(Jurisdiction.getUsername());*/
						    pd.put("userId", Jurisdiction.getUsername());
						    String keywords = pd.getString("keywords");
						    if(!"".equals(keywords)&&keywords!=null) {
						    	pd.put("keywords", keywords);
						    	page.setPd(pd);
						    }
						    String start=pd.getString("start");
							if(start!=null && !"".equals(start)) {
							start=start+" 00:00:00";
							pd.put("start", start);
							page.setPd(pd);
							}
							
							String end=pd.getString("end");
							if(end !=null && !"".equals(end)) {
							end=end+" 23:59:59";
							pd.put("end", end);
							page.setPd(pd);
							}
							pd.put("isDraft", 2);//查询已经下架的活动
							page.setPd(pd);
							
							List<PageData> listOrganizerInfo = activitySqlManager.getOrganizerInfoPublistActivity(page);
							for (PageData pageData : listOrganizerInfo) {
								float sumSoloActivityDealMoney = 0;
								TdOrganizerInfo tdOrganizerInfo =new TdOrganizerInfo();
								tdOrganizerInfo.setUserId(pageData.getString("user_id"));
								TdOrganizerInfo tdOrganizerInfo2 =service.queryOne(tdOrganizerInfo);
								pageData.put("userNames", tdOrganizerInfo2.getName());
								   //统计单独一个的活动成交金额							
								sumSoloActivityDealMoney = activityUenrollAndActivityService.sumSoloActivityDealMoney(pageData.getString("activity_id"));
								pageData.put("sumSoloActivityDealMoney", sumSoloActivityDealMoney);
							 
								 //统计报名人数
								TdUenrollandactivity tdUenrollandactivity = new TdUenrollandactivity();				
								tdUenrollandactivity.setActivityId(pageData.getString("activity_id"));
								pageData.put("countEnrollPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivity));
								//待发放提成金额
								 float sumSoloActivityWaitPayExtract = 0;
								 sumSoloActivityWaitPayExtract = activityUenrollAndActivityService.getSumSoloActivityWaitPayExtract(pageData.getString("activity_id"));
								 pageData.put("sumSoloActivityWaitPayExtract", sumSoloActivityWaitPayExtract);
								 //应发提成
								 float sumSoloActivityShouldPubPayExtract = 0;
								
								 sumSoloActivityShouldPubPayExtract = activityUenrollAndActivityService.getSumSoloActivityShouldPubPayExtract(pageData.getString("activity_id"));
								 pageData.put("shouldPubMoney", sumSoloActivityShouldPubPayExtract);
								 
								   //签到人数
									TdUenrollandactivity tdUenrollandactivitySignIn = new TdUenrollandactivity();				
									tdUenrollandactivitySignIn.setActivityId(pageData.getString("activity_id"));
									tdUenrollandactivitySignIn.setUsersignStatus(1);
									pageData.put("countEnrollSignInPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivitySignIn));
								 //成交人数,已经成交
									TdUenrollandactivity tdUenrollandactivityDeal = new TdUenrollandactivity();				
									tdUenrollandactivityDeal.setActivityId(pageData.getString("activity_id"));
									tdUenrollandactivityDeal.setDealStatus(1);
									pageData.put("countEnrollDealPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivityDeal));
								 
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
							mv.setViewName("system/activity/draftActivityOrganizerInfo_list");
							mv.addObject("listOrganizerInfo",listOrganizerInfo);
							mv.addObject("QX",Jurisdiction.getHC());//按钮权限
							mv.addObject("pd", pd);
							return mv;
		         }
		   
		   //被举报
		   @SuppressWarnings("unlikely-arg-type")
			@RequestMapping(value="goListReportActivityOrganizerInfo")
			   public ModelAndView goListReportActivityOrganizerInfo(Page page)throws Exception {
							ModelAndView mv = this.getModelAndView();
							PageData pd = new PageData();
							pd = this.getPageData();
							pd.put("USERNAME",Jurisdiction.getUsername());
							/*PageData user=this.um.findByUsername(pd);//通过用户名找出用户
	*/						/*TdUser tdUser = clientUserService.queryById(Jurisdiction.getUsername());*/
						    pd.put("userId", Jurisdiction.getUsername());
						    String keywords = pd.getString("keywords");
						    if(!"".equals(keywords)&&keywords!=null) {
						    	pd.put("keywords", keywords);
						    	page.setPd(pd);
						    }
						    String start=pd.getString("start");
							if(start!=null && !"".equals(start)) {
							start=start+" 00:00:00";
							pd.put("start", start);
							page.setPd(pd);
							}
							
							String end=pd.getString("end");
							if(end !=null && !"".equals(end)) {
							end=end+" 23:59:59";
							pd.put("end", end);
							page.setPd(pd);
							}
						    pd.put("isReport", 1);
							page.setPd(pd);
							List<PageData> listOrganizerInfo = new ArrayList<>();
							List<PageData> listAllOrganizerInfo = activitySqlManager.getOrganizerInfoPublistActivity(page);
							for (PageData pageData : listAllOrganizerInfo) {
								float sumSoloActivityDealMoney = 0;
								TdOrganizerInfo tdOrganizerInfo =new TdOrganizerInfo();
								tdOrganizerInfo.setUserId(pageData.getString("user_id"));
								TdOrganizerInfo tdOrganizerInfo2 =service.queryOne(tdOrganizerInfo);
								pageData.put("userNames", tdOrganizerInfo2.getName());
								   //统计单独一个的活动成交金额							
								sumSoloActivityDealMoney = activityUenrollAndActivityService.sumSoloActivityDealMoney(pageData.getString("activity_id"));
								pageData.put("sumSoloActivityDealMoney", sumSoloActivityDealMoney);
							 
								 //统计报名人数
								TdUenrollandactivity tdUenrollandactivity = new TdUenrollandactivity();				
								tdUenrollandactivity.setActivityId(pageData.getString("activity_id"));
								pageData.put("countEnrollPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivity));
								//待发放提成金额
								 float sumSoloActivityWaitPayExtract = 0;
								 sumSoloActivityWaitPayExtract = activityUenrollAndActivityService.getSumSoloActivityWaitPayExtract(pageData.getString("activity_id"));
								 pageData.put("sumSoloActivityWaitPayExtract", sumSoloActivityWaitPayExtract);
								 //应发提成
								 float sumSoloActivityShouldPubPayExtract = 0;
								
								 sumSoloActivityShouldPubPayExtract = activityUenrollAndActivityService.getSumSoloActivityShouldPubPayExtract(pageData.getString("activity_id"));
								 pageData.put("shouldPubMoney", sumSoloActivityShouldPubPayExtract);
								 
								   //签到人数
									TdUenrollandactivity tdUenrollandactivitySignIn = new TdUenrollandactivity();				
									tdUenrollandactivitySignIn.setActivityId(pageData.getString("activity_id"));
									tdUenrollandactivitySignIn.setUsersignStatus(1);
									pageData.put("countEnrollSignInPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivitySignIn));
								 //成交人数,已经成交
									TdUenrollandactivity tdUenrollandactivityDeal = new TdUenrollandactivity();				
									tdUenrollandactivityDeal.setActivityId(pageData.getString("activity_id"));
									tdUenrollandactivityDeal.setDealStatus(1);
									pageData.put("countEnrollDealPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivityDeal));
								 
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
                                    if(reportService.queryTotalCount(tdReport)>0) {
                                    	listOrganizerInfo.add(pageData);
									}
							}
							mv.setViewName("system/activity/reportActivityOrganizerInfo_list");
							mv.addObject("listOrganizerInfo",listOrganizerInfo);
							mv.addObject("QX",Jurisdiction.getHC());//按钮权限
							mv.addObject("pd", pd);
							return mv;
		         }
		   //被投诉
		   @SuppressWarnings("unlikely-arg-type")
			@RequestMapping(value="goListComplainActivityOrganizerInfo")
			   public ModelAndView goListComplainActivityOrganizerInfo(Page page)throws Exception {
							ModelAndView mv = this.getModelAndView();
							PageData pd = new PageData();
							pd = this.getPageData();
							pd.put("USERNAME",Jurisdiction.getUsername());
							/*PageData user=this.um.findByUsername(pd);//通过用户名找出用户
	*/						/*TdUser tdUser = clientUserService.queryById(Jurisdiction.getUsername());*/
						    pd.put("userId", Jurisdiction.getUsername());
						    String keywords = pd.getString("keywords");
						    if(!"".equals(keywords)&&keywords!=null) {
						    	pd.put("keywords", keywords);
						    	page.setPd(pd);
						    }
						    String start=pd.getString("start");
							if(start!=null && !"".equals(start)) {
							start=start+" 00:00:00";
							pd.put("start", start);
							page.setPd(pd);
							}
							
							String end=pd.getString("end");
							if(end !=null && !"".equals(end)) {
							end=end+" 23:59:59";
							pd.put("end", end);
							page.setPd(pd);
							}
							 pd.put("isComplaint", 1);
							page.setPd(pd);
							List<PageData> listOrganizerInfo = new ArrayList<>();
							List<PageData> listAllOrganizerInfo = activitySqlManager.getOrganizerInfoPublistActivity(page);
							for (PageData pageData : listAllOrganizerInfo) {
								float sumSoloActivityDealMoney = 0;
								TdOrganizerInfo tdOrganizerInfo =new TdOrganizerInfo();
								tdOrganizerInfo.setUserId(pageData.getString("user_id"));
								TdOrganizerInfo tdOrganizerInfo2 =service.queryOne(tdOrganizerInfo);
								pageData.put("userNames", tdOrganizerInfo2.getName());
								   //统计单独一个的活动成交金额							
								sumSoloActivityDealMoney = activityUenrollAndActivityService.sumSoloActivityDealMoney(pageData.getString("activity_id"));
								pageData.put("sumSoloActivityDealMoney", sumSoloActivityDealMoney);
							 
								 //统计报名人数
								TdUenrollandactivity tdUenrollandactivity = new TdUenrollandactivity();				
								tdUenrollandactivity.setActivityId(pageData.getString("activity_id"));
								pageData.put("countEnrollPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivity));
								//待发放提成金额
								 float sumSoloActivityWaitPayExtract = 0;
								 sumSoloActivityWaitPayExtract = activityUenrollAndActivityService.getSumSoloActivityWaitPayExtract(pageData.getString("activity_id"));
								 pageData.put("sumSoloActivityWaitPayExtract", sumSoloActivityWaitPayExtract);
								 //应发提成
								 float sumSoloActivityShouldPubPayExtract = 0;
								
								 sumSoloActivityShouldPubPayExtract = activityUenrollAndActivityService.getSumSoloActivityShouldPubPayExtract(pageData.getString("activity_id"));
								 pageData.put("shouldPubMoney", sumSoloActivityShouldPubPayExtract);
								 
								   //签到人数
									TdUenrollandactivity tdUenrollandactivitySignIn = new TdUenrollandactivity();				
									tdUenrollandactivitySignIn.setActivityId(pageData.getString("activity_id"));
									tdUenrollandactivitySignIn.setUsersignStatus(1);
									pageData.put("countEnrollSignInPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivitySignIn));
								 //成交人数,已经成交
									TdUenrollandactivity tdUenrollandactivityDeal = new TdUenrollandactivity();				
									tdUenrollandactivityDeal.setActivityId(pageData.getString("activity_id"));
									tdUenrollandactivityDeal.setDealStatus(1);
									pageData.put("countEnrollDealPerson", activityUenrollAndActivityService.queryTotalCount(tdUenrollandactivityDeal));
								 
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
                                   if(complaintService.queryTotalCount(tdComplaint)>0) {
                                   	listOrganizerInfo.add(pageData);
									}
							}
							mv.setViewName("system/activity/complaintActivityOrganizerInfo_list");
							mv.addObject("listOrganizerInfo",listOrganizerInfo);
							mv.addObject("QX",Jurisdiction.getHC());//按钮权限
							mv.addObject("pd", pd);
							return mv;
		         }
		   
		   //新建
		   
		   @RequestMapping(value="/goNewPubActivityOrganizerInfo")
			public ModelAndView goNewPubActivityOrganizerInfo(Page page)throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				//活动类别集合
				List<TdActivitycategory> listActivitycategory= activityTypeService.queryAll();
				//活动音乐集合
				List<TdActivitymusicurl> listActivitymusicurl =activityMusicService.queryAll();
				//报名填写项目
				List<TdActivityFillInItem> listMustFillTdActivityFillInItem = activityFillInItemService.listMustFillTdActivityFillInItem();
				
				pd.put("userId",Jurisdiction.getUsername());
				pd = this.getPageData();
				mv.setViewName("system/activity/newActivityOrganizerInfo_add");
				mv.addObject("msg", "saveU");
				mv.addObject("listActivitycategory", listActivitycategory);
				mv.addObject("listActivitymusicurl", listActivitymusicurl);
				mv.addObject("listMustFillTdActivityFillInItem", listMustFillTdActivityFillInItem);
				mv.addObject("pd", pd);
				return mv;
			}
		   
		   //批量删除
		   @RequestMapping(value="/deleteAllActivity")
			@ResponseBody
			public Object deleteAllActivity() throws Exception {
				
				FHLOG.save(Jurisdiction.getUsername(), "批量删除position");
				TdActivity tdActivity = new TdActivity();
				PageData pd = new PageData();
				List<PageData> pdList = new ArrayList<PageData>();
				Map<String,Object> map = new HashMap<String,Object>();
				pd = this.getPageData();
			/*	String Position_IDS = pd.getString("Activity_IDS");
				activityService.delAllActivity(Position_IDS);*/
				String Activity_IDS = pd.getString("Activity_IDS");
				if(null != Activity_IDS && !"".equals(Activity_IDS)){
					String ArrayActivity_IDS[] = Activity_IDS.split(",");
//					userService.deleteAllU(ArrayPosition_IDS);
					
					activitySqlManager.deleteActivity(ArrayActivity_IDS);
					pd.put("msg", "ok");
				}else{
					pd.put("msg", "no");
				}
				
				pdList.add(pd);
				map.put("list", pdList);
				return AppUtil.returnObject(pd, map);
			}
		   //发布活动
		   @RequestMapping(value="/goOrganizerInfoAddActivity")
			public ModelAndView goOrganizerInfoAddActivity(Page page)throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				//活动类别集合
				List<TdActivitycategory> listActivitycategory= activityTypeService.queryAll();
				//活动音乐集合
				List<TdActivitymusicurl> listActivitymusicurl =activityMusicService.queryAll();
				//报名填写项目
				List<TdActivityFillInItem> listMustFillTdActivityFillInItem = activityFillInItemService.listMustFillTdActivityFillInItem();
				
				pd.put("userId",Jurisdiction.getUsername());
				pd = this.getPageData();
				mv.setViewName("system/activity/pubActivityOrganizerInfo_add");
				mv.addObject("msg", "saveU");
				mv.addObject("listActivitycategory", listActivitycategory);
				mv.addObject("listActivitymusicurl", listActivitymusicurl);
				mv.addObject("listMustFillTdActivityFillInItem", listMustFillTdActivityFillInItem);
				mv.addObject("pd", pd);
				return mv;
			}
		   //主办方发布活动
		   /*
		   */
		   @RequestMapping(value="/sendOrganizerInfoAddActivity")
			@ResponseBody
			public Object sendOrganizerInfoAddActivity() throws MessagingException, ParseException{
			 
				PageData pd = new PageData();
				pd = this.getPageData();
				Map<String,Object> map = new HashMap<String,Object>();
				
				//活动名字
				   String activityName = pd.getString("activityName");
				   //活动类别
				   String activitycategoryId = pd.getString("activitycategoryId");
				  //活动开始结束，报名开始结束时间
				   String avtivitySignUpStartTime = pd.getString("avtivitySignUpStartTime");
				   String avtivitySignUpEndTime = pd.getString("avtivitySignUpEndTime");	   
				   String activityStartTime = pd.getString("activityStartTime");
				   String activityEndTime = pd.getString("activityEndTime");
				  //报名人数
				   String activitySignUpPersonNumber = pd.getString("activitySignUpPersonNumber");
				  //活动费用类型
				   String activityCostType1 = pd.getString("activityCostType1");
				   String activityCostType2 = pd.getString("activityCostType2");
				   //如果为收费，则收费项目数组
				   String costProjectmInfoSaveArray = pd.getString("costProjectmInfoSaveArray");
                  //客户匹配区域
				   String pid = pd.getString("pid");
				   String cid = pd.getString("cid");
				   String did = pd.getString("did");
				   //活动类型 线上，线下
				
				   String activityOnlineStatus1 = pd.getString("activityOnlineStatus1");
				   String activityOnlineStatus2 = pd.getString("activityOnlineStatus2");

				   //选择类型状态为线下时：线下
				   String pid2 = pd.getString("pid2");
				   String cid2 = pd.getString("cid2");
				   String did2 = pd.getString("did2");
				   String detailedAddress = pd.getString("detailedAddress");
				   
				 
				   //活动封面
				   String activity_cover_img = pd.getString("activity_cover_img");
				   //分享摘要
				   String shareSummary = pd.getString("shareSummary");
				   //邀约提成设置
				   String isInvitationActivityRoyalty1 = pd.getString("isInvitationActivityRoyalty1");
				   String isInvitationActivityRoyalty2 = pd.getString("isInvitationActivityRoyalty2");

				   //如果是 邀约提成比例				
				   String invitationActivityRoyaltyRate = pd.getString("invitationActivityRoyaltyRate");
				  //活动音乐
				   String activitymusicId = pd.getString("activitymusicId");
				 
				  //活动富文本详情
				   String CONTENT = pd.getString("CONTENT");				//内容
				   //报名填写项数组
				   String createInputCountSumOtherArray = pd.getString("createInputCountSumOtherArray");
				  //活动在线状态，保存为草稿，直接发布上线 
				   String onlineStatus = pd.getString("onlineStatus");
				   String msg = "ok";		//发送状态
				int count = 0;			//统计发送成功条数
				int zcount = 0;			//理论条数
			    List<PageData> pdList = new ArrayList<PageData>();
		
				
				String TYPE = pd.getString("TYPE");						//类型
				
				String fmsg = pd.getString("fmsg");						//判断是系统用户还是会员 "appuser"为会员用户
			  
	        	TdActivity tdActivity = new TdActivity();
	        	tdActivity.setActivityId(this.get32UUID());
	        	
	        	tdActivity.setUserId(Jurisdiction.getUsername());
	        	
	        	TdUser tdUser = new TdUser();
	        	tdUser.setUserId(Jurisdiction.getUsername());
	        	TdUser tdUserFinal = clientUserService.queryOne(tdUser);
	        	if(tdUserFinal!=null) {
	        		tdActivity.setUserNickName(tdUserFinal.getuNickname());
	        		
	        	}
	        	tdActivity.setActivityName(activityName);
	        	tdActivity.setActivitycategoryId(activitycategoryId);
	        	TdActivitycategory tdActivitycategory = activityTypeService.queryById(activitycategoryId);
	        	if(tdActivitycategory!=null) {
	        		tdActivity.setActivitycategoryName(tdActivitycategory.getActivitycategoryName());
	        	}
	        	//活动开始结束，报名开始结束时间
	           /* System.out.println("ccc"+avtivitySignUpStartTime);*/
	        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	        
	        	String curDate = df.format(new Date());
	        	String     avtivitySignUpStartTime2 = splitStringPubActivityTime(avtivitySignUpStartTime);
	        	String     avtivitySignUpEndTime2 = splitStringPubActivityTime(avtivitySignUpEndTime);
	        	String     activityStartTime2 = splitStringPubActivityTime(activityStartTime);
	        	String     activityEndTime2 = splitStringPubActivityTime(activityEndTime);
		           
	        	
	        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        	tdActivity.setActivitysignStarttime(avtivitySignUpStartTime2);
	        	tdActivity.setActivitysignEndtime(avtivitySignUpEndTime2);
	        	tdActivity.setActivitystartTime(activityStartTime2);
	        	tdActivity.setActivityendTime(activityEndTime2);
	        	//活动状态
	        	int result = compareTime1AndTime2(activityStartTime2,activityEndTime2);
	        	tdActivity.setActivityStatus(result);
	        	//报名状态
	        	int resultSign = compareTime1AndTime2(avtivitySignUpStartTime2,avtivitySignUpEndTime2);
	        	tdActivity.setActivitySignupstatus(resultSign);
	        	//1活动报名状态
	        	//报名未开始
	        	if(StringTimeToLong(curDate)<StringTimeToLong(avtivitySignUpStartTime2)) {
	        		tdActivity.setActivitySignupstatus(0);
	        	}
	        	//报名进行中
	        	if(StringTimeToLong(avtivitySignUpEndTime2)>StringTimeToLong(curDate)&&StringTimeToLong(curDate)>StringTimeToLong(avtivitySignUpStartTime2)) {
	        		tdActivity.setActivitySignupstatus(1);
	        	}
	        	//报名结束
	        	if(StringTimeToLong(avtivitySignUpEndTime2)<StringTimeToLong(curDate)) {
	        		tdActivity.setActivitySignupstatus(2);
	        	}
	        	//2活动开始结束状态
	        	//活动未开始
	        	if(StringTimeToLong(activityStartTime2)>StringTimeToLong(curDate)) {
	        		tdActivity.setActivitySignupstatus(0);
	        	}
	        	//活动进行中
	        	if(StringTimeToLong(activityStartTime2)<StringTimeToLong(curDate)&&StringTimeToLong(activityEndTime2)>StringTimeToLong(curDate)) {
	        		tdActivity.setActivitySignupstatus(1);
	        	}
	        	//活动已经结束
	        	if(StringTimeToLong(activityStartTime2)<StringTimeToLong(curDate)) {
	        		tdActivity.setActivitySignupstatus(2);
	        	}
	        	//活动状态
	        	//人数
	        	if(!"".equals(activitySignUpPersonNumber)&&activitySignUpPersonNumber!=null) {
	        		
	        		Integer activitySignUpPersonNumbers = Integer.parseInt(activitySignUpPersonNumber);
	        		tdActivity.setActivityCountpersons(activitySignUpPersonNumbers);
	        		
	        	}
	        	//活动匹配区域
	        	
	        /*	tdActivity.setPrecisionDemandProvinceId(pid);
	        	tdActivity.setPrecisionDemandCityId(cid);
	        	tdActivity.setPrecisionDemandAreaId(did);*/
	        	String precisionDemandAddressName = "";
        		//省
        		if(!"".equals(pid)&&pid!=null) {
        			TdAddress tdAddress1 = tdAddressService.queryById(pid);
        			if(tdAddress1!=null) {
        				precisionDemandAddressName+=tdAddress1.getCityname();
        				tdActivity.setPrecisionDemandProvinceId(pid);
        			}else {
        				tdActivity.setPrecisionDemandProvinceId("000000");
        			}
        		}else {
        			tdActivity.setPrecisionDemandProvinceId("000000");
        		}
        		//市
        		if(!"".equals(cid)&&cid!=null) {
        			TdAddress tdAddress2 = tdAddressService.queryById(cid);		        			
        		    if(tdAddress2!=null) {
        		    	precisionDemandAddressName+=" "+tdAddress2.getCityname();
        		    	tdActivity.setPrecisionDemandCityId(cid);
        		    }else {
        		    	tdActivity.setPrecisionDemandCityId("000000");
        		    }
        		}else {
        			tdActivity.setPrecisionDemandCityId("000000");
        		}
        		//区
        		if(!"".equals(did)&&did!=null) {
        			TdAddress tdAddress3 = tdAddressService.queryById(did);		        			
        			if(tdAddress3!=null) {
        				precisionDemandAddressName+=" "+tdAddress3.getCityname();
        				tdActivity.setPrecisionDemandAreaId(did);
        			}else {
        				tdActivity.setPrecisionDemandAreaId("000000");
        			}
        		}else {
        			tdActivity.setPrecisionDemandAreaId("000000");
        		}
        		tdActivity.setPrecisionDemandAddressName(precisionDemandAddressName);   
	        
	        	//活动类型 线上，线下
	        	if(!"".equals(activityOnlineStatus1)&&activityOnlineStatus1!=null) {
	       
	        	Integer activityOnlineStatuss = Integer.parseInt(activityOnlineStatus1);
	            //线上
	        	 if(activityOnlineStatuss==1) {
	        		tdActivity.setActivityType(0);
	        	   }
	        	}
	        	
	        	//线下
	        	if(!"".equals(activityOnlineStatus2)&&activityOnlineStatus2!=null) {
	     	       
	        		
		        	Integer activityOnlineStatuss2 = Integer.parseInt(activityOnlineStatus2);
		        	//线下
		        	if(activityOnlineStatuss2==2) {
		        		tdActivity.setActivityType(1);
		        		/*tdActivity.setProvinceCitycode(pid2);
		        		tdActivity.setCityCitycode(cid2);
		        		tdActivity.setAreaCitycode(did2);*/
		        		String addressName = "";
		        		//省
		        		if(!"".equals(pid2)&&pid2!=null) {
		        			TdAddress tdAddress1 = tdAddressService.queryById(pid2);
		        			if(tdAddress1!=null) {
		        				addressName+=tdAddress1.getCityname();	
		        				tdActivity.setProvinceCitycode(pid2);
		        			}
		        		}
		        		//市
		        		if(!"".equals(cid2)&&cid2!=null) {
		        			TdAddress tdAddress2 = tdAddressService.queryById(cid2);		        			
		        		    if(tdAddress2!=null) {
		        		    	addressName+=" "+tdAddress2.getCityname();
		        		    	tdActivity.setCityCitycode(cid2);
		        		    }
		        		}
		        		//区
		        		if(!"".equals(did2)&&did2!=null) {
		        			TdAddress tdAddress3 = tdAddressService.queryById(did2);		        			
		        			if(tdAddress3!=null) {
		        				addressName+=" "+tdAddress3.getCityname();		
		        				tdActivity.setAreaCitycode(did2);
		        			}
		        		}
		        		tdActivity.setAddressName(addressName);
		        		
		        		
		        	}
		        }
	        	//详细地址
        	
        		tdActivity.setCitycode(detailedAddress);
	        	//活动封面图
        		String activityCoverImg[] = activity_cover_img.split("[?]");
        		String finalCoverImg = "";
        		if(activityCoverImg.length>1) {
        			finalCoverImg = activityCoverImg[0];
        		}else {
        			finalCoverImg = activity_cover_img;
        		}
	        	tdActivity.setActivityCoverimgurl("/"+getfinalUploadImg(finalCoverImg));
	        	//分享摘要
	        	tdActivity.setShareAbstract(shareSummary);
	        	//是否设置邀约提成
	        	//设置邀约提成
	        	if(!"".equals(isInvitationActivityRoyalty1)&&isInvitationActivityRoyalty1!=null) {
	        		
	        		Integer isInvitationActivityRoyaltys = Integer.parseInt(isInvitationActivityRoyalty1);
	        		if(isInvitationActivityRoyaltys==1) {
	        			BigDecimal setRoyaltyRatios=new BigDecimal(invitationActivityRoyaltyRate);
	        			tdActivity.setRoyaltyRatio(setRoyaltyRatios);
	        			tdActivity.setActivityIsextract(1);
	        		}
	        	}
	        	//未设置邀约提成
                   if(!"".equals(isInvitationActivityRoyalty2)&&isInvitationActivityRoyalty2!=null) {	        		
	        		Integer isInvitationActivityRoyaltys2 = Integer.parseInt(isInvitationActivityRoyalty2);
	        		if(isInvitationActivityRoyaltys2==2) {			
	        			tdActivity.setActivityIsextract(0);
	        		}
	        	}
	        	//活动音乐
	        	tdActivity.setActivitymusicId(activitymusicId);
	        	//活动详情，富文本图片修改
				
	        	tdActivity.setActivityDetailsurl(pubActivityEditorImage(editorFixImage(CONTENT)));
/*	        	System.out.println("n"+pubActivityEditorImage(editorFixImage(CONTENT)));
*/	        	if(!"".equals(onlineStatus)&&onlineStatus!=null) {
	        	Integer onlineStatuss=  Integer.parseInt(onlineStatus);
	        
	        	tdActivity.setOnlineStatus(onlineStatuss);
	        	}
	        	//免费
	        	if(!"".equals(activityCostType2)&&activityCostType2!=null) {
		        	Integer activityCostTypes2 = Integer.parseInt(activityCostType2);	
	        		tdActivity.setActivityChargestatus(0);

	        	}
	        	//收费
	        	if(!"".equals(activityCostType1)&&activityCostType1!=null) {	      
		        	Integer activityCostTypes = Integer.parseInt(activityCostType1);
		        	tdActivity.setActivityChargestatus(1);
	        	}
	        	int returnSaveResult =	activityService.saveSelective(tdActivity);
	            
              if(returnSaveResult==1) {
            	//报名填写项
            	if(!"".equals(createInputCountSumOtherArray)&&createInputCountSumOtherArray!=null) {
            	
  	        	String createInputCountSumOtherArrays[] = createInputCountSumOtherArray.split(",");
  		    
  	        	for (int i = 0; i < createInputCountSumOtherArrays.length; i++) {
  					
  	        		TdActivityFillInItem tActivityFillInItem = new TdActivityFillInItem();
  	        		tActivityFillInItem.setFillInItemId(this.get32UUID());
  	        		tActivityFillInItem.setActivityId(tdActivity.getActivityId());
  	        		tActivityFillInItem.setFillInItemName(createInputCountSumOtherArrays[i]);
  	        		tActivityFillInItem.setType(1);
  	        		activityFillInItemService.saveSelective(tActivityFillInItem);
  	        	}}
  	        //活动收费状态，1收费，2免费
	        	
	        	if(!"".equals(activityCostType1)&&activityCostType1!=null) {	      
	        	Integer activityCostTypes = Integer.parseInt(activityCostType1);
	       
	        		tdActivity.setActivityChargestatus(1);
	        		
	        				
	        		//收费项目数组
	        	
	        		String costProjectmInfoSaveArrays[] = costProjectmInfoSaveArray.split(",");	        		
	        		for (int i = 0; i < costProjectmInfoSaveArrays.length; i++) {
						//暂时无
	        			String costArrays[] =  costProjectmInfoSaveArrays[i].split(",");
	        			
	        			String costArrayFinal[] = costArrays[0].split(":");
	        			TdActivityChargeItem tdActivityChargeItem = new TdActivityChargeItem();
	        			if(costArrayFinal.length>1) {
	        				
	        				if(!"".equals(costArrayFinal[1])&&costArrayFinal[1]!=null&&!"undefined".equals(costArrayFinal[1])) {
	        					Double moneyNum = Double.parseDouble(costArrayFinal[1]);
	        					BigDecimal costMoney = new BigDecimal(Double.toString(moneyNum));
	        					tdActivityChargeItem.setActivityChargeItemMoney(costMoney);
	        					
	        				}
	        				if(!"".equals(costArrayFinal[0])&&costArrayFinal[0]!=null&&!"undefined".equals(costArrayFinal[0])) {	        				
	        					tdActivityChargeItem.setActivityChargeItemName(costArrayFinal[0]);
	        					tdActivityChargeItem.setActivityChargeItemId(this.get32UUID());
	        					tdActivityChargeItem.setActivityId(tdActivity.getActivityId());
	        					tdActivityChargeItem.setUserId(Jurisdiction.getUsername());
	        					activityProjectService.saveSelective(tdActivityChargeItem);
	        				}
	        			}
					}
	        
	        	}
	        	
	            	msg = "ok";
	            }else {
	            	msg = "error";
	            }
	 
				pd.put("msg", msg);
				pd.put("count", count);						//成功数
				pd.put("ecount", zcount-count);				//失败数
				pdList.add(pd);
				map.put("list", pdList);
				return AppUtil.returnObject(pd, map);
			}
		   
		   //修改主办方发布的活动
		   @RequestMapping(value="/goOrgEditActivity")
			public ModelAndView goOrgEditActivity() throws Exception{
		/*		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		*/		ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
				pd = this.getPageData();
				String activity_id = pd.getString("activity_id");
				TdActivity tdActivity = activityService.queryById(activity_id);
				/*pd = wm.findPositionByPidd(pd);	*/
				//活动类别集合
				List<TdActivitycategory> listActivitycategory= activityTypeService.queryAll();
				//活动音乐集合
				List<TdActivitymusicurl> listActivitymusicurl =activityMusicService.queryAll();
				
				//报名填写项目,必填
				List<TdActivityFillInItem> listMustFillTdActivityFillInItem = activityFillInItemService.listMustFillTdActivityFillInItem();
				//报名填写项非必填
				List<TdActivityFillInItem> listNotMustFillTdActivityFillInItem = activityFillInItemService.listNotMustFillTdActivityFillInItem(activity_id);
			
				//收费项目
				List<TdActivityChargeItem> activityprojectandacsigns = activityProjectService.getChargeProject(activity_id);
				tdActivity.setActivitystartTime(splitStringEditActivityTime(tdActivity.getActivitystartTime()));
				tdActivity.setActivityendTime(splitStringEditActivityTime(tdActivity.getActivityendTime()));
				tdActivity.setActivitysignStarttime(splitStringEditActivityTime(tdActivity.getActivitysignStarttime()));
				tdActivity.setActivitysignEndtime(splitStringEditActivityTime(tdActivity.getActivitysignEndtime()));
				
			/*	tdActivity.setRoyaltyRatio(royaltyRatio);*/
				TdAddress tdAddressP = tdAddressService.queryById(tdActivity.getProvinceCitycode());
				TdAddress tdAddressC = tdAddressService.queryById(tdActivity.getCityCitycode());
				TdAddress tdAddressA = tdAddressService.queryById(tdActivity.getAreaCitycode());
				TdAddress tdAddressPP = tdAddressService.queryById(tdActivity.getPrecisionDemandProvinceId());
				TdAddress tdAddressPC = tdAddressService.queryById(tdActivity.getPrecisionDemandCityId());
				TdAddress tdAddressPA = tdAddressService.queryById(tdActivity.getPrecisionDemandAreaId());
				
				mv.setViewName("system/activity/pubActivityOrganizerInfo_edit");
				mv.addObject("msg", "editU");
				mv.addObject("pd", pd);
				mv.addObject("tdActivity", tdActivity);
				mv.addObject("tdAddressP", tdAddressP);
				mv.addObject("tdAddressC", tdAddressC);
				mv.addObject("tdAddressA", tdAddressA);
				mv.addObject("tdAddressPP", tdAddressPP);
				mv.addObject("tdAddressPC", tdAddressPC);
				mv.addObject("tdAddressPA", tdAddressPA);
				mv.addObject("listActivitycategory", listActivitycategory);
				mv.addObject("listActivitymusicurl", listActivitymusicurl);
				mv.addObject("listMustFillTdActivityFillInItem", listMustFillTdActivityFillInItem);
				mv.addObject("listNotMustFillTdActivityFillInItem", listNotMustFillTdActivityFillInItem);
				mv.addObject("activityprojectandacsigns", activityprojectandacsigns);
				return mv;
			}
		   
		   //执行修改
		   @RequestMapping(value="/editOrganizerInfoActivity")
			@ResponseBody
			public Object editOrganizerInfoActivity() throws MessagingException, ParseException{
			 
				PageData pd = new PageData();
				pd = this.getPageData();
				Map<String,Object> map = new HashMap<String,Object>();
				//修改 活动id
				String activityId = pd.getString("activityId");
				//活动名字
				   String activityName = pd.getString("activityName");
				   //活动类别
				   String activitycategoryId = pd.getString("activitycategoryId");
				  //活动开始结束，报名开始结束时间
				   String avtivitySignUpStartTime = pd.getString("avtivitySignUpStartTime");
				   String avtivitySignUpEndTime = pd.getString("avtivitySignUpEndTime");	   
				   String activityStartTime = pd.getString("activityStartTime");
				   String activityEndTime = pd.getString("activityEndTime");
				  //报名人数
				   String activitySignUpPersonNumber = pd.getString("activitySignUpPersonNumber");
				  //活动费用类型
				   String activityCostType1 = pd.getString("activityCostType1");
				   String activityCostType2 = pd.getString("activityCostType2");
				   //如果为收费，则收费项目数组
				   String costProjectmInfoSaveArray = pd.getString("costProjectmInfoSaveArray");
                 //草稿保存好的收费项目
				   String returnCostProjectmInfoSaveArray = pd.getString("returnCostProjectmInfoSaveArray");
				   //客户匹配区域
				   String pid = pd.getString("pid");
				   String cid = pd.getString("cid");
				   String did = pd.getString("did");
				   //活动类型 线上，线下
				
				   String activityOnlineStatus1 = pd.getString("activityOnlineStatus1");
				   String activityOnlineStatus2 = pd.getString("activityOnlineStatus2");

				   //选择类型状态为线下时：线下
				   String pid2 = pd.getString("pid2");
				   String cid2 = pd.getString("cid2");
				   String did2 = pd.getString("did2");
				   String pid3 = pd.getString("pid3");
				   String cid3 = pd.getString("cid3");
				   String did3 = pd.getString("did3");
				   String detailedAddress = pd.getString("detailedAddress");
				   
				 
				   //活动封面
				   String activity_cover_img = pd.getString("activity_cover_img");
				   //分享摘要
				   String shareSummary = pd.getString("shareSummary");
				   //邀约提成设置
				   String isInvitationActivityRoyalty1 = pd.getString("isInvitationActivityRoyalty1");
				   String isInvitationActivityRoyalty2 = pd.getString("isInvitationActivityRoyalty2");

				   //如果是 邀约提成比例				
				   String invitationActivityRoyaltyRate = pd.getString("invitationActivityRoyaltyRate");
				  //活动音乐
				   String activitymusicId = pd.getString("activitymusicId");
				 
				  //活动富文本详情
				   String CONTENT = pd.getString("CONTENT");				//内容
				   //报名填写项数组
				   String createInputCountSumOtherArray = pd.getString("createInputCountSumOtherArray");
				  //草稿报名填写数组
				   String finalReturnInputCountSumOtherArray = pd.getString("finalReturnInputCountSumOtherArray");
				   //活动在线状态，保存为草稿，直接发布上线 
				   String onlineStatus = pd.getString("onlineStatus");
				   String msg = "ok";		//发送状态
				int count = 0;			//统计发送成功条数
				int zcount = 0;			//理论条数
			    List<PageData> pdList = new ArrayList<PageData>();
		
				
				String TYPE = pd.getString("TYPE");						//类型
				
				String fmsg = pd.getString("fmsg");						//判断是系统用户还是会员 "appuser"为会员用户
			  
	        	TdActivity tdActivity = new TdActivity();
	        	tdActivity.setActivityId(this.get32UUID());
	        	
	        	tdActivity.setUserId(Jurisdiction.getUsername());
	        	
	        	TdUser tdUser = new TdUser();
	        	tdUser.setUserId(Jurisdiction.getUsername());
	        	TdUser tdUserFinal = clientUserService.queryOne(tdUser);
	        	if(tdUserFinal!=null) {
	        		tdActivity.setUserNickName(tdUserFinal.getuNickname());
	        		
	        	}
	        	tdActivity.setActivityName(activityName);
	        	tdActivity.setActivitycategoryId(activitycategoryId);
	        	TdActivitycategory tdActivitycategory = activityTypeService.queryById(activitycategoryId);
	        	if(tdActivitycategory!=null) {
	        		tdActivity.setActivitycategoryName(tdActivitycategory.getActivitycategoryName());
	        	}
	        	//活动开始结束，报名开始结束时间
	           /* System.out.println("ccc"+avtivitySignUpStartTime);*/
	        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	        
	        	String curDate = df.format(new Date());
	        	String     avtivitySignUpStartTime2 = splitStringPubActivityTime(avtivitySignUpStartTime);
	        	String     avtivitySignUpEndTime2 = splitStringPubActivityTime(avtivitySignUpEndTime);
	        	String     activityStartTime2 = splitStringPubActivityTime(activityStartTime);
	        	String     activityEndTime2 = splitStringPubActivityTime(activityEndTime);
		           
	        	
	        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        	tdActivity.setActivitysignStarttime(avtivitySignUpStartTime2);
	        	tdActivity.setActivitysignEndtime(avtivitySignUpEndTime2);
	        	tdActivity.setActivitystartTime(activityStartTime2);
	        	tdActivity.setActivityendTime(activityEndTime2);
	        	//活动状态
	        	int result = compareTime1AndTime2(activityStartTime2,activityEndTime2);
	        	tdActivity.setActivityStatus(result);
	        	//报名状态
	        	int resultSign = compareTime1AndTime2(avtivitySignUpStartTime2,avtivitySignUpEndTime2);
	        	tdActivity.setActivitySignupstatus(resultSign);
	        	//1活动报名状态
	        	//报名未开始
	        	if(StringTimeToLong(curDate)<StringTimeToLong(avtivitySignUpStartTime2)) {
	        		tdActivity.setActivitySignupstatus(0);
	        	}
	        	//报名进行中
	        	if(StringTimeToLong(avtivitySignUpEndTime2)>StringTimeToLong(curDate)&&StringTimeToLong(curDate)>StringTimeToLong(avtivitySignUpStartTime2)) {
	        		tdActivity.setActivitySignupstatus(1);
	        	}
	        	//报名结束
	        	if(StringTimeToLong(avtivitySignUpEndTime2)<StringTimeToLong(curDate)) {
	        		tdActivity.setActivitySignupstatus(2);
	        	}
	        	//2活动开始结束状态
	        	//活动未开始
	        	if(StringTimeToLong(activityStartTime2)>StringTimeToLong(curDate)) {
	        		tdActivity.setActivitySignupstatus(0);
	        	}
	        	//活动进行中
	        	if(StringTimeToLong(activityStartTime2)<StringTimeToLong(curDate)&&StringTimeToLong(activityEndTime2)>StringTimeToLong(curDate)) {
	        		tdActivity.setActivitySignupstatus(1);
	        	}
	        	//活动已经结束
	        	if(StringTimeToLong(activityStartTime2)<StringTimeToLong(curDate)) {
	        		tdActivity.setActivitySignupstatus(2);
	        	}
	        	//活动状态
	        	//人数
	        	if(!"".equals(activitySignUpPersonNumber)&&activitySignUpPersonNumber!=null) {
	        		
	        		Integer activitySignUpPersonNumbers = Integer.parseInt(activitySignUpPersonNumber);
	        		tdActivity.setActivityCountpersons(activitySignUpPersonNumbers);
	        		
	        	}
	        	//活动匹配区域
	        	
	        /*	tdActivity.setPrecisionDemandProvinceId(pid);
	        	tdActivity.setPrecisionDemandCityId(cid);
	        	tdActivity.setPrecisionDemandAreaId(did);*/
	        	String precisionDemandAddressName = "";
       		//省
       		if(!"".equals(pid)&&pid!=null) {
       			TdAddress tdAddress1 = tdAddressService.queryById(pid);
       			if(tdAddress1!=null) {
       				precisionDemandAddressName+=tdAddress1.getCityname();
       				tdActivity.setPrecisionDemandProvinceId(pid);
       			}else {
       				tdActivity.setPrecisionDemandProvinceId("000000");
       			}
       		}else {
       			tdActivity.setPrecisionDemandProvinceId("000000");
       		}
       		//市
       		if(!"".equals(cid)&&cid!=null) {
       			TdAddress tdAddress2 = tdAddressService.queryById(cid);		        			
       		    if(tdAddress2!=null) {
       		    	precisionDemandAddressName+=" "+tdAddress2.getCityname();
       		    	tdActivity.setPrecisionDemandCityId(cid);
       		    }else {
       		    	tdActivity.setPrecisionDemandCityId("000000");
       		    }
       		}else {
       			tdActivity.setPrecisionDemandCityId("000000");
       		}
       		//区
       		if(!"".equals(did)&&did!=null) {
       			TdAddress tdAddress3 = tdAddressService.queryById(did);		        			
       			if(tdAddress3!=null) {
       				precisionDemandAddressName+=" "+tdAddress3.getCityname();
       				tdActivity.setPrecisionDemandAreaId(did);
       			}else {
       				tdActivity.setPrecisionDemandAreaId("000000");
       			}
       		}else {
       			tdActivity.setPrecisionDemandAreaId("000000");
       		}
       		tdActivity.setPrecisionDemandAddressName(precisionDemandAddressName);   
	        
	        	//活动类型 线上，线下
	        	if(!"".equals(activityOnlineStatus1)&&activityOnlineStatus1!=null) {
	       
	        	Integer activityOnlineStatuss = Integer.parseInt(activityOnlineStatus1);
	            //线上
	        	 if(activityOnlineStatuss==1) {
	        		tdActivity.setActivityType(0);
	        		tdActivity.setProvinceCitycode(" ");
	        		tdActivity.setCityCitycode(" ");
	        		tdActivity.setAreaCitycode(" ");
	        		tdActivity.setAddressName(" ");
	        	   }
	        	}
	        	
	        	//线下
	        	if(!"".equals(activityOnlineStatus2)&&activityOnlineStatus2!=null) {
	     	       
	        		
		        	Integer activityOnlineStatuss2 = Integer.parseInt(activityOnlineStatus2);
		        	//线下
		        	if(activityOnlineStatuss2==2) {
		        		tdActivity.setActivityType(1);
		        		/*tdActivity.setProvinceCitycode(pid2);
		        		tdActivity.setCityCitycode(cid2);
		        		tdActivity.setAreaCitycode(did2);*/
		        		String addressName = "";
		        		//省
		        		if(!"".equals(pid2)&&pid2!=null) {
		        			TdAddress tdAddress1 = tdAddressService.queryById(pid2);
		        			if(tdAddress1!=null) {
		        				addressName+=tdAddress1.getCityname();	
		        				tdActivity.setProvinceCitycode(pid2);
		        			}
		        		}
		        		//市
		        		if(!"".equals(cid2)&&cid2!=null) {
		        			TdAddress tdAddress2 = tdAddressService.queryById(cid2);		        			
		        		    if(tdAddress2!=null) {
		        		    	addressName+=" "+tdAddress2.getCityname();
		        		    	tdActivity.setCityCitycode(cid2);
		        		    }
		        		}
		        		//区
		        		if(!"".equals(did2)&&did2!=null) {
		        			TdAddress tdAddress3 = tdAddressService.queryById(did2);		        			
		        			if(tdAddress3!=null) {
		        				addressName+=" "+tdAddress3.getCityname();		
		        				tdActivity.setAreaCitycode(did2);
		        			}
		        		}
		        		//3
		        		//省
		        		if(!"".equals(pid3)&&pid3!=null) {
		        			TdAddress tdAddress1 = tdAddressService.queryById(pid3);
		        			if(tdAddress1!=null) {
		        				addressName+=tdAddress1.getCityname();	
		        				tdActivity.setProvinceCitycode(pid3);
		        			}
		        		}
		        		//市
		        		if(!"".equals(cid3)&&cid3!=null) {
		        			TdAddress tdAddress2 = tdAddressService.queryById(cid3);		        			
		        		    if(tdAddress2!=null) {
		        		    	addressName+=" "+tdAddress2.getCityname();
		        		    	tdActivity.setCityCitycode(cid3);
		        		    }
		        		}
		        		//区
		        		if(!"".equals(did3)&&did3!=null) {
		        			TdAddress tdAddress3 = tdAddressService.queryById(did3);		        			
		        			if(tdAddress3!=null) {
		        				addressName+=" "+tdAddress3.getCityname();		
		        				tdActivity.setAreaCitycode(did3);
		        			}
		        		}
		        		tdActivity.setAddressName(addressName);
		        		
		        		
		        	}
		        }
	        	//详细地址
       	
       		tdActivity.setCitycode(detailedAddress);
	        	//活动封面图
       		String activityCoverImg[] = activity_cover_img.split("[?]");
       		String finalCoverImg = "";
       		if(activityCoverImg.length>1) {
       			finalCoverImg = activityCoverImg[0];
       		}else {
       			finalCoverImg = activity_cover_img;
       		}
	        	tdActivity.setActivityCoverimgurl("/"+getfinalUploadImg(finalCoverImg));
	        	//分享摘要
	        	tdActivity.setShareAbstract(shareSummary);
	        	//是否设置邀约提成
	        	//设置邀约提成
	        	if(!"".equals(isInvitationActivityRoyalty1)&&isInvitationActivityRoyalty1!=null) {
	        		
	        		Integer isInvitationActivityRoyaltys = Integer.parseInt(isInvitationActivityRoyalty1);
	        		if(isInvitationActivityRoyaltys==1) {
	        			BigDecimal setRoyaltyRatios=new BigDecimal(invitationActivityRoyaltyRate);
	        			tdActivity.setRoyaltyRatio(setRoyaltyRatios);
	        			tdActivity.setActivityIsextract(1);
	        		}
	        	}
	        	//未设置邀约提成
                  if(!"".equals(isInvitationActivityRoyalty2)&&isInvitationActivityRoyalty2!=null) {	        		
	        		Integer isInvitationActivityRoyaltys2 = Integer.parseInt(isInvitationActivityRoyalty2);
	        		if(isInvitationActivityRoyaltys2==2) {			
	        			tdActivity.setActivityIsextract(0);
	        			BigDecimal remove=new BigDecimal(0);
	        			tdActivity.setRoyaltyRatio(remove);
	        		}
	        	}
	        	//活动音乐
	        	tdActivity.setActivitymusicId(activitymusicId);
	        	//活动详情，富文本图片修改
				
	        	tdActivity.setActivityDetailsurl(pubActivityEditorImage(editorFixImage(CONTENT)));
/*	        	System.out.println("n"+pubActivityEditorImage(editorFixImage(CONTENT)));
*/	        	if(!"".equals(onlineStatus)&&onlineStatus!=null) {
	        	Integer onlineStatuss=  Integer.parseInt(onlineStatus);
	        
	        	tdActivity.setOnlineStatus(onlineStatuss);
	        	}
	        	//免费
	        	if(!"".equals(activityCostType2)&&activityCostType2!=null&&"2".equals(activityCostType2)) {
		        	Integer activityCostTypes2 = Integer.parseInt(activityCostType2);	
	        		tdActivity.setActivityChargestatus(0);
	        		
	        		TdActivityChargeItem returnTdActivityChargeItem = new TdActivityChargeItem();	        			
        			returnTdActivityChargeItem.setActivityId(activityId);
        			activityProjectService.deleteByWhere(returnTdActivityChargeItem);
	        		
	        	}
	        	//收费
	        	if(!"".equals(activityCostType1)&&activityCostType1!=null&&"1".equals(activityCostType1)) {	      
		        	Integer activityCostTypes = Integer.parseInt(activityCostType1);
		        	tdActivity.setActivityChargestatus(1);
		        	
	        	}
	        	tdActivity.setActivityId(activityId);
	        	int returnSaveResult =	activityService.updateSelective(tdActivity);
	        
             if(returnSaveResult==1) {
            //草稿报名填写项目数组1把之前草稿的报名填写项目删除，2添加新的草稿报名填写项目
            	
            if(!"".equals(finalReturnInputCountSumOtherArray)&&finalReturnInputCountSumOtherArray!=null) {
            	        //1
            	        TdActivityFillInItem returnTdActivityFillInItem = new TdActivityFillInItem();
            	        returnTdActivityFillInItem.setActivityId(activityId);
            	        activityFillInItemService.deleteByWhere(returnTdActivityFillInItem);
            	        //2
         	        	String finalReturnInputCountSumOtherArrays[] = finalReturnInputCountSumOtherArray.split(",");        		    
         	        	if(finalReturnInputCountSumOtherArrays.length>0) {
         	        		
         	        		for (int i = 0; i < finalReturnInputCountSumOtherArrays.length; i++) {
         	        			if(!"".equals(finalReturnInputCountSumOtherArrays[i])&&finalReturnInputCountSumOtherArrays[i]!=null&&!"undefined".equals(finalReturnInputCountSumOtherArrays[i])) {
         	        				
         	        				TdActivityFillInItem tActivityFillInItem = new TdActivityFillInItem();
         	        				tActivityFillInItem.setFillInItemId(this.get32UUID());
         	        				tActivityFillInItem.setActivityId(activityId);
         	        				tActivityFillInItem.setFillInItemName(finalReturnInputCountSumOtherArrays[i]);
         	        				tActivityFillInItem.setType(1);
         	        				activityFillInItemService.saveSelective(tActivityFillInItem);
         	        			}
         	        		}
         	        	}
         	        	}
           	//报名填写项
           	if(!"".equals(createInputCountSumOtherArray)&&createInputCountSumOtherArray!=null) {
           	
 	        	String createInputCountSumOtherArrays[] = createInputCountSumOtherArray.split(",");
 		    
 	        	for (int i = 0; i < createInputCountSumOtherArrays.length; i++) {
 					if(!"".equals(createInputCountSumOtherArrays[i])&&createInputCountSumOtherArrays[i]!=null&&!"undefined".equals(createInputCountSumOtherArrays[i])) {						
 						TdActivityFillInItem tActivityFillInItem = new TdActivityFillInItem();
 						tActivityFillInItem.setFillInItemId(this.get32UUID());
 						tActivityFillInItem.setActivityId(tdActivity.getActivityId());
 						tActivityFillInItem.setFillInItemName(createInputCountSumOtherArrays[i]);
 						tActivityFillInItem.setType(1);
 						activityFillInItemService.saveSelective(tActivityFillInItem);
 					}
 	        	}}
 	        //活动收费状态，1收费，2免费
	        
	        	if(!"".equals(activityCostType1)&&activityCostType1!=null&&"1".equals(activityCostType1)) {	      
	        	Integer activityCostTypes = Integer.parseInt(activityCostType1);
	          
	        		tdActivity.setActivityChargestatus(1);
	        		//草稿已经保存的收费项目1先删除草稿已经保存的收费项目，2再添加新的草稿项目
	        	
	        		if(!"".equals(activityId)&&activityId!=null) {	    
	        			//1
	        			TdActivityChargeItem returnTdActivityChargeItem = new TdActivityChargeItem();	        			
	        			returnTdActivityChargeItem.setActivityId(activityId);
	        			activityProjectService.deleteByWhere(returnTdActivityChargeItem);
	        			//2
	        			String returnCostProjectmInfoSaveArrays[] = returnCostProjectmInfoSaveArray.split(",");
	        			for (int i = 0; i < returnCostProjectmInfoSaveArrays.length; i++) {
							//暂时无
		        			String costArrays[] =  returnCostProjectmInfoSaveArrays[i].split(",");
		        			
		        			String costArrayFinal[] = costArrays[0].split(":");
		        			TdActivityChargeItem tdActivityChargeItem = new TdActivityChargeItem();
		        			if(costArrayFinal.length>1) {
		        				
		        				if(!"".equals(costArrayFinal[1])&&costArrayFinal[1]!=null&&!"undefined".equals(costArrayFinal[1])) {
		        					Double moneyNum = Double.parseDouble(costArrayFinal[1]);
		        					BigDecimal costMoney = new BigDecimal(Double.toString(moneyNum));
		        					tdActivityChargeItem.setActivityChargeItemMoney(costMoney);
		        					
		        				}
		        				if(!"".equals(costArrayFinal[0])&&costArrayFinal[0]!=null&&!"undefined".equals(costArrayFinal[0])) {	        				
		        					tdActivityChargeItem.setActivityChargeItemName(costArrayFinal[0]);
		        					tdActivityChargeItem.setActivityChargeItemId(this.get32UUID());
		        					tdActivityChargeItem.setActivityId(tdActivity.getActivityId());
		        					tdActivityChargeItem.setUserId(Jurisdiction.getUsername());
		        					activityProjectService.saveSelective(tdActivityChargeItem);
		        				}
		        			}
						}
	        		}
	        				
	        		//收费项目数组
	        	
	        		String costProjectmInfoSaveArrays[] = costProjectmInfoSaveArray.split(",");	        		
	        		for (int i = 0; i < costProjectmInfoSaveArrays.length; i++) {
						//暂时无
	        			String costArrays[] =  costProjectmInfoSaveArrays[i].split(",");
	        			
	        			String costArrayFinal[] = costArrays[0].split(":");
	        			TdActivityChargeItem tdActivityChargeItem = new TdActivityChargeItem();
	        			if(costArrayFinal.length>1) {
	        				
	        				if(!"".equals(costArrayFinal[1])&&costArrayFinal[1]!=null&&!"undefined".equals(costArrayFinal[1])) {
	        					Double moneyNum = Double.parseDouble(costArrayFinal[1]);
	        					BigDecimal costMoney = new BigDecimal(Double.toString(moneyNum));
	        					tdActivityChargeItem.setActivityChargeItemMoney(costMoney);
	        					
	        				}
	        				if(!"".equals(costArrayFinal[0])&&costArrayFinal[0]!=null&&!"undefined".equals(costArrayFinal[0])) {	        				
	        					tdActivityChargeItem.setActivityChargeItemName(costArrayFinal[0]);
	        					tdActivityChargeItem.setActivityChargeItemId(this.get32UUID());
	        					tdActivityChargeItem.setActivityId(tdActivity.getActivityId());
	        					tdActivityChargeItem.setUserId(Jurisdiction.getUsername());
	        					activityProjectService.saveSelective(tdActivityChargeItem);
	        				}
	        			}
					}
	        
	        	}
	        	
	            	msg = "ok";
	            }else {
	            	msg = "error";
	            }
	 
				pd.put("msg", msg);
				pd.put("count", count);						//成功数
				pd.put("ecount", zcount-count);				//失败数
				pdList.add(pd);
				map.put("list", pdList);
				return AppUtil.returnObject(pd, map);
			}
		  /* public static void main(String[] args) {
			  
			   System.out.println(splitStringEditActivityTime("2018-12-05 10:19:00"));
		   }*/
		   //后端传到前端的是时间
		   public static String splitStringEditActivityTime(String time) {
			   String times[] = time.split("-");
			   String timesString = times[0]+"/"+times[1]+"/"+times[2];
			 return  timesString.substring(0, 16);
		   }
		   //分割前端传过来的时间
		   public static String splitStringPubActivityTime(String time) {
			   String times[] = time.split("/");
			   String timesString = times[0]+"-"+times[1]+"-"+times[2]+":00";
	        	
			   return timesString;
		   }
		  public final static String dateTransferToString(Timestamp timestamp) {
			
			  SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	        
	          String ooo = timestamp.toString();
	        
			  return ooo;
		  }
		  public final static long StringTimeToLong(String timeFormat) throws ParseException {
			  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date date=df.parse(timeFormat);
				long timeLong = date.getTime();
				return timeLong;
		  }
		  
		  public static String subString(String str, String strStart, String strEnd) {
			  
		        /* 找出指定的2个字符在 该字符串里面的 位置 */
		        int strStartIndex = str.indexOf(strStart);
		        int strEndIndex = str.indexOf(strEnd);
		 
		        /* index 为负数 即表示该字符串中 没有该字符 */
		        if (strStartIndex < 0) {
		            return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";
		        }
		        if (strEndIndex < 0) {
		            return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";
		        }
		        /* 开始截取 */
		        String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
		        return result;

		  }
		  
		/*  public static void main(String[] args) {
			String context = "<p>富文本内容显示活动详情测试<img src=\"http://fb.yxl58.cn:80/Users/Administrator/Desktop/uLog_yxlht/webapps/yixunlianUserLogin/plugins/ueditor/jsp/upload1/20181227/98811545908874456.jpg\" title=\"莎拉10.jpg\" style=\"width: 400px; height: 400px;\" width=\"400\" height=\"400\" border=\"0\" hspace=\"0\" vspace=\"0\"/></p><img src=\"http://fb.yxl58.cn:80/Users/Administrator/Desktop/uLog_yxlht/webapps/yixunlianUserLogin/plugins/ueditor/jsp/upload1/20181227/98811545908874456.jpg\" title=\"莎拉10.jpg\" style=\"width: 400px; height: 400px;\" width=\"400\" height=\"400\" border=\"0\" hspace=\"0\" vspace=\"0\"/><img src=\"http://fb.yxl58.cn:80/Users/Administrator/Desktop/uLog_yxlht/webapps/yixunlianUserLogin/plugins/ueditor/jsp/upload1/20181227/98811545908874456.jpg\" title=\"莎拉10.jpg\" style=\"width: 400px; height: 400px;\" width=\"400\" height=\"400\" border=\"0\" hspace=\"0\" vspace=\"0\"/>";
			
		     System.out.println(pubActivityEditorImage(context));
		  }*/
		//主办方发布活动调整页面图片大小
		  
		  public final static String pubActivityEditorImage(String editorContext) {
				String contexts[] = editorContext.split("<img src=\"");
			  	String finalContext = "";
			  	finalContext =contexts[0];
			  	String finalEditContext = "";
			  	if(contexts.length>1) {
			  		
			  		for (int i = 1; i < contexts.length; i++) {			    	 
			  			String imgContext[] =   contexts[i].split("\"");
			  			
			  			String imgContextfinal = imgContext[0];
			  			
			  			String srcContext[] =   contexts[i].split(">");
			  			String finalContextLast = "";
			  			for (int j = 1; j < srcContext.length; j++) {
			  				finalContextLast+=	">" +srcContext[j];
						}
			  			
			  			finalContext+="<img src=\""+imgContextfinal+"\""+"style=\"font-size: 0.28rem; max-width: 100%;\""+finalContextLast+">";
			  		}
			  		/*finalEditContext = finalContext.substring(0,finalContext.length()-1);*/
			  	}
			  return finalContext;
		  }
		  
		//富文本内容，图片路径修改可访问
		  public final static String editorFixImage(String editorContext) {
		  	String contexts[] = editorContext.split("<img src=\"/");
		  	String finalContext = "";
		  	finalContext =contexts[0];
		      for (int i = 1; i < contexts.length; i++) {
		      	finalContext+="<img src=\"http://fb.yxl58.com:80/Users/Administrator/Desktop/uLog_yxlht/webapps/"+contexts[i];
		  	}
		      return finalContext;
		  }
		  //俩个字符串时间，转变为时间戳的比较
		  //activity_status
		  public final static int compareTime1AndTime2(String time1,String time2) throws ParseException {
			  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    //字符串时间1转变为时间戳     开始时间
				java.util.Date date=df.parse(time1);
				long startTimeLong = date.getTime();
				//字符串时间2转变为时间戳     结束时间
				java.util.Date date2=df.parse(time2);
				long endTimeLong = date2.getTime();
				//获取当前时间			  当前时间	
				long curTimeLong = (new Date()).getTime();
				//1当前时间大于结束时间
				if(curTimeLong>endTimeLong) {
					return 2;
				}//2当前时间大于开始时间，小于结束时间
				else if(endTimeLong>curTimeLong&&curTimeLong>startTimeLong) {
					return 1;
				}//3当前时间小于开始时间
				else if(startTimeLong>curTimeLong){
					return 0;
				}else {
					return 2;
				}
		  }
		/*  public static void main(String[] args) {
			System.out.println(getfinalEditImg("/file/img/activity/jsp_source_20181229171455250ibysweeb.jpg"));  
		  }*/
		  public final static String getfinalUploadImg(String imgs) {
			  int count = imgs.indexOf("/");
			  if(count==0) {
				  String imgss =imgs.substring(1, imgs.length());
				  return imgss;
			  }else {
				  
				  return imgs;
			  }
		  }
		  public final  Map<String,TdUser> listTdUserPrecisionByActivitycategoryId(String activitycategory_id,String address,int type){
				//活动类别，查找三点依据，1兴趣爱好，2曾经参与，3，个人需求
				//1兴趣爱好
				/*TdUserandhobby tdUserandhobby =new TdUserandhobby();
				tdUserandhobby.setActivitycategoryId(activitycategory_id);*/
				Map<String,TdUser> map = new HashMap<>();
				List<TdUserandhobby> listTdUserAndHobby = clientUserAndHobbyService.getlistTdUserAndHobbyByActivitycategoryId(activitycategory_id);
				for (TdUserandhobby tdUserandhobby2 : listTdUserAndHobby) {
					TdUser tdUser = clientUserService.getTdUserByAddress(tdUserandhobby2.getUserId(),address,type);
					if(tdUser!=null) {
						map.put(tdUser.getUserId(), tdUser);				
					}
				}
			
				//2曾经参与
				List<TdEverjoin> listTdEverjoin = everjoinActivityService.getListTdEverjoin(activitycategory_id);
				for (TdEverjoin tdEverjoin : listTdEverjoin) {
					TdUser tdUser = clientUserService.getTdUserByAddress(tdEverjoin.getUserId(),address,type);
					if(tdUser!=null) {
						map.put(tdUser.getUserId(), tdUser);				
					}
				}
				
				//3个人需求
				List<TdPersonalneeds> listTdPersonalneeds =  personalneedsService.getListTdPersonalneeds(activitycategory_id);
			    for (TdPersonalneeds tdPersonalneeds : listTdPersonalneeds) {
			    	TdUser tdUser = clientUserService.getTdUserByAddress(tdPersonalneeds.getUserId(),address,type);
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


