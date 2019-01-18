package com.fh.service.system.user.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.lw.pojo.user.Teacher;
import com.fh.service.system.user.TeacherManager;
import com.fh.util.PageData;

@Service
public class TeacherService implements TeacherManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> listSubTeacherBypId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<Teacher>)dao.findForList("TeacherMapper.listSubTeacherBypId", pd);
	}

	@Override
	public PageData getTeacherById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData) dao.findForObject("TeacherMapper.getTeacherById", pd);
	}

	@Override
	public void edit(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("TeacherMapper.updateTeacher",pd);
	}
	@Override
	public void saveT(PageData pd)throws Exception{
		dao.save("TeacherMapper.saveT", pd);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> listAllTeacher() throws Exception {
		// TODO Auto-generated method stub
		return (List<Teacher>) dao.findForList("TeacherMapper.listAllTeacher", null);
	}

	@Override
	public Teacher findTeacherById(Long tid) throws Exception {
		// TODO Auto-generated method stub
		return (Teacher) dao.findForObject("TeacherMapper.findTeacherById", tid);
	}

	@Override
	public Teacher findTeacherByPhone(String phone) throws Exception {
		// TODO Auto-generated method stub
		return (Teacher) dao.findForObject("TeacherMapper.findTeacherByPhone", phone);
	}

	@Override
	public void deleteT(Long tid) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("TeacherMapper.deleteTeacherById", tid);
	}
//2018/8/4
	

	@Override
	public void editPid(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("TeacherMapper.updatePid",pd);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listTeacherByYid(String ywyid) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("TeacherMapper.listTeacherByYid", ywyid);
	}

	@Override
	public void editYid(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("TeacherMapper.editYid", pd);
	}

	@Override
	public List<Teacher> listFirstFindTeacherBypId(Long pid) throws Exception {
		// TODO Auto-generated method stub
		return (List<Teacher>)dao.findForList("TeacherMapper.listFirstFindTeacherBypId", pid);

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> listTeacherBypId(Long tids)throws Exception  {
		// TODO Auto-generated method stub
		return (List<Teacher>)dao.findForList("TeacherMapper.listTeacherBypId", tids);

	}
//2018/8/4
	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> FirstFindSecondlistTeachersBypId(Long tid)throws Exception {
		// TODO Auto-generated method stub
		return (List<Teacher>)dao.firstFindSecondTeacherList("TeacherMapper.firstFindSecondListByTid",tid );

	}
//2018/8/8
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> findSecondTeaByFirstTeaTid(PageData pd)throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findSecondTeaByFirstTeaTid("TeacherMapper.findSecondTeaByFirstTeaTid",pd);
	}

	@Override
	public void addIntegralTeacherByTid(PageData pd) throws Exception{
		// TODO Auto-generated method stub
		dao.addIntegeral("TeacherMapper.addIntegralTeacher", pd);

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listTeacherBypId(PageData pd) {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.listTeacherBypId("TeacherMapper.listTeacherBypIds",pd);
	}

	@Override
	public Teacher findTeacherById2(Long long1) {
		// TODO Auto-generated method stub
		return (Teacher) dao.findForTeacher("TeacherMapper.findTeacherById2", long1);
	}

}
