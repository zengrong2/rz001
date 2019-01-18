package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdSystemHelp;
@Service
public class SystemHelpSqlService implements SystemHelpSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdSystemHelp> getAllTdSystemHelp(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdSystemHelp>)dao.findForList("TdSystemHelpMapper.getAllTdSystemHelplistPage", page);
	}

}
