package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivitycategory;

public interface ActivityTypeSqlManager {

	List<TdActivitycategory> getAllTdActivity(Page page) throws Exception;

}
