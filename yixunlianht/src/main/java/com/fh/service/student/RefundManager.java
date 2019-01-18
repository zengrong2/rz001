package com.fh.service.student;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.student.Refund;
import com.fh.util.PageData;

public interface RefundManager {
	public List<PageData> listAllRefund(Page page)throws Exception;
	public  PageData findRefundById(PageData pd) throws Exception;
	public void editC(PageData pd)throws Exception;

}
