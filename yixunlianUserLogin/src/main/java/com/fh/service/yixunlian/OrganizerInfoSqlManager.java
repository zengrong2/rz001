package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdOrganizerInfo;

public interface OrganizerInfoSqlManager {

	List<TdOrganizerInfo> getAllTdlistOrganizerInfo(Page page) throws Exception;

}
