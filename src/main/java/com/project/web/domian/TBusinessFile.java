package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 企业文件表 t_business_file
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TBusinessFile extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 文件名称 */
	private String businessFileName;
	/** 文号 */
	private String businessFileCode;
	/** 类型 */
	private String businessFileType;
	/** 实施日期 */
	private Date businessFileDate;
	/** 实施日期字符串 */
	private String businessFileStr;
	/** 实施日期 */
	private Date businessFileDateEnd;
	/** 适用部门 */
	private String operatingDeptId;
	/** 是否适用 1:适用 0:不适用 */
	private String isApply;
	/** 文件路径 */
	private String businessFilePath;
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
	
	public String getBusinessFileStr() {
		return businessFileStr;
	}

	public void setBusinessFileStr(String businessFileStr) {
		this.businessFileStr = businessFileStr;
	}

	public Date getBusinessFileDateEnd() {
		return businessFileDateEnd;
	}

	public void setBusinessFileDateEnd(Date businessFileDateEnd) {
		this.businessFileDateEnd = businessFileDateEnd;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public void setBusinessFileName(String businessFileName) 
	{
		this.businessFileName = businessFileName;
	}

	public String getBusinessFileName() 
	{
		return businessFileName;
	}
	public void setBusinessFileCode(String businessFileCode) 
	{
		this.businessFileCode = businessFileCode;
	}

	public String getBusinessFileCode() 
	{
		return businessFileCode;
	}
	public void setBusinessFileType(String businessFileType) 
	{
		this.businessFileType = businessFileType;
	}

	public String getBusinessFileType() 
	{
		return businessFileType;
	}
	public void setBusinessFileDate(Date businessFileDate) 
	{
		this.businessFileDate = businessFileDate;
	}

	public Date getBusinessFileDate() 
	{
		return businessFileDate;
	}
	public void setOperatingDeptId(String operatingDeptId) 
	{
		this.operatingDeptId = operatingDeptId;
	}

	public String getOperatingDeptId() 
	{
		return operatingDeptId;
	}
	public void setIsApply(String isApply) 
	{
		this.isApply = isApply;
	}

	public String getIsApply() 
	{
		return isApply;
	}
	public void setBusinessFilePath(String businessFilePath) 
	{
		this.businessFilePath = businessFilePath;
	}

	public String getBusinessFilePath() 
	{
		return businessFilePath;
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
            .append("businessFileName", getBusinessFileName())
            .append("businessFileCode", getBusinessFileCode())
            .append("businessFileType", getBusinessFileType())
            .append("businessFileDate", getBusinessFileDate())
            .append("operatingDeptId", getOperatingDeptId())
            .append("isApply", getIsApply())
            .append("businessFilePath", getBusinessFilePath())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
