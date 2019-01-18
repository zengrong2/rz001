package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdUhobby;

public interface HobbySqlManager {

	List<TdUhobby> getAllTdHobby(Page page) throws Exception;

}
