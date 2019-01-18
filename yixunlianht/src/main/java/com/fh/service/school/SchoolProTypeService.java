package com.fh.service.school;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.educationschool.Category;
import com.fh.util.PageData;

@Service
public class SchoolProTypeService implements SchoolProTypeManager {
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listAllSchoolProType(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<Category>)dao.findForList("SchoolProTypeMapper.SchoolProTypelistPage", page);
	}

	@Override
	public PageData getSchoolProTypeById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.findForObject("SchoolProTypeMapper.getSchoolProTypeById", pd);
	}

	@Override
	public void editSchoolProType(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.editS("SchoolProTypeMapper.editSchoolProType",pd);
	}

	@Override
	public void deleteSchoolProTypeByCid(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("SchoolProTypeMapper.deleteSchoolProTypeByCid", pd);
	}

	@Override
	public void saveSchoolProTypeInfo(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.save("SchoolProTypeMapper.saveSchoolProTypeInfo", pd);
	}

	@Override
	public void deleteAllSchoolProType(String[] arraySchoolProType_IDS) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("SchoolProTypeMapper.deleteAllSchoolProType", arraySchoolProType_IDS);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllSchoolProType(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<Category>)dao.findForList("SchoolProTypeMapper.findAllSchoolProType", pd);
	}
}
