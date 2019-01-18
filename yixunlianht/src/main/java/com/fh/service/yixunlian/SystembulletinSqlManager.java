package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdSystembulletin;

public interface SystembulletinSqlManager {

	List<TdSystembulletin> getAllTdSystembulletin(Page page) throws Exception;

}
