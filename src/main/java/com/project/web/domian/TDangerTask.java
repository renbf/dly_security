package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 危险作业表 t_danger_task
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TDangerTask extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 作业名称 */
	private String taskName;
	/** 作业类别 */
	private String taskType;
	/** 作业地点 */
	private String taskPlace;
	/** 开始时间 */
	private Date startTime;
	/** 开始时间 */
	private Date startTime1;
	/** 结束时间 */
	private Date endTime;
	/** 结束时间 */
	private Date endTime1;
	/** 是否执行  0:执行  1:不执行*/
	private String isImplement;
	/** 申请人 */
	private String applyPer;
	/** 申请人user_id */
	private Long applyId;
	/** 现场负责人 */
	private String sceneResponsiblePer;
	/** 技术交底文件路径 */
	private String technologyFilePath;
	/** 许可证文件路径 */
	private String licenceFilePath;
	/** 备注 */
	private String remark;
	/** 新增时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
	/** 创建人ID */
	private Long userId;
	/** 企业ID */
	private String businessId;
	/** 修改人id */
	private Long updateUserId;

	
	
	
	public Date getStartTime1() {
		return startTime1;
	}

	public void setStartTime1(Date startTime1) {
		this.startTime1 = startTime1;
	}

	public Date getEndTime1() {
		return endTime1;
	}

	public void setEndTime1(Date endTime1) {
		this.endTime1 = endTime1;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setTaskName(String taskName) 
	{
		this.taskName = taskName;
	}

	public String getTaskName() 
	{
		return taskName;
	}
	public void setTaskType(String taskType) 
	{
		this.taskType = taskType;
	}

	public String getTaskType() 
	{
		return taskType;
	}
	public void setTaskPlace(String taskPlace) 
	{
		this.taskPlace = taskPlace;
	}

	public String getTaskPlace() 
	{
		return taskPlace;
	}
	public void setStartTime(Date startTime) 
	{
		this.startTime = startTime;
	}

	public Date getStartTime() 
	{
		return startTime;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}
	public void setIsImplement(String isImplement) 
	{
		this.isImplement = isImplement;
	}

	public String getIsImplement() 
	{
		return isImplement;
	}
	public void setApplyPer(String applyPer) 
	{
		this.applyPer = applyPer;
	}

	public String getApplyPer() 
	{
		return applyPer;
	}
	public void setApplyId(Long applyId) 
	{
		this.applyId = applyId;
	}

	public Long getApplyId() 
	{
		return applyId;
	}
	public void setSceneResponsiblePer(String sceneResponsiblePer) 
	{
		this.sceneResponsiblePer = sceneResponsiblePer;
	}

	public String getSceneResponsiblePer() 
	{
		return sceneResponsiblePer;
	}
	public void setTechnologyFilePath(String technologyFilePath) 
	{
		this.technologyFilePath = technologyFilePath;
	}

	public String getTechnologyFilePath() 
	{
		return technologyFilePath;
	}
	public void setLicenceFilePath(String licenceFilePath) 
	{
		this.licenceFilePath = licenceFilePath;
	}

	public String getLicenceFilePath() 
	{
		return licenceFilePath;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
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
            .append("taskName", getTaskName())
            .append("taskType", getTaskType())
            .append("taskPlace", getTaskPlace())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("isImplement", getIsImplement())
            .append("applyPer", getApplyPer())
            .append("applyId", getApplyId())
            .append("sceneResponsiblePer", getSceneResponsiblePer())
            .append("technologyFilePath", getTechnologyFilePath())
            .append("licenceFilePath", getLicenceFilePath())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
