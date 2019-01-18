package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMusicMapper;
import com.fh.lw.mapper.OrganizerInfoMapper;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdOrganizerInfo;
import com.fh.lw.service.BaseService;

@Service
public class OrganizerInfoService extends BaseService<TdOrganizerInfo>{
	 @Autowired
	  private OrganizerInfoMapper mapper;
}
