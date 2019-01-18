package com.fh.service.school;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.obtainemployment.Prejob;
import com.fh.util.PageData;

@Service
public class PreJobService implements PreJobManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<Prejob> findListPreJobType(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<Prejob>)dao.listPreJobType("PreJobMapper.preJobTypelistPage",page);
	}

	@Override
	public void delPreJobTypeBylid(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.delPreJobTypeBylid("PreJobMapper.delPreJobTypeBylid",pd);
	}

	@Override
	public void savePreJobTypeInfo(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.savePreJobTypeInfo("PreJobMapper.savePreJobTypeInfo",pd);
	}

	@Override
	public PageData getPreJobTypeTypeById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.getPreJobTypeTypeById("PreJobMapper.getPreJobTypeTypeById",pd);
	}

	@Override
	public void editPreJobTypeType(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.editPreJobTypeType("PreJobMapper.editPreJobTypeType",pd);
	}

	@Override
	public void deleteAllProJobType(String[] arrayProJobType_IDS) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("PreJobMapper.deleteAllProJobType", arrayProJobType_IDS);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prejob> ListPreJobType() throws Exception {
		// TODO Auto-generated method stub
		return (List<Prejob>)dao.ListPreJobType("PreJobMapper.ListPreJobType");
	}
	
}
