package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdBackgroundTransferRecordout;

public interface BackgroundTransferRecordoutSqlManager {

	List<TdBackgroundTransferRecordout> getAllTdBackgroundTransferRecordout(Page page) throws Exception;

}
