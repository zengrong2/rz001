package com.fh.service.yixunlian;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMusicMapper;
import com.fh.lw.mapper.PartnerBonusTransferRecordinputMapper;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdBackgroundTransferRecordinput;
import com.fh.lw.pojo.yixunlian.TdPartnerBonusTransferRecordinput;
import com.fh.lw.service.BaseService;

@Service
public class PartnerBonusTransferRecordinputService extends BaseService<TdPartnerBonusTransferRecordinput>{
	 @Autowired
	  private PartnerBonusTransferRecordinputMapper mapper;

	public void deletePartnerBonusTransferRecordinputById(String partner_bonus_id) {
		// TODO Auto-generated method stub 
		TdPartnerBonusTransferRecordinput tdPartnerBonusTransferRecordinput = new TdPartnerBonusTransferRecordinput();
		tdPartnerBonusTransferRecordinput.setPartnerBonusId(partner_bonus_id);
		super.deleteByWhere(tdPartnerBonusTransferRecordinput);
		
	}

	@SuppressWarnings("unchecked")
	public void delAllPartnerBonusInput(String partnerBonus_IDS) {
		// TODO Auto-generated method stub
		String partnerBonus_IDSs[] = partnerBonus_IDS.split(",");
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i=0;i<partnerBonus_IDSs.length;i++) {
			list.add(partnerBonus_IDSs[i]);
		}
		//propety是实体字段
		TdPartnerBonusTransferRecordinput tdPartnerBonusTransferRecordinput = new TdPartnerBonusTransferRecordinput(); 
		super.deleteByIds((Class<TdPartnerBonusTransferRecordinput>) tdPartnerBonusTransferRecordinput.getClass(), "partnerBonusId", list);

	}
}
