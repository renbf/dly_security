package com.project.security.domain.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private String businessType;
	/** 专业类型 */
	@JsonIgnore
	private String majorType;
	/** 正确答案 */
	private String trueAnswer;
	/** 题库来源 */
	@JsonIgnore
	private String subjectSource;
	/** 企业ID */
	@JsonIgnore
	private String businessId;
	/** 创建人id */
	@JsonIgnore
	private String addUserId;
	/** 创建时间 */
	@JsonIgnore
	private Date createDate;
	/** 修改时间 */
	@JsonIgnore
	private Date updateDate;
	/** 修改人id */
	@JsonIgnore
	private String updateUserId;
	/** 题目选项 */
	@JsonIgnore
	private String optionValue;
	/** 题目内容 */
	@JsonIgnore
	private String content;
	/** 题目顺序 */
	@JsonIgnore
	private Integer optionSort;
	/** 题目选项信息 */
	private List<Map<String,Object>> optionContents;
	/** 是否收藏 */
	private String isCollect;
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

	public List<Map<String, Object>> getOptionContents() {
		return optionContents;
	}

	public void setOptionContents(List<Map<String, Object>> optionContents) {
		this.optionContents = optionContents;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getOptionSort() {
		return optionSort;
	}

	public void setOptionSort(Integer optionSort) {
		this.optionSort = optionSort;
	}

	public String getIsCollect() {
		return isCollect;
	}

	public void setIsCollect(String isCollect) {
		this.isCollect = isCollect;
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
