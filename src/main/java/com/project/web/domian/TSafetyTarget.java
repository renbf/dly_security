package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 安全目标表 t_safety_target
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TSafetyTarget extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 目标名称 */
	private String targetName;
	/** 目标日期 */
	private Date targetDate;
	/** 目标制定人 */
	private String targetEnactingPerson;
	/** 部门id */
	private Long orgId;
	/** 状态 0:正常  1:已作废 */
	private Integer targetStatus;
	/** 附件文件路径 */
	private String targetFilePath;
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
	public void setTargetName(String targetName) 
	{
		this.targetName = targetName;
	}

	public String getTargetName() 
	{
		return targetName;
	}
	public void setTargetDate(Date targetDate) 
	{
		this.targetDate = targetDate;
	}

	public Date getTargetDate() 
	{
		return targetDate;
	}
	public void setTargetEnactingPerson(String targetEnactingPerson) 
	{
		this.targetEnactingPerson = targetEnactingPerson;
	}

	public String getTargetEnactingPerson() 
	{
		return targetEnactingPerson;
	}
	public void setOrgId(Long orgId) 
	{
		this.orgId = orgId;
	}

	public Long getOrgId() 
	{
		return orgId;
	}
	public void setTargetStatus(Integer targetStatus) 
	{
		this.targetStatus = targetStatus;
	}

	public Integer getTargetStatus() 
	{
		return targetStatus;
	}
	public void setTargetFilePath(String targetFilePath) 
	{
		this.targetFilePath = targetFilePath;
	}

	public String getTargetFilePath() 
	{
		return targetFilePath;
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
            .append("targetName", getTargetName())
            .append("targetDate", getTargetDate())
            .append("targetEnactingPerson", getTargetEnactingPerson())
            .append("orgId", getOrgId())
            .append("targetStatus", getTargetStatus())
            .append("targetFilePath", getTargetFilePath())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
