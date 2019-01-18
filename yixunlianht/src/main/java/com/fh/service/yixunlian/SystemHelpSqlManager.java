package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdSystemHelp;

public interface SystemHelpSqlManager {

	List<TdSystemHelp> getAllTdSystemHelp(Page page) throws Exception;

}
