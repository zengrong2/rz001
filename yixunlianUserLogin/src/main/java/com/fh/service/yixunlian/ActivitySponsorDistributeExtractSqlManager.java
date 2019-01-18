package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdActivitySponsorDistributeExtract;

public interface ActivitySponsorDistributeExtractSqlManager {

	List<TdActivitySponsorDistributeExtract> getAllTdActivitySponsorDistributeExtract(Page page) throws Exception;

}
