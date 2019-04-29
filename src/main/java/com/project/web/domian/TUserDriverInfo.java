package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 驾驶员驾驶表 t_user_driver_info
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TUserDriverInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 对应sys_user表中的user_id值 */
	private Long driverUserId;
	/** 档案编号 */
	private String driverArchives;
	/** 驾驶证号 */
	private String driverLicenseNumber;
	/** 初领日期 */
	private Date initialDate;
	/** 驾龄 */
	private String driverAge;
	/** 证件有效期 */
	private Date certificateValidityPeriod;
	/** 证件有效期 */
	private String certificateStr;
	/** 体检有效期 */
	private Date physicalValidityPeriod;
	/** 准驾车型 */
	private String driverVehicleType;
	/** 年审有效期 */
	private Date annualValidityPeriod;
	/** 违法记分 */
	private String driverIllegalScore;
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
	
	
	public String getCertificateStr() {
		return certificateStr;
	}

	public void setCertificateStr(String certificateStr) {
		this.certificateStr = certificateStr;
	}

	public void setDriverUserId(Long driverUserId) 
	{
		this.driverUserId = driverUserId;
	}

	public Long getDriverUserId() 
	{
		return driverUserId;
	}
	public void setDriverArchives(String driverArchives) 
	{
		this.driverArchives = driverArchives;
	}

	public String getDriverArchives() 
	{
		return driverArchives;
	}
	public void setDriverLicenseNumber(String driverLicenseNumber) 
	{
		this.driverLicenseNumber = driverLicenseNumber;
	}

	public String getDriverLicenseNumber() 
	{
		return driverLicenseNumber;
	}
	public void setInitialDate(Date initialDate) 
	{
		this.initialDate = initialDate;
	}

	public Date getInitialDate() 
	{
		return initialDate;
	}
	public void setDriverAge(String driverAge) 
	{
		this.driverAge = driverAge;
	}

	public String getDriverAge() 
	{
		return driverAge;
	}
	public void setCertificateValidityPeriod(Date certificateValidityPeriod) 
	{
		this.certificateValidityPeriod = certificateValidityPeriod;
	}

	public Date getCertificateValidityPeriod() 
	{
		return certificateValidityPeriod;
	}
	public void setPhysicalValidityPeriod(Date physicalValidityPeriod) 
	{
		this.physicalValidityPeriod = physicalValidityPeriod;
	}

	public Date getPhysicalValidityPeriod() 
	{
		return physicalValidityPeriod;
	}
	public void setDriverVehicleType(String driverVehicleType) 
	{
		this.driverVehicleType = driverVehicleType;
	}

	public String getDriverVehicleType() 
	{
		return driverVehicleType;
	}
	public void setAnnualValidityPeriod(Date annualValidityPeriod) 
	{
		this.annualValidityPeriod = annualValidityPeriod;
	}

	public Date getAnnualValidityPeriod() 
	{
		return annualValidityPeriod;
	}
	public void setDriverIllegalScore(String driverIllegalScore) 
	{
		this.driverIllegalScore = driverIllegalScore;
	}

	public String getDriverIllegalScore() 
	{
		return driverIllegalScore;
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
            .append("driverUserId", getDriverUserId())
            .append("driverArchives", getDriverArchives())
            .append("driverLicenseNumber", getDriverLicenseNumber())
            .append("initialDate", getInitialDate())
            .append("driverAge", getDriverAge())
            .append("certificateValidityPeriod", getCertificateValidityPeriod())
            .append("physicalValidityPeriod", getPhysicalValidityPeriod())
            .append("driverVehicleType", getDriverVehicleType())
            .append("annualValidityPeriod", getAnnualValidityPeriod())
            .append("driverIllegalScore", getDriverIllegalScore())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
