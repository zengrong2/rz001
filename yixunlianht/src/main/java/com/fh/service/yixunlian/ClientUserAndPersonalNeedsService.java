package com.fh.service.yixunlian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ClientUserAndHobbyMapper;
import com.fh.lw.mapper.ClientUserAndPersonalNeedsMapper;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdPersonalneeds;
import com.fh.lw.pojo.yixunlian.TdUserandhobby;
import com.fh.lw.pojo.yixunlian.TdUserandpersonalneeds;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;

@Service
public class ClientUserAndPersonalNeedsService extends BaseService<TdUserandpersonalneeds>{
	 @Autowired
	  private ClientUserAndPersonalNeedsMapper mapper;
	 @Autowired
	    private PersonalneedsService personalneedsService;
	 //活动类额
	 @Autowired
		private ActivityTypeService activityTypeService;
    //用户详细信息》显示个人需求和统计单个需求的次数
	public List<TdUserandpersonalneeds> getListTdUserandpersonalneeds(String user_id) {
		// TODO Auto-generated method stub
		TdUserandpersonalneeds tdUserandpersonalneeds = new TdUserandpersonalneeds();
		Example example = new Example(tdUserandpersonalneeds.getClass());
		
		example.createCriteria().andEqualTo("userId", user_id);
		List<TdUserandpersonalneeds> list = this.mapper.selectByExample(example);
		//需求类型   这里显示活动类别则以活动类别id做判断，如果改显示活动则以需求id做判断
		for (TdUserandpersonalneeds tdUserandpersonalneeds2 : list) {
			TdActivitycategory tdActivitycategory = activityTypeService.queryById(tdUserandpersonalneeds2.getActivitycategoryId());
/*			tdUserandpersonalneeds2.setPersonalneedsType(tdPersonalneeds.getPersonalneedsType());
*/			tdUserandpersonalneeds2.setActivityType(tdActivitycategory.getActivitycategoryName());
		}
		//最终存放数据集合,去重复
		List<TdUserandpersonalneeds> listTdUserandpersonalneeds = new  ArrayList<>();
		Map<String ,TdUserandpersonalneeds> map = new HashMap<>();
		for (TdUserandpersonalneeds tdUserandpersonalneeds2 : list) {
		     map.put(tdUserandpersonalneeds2.getActivitycategoryId(), tdUserandpersonalneeds2);
	    }
		Set<Entry<String, TdUserandpersonalneeds>> mapFor= map.entrySet();
		for (Entry<String, TdUserandpersonalneeds> entry : mapFor) {
		     listTdUserandpersonalneeds.add(entry.getValue());
	    }
		//统计每个需求次数
		int needCount = 0;
		for(int i=0;i<listTdUserandpersonalneeds.size();i++) {
			TdUserandpersonalneeds tdUserandpersonalneedsC = new TdUserandpersonalneeds();
			tdUserandpersonalneedsC.setActivitycategoryId(listTdUserandpersonalneeds.get(i).getActivitycategoryId());
			needCount = super.queryTotalCount(tdUserandpersonalneedsC);			
			listTdUserandpersonalneeds.get(i).setNeedCount(needCount);
			
		}
	
		return listTdUserandpersonalneeds;
	}
}
