package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdFeedbackadvice;

public interface FeedbackadviceSqlManager {

	List<TdFeedbackadvice> getAllTdlistFeedbackadvice(Page page) throws Exception;

}
