package com.fh.service.school;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.course.Curriculum;
import com.fh.util.PageData;

@Service
public class SchoolCurriculumService implements SchoolCurriculumManager{
 
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@SuppressWarnings("unchecked")
	@Override
	public List<Curriculum> listSchoolCurriculum(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<Curriculum>)dao.listSchoolCurriculum("CurriculumMapper.SchoolCurriculumlistPage",page);
	}

	@Override
	public void deleteSchoolCurriculumByCid(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteSchoolCurriculumByCid("CurriculumMapper.delSchoolCurriculumByCid",pd);
	}

	@Override
	public void saveSchoolCurriculumInfo(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.saveSchoolCurriculumInfo("CurriculumMapper.saveSchoolCurriculumInfo",pd);
	}

	@Override
	public PageData getSchoolCurriculumById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.getSchoolCurriculumById("CurriculumMapper.getSchoolCurriculumById",pd);
	}

	@Override
	public void editSchoolCurriculum(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.editSchoolCurriculum("CurriculumMapper.editSchoolCurriculum",pd);
	}

	@Override
	public void deleteAllCurriculum(String[] arrayCurriculum_IDS) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("CurriculumMapper.deleteAllCurriculum", arrayCurriculum_IDS);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curriculum> findTrainCurriculumDetailByS_id(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<Curriculum>)dao.findForList("CurriculumMapper.findTrainCurriculumDetailByS_id",pd);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curriculum> listSchoolCurriculumByName(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<Curriculum>)dao.findForList("CurriculumMapper.listSchoolCurriculumByName",pd);
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Curriculum> getListSchoolCurriculum(Map<String,Integer> list) throws Exception {
//		// TODO Auto-generated method stub
//		return (List<Curriculum>)dao.findForList("CurriculumMapper.getListSchoolCurriculumlistPage", list) ;
//	}

	
}
