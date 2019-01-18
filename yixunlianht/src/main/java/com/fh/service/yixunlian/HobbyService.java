package com.fh.service.yixunlian;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.HobbyMapper;
import com.fh.lw.pojo.yixunlian.SysFhlog;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
import com.fh.lw.pojo.yixunlian.TdHobbyAndactivitycategory;
import com.fh.lw.pojo.yixunlian.TdUhobby;
import com.fh.lw.service.BaseService;
@Service
public class HobbyService extends BaseService<TdUhobby>{
	 @Autowired
	 private HobbyMapper mapper;

	public void deleteUhobbyById(String hobby_id) {
		// TODO Auto-generated method stub
		TdUhobby tdUhobby = new TdUhobby();
		tdUhobby.setHobbyId(hobby_id);
		
		super.deleteByWhere(tdUhobby);
	}

	public void updateTdHobby(String hobby_id, String hobby_name, String remark) {
		// TODO Auto-generated method stub
		TdUhobby tdUhobby = new TdUhobby();
		tdUhobby.setHobbyId(hobby_id);
		tdUhobby.setHobbyName(hobby_name);
		tdUhobby.setRemark(remark);
	 	super.updateSelective(tdUhobby);
	}

	
}
