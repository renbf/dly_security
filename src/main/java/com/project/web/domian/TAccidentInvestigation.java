package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 事故调查表 t_accident_investigation
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TAccidentInvestigation extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 事故基础表主键ID t_accident_basics */
	private String accidentBasiscId;
	/** 事故名称 */
	private String accidentName;
	/** 是否处理 0：未处理   1:处理 */
	private String isHandle;
	/** 处理日期 */
	private Date handleDate;
	/** 是否结案 0：未结案   1:已结案 */
	private String isCloseCase;
	/** 结案日期 */
	private Date closeCaseDate;
	/** 结案方式 */
	private String closeCaseType;
	/** 所属部门 （部门ID） */
	private String deptId;
	/** 参与方资料 */
	private String participantInfo;
	/** 事故原因 */
	private String accidentReason;
	/** 责任追究 */
	private String responsibilityInvestigate;
	/** 事故教育 */
	private String accidentEducation;
	/** 整改措施 */
	private String rectificationMeasures;
	/** 防范措施 */
	private String preventiveMeasures;
	/** 文件路径 */
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
	public void setAccidentBasiscId(String accidentBasiscId) 
	{
		this.accidentBasiscId = accidentBasiscId;
	}

	public String getAccidentBasiscId() 
	{
		return accidentBasiscId;
	}
	public void setAccidentName(String accidentName) 
	{
		this.accidentName = accidentName;
	}

	public String getAccidentName() 
	{
		return accidentName;
	}
	public void setIsHandle(String isHandle) 
	{
		this.isHandle = isHandle;
	}

	public String getIsHandle() 
	{
		return isHandle;
	}
	public void setHandleDate(Date handleDate) 
	{
		this.handleDate = handleDate;
	}

	public Date getHandleDate() 
	{
		return handleDate;
	}
	public void setIsCloseCase(String isCloseCase) 
	{
		this.isCloseCase = isCloseCase;
	}

	public String getIsCloseCase() 
	{
		return isCloseCase;
	}
	public void setCloseCaseDate(Date closeCaseDate) 
	{
		this.closeCaseDate = closeCaseDate;
	}

	public Date getCloseCaseDate() 
	{
		return closeCaseDate;
	}
	public void setCloseCaseType(String closeCaseType) 
	{
		this.closeCaseType = closeCaseType;
	}

	public String getCloseCaseType() 
	{
		return closeCaseType;
	}
	public void setDeptId(String deptId) 
	{
		this.deptId = deptId;
	}

	public String getDeptId() 
	{
		return deptId;
	}
	public void setParticipantInfo(String participantInfo) 
	{
		this.participantInfo = participantInfo;
	}

	public String getParticipantInfo() 
	{
		return participantInfo;
	}
	public void setAccidentReason(String accidentReason) 
	{
		this.accidentReason = accidentReason;
	}

	public String getAccidentReason() 
	{
		return accidentReason;
	}
	public void setResponsibilityInvestigate(String responsibilityInvestigate) 
	{
		this.responsibilityInvestigate = responsibilityInvestigate;
	}

	public String getResponsibilityInvestigate() 
	{
		return responsibilityInvestigate;
	}
	public void setAccidentEducation(String accidentEducation) 
	{
		this.accidentEducation = accidentEducation;
	}

	public String getAccidentEducation() 
	{
		return accidentEducation;
	}
	public void setRectificationMeasures(String rectificationMeasures) 
	{
		this.rectificationMeasures = rectificationMeasures;
	}

	public String getRectificationMeasures() 
	{
		return rectificationMeasures;
	}
	public void setPreventiveMeasures(String preventiveMeasures) 
	{
		this.preventiveMeasures = preventiveMeasures;
	}

	public String getPreventiveMeasures() 
	{
		return preventiveMeasures;
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
            .append("accidentBasiscId", getAccidentBasiscId())
            .append("accidentName", getAccidentName())
            .append("isHandle", getIsHandle())
            .append("handleDate", getHandleDate())
            .append("isCloseCase", getIsCloseCase())
            .append("closeCaseDate", getCloseCaseDate())
            .append("closeCaseType", getCloseCaseType())
            .append("deptId", getDeptId())
            .append("participantInfo", getParticipantInfo())
            .append("accidentReason", getAccidentReason())
            .append("responsibilityInvestigate", getResponsibilityInvestigate())
            .append("accidentEducation", getAccidentEducation())
            .append("rectificationMeasures", getRectificationMeasures())
            .append("preventiveMeasures", getPreventiveMeasures())
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
