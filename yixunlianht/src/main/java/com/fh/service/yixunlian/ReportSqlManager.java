package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdReport;
import com.fh.util.PageData;

public interface ReportSqlManager {

	List<PageData> getAllTdReport(Page page) throws Exception;

}
