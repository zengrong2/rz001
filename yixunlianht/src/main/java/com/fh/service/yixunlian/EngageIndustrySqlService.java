package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdEngagendustry;

@Service
public class EngageIndustrySqlService implements EngageIndustrySqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdEngagendustry> getAllTdEngagendustry(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdEngagendustry>)dao.findForList("TdEngagendustryMapper.getAllTdEngagendustrylistPage", page);
	}
}
