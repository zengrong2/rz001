package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdPartnerBonusTransferRecordinput;
import com.fh.util.PageData;

@Service
public class PartnerBonusTransferRecordinputSqlService implements PartnerBonusTransferRecordinputSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdPartnerBonusTransferRecordinput> getAllTdlistlistPartnerBonusTransferRecordinput(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdPartnerBonusTransferRecordinput>)dao.findForList("TdPartnerBonusInputMapper.getAllTdPartnerBonusInputlistPage", page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> getgetfinancialPartnerBonusInputStatistics(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("TdPartnerBonusInputMapper.financialPartnerBonusInputStatistics", page);
	}
}
