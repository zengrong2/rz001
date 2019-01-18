package com.fh.service.school;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.school.School;
import com.fh.util.PageData;

public interface SchoolManager {
	public List<School> listAllSchool(Page page)throws Exception;
	public  PageData findSchoolById(PageData pd) throws Exception;
	public void saveS(PageData pd)throws Exception;
	/**
	 * 删除
	 */
	public void deleteS(PageData pd)throws Exception;
	
	public  PageData findSchoolByUid(PageData pd) throws Exception;
	
	public void editS(PageData pd)throws Exception;
	
	public void editState(PageData sm)throws Exception;
////	//新添加根据学校类型选择学校
//	
//	public List<School> findSchoolByType(Page page);
	public List<School> findListTrain(Page page) throws Exception;
	//学历提升
	public List<School> listPromotionSchool(Page page) throws Exception;
	public PageData findSchoolByName(String school_names) throws Exception;
	
	
}
