package com.fh.service.yixunlian;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.entity.Page;
import com.fh.lw.mapper.ActivityMapper;
import com.fh.lw.mapper.ActivityProjectAndEnrollMapper;
import com.fh.lw.mapper.ClientUserMapper;
import com.fh.lw.pojo.yixunlian.TdActivity;
import com.fh.lw.pojo.yixunlian.TdUenrollandactivity;
import com.fh.lw.pojo.yixunlian.TdUser;
import com.fh.lw.pojo.yixunlian.TdUserCount;
import com.fh.lw.pojo.yixunlian.TdUtype;
import com.fh.lw.service.BaseService;
import com.fh.util.PageData;
import com.github.abel533.entity.Example;
@Service
public class ClientUserService extends BaseService<TdUser>{
	 @Autowired
	  private ClientUserMapper mapper;
	 //报名列表
	 @Autowired
	  private ActivityProjectAndEnrollMapper activityProjectAndEnrollMapper;
	//会员类型通用service
		@Autowired
		private MemberTypeService memberTypeservice;

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
		 TdUser isAllActiveTdUser = new TdUser();
		 Example exampleAllActive= new Example(isAllActiveTdUser.getClass());
		 List<Object> listIsActivation = new ArrayList<>(); 
		 listIsActivation.add(1);
		 listIsActivation.add(2);
		 exampleAllActive.createCriteria().andIn("userIsactivation", listIsActivation);
		 int  memberCount =  mapper.selectCountByExample(exampleAllActive);
		 //未激活用户人数
		 Example example = new Example(tdUser.getClass());
		 example.createCriteria().andEqualTo("userIsactivation", 1);
		 int notActiveCount  = mapper.selectCountByExample(example);
		  //初级会员人数（即普通用户）
		 TdUser tdUser2 = new TdUser();
		 Example example2 = new Example(tdUser2.getClass());
		 example2.createCriteria().andEqualTo("utypeId", "1");
		  int primaryCount  = mapper.selectCountByExample(example2);
		//普通客户经理
		  TdUser tdUser3 = new TdUser();
		  Example example3 = new Example(tdUser3.getClass());
			 example3.createCriteria().andEqualTo("utypeId", "2");
		  int customerManagerCount  = mapper.selectCountByExample(example3);
		 
		  //Vip体验人数
		  TdUser tdUser4 = new TdUser();
		  Example example4 = new Example(tdUser4.getClass());
			 example4.createCriteria().andEqualTo("utypeId", "4");
		  int VIPExperienceCount  = mapper.selectCountByExample(example4);
		//Vip试用人数
		  TdUser tdUser5 = new TdUser();
		  Example example5 = new Example(tdUser5.getClass());
			 example5.createCriteria().andEqualTo("utypeId", "5");
		  int VIPTryCount  = mapper.selectCountByExample(example5);
		//Vip客户经理
		  TdUser tdUser6 = new TdUser();
		  Example example6 = new Example(tdUser6.getClass());
			 example6.createCriteria().andEqualTo("utypeId", "3");
		  int vipcustomerManagerCount  = mapper.selectCountByExample(example6);
		
		  //钻石客户经理
		  TdUser tdUser7 = new TdUser();
		  Example example7 = new Example(tdUser7.getClass());
			 example7.createCriteria().andEqualTo("utypeId", "6");
		  int diamondsCustomerManagerCount  = mapper.selectCountByExample(example7);
		
		  // 未参加应用培训 activityProjectAndEnrollMapper,1先找到报名该活动类别的人，2筛查除去普通用户以外的用户
		  /*List<TdUser> listTdUsers = new ArrayList<>();*/
		  int countNotJoinIsSpecialActivitytypeUser = 0;
		  List<Object> listTdUserId = new ArrayList<>();
			
			 TdUenrollandactivity tdUenrollandactivity = new TdUenrollandactivity();
			 Example  example8 = new Example(tdUenrollandactivity.getClass());
			 example8.createCriteria().andEqualTo("activitycategoryId", "9bbada2bd61041f1ac54fff6d464e6f3");
			 List<TdUenrollandactivity> listTdUenrollandactivity = activityProjectAndEnrollMapper.selectByExample(example8);
			 for (TdUenrollandactivity tdUenrollandactivity2 : listTdUenrollandactivity) {
				TdUser getTdUser = this.mapper.selectByPrimaryKey(tdUenrollandactivity2.getUserId());
				if(getTdUser!=null) {
					if(!"".equals(getTdUser.getUtypeId())&&getTdUser.getUtypeId()!=null) {					
						if((Integer.parseInt(getTdUser.getUtypeId()))>1) {						
							listTdUserId.add(getTdUser.getUserId());
						}
					}
				}
			 }
		 
