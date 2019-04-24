package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 安全责任表 t_safety_responsibility
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TSafetyResponsibility extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 文件名称 */
	private String responsibilityName;
	/** 日期 */
	private Date responsibilityDate;
	/** 类型 */
	private String responsibilityType;
	/** 部门id */
	private String deptId;
	/** 附件文件路径 */
	private String responsibilityFilePath;
	/** 创建日期 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/** 创建人id */
	private Long userId;
	/** 备用字段 */
	private String meno;
	/** 企业ID */
	private String businessId;
	/** 修改人id */
	private Long updateUserId;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setResponsibilityName(String responsibilityName) 
	{
		this.responsibilityName = responsibilityName;
	}

	public String getResponsibilityName() 
	{
		return responsibilityName;
	}
	public void setResponsibilityDate(Date responsibilityDate) 
	{
		this.responsibilityDate = responsibilityDate;
	}

	public Date getResponsibilityDate() 
	{
		return responsibilityDate;
	}
	public void setResponsibilityType(String responsibilityType) 
	{
		this.responsibilityType = responsibilityType;
	}

	public String getResponsibilityType() 
	{
		return responsibilityType;
	}
	public void setDeptId(String deptId) 
	{
		this.deptId = deptId;
	}

	public String getDeptId() 
	{
		return deptId;
	}
	public void setResponsibilityFilePath(String responsibilityFilePath) 
	{
		this.responsibilityFilePath = responsibilityFilePath;
	}

	public String getResponsibilityFilePath() 
	{
		return responsibilityFilePath;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setMeno(String meno) 
	{
		this.meno = meno;
	}

	public String getMeno() 
	{
		return meno;
	}
	public void setBusinessId(String businessId) 
	{
		this.businessId = businessId;
	}

	public String getBusinessId() 
	{
		return businessId;
	}
	public void setUpdateUserId(Long updateUserId) 
	{
		this.updateUserId = updateUserId;
	}

	public Long getUpdateUserId() 
	{
		return updateUserId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("responsibilityName", getResponsibilityName())
            .append("responsibilityDate", getResponsibilityDate())
            .append("responsibilityType", getResponsibilityType())
            .append("deptId", getDeptId())
            .append("responsibilityFilePath", getResponsibilityFilePath())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
