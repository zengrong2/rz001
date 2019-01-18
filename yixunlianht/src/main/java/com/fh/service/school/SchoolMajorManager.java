package com.fh.service.school;

import java.util.List;
import java.util.Map;

import com.fh.entity.Page;
import com.fh.lw.pojo.school.SchoolMajor;
import com.fh.lw.pojo.user.Teacher;
import com.fh.util.PageData;

public interface SchoolMajorManager {
	public List<SchoolMajor> listAllSchoolMajor(Page page)throws Exception;
	public  PageData findSchoolMajorById(PageData pd) throws Exception;
	public void saveSm(PageData sm)throws Exception;
	/**
	 * 删除
	 */
	public void deleteSm(PageData pd)throws Exception;
	public void editSm(PageData sm)throws Exception;
	public List<SchoolMajor> schoolMajorBySId(PageData pd)throws Exception;
	//每个学生的报名费用
	public SchoolMajor getMoneyBySid(PageData tempSaveMap) throws Exception;
	public  List<PageData> findSchooMajorByName(PageData pd) throws Exception;
	public List<SchoolMajor> getlistAllSchoolMajor(PageData pd) throws Exception;
	
}
