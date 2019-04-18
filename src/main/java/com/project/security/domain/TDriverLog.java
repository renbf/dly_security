package com.project.security.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;
import java.util.Date;

/**
 * 行车日志基础表 t_driver_log
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TDriverLog implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 填报日期 */
	private Date writeTime;
	/** 车牌号 */
	private String carNumber;
	/** 核载吨位 */
	private String idealTonnage;
	/** 实载吨位 */
	private String actualTonnage;
	/** 货物名称 */
	private String goodsName;
	/** 类项 */
	private String type;
	/** 启运地 */
	private String transporAddress;
	/** 目的地 */
	private String goalAddress;
	/** 启运日期 */
	private Date transportDate;
	/** 到达日期 */
	private Date arriveDate;
	/** 里程 */
	private String km;
	/** 车辆状态0行车前1行车中2行车后 */
	private String status;
	/** 驾驶员1 */
	private String firstDriverId;
	/** 驾驶员2 */
	private String secondDriverId;
	/** 押运员 */
	private String escortId;
	/** 气温 */
	private String temperature;
	/** 天气 */
	private String weather;
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
	public void setWriteTime(Date writeTime) 
	{
		this.writeTime = writeTime;
	}

	public Date getWriteTime() 
	{
		return writeTime;
	}
	public void setCarNumber(String carNumber) 
	{
		this.carNumber = carNumber;
	}

	public String getCarNumber() 
	{
		return carNumber;
	}
	public void setIdealTonnage(String idealTonnage) 
	{
		this.idealTonnage = idealTonnage;
	}

	public String getIdealTonnage() 
	{
		return idealTonnage;
	}
	public void setActualTonnage(String actualTonnage) 
	{
		this.actualTonnage = actualTonnage;
	}

	public String getActualTonnage() 
	{
		return actualTonnage;
	}
	public void setGoodsName(String goodsName) 
	{
		this.goodsName = goodsName;
	}

	public String getGoodsName() 
	{
		return goodsName;
	}
	public void setType(String type) 
	{
		this.type = type;
	}

	public String getType() 
	{
		return type;
	}
	public void setTransporAddress(String transporAddress) 
	{
		this.transporAddress = transporAddress;
	}

	public String getTransporAddress() 
	{
		return transporAddress;
	}
	public void setGoalAddress(String goalAddress) 
	{
		this.goalAddress = goalAddress;
	}

	public String getGoalAddress() 
	{
		return goalAddress;
	}
	public void setTransportDate(Date transportDate) 
	{
		this.transportDate = transportDate;
	}

	public Date getTransportDate() 
	{
		return transportDate;
	}
	public void setArriveDate(Date arriveDate) 
	{
		this.arriveDate = arriveDate;
	}

	public Date getArriveDate() 
	{
		return arriveDate;
	}
	public void setKm(String km) 
	{
		this.km = km;
	}

	public String getKm() 
	{
		return km;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setFirstDriverId(String firstDriverId) 
	{
		this.firstDriverId = firstDriverId;
	}

	public String getFirstDriverId() 
	{
		return firstDriverId;
	}
	public void setSecondDriverId(String secondDriverId) 
	{
		this.secondDriverId = secondDriverId;
	}

	public String getSecondDriverId() 
	{
		return secondDriverId;
	}
	public void setEscortId(String escortId) 
	{
		this.escortId = escortId;
	}

	public String getEscortId() 
	{
		return escortId;
	}
	public void setTemperature(String temperature) 
	{
		this.temperature = temperature;
	}

	public String getTemperature() 
	{
		return temperature;
	}
	public void setWeather(String weather) 
	{
		this.weather = weather;
	}

	public String getWeather() 
	{
		return weather;
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
            .append("writeTime", getWriteTime())
            .append("carNumber", getCarNumber())
            .append("idealTonnage", getIdealTonnage())
            .append("actualTonnage", getActualTonnage())
            .append("goodsName", getGoodsName())
            .append("type", getType())
            .append("transporAddress", getTransporAddress())
            .append("goalAddress", getGoalAddress())
            .append("transportDate", getTransportDate())
            .append("arriveDate", getArriveDate())
            .append("km", getKm())
            .append("status", getStatus())
            .append("firstDriverId", getFirstDriverId())
            .append("secondDriverId", getSecondDriverId())
            .append("escortId", getEscortId())
            .append("temperature", getTemperature())
            .append("weather", getWeather())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
