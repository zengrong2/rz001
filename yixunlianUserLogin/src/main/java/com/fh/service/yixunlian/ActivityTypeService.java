package com.fh.service.yixunlian;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.ActivityTypeMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;
@Service
public class ActivityTypeService extends BaseService<TdActivitycategory>{
	   @Autowired
	  private ActivityTypeMapper mapper;

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
	public void updateTdActivityType(String activitycategory_id, String activitycategory_name, String remark) {
		// TODO Auto-generated method stub
		TdActivitycategory tdActivityType = new TdActivitycategory();
		tdActivityType.setActivitycategoryId(activitycategory_id);
		tdActivityType.setActivitycategoryName(activitycategory_name);
		tdActivityType.setRemark(remark);
		/*Example example = new Example(tdActivityType.getClass());
	 	example.createCriteria().andEqualTo("activitycategoryName", activitycategory_name).andEqualTo("remark", remark).andEqualTo("updated", new Date());
	    */
	 	super.updateSelective(tdActivityType);
	 	/*mapper.updateByExampleSelective(tdActivityType, example);*/
	}
}
