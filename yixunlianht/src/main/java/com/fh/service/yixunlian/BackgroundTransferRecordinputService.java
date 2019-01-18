package com.fh.service.yixunlian;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityTypeMapper;
import com.fh.lw.mapper.BackgroundTransferRecordinputMapper;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdBackgroundTransferRecordinput;
import com.fh.lw.service.BaseService;

@Service
public class BackgroundTransferRecordinputService extends BaseService<TdBackgroundTransferRecordinput>{
	  @Autowired
	  private BackgroundTransferRecordinputMapper mapper;

	public void deleteBackgroundTransferRecordinputById(String background_transfer_record_id) {
		// TODO Auto-generated method stub
		TdBackgroundTransferRecordinput tdBackgroundTransferRecordinput = new TdBackgroundTransferRecordinput();
		tdBackgroundTransferRecordinput.setBackgroundTransferRecordId(background_transfer_record_id);
		super.deleteByWhere(tdBackgroundTransferRecordinput);
	}

	@SuppressWarnings("unchecked")
	public void delAllBackgroundTransferRecordinput(String backgroundTransferRecordinput_IDS) {
		// TODO Auto-generated method stub
		String backgroundTransferRecordinputs[] = backgroundTransferRecordinput_IDS.split(",");
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i=0;i<backgroundTransferRecordinputs.length;i++) {
			list.add(backgroundTransferRecordinputs[i]);
		}
		//propety是实体字段
		TdBackgroundTransferRecordinput tdBackgroundTransferRecordinput = new TdBackgroundTransferRecordinput(); 
		super.deleteByIds((Class<TdBackgroundTransferRecordinput>) tdBackgroundTransferRecordinput.getClass(), "backgroundTransferRecordId", list);

	}
}
