package com.fh.lw.pojo.school;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.entity.Page;
import com.fh.lw.pojo.BasePojo;
/**
 * 学校专业
 * @author a55660000
 *
 */
@Table(name="tb_school_major")
public class SchoolMajor extends BasePojo{
	@Id
	private Long majorId;
	private Long schoolId;//学校Id
	private String majorName;//专业名称
	private String subjectType;//学科分类
	private String twoType;//二级分类
	private Long typeId;//专业id
	private String schoolName;//学校名称
	private String createTime;
	private String updateTime;
	private Integer money;//就读费用
	private String year;//就读年限
	private String reamrk;//专业备注
	private String zsdx;//招生对象
	private Page page;
	
	public String getZsdx() {
		return zsdx;
	}
	public void setZsdx(String zsdx) {
		this.zsdx = zsdx;
	}
	public String getReamrk() {
		return reamrk;
	}
	public void setReamrk(String reamrk) {
		this.reamrk = reamrk;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Long getMajorId() {
		return majorId;
	}
	public void setMajorId(Long majorId) {
		this.majorId = majorId;
	}
	public Long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}
	public String getTwoType() {
		return twoType;
	}
	public void setTwoType(String twoType) {
		this.twoType = twoType;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
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
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
    
}
