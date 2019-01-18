package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityExtractProjectMapper;
import com.fh.lw.mapper.ActivityProjectMapper;
import com.fh.lw.pojo.yixunlian.TdActivityChargeItem;
import com.fh.lw.pojo.yixunlian.TdExtractproject;
import com.fh.lw.service.BaseService;

@Service
public class ActivityExtractProjectService extends BaseService<TdExtractproject>{
	 @Autowired
	  private ActivityExtractProjectMapper mapper;
}