		   List<Object> list = new ArrayList<>();
			 for (int i = 2; i <=6; i++) {
				 list.add(i);
			}
			 
		  if(listTdUserId.size()>0) {
		     TdUser specialtTdUser = new TdUser();
			 Example specialExample = new Example(specialtTdUser.getClass());
			 specialExample.createCriteria().andNotIn("userId", listTdUserId).andIn("utypeId", list);
/*		     List<TdUser> 	 notJoinSpecialListTdUsers = this.mapper.selectByExample(specialExample);
*/		     countNotJoinIsSpecialActivitytypeUser = this.mapper.selectCountByExample(specialExample);
		    
		  }else {
			     TdUser specialtTdUser = new TdUser();
				 Example specialExample = new Example(specialtTdUser.getClass());
				 specialExample.createCriteria().andIn("utypeId", list);
/*			     List<TdUser> 	 notJoinSpecialListTdUsers = this.mapper.selectByExample(specialExample);
*/			     countNotJoinIsSpecialActivitytypeUser = this.mapper.selectCountByExample(specialExample);
			    
		  }
		  //临时存放统计数据对象
		  TdUserCount tdUserCount = new TdUserCount();
		  tdUserCount.setCustomerManagerCount(customerManagerCount);
		  tdUserCount.setDiamondsCustomerManagerCount(diamondsCustomerManagerCount);
		  tdUserCount.setMemberCount(memberCount);
		  tdUserCount.setNotActiveCount(notActiveCount);
		  tdUserCount.setPrimaryCount(primaryCount);
		  tdUserCount.setVipcusManagerCount(vipcustomerManagerCount);
		 
		  tdUserCount.setVIPExperienceCount(VIPExperienceCount);
		  tdUserCount.setVIPTryCount(VIPTryCount);
		  tdUserCount.setCountNotJoinIsSpecialActivitytypeUser(countNotJoinIsSpecialActivitytypeUser);
			 
