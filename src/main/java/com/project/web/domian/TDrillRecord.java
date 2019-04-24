package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 演练记录表 t_drill_record
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TDrillRecord extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 应急预案 */
	private String contingencyPlan;
	/** 演练内容 */
	private String exerciseContent;
	/** 演练名称 */
	private String exerciseName;
	/** 效果评估 */
	private String effectEvaluation;
	/** 演练时间 */
	private Date exerciseDate;
	/** 指挥人 */
	private String commandingOfficer;
	/** 演练类型 */
	private String exerciseType;
	/** 参与人数 */
	private Integer participantsNum;
	/** 演练级别 */
	private String participantsLevl;
	/** 签到人数 */
	private Integer checkInNum;
	/** 演练地点 */
	private String exercisePlace;
	/** 演练照片 */
	private String exerciseFilePath;
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
	public void setContingencyPlan(String contingencyPlan) 
	{
		this.contingencyPlan = contingencyPlan;
	}

	public String getContingencyPlan() 
	{
		return contingencyPlan;
	}
	public void setExerciseContent(String exerciseContent) 
	{
		this.exerciseContent = exerciseContent;
	}

	public String getExerciseContent() 
	{
		return exerciseContent;
	}
	public void setExerciseName(String exerciseName) 
	{
		this.exerciseName = exerciseName;
	}

	public String getExerciseName() 
	{
		return exerciseName;
	}
	public void setEffectEvaluation(String effectEvaluation) 
	{
		this.effectEvaluation = effectEvaluation;
	}

	public String getEffectEvaluation() 
	{
		return effectEvaluation;
	}
	public void setExerciseDate(Date exerciseDate) 
	{
		this.exerciseDate = exerciseDate;
	}

	public Date getExerciseDate() 
	{
		return exerciseDate;
	}
	public void setCommandingOfficer(String commandingOfficer) 
	{
		this.commandingOfficer = commandingOfficer;
	}

	public String getCommandingOfficer() 
	{
		return commandingOfficer;
	}
	public void setExerciseType(String exerciseType) 
	{
		this.exerciseType = exerciseType;
	}

	public String getExerciseType() 
	{
		return exerciseType;
	}
	public void setParticipantsNum(Integer participantsNum) 
	{
		this.participantsNum = participantsNum;
	}

	public Integer getParticipantsNum() 
	{
		return participantsNum;
	}
	public void setParticipantsLevl(String participantsLevl) 
	{
		this.participantsLevl = participantsLevl;
	}

	public String getParticipantsLevl() 
	{
		return participantsLevl;
	}
	public void setCheckInNum(Integer checkInNum) 
	{
		this.checkInNum = checkInNum;
	}

	public Integer getCheckInNum() 
	{
		return checkInNum;
	}
	public void setExercisePlace(String exercisePlace) 
	{
		this.exercisePlace = exercisePlace;
	}

	public String getExercisePlace() 
	{
		return exercisePlace;
	}
	public void setExerciseFilePath(String exerciseFilePath) 
	{
		this.exerciseFilePath = exerciseFilePath;
	}

	public String getExerciseFilePath() 
	{
		return exerciseFilePath;
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
            .append("contingencyPlan", getContingencyPlan())
            .append("exerciseContent", getExerciseContent())
            .append("exerciseName", getExerciseName())
            .append("effectEvaluation", getEffectEvaluation())
            .append("exerciseDate", getExerciseDate())
            .append("commandingOfficer", getCommandingOfficer())
            .append("exerciseType", getExerciseType())
            .append("participantsNum", getParticipantsNum())
            .append("participantsLevl", getParticipantsLevl())
            .append("checkInNum", getCheckInNum())
            .append("exercisePlace", getExercisePlace())
            .append("exerciseFilePath", getExerciseFilePath())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
