package com.project.security.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;
import java.util.Date;

/**
 * 课程安排表 t_user_course
 * 
 * @author rbf
 * @date 2019-04-22
 */
public class TUserCourse implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 用户ID */
	private String userId;
	/** 开始时间 */
	private Date startDate;
	/** 课程id */
	private String courseId;
	/** 级别类型 */
	private String levelType;
	/** 学习状态0未学习1学习中2已完成 */
	private String status;
	/** 课时（秒） */
	private Long classHour;
	/** 已观看秒数 */
	private Long progress;
	/** 是否收藏1是0否 */
	private String isCollect;
	/** 发布人id */
	private String addUserId;
	/** 发布日期 */
	private Date publishDate;
	/** 修改时间 */
	private Date updateDate;
	/** 修改人id */
	private String updateUserId;
	/** 累计观看时长 */
	private Long lookTime;
	/** 观看开始时间 */
	private Date lookStartTime;
	/** 观看结束时间 */
	private Date lookEndTime;
	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}

	public String getUserId() 
	{
		return userId;
	}
	public void setStartDate(Date startDate) 
	{
		this.startDate = startDate;
	}

	public Date getStartDate() 
	{
		return startDate;
	}
	public void setCourseId(String courseId) 
	{
		this.courseId = courseId;
	}

	public String getCourseId() 
	{
		return courseId;
	}
	public void setLevelType(String levelType) 
	{
		this.levelType = levelType;
	}

	public String getLevelType() 
	{
		return levelType;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setClassHour(Long classHour) 
	{
		this.classHour = classHour;
	}

	public Long getClassHour() 
	{
		return classHour;
	}
	public void setProgress(Long progress) 
	{
		this.progress = progress;
	}

	public Long getProgress() 
	{
		return progress;
	}
	public void setIsCollect(String isCollect) 
	{
		this.isCollect = isCollect;
	}

	public String getIsCollect() 
	{
		return isCollect;
	}
	public void setAddUserId(String addUserId) 
	{
		this.addUserId = addUserId;
	}

	public String getAddUserId() 
	{
		return addUserId;
	}
	public void setPublishDate(Date publishDate) 
	{
		this.publishDate = publishDate;
	}

	public Date getPublishDate() 
	{
		return publishDate;
	}
	public void setUpdateDate(Date updateDate) 
	{
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() 
	{
		return updateDate;
	}
	public void setUpdateUserId(String updateUserId) 
	{
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserId() 
	{
		return updateUserId;
	}

    public Long getLookTime() {
		return lookTime;
	}

	public void setLookTime(Long lookTime) {
		this.lookTime = lookTime;
	}

	public Date getLookStartTime() {
		return lookStartTime;
	}

	public void setLookStartTime(Date lookStartTime) {
		this.lookStartTime = lookStartTime;
	}

	public Date getLookEndTime() {
		return lookEndTime;
	}

	public void setLookEndTime(Date lookEndTime) {
		this.lookEndTime = lookEndTime;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("startDate", getStartDate())
            .append("courseId", getCourseId())
            .append("levelType", getLevelType())
            .append("status", getStatus())
            .append("classHour", getClassHour())
            .append("progress", getProgress())
            .append("isCollect", getIsCollect())
            .append("addUserId", getAddUserId())
            .append("publishDate", getPublishDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