		return tdUserCount;
	}

	public int getAllCustomerCountByYear(String startYears, String endYears) {
		// TODO Auto-generated method stub
		 TdUser tdUser = new TdUser();
		 Example  example = new Example(tdUser.getClass());
		 List<Object> listIsActivation = new ArrayList<>(); 
		 listIsActivation.add(1);
		 listIsActivation.add(2);		
		 example.createCriteria().andIn("userIsactivation", listIsActivation).andBetween("created", startYears, endYears);
		 int  allTdUserCount =  mapper.selectCountByExample(example);
		return allTdUserCount;
	}

	public int getAllNotActiveCustomerCountByYear(String startYears, String endYears) {
		// TODO Auto-generated method stub
		TdUser tdUser = new TdUser();
		Example  example = new Example(tdUser.getClass());//
		example.createCriteria().andEqualTo("userIsactivation", 1).andBetween("created", startYears, endYears);
		int allNotActiveTdUserCount = mapper.selectCountByExample(example);
		return allNotActiveTdUserCount;
	}

	public int getAlldiamondCustomerCountByDay(String curDate, String nextDate) {
		// TODO Auto-generated method stub
		TdUser tdUser = new TdUser();
		Example  example = new Example(tdUser.getClass());
		example.createCriteria().andEqualTo("utypeId", 6).andBetween("created", curDate, nextDate);
		int allDiamondCustomerCountByDay = mapper.selectCountByExample(example);
		return allDiamondCustomerCountByDay;
		
	}

	public int getAllVipCustomerCountByDay(String curDate, String nextDate) {
		// TODO Auto-generated method stub
		TdUser tdUser = new TdUser();
		Example  example = new Example(tdUser.getClass());
		example.createCriteria().andEqualTo("utypeId", 3).andBetween("created", curDate, nextDate);
		int allVipExperienceCustomerCountByDay = mapper.selectCountByExample(example);
		return allVipExperienceCustomerCountByDay;
	}

	public int getClientUserService(String curDate, String nextDate) {
		// TODO Auto-generated method stub
		TdUser tdUser = new TdUser();
		Example  example = new Example(tdUser.getClass());
		 List<Object> listIsActivation = new ArrayList<>(); 
		 listIsActivation.add(1);
		 listIsActivation.add(2);
		example.createCriteria().andIn("userIsactivation", listIsActivation).andBetween("created", curDate, nextDate);
		int allClientUserCountByDay = mapper.selectCountByExample(example);
		return allClientUserCountByDay;
	}

	public int getAllVipExperienceCustomerCountByDay(String curDate, String nextDate) {
		// TODO Auto-generated method stub
		TdUser tdUser = new TdUser();
		Example  example = new Example(tdUser.getClass());
		example.createCriteria().andEqualTo("utypeId",4 ).andBetween("created", curDate, nextDate);
		int allClientUserCountByDay = mapper.selectCountByExample(example);
		return allClientUserCountByDay;
	}

	public int getAllVipTryCustomerCountByDay(String curDate, String nextDate) {
		// TODO Auto-generated method stub
		TdUser tdUser = new TdUser();
		Example  example = new Example(tdUser.getClass());
		example.createCriteria().andEqualTo("utypeId",5 ).andBetween("created", curDate, nextDate);
		int allClientUserCountByDay = mapper.selectCountByExample(example);
		return allClientUserCountByDay;
	}

	public int getAllCustomerManagerCountByDay(String curDate, String nextDate) {
		// TODO Auto-generated method stub
		TdUser tdUser = new TdUser();
		Example  example = new Example(tdUser.getClass());
		example.createCriteria().andEqualTo("utypeId",2 ).andBetween("created", curDate, nextDate);
		int allClientUserCountByDay = mapper.selectCountByExample(example);
		return allClientUserCountByDay;
	}

	public int getAllOrdinaryUserCountByDay(String curDate, String nextDate) {
		// TODO Auto-generated method stub
		TdUser tdUser = new TdUser();
		Example  example = new Example(tdUser.getClass());
		example.createCriteria().andEqualTo("utypeId",1).andBetween("created", curDate, nextDate);
		int allClientUserCountByDay = mapper.selectCountByExample(example);
		return allClientUserCountByDay;
	}

	public int getAllNotActivityUserCountByDay(String curDate, String nextDate) {
		// TODO Auto-generated method stub
		TdUser tdUser = new TdUser();
		Example  example = new Example(tdUser.getClass());
		example.createCriteria().andEqualTo("userIsactivation", 1).andBetween("created", curDate, nextDate);
		int allClientUserCountByDay = mapper.selectCountByExample(example);
		return allClientUserCountByDay;
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
//判断是否参加应用培训
	public int getIsJoinTrain(String userId) {
		// TODO Auto-generated method stub
		 int isCount = 0; 
		 TdUser tdUser = this.mapper.selectByPrimaryKey(userId);
		 if(tdUser!=null) {
			 
			 if(!"".equals(tdUser.getUtypeId())&&tdUser.getUtypeId()!=null) {
				 if(Integer.parseInt(tdUser.getUtypeId())>1) {
					 TdUenrollandactivity tdUenrollandactivity = new TdUenrollandactivity();
					 Example  example = new Example(tdUenrollandactivity.getClass());
					 example.createCriteria().andEqualTo("activitycategoryId", "9bbada2bd61041f1ac54fff6d464e6f3").andEqualTo("userId", userId);
					 if(activityProjectAndEnrollMapper.selectCountByExample(example)>0) {
						 //参加
						 isCount = 2;
					 }else {
						 //未参加
						 isCount = 1;
					 }
					 
				 }
				 
			 }
			 
		 }
		 
		 
		return isCount;
	}
//会员资源的人数
	public int getCountResousep(String user_id) {
		// TODO Auto-generated method stub
		int countResousep = 0;
		TdUser tdUser = this.mapper.selectByPrimaryKey(user_id);
		if(tdUser!=null) {
			if(Integer.parseInt(tdUser.getUtypeId())>1) {
				TdUser finalTdUser = new TdUser();
				Example example = new Example(finalTdUser.getClass());
				List<Object> list = new ArrayList<>();
				List<TdUtype> listTdUtype = memberTypeservice.queryAll();
				for (int i = 1; i <=listTdUtype.size(); i++) {
					list.add(i);
				}
				example.createCriteria().andEqualTo("usermanagerUid", user_id).andIn("utypeId", list);
				countResousep = this.mapper.selectCountByExample(example);
			}
		}
		return countResousep;
	}

	


	
}
