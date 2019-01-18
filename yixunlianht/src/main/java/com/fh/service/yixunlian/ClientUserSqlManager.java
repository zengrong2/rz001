package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.util.PageData;

public interface ClientUserSqlManager {

	List<PageData> getAllTdUser(Page page) throws Exception;

	List<PageData> getDiamondCustomerManagerStatistics(Page page) throws Exception;

	List<PageData> getVipCustomerManagerStatistics(Page page) throws Exception;

	List<PageData> getVipTryCustomerManagerStatistics(Page page) throws Exception;

	List<PageData> getVipExperienceCustomerManagerStatistics(Page page) throws Exception;

	List<PageData> getCustomerManagerStatistics(Page page) throws Exception;

	List<PageData> getCustomerStatistics(Page page) throws Exception;

}
