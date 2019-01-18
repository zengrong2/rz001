package com.fh.service.yixunlian;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ClientUserMapper;
import com.fh.lw.mapper.SetBeneficiaryUserServiceMapper;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdSetBeneficiary;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.lw.service.BaseService;

@Service
public class SetBeneficiaryUserService  extends BaseService<TdSetBeneficiary> {
	 @Autowired
	  private SetBeneficiaryUserServiceMapper mapper;

	@SuppressWarnings("unchecked")
	public void delAllSetBeneficiary(String beneficiary_IDS) {
		// TODO Auto-generated method stub
		String ArrayBeneficiary_IDS[] = beneficiary_IDS.split(",");
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i=0;i<ArrayBeneficiary_IDS.length;i++) {
			
			list.add(ArrayBeneficiary_IDS[i]);
		}
		//propety是实体字段
		TdSetBeneficiary tdSetBeneficiary = new TdSetBeneficiary(); 
		super.deleteByIds((Class<TdSetBeneficiary>) tdSetBeneficiary.getClass(), "beneficiaryId", list);

	}
}
