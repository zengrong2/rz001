package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdBackgroundTransferRecordinput;
import com.fh.util.PageData;

public interface BackgroundTransferRecordinputSqlManager {

	List<TdBackgroundTransferRecordinput> getAllTdBackgroundTransferRecordinput(Page page) throws Exception;

	List<PageData> getfinancialBackgroundInputStatistics(Page page) throws Exception;

}
