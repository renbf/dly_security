package com.project.security.domain.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户考试安排表 t_user_paper
 * 
 * @author rbf
 * @date 2019-04-16
 */
public class TUserPaperVo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 用户ID */
	private String userId;
	/** 考卷ID */
	private String paperId;
	/** 考试开始日期 */
	private Date beginDate;
	/** 考试结束日期 */
	private Date endDate;
	/** 状态0未答题，1已答题 */
	private String status;
	/** 考试分数 */
	private Integer paperScore;
	/** 答题开始时间 */
	private Date startDate;
	/** 交卷时间时间 */
	private Date commitDate;
	/** 发布人id */
	private String addUserId;
	/** 发布时间 */
	private Date createDate;
	/** 修改时间 */
	private Date updateDate;
	/** 修改人id */
	private String updateUserId;
	/** 考卷名称 */
	private String paperName;
	/** 考试剩余时长 */
	private Long remainingTime;
	/** 考卷时间 */
	private Integer paperTimes;
	/** 考卷的考题 */
	private List<UserPaperDetailVo> examQuestions;
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
	public void setPaperId(String paperId) 
	{
		this.paperId = paperId;
	}

	public String getPaperId() 
	{
		return paperId;
	}
	public void setBeginDate(Date beginDate) 
	{
		this.beginDate = beginDate;
	}

	public Date getBeginDate() 
	{
		return beginDate;
	}
	public void setEndDate(Date endDate) 
	{
		this.endDate = endDate;
	}

	public Date getEndDate() 
	{
		return endDate;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setPaperScore(Integer paperScore) 
	{
		this.paperScore = paperScore;
	}

	public Integer getPaperScore() 
	{
		return paperScore;
	}
	public void setStartDate(Date startDate) 
	{
		this.startDate = startDate;
	}

	public Date getStartDate() 
	{
		return startDate;
	}
	public void setCommitDate(Date commitDate) 
	{
		this.commitDate = commitDate;
	}

	public Date getCommitDate() 
	{
		return commitDate;
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

    public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public Long getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(Long remainingTime) {
		this.remainingTime = remainingTime;
	}

	public List<UserPaperDetailVo> getExamQuestions() {
		return examQuestions;
	}

	public void setExamQuestions(List<UserPaperDetailVo> examQuestions) {
		this.examQuestions = examQuestions;
	}

	public Integer getPaperTimes() {
		return paperTimes;
	}

	public void setPaperTimes(Integer paperTimes) {
		this.paperTimes = paperTimes;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("paperId", getPaperId())
            .append("beginDate", getBeginDate())
            .append("endDate", getEndDate())
            .append("status", getStatus())
            .append("paperScore", getPaperScore())
            .append("startDate", getStartDate())
            .append("commitDate", getCommitDate())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .append("paperName", getPaperName())
            .append("remainingTime", getRemainingTime())
            .toString();
    }
}
