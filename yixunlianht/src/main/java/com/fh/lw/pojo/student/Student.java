package com.fh.lw.pojo.student;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;


@Table(name="tb_student")
public class Student extends BasePojo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long userId;
	private String phone;//电话
	private String password;//密码
    private String name;//姓名
    private String card;//身份证号
    private String jhrPhone;//监护人手机
    private String jhrName;//监护人姓名
    private String headPortrait;//头像
    private String studentCard;//学生证号
    private String schoolName;//学校名称
    private String qualifications;//最高学历
    private String createTime;//注册日期
    private String updateTime;//更新日期
    private Integer sex;//性别:1-男，0-女
    private Long inviterId;//邀请人id
    private String txId;//同学id
    private Integer money;//余额
    private String hobby;//爱好
    private String mojar;//专业
    private Integer state;//学生状态 0-未入学，1-已试读，2-已报名，3-已退学
    private Long schoolId;//学校id 
    private String tphone;//招生老师电话
    private String jdtime;//就读时间
    
	public String getJdtime() {
		return jdtime;
	}
	public void setJdtime(String jdtime) {
		this.jdtime = jdtime;
	}
	public String getTphone() {
		return tphone;
	}
	public void setTphone(String tphone) {
		this.tphone = tphone;
	}
	public Long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMojar() {
		return mojar;
	}
	public void setMojar(String mojar) {
		this.mojar = mojar;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public String getTxId() {
		return txId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public Long getInviterId() {
		return inviterId;
	}
	public void setInviterId(Long inviterId) {
		this.inviterId = inviterId;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getJhrPhone() {
		return jhrPhone;
	}
	public void setJhrPhone(String jhrPhone) {
		this.jhrPhone = jhrPhone;
	}
	public String getJhrName() {
		return jhrName;
	}
	public void setJhrName(String jhrName) {
		this.jhrName = jhrName;
	}
	
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public String getStudentCard() {
		return studentCard;
	}
	public void setStudentCard(String studentCard) {
		this.studentCard = studentCard;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	public String getCreatTime() {
		return createTime;
	}
	public void setCreatTime(String creatTime) {
		this.createTime = creatTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
    
}
