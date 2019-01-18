package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.util.PageData;

public interface ClientUserSqlManager {

	List<PageData> getAllTdUser(Page page) throws Exception;

}
