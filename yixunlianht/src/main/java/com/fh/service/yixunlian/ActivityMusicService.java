package com.fh.service.yixunlian;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.ActivityMusicMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.service.BaseService;

@Service
public class ActivityMusicService extends BaseService<TdActivitymusicurl>{
	 @Autowired
	  private ActivityMusicMapper mapper;

	public void deleteActivityMusicByAid(String activitymusic_id) {
		// TODO Auto-generated method stub
		TdActivitymusicurl tdActivitymusicurl = new TdActivitymusicurl(); 
		
		tdActivitymusicurl.setActivitymusicId(activitymusic_id);
		super.deleteByWhere(tdActivitymusicurl);
	}

	@SuppressWarnings("unchecked")
	public void delAllActivityMusic(String activityMusic_IDS) {
		// TODO Auto-generated method stub
		String ArrayActivityMusic_IDS[] = activityMusic_IDS.split(",");
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i=0;i<ArrayActivityMusic_IDS.length;i++) {
			
			list.add(ArrayActivityMusic_IDS[i]);
		}
		TdActivitymusicurl tdActivitymusicurl = new TdActivitymusicurl(); 
		super.deleteByIds((Class<TdActivitymusicurl>) tdActivitymusicurl.getClass(), "activitymusicId", list);
	}
}
