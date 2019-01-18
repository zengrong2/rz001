package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;

public interface ActivityMusicSqlManager {

	List<TdActivitymusicurl> getAllTdlistActivityMusic(Page page) throws Exception;

}
