package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 事故基础表 t_accident_basics
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TAccidentBasics extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 事故名称 */
	private String accidentName;
	/** 事故类型 */
	private String accidentType;
	/** 发生日期 */
	private Date happenTime;
	/** 事故损失 */
	private String accidentLoss;
	/** 责任人 */
	private String accidentResponsibility;
	/** 责任人user_id */
	private Long responsibilityUserId;
	/** 责任部门ID */
	private String responsibilityDeptId;
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
	public void setAccidentName(String accidentName) 
	{
		this.accidentName = accidentName;
	}

	public String getAccidentName() 
	{
		return accidentName;
	}
	public void setAccidentType(String accidentType) 
	{
		this.accidentType = accidentType;
	}

	public String getAccidentType() 
	{
		return accidentType;
	}
	public void setHappenTime(Date happenTime) 
	{
		this.happenTime = happenTime;
	}

	public Date getHappenTime() 
	{
		return happenTime;
	}
	public void setAccidentLoss(String accidentLoss) 
	{
		this.accidentLoss = accidentLoss;
	}

	public String getAccidentLoss() 
	{
		return accidentLoss;
	}
	public void setAccidentResponsibility(String accidentResponsibility) 
	{
		this.accidentResponsibility = accidentResponsibility;
	}

	public String getAccidentResponsibility() 
	{
		return accidentResponsibility;
	}
	public void setResponsibilityUserId(Long responsibilityUserId) 
	{
		this.responsibilityUserId = responsibilityUserId;
	}

	public Long getResponsibilityUserId() 
	{
		return responsibilityUserId;
	}
	public void setResponsibilityDeptId(String responsibilityDeptId) 
	{
		this.responsibilityDeptId = responsibilityDeptId;
	}

	public String getResponsibilityDeptId() 
	{
		return responsibilityDeptId;
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
            .append("accidentName", getAccidentName())
            .append("accidentType", getAccidentType())
            .append("happenTime", getHappenTime())
            .append("accidentLoss", getAccidentLoss())
            .append("accidentResponsibility", getAccidentResponsibility())
            .append("responsibilityUserId", getResponsibilityUserId())
            .append("responsibilityDeptId", getResponsibilityDeptId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
