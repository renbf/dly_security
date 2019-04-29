package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 检查计划表 t_check_plan
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TCheckPlan extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 标题 */
	private String planTitle;
	/** 检查类型 */
	private String checkType;
	/** 年度 */
	private String checkYear;
	/** 部门id */
	private String deptId;
	/** 计划检查时间 */
	private Date palnCheckDate;
	/** 计划检查时间(查询结束时间) */
	private Date palnCheckDateEnd;
	
	/** 计划检查时间字符串 */
	private String palnCheckDateStr;
	/** 责任人user_id */
	private Long personLiableId;
	/** 责任人名称 */
	private String personLiableName;
	/** 检查项目 */
	private String checkTeam;
	/** 状态 0：待接收 1:已接收 2:已整改 3:拒绝 */
	private String checkStatus;
	/** 备注 */
	private String remark;
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
	
	
	public Date getPalnCheckDateEnd() {
		return palnCheckDateEnd;
	}

	public void setPalnCheckDateEnd(Date palnCheckDateEnd) {
		this.palnCheckDateEnd = palnCheckDateEnd;
	}



	public String getPalnCheckDateStr() {
		return palnCheckDateStr;
	}

	public void setPalnCheckDateStr(String palnCheckDateStr) {
		this.palnCheckDateStr = palnCheckDateStr;
	}

	public void setPlanTitle(String planTitle) 
	{
		this.planTitle = planTitle;
	}

	public String getPlanTitle() 
	{
		return planTitle;
	}
	public void setCheckType(String checkType) 
	{
		this.checkType = checkType;
	}

	public String getCheckType() 
	{
		return checkType;
	}
	public void setCheckYear(String checkYear) 
	{
		this.checkYear = checkYear;
	}

	public String getCheckYear() 
	{
		return checkYear;
	}
	public void setDeptId(String deptId) 
	{
		this.deptId = deptId;
	}

	public String getDeptId() 
	{
		return deptId;
	}
	public void setPalnCheckDate(Date palnCheckDate) 
	{
		this.palnCheckDate = palnCheckDate;
	}

	public Date getPalnCheckDate() 
	{
		return palnCheckDate;
	}
	public void setPersonLiableId(Long personLiableId) 
	{
		this.personLiableId = personLiableId;
	}

	public Long getPersonLiableId() 
	{
		return personLiableId;
	}
	public void setPersonLiableName(String personLiableName) 
	{
		this.personLiableName = personLiableName;
	}

	public String getPersonLiableName() 
	{
		return personLiableName;
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
            .append("planTitle", getPlanTitle())
            .append("checkType", getCheckType())
            .append("checkYear", getCheckYear())
            .append("deptId", getDeptId())
            .append("palnCheckDate", getPalnCheckDate())
            .append("personLiableId", getPersonLiableId())
            .append("personLiableName", getPersonLiableName())
            .append("checkTeam", getCheckTeam())
            .append("checkStatus", getCheckStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}

