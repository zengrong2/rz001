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

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> getDiamondCustomerManagerStatistics(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("TdUserMapper.getDiamondCustomerManagerStatistics", page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> getVipCustomerManagerStatistics(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("TdUserMapper.getVipCustomerManagerStatistics", page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> getVipTryCustomerManagerStatistics(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("TdUserMapper.getVipTryCustomerManagerStatistics", page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> getVipExperienceCustomerManagerStatistics(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("TdUserMapper.getVipExperienceCustomerManagerStatistics", page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> getCustomerManagerStatistics(Page page) throws Exception {
		// TODO Auto-generated method stub
		return ( List<PageData>)dao.findForList("TdUserMapper.getCustomerManagerStatistics", page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> getCustomerStatistics(Page page) throws Exception {
		// TODO Auto-generated method stub
		return ( List<PageData>)dao.findForList("TdUserMapper.getCustomerStatistics", page);
	}
}
