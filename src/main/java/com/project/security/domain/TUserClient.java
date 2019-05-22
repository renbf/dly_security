package com.project.security.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;

/**
 * 用户和设备关系表 t_user_client
 * 
 * @author rbf
 * @date 2019-05-10
 */
public class TUserClient implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 用户ID */
	private Long userId;
	/** 设备唯一标识 */
	private String clientId;
	/** 来源1:ios,0:android */
	private String source;

	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setClientId(String clientId) 
	{
		this.clientId = clientId;
	}

	public String getClientId() 
	{
		return clientId;
	}
	public void setSource(String source) 
	{
		this.source = source;
	}

	public String getSource() 
	{
		return source;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("clientId", getClientId())
            .append("source", getSource())
            .toString();
    }
}
