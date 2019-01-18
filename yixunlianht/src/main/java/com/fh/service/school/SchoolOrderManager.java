package com.fh.service.school;

import java.util.List;
import com.fh.entity.Page;
import com.fh.util.PageData;

public interface SchoolOrderManager {
	public List<PageData> listAllSchoolOrder(Page page)throws Exception;
	public  PageData findSchoolOrderById(PageData pd) throws Exception;
	public void editC(PageData sm)throws Exception;
	public Integer getZjMoney(PageData pd)throws Exception;
}
