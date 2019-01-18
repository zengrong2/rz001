package com.fh.service.company;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.obtainemployment.Labour;
import com.fh.util.PageData;
@Service
public class LabourWorkService implements LabourWorkManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<Labour> ListLabourWordType(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<Labour>)dao.listLabourWordType("LabourWorkTypeMapper.labourWordTypelistPage",page);
	}

	@Override
	public void deleteLabourTypeBylid(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteLabourTypeBylid("LabourWorkTypeMapper.deleteLabourTypeBylid",pd);
	}

	@Override
	public PageData getLabourTypeById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.getLabourTypeById("LabourWorkTypeMapper.getLabourTypeById",pd);
	}

	@Override
	public void editLabourType(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.editLabourType("LabourWorkTypeMapper.editLabourType",pd);
	}

	@Override
	public void saveLabourTypeInfo(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.saveLabourTypeInfo("LabourWorkTypeMapper.saveLabourTypeInfo",pd);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Labour> showListLabourWorkType() throws Exception {
		// TODO Auto-generated method stub
		return (List<Labour>)dao.showListLabourWorkType("LabourWorkTypeMapper.showListLabourWorkType");
	}

	@Override
	public Labour findLabourTypeById(int getwId) throws Exception {
		// TODO Auto-generated method stub
		return (Labour)dao.findLabourTypeById("LabourWorkTypeMapper.findLabourTypeById",getwId);
	}

	@Override
	public void deleteAllLabourWorkType(String[] arrayLabourWorkType_IDS) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("LabourWorkTypeMapper.deleteAllLabourWorkType", arrayLabourWorkType_IDS);
	}

	

	
	
}
