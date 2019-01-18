package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.util.PageData;

public interface ActivitySqlManager {

	List<PageData> getAllTdActivity(Page page) throws Exception;

	List<PageData> getOrganizerInfoPublistActivity(Page page) throws Exception;

	void deleteActivity(String[] arrayActivity_IDS) throws Exception;

}
