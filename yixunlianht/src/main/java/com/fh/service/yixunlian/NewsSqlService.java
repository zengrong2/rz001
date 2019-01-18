package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdJournalism;

@Service
public class NewsSqlService implements NewsSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdJournalism> getAllTdJournalism(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdJournalism>)dao.findForList("TdJournalismMapper.getAllTdJournalismlistPage", page);
	}
}
