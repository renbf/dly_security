package com.project.security.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;
import java.util.Date;

/**
 * 消息表 t_message
 * 
 * @author rbf
 * @date 2019-04-24
 */
public class TMessage implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 消息名称 */
	private String title;
	/** 消息内容 */
	private String context;
	/** 链接url */
	private String linkUrl;
	/** logo链接url */
	private String logoUrl;
	/** 消息类型 */
	private String messageType;
	/** 创建人id */
	private String addUserId;
	/** 创建时间 */
	private Date createDate;
	/** 修改时间 */
	private Date updateDate;
	/** 修改人id */
	private String updateUserId;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setContext(String context) 
	{
		this.context = context;
	}

	public String getContext() 
	{
		return context;
	}
	public void setLinkUrl(String linkUrl) 
	{
		this.linkUrl = linkUrl;
	}

	public String getLinkUrl() 
	{
		return linkUrl;
	}
	public void setLogoUrl(String logoUrl) 
	{
		this.logoUrl = logoUrl;
	}

	public String getLogoUrl() 
	{
		return logoUrl;
	}
	public void setMessageType(String messageType) 
	{
		this.messageType = messageType;
	}

	public String getMessageType() 
	{
		return messageType;
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
            .append("title", getTitle())
            .append("context", getContext())
            .append("linkUrl", getLinkUrl())
            .append("logoUrl", getLogoUrl())
            .append("messageType", getMessageType())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
