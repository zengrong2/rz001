package com.fh.service.school;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.school.SchoolMajor;
import com.fh.lw.pojo.user.Teacher;
import com.fh.util.PageData;
@Service
public class SchoolMajorService implements SchoolMajorManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	@SuppressWarnings("unchecked")
	@Override
	public List<SchoolMajor> listAllSchoolMajor(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<SchoolMajor>)dao.findForList("SchoolMajorMapper.schoolMajorlistPage",page);
	}
	@Override
	public PageData findSchoolMajorById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData) dao.findForObject("SchoolMajorMapper.findSchoolMajorById", pd);
	}
	@Override
	public void saveSm(PageData pd)throws Exception{
		dao.save("SchoolMajorMapper.saveSm", pd);
	}
	@Override
	public void deleteSm(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		this.dao.delete("SchoolMajorMapper.deleteSm", pd);
	}
    @Override
	public void editSm(PageData pd)throws Exception{
		dao.update("SchoolMajorMapper.editSm", pd);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SchoolMajor> schoolMajorBySId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<SchoolMajor>) dao.findForList("SchoolMajorMapper.schoolMajorBySId", pd);
	}
	//每个学生交的费用
	@SuppressWarnings("unchecked")
	@Override
	public SchoolMajor getMoneyBySid(PageData pd)throws Exception {
		// TODO Auto-generated method stub
		return (SchoolMajor)dao.soloStuMoney("SchoolMajorMapper.studentStyMajorMoney",pd);
	}
	@SuppressWarnings("unchecked")
	@Override
	public  List<PageData> findSchooMajorByName(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("SchoolMajorMapper.findSchooMajorByName",pd);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SchoolMajor> getlistAllSchoolMajor(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<SchoolMajor>)dao.findForList("SchoolMajorMapper.getlistAllSchoolMajor", pd);
	}
	
}
