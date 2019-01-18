package com.fh.lw.pojo.yixunlian;

public class TdUserCount {
    //会员总人数
	private Integer memberCount;
	//未激活用户
	private Integer notActiveCount;
	//初级会员人数（即普通用户）
	private Integer primaryCount;
	//普通客户经理
	private Integer customerManagerCount;
	//Vip体验人数
	private Integer VIPExperienceCount;
	//Vip试用人数
	private Integer VIPTryCount;
	//Vip客户经理VipcustomerManagerCount
	private Integer vipcusManagerCount;
	//未参加应用培训
	private Integer countNotJoinIsSpecialActivitytypeUser;
	
	
	
	public Integer getVipcusManagerCount() {
		return vipcusManagerCount;
	}
	public void setVipcusManagerCount(Integer vipcusManagerCount) {
		this.vipcusManagerCount = vipcusManagerCount;
	}
	//钻石客户经理
	private Integer diamondsCustomerManagerCount;
	public Integer getDiamondsCustomerManagerCount() {
		return diamondsCustomerManagerCount;
	}
	public void setDiamondsCustomerManagerCount(Integer diamondsCustomerManagerCount) {
		this.diamondsCustomerManagerCount = diamondsCustomerManagerCount;
	}
	public Integer getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}
	public Integer getNotActiveCount() {
		return notActiveCount;
	}
	public void setNotActiveCount(Integer notActiveCount) {
		this.notActiveCount = notActiveCount;
	}
	public Integer getPrimaryCount() {
		return primaryCount;
	}
	
	public Integer getCountNotJoinIsSpecialActivitytypeUser() {
		return countNotJoinIsSpecialActivitytypeUser;
	}
	public void setCountNotJoinIsSpecialActivitytypeUser(Integer countNotJoinIsSpecialActivitytypeUser) {
		this.countNotJoinIsSpecialActivitytypeUser = countNotJoinIsSpecialActivitytypeUser;
	}
	public void setPrimaryCount(Integer primaryCount) {
		this.primaryCount = primaryCount;
	}
	public Integer getCustomerManagerCount() {
		return customerManagerCount;
	}
	public void setCustomerManagerCount(Integer customerManagerCount) {
		this.customerManagerCount = customerManagerCount;
	}
	public Integer getVIPExperienceCount() {
		return VIPExperienceCount;
	}
	public void setVIPExperienceCount(Integer vIPExperienceCount) {
		VIPExperienceCount = vIPExperienceCount;
	}
	public Integer getVIPTryCount() {
		return VIPTryCount;
	}
	public void setVIPTryCount(Integer vIPTryCount) {
		VIPTryCount = vIPTryCount;
	}

	
	
}
