package com.fh.service.yixunlian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fh.lw.mapper.ActivityFillInItemMapper;
import com.fh.lw.pojo.yixunlian.TdActivityFillInItem;
import com.fh.lw.pojo.yixunlian.TdExtractproject;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;
//报名填写项目
@Service
public class ActivityFillInItemService extends BaseService<TdActivityFillInItem>{
	 @Autowired
	  private ActivityFillInItemMapper mapper;

	public List<TdActivityFillInItem> listMustFillTdActivityFillInItem() {
		// TODO Auto-generated method stub
		TdActivityFillInItem tdActivityFillInItem = new TdActivityFillInItem();
		Example example =new Example(tdActivityFillInItem.getClass());
		example.createCriteria().andEqualTo("type", 0);
		List<TdActivityFillInItem> listTdActivityFillInItem = this.mapper.selectByExample(example);
	
		return listTdActivityFillInItem;
	}

	public List<TdActivityFillInItem> listNotMustFillTdActivityFillInItem(String activity_id) {
		// TODO Auto-generated method stub
		TdActivityFillInItem tdActivityFillInItem = new TdActivityFillInItem();
		Example example =new Example(tdActivityFillInItem.getClass());
		example.createCriteria().andEqualTo("activityId", activity_id).andNotEqualTo("type", 0);
		List<TdActivityFillInItem> listTdActivityFillInItem = this.mapper.selectByExample(example);
	
		return listTdActivityFillInItem;
	}
}
