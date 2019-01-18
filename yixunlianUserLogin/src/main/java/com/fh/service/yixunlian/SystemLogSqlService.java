package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.SysFhlog;
@Service
public class SystemLogSqlService implements SystemLogSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<SysFhlog> getAllSysFhlog(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<SysFhlog>)dao.findForList("FHlogMapper.getAllSysLoglistPage", page);
	}
}
