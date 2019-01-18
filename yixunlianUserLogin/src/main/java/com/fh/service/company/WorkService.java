package com.fh.service.company;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.lw.pojo.company.Position;
import com.fh.util.PageData;

@Service
public class WorkService implements WorkManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	@SuppressWarnings("unchecked")
	@Override
	public List<Position> findListWord(Page page) throws Exception{
		// TODO Auto-generated method stub
		return  (List<Position>)dao.findListWorks("WorkMapper.findListWorkslistPage",page);
	}
	@Override
	public PageData findPositionByPidd(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.findPositionByPid("WorkMapper.findPositionByPid",pd);
	}
	@Override
	public void deletePosition(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.deletePositionByPid("WorkMapper.deletePositionByPid",pd);
	}
	
	@Override
	public void edit(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.editPositionByPid("WorkMapper.editPositionByPid",pd);
	}
	@Override
	public void savePosition(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.savePositionInfo("WorkMapper.savePositionInfo",pd);

	}
	@Override
	public void deleteAllPosition(String[] arrayPosition_IDS) throws Exception {
		// TODO Auto-generated method stub
		dao.delete("WorkMapper.deleteAllPosition", arrayPosition_IDS);
	}
	@Override
	public PageData findPositionById(int p_id) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.findPositionByPid("WorkMapper.findPositionById", p_id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Position> findPositionByCompanyId(int companyId) throws Exception {
		// TODO Auto-generated method stub
		return (List<Position>)dao.findForList("WorkMapper.findPositionByCompanyId", companyId);
	}
	@Override
	public void updateWorkState(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("WorkMapper.updateWorkState", pd);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PageData> findListPositionByCompanyId(Integer company_id) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>)dao.findForList("WorkMapper.findPositionByCompanyId", company_id);
	}
	@Override
	public void editPositionState(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("WorkMapper.editPositionState", pd);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Position> getFindListWork(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<Position>)dao.findForList("WorkMapper.getFindListWork", pd);
	}
	

	
}
