package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 驾驶员其他表 t_user_driver_others
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TUserDriverOthers extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 对应sys_user表中的user_id值 */
	private Long driverUserId;
	/** 是否备案 0:备案  1：无备案 */
	private String isRecord;
	/** 诚信考核到期 */
	private Date integrityExaminationPeriod;
	/** 诚信考核等级 */
	private String integrityExaminationLevel;
	/** 准驾证号 */
	private String accurateNum;
	/** 准运线 */
	private String transportationLine;
	/** 准驾证有效期 */
	private Date driverValidityPeriod;
	/** 是否缴纳风险金 0:是  1:否 */
	private String isRisk;
	/** 缴纳标准 */
	private String riskStandard;
	/** 缴纳金额 */
	private Long riskAmt;
	/** 考核人 */
	private String assessor;
	/** 考核日期 */
	private Date assessorDate;
	/** 考核内容 */
	private String assessorInfo;
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
	public void setDriverUserId(Long driverUserId) 
	{
		this.driverUserId = driverUserId;
	}

	public Long getDriverUserId() 
	{
		return driverUserId;
	}
	public void setIsRecord(String isRecord) 
	{
		this.isRecord = isRecord;
	}

	public String getIsRecord() 
	{
		return isRecord;
	}
	public void setIntegrityExaminationPeriod(Date integrityExaminationPeriod) 
	{
		this.integrityExaminationPeriod = integrityExaminationPeriod;
	}

	public Date getIntegrityExaminationPeriod() 
	{
		return integrityExaminationPeriod;
	}
	public void setIntegrityExaminationLevel(String integrityExaminationLevel) 
	{
		this.integrityExaminationLevel = integrityExaminationLevel;
	}

	public String getIntegrityExaminationLevel() 
	{
		return integrityExaminationLevel;
	}
	public void setAccurateNum(String accurateNum) 
	{
		this.accurateNum = accurateNum;
	}

	public String getAccurateNum() 
	{
		return accurateNum;
	}
	public void setTransportationLine(String transportationLine) 
	{
		this.transportationLine = transportationLine;
	}

	public String getTransportationLine() 
	{
		return transportationLine;
	}
	public void setDriverValidityPeriod(Date driverValidityPeriod) 
	{
		this.driverValidityPeriod = driverValidityPeriod;
	}

	public Date getDriverValidityPeriod() 
	{
		return driverValidityPeriod;
	}
	public void setIsRisk(String isRisk) 
	{
		this.isRisk = isRisk;
	}

	public String getIsRisk() 
	{
		return isRisk;
	}
	public void setRiskStandard(String riskStandard) 
	{
		this.riskStandard = riskStandard;
	}

	public String getRiskStandard() 
	{
		return riskStandard;
	}
	public void setRiskAmt(Long riskAmt) 
	{
		this.riskAmt = riskAmt;
	}

	public Long getRiskAmt() 
	{
		return riskAmt;
	}
	public void setAssessor(String assessor) 
	{
		this.assessor = assessor;
	}

	public String getAssessor() 
	{
		return assessor;
	}
	public void setAssessorDate(Date assessorDate) 
	{
		this.assessorDate = assessorDate;
	}

	public Date getAssessorDate() 
	{
		return assessorDate;
	}
	public void setAssessorInfo(String assessorInfo) 
	{
		this.assessorInfo = assessorInfo;
	}

	public String getAssessorInfo() 
	{
		return assessorInfo;
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
            .append("isRecord", getIsRecord())
            .append("integrityExaminationPeriod", getIntegrityExaminationPeriod())
            .append("integrityExaminationLevel", getIntegrityExaminationLevel())
            .append("accurateNum", getAccurateNum())
            .append("transportationLine", getTransportationLine())
            .append("driverValidityPeriod", getDriverValidityPeriod())
            .append("isRisk", getIsRisk())
            .append("riskStandard", getRiskStandard())
            .append("riskAmt", getRiskAmt())
            .append("assessor", getAssessor())
            .append("assessorDate", getAssessorDate())
            .append("assessorInfo", getAssessorInfo())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
