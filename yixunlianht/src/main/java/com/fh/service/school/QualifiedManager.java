package com.fh.service.school;

import java.util.List;
import com.fh.entity.Page;
import com.fh.lw.pojo.school.Qualified;
import com.fh.util.PageData;

public interface QualifiedManager {
	public List<Qualified> listAllQualified(Page page)throws Exception;
	public  PageData findQualifiedById(PageData pd) throws Exception;
	public void saveQ(PageData sm)throws Exception;
	/**
	 * 删除
	 */
	public void deleteQ(PageData pd)throws Exception;
	public void editQ(PageData sm)throws Exception;
	public List<Qualified> qualifiedBySId(PageData pd)throws Exception;
}
