package com.fh.service.yixunlian;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMusicMapper;
import com.fh.lw.mapper.ComplaintMapper;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdComplaint;
import com.fh.lw.pojo.yixunlian.TdReport;
import com.fh.lw.service.BaseService;

@Service
public class ComplaintService extends BaseService<TdComplaint>{
	 @Autowired
	  private ComplaintMapper mapper;

	public void deleteComplaintById(String complaint_id) {
		// TODO Auto-generated method stub
		TdComplaint tdComplaint = new TdComplaint();
		tdComplaint.setComplaintId(complaint_id);
		super.deleteByWhere(tdComplaint);
		
	}

	public void delAllTdComplaint(String complaint_IDS) {
		// TODO Auto-generated method stub
		String complaint_IDSs[] = complaint_IDS.split(",");
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i=0;i<complaint_IDSs.length;i++) {
			list.add(complaint_IDSs[i]);
		}
		//propety是实体字段
		TdComplaint tdComplaint = new TdComplaint(); 
		super.deleteByIds((Class<TdComplaint>) tdComplaint.getClass(), "complaintId", list);

	}

	
	public void updateComplaintState(String complaintId, Integer isExamines) {
		// TODO Auto-generated method stub
		TdComplaint tdComplaint  = new TdComplaint();
		tdComplaint.setComplaintId(complaintId);
		if(isExamines==0) {
			tdComplaint.setIsExamine(1);			
		}
		super.updateSelective(tdComplaint);
	}
}
