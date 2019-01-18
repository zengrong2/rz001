package com.fh.service.yixunlian;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMusicMapper;
import com.fh.lw.mapper.AidFundMapper;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdAidFund;
import com.fh.lw.service.BaseService;

@Service
public class AidFundService extends BaseService<TdAidFund>{
	 @Autowired
	  private AidFundMapper mapper;

	public void deleteAidFundByAid(String af_id) {
		// TODO Auto-generated method stub
		TdAidFund tdAidFund = new TdAidFund(); 
		tdAidFund.setAfId(af_id);
		
		super.deleteByWhere(tdAidFund);
	}

	@SuppressWarnings("unchecked")
	public void delAllAidFund(String aidFund_IDS) {
		// TODO Auto-generated method stub
		String ArrayAidFund_IDS[] = aidFund_IDS.split(",");
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i=0;i<ArrayAidFund_IDS.length;i++) {
			
			list.add(ArrayAidFund_IDS[i]);
		}
		TdAidFund tdAidFund = new TdAidFund(); 
		super.deleteByIds((Class<TdAidFund>) tdAidFund.getClass(), "afId", list);
	}
}
