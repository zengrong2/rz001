package com.fh.service.school;

import com.fh.lw.pojo.school.Platform;
import com.fh.util.PageData;

public interface PlatformManager {
	public PageData listPlatform(PageData pd) throws Exception;
	public void editP(PageData pd) throws Exception;
}
