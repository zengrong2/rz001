package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdUtype;
import com.fh.util.PageData;

public interface MemberTypeSqlManager {

	List<PageData> getAllTdUtype(Page page) throws Exception;

}
