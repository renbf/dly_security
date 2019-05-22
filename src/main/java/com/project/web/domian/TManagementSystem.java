package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 管理制度表 t_management_system
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TManagementSystem extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 制度名称 */
	private String managementName;
	/** 制度类型 */
	private String managementType;
	/** 颁发单位 */
	private String managementUnit;
	/** 实时日期 */
	private Date managementDate;
	/** 实时日期字符串 */
	private String managementDateStr;
	/** 适用部门 */
	private Long managementDeptId;
	/** 是否适用 1:适用 0:不适用 */
	private String isApply;
	/** 文件路径 */
	private String managementFilePath;
	/** 创建日期 */
	private Date createTime;
	/** 创建日期 */
	private Date createTimeEnd;
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
	private String deptName;
	

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	
	public String getManagementDateStr() {
		return managementDateStr;
	}

	public void setManagementDateStr(String managementDateStr) {
		this.managementDateStr = managementDateStr;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public void setManagementName(String managementName) 
	{
		this.managementName = managementName;
	}

	public String getManagementName() 
	{
		return managementName;
	}
	public void setManagementType(String managementType) 
	{
		this.managementType = managementType;
	}

	public String getManagementType() 
	{
		return managementType;
	}
	public void setManagementUnit(String managementUnit) 
	{
		this.managementUnit = managementUnit;
	}

	public String getManagementUnit() 
	{
		return managementUnit;
	}
	public void setManagementDate(Date managementDate) 
	{
		this.managementDate = managementDate;
	}

	public Date getManagementDate() 
	{
		return managementDate;
	}

	public Long getManagementDeptId() {
		return managementDeptId;
	}

	public void setManagementDeptId(Long managementDeptId) {
		this.managementDeptId = managementDeptId;
	}

	public void setIsApply(String isApply) 
	{
		this.isApply = isApply;
	}

	public String getIsApply() 
	{
		return isApply;
	}
	public void setManagementFilePath(String managementFilePath) 
	{
		this.managementFilePath = managementFilePath;
	}

	public String getManagementFilePath() 
	{
		return managementFilePath;
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
            .append("managementName", getManagementName())
            .append("managementType", getManagementType())
            .append("managementUnit", getManagementUnit())
            .append("managementDate", getManagementDate())
            .append("managementDeptId", getManagementDeptId())
            .append("isApply", getIsApply())
            .append("managementFilePath", getManagementFilePath())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
