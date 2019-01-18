package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdMembershipwelfare;
@Service
public class WelfareSqlService implements WelfareSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdMembershipwelfare> getAllTdMembershipwelfare(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdMembershipwelfare>)dao.findForList("TdMembershipwelfareMapper.getAllTdMembershipwelfarelistPage", page);
	}
}
