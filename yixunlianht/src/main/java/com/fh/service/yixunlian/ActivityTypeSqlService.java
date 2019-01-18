package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;
@Service
public class ActivityTypeSqlService implements ActivityTypeSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdActivitycategory> getAllTdActivity(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdActivitycategory>)dao.findForList("TdActivitycategoryMapper.getAllTdActivitycategorylistPage", page);
	}
}
