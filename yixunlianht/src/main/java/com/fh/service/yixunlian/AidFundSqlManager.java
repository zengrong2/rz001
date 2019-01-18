package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdAidFund;
import com.fh.util.PageData;

public interface AidFundSqlManager {

	List<TdAidFund> getAllTdlistTdAidFund(Page page) throws Exception;

	List<PageData> getfinancialAidFundInputStatistics(Page page) throws Exception;

}
