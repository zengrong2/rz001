package com.fh.service.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.company.Application;
import com.fh.util.PageData;

@Service
public class StudentResumeService implements StudentResumeManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<Application> listStudentResume(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<Application>)dao.listStudentResume("StudentResumeMapper.studentResumelistPage",page);
	}

	@Override
	public void delStudentResumeByCid(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.delStudentResumeByCid("StudentResumeMapper.delStudentResumeByCid",pd);
		
	}

	@Override
	public void saveStudentResumeInfo(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.saveStudentResumeInfo("StudentResumeMapper.saveStudentResumeInfo",pd);
	}

	@Override
	public PageData getStudentResumeById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.getStudentResumeById("StudentResumeMapper.getStudentResumeById",pd);
	}

	@Override
	public void editStudentResume(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.editStudentResume("StudentResumeMapper.editStudentResume",pd);
	}

	@Override
	public void deleteAllResume(String[] arrayResume_IDS) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("StudentResumeMapper.deleteAllResume", arrayResume_IDS);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Application> getListStudentResume() throws Exception {
		// TODO Auto-generated method stub
		return (List<Application>)dao.getListStudentResume("StudentResumeMapper.listStudentResume");
	}
}
