package com.fh.service.school;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.school.SchoolTeacher;
import com.fh.util.PageData;
@Service
public class SchoolTeacherService implements SchoolTeacherManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	@SuppressWarnings("unchecked")
	@Override
	public List<SchoolTeacher> listAllSchoolTeacher(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<SchoolTeacher>)dao.findForList("SchoolTeacherMapper.schoolTeacherlistPage",page);
	}
	@Override
	public PageData findSchoolTeacherById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData) dao.findForObject("SchoolTeacherMapper.findSchoolTeacherById", pd);
	}
	@Override
	public void saveSt(PageData pd)throws Exception{
		dao.save("SchoolTeacherMapper.saveSt", pd);
	}
	@Override
	public void deleteSt(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		this.dao.delete("SchoolTeacherMapper.deleteSt", pd);
	}
    @Override
	public void editSt(PageData pd)throws Exception{
		dao.update("SchoolTeacherMapper.editSt", pd);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SchoolTeacher> schoolTeacherBySId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<SchoolTeacher>) dao.findForList("SchoolTeacherMapper.schoolTeacherBySId", pd);
	}
}
