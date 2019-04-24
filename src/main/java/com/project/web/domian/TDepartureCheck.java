package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 出站例检表 t_departure_check
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TDepartureCheck extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 车辆牌照 */
	private String vehicleLicence;
	/** 驾驶员 */
	private String driver;
	/** 打单时间 */
	private Date intimidateDate;
	/** 售票座位数 */
	private Integer ticketingSeatNum;
	/** 实载人数 */
	private Integer actualNum;
	/** 半票人数 */
	private Integer halfTicketNum;
	/** 免票人数 */
	private Integer freeTicketNum;
	/** 线路名称 */
	private String lineName;
	/** 班次日期 */
	private Date shiftsDate;
	/** 班次号 */
	private String shiftsNum;
	/** 班次类型 */
	private String shiftsType;
	/** 天气 */
	private String weather;
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
	public void setDriver(String driver) 
	{
		this.driver = driver;
	}

	public String getDriver() 
	{
		return driver;
	}
	public void setIntimidateDate(Date intimidateDate) 
	{
		this.intimidateDate = intimidateDate;
	}

	public Date getIntimidateDate() 
	{
		return intimidateDate;
	}
	public void setTicketingSeatNum(Integer ticketingSeatNum) 
	{
		this.ticketingSeatNum = ticketingSeatNum;
	}

	public Integer getTicketingSeatNum() 
	{
		return ticketingSeatNum;
	}
	public void setActualNum(Integer actualNum) 
	{
		this.actualNum = actualNum;
	}

	public Integer getActualNum() 
	{
		return actualNum;
	}
	public void setHalfTicketNum(Integer halfTicketNum) 
	{
		this.halfTicketNum = halfTicketNum;
	}

	public Integer getHalfTicketNum() 
	{
		return halfTicketNum;
	}
	public void setFreeTicketNum(Integer freeTicketNum) 
	{
		this.freeTicketNum = freeTicketNum;
	}

	public Integer getFreeTicketNum() 
	{
		return freeTicketNum;
	}
	public void setLineName(String lineName) 
	{
		this.lineName = lineName;
	}

	public String getLineName() 
	{
		return lineName;
	}
	public void setShiftsDate(Date shiftsDate) 
	{
		this.shiftsDate = shiftsDate;
	}

	public Date getShiftsDate() 
	{
		return shiftsDate;
	}
	public void setShiftsNum(String shiftsNum) 
	{
		this.shiftsNum = shiftsNum;
	}

	public String getShiftsNum() 
	{
		return shiftsNum;
	}
	public void setShiftsType(String shiftsType) 
	{
		this.shiftsType = shiftsType;
	}

	public String getShiftsType() 
	{
		return shiftsType;
	}
	public void setWeather(String weather) 
	{
		this.weather = weather;
	}

	public String getWeather() 
	{
		return weather;
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
            .append("driver", getDriver())
            .append("intimidateDate", getIntimidateDate())
            .append("ticketingSeatNum", getTicketingSeatNum())
            .append("actualNum", getActualNum())
            .append("halfTicketNum", getHalfTicketNum())
            .append("freeTicketNum", getFreeTicketNum())
            .append("lineName", getLineName())
            .append("shiftsDate", getShiftsDate())
            .append("shiftsNum", getShiftsNum())
            .append("shiftsType", getShiftsType())
            .append("weather", getWeather())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
