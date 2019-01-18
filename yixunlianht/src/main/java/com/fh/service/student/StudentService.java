package com.fh.service.student;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.student.Student;
import com.fh.util.PageData;

@Service
public class StudentService implements StudentManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
    
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listAllStudent(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<Student>)dao.findForList("StudentMapper.studentlistPage",page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listStudentByInviter(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("StudentMapper.listStudentByInviter",pd);
	}

	@Override
	public PageData findStudentById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData) dao.findForObject("StudentMapper.findStudentById", pd);
	}

	@Override
	public void editS(PageData pd) throws Exception {
		dao.update("StudentMapper.editS", pd);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listStudentBySchoolId(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("StudentMapper.schoolStudentlistPage",page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listAllStudents(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("StudentMapper.listAllStudents",pd);
	}
	//新添加一级老师自己招聘学生
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudentByTid(Long tid) throws Exception {
		// TODO Auto-generated method stub
		return(List<Student>)dao.findForListByTid("StudentMapper.listAllStudentByTid",tid);
	}
	

	@Override
	public void editTid(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("StudentMapper.editTid", pd);
	}

	@Override
	public void deleteU(PageData pd) {
		try {
			dao.delete("StudentMapper.deleteStuden", pd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//2018/8/4确认学生就读
	@Override
	public void comfirmStuden(PageData pd) {
		// TODO Auto-generated method stub
		dao.comfireStudy("StudentMapper.comfireStudent",pd);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> findFirstTeaGetStu(PageData pd) {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findFirstTeaGetStu("StudentMapper.findFirstTeaGetStu",pd);
	}

	
	

}
