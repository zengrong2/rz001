package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdPartnerBonusTransferRecordinput;
import com.fh.util.PageData;

public interface PartnerBonusTransferRecordinputSqlManager {

	List<TdPartnerBonusTransferRecordinput> getAllTdlistlistPartnerBonusTransferRecordinput(Page page) throws Exception;

	List<PageData> getgetfinancialPartnerBonusInputStatistics(Page page) throws Exception;

}
