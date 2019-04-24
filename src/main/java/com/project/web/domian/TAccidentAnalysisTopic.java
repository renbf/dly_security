package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 事故分析专题会议表 t_accident_analysis_topic
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TAccidentAnalysisTopic extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 事故基础表主键ID t_accident_basics */
	private String accidentBasiscId;
	/** 会议名称 */
	private String topicName;
	/** 会议编号 */
	private String topicCode;
	/** 会议形式 */
	private String topicType;
	/** 会议日期 */
	private Date topicDate;
	/** 会议主持人 */
	private String topicHost;
	/** 会议记录人 */
	private Long topicNoteTaker;
	/** 应到人数 */
	private Integer shouldNum;
	/** 实到人数 */
	private Integer actNum;
	/** 所属部门ID */
	private String deptId;
	/** 所属部门名称 */
	private String deptName;
	/** 会议地点 */
	private String topicPlace;
	/** 会议内容 */
	private String topicInfo;
	/** 事故原因 */
	private String accidentReason;
	/** 企业存在问题 */
	private String enterpriseProblem;
	/** 整改以及防范措施 */
	private String rectificationPreventiveMeasures;
	/** 备注 */
	private String remark;
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
	/**  */
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
	public void setTopicName(String topicName) 
	{
		this.topicName = topicName;
	}

	public String getTopicName() 
	{
		return topicName;
	}
	public void setTopicCode(String topicCode) 
	{
		this.topicCode = topicCode;
	}

	public String getTopicCode() 
	{
		return topicCode;
	}
	public void setTopicType(String topicType) 
	{
		this.topicType = topicType;
	}

	public String getTopicType() 
	{
		return topicType;
	}
	public void setTopicDate(Date topicDate) 
	{
		this.topicDate = topicDate;
	}

	public Date getTopicDate() 
	{
		return topicDate;
	}
	public void setTopicHost(String topicHost) 
	{
		this.topicHost = topicHost;
	}

	public String getTopicHost() 
	{
		return topicHost;
	}
	public void setTopicNoteTaker(Long topicNoteTaker) 
	{
		this.topicNoteTaker = topicNoteTaker;
	}

	public Long getTopicNoteTaker() 
	{
		return topicNoteTaker;
	}
	public void setShouldNum(Integer shouldNum) 
	{
		this.shouldNum = shouldNum;
	}

	public Integer getShouldNum() 
	{
		return shouldNum;
	}
	public void setActNum(Integer actNum) 
	{
		this.actNum = actNum;
	}

	public Integer getActNum() 
	{
		return actNum;
	}
	public void setDeptId(String deptId) 
	{
		this.deptId = deptId;
	}

	public String getDeptId() 
	{
		return deptId;
	}
	public void setDeptName(String deptName) 
	{
		this.deptName = deptName;
	}

	public String getDeptName() 
	{
		return deptName;
	}
	public void setTopicPlace(String topicPlace) 
	{
		this.topicPlace = topicPlace;
	}

	public String getTopicPlace() 
	{
		return topicPlace;
	}
	public void setTopicInfo(String topicInfo) 
	{
		this.topicInfo = topicInfo;
	}

	public String getTopicInfo() 
	{
		return topicInfo;
	}
	public void setAccidentReason(String accidentReason) 
	{
		this.accidentReason = accidentReason;
	}

	public String getAccidentReason() 
	{
		return accidentReason;
	}
	public void setEnterpriseProblem(String enterpriseProblem) 
	{
		this.enterpriseProblem = enterpriseProblem;
	}

	public String getEnterpriseProblem() 
	{
		return enterpriseProblem;
	}
	public void setRectificationPreventiveMeasures(String rectificationPreventiveMeasures) 
	{
		this.rectificationPreventiveMeasures = rectificationPreventiveMeasures;
	}

	public String getRectificationPreventiveMeasures() 
	{
		return rectificationPreventiveMeasures;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
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
            .append("topicName", getTopicName())
            .append("topicCode", getTopicCode())
            .append("topicType", getTopicType())
            .append("topicDate", getTopicDate())
            .append("topicHost", getTopicHost())
            .append("topicNoteTaker", getTopicNoteTaker())
            .append("shouldNum", getShouldNum())
            .append("actNum", getActNum())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("topicPlace", getTopicPlace())
            .append("topicInfo", getTopicInfo())
            .append("accidentReason", getAccidentReason())
            .append("enterpriseProblem", getEnterpriseProblem())
            .append("rectificationPreventiveMeasures", getRectificationPreventiveMeasures())
            .append("remark", getRemark())
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
