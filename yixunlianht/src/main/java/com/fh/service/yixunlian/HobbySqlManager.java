package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdUhobby;
import com.fh.util.PageData;

public interface HobbySqlManager {

	List<PageData> getAllTdHobby(Page page) throws Exception;

}
