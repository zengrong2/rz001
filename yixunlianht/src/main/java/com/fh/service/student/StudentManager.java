package com.fh.service.student;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.student.Student;
import com.fh.util.PageData;

public interface StudentManager {
	public List<Student> listAllStudent(Page page)throws Exception;
	public List<PageData> listStudentByInviter(PageData pd)throws Exception;
	public  PageData findStudentById(PageData pd) throws Exception;
	public void editS(PageData pd)throws Exception;
	public List<PageData> listStudentBySchoolId(Page page)throws Exception;
	public List<PageData> listAllStudents(PageData pd)throws Exception;
	public void editTid(PageData pd)throws Exception;
	public void deleteU(PageData pd)throws Exception;
	//一级老师自己招聘学生
	public List<Student> getAllStudentByTid(Long tid)throws Exception;
	//确认学生就读
	public void comfirmStuden(PageData pd);
	//2018/8/8
	public List<PageData> findFirstTeaGetStu(PageData pd);

}
