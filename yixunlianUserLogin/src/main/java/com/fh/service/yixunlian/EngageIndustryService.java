package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.EngageIndustryMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdEngagendustry;
import com.fh.lw.service.BaseService;

@Service
public class EngageIndustryService extends BaseService<TdEngagendustry>{
	 @Autowired
	  private EngageIndustryMapper mapper;
}
