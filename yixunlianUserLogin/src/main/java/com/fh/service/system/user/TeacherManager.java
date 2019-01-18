package com.fh.service.system.user;

import java.util.List;
import com.fh.lw.pojo.user.Teacher;
import com.fh.util.PageData;

public interface TeacherManager {
	public List<Teacher> listSubTeacherBypId(PageData pd)throws Exception;
	public PageData getTeacherById(PageData pd) throws Exception;
	public void edit(PageData pd) throws Exception;
	public void saveT(PageData pd)throws Exception;
	public List<Teacher> listAllTeacher()throws Exception;
	public Teacher findTeacherById(Long tid) throws Exception;
	public Teacher findTeacherByPhone(String phone) throws Exception;
	public void deleteT(Long tid)throws Exception;
	
	public void editPid(PageData pd) throws Exception;
	public List<PageData> listTeacherByYid(String ywyid)throws Exception;
	public void editYid(PageData pd) throws Exception;
	public List<Teacher> listFirstFindTeacherBypId(Long pid) throws Exception;
	public List<Teacher> listTeacherBypId(Long tids) throws Exception;
	//2018/8/4  一级老师id找二级老师们
	public List<Teacher> FirstFindSecondlistTeachersBypId(Long tid) throws Exception;
	//2018/8/4
	
	public List<PageData> findSecondTeaByFirstTeaTid(PageData pd)throws Exception;
	//添加积分
	public void addIntegralTeacherByTid(PageData pd) throws Exception;
	public List<PageData> listTeacherBypId(PageData pd);
	public Teacher findTeacherById2(Long long1);
	
}
