package com.fh.service.yixunlian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ClientUserAndHobbyMapper;
import com.fh.lw.mapper.ClientUserMapper;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.lw.pojo.yixunlian.TdUserandhobby;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;

import net.sf.jsqlparser.expression.Function;

@Service
public class ClientUserAndHobbyService extends BaseService<TdUserandhobby>{
	 @Autowired
	  private ClientUserAndHobbyMapper mapper;

	@SuppressWarnings("unlikely-arg-type")
	public List<TdUserandhobby> getListTdUserandhobby(String user_id) {
		// TODO Auto-generated method stub
		TdUserandhobby tdUserandhobby = new TdUserandhobby();
		Example example = new Example(tdUserandhobby.getClass());
				
		example.createCriteria().andEqualTo("userId", user_id);
		List<TdUserandhobby> list = this.mapper.selectByExample(example);
		//最终存放数据集合,去重复
		List<TdUserandhobby> listTdUserandhobby = new  ArrayList<>();
        Map<String ,TdUserandhobby> map = new HashMap<>();
        for (TdUserandhobby tdUserandhobby2 : list) {
        	map.put(tdUserandhobby2.getHobbyId(), tdUserandhobby2);
		}
        Set<Entry<String, TdUserandhobby>> mapFor= map.entrySet();
        for (Entry<String, TdUserandhobby> entry : mapFor) {
        	listTdUserandhobby.add(entry.getValue());
		}
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
