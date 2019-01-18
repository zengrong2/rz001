package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.AdvertisementMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdAdvertisementimage;
import com.fh.lw.service.BaseService;

@Service
public class AdvertisementService extends BaseService<TdAdvertisementimage>{
	 @Autowired
	 private AdvertisementMapper mapper;
}
