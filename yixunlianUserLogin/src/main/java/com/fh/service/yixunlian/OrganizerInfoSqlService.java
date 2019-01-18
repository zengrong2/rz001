package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdOrganizerInfo;

@Service
public class OrganizerInfoSqlService implements OrganizerInfoSqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<TdOrganizerInfo> getAllTdlistOrganizerInfo(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<TdOrganizerInfo>)dao.findForList("TdOrganizerInfoMapper.getAllTdOrganizerInfolistPage", page);
	}

	
}
