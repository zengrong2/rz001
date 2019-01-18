package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;

@Service
public class ActivityMusicSqlService  implements ActivityMusicSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdActivitymusicurl> getAllTdlistActivityMusic(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdActivitymusicurl>)dao.findForList("TdActivitymusicurlMapper.getAllTdActivityMusiclistPage", page);
	}
}
