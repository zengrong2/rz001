package com.fh.service.yixunlian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ClientUserAndHobbyMapper;
import com.fh.lw.mapper.ClientUserMapper;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.lw.pojo.yixunlian.TdUserandhobby;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;

@Service
public class ClientUserAndHobbyService extends BaseService<TdUserandhobby>{
	 @Autowired
	  private ClientUserAndHobbyMapper mapper;

	public List<TdUserandhobby> getListTdUserandhobby(String user_id) {
		// TODO Auto-generated method stub
		TdUserandhobby tdUserandhobby = new TdUserandhobby();
		Example example = new Example(tdUserandhobby.getClass());
		example.createCriteria().andEqualTo("userId", user_id);
		List<TdUserandhobby> listTdUserandhobby = this.mapper.selectByExample(example);
		
		return listTdUserandhobby;
	}

	public List<TdUserandhobby> getlistTdUserAndHobbyByActivitycategoryId(String activitycategory_id) {
		// TODO Auto-generated method stub
		TdUserandhobby tdUserandhobby = new TdUserandhobby();
		Example example = new Example(tdUserandhobby.getClass());
		example.isDistinct();
		example.createCriteria().andEqualTo("activitycategoryId", activitycategory_id);
		List<TdUserandhobby> listTdUserAndHobby = this.mapper.selectByExample(example);
		
		return listTdUserAndHobby;
	}

}
