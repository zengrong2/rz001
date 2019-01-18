package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdUhobby;

@Service
public class HobbySqlService implements HobbySqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdUhobby> getAllTdHobby(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdUhobby>)dao.findForList("TdUhobbyMapper.getAllTdhobbylistPage", page);
	}
}
