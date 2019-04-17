package com.project.security.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户收藏记录表 t_user_subject_collect
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TUserSubjectCollect implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 用户ID */
	private String userId;
	/** 题库ID */
	private String subjectId;
	/** 是否收藏本题1是0否 */
	private String isCollect;

	public void setUserId(String userId) 
	{
		this.userId = userId;
	}

	public String getUserId() 
	{
		return userId;
	}
	public void setSubjectId(String subjectId) 
	{
		this.subjectId = subjectId;
	}

	public String getSubjectId() 
	{
		return subjectId;
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
            .append("userId", getUserId())
            .append("subjectId", getSubjectId())
            .append("isCollect", getIsCollect())
            .toString();
    }
}
