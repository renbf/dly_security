package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;
import java.util.Date;
import java.util.List;

/**
 * 考卷表 t_paper
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TPaper extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 考卷ID */
	private String id;
	/** 考卷名称 */
	private String name;
	/** 考卷时间 */
	private Integer paperTimes;
	/** 考卷类型 */
	private String paperType;
	/** 题目数量 */
	private Integer subjectNums;
	/** 企业类型 */
	private String businessType;
	/** 专业类型 */
	private String majorType;
	/** 考卷金额 */
	private Long paperPrice;
	/** 及格分数 */
	private Integer passScore;
	/** 考卷来源 */
	private String paperSource;
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
	
	/**
	 * 题库ID集合
	 */
	private List<TSubjectPaper> tSubList;
	/**
	 * 题集合
	 */
	private List<TSubject> subJectList;


	public List<TSubjectPaper> gettSubList() {
		return tSubList;
	}

	public void settSubList(List<TSubjectPaper> tSubList) {
		this.tSubList = tSubList;
	}

	public List<TSubject> getSubJectList() {
		return subJectList;
	}

	public void setSubJectList(List<TSubject> subJectList) {
		this.subJectList = subJectList;
	}

	public Date getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setPaperTimes(Integer paperTimes) 
	{
		this.paperTimes = paperTimes;
	}

	public Integer getPaperTimes() 
	{
		return paperTimes;
	}
	public void setPaperType(String paperType) 
	{
		this.paperType = paperType;
	}

	public String getPaperType() 
	{
		return paperType;
	}
	public void setSubjectNums(Integer subjectNums) 
	{
		this.subjectNums = subjectNums;
	}

	public Integer getSubjectNums() 
	{
		return subjectNums;
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
	public void setPaperPrice(Long paperPrice) 
	{
		this.paperPrice = paperPrice;
	}

	public Long getPaperPrice() 
	{
		return paperPrice;
	}
	public void setPassScore(Integer passScore) 
	{
		this.passScore = passScore;
	}

	public Integer getPassScore() 
	{
		return passScore;
	}
	public void setPaperSource(String paperSource) 
	{
		this.paperSource = paperSource;
	}

	public String getPaperSource() 
	{
		return paperSource;
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
            .append("name", getName())
            .append("paperTimes", getPaperTimes())
            .append("paperType", getPaperType())
            .append("subjectNums", getSubjectNums())
            .append("businessType", getBusinessType())
            .append("majorType", getMajorType())
            .append("paperPrice", getPaperPrice())
            .append("passScore", getPassScore())
            .append("paperSource", getPaperSource())
            .append("businessId", getBusinessId())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
