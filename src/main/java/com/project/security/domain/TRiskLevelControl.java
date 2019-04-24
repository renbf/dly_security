package com.project.security.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;
import java.util.Date;

/**
 * 风险分级管控表 t_risk_level_control
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TRiskLevelControl implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 风险部位 */
	private String riskPosition;
	/** 风险名称 */
	private String riskName;
	/** 风险分级 */
	private String riskLevel;
	/** 防范措施 */
	private String preventiveMeasures;
	/** 可能导致事故类型 */
	private String accidentType;
	/** 辨识日期 */
	private Date identificationDate;
	/** 依据 */
	private String basis;
	/** 所属部门id */
	private String deptId;
	/** 责任人 */
	private String personLiable;
	/** 附件路径 */
	private String filePath;
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
	public void setRiskPosition(String riskPosition) 
	{
		this.riskPosition = riskPosition;
	}

	public String getRiskPosition() 
	{
		return riskPosition;
	}
	public void setRiskName(String riskName) 
	{
		this.riskName = riskName;
	}

	public String getRiskName() 
	{
		return riskName;
	}
	public void setRiskLevel(String riskLevel) 
	{
		this.riskLevel = riskLevel;
	}

	public String getRiskLevel() 
	{
		return riskLevel;
	}
	public void setPreventiveMeasures(String preventiveMeasures) 
	{
		this.preventiveMeasures = preventiveMeasures;
	}

	public String getPreventiveMeasures() 
	{
		return preventiveMeasures;
	}
	public void setAccidentType(String accidentType) 
	{
		this.accidentType = accidentType;
	}

	public String getAccidentType() 
	{
		return accidentType;
	}
	public void setIdentificationDate(Date identificationDate) 
	{
		this.identificationDate = identificationDate;
	}

	public Date getIdentificationDate() 
	{
		return identificationDate;
	}
	public void setBasis(String basis) 
	{
		this.basis = basis;
	}

	public String getBasis() 
	{
		return basis;
	}
	public void setDeptId(String deptId) 
	{
		this.deptId = deptId;
	}

	public String getDeptId() 
	{
		return deptId;
	}
	public void setPersonLiable(String personLiable) 
	{
		this.personLiable = personLiable;
	}

	public String getPersonLiable() 
	{
		return personLiable;
	}
	public void setFilePath(String filePath) 
	{
		this.filePath = filePath;
	}

	public String getFilePath() 
	{
		return filePath;
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
            .append("riskPosition", getRiskPosition())
            .append("riskName", getRiskName())
            .append("riskLevel", getRiskLevel())
            .append("preventiveMeasures", getPreventiveMeasures())
            .append("accidentType", getAccidentType())
            .append("identificationDate", getIdentificationDate())
            .append("basis", getBasis())
            .append("deptId", getDeptId())
            .append("personLiable", getPersonLiable())
            .append("filePath", getFilePath())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
