package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 行为观察表 t_behavior_observation
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TBehaviorObservation extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String id;
	/** 观察时间 */
	private Date observationDate;
	/** 观察人 */
	private String observationPer;
	/** 观察区域 */
	private String observationRegion;
	/** 观察对象 */
	private String observationObj;
	/** 作业名称 */
	private String observationName;
	/** 员工反映 */
	private String observationPerFy;
	/** 员工位置 */
	private String observationPerPosition;
	/** 个人防护 */
	private String observationPerProtection;
	/** 工具与设置 */
	private String observationPerTool;
	/** 程序与标准 */
	private String observationPerProgram;
	/** 人体功效 */
	private String observationPerEffect;
	/** 现场秩序 */
	private String observationPerZx;
	/** 观察对话 */
	private String observationDh;
	/** 后续整改 */
	private String observationRectification;
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
	public void setObservationDate(Date observationDate) 
	{
		this.observationDate = observationDate;
	}

	public Date getObservationDate() 
	{
		return observationDate;
	}
	public void setObservationPer(String observationPer) 
	{
		this.observationPer = observationPer;
	}

	public String getObservationPer() 
	{
		return observationPer;
	}
	public void setObservationRegion(String observationRegion) 
	{
		this.observationRegion = observationRegion;
	}

	public String getObservationRegion() 
	{
		return observationRegion;
	}
	public void setObservationObj(String observationObj) 
	{
		this.observationObj = observationObj;
	}

	public String getObservationObj() 
	{
		return observationObj;
	}
	public void setObservationName(String observationName) 
	{
		this.observationName = observationName;
	}

	public String getObservationName() 
	{
		return observationName;
	}
	public void setObservationPerFy(String observationPerFy) 
	{
		this.observationPerFy = observationPerFy;
	}

	public String getObservationPerFy() 
	{
		return observationPerFy;
	}
	public void setObservationPerPosition(String observationPerPosition) 
	{
		this.observationPerPosition = observationPerPosition;
	}

	public String getObservationPerPosition() 
	{
		return observationPerPosition;
	}
	public void setObservationPerProtection(String observationPerProtection) 
	{
		this.observationPerProtection = observationPerProtection;
	}

	public String getObservationPerProtection() 
	{
		return observationPerProtection;
	}
	public void setObservationPerTool(String observationPerTool) 
	{
		this.observationPerTool = observationPerTool;
	}

	public String getObservationPerTool() 
	{
		return observationPerTool;
	}
	public void setObservationPerProgram(String observationPerProgram) 
	{
		this.observationPerProgram = observationPerProgram;
	}

	public String getObservationPerProgram() 
	{
		return observationPerProgram;
	}
	public void setObservationPerEffect(String observationPerEffect) 
	{
		this.observationPerEffect = observationPerEffect;
	}

	public String getObservationPerEffect() 
	{
		return observationPerEffect;
	}
	public void setObservationPerZx(String observationPerZx) 
	{
		this.observationPerZx = observationPerZx;
	}

	public String getObservationPerZx() 
	{
		return observationPerZx;
	}
	public void setObservationDh(String observationDh) 
	{
		this.observationDh = observationDh;
	}

	public String getObservationDh() 
	{
		return observationDh;
	}
	public void setObservationRectification(String observationRectification) 
	{
		this.observationRectification = observationRectification;
	}

	public String getObservationRectification() 
	{
		return observationRectification;
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
            .append("observationDate", getObservationDate())
            .append("observationPer", getObservationPer())
            .append("observationRegion", getObservationRegion())
            .append("observationObj", getObservationObj())
            .append("observationName", getObservationName())
            .append("observationPerFy", getObservationPerFy())
            .append("observationPerPosition", getObservationPerPosition())
            .append("observationPerProtection", getObservationPerProtection())
            .append("observationPerTool", getObservationPerTool())
            .append("observationPerProgram", getObservationPerProgram())
            .append("observationPerEffect", getObservationPerEffect())
            .append("observationPerZx", getObservationPerZx())
            .append("observationDh", getObservationDh())
            .append("observationRectification", getObservationRectification())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("meno", getMeno())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
