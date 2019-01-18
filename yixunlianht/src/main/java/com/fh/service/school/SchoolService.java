package com.fh.service.school;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.school.School;
import com.fh.util.PageData;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
@Service
public class SchoolService implements SchoolManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	@SuppressWarnings("unchecked")
	@Override
	public List<School> listAllSchool(Page page) throws Exception {
		// TODO Auto-generated method stubfindForList
		return (List<School>)dao.findForList("SchoolMapper.schoollistPage",page);
	}
	@Override
	public PageData findSchoolById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData) dao.findForObject("SchoolMapper.findSchoolById", pd);
	}
	@Override
	public void saveS(PageData pd)throws Exception{
		dao.save("SchoolMapper.saveS", pd);
	}
	@Override
	public void deleteS(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		this.dao.delete("SchoolMapper.deleteS", pd);
	}
	@Override
	public PageData findSchoolByUid(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData) dao.findForObject("SchoolMapper.findSchoolByUid", pd);
	}
    @Override
	public void editS(PageData pd)throws Exception{
		dao.update("SchoolMapper.editS", pd);
	}
	@Override
	public void editState(PageData sm) throws Exception {
		// TODO Auto-generated method stub
		dao.update("SchoolMapper.editState", sm);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<School> findListTrain(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<School>)dao.findForList("SchoolMapper.trainlistPage",page);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<School> listPromotionSchool(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<School>)dao.findForList("SchoolMapper.promotionSchoollistPage",page);
	}
	@Override
	public PageData findSchoolByName(String school_names) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.findSchoolByName("SchoolMapper.findSchoolByName",school_names);
	}
	
	
	
	
//	//2018/8/3
//	@Override
//	public List<School> findSchoolByType(Page page) {
//	return (List<School>)dao.findSchoolByType("SchoolMapper.schoollistPage",page);
//
//		
//	}
}
