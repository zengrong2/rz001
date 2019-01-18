package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdOrganizerInfo;
import com.fh.util.PageData;

public interface OrganizerInfoSqlManager {

	List<PageData> getAllTdlistOrganizerInfo(Page page) throws Exception;

}
