package com.fh.service.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.lw.pojo.student.StudentRecharge;
import com.fh.util.PageData;

@Service
public class StudentRechargeService implements StudentRechargeManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentRecharge> studentRechargeBySId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<StudentRecharge>) dao.findForList("StudentRechargeMapper.studentRechargeBySId", pd);
	}
	

}
