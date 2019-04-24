package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 隐患排查表 t_hidden_trouble_investigation
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class THiddenTroubleInvestigation extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 部门/车间 部门id */
	private String deptId;
	/** 风险部位 */
	private String riskPosition;
	/** 隐患名称 */
	private String riskName;
	/** 风险管控措施 */
	private String riskMeasures;
	/** 风险失控表现 */
	private String riskNotControl;
	/** 隐患等级 */
	private String riskLevel;
	/** 失职部门id */
	private String derelictionDeptId;
	/** 失职人员id */
	private Long derelictionPer;
	/** 失职人员名称 */
	private String derelictionPerName;
	/** 排查部门id */
	private String troubleshootDeptId;
	/** 排查人员id */
	private Long troubleshootPer;
	/** 排查人员名称 */
	private String troubleshootPerName;
	/** 排查状态 0：已下发  1:已整改 */
	private String troubleshootStatus;
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
	public void setDeptId(String deptId) 
	{
		this.deptId = deptId;
	}

	public String getDeptId() 
	{
		return deptId;
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
	public void setRiskMeasures(String riskMeasures) 
	{
		this.riskMeasures = riskMeasures;
	}

	public String getRiskMeasures() 
	{
		return riskMeasures;
	}
	public void setRiskNotControl(String riskNotControl) 
	{
		this.riskNotControl = riskNotControl;
	}

	public String getRiskNotControl() 
	{
		return riskNotControl;
	}
	public void setRiskLevel(String riskLevel) 
	{
		this.riskLevel = riskLevel;
	}

	public String getRiskLevel() 
	{
		return riskLevel;
	}
	public void setDerelictionDeptId(String derelictionDeptId) 
	{
		this.derelictionDeptId = derelictionDeptId;
	}

	public String getDerelictionDeptId() 
	{
		return derelictionDeptId;
	}
	public void setDerelictionPer(Long derelictionPer) 
	{
		this.derelictionPer = derelictionPer;
	}

	public Long getDerelictionPer() 
	{
		return derelictionPer;
	}
	public void setDerelictionPerName(String derelictionPerName) 
	{
		this.derelictionPerName = derelictionPerName;
	}

	public String getDerelictionPerName() 
	{
		return derelictionPerName;
	}
	public void setTroubleshootDeptId(String troubleshootDeptId) 
	{
		this.troubleshootDeptId = troubleshootDeptId;
	}

	public String getTroubleshootDeptId() 
	{
		return troubleshootDeptId;
	}
	public void setTroubleshootPer(Long troubleshootPer) 
	{
		this.troubleshootPer = troubleshootPer;
	}

	public Long getTroubleshootPer() 
	{
		return troubleshootPer;
	}
	public void setTroubleshootPerName(String troubleshootPerName) 
	{
		this.troubleshootPerName = troubleshootPerName;
	}

	public String getTroubleshootPerName() 
	{
		return troubleshootPerName;
	}
	public void setTroubleshootStatus(String troubleshootStatus) 
	{
		this.troubleshootStatus = troubleshootStatus;
	}

	public String getTroubleshootStatus() 
	{
		return troubleshootStatus;
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
            .append("deptId", getDeptId())
            .append("riskPosition", getRiskPosition())
            .append("riskName", getRiskName())
            .append("riskMeasures", getRiskMeasures())
            .append("riskNotControl", getRiskNotControl())
            .append("riskLevel", getRiskLevel())
            .append("derelictionDeptId", getDerelictionDeptId())
            .append("derelictionPer", getDerelictionPer())
            .append("derelictionPerName", getDerelictionPerName())
            .append("troubleshootDeptId", getTroubleshootDeptId())
            .append("troubleshootPer", getTroubleshootPer())
            .append("troubleshootPerName", getTroubleshootPerName())
            .append("troubleshootStatus", getTroubleshootStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
