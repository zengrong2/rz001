package com.fh.service.school;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.educationschool.Category;
import com.fh.util.PageData;

public interface SchoolProTypeManager {

	List<Category> listAllSchoolProType(Page page) throws Exception;

	PageData getSchoolProTypeById(PageData pd) throws Exception;

	void editSchoolProType(PageData pd) throws Exception;

	void deleteSchoolProTypeByCid(PageData pd) throws Exception;

	void saveSchoolProTypeInfo(PageData pd) throws Exception;

	void deleteAllSchoolProType(String[] arraySchoolProType_IDS) throws Exception;

	List<Category> findAllSchoolProType(PageData pd) throws Exception;

	

}
