package com.project.security.domain.vo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 题库表 t_subject
 * 
 * @author rbf
 * @date 2019-04-16
 */
public class TSubjectVo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 题库ID */
	private String id;
	/** 题目 */
	private String subject;
	/** 注释 */
	private String annotation;
	/** 题目类型 */
	private String subjectType;
	/** 企业类型 */
	private String businessType;
	/** 专业类型 */
	private String majorType;
	/** 正确答案 */
	private String trueAnswer;
	/** 题库来源 */
	private String subjectSource;
	/** 企业ID */
	private String businessId;
	/** 创建人id */
	private String addUserId;
	/** 创建时间 */
	private Date createDate;
	/** 修改时间 */
	private Date updateDate;
	/** 修改人id */
	private String updateUserId;
	/** 选项s */
	private String contents;
	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setSubject(String subject) 
	{
		this.subject = subject;
	}

	public String getSubject() 
	{
		return subject;
	}
	public void setAnnotation(String annotation) 
	{
		this.annotation = annotation;
	}

	public String getAnnotation() 
	{
		return annotation;
	}
	public void setSubjectType(String subjectType) 
	{
		this.subjectType = subjectType;
	}

	public String getSubjectType() 
	{
		return subjectType;
	}
	public void setBusinessType(String businessType) 
	{
		this.businessType = businessType;
	}

	public String getBusinessType() 
	{
		return businessType;
	}
	public void setMajorType(String majorType) 
	{
		this.majorType = majorType;
	}

	public String getMajorType() 
	{
		return majorType;
	}
	public void setTrueAnswer(String trueAnswer) 
	{
		this.trueAnswer = trueAnswer;
	}

	public String getTrueAnswer() 
	{
		return trueAnswer;
	}
	public void setSubjectSource(String subjectSource) 
	{
		this.subjectSource = subjectSource;
	}

	public String getSubjectSource() 
	{
		return subjectSource;
	}
	public void setBusinessId(String businessId) 
	{
		this.businessId = businessId;
	}

	public String getBusinessId() 
	{
		return businessId;
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

    public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("subject", getSubject())
            .append("annotation", getAnnotation())
            .append("subjectType", getSubjectType())
            .append("businessType", getBusinessType())
            .append("majorType", getMajorType())
            .append("trueAnswer", getTrueAnswer())
            .append("subjectSource", getSubjectSource())
            .append("businessId", getBusinessId())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
