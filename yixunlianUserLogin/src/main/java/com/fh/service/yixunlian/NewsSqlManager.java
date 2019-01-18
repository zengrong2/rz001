package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdJournalism;

public interface NewsSqlManager {

	List<TdJournalism> getAllTdJournalism(Page page) throws Exception;

}
