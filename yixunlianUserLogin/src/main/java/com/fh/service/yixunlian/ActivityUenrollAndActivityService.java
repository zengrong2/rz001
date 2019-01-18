package com.fh.service.yixunlian;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityProjectAndEnrollMapper;
import com.fh.lw.mapper.ActivityTypeMapper;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdTransactionItem;
import com.fh.lw.pojo.yixunlian.TdUenrollandactivity;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;

@Service
public class ActivityUenrollAndActivityService extends BaseService<TdUenrollandactivity>{
	  @Autowired
	  private ActivityProjectAndEnrollMapper mapper;

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

	//待发放给客户经理的提成金额，还需要支付出去的总额
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
//报名 设置成交情况，未成交
	public void setUploadOADealDataIsNotDeal(String uandactivityenrollId) {
		// TODO Auto-generated method stub
		TdUenrollandactivity tdUenrollandactivity  =new TdUenrollandactivity();
		tdUenrollandactivity.setUandactivityenrollId(uandactivityenrollId);
		tdUenrollandactivity.setDealStatus(0);
		BigDecimal bigDecimal = new BigDecimal(0);
		tdUenrollandactivity.setTransactionNum(bigDecimal);
		super.updateSelective(tdUenrollandactivity);
	}

	public void setUploadOADealDataIsDeal( String uandactivityenrollId,
			float totalMoney) {
		// TODO Auto-generated method stub
		TdUenrollandactivity tdUenrollandactivity  =new TdUenrollandactivity();
		tdUenrollandactivity.setUandactivityenrollId(uandactivityenrollId);
		tdUenrollandactivity.setDealStatus(1);
		BigDecimal bigDecimal = new BigDecimal(totalMoney);
		tdUenrollandactivity.setTransactionNum(bigDecimal);
		super.updateSelective(tdUenrollandactivity);
	}
}
