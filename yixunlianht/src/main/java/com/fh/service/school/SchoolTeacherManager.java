package com.fh.service.school;

import java.util.List;
import com.fh.entity.Page;
import com.fh.lw.pojo.school.SchoolTeacher;
import com.fh.util.PageData;

public interface SchoolTeacherManager {
	public List<SchoolTeacher> listAllSchoolTeacher(Page page)throws Exception;
	public  PageData findSchoolTeacherById(PageData pd) throws Exception;
	public void saveSt(PageData sm)throws Exception;
	/**
	 * 删除
	 */
	public void deleteSt(PageData pd)throws Exception;
	public void editSt(PageData sm)throws Exception;
	public List<SchoolTeacher> schoolTeacherBySId(PageData pd)throws Exception;
}
