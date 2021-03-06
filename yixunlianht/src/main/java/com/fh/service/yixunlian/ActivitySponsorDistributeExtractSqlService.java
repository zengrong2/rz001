package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivitySponsorDistributeExtract;

@Service
public class ActivitySponsorDistributeExtractSqlService implements ActivitySponsorDistributeExtractSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdActivitySponsorDistributeExtract> getAllTdActivitySponsorDistributeExtract(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdActivitySponsorDistributeExtract>)dao.findForList("TdActivitySponsorDistributeExtractMapper.getAllActivitySponsorDistributeExtractlistPage", page);
	}
}
