package com.fh.service.yixunlian;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.ActivityProjectAndEnrollMapper;
import com.fh.lw.mapper.ActivityTypeMapper;
import com.fh.lw.mapper.ClientUserMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdUenrollandactivity;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;
@Service
public class ActivityTypeService extends BaseService<TdActivitycategory>{
	   @Autowired
	   private ActivityTypeMapper mapper;
	   //用户
	   @Autowired
	   private ClientUserMapper clientUserMapper;
		 //报名列表
	   @Autowired
	   private ActivityProjectAndEnrollMapper activityProjectAndEnrollMapper;
	public void deleteActivityTypeByAid(String activitycategory_id) {
		// TODO Auto-generated method stub
		TdActivitycategory activitycategory = new TdActivitycategory();
		activitycategory.setActivitycategoryId(activitycategory_id);
		super.deleteByWhere(activitycategory);
	}

	public void delAllActivity(String activityType_IDS) {
		// TODO Auto-generated method stub
		String ArrayActivityType_IDS[] = activityType_IDS.split(",");
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i=0;i<ArrayActivityType_IDS.length;i++) {
			Integer a = Integer.parseInt(ArrayActivityType_IDS[i]);
			list.add(a);
		}
		//propety是实体字段
		TdActivitycategory tdActivityType = new TdActivitycategory(); 
		super.deleteByIds((Class<TdActivitycategory>) tdActivityType.getClass(), "activitycategoryId", list);

	}
//执行修改活动类型
	public void updateTdActivityType(String activitycategory_id, String activitycategory_name, String remark,String isSpecial) {
		// TODO Auto-generated method stub
		TdActivitycategory tdActivityType = new TdActivitycategory();
		tdActivityType.setActivitycategoryId(activitycategory_id);
		tdActivityType.setActivitycategoryName(activitycategory_name);
		tdActivityType.setIsSpecial(Integer.parseInt(isSpecial));
		tdActivityType.setRemark(remark);	
	 	super.updateSelective(tdActivityType);
	 
	}

	public void updateActivityCategoryState(String activitycategory_id, Integer is_state) {
		// TODO Auto-generated method stub
		TdActivitycategory tdActivitycategory = new TdActivitycategory(); 
		TdActivitycategory tdActivitycategory2 = super.queryById(activitycategory_id);			
		Example example = new Example(tdActivitycategory.getClass());
		if(is_state==1) {			
		
			tdActivitycategory2.setIsOnline(0);
			super.updateSelective(tdActivitycategory2);
			return ;
		}
		if(is_state!=1){
		
			tdActivitycategory2.setIsOnline(1);
			super.updateSelective(tdActivitycategory2);
			return ;
		}
	}
//未参加应用培训的所有用户
	public List<TdUser> getNotJoinSpecialListUser() {
		// TODO Auto-generated method stub
		 List<TdUser> notJoinSpecialListTdUsers = new ArrayList<>();
		 List<Object> listTdUserId = new ArrayList<>();		
		 TdUenrollandactivity tdUenrollandactivity = new TdUenrollandactivity();
		 Example  example8 = new Example(tdUenrollandactivity.getClass());
		 example8.createCriteria().andEqualTo("activitycategoryId", "9bbada2bd61041f1ac54fff6d464e6f3");
		 List<TdUenrollandactivity> listTdUenrollandactivity = activityProjectAndEnrollMapper.selectByExample(example8);
		 for (TdUenrollandactivity tdUenrollandactivity2 : listTdUenrollandactivity) {
			TdUser getTdUser = clientUserMapper.selectByPrimaryKey(tdUenrollandactivity2.getUserId());
			if(getTdUser!=null) {
				if(!"".equals(getTdUser.getUtypeId())&&getTdUser.getUtypeId()!=null) {					
					if((Integer.parseInt(getTdUser.getUtypeId()))>1) {						
						listTdUserId.add(getTdUser.getUserId());
					}
				}
			}
		 }
		 List<Object> list = new ArrayList<>();
		 for (int i = 2; i <=6; i++) {
			 list.add(i);
		}
		 if(listTdUserId.size()>0) {			 
			 TdUser tdUser = new TdUser();
			 Example specialExample = new Example(tdUser.getClass());
			 specialExample.createCriteria().andNotIn("userId", listTdUserId).andIn("utypeId", list);
			 notJoinSpecialListTdUsers = clientUserMapper.selectByExample(specialExample);
			
		 }else {
			 TdUser tdUser = new TdUser();
			 Example specialExample = new Example(tdUser.getClass());
			 specialExample.createCriteria().andIn("utypeId", list);
			 notJoinSpecialListTdUsers = clientUserMapper.selectByExample(specialExample);
			
		 }
		return notJoinSpecialListTdUsers;
	}
}
