package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 培训记录表 t_training_record
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TTrainingRecord extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 培训主题 */
	private String trainTheme;
	/** 培训应到人数 */
	private Integer trainSholudNum;
	/** 培训实到人数 */
	private Integer trainActNum;
	/** 培训内容 */
	private String trainInfo;
	/** 培训日期 */
	private Date trainDate;
	/** 是否考试 0:未安排考试  1:安排考试 */
	private String isExamination;
	/** 培训级别 1:公司  2:部门   3:岗位 */
	private String trainLevel;
	/** 培训课时 */
	private Integer trainHour;
	/** 效果评价 */
	private String trainEffect;
	/** 评价人 */
	private String trainEffectPer;
	/** 评价时间 */
	private Date trainEffectDate;
	/** 培训人员user_id */
	private Long trainUserId;
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
	public void setTrainTheme(String trainTheme) 
	{
		this.trainTheme = trainTheme;
	}

	public String getTrainTheme() 
	{
		return trainTheme;
	}
	public void setTrainSholudNum(Integer trainSholudNum) 
	{
		this.trainSholudNum = trainSholudNum;
	}

	public Integer getTrainSholudNum() 
	{
		return trainSholudNum;
	}
	public void setTrainActNum(Integer trainActNum) 
	{
		this.trainActNum = trainActNum;
	}

	public Integer getTrainActNum() 
	{
		return trainActNum;
	}
	public void setTrainInfo(String trainInfo) 
	{
		this.trainInfo = trainInfo;
	}

	public String getTrainInfo() 
	{
		return trainInfo;
	}
	public void setTrainDate(Date trainDate) 
	{
		this.trainDate = trainDate;
	}

	public Date getTrainDate() 
	{
		return trainDate;
	}
	public void setIsExamination(String isExamination) 
	{
		this.isExamination = isExamination;
	}

	public String getIsExamination() 
	{
		return isExamination;
	}
	public void setTrainLevel(String trainLevel) 
	{
		this.trainLevel = trainLevel;
	}

	public String getTrainLevel() 
	{
		return trainLevel;
	}
	public void setTrainHour(Integer trainHour) 
	{
		this.trainHour = trainHour;
	}

	public Integer getTrainHour() 
	{
		return trainHour;
	}
	public void setTrainEffect(String trainEffect) 
	{
		this.trainEffect = trainEffect;
	}

	public String getTrainEffect() 
	{
		return trainEffect;
	}
	public void setTrainEffectPer(String trainEffectPer) 
	{
		this.trainEffectPer = trainEffectPer;
	}

	public String getTrainEffectPer() 
	{
		return trainEffectPer;
	}
	public void setTrainEffectDate(Date trainEffectDate) 
	{
		this.trainEffectDate = trainEffectDate;
	}

	public Date getTrainEffectDate() 
	{
		return trainEffectDate;
	}
	public void setTrainUserId(Long trainUserId) 
	{
		this.trainUserId = trainUserId;
	}

	public Long getTrainUserId() 
	{
		return trainUserId;
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
            .append("trainTheme", getTrainTheme())
            .append("trainSholudNum", getTrainSholudNum())
            .append("trainActNum", getTrainActNum())
            .append("trainInfo", getTrainInfo())
            .append("trainDate", getTrainDate())
            .append("isExamination", getIsExamination())
            .append("trainLevel", getTrainLevel())
            .append("trainHour", getTrainHour())
            .append("trainEffect", getTrainEffect())
            .append("trainEffectPer", getTrainEffectPer())
            .append("trainEffectDate", getTrainEffectDate())
            .append("trainUserId", getTrainUserId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
