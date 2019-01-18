package com.fh.service.company;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.company.Position;
import com.fh.util.PageData;

public interface WorkManager {

	List<Position> findListWord(Page page)throws Exception;

	PageData findPositionByPidd(PageData pd) throws Exception;

	void deletePosition(PageData pd) throws Exception;

	

	void edit(PageData pd) throws Exception;

	void savePosition(PageData pd) throws Exception;

	void deleteAllPosition(String[] arrayPosition_IDS) throws Exception;

	PageData findPositionById(int p_id) throws Exception;

	List<Position> findPositionByCompanyId(int companyId) throws Exception;

	void updateWorkState(PageData pd) throws Exception;

	List<PageData> findListPositionByCompanyId(Integer company_id) throws Exception;

	void editPositionState(PageData pd) throws Exception;

	List<Position> getFindListWork(PageData pd) throws Exception;

	



}
