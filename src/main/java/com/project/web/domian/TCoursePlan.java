package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;
import java.util.Date;

/**
 * 课程计划表 t_course_plan
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TCoursePlan extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 年份 */
	private String planYear;
	/** 标题 */
	private String title;
	/** 部门id */
	private Long deptId;
	/** 级别类型 */
	private String levelType;
	/** 计划课时 */
	private String classHour;
	/** 附件url */
	private String attachmentUrl;
	/** 创建人id */
	private String addUserId;
	/** 创建时间 */
	private Date createDate;
	/** 创建时间 */
	private Date createDateEnd;
	/** 修改时间 */
	private Date updateDate;
	/** 修改人id */
	private String updateUserId;
	//课程类型 1:线上  0:线下
	private String courseType;
	//企业id
	private String businessId;
	
	
	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public Date getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setPlanYear(String planYear) 
	{
		this.planYear = planYear;
	}

	public String getPlanYear() 
	{
		return planYear;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	
	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public void setLevelType(String levelType) 
	{
		this.levelType = levelType;
	}

	public String getLevelType() 
	{
		return levelType;
	}
	public void setClassHour(String classHour) 
	{
		this.classHour = classHour;
	}

	public String getClassHour() 
	{
		return classHour;
	}
	public void setAttachmentUrl(String attachmentUrl) 
	{
		this.attachmentUrl = attachmentUrl;
	}

	public String getAttachmentUrl() 
	{
		return attachmentUrl;
	}
	public void setAddUserId(String addUserId) 
	{
		this.addUserId = addUserId;
	}

	public String getAddUserId() 
	{
		return addUserId;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("planYear", getPlanYear())
            .append("title", getTitle())
            .append("deptId", getDeptId())
            .append("levelType", getLevelType())
            .append("classHour", getClassHour())
            .append("attachmentUrl", getAttachmentUrl())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
