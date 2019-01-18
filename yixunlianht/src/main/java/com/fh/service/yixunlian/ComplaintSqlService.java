package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdComplaint;
import com.fh.util.PageData;

@Service
public class ComplaintSqlService implements ComplaintSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> getAllTdComplaint(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("TdComplaintMapper.getAllTdComplaintlistPage", page);
	}
}