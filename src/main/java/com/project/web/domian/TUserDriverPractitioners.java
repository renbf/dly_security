package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 驾驶员从业资格证表 t_user_driver_practitioners
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TUserDriverPractitioners extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 对应sys_user表中的user_id值 */
	private Long driverUserId;
	/** 从业资格证号 */
	private String practitionersNum;
	/** 从业类别 */
	private String practitionersType;
	/** 初领日期 */
	private Date practitionersInitialDate;
	/** 年审有效期 */
	private Date annualValidityPeriod;
	/** 证件有效期 */
	private Date certificateValidityPeriod;
	/** 证件有效期 */
	private Date certificateValidityPeriodStr;
	/** 是否持证  0:持证 1:不持证 */
	private String isCertificate;
	/** 继续教育有效期限 */
	private Date aginEducationValidityPeriod;
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

	
	
	public Date getCertificateValidityPeriodStr() {
		return certificateValidityPeriodStr;
	}

	public void setCertificateValidityPeriodStr(Date certificateValidityPeriodStr) {
		this.certificateValidityPeriodStr = certificateValidityPeriodStr;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setDriverUserId(Long driverUserId) 
	{
		this.driverUserId = driverUserId;
	}

	public Long getDriverUserId() 
	{
		return driverUserId;
	}
	public void setPractitionersNum(String practitionersNum) 
	{
		this.practitionersNum = practitionersNum;
	}

	public String getPractitionersNum() 
	{
		return practitionersNum;
	}
	public void setPractitionersType(String practitionersType) 
	{
		this.practitionersType = practitionersType;
	}

	public String getPractitionersType() 
	{
		return practitionersType;
	}
	public void setPractitionersInitialDate(Date practitionersInitialDate) 
	{
		this.practitionersInitialDate = practitionersInitialDate;
	}

	public Date getPractitionersInitialDate() 
	{
		return practitionersInitialDate;
	}
	public void setAnnualValidityPeriod(Date annualValidityPeriod) 
	{
		this.annualValidityPeriod = annualValidityPeriod;
	}

	public Date getAnnualValidityPeriod() 
	{
		return annualValidityPeriod;
	}
	public void setCertificateValidityPeriod(Date certificateValidityPeriod) 
	{
		this.certificateValidityPeriod = certificateValidityPeriod;
	}

	public Date getCertificateValidityPeriod() 
	{
		return certificateValidityPeriod;
	}
	public void setIsCertificate(String isCertificate) 
	{
		this.isCertificate = isCertificate;
	}

	public String getIsCertificate() 
	{
		return isCertificate;
	}
	public void setAginEducationValidityPeriod(Date aginEducationValidityPeriod) 
	{
		this.aginEducationValidityPeriod = aginEducationValidityPeriod;
	}

	public Date getAginEducationValidityPeriod() 
	{
		return aginEducationValidityPeriod;
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
            .append("practitionersNum", getPractitionersNum())
            .append("practitionersType", getPractitionersType())
            .append("practitionersInitialDate", getPractitionersInitialDate())
            .append("annualValidityPeriod", getAnnualValidityPeriod())
            .append("certificateValidityPeriod", getCertificateValidityPeriod())
            .append("isCertificate", getIsCertificate())
            .append("aginEducationValidityPeriod", getAginEducationValidityPeriod())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
