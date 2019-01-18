package com.fh.service.school;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.lw.pojo.finance.LunBo;
import com.fh.lw.pojo.school.Platform;
import com.fh.service.system.user.LuBoManager;
import com.fh.util.PageData;

@Service
public class PlatformService implements PlatformManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@Override
	public PageData listPlatform(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData) dao.findForObject("PlatformMapper.listPlatform", pd);
	}

	@Override
	public void editP(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("PlatformMapper.editP",pd);
	}

}
