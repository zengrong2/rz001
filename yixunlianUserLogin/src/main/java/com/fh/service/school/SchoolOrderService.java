package com.fh.service.school;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;
@Service
public class SchoolOrderService implements SchoolOrderManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listAllSchoolOrder(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("SchoolOrderMapper.schoolOrderlistPage",page);
	}
	@Override
	public PageData findSchoolOrderById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData) dao.findForObject("SchoolOrderMapper.findSchoolOrderById", pd);
	}
    @Override
	public void editC(PageData pd)throws Exception{
		dao.update("SchoolOrderMapper.editC", pd);
	}
	@Override
	public Integer getZjMoney(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (Integer) dao.findForObject("SchoolOrderMapper.getZjMoney", pd);
	}
	
}
