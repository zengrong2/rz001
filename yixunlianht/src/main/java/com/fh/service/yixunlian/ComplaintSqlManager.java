package com.fh.service.yixunlian;

import java.util.List;

import com.fh.entity.Page;
import com.fh.lw.pojo.yixunlian.TdComplaint;
import com.fh.util.PageData;

public interface ComplaintSqlManager {

	List<PageData> getAllTdComplaint(Page page) throws Exception;

}
