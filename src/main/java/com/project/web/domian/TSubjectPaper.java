package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;

/**
 * 考卷题目关系表 t_subject_paper
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TSubjectPaper extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 考卷ID */
	private String paperId;
	/** 题库ID */
	private String subjectId;
	/** 题目分数 */
	private Double subjectScore;
	/** 顺序 */
	private Integer subjectSort;
	
	private String oldSubjectId;
	
	

	public String getOldSubjectId() {
		return oldSubjectId;
	}

	public void setOldSubjectId(String oldSubjectId) {
		this.oldSubjectId = oldSubjectId;
	}

	public void setPaperId(String paperId) 
	{
		this.paperId = paperId;
	}

	public String getPaperId() 
	{
		return paperId;
	}
	public void setSubjectId(String subjectId) 
	{
		this.subjectId = subjectId;
	}

	public String getSubjectId() 
	{
		return subjectId;
	}

	public Double getSubjectScore() {
		return subjectScore;
	}

	public void setSubjectScore(Double subjectScore) {
		this.subjectScore = subjectScore;
	}

	public void setSubjectSort(Integer subjectSort) 
	{
		this.subjectSort = subjectSort;
	}

	public Integer getSubjectSort() 
	{
		return subjectSort;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("paperId", getPaperId())
            .append("subjectId", getSubjectId())
            .append("subjectScore", getSubjectScore())
            .append("subjectSort", getSubjectSort())
            .toString();
    }
}
