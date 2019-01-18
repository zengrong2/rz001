package com.fh.service.school;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.school.Qualified;
import com.fh.util.PageData;
@Service
public class QualifiedService implements QualifiedManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	@SuppressWarnings("unchecked")
	@Override
	public List<Qualified> listAllQualified(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<Qualified>)dao.findForList("QualifiedMapper.qualifiedlistPage",page);
	}
	@Override
	public PageData findQualifiedById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData) dao.findForObject("QualifiedMapper.findQualifiedById", pd);
	}
	@Override
	public void saveQ(PageData pd)throws Exception{
		dao.save("QualifiedMapper.saveQ", pd);
	}
	@Override
	public void deleteQ(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		this.dao.delete("QualifiedMapper.deleteQ", pd);
	}
    @Override
	public void editQ(PageData pd)throws Exception{
		dao.update("QualifiedMapper.editQ", pd);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Qualified> qualifiedBySId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<Qualified>) dao.findForList("QualifiedMapper.qualifiedBySId", pd);
	}
}
