package com.project.security.domain.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 课程安排表 t_user_course
 * 
 * @author rbf
 * @date 2019-04-16
 */
public class TUserCourseVo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 用户ID */
	private String userId;
	/** 用户名称 */
	private String userName;
	/** 部门ID */
	private Long deptId;
	/** 部门名称 */
	private String deptName;
	/** 已观看秒数 */
	@JsonIgnore
	private Long progress;
	/** 已观看总秒数 */
	@JsonIgnore
	private Long proSum;
	/** 排名 */
	private Integer rank;
	/** 观看课时 */
	private BigDecimal classHour;
	/** 观看总课时 */
	private BigDecimal classHourSum;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Long getProgress() {
		return progress;
	}
	public void setProgress(Long progress) {
		this.progress = progress;
	}
	public Long getProSum() {
		return proSum;
	}
	public void setProSum(Long proSum) {
		this.proSum = proSum;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public BigDecimal getClassHour() {
		return classHour;
	}
	public void setClassHour(BigDecimal classHour) {
		this.classHour = classHour;
	}
	public BigDecimal getClassHourSum() {
		return classHourSum;
	}
	public void setClassHourSum(BigDecimal classHourSum) {
		this.classHourSum = classHourSum;
	}
	
	
}
