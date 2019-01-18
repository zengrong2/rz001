package com.fh.service.system.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.lw.pojo.finance.LunBo;
import com.fh.service.system.user.LuBoManager;
import com.fh.util.PageData;

@Service
public class LuBoService implements LuBoManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@Override
	public PageData listLunBo(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData) dao.findForObject("LunBoMapper.listLunBo", pd);
	}

	@Override
	public void ediL(LunBo lunbo) throws Exception {
		// TODO Auto-generated method stub
		dao.update("LunBoMapper.editL",lunbo);
	}

}
