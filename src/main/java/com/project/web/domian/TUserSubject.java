package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;

/**
 * 用户答题记录表 t_user_subject
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TUserSubject extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 用户考卷ID */
	private String userPaperId;
	/** 题库ID */
	private String subjectId;
	/** 用户答案 */
	private String userAnswer;
	/** 是否答对0否1是 */
	private String isTrue;
	/** 是否收藏本题1是0否 */
	private String isCollect;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setUserPaperId(String userPaperId) 
	{
		this.userPaperId = userPaperId;
	}

	public String getUserPaperId() 
	{
		return userPaperId;
	}
	public void setSubjectId(String subjectId) 
	{
		this.subjectId = subjectId;
	}

	public String getSubjectId() 
	{
		return subjectId;
	}
	public void setUserAnswer(String userAnswer) 
	{
		this.userAnswer = userAnswer;
	}

	public String getUserAnswer() 
	{
		return userAnswer;
	}
	public void setIsTrue(String isTrue) 
	{
		this.isTrue = isTrue;
	}

	public String getIsTrue() 
	{
		return isTrue;
	}
	public void setIsCollect(String isCollect) 
	{
		this.isCollect = isCollect;
	}

	public String getIsCollect() 
	{
		return isCollect;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userPaperId", getUserPaperId())
            .append("subjectId", getSubjectId())
            .append("userAnswer", getUserAnswer())
            .append("isTrue", getIsTrue())
            .append("isCollect", getIsCollect())
            .toString();
    }
}
