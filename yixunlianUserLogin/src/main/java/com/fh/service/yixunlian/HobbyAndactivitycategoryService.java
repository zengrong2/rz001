package com.fh.service.yixunlian;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityTypeMapper;
import com.fh.lw.mapper.HobbyAndactivitycategoryMapper;
import com.fh.lw.pojo.yixunlian.TdHobbyAndactivitycategory;
import com.fh.lw.pojo.yixunlian.TdUhobby;
import com.fh.lw.service.BaseService;
@Service
public class HobbyAndactivitycategoryService extends BaseService<TdHobbyAndactivitycategory>{
	  @Autowired
	  private HobbyAndactivitycategoryMapper mapper;

	 /* public void saveAllHobby(String activitycategory_IDS,String hobbyId,String hobbyAndActivitycategoryId) {
			// TODO Auto-generated method stub
			String ArrayActivitycategory_IDS[] = activitycategory_IDS.split(",");
			ArrayList<Object> list = new ArrayList<Object>();
			for(int i=0;i<ArrayActivitycategory_IDS.length;i++) {
				String  a = ArrayActivitycategory_IDS[i];
				list.add(a);
				TdHobbyAndactivitycategory hobbyAndactivitycategory = new TdHobbyAndactivitycategory();
				hobbyAndactivitycategory.setUhobbyAndActivitycategoryId(this.get32UUID());
				hobbyAndactivitycategory.setHobbyId(hobbyId);
				hobbyAndactivitycategory.setActivitycategoryId(ArrayActivitycategory_IDS[i]);
				super.saveSelective(hobbyAndactivitycategory);
			}
			TdUhobby tdUhobby = new TdUhobby(); 
			System.out.println("fanhui"+list.size());
		
			super.deleteByIds((Class<TdUhobby>) tdUhobby.getClass(), "fhlogId", list);
		}*/
}
