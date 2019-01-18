package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.MemberUpdateExtractMapper;
import com.fh.lw.mapper.NewsMapper;
import com.fh.lw.pojo.yixunlian.TdJournalism;
import com.fh.lw.pojo.yixunlian.TdMemberUpdateExtract;
import com.fh.lw.service.BaseService;

@Service
public class MemberUpdateExtractService extends BaseService<TdMemberUpdateExtract> {
	 @Autowired
	 private MemberUpdateExtractMapper mapper;
}
