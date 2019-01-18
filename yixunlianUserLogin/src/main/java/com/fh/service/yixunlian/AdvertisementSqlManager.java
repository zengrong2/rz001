package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdAdvertisementimage;

public interface AdvertisementSqlManager {

	List<TdAdvertisementimage> getAllTdAdvertisement(Page page) throws Exception;

}
