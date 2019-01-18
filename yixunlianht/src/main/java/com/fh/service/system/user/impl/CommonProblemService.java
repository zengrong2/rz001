package com.fh.service.system.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.service.system.user.CommonProblemManager;
import com.fh.util.PageData;

@Service
public class CommonProblemService implements CommonProblemManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> problemlistPage(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("CommonProblemMapper.problemlistPage", page);
	}

	@Override
	public void editP(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		this.dao.update("CommonProblemMapper.editP", pd);
	}

	@Override
	public void saveP(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		this.dao.save("CommonProblemMapper.saveP", pd);
	}

	@Override
	public PageData getProblemById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.findForObject("CommonProblemMapper.getProblemById", pd);
	}
	@Override
	public void deleteP(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		this.dao.delete("CommonProblemMapper.deleteP", pd);
	}

}
