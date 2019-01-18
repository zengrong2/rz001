package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.SysFhlog;

public interface SystemLogSqlManager {

	List<SysFhlog> getAllSysFhlog(Page page) throws Exception;

}
