package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityExtractProjectMapper;
import com.fh.lw.mapper.ActivityFillInItemMapper;
import com.fh.lw.pojo.yixunlian.TdActivityFillInItem;
import com.fh.lw.pojo.yixunlian.TdExtractproject;
import com.fh.lw.service.BaseService;

@Service
public class ActivityFillInItemService extends BaseService<TdActivityFillInItem>{
	 @Autowired
	  private ActivityFillInItemMapper mapper;
}
