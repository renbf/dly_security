package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 检查计划表 t_inspect_plan
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TInspectPlan extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 标题ID */
	private String titleId;
	/** 标题 */
	private String checkTitle;
	/** 年度 */
	private String checkYear;
	/** 计划检查时间 */
	private Date checkTime;
	/** 检查类型 */
	private String checkType;
	/** 部门 */
	private Long deptId;
	/** 责任人 */
	private String userId;
	/** 检查项目id */
	private String checkTeam;
	/** 检查状态 0未检出 1已完成 2上报了隐患 */
	private String checkStatus;
	/** 企业ID */
	private String businessId;
	/** 备注 */
	private String remark;
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
	public void setTitleId(String titleId) 
	{
		this.titleId = titleId;
	}

	public String getTitleId() 
	{
		return titleId;
	}
	public void setCheckTitle(String checkTitle) 
	{
		this.checkTitle = checkTitle;
	}

	public String getCheckTitle() 
	{
		return checkTitle;
	}
	public void setCheckYear(String checkYear) 
	{
		this.checkYear = checkYear;
	}

	public String getCheckYear() 
	{
		return checkYear;
	}
	public void setCheckTime(Date checkTime) 
	{
		this.checkTime = checkTime;
	}

	public Date getCheckTime() 
	{
		return checkTime;
	}
	public void setCheckType(String checkType) 
	{
		this.checkType = checkType;
	}

	public String getCheckType() 
	{
		return checkType;
	}
	public void setDeptId(Long deptId) 
	{
		this.deptId = deptId;
	}

	public Long getDeptId() 
	{
		return deptId;
	}
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}

	public String getUserId() 
	{
		return userId;
	}
	public void setCheckTeam(String checkTeam) 
	{
		this.checkTeam = checkTeam;
	}

	public String getCheckTeam() 
	{
		return checkTeam;
	}
	public void setCheckStatus(String checkStatus) 
	{
		this.checkStatus = checkStatus;
	}

	public String getCheckStatus() 
	{
		return checkStatus;
	}
	public void setBusinessId(String businessId) 
	{
		this.businessId = businessId;
	}

	public String getBusinessId() 
	{
		return businessId;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
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
            .append("titleId", getTitleId())
            .append("checkTitle", getCheckTitle())
            .append("checkYear", getCheckYear())
            .append("checkTime", getCheckTime())
            .append("checkType", getCheckType())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .append("checkTeam", getCheckTeam())
            .append("checkStatus", getCheckStatus())
            .append("businessId", getBusinessId())
            .append("remark", getRemark())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
