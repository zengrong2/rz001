package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdMemberUpdateExtract;

@Service
public class MemberUpdateExtractSqlService implements MemberUpdateExtractSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdMemberUpdateExtract> getAllTdlistMemberUpdateExtract(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdMemberUpdateExtract>)dao.findForList("TdMemberUpdateExtractMapper.getAllTdMemberUpdateExtractlistPage", page);
	}
}
