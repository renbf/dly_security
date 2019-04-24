package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 安全值班表 t_safety_duty
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TSafetyDuty extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 值班类型 */
	private String dutyType;
	/** 值班人员 */
	private String dutyPerson;
	/** 值班日期 */
	private Date dutyDate;
	/** 登记日期 */
	private Date registerDate;
	/** 记录 */
	private String dutyRecord;
	/** 部门id */
	private String deptId;
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
	public void setDutyType(String dutyType) 
	{
		this.dutyType = dutyType;
	}

	public String getDutyType() 
	{
		return dutyType;
	}
	public void setDutyPerson(String dutyPerson) 
	{
		this.dutyPerson = dutyPerson;
	}

	public String getDutyPerson() 
	{
		return dutyPerson;
	}
	public void setDutyDate(Date dutyDate) 
	{
		this.dutyDate = dutyDate;
	}

	public Date getDutyDate() 
	{
		return dutyDate;
	}
	public void setRegisterDate(Date registerDate) 
	{
		this.registerDate = registerDate;
	}

	public Date getRegisterDate() 
	{
		return registerDate;
	}
	public void setDutyRecord(String dutyRecord) 
	{
		this.dutyRecord = dutyRecord;
	}

	public String getDutyRecord() 
	{
		return dutyRecord;
	}
	public void setDeptId(String deptId) 
	{
		this.deptId = deptId;
	}

	public String getDeptId() 
	{
		return deptId;
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
            .append("dutyType", getDutyType())
            .append("dutyPerson", getDutyPerson())
            .append("dutyDate", getDutyDate())
            .append("registerDate", getRegisterDate())
            .append("dutyRecord", getDutyRecord())
            .append("deptId", getDeptId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
