package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdEngagendustry;

public interface EngageIndustrySqlManager {

	List<TdEngagendustry> getAllTdEngagendustry(Page page) throws Exception;

}
