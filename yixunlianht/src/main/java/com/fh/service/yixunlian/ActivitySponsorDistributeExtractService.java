package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMusicMapper;
import com.fh.lw.mapper.ActivitySponsorDistributeExtractMapper;
import com.fh.lw.pojo.yixunlian.TdActivitySponsorDistributeExtract;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.service.BaseService;

@Service
public class ActivitySponsorDistributeExtractService extends BaseService<TdActivitySponsorDistributeExtract>{
	@Autowired
	  private ActivitySponsorDistributeExtractMapper mapper;
}
