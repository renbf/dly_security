package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 体检记录表 t_physical_examination
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TPhysicalExamination extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 体检时间 */
	private Date physicalDate;
	/** 体检单位 */
	private String physicalUnit;
	/** 疑似病人数 */
	private String suspectedNum;
	/** 文件路径 */
	private String filePath;
	/** 备注(描述) */
	private String remark;
	/** 创建日期 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
	/** 创建人ID */
	private Long userId;
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
	public void setPhysicalDate(Date physicalDate) 
	{
		this.physicalDate = physicalDate;
	}

	public Date getPhysicalDate() 
	{
		return physicalDate;
	}
	public void setPhysicalUnit(String physicalUnit) 
	{
		this.physicalUnit = physicalUnit;
	}

	public String getPhysicalUnit() 
	{
		return physicalUnit;
	}
	public void setSuspectedNum(String suspectedNum) 
	{
		this.suspectedNum = suspectedNum;
	}

	public String getSuspectedNum() 
	{
		return suspectedNum;
	}
	public void setFilePath(String filePath) 
	{
		this.filePath = filePath;
	}

	public String getFilePath() 
	{
		return filePath;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
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
            .append("physicalDate", getPhysicalDate())
            .append("physicalUnit", getPhysicalUnit())
            .append("suspectedNum", getSuspectedNum())
            .append("filePath", getFilePath())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
