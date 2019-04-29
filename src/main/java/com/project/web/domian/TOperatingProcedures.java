package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 操作规程表 t_operating_procedures
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TOperatingProcedures extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 操作规程名称 */
	private String operatingName;
	/** 颁发单位 */
	private String operatingUnit;
	/** 实施日期 */
	private Date operatingDate;
	/** 实施日期 */
	private Date operatingDateEnd;
	/** 实施日期字符串 */
	private String operatingDateStr;
	/** 适用部门 */
	private Long operatingDeptId;
	/** 是否适用 1:适用 0:不适用 */
	private String isApply;
	/** 文件路径 */
	private String operatingFilePath;
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

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public Date getOperatingDateEnd() {
		return operatingDateEnd;
	}

	public void setOperatingDateEnd(Date operatingDateEnd) {
		this.operatingDateEnd = operatingDateEnd;
	}

	public String getOperatingDateStr() {
		return operatingDateStr;
	}

	public void setOperatingDateStr(String operatingDateStr) {
		this.operatingDateStr = operatingDateStr;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public void setOperatingName(String operatingName) 
	{
		this.operatingName = operatingName;
	}

	public String getOperatingName() 
	{
		return operatingName;
	}
	public void setOperatingUnit(String operatingUnit) 
	{
		this.operatingUnit = operatingUnit;
	}

	public String getOperatingUnit() 
	{
		return operatingUnit;
	}
	public void setOperatingDate(Date operatingDate) 
	{
		this.operatingDate = operatingDate;
	}

	public Date getOperatingDate() 
	{
		return operatingDate;
	}

	public Long getOperatingDeptId() {
		return operatingDeptId;
	}

	public void setOperatingDeptId(Long operatingDeptId) {
		this.operatingDeptId = operatingDeptId;
	}

	public void setIsApply(String isApply) 
	{
		this.isApply = isApply;
	}

	public String getIsApply() 
	{
		return isApply;
	}
	public void setOperatingFilePath(String operatingFilePath) 
	{
		this.operatingFilePath = operatingFilePath;
	}

	public String getOperatingFilePath() 
	{
		return operatingFilePath;
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
            .append("operatingName", getOperatingName())
            .append("operatingUnit", getOperatingUnit())
            .append("operatingDate", getOperatingDate())
            .append("operatingDeptId", getOperatingDeptId())
            .append("isApply", getIsApply())
            .append("operatingFilePath", getOperatingFilePath())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
