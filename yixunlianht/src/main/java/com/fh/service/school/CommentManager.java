package com.fh.service.school;

import java.util.List;
import com.fh.entity.Page;
import com.fh.util.PageData;

public interface CommentManager {
	public List<PageData> listAllComment(Page page)throws Exception;
	public  PageData findCommentById(PageData pd) throws Exception;
	public void editC(PageData sm)throws Exception;
}
