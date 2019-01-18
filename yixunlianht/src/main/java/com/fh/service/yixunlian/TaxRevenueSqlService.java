package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdTaxrevenue;

@Service
public class TaxRevenueSqlService implements TaxRevenueSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdTaxrevenue> getAllTdTaxrevenue(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdTaxrevenue>)dao.findForList("TdTaxrevenueMapper.getAllTdTaxRevenuelistPage", page);
	}

}
