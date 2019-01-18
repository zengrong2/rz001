package com.fh.service.yixunlian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ClientUserAndHobbyMapper;
import com.fh.lw.mapper.ClientUserAndPersonalNeedsMapper;
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

	public List<TdUserandpersonalneeds> getListTdUserandpersonalneeds(String user_id) {
		// TODO Auto-generated method stub
		TdUserandpersonalneeds tdUserandpersonalneeds = new TdUserandpersonalneeds();
		Example example = new Example(tdUserandpersonalneeds.getClass());
		example.createCriteria().andEqualTo("userId", user_id);
		List<TdUserandpersonalneeds> listTdUserandpersonalneeds = this.mapper.selectByExample(example);
		for (TdUserandpersonalneeds tdUserandpersonalneeds2 : listTdUserandpersonalneeds) {
			TdPersonalneeds tdPersonalneeds =personalneedsService.queryById(tdUserandpersonalneeds2.getPersonalneedsId());
			tdUserandpersonalneeds2.setTdPersonalneeds(tdPersonalneeds);
		}
		
		return listTdUserandpersonalneeds;
	}
}
