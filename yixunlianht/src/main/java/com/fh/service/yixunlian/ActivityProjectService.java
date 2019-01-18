package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.ActivityProjectMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdActivityChargeItem;
import com.fh.lw.pojo.yixunlian.TdActivityprojectandacsign;
import com.fh.lw.service.BaseService;

@Service
public class ActivityProjectService extends BaseService<TdActivityChargeItem>{
	 @Autowired
	  private ActivityProjectMapper mapper;
}
