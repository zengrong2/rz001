package com.fh.service.yixunlian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.ClientUserMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.lw.pojo.yixunlian.TdUserCount;
import com.fh.lw.service.BaseService;
import com.github.abel533.entity.Example;
@Service
public class ClientUserService extends BaseService<TdUser>{
	 @Autowired
	  private ClientUserMapper mapper;

	public void updateActivityState(String user_id, Integer closedUserStatus) {
		// TODO Auto-generated method stub
		TdUser tdUser = new TdUser(); 
		TdUser tdUser2 = super.queryById(user_id);	
		Example example = new Example(tdUser.getClass());
		if(closedUserStatus==0) {
			tdUser2.setClosedUserStatus(1);
			super.updateSelective(tdUser2);
			return ;
		}
		if(closedUserStatus!=0){
			tdUser2.setClosedUserStatus(0);		
			super.updateSelective(tdUser2);
			return ;
		}
	}

	public TdUserCount getTdUserCount() {
		// TODO Auto-generated method stub
		
		 TdUser tdUser = new TdUser();
		
		  //会员总人数
		 int  memberCount =  super.queryTotalCount(tdUser);
		 //未激活用户人数
		 Example example = new Example(tdUser.getClass());
		 example.createCriteria().andNotEqualTo("userIsactivation", 2);
		 int notActiveCount  = mapper.selectCountByExample(example);
		  //初级会员人数（即普通用户）
		 Example example2 = new Example(tdUser.getClass());
		 example2.createCriteria().andEqualTo("utypeId", 1);
		  int primaryCount  = mapper.selectCountByExample(example2);
		//普通客户经理
		  Example example3 = new Example(tdUser.getClass());
			 example3.createCriteria().andEqualTo("utypeId", 2);
		  int customerManagerCount  = mapper.selectCountByExample(example3);
		 
		  //Vip体验人数
		
		  Example example4 = new Example(tdUser.getClass());
			 example4.createCriteria().andEqualTo("utypeId", 4);
		  int VIPExperienceCount  = mapper.selectCountByExample(example4);
		//Vip试用人数
		 
		  Example example5 = new Example(tdUser.getClass());
			 example5.createCriteria().andEqualTo("utypeId", 5);
		  int VIPTryCount  = mapper.selectCountByExample(example5);
		//Vip客户经理
		
		  Example example6 = new Example(tdUser.getClass());
			 example6.createCriteria().andEqualTo("utypeId", 3);
		  int vipcustomerManagerCount  = mapper.selectCountByExample(example6);
		//钻石客户经理
		 
		  Example example7 = new Example(tdUser.getClass());
			 example7.createCriteria().andEqualTo("utypeId", 6);
		  int diamondsCustomerManagerCount  = mapper.selectCountByExample(example7);
		  TdUserCount tdUserCount = new TdUserCount();
		  tdUserCount.setCustomerManagerCount(customerManagerCount);
		  tdUserCount.setDiamondsCustomerManagerCount(diamondsCustomerManagerCount);
		  tdUserCount.setMemberCount(memberCount);
		  tdUserCount.setNotActiveCount(notActiveCount);
		  tdUserCount.setPrimaryCount(primaryCount);
		  tdUserCount.setVipcusManagerCount(vipcustomerManagerCount);
		 
		  tdUserCount.setVIPExperienceCount(VIPExperienceCount);
		  tdUserCount.setVIPTryCount(VIPTryCount);
		  
		return tdUserCount;
	}

	public TdUser getTdUserByAddress(String userId, String address,int type) {
		// TODO Auto-generated method stub
		TdUser tdUser = new TdUser();
		
		if(type==1) {
			tdUser.setUserId(userId);
			tdUser.setAreaCitycode(address);
		}else if(type==2) {
			tdUser.setUserId(userId);
			tdUser.setCityCitycode(address);
		}else if(type==3) {
			tdUser.setUserId(userId);
			tdUser.setProvinceCitycode(address);			
		}
		TdUser finalTdUser=super.queryOne(tdUser);
		return finalTdUser;
	}

	
}
