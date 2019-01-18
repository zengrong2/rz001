package com.fh.lw.pojo.school;

import javax.persistence.Id;
import javax.persistence.Table;
import com.fh.lw.pojo.BasePojo;

@Table(name="tb_school")
public class School extends BasePojo{
	@Id
	private Long schoolId;
	private String name;//学校名称
	private String minImg;//学校小图
	private String saddress;//学校详细地址
	private String stype;//学校类型，例:财经类等
    private String principal;//校长
    private String attribute;//属性,例:211/985
    private String type;//类型：公立/私立
    private Integer majorNum;//专业数量
    private String score;//评分
    private Integer totalScore;//总分
    private Integer num;//评论次数
    private String profile;//学校简介
    private String details;//其他详情
    private String picture;//轮播图
    private String lng;//经度
    private String lat;//纬度
    private String createTime;//创建时间
    private String updateTime;//更新时间
    private String grade;//学校等级,例:本科，大专
    private Integer followNum;//关注次数
    private String province;//省
    private String city;//市
    private String area;//区
    private Integer enrollCost;//报名费
    private Integer probationDay;//试读天数
    private String userId;//管理员id
    private String isCheck;//审核:0-待审核，1-已审核
    private String phone;//学校电话
    private String school_phone;
    private Integer is_promotion;//是否为学历提升学校
    public Integer getIs_promotion() {
		return is_promotion;
	}
	public void setIs_promotion(Integer is_promotion) {
		this.is_promotion = is_promotion;
	}
	public Integer getFollow_num() {
		return follow_num;
	}
	public void setFollow_num(Integer follow_num) {
		this.follow_num = follow_num;
	}
	public Integer getCollection() {
		return collection;
	}
	public void setCollection(Integer collection) {
		this.collection = collection;
	}
	public String getIntroducte() {
		return introducte;
	}
	public void setIntroducte(String introducte) {
		this.introducte = introducte;
	}
	public Integer getW_id() {
		return w_id;
	}
	public void setW_id(Integer w_id) {
		this.w_id = w_id;
	}
	public String getAdapt_people() {
		return adapt_people;
	}
	public void setAdapt_people(String adapt_people) {
		this.adapt_people = adapt_people;
	}
	public String getIs_distribution_work() {
		return is_distribution_work;
	}
	public void setIs_distribution_work(String is_distribution_work) {
		this.is_distribution_work = is_distribution_work;
	}
	public String getEmployment_salary() {
		return employment_salary;
	}
	public void setEmployment_salary(String employment_salary) {
		this.employment_salary = employment_salary;
	}
	private Integer follow_num;
    private Integer collection;
    private String introducte;
    private Integer w_id;
    private String adapt_people;
    private String is_distribution_work;
    private String employment_salary;
   

	public String getSchool_phone() {
		return school_phone;
	}
	public void setSchool_phone(String school_phone) {
		this.school_phone = school_phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIsCheck() {
	return isCheck;
    }
   public void setIsCheck(String isCheck) {
	this.isCheck = isCheck;
    }
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getProbationDay() {
		return probationDay;
	}
	public void setProbationDay(Integer probationDay) {
		this.probationDay = probationDay;
	}
	public Integer getEnrollCost() {
		return enrollCost;
	}
	public void setEnrollCost(Integer enrollCost) {
		this.enrollCost = enrollCost;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getFollowNum() {
		return followNum;
	}
	public void setFollowNum(Integer followNum) {
		this.followNum = followNum;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMinImg() {
		return minImg;
	}
	public void setMinImg(String minImg) {
		this.minImg = minImg;
	}
	
	
	
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getMajorNum() {
		return majorNum;
	}
	public void setMajorNum(Integer majorNum) {
		this.majorNum = majorNum;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
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
