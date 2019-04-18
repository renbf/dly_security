package com.project.security.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;
import java.util.Date;

/**
 * 隐患表 t_danger
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TDanger implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 受检部门ID */
	private Long inspectDeptId;
	/** 受检对象ID */
	private String inspectObj;
	/** 检查人ID */
	private String checkUserId;
	/** 检查日期 */
	private Date checkDate;
	/** 检查类型 */
	private String checkType;
	/** 隐患部位 */
	private String dangerPosition;
	/** 隐患部门ID */
	private Long dangerDeptId;
	/** 隐患类型 */
	private String dangerType;
	/** 隐患等级 */
	private String dangerLevel;
	/** 风险源 */
	private String riskResource;
	/** 可能后果 */
	private String maybeResult;
	/** 隐患照片 */
	private String dangerUrl;
	/** 备注 */
	private String remark;
	/** 状态0未整改、1整改中、2已整改待验收、3已验收4拒绝整改 */
	private String status;
	/** 整改截止时间 */
	private Date endDate;
	/** 整改责任人 */
	private String dochangeUserId;
	/** 整改部门 */
	private Long dochangeDeptId;
	/** 整改措施 */
	private String dochangeStep;
	/** 整改资金 */
	private String dochangeCapital;
	/** 整改照片 */
	private String dochangePicture;
	/** 整改时间 */
	private Date dochangeDate;
	/** 整改类型 */
	private String dochangeType;
	/** 拒绝原因 */
	private String refuseText;
	/** 验收责任人 */
	private String checkAcceptUserId;
	/** 验收部门 */
	private Long checkAcceptDeptId;
	/** 验收时间 */
	private Date checkAcceptDate;
	/** 验收结果 */
	private String checkAcceptResult;
	/** 验收照片 */
	private String checkAcceptUrl;
	/** 创建人id */
	private String addUserId;
	/** 创建时间 */
	private Date createDate;
	/** 修改时间 */
	private Date updateDate;
	/** 修改人id */
	private String updateUserId;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setInspectDeptId(Long inspectDeptId) 
	{
		this.inspectDeptId = inspectDeptId;
	}

	public Long getInspectDeptId() 
	{
		return inspectDeptId;
	}
	public void setInspectObj(String inspectObj) 
	{
		this.inspectObj = inspectObj;
	}

	public String getInspectObj() 
	{
		return inspectObj;
	}
	public void setCheckUserId(String checkUserId) 
	{
		this.checkUserId = checkUserId;
	}

	public String getCheckUserId() 
	{
		return checkUserId;
	}
	public void setCheckDate(Date checkDate) 
	{
		this.checkDate = checkDate;
	}

	public Date getCheckDate() 
	{
		return checkDate;
	}
	public void setCheckType(String checkType) 
	{
		this.checkType = checkType;
	}

	public String getCheckType() 
	{
		return checkType;
	}
	public void setDangerPosition(String dangerPosition) 
	{
		this.dangerPosition = dangerPosition;
	}

	public String getDangerPosition() 
	{
		return dangerPosition;
	}
	public void setDangerDeptId(Long dangerDeptId) 
	{
		this.dangerDeptId = dangerDeptId;
	}

	public Long getDangerDeptId() 
	{
		return dangerDeptId;
	}
	public void setDangerType(String dangerType) 
	{
		this.dangerType = dangerType;
	}

	public String getDangerType() 
	{
		return dangerType;
	}
	public void setDangerLevel(String dangerLevel) 
	{
		this.dangerLevel = dangerLevel;
	}

	public String getDangerLevel() 
	{
		return dangerLevel;
	}
	public void setRiskResource(String riskResource) 
	{
		this.riskResource = riskResource;
	}

	public String getRiskResource() 
	{
		return riskResource;
	}
	public void setMaybeResult(String maybeResult) 
	{
		this.maybeResult = maybeResult;
	}

	public String getMaybeResult() 
	{
		return maybeResult;
	}
	public void setDangerUrl(String dangerUrl) 
	{
		this.dangerUrl = dangerUrl;
	}

	public String getDangerUrl() 
	{
		return dangerUrl;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setEndDate(Date endDate) 
	{
		this.endDate = endDate;
	}

	public Date getEndDate() 
	{
		return endDate;
	}
	public void setDochangeUserId(String dochangeUserId) 
	{
		this.dochangeUserId = dochangeUserId;
	}

	public String getDochangeUserId() 
	{
		return dochangeUserId;
	}
	public void setDochangeDeptId(Long dochangeDeptId) 
	{
		this.dochangeDeptId = dochangeDeptId;
	}

	public Long getDochangeDeptId() 
	{
		return dochangeDeptId;
	}
	public void setDochangeStep(String dochangeStep) 
	{
		this.dochangeStep = dochangeStep;
	}

	public String getDochangeStep() 
	{
		return dochangeStep;
	}
	public void setDochangeCapital(String dochangeCapital) 
	{
		this.dochangeCapital = dochangeCapital;
	}

	public String getDochangeCapital() 
	{
		return dochangeCapital;
	}
	public void setDochangePicture(String dochangePicture) 
	{
		this.dochangePicture = dochangePicture;
	}

	public String getDochangePicture() 
	{
		return dochangePicture;
	}
	public void setDochangeDate(Date dochangeDate) 
	{
		this.dochangeDate = dochangeDate;
	}

	public Date getDochangeDate() 
	{
		return dochangeDate;
	}
	public void setDochangeType(String dochangeType) 
	{
		this.dochangeType = dochangeType;
	}

	public String getDochangeType() 
	{
		return dochangeType;
	}
	public void setRefuseText(String refuseText) 
	{
		this.refuseText = refuseText;
	}

	public String getRefuseText() 
	{
		return refuseText;
	}
	public void setCheckAcceptUserId(String checkAcceptUserId) 
	{
		this.checkAcceptUserId = checkAcceptUserId;
	}

	public String getCheckAcceptUserId() 
	{
		return checkAcceptUserId;
	}
	public void setCheckAcceptDeptId(Long checkAcceptDeptId) 
	{
		this.checkAcceptDeptId = checkAcceptDeptId;
	}

	public Long getCheckAcceptDeptId() 
	{
		return checkAcceptDeptId;
	}
	public void setCheckAcceptDate(Date checkAcceptDate) 
	{
		this.checkAcceptDate = checkAcceptDate;
	}

	public Date getCheckAcceptDate() 
	{
		return checkAcceptDate;
	}
	public void setCheckAcceptResult(String checkAcceptResult) 
	{
		this.checkAcceptResult = checkAcceptResult;
	}

	public String getCheckAcceptResult() 
	{
		return checkAcceptResult;
	}
	public void setCheckAcceptUrl(String checkAcceptUrl) 
	{
		this.checkAcceptUrl = checkAcceptUrl;
	}

	public String getCheckAcceptUrl() 
	{
		return checkAcceptUrl;
	}
	public void setAddUserId(String addUserId) 
	{
		this.addUserId = addUserId;
	}

	public String getAddUserId() 
	{
		return addUserId;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setUpdateDate(Date updateDate) 
	{
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() 
	{
		return updateDate;
	}
	public void setUpdateUserId(String updateUserId) 
	{
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserId() 
	{
		return updateUserId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("inspectDeptId", getInspectDeptId())
            .append("inspectObj", getInspectObj())
            .append("checkUserId", getCheckUserId())
            .append("checkDate", getCheckDate())
            .append("checkType", getCheckType())
            .append("dangerPosition", getDangerPosition())
            .append("dangerDeptId", getDangerDeptId())
            .append("dangerType", getDangerType())
            .append("dangerLevel", getDangerLevel())
            .append("riskResource", getRiskResource())
            .append("maybeResult", getMaybeResult())
            .append("dangerUrl", getDangerUrl())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("endDate", getEndDate())
            .append("dochangeUserId", getDochangeUserId())
            .append("dochangeDeptId", getDochangeDeptId())
            .append("dochangeStep", getDochangeStep())
            .append("dochangeCapital", getDochangeCapital())
            .append("dochangePicture", getDochangePicture())
            .append("dochangeDate", getDochangeDate())
            .append("dochangeType", getDochangeType())
            .append("refuseText", getRefuseText())
            .append("checkAcceptUserId", getCheckAcceptUserId())
            .append("checkAcceptDeptId", getCheckAcceptDeptId())
            .append("checkAcceptDate", getCheckAcceptDate())
            .append("checkAcceptResult", getCheckAcceptResult())
            .append("checkAcceptUrl", getCheckAcceptUrl())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
