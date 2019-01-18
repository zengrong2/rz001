package com.fh.service.system.user;

import java.util.List;

import com.fh.entity.Page;
import com.fh.util.PageData;

public interface CommonProblemManager {
	public List<PageData> problemlistPage(Page page)throws Exception;
	/**
	 * 修改
	 * @param pd
	 * @throws Exception
	 */
	public void editP(PageData pd)throws Exception;
	/**
	 * 新增
	 * @param pd
	 * @throws Exception
	 */
	public void saveP(PageData pd)throws Exception;
	/**
	 * 通过id获取数据
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public PageData getProblemById(PageData pd)throws Exception;
	/**
	 * 删除
	 */
	public void deleteP(PageData pd)throws Exception;
	

}
