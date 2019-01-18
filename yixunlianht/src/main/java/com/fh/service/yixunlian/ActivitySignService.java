package com.fh.service.yixunlian;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.ActivitySignMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitysign;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;

@Service
public class ActivitySignService extends BaseService<TdActivitysign>{
	 @Autowired
	  private ActivitySignMapper mapper;

	public TdActivitysign getActivitySign(String activity_id, String userId, int type) {
		// TODO Auto-generated method stub
		 TdActivitysign tdActivitysign =new TdActivitysign();
		 Example example = new Example(tdActivitysign.getClass());
		 //所在区域
		 if(type==1) {
			 example.createCriteria().andEqualTo("activityId", activity_id).andEqualTo("userId", userId).andEqualTo("fillInItemId", "3");
		 }
		 //邀约人
		 else if(type==2) {
			 example.createCriteria().andEqualTo("activityId", activity_id).andEqualTo("userId", userId).andEqualTo("fillInItemId", "5");
		 }
		 List<TdActivitysign> listTdActivitysign = this.mapper.selectByExample(example);
		if(listTdActivitysign.size()>0) {
			return listTdActivitysign.get(0);			
		}else {
			return null;
		}
	}
//报名填写增项
	public List<TdActivitysign> getAddActivitySign(String activity_id, String userId) {
		// TODO Auto-generated method stub
		TdActivitysign tdActivitysign =new TdActivitysign();
		Example example = new Example(tdActivitysign.getClass());
		List<Object> list = new ArrayList<>();
		for (int i = 1; i <=5; i++) {
			list.add(i);
		}
		example.createCriteria().andNotIn("fillInItemId", list).andEqualTo("activityId", activity_id).andEqualTo("userId", userId);
		List<TdActivitysign> listTdActivitysign = this.mapper.selectByExample(example);
		
		return listTdActivitysign;
	}
	public List<TdActivitysign> getAddActivitySignAll(String activity_id, String userId) {
		// TODO Auto-generated method stub
		TdActivitysign tdActivitysign =new TdActivitysign();
		Example example = new Example(tdActivitysign.getClass());
		example.createCriteria().andEqualTo("activityId", activity_id).andEqualTo("userId", userId);
        List<TdActivitysign> listTdActivitysign = this.mapper.selectByExample(example);
		
		return listTdActivitysign;

	}
}
