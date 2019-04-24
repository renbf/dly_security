package com.project.security.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * 行业动态表 t_industry_dynamics
 * 
 * @author rbf
 * @date 2019-04-22
 */
public class TIndustryDynamics implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 行业标题 */
	private String title;
	/** 动态内容 */
	private String context;
	/** 详情url */
	private String webUrl;
	/** 上传图片 */
	private String uploadUrl;
	/** 创建人id */
	@JsonIgnore
	private String addUserId;
	/** 创建时间 */
	private Date createDate;
	/** 修改时间 */
	@JsonIgnore
	private Date updateDate;
	/** 修改人id */
	@JsonIgnore
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
	public void setWebUrl(String webUrl) 
	{
		this.webUrl = webUrl;
	}

	public String getWebUrl() 
	{
		return webUrl;
	}
	public void setUploadUrl(String uploadUrl) 
	{
		this.uploadUrl = uploadUrl;
	}

	public String getUploadUrl() 
	{
		return uploadUrl;
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
            .append("webUrl", getWebUrl())
            .append("uploadUrl", getUploadUrl())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
