package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdSystembulletin;

@Service
public class SystembulletinSqlService implements SystembulletinSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdSystembulletin> getAllTdSystembulletin(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdSystembulletin>)dao.findForList("TdSystembulletinMapper.getAllTdSystembulletinlistPage", page);
	}
}
