package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.FeedbackadviceMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdFeedbackadvice;
import com.fh.lw.service.BaseService;

@Service
public class FeedbackadviceService extends BaseService<TdFeedbackadvice>{
	 @Autowired
	  private FeedbackadviceMapper mapper;

	public void deleteFeedbackadviceByAid(String feedbackadvice_id) {
		// TODO Auto-generated method stub
		TdFeedbackadvice tdFeedbackadvice = new TdFeedbackadvice(); 
		
		tdFeedbackadvice.setFeedbackadviceId(feedbackadvice_id);
		super.deleteByWhere(tdFeedbackadvice);
	}
}
