package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 预警设置表 t_early_warning_settings
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TEarlyWarningSettings extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 隐患初始数量（A） */
	private Integer dangerIniNum;
	/** 风险初始数量（H） */
	private Integer riskIniNum;
	/** 事故隐患后果（W1） */
	private String accidentResult;
	/** 事故隐患等级（W2） */
	private String accidentLevl;
	/** 事故整改率（W3) */
	private String accidentRectificationRate;
	/** 教育培训等级（W4） */
	private String educationLevl;
	/** 教育培训学时比（W5)： */
	private String educationProportion;
	/** 应急演练等级（W6) */
	private String drillLevl;
	/** 应急演练影响（W7） */
	private String drillInfluence;
	/** 事故事件（W8) */
	private String accidentEvent;
	/** 风险源后果( W9 ) */
	private String riskSourceResult;
	/** 风险源等级（W10)： */
	private String riskSourceLevl;
	/** 风险源受控率（W11） */
	private String riskSourceControlRate;
	/** 道路运输证 */
	private Integer roadTransport;
	/** 行驶证 */
	private Integer travelCard;
	/** 驾驶员年龄预警 */
	private Integer driverAge;
	/** 隐患整改限时 (单位天) */
	private Integer rectificationLimitedDay;
	/** 安全责任状 */
	private Integer securityResponsibility;
	/** 车辆保险 */
	private Integer vehicleInsurance;
	/** 未学习 */
	private Integer notLearn;
	/** 驾驶证日期 */
	private Integer driverLicenseTime;
	/** 从业资格证过期 */
	private Integer qualificationCertificate;
	/** 每月未进行隐患排查 */
	private Integer monthNotCheck;
	/** 每年未进行应急演练 */
	private Integer yearNotCheck;
	/** 车辆综合性能检测（检测有效期） */
	private Integer driverComprehensiveCheck;
	/** 驾驶员从业资格证中的继续教育 */
	private Integer driverEducation;
	/** 主要负责人，安全员年度再教育 */
	private Integer mainResponsibleEducation;
	/** 承运人责任险过期 */
	private Integer shipmentResponsibleDay;
	/** 罐检 */
	private Integer potCheck;
	/** 特种设备年检 */
	private Integer specialEquipmentCheck;
	/** （客运企业）线路牌有效期 */
	private Integer clientLine;
	/** 包车牌过期 */
	private Integer driverOutDay;
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
	public void setDangerIniNum(Integer dangerIniNum) 
	{
		this.dangerIniNum = dangerIniNum;
	}

	public Integer getDangerIniNum() 
	{
		return dangerIniNum;
	}
	public void setRiskIniNum(Integer riskIniNum) 
	{
		this.riskIniNum = riskIniNum;
	}

	public Integer getRiskIniNum() 
	{
		return riskIniNum;
	}
	public void setAccidentResult(String accidentResult) 
	{
		this.accidentResult = accidentResult;
	}

	public String getAccidentResult() 
	{
		return accidentResult;
	}
	public void setAccidentLevl(String accidentLevl) 
	{
		this.accidentLevl = accidentLevl;
	}

	public String getAccidentLevl() 
	{
		return accidentLevl;
	}
	public void setAccidentRectificationRate(String accidentRectificationRate) 
	{
		this.accidentRectificationRate = accidentRectificationRate;
	}

	public String getAccidentRectificationRate() 
	{
		return accidentRectificationRate;
	}
	public void setEducationLevl(String educationLevl) 
	{
		this.educationLevl = educationLevl;
	}

	public String getEducationLevl() 
	{
		return educationLevl;
	}
	public void setEducationProportion(String educationProportion) 
	{
		this.educationProportion = educationProportion;
	}

	public String getEducationProportion() 
	{
		return educationProportion;
	}
	public void setDrillLevl(String drillLevl) 
	{
		this.drillLevl = drillLevl;
	}

	public String getDrillLevl() 
	{
		return drillLevl;
	}
	public void setDrillInfluence(String drillInfluence) 
	{
		this.drillInfluence = drillInfluence;
	}

	public String getDrillInfluence() 
	{
		return drillInfluence;
	}
	public void setAccidentEvent(String accidentEvent) 
	{
		this.accidentEvent = accidentEvent;
	}

	public String getAccidentEvent() 
	{
		return accidentEvent;
	}
	public void setRiskSourceResult(String riskSourceResult) 
	{
		this.riskSourceResult = riskSourceResult;
	}

	public String getRiskSourceResult() 
	{
		return riskSourceResult;
	}
	public void setRiskSourceLevl(String riskSourceLevl) 
	{
		this.riskSourceLevl = riskSourceLevl;
	}

	public String getRiskSourceLevl() 
	{
		return riskSourceLevl;
	}
	public void setRiskSourceControlRate(String riskSourceControlRate) 
	{
		this.riskSourceControlRate = riskSourceControlRate;
	}

	public String getRiskSourceControlRate() 
	{
		return riskSourceControlRate;
	}
	public void setRoadTransport(Integer roadTransport) 
	{
		this.roadTransport = roadTransport;
	}

	public Integer getRoadTransport() 
	{
		return roadTransport;
	}
	public void setTravelCard(Integer travelCard) 
	{
		this.travelCard = travelCard;
	}

	public Integer getTravelCard() 
	{
		return travelCard;
	}
	public void setDriverAge(Integer driverAge) 
	{
		this.driverAge = driverAge;
	}

	public Integer getDriverAge() 
	{
		return driverAge;
	}
	public void setRectificationLimitedDay(Integer rectificationLimitedDay) 
	{
		this.rectificationLimitedDay = rectificationLimitedDay;
	}

	public Integer getRectificationLimitedDay() 
	{
		return rectificationLimitedDay;
	}
	public void setSecurityResponsibility(Integer securityResponsibility) 
	{
		this.securityResponsibility = securityResponsibility;
	}

	public Integer getSecurityResponsibility() 
	{
		return securityResponsibility;
	}
	public void setVehicleInsurance(Integer vehicleInsurance) 
	{
		this.vehicleInsurance = vehicleInsurance;
	}

	public Integer getVehicleInsurance() 
	{
		return vehicleInsurance;
	}
	public void setNotLearn(Integer notLearn) 
	{
		this.notLearn = notLearn;
	}

	public Integer getNotLearn() 
	{
		return notLearn;
	}
	public void setDriverLicenseTime(Integer driverLicenseTime) 
	{
		this.driverLicenseTime = driverLicenseTime;
	}

	public Integer getDriverLicenseTime() 
	{
		return driverLicenseTime;
	}
	public void setQualificationCertificate(Integer qualificationCertificate) 
	{
		this.qualificationCertificate = qualificationCertificate;
	}

	public Integer getQualificationCertificate() 
	{
		return qualificationCertificate;
	}
	public void setMonthNotCheck(Integer monthNotCheck) 
	{
		this.monthNotCheck = monthNotCheck;
	}

	public Integer getMonthNotCheck() 
	{
		return monthNotCheck;
	}
	public void setYearNotCheck(Integer yearNotCheck) 
	{
		this.yearNotCheck = yearNotCheck;
	}

	public Integer getYearNotCheck() 
	{
		return yearNotCheck;
	}
	public void setDriverComprehensiveCheck(Integer driverComprehensiveCheck) 
	{
		this.driverComprehensiveCheck = driverComprehensiveCheck;
	}

	public Integer getDriverComprehensiveCheck() 
	{
		return driverComprehensiveCheck;
	}
	public void setDriverEducation(Integer driverEducation) 
	{
		this.driverEducation = driverEducation;
	}

	public Integer getDriverEducation() 
	{
		return driverEducation;
	}
	public void setMainResponsibleEducation(Integer mainResponsibleEducation) 
	{
		this.mainResponsibleEducation = mainResponsibleEducation;
	}

	public Integer getMainResponsibleEducation() 
	{
		return mainResponsibleEducation;
	}
	public void setShipmentResponsibleDay(Integer shipmentResponsibleDay) 
	{
		this.shipmentResponsibleDay = shipmentResponsibleDay;
	}

	public Integer getShipmentResponsibleDay() 
	{
		return shipmentResponsibleDay;
	}
	public void setPotCheck(Integer potCheck) 
	{
		this.potCheck = potCheck;
	}

	public Integer getPotCheck() 
	{
		return potCheck;
	}
	public void setSpecialEquipmentCheck(Integer specialEquipmentCheck) 
	{
		this.specialEquipmentCheck = specialEquipmentCheck;
	}

	public Integer getSpecialEquipmentCheck() 
	{
		return specialEquipmentCheck;
	}
	public void setClientLine(Integer clientLine) 
	{
		this.clientLine = clientLine;
	}

	public Integer getClientLine() 
	{
		return clientLine;
	}
	public void setDriverOutDay(Integer driverOutDay) 
	{
		this.driverOutDay = driverOutDay;
	}

	public Integer getDriverOutDay() 
	{
		return driverOutDay;
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
            .append("dangerIniNum", getDangerIniNum())
            .append("riskIniNum", getRiskIniNum())
            .append("accidentResult", getAccidentResult())
            .append("accidentLevl", getAccidentLevl())
            .append("accidentRectificationRate", getAccidentRectificationRate())
            .append("educationLevl", getEducationLevl())
            .append("educationProportion", getEducationProportion())
            .append("drillLevl", getDrillLevl())
            .append("drillInfluence", getDrillInfluence())
            .append("accidentEvent", getAccidentEvent())
            .append("riskSourceResult", getRiskSourceResult())
            .append("riskSourceLevl", getRiskSourceLevl())
            .append("riskSourceControlRate", getRiskSourceControlRate())
            .append("roadTransport", getRoadTransport())
            .append("travelCard", getTravelCard())
            .append("driverAge", getDriverAge())
            .append("rectificationLimitedDay", getRectificationLimitedDay())
            .append("securityResponsibility", getSecurityResponsibility())
            .append("vehicleInsurance", getVehicleInsurance())
            .append("notLearn", getNotLearn())
            .append("driverLicenseTime", getDriverLicenseTime())
            .append("qualificationCertificate", getQualificationCertificate())
            .append("monthNotCheck", getMonthNotCheck())
            .append("yearNotCheck", getYearNotCheck())
            .append("driverComprehensiveCheck", getDriverComprehensiveCheck())
            .append("driverEducation", getDriverEducation())
            .append("mainResponsibleEducation", getMainResponsibleEducation())
            .append("shipmentResponsibleDay", getShipmentResponsibleDay())
            .append("potCheck", getPotCheck())
            .append("specialEquipmentCheck", getSpecialEquipmentCheck())
            .append("clientLine", getClientLine())
            .append("driverOutDay", getDriverOutDay())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
