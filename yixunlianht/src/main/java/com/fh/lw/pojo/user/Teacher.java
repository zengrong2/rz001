package com.fh.lw.pojo.user;

import java.util.List;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fh.lw.pojo.BasePojo;

/**
 * 招生老师
 * @author a55660000
 *
 */
@Table(name="tb_teacher")
public class Teacher extends BasePojo{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
 private Long tid;
 private String name;//姓名
 private String phone;//电话
 private String password;//密码
 private String headPortrait;//头像路径
 private Integer balance;//余额*100
 private Integer income;//总收入*100
 private Integer type;//类型1-一级招生，2-二级招生
 private Integer commission;//提成
 private Long pid;//上级id
 private String createTime;
 private String updateTime;
 private String sharingCode;//分享二维码
 private String remark;//备注
 private String ywyid;//业务员id
 private String address;//地址
 private String ywyphone;//业务员电话
 private String workunit;//工作单位
 private Integer num;
 //新+结算
 private Integer totalCommissionMoney;
 public Integer getTotalCommissionMoney() {
	return totalCommissionMoney;
}
public void setTotalCommissionMoney(Integer totalCommissionMoney) {
	this.totalCommissionMoney = totalCommissionMoney;
}
//新加积分
 private int integral;



public int getIntegral() {
	return integral;
}
public void setIntegral(int integral) {
	this.integral = integral;
}
@Transient
 private String URL;//未使用
 @Transient
 private List<Teacher> subType;//递归显示使用
 
public Integer getNum() {
	return num;
}
public void setNum(Integer num) {
	this.num = num;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public String getYwyid() {
	return ywyid;
}
public void setYwyid(String ywyid) {
	this.ywyid = ywyid;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getYwyphone() {
	return ywyphone;
}
public void setYwyphone(String ywyphone) {
	this.ywyphone = ywyphone;
}
public String getWorkunit() {
	return workunit;
}
public void setWorkunit(String workunit) {
	this.workunit = workunit;
}
public String getURL() {
	return URL;
}
public void setURL(String uRL) {
	URL = uRL;
}
public List<Teacher> getSubType() {
	return subType;
}
public void setSubType(List<Teacher> subType) {
	this.subType = subType;
}
public String getSharingCode() {
	return sharingCode;
}
public void setSharingCode(String sharingCode) {
	this.sharingCode = sharingCode;
}
public Long getTid() {
	return tid;
}
public void setTid(Long tid) {
	this.tid = tid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getHeadPortrait() {
	return headPortrait;
}
public void setHeadPortrait(String headPortrait) {
	this.headPortrait = headPortrait;
}
public Integer getBalance() {
	return balance;
}
public void setBalance(Integer balance) {
	this.balance = balance;
}
public Integer getIncome() {
	return income;
}
public void setIncome(Integer income) {
	this.income = income;
}
public Integer getType() {
	return type;
}
public void setType(Integer type) {
	this.type = type;
}
public Integer getCommission() {
	return commission;
}
public void setCommission(Integer commission) {
	this.commission = commission;
}
public Long getPid() {
	return pid;
}
public void setPid(Long pid) {
	this.pid = pid;
}
public String getCreateTime() {
	return createTime;
}
public void setCreateTime(String createTime) {
	this.createTime = createTime;
}
public String getUpdateTime() {
	return updateTime;
}
public void setUpdateTime(String updateTime) {
	this.updateTime = updateTime;
}
 
}
