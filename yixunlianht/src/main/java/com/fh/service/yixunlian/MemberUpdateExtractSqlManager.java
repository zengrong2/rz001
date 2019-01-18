package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdMemberUpdateExtract;

public interface MemberUpdateExtractSqlManager {

	List<TdMemberUpdateExtract> getAllTdlistMemberUpdateExtract(Page page) throws Exception;

}
