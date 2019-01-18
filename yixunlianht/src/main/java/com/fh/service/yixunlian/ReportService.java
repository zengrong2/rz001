package com.fh.service.yixunlian;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMusicMapper;
import com.fh.lw.mapper.ReportMapper;
import com.fh.lw.pojo.yixunlian.TdActivitymusicurl;
import com.fh.lw.pojo.yixunlian.TdComplaint;
import com.fh.lw.pojo.yixunlian.TdReport;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;

@Service
public class ReportService extends BaseService<TdReport>{
	 @Autowired
	  private ReportMapper mapper;

	public void deleteReportById(String report_id) {
		// TODO Auto-generated method stub
		TdReport tdReport = new TdReport();
		tdReport.setReportId(report_id);
	
		super.deleteByWhere(tdReport);
	}

	public void delAllTdReport(String report_IDS) {
		// TODO Auto-generated method stub
		String report_IDSs[] = report_IDS.split(",");
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i=0;i<report_IDSs.length;i++) {
			list.add(report_IDSs[i]);
		}
		//propety是实体字段
		TdReport tdReport = new TdReport(); 
		super.deleteByIds((Class<TdReport>) tdReport.getClass(), "reportId", list);

	}

	public void updateReportState(String reportId, Integer isExamines) {
		// TODO Auto-generated method stub
		TdReport tdReport  = new TdReport();
		tdReport.setReportId(reportId);
		if(isExamines==0) {
			tdReport.setIsExamine(1);			
		}
		super.updateSelective(tdReport);
	}
}
