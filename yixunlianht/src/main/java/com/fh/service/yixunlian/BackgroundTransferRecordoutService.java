package com.fh.service.yixunlian;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.BackgroundTransferRecordinputMapper;
import com.fh.lw.mapper.BackgroundTransferRecordoutMapper;
import com.fh.lw.pojo.yixunlian.TdBackgroundTransferRecordinput;
import com.fh.lw.pojo.yixunlian.TdBackgroundTransferRecordout;
import com.fh.lw.service.BaseService;

@Service
public class BackgroundTransferRecordoutService extends BaseService<TdBackgroundTransferRecordout>{
	  @Autowired
	  private BackgroundTransferRecordoutMapper mapper;

	public void deleteBackgroundTransferRecordOutById(String background_transfer_record_id) {
		// TODO Auto-generated method stub
		TdBackgroundTransferRecordout tdBackgroundTransferRecordout = new TdBackgroundTransferRecordout();
		tdBackgroundTransferRecordout.setBackgroundTransferRecordId(background_transfer_record_id);
		super.deleteByWhere(tdBackgroundTransferRecordout);
	}

	@SuppressWarnings("unchecked")
	public void delAllBackgroundTransferRecordout(String backgroundTransferRecordout_IDS) {
		// TODO Auto-generated method stub
		String backgroundTransferRecordouts[] = backgroundTransferRecordout_IDS.split(",");
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i=0;i<backgroundTransferRecordouts.length;i++) {
			list.add(backgroundTransferRecordouts[i]);
		}
		//propety是实体字段
		TdBackgroundTransferRecordout tdBackgroundTransferRecordout = new TdBackgroundTransferRecordout(); 
		super.deleteByIds((Class<TdBackgroundTransferRecordout>) tdBackgroundTransferRecordout.getClass(), "backgroundTransferRecordId", list);

	}
}
