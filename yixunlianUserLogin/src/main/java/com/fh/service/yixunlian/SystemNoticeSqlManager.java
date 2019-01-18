package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdSystembulletinNotice;

public interface SystemNoticeSqlManager {

	List<TdSystembulletinNotice> getAllTdSystembulletinNotice(Page page) throws Exception;

}
