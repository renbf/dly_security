package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 未报班车辆表 t_out_newspaper_class_vehicle
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TOutNewspaperClassVehicle extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 车辆牌照 */
	private String vehicleLicence;
	/** 最后班次号 */
	private String lastShiftsNum;
	/** 最后班次类型 */
	private String lastShiftsType;
	/** 最后报班人 */
	private String lastDriver;
	/** 最后班次日期 */
	private Date lastShiftsDate;
	/** 最后报班时间 */
	private Date lastNewspaperClassDate;
	/** 距今多少天 */
	private String distanceDay;
	/** 最后线路名称 */
	private String lastLineName;
	/** 所属机构 */
	private String deptId;
	/** 创建日期 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
	/** 创建人ID */
	private Long userId;
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
	public void setVehicleLicence(String vehicleLicence) 
	{
		this.vehicleLicence = vehicleLicence;
	}

	public String getVehicleLicence() 
	{
		return vehicleLicence;
	}
	public void setLastShiftsNum(String lastShiftsNum) 
	{
		this.lastShiftsNum = lastShiftsNum;
	}

	public String getLastShiftsNum() 
	{
		return lastShiftsNum;
	}
	public void setLastShiftsType(String lastShiftsType) 
	{
		this.lastShiftsType = lastShiftsType;
	}

	public String getLastShiftsType() 
	{
		return lastShiftsType;
	}
	public void setLastDriver(String lastDriver) 
	{
		this.lastDriver = lastDriver;
	}

	public String getLastDriver() 
	{
		return lastDriver;
	}
	public void setLastShiftsDate(Date lastShiftsDate) 
	{
		this.lastShiftsDate = lastShiftsDate;
	}

	public Date getLastShiftsDate() 
	{
		return lastShiftsDate;
	}
	public void setLastNewspaperClassDate(Date lastNewspaperClassDate) 
	{
		this.lastNewspaperClassDate = lastNewspaperClassDate;
	}

	public Date getLastNewspaperClassDate() 
	{
		return lastNewspaperClassDate;
	}
	public void setDistanceDay(String distanceDay) 
	{
		this.distanceDay = distanceDay;
	}

	public String getDistanceDay() 
	{
		return distanceDay;
	}
	public void setLastLineName(String lastLineName) 
	{
		this.lastLineName = lastLineName;
	}

	public String getLastLineName() 
	{
		return lastLineName;
	}
	public void setDeptId(String deptId) 
	{
		this.deptId = deptId;
	}

	public String getDeptId() 
	{
		return deptId;
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
            .append("vehicleLicence", getVehicleLicence())
            .append("lastShiftsNum", getLastShiftsNum())
            .append("lastShiftsType", getLastShiftsType())
            .append("lastDriver", getLastDriver())
            .append("lastShiftsDate", getLastShiftsDate())
            .append("lastNewspaperClassDate", getLastNewspaperClassDate())
            .append("distanceDay", getDistanceDay())
            .append("lastLineName", getLastLineName())
            .append("deptId", getDeptId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
