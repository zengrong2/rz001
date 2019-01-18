package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdAidFund;
import com.fh.util.PageData;

@Service
public class AidFundSqlService implements AidFundSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdAidFund> getAllTdlistTdAidFund(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdAidFund>)dao.findForList("AidFundMapper.getAllTdAidFundlistPage", page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> getfinancialAidFundInputStatistics(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("AidFundMapper.financialAidFundInputStatistics", page);
	}

}
