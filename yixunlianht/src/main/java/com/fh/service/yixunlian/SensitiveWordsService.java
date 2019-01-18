package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.SensitiveWordsMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdSensitiveWords;
import com.fh.lw.service.BaseService;

@Service
public class SensitiveWordsService extends BaseService<TdSensitiveWords>{
	 @Autowired
	 private SensitiveWordsMapper mapper;
}
