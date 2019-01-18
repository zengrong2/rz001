package com.fh.service.student;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;
@Service
public class OpinionService implements OpinionManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> listAllOpinion(Page page) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("OpinionMapper.opinionlistPage",page);
	}
	@Override
	public PageData findOpinionById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData) dao.findForObject("OpinionMapper.findOpinionById", pd);
	}

	
}
