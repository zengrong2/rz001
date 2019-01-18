package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdBackgroundTransferRecordinput;
import com.fh.util.PageData;

@Service
public class BackgroundTransferRecordinputSqlService implements BackgroundTransferRecordinputSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdBackgroundTransferRecordinput> getAllTdBackgroundTransferRecordinput(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdBackgroundTransferRecordinput>)dao.findForList("TdBackgroundTransferRecordinputMapper.getAllTdBackgroundTransferRecordinputlistPage", page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> getfinancialBackgroundInputStatistics(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("TdBackgroundTransferRecordinputMapper.financialBackgroundInputStatistics", page);
	}
}
