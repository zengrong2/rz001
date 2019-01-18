package com.fh.service.school;

import java.util.List;
import java.util.Map;

import com.fh.entity.Page;
import com.fh.lw.pojo.course.Curriculum;
import com.fh.util.PageData;

public interface SchoolCurriculumManager {

	List<Curriculum> listSchoolCurriculum(Page page) throws Exception;

	
	void deleteSchoolCurriculumByCid(PageData pd) throws Exception;

	void saveSchoolCurriculumInfo(PageData pd) throws Exception;

	PageData getSchoolCurriculumById(PageData pd) throws Exception;

	void editSchoolCurriculum(PageData pd) throws Exception;


	void deleteAllCurriculum(String[] arrayCurriculum_IDS) throws Exception;


	List<Curriculum> findTrainCurriculumDetailByS_id(PageData pd) throws Exception;


	List<Curriculum> listSchoolCurriculumByName(PageData pd) throws Exception;


//	List<Curriculum> getListSchoolCurriculum(Map<String,Integer> pdList) throws Exception;


	

}
