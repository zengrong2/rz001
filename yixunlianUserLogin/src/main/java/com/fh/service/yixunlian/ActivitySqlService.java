package com.fh.service.yixunlian;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.util.PageData;
@Service
public class ActivitySqlService implements ActivitySqlManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> getAllTdActivity(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("TdActivityMapper.getAllTdActivitylistPage", page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> getOrganizerInfoPublistActivity(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("TdActivityMapper.getOrganizerInfoPublistActivitylistPage", page);
	}

	@Override
	public void deleteActivity(String[] arrayActivity_IDS) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("TdActivityMapper.deleteAllActivity", arrayActivity_IDS);

	}

}
