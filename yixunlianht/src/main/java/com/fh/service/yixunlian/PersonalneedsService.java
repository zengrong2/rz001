package com.fh.service.yixunlian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.PersonalneedsMapper;
import com.fh.lw.mapper.ReportMapper;
import com.fh.lw.pojo.yixunlian.TdPersonalneeds;
import com.fh.lw.pojo.yixunlian.TdReport;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;

@Service
public class PersonalneedsService extends BaseService<TdPersonalneeds>{
	  @Autowired
	  private PersonalneedsMapper mapper;
//匹配个人需求
	public List<TdPersonalneeds> getListTdPersonalneeds(String activitycategory_id) {
		// TODO Auto-generated method stub
		TdPersonalneeds tdPersonalneeds = new TdPersonalneeds();
		Example example =new Example(tdPersonalneeds.getClass());
		example.isDistinct();
		example.createCriteria().andEqualTo("activitycategoryid", activitycategory_id);
		List<TdPersonalneeds> listTdPersonalneeds = this.mapper.selectByExample(example);
		return listTdPersonalneeds;
	}
}
