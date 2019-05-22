package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.alibaba.fastjson.JSON;
import com.project.common.base.BaseEntity;

import springfox.documentation.spring.web.json.Json;

import java.util.Date;
import java.util.List;

/**
 * 题库表 t_subject
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TSubject extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 题库ID */
	private String id;
	/** 题目 */
	private String subject;
	/** 注释 */
	private String annotation;
	/** 选择类型  0:单选  1:多选   2:判断 */
	private String subjectType;
	/** 题库类型 */
	private String itemType;
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
	/** 创建时间 */
	private Date createDateEnd;
	/** 修改时间 */
	private Date updateDate;
	/** 修改人id */
	private String updateUserId;
	//所有选择的拼接字段
	private String allOption;
	private List<TSubjectOption> subList;

    private String[] array;
	private String subListDetail;
	
	//本道题的分值
	private String subjectScore;
	//本道题的排序
	private String subjectSort;
	//试卷id
	private String paperId;
	
	




	public String getSubjectScore() {
		return subjectScore;
	}

	public void setSubjectScore(String subjectScore) {
		this.subjectScore = subjectScore;
	}

	public String getSubjectSort() {
		return subjectSort;
	}

	public void setSubjectSort(String subjectSort) {
		this.subjectSort = subjectSort;
	}

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getSubListDetail() {
		return subListDetail;
	}

	public void setSubListDetail(String subListDetail) {
		this.subListDetail = subListDetail;
	}

	public String[] getIds() {
		return array;
	}

	public void setIds(String[] ids) {
		this.array = ids;
	}

	public Date getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public String getAllOption() {
		return allOption;
	}

	public void setAllOption(String allOption) {
		this.allOption = allOption;
	}


	
	
	
	public List<TSubjectOption> getSubList() {
		return subList;
	}

	public void setSubList(List<TSubjectOption> subList) {
		this.subList = subList;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

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
