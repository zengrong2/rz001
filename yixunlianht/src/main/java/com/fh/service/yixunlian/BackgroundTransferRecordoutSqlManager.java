package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdBackgroundTransferRecordout;
import com.fh.util.PageData;

public interface BackgroundTransferRecordoutSqlManager {

	List<TdBackgroundTransferRecordout> getAllTdBackgroundTransferRecordout(Page page) throws Exception;

	List<PageData> getfinancialBackgroundOutStatistics(Page page) throws Exception;

}
