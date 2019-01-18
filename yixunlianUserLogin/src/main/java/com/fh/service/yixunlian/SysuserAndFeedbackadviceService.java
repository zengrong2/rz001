package com.fh.service.yixunlian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.SysuserAndFeedbackadviceMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdSysuserAndFeedbackadvice;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;


@Service
public class SysuserAndFeedbackadviceService extends BaseService<TdSysuserAndFeedbackadvice>{
	 @Autowired
	  private SysuserAndFeedbackadviceMapper mapper;

	public List<TdSysuserAndFeedbackadvice> getSysuserAndFeedbackadvice(String user_id, String feedbackadvice_id) {
		// TODO Auto-generated method stub
		TdSysuserAndFeedbackadvice tdSysuserAndFeedbackadvice = new TdSysuserAndFeedbackadvice();
		
		Example example = new Example(tdSysuserAndFeedbackadvice.getClass());
		example.createCriteria().andEqualTo("userId", user_id).andEqualTo("feedbackadviceId", feedbackadvice_id);
		List<TdSysuserAndFeedbackadvice> listTdSysuserAndFeedbackadvice= mapper.selectByExample(example);
		return listTdSysuserAndFeedbackadvice;
	}
}
