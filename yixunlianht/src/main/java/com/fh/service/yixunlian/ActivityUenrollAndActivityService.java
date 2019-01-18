package com.fh.service.yixunlian;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.ActivityProjectAndEnrollMapper;
import com.fh.lw.mapper.ActivityTypeMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdTransactionItem;
import com.fh.lw.pojo.yixunlian.TdUenrollandactivity;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;

@Service
public class ActivityUenrollAndActivityService extends BaseService<TdUenrollandactivity>{
	  @Autowired
	  private ActivityProjectAndEnrollMapper mapper;
	  @Autowired
	  private ActivityMapper activityMapper;


	@SuppressWarnings("unlikely-arg-type")
	public float sumSoloActivityDealMoney(String activity_id) {
					// TODO Auto-generated method stub
					float sumSoloActivityDealMoney = 0;
					TdUenrollandactivity tdUenrollandactivity  =new TdUenrollandactivity();
					Example example = new Example(tdUenrollandactivity.getClass());
					example.createCriteria().andEqualTo("activityId", activity_id).andEqualTo("dealStatus", 1);
					List<TdUenrollandactivity> listTdUenrollandactivity = this.mapper.selectByExample(example);
					for (TdUenrollandactivity tdUenrollandactivity2 : listTdUenrollandactivity) {
	                      if(!"".equals(tdUenrollandactivity2.getTransactionNum())&&tdUenrollandactivity2.getTransactionNum()!=null) {
							
							sumSoloActivityDealMoney  +=Float.parseFloat(tdUenrollandactivity2.getTransactionNum()+"");
						}
					}
					
					return sumSoloActivityDealMoney;
				}
//待发放给客户经理的提成金额
	@SuppressWarnings("unlikely-arg-type")
	public float getSumSoloActivityWaitPayExtract(String activity_id) {
		// TODO Auto-generated method stub
		float sumSoloActivityWaitPay = 0;
		TdUenrollandactivity tdUenrollandactivity  =new TdUenrollandactivity();
		Example example = new Example(tdUenrollandactivity.getClass());
		example.createCriteria().andEqualTo("activityId", activity_id).andEqualTo("dealStatus", 1).andEqualTo("paymentStatus", 0);
		List<TdUenrollandactivity> listTdUenrollandactivity = this.mapper.selectByExample(example);
        for (TdUenrollandactivity tdUenrollandactivity2 : listTdUenrollandactivity) {
        	if(!"".equals(tdUenrollandactivity2.getPaymentNum())&&tdUenrollandactivity2.getPaymentNum()!=null) {
				
        		sumSoloActivityWaitPay  +=Float.parseFloat(tdUenrollandactivity2.getPaymentNum()+"");
			}
        }
		return sumSoloActivityWaitPay;
	}
	//应发放的提成 总支付出去的总额
		@SuppressWarnings("unlikely-arg-type")
		public float getSumSoloActivityShouldPubPayExtract(String activity_id) {
			// TODO Auto-generated method stub
			float sumSoloActivityShouldPubPay = 0;
			List<Object> list = new ArrayList<>();
			list.add(0);
			list.add(1);
			TdUenrollandactivity tdUenrollandactivity  =new TdUenrollandactivity();
			Example example = new Example(tdUenrollandactivity.getClass());
			example.createCriteria().andEqualTo("activityId", activity_id).andEqualTo("dealStatus", 1).andIn("paymentStatus", list);
			List<TdUenrollandactivity> listTdUenrollandactivity = this.mapper.selectByExample(example);
	        for (TdUenrollandactivity tdUenrollandactivity2 : listTdUenrollandactivity) {
	        	if(!"".equals(tdUenrollandactivity2.getPaymentNum())&&tdUenrollandactivity2.getPaymentNum()!=null) {
					
	        		sumSoloActivityShouldPubPay  +=Float.parseFloat(tdUenrollandactivity2.getPaymentNum()+"");
				}
	        }
			return sumSoloActivityShouldPubPay;
		}
		//计算主办方所有活动已经成交的金额
		public float getOrganizerActivityCountDealMoney(String organizer_info_id) {
			// TODO Auto-generated method stub
			float countMoney = 0;
			TdUenrollandactivity tdUenrollandactivity  =new TdUenrollandactivity();
			Example example = new Example(tdUenrollandactivity.getClass());
			example.createCriteria().andEqualTo("organizerId", organizer_info_id).andEqualTo("dealStatus", 1);
			List<TdUenrollandactivity>  listTdUenrollandactivity = this.mapper.selectByExample(example);
			for (TdUenrollandactivity tdUenrollandactivity2 : listTdUenrollandactivity) {
				countMoney  +=Float.parseFloat(tdUenrollandactivity2.getTransactionNum()+"");
			}
			return countMoney;
		}
		//分润总金额
		public float getOrganizerActivityCountAlreadyExtractMoney(String organizer_info_id) {
			// TODO Auto-generated method stub
			float countMoney = 0;
			TdUenrollandactivity tdUenrollandactivity  =new TdUenrollandactivity();
			Example example = new Example(tdUenrollandactivity.getClass());
			example.createCriteria().andEqualTo("organizerId", organizer_info_id).andEqualTo("paymentStatus", 1);
			List<TdUenrollandactivity>  listTdUenrollandactivity = this.mapper.selectByExample(example);
			for (TdUenrollandactivity tdUenrollandactivity2 : listTdUenrollandactivity) {
				countMoney  +=Float.parseFloat(tdUenrollandactivity2.getPaymentNum()+"");
			}
			return countMoney;
		}
		//封装的获取主办方发布的所有活动
		public  List<TdActivity> getAllTdActivity(String userId){
			TdActivity tdActivity  =new TdActivity();
			Example example = new Example(tdActivity.getClass());			
			example.createCriteria().andEqualTo("userId", userId);
			List<TdActivity> listTdActivity = this.activityMapper.selectByExample(example);
			return listTdActivity;
		}
		
}
