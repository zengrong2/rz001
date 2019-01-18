package com.fh.service.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.entity.Page;
import com.fh.lw.mapper.ActivityMapper;

import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



@Service
public class ActivityService extends BaseService<TdActivity>{
	 @Autowired
	  private ActivityMapper mapper;

	public List<TdActivity> getAllTdActivity() {
		// TODO Auto-generated method stub
		TdActivity tdActivity = new TdActivity();
		List<TdActivity> list = this.mapper.select(tdActivity);
		return list;
	}

	public PageInfo<TdActivity> getPageAllTdActivity(Integer page, Integer rows) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, rows);
		TdActivity tdActivity = new TdActivity();
		Example example = new Example(tdActivity.getClass());
		example.setOrderByClause("created DESC ");
		 List<TdActivity> sList=this.mapper.selectByExample(example);
		return new PageInfo<>(sList);
	}
//修改活动状态
	public void updateActivityState(String activity_id, Integer is_state) {
		// TODO Auto-generated method stub
		TdActivity tdActivity = new TdActivity(); 
		TdActivity tdActivity2 = super.queryById(activity_id);			
		Example example = new Example(tdActivity.getClass());
		if(is_state==1) {			
			tdActivity2.setOnlineStatus(0);
			super.updateSelective(tdActivity2);
			return ;
		}
		if(is_state!=1){
			tdActivity2.setOnlineStatus(1);
			super.updateSelective(tdActivity2);
			return ;
		}

}
//活动全选删除
	@SuppressWarnings("unchecked")
	public void delAllActivity(String position_IDS) {
		// TODO Auto-generated method stub
		String ArrayPosition_IDS[] = position_IDS.split(",");
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i=0;i<ArrayPosition_IDS.length;i++) {
		
			list.add(ArrayPosition_IDS[i]);
		}
		TdActivity tdActivity = new TdActivity(); 
		super.deleteByIds((Class<TdActivity>) tdActivity.getClass(), "activityId", list);
	}

	public void deleteActivityByAid(String activity_id) {
		// TODO Auto-generated method stub
		TdActivity tdActivity = new TdActivity(); 
		tdActivity.setActivityId(activity_id);
		super.deleteByWhere(tdActivity);
	}

	public void updateActivityStateUnder(String activityId, Integer onlineStatuss) {
		// TODO Auto-generated method stub
		TdActivity tdActivity = new TdActivity();
		tdActivity.setActivityId(activityId);
		tdActivity.setOnlineStatus(0);
		super.updateSelective(tdActivity);
	}

	

	
}
