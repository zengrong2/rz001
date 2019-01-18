package com.fh.lw.pojo.student;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fh.lw.pojo.BasePojo;

/**
 * 投诉建议
 * @author a55660000
 *
 */

@Table(name="tb_opinion")
public class Opinion extends BasePojo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long opinionId;
	private String userId;//用户id
	private String content;//内容
    private String createTime;//创建时间
	public Long getOpinionId() {
		return opinionId;
	}
	public void setOpinionId(Long opinionId) {
		this.opinionId = opinionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
    
}
