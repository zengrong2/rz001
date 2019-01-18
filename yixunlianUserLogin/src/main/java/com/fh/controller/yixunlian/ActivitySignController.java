package com.fh.controller.yixunlian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.lw.pojo.yixunlian.TdActivitySignOtherFields;
import com.fh.lw.pojo.yixunlian.TdActivityprojectandacsign;
import com.fh.lw.pojo.yixunlian.TdActivitysign;
import com.fh.service.yixunlian.ActivityService;
import com.fh.service.yixunlian.ActivitySignService;
import com.fh.service.yixunlian.ActivitySignSqlManager;
import com.fh.service.yixunlian.ActivitySqlManager;
import com.fh.util.PageData;

@Controller
@RequestMapping("activitySign/")
public class ActivitySignController extends BaseController{
	//这个注入的是通用mapper使用的service
		@Autowired
		private ActivitySignService service;
		//这是注入的是写sql语句的service
		@Autowired
		private ActivitySignSqlManager sqlService;
		/*
		 * 活动报名详情
		 * ActivityEnrollInfoDetail
		 */
		@RequestMapping(value="ActivityEnrollInfoDetail")
		public ModelAndView ActivityEnrollInfoDetail(){
				ModelAndView mv = this.getModelAndView();
				PageData pd = new PageData();
					try{
					pd = this.getPageData();			
					String activity_id = pd.getString("activity_id");
					
					TdActivitysign tdActivitysign = new TdActivitysign();
					tdActivitysign.setActivityId(activity_id);
					List<TdActivitysign> tdActivitysignList = service.queryListByWhere(tdActivitysign);
					List<TdActivitySignOtherFields> tdActivitySignOtherFieldss = new ArrayList<>();
					for (TdActivitysign tdActivitysign2 : tdActivitysignList) {
						String otherField = tdActivitysign2.getOtherField();
						String otherFields[] = otherField.split(",");
						if(otherFields.length>1) {
						
							for(int i=0;i<otherFields.length;i++) {
								TdActivitySignOtherFields tdActivitySignOtherFields = new TdActivitySignOtherFields();
								String  temp[] =  otherFields[i].split(":");
								
								if(temp.length==2) {
								
									tdActivitySignOtherFields.setOtherFieldContext(temp[1]);
									tdActivitySignOtherFields.setOtherFieldTilte(temp[0]);
									tdActivitySignOtherFieldss.add(tdActivitySignOtherFields);
								}
							}
						}
				
					}	
					mv.addObject("tdActivitysignList",tdActivitysignList);
					mv.addObject("tdActivitySignOtherFieldss",tdActivitySignOtherFieldss);
					mv.setViewName("system/activity/activityEnrollList_detail");
						
					} catch(Exception e){
						logger.error(e.toString(), e);
					}
					return mv;
				}
}
