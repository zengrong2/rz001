package com.fh.service.student;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.company.Application;
import com.fh.util.PageData;

public interface StudentResumeManager {

	List<Application> listStudentResume(Page page) throws Exception;

	void delStudentResumeByCid(PageData pd) throws Exception;

	void saveStudentResumeInfo(PageData pd) throws Exception;

	PageData getStudentResumeById(PageData pd) throws Exception;

	void editStudentResume(PageData pd) throws Exception;

	void deleteAllResume(String[] arrayResume_IDS) throws Exception;

	List<Application> getListStudentResume() throws Exception;

}
