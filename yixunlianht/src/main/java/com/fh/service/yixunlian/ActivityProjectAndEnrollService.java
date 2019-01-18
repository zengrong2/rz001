package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.ActivityProjectAndEnrollMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdUenrollandactivity;
import com.fh.lw.service.BaseService;

@Service
public class ActivityProjectAndEnrollService extends BaseService<TdUenrollandactivity>{
	 @Autowired
	  private ActivityProjectAndEnrollMapper mapper;

}
