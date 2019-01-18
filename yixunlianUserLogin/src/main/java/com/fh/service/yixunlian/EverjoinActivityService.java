package com.fh.service.yixunlian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ClientUserMapper;
import com.fh.lw.mapper.EverjoinActivityMapper;
import com.fh.lw.pojo.yixunlian.TdEverjoin;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;

@Service
public class EverjoinActivityService extends BaseService<TdEverjoin>{
	 @Autowired
	  private EverjoinActivityMapper mapper;
//匹配曾经参与
	public List<TdEverjoin> getListTdEverjoin(String activitycategory_id) {
		// TODO Auto-generated method stub
		TdEverjoin TdEverjoin =new TdEverjoin();
		Example example =new Example(TdEverjoin.getClass());
		example.isDistinct();
		example.createCriteria().andEqualTo("activitycategoryId", activitycategory_id);
		List<TdEverjoin> listTdEverjoin = this.mapper.selectByExample(example);
		return listTdEverjoin;
	}
}
