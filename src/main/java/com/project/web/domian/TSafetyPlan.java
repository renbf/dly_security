package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 安全计划表 t_safety_plan
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TSafetyPlan extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 计划名称 */
	private String palnName;
	/** 计划日期 */
	private Date planDate;
	/** 计划制定人 */
	private String planEnactingPerson;
	/** 部门id */
	private String deptId;
	/** 状态 0:正常  1:已作废 */
	private Integer planStatus;
	/** 附件文件路径 */
	private String planFilePath;
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
	public void setPalnName(String palnName) 
	{
		this.palnName = palnName;
	}

	public String getPalnName() 
	{
		return palnName;
	}
	public void setPlanDate(Date planDate) 
	{
		this.planDate = planDate;
	}

	public Date getPlanDate() 
	{
		return planDate;
	}
	public void setPlanEnactingPerson(String planEnactingPerson) 
	{
		this.planEnactingPerson = planEnactingPerson;
	}

	public String getPlanEnactingPerson() 
	{
		return planEnactingPerson;
	}
	public void setDeptId(String deptId) 
	{
		this.deptId = deptId;
	}

	public String getDeptId() 
	{
		return deptId;
	}
	public void setPlanStatus(Integer planStatus) 
	{
		this.planStatus = planStatus;
	}

	public Integer getPlanStatus() 
	{
		return planStatus;
	}
	public void setPlanFilePath(String planFilePath) 
	{
		this.planFilePath = planFilePath;
	}

	public String getPlanFilePath() 
	{
		return planFilePath;
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
            .append("palnName", getPalnName())
            .append("planDate", getPlanDate())
            .append("planEnactingPerson", getPlanEnactingPerson())
            .append("deptId", getDeptId())
            .append("planStatus", getPlanStatus())
            .append("planFilePath", getPlanFilePath())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
