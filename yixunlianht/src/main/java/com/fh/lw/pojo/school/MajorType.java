package com.fh.lw.pojo.school;

import java.util.List;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fh.lw.pojo.BasePojo;


/**
 * 专业类型
 * @author a55660000
 *
 */
@Table(name="tb_type")
public class MajorType extends BasePojo {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private Long type_id;
    private String type_name;
    private Long pid;
    private String create_time;
    private String update_time;
    private String img_url;//类别图片
    private Integer type;//等级
    @Transient
    private String target;//链接左右侧页面
    @Transient
    private String URL;//未使用
    @Transient
 	private List<MajorType> subType;//递归显示使用
   
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public List<MajorType> getSubType() {
		return subType;
	}
	public void setSubType(List<MajorType> subType) {
		this.subType = subType;
	}
	
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Long getType_id() {
		return type_id;
	}
	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	
    
}
