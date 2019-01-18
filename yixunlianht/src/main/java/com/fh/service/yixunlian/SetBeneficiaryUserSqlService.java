package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;

@Service
public class SetBeneficiaryUserSqlService implements SetBeneficiaryUserSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> getAllSetBeneficiaryUsery(Page page) throws Exception {
		// TODO Auto-generated method stub
		
		return (List<PageData>)dao.findForList("TdSetBeneficiaryUserMapper.getAllSetBeneficiaryUserlistPage", page);
	}
}
