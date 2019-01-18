package com.fh.service.yixunlian;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.SystemLogMapper;
import com.fh.lw.pojo.yixunlian.SysFhlog;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.service.BaseService;

@Service
public class SystemLogService  extends BaseService<SysFhlog>{
	 @Autowired
	 private SystemLogMapper mapper;

	@SuppressWarnings("unchecked")
	public void delAllSystemLog(String systemLog_IDS) {
		// TODO Auto-generated method stub
		String ArraySystemLog_IDS[] = systemLog_IDS.split(",");
		ArrayList<Object> list = new ArrayList<Object>();
		for(int i=0;i<ArraySystemLog_IDS.length;i++) {
			String  a = ArraySystemLog_IDS[i];
			list.add(a);
		}
		SysFhlog sysFhlog = new SysFhlog(); 
		/*System.out.println("fanhui"+list.size());*/
		super.deleteByIds((Class<SysFhlog>) sysFhlog.getClass(), "fhlogId", list);
	}
}
