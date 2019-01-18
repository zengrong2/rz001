package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.SystembulletinMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdSystembulletin;
import com.fh.lw.service.BaseService;

@Service
public class SystembulletinService  extends BaseService<TdSystembulletin>{
	 @Autowired
	  private SystembulletinMapper mapper;
}
