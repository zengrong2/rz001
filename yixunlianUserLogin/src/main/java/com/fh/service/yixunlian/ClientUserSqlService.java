package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.util.PageData;

@Service
public class ClientUserSqlService implements ClientUserSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> getAllTdUser(Page page) throws Exception {
		
		return (List<PageData>)dao.findForList("TdUserMapper.getAllTdUserlistPage", page);
	}
}
