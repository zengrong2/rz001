package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdBackgroundTransferRecordinput;

public interface BackgroundTransferRecordinputSqlManager {

	List<TdBackgroundTransferRecordinput> getAllTdBackgroundTransferRecordinput(Page page) throws Exception;

}
