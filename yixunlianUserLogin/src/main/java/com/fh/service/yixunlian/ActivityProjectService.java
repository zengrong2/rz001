package com.fh.service.yixunlian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.ActivityProjectMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivityChargeItem;
import com.fh.lw.pojo.yixunlian.TdActivityprojectandacsign;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;

@Service
public class ActivityProjectService extends BaseService<TdActivityChargeItem>{
	 @Autowired
	  private ActivityProjectMapper mapper;

	public List<TdActivityChargeItem> getChargeProject(String activity_id) {
		// TODO Auto-generated method stub
		TdActivityChargeItem activityChargeItem= new TdActivityChargeItem();
		Example example = new Example(activityChargeItem.getClass());
		example.createCriteria().andEqualTo("activityId", activity_id);
		List<TdActivityChargeItem> listActivityChargeItem = this.mapper.selectByExample(example);
		
		return listActivityChargeItem;
	}

	
}
