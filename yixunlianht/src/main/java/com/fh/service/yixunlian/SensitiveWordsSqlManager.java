package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdSensitiveWords;

public interface SensitiveWordsSqlManager {

	List<TdSensitiveWords> getAllTdSensitiveWords(Page page) throws Exception;

}
