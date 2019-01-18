package com.fh.service.student;

import java.util.List;
import com.fh.entity.Page;
import com.fh.util.PageData;

public interface OpinionManager {
	public List<PageData> listAllOpinion(Page page)throws Exception;
	public  PageData findOpinionById(PageData pd) throws Exception;
}
