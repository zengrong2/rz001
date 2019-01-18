package com.fh.service.yixunlian;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.NewsMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdJournalism;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;

@Service
public class NewsService extends BaseService<TdJournalism>{
	 @Autowired
	 private NewsMapper mapper;

	public void deleteJournalismById(String journalism_id) {
		// TODO Auto-generated method stub
		TdJournalism tdJournalism = new TdJournalism(); 
		tdJournalism.setJournalismId(journalism_id);
		super.deleteByWhere(tdJournalism);
	}

	@SuppressWarnings("unchecked")
	public void delAllJournalism(String journalism_IDS) {
		// TODO Auto-generated method stub
		String ArrayJournalism_IDS[] = journalism_IDS.split(",");
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i=0;i<ArrayJournalism_IDS.length;i++) {
			
			list.add(ArrayJournalism_IDS[i]);
		}
		TdJournalism tdJournalism = new TdJournalism(); 
		super.deleteByIds((Class<TdJournalism>) tdJournalism.getClass(), "journalismId", list);
	}

	public void updateActivityState(String journalism_id, Integer is_online) {
		// TODO Auto-generated method stub
		TdJournalism tdJournalism = new TdJournalism(); 
		TdJournalism tdJournalism2 = super.queryById(journalism_id);			
		Example example = new Example(tdJournalism.getClass());
		if(is_online==1) {			
			
			tdJournalism2.setIs_online(0);
			super.updateSelective(tdJournalism2);
			return ;
		}
		if(is_online!=1){
			
			tdJournalism2.setIs_online(1);
			super.updateSelective(tdJournalism2);
			return ;
		}
	}
}
