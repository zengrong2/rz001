package com.fh.service.yixunlian;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.SystemNoticeMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdSystembulletinNotice;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;

@Service
public class SystemNoticeService extends BaseService<TdSystembulletinNotice>{
	 @Autowired
	 private SystemNoticeMapper mapper;

	@SuppressWarnings("unchecked")
	public void delAllSystemNotice(String systemNotice_IDS) {
		// TODO Auto-generated method stub
		
		String ArraySystemNotice_IDS[] = systemNotice_IDS.split(",");
		

		for(int i=0;i<ArraySystemNotice_IDS.length;i++) {
			TdSystembulletinNotice tdSystembulletinNotice = new TdSystembulletinNotice(); 
			tdSystembulletinNotice.setNoticeId(ArraySystemNotice_IDS[i]);
			tdSystembulletinNotice.setNoticeStatus(0);
			super.updateSelective(tdSystembulletinNotice);
		}
		
	}
}
