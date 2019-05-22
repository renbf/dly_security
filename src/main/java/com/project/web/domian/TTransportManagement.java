package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 客运管理表 t_transport_management
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TTransportManagement extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 运行路线 */
	private String lineName;
	/** 起点 */
	private String startCity;
	/** 终点 */
	private String endCity;
	/** 高速 */
	private String highSpeed;
	/** 非高速 */
	private String notHighSpeed;
	/** 总里程 */
	private String allMileage;
	/** 线路类别 */
	private String lineType;
	/** 线路等级 */
	private String lineLevel;
	/** 是否为超长路线  0:否  1：是 */
	private String isSuperLong;
	/** 起点站 */
	private String statrStation;
	/** 终点站 */
	private String endStation;
	/** 日发班次 */
	private String dayVehicle;
	/** 许可日期 */
	private Date permitDate;
	/** 许可有效期 */
	private Date permitValidityDate;
	/** 班车类型 */
	private String shiftsType;
	/** 日营运里程 */
	private String dayMileage;
	/** 所属机构(部门) */
	private Long deptId;
	/** 途径车站 */
	private String passByStation;
	/** 停靠站 */
	private String stopStation;
	/** 文件路径 */
	private String filePath;
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
	
	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public void setLineName(String lineName) 
	{
		this.lineName = lineName;
	}

	public String getLineName() 
	{
		return lineName;
	}
	public void setStartCity(String startCity) 
	{
		this.startCity = startCity;
	}

	public String getStartCity() 
	{
		return startCity;
	}
	public void setEndCity(String endCity) 
	{
		this.endCity = endCity;
	}

	public String getEndCity() 
	{
		return endCity;
	}
	public void setHighSpeed(String highSpeed) 
	{
		this.highSpeed = highSpeed;
	}

	public String getHighSpeed() 
	{
		return highSpeed;
	}
	public void setNotHighSpeed(String notHighSpeed) 
	{
		this.notHighSpeed = notHighSpeed;
	}

	public String getNotHighSpeed() 
	{
		return notHighSpeed;
	}
	public void setAllMileage(String allMileage) 
	{
		this.allMileage = allMileage;
	}

	public String getAllMileage() 
	{
		return allMileage;
	}
	public void setLineType(String lineType) 
	{
		this.lineType = lineType;
	}

	public String getLineType() 
	{
		return lineType;
	}
	public void setLineLevel(String lineLevel) 
	{
		this.lineLevel = lineLevel;
	}

	public String getLineLevel() 
	{
		return lineLevel;
	}
	public void setIsSuperLong(String isSuperLong) 
	{
		this.isSuperLong = isSuperLong;
	}

	public String getIsSuperLong() 
	{
		return isSuperLong;
	}
	public void setStatrStation(String statrStation) 
	{
		this.statrStation = statrStation;
	}

	public String getStatrStation() 
	{
		return statrStation;
	}
	public void setEndStation(String endStation) 
	{
		this.endStation = endStation;
	}

	public String getEndStation() 
	{
		return endStation;
	}
	public void setDayVehicle(String dayVehicle) 
	{
		this.dayVehicle = dayVehicle;
	}

	public String getDayVehicle() 
	{
		return dayVehicle;
	}
	public void setPermitDate(Date permitDate) 
	{
		this.permitDate = permitDate;
	}

	public Date getPermitDate() 
	{
		return permitDate;
	}
	public void setPermitValidityDate(Date permitValidityDate) 
	{
		this.permitValidityDate = permitValidityDate;
	}

	public Date getPermitValidityDate() 
	{
		return permitValidityDate;
	}
	public void setShiftsType(String shiftsType) 
	{
		this.shiftsType = shiftsType;
	}

	public String getShiftsType() 
	{
		return shiftsType;
	}
	public void setDayMileage(String dayMileage) 
	{
		this.dayMileage = dayMileage;
	}

	public String getDayMileage() 
	{
		return dayMileage;
	}

	public void setPassByStation(String passByStation) 
	{
		this.passByStation = passByStation;
	}

	public String getPassByStation() 
	{
		return passByStation;
	}
	public void setStopStation(String stopStation) 
	{
		this.stopStation = stopStation;
	}

	public String getStopStation() 
	{
		return stopStation;
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
            .append("lineName", getLineName())
            .append("startCity", getStartCity())
            .append("endCity", getEndCity())
            .append("highSpeed", getHighSpeed())
            .append("notHighSpeed", getNotHighSpeed())
            .append("allMileage", getAllMileage())
            .append("lineType", getLineType())
            .append("lineLevel", getLineLevel())
            .append("isSuperLong", getIsSuperLong())
            .append("statrStation", getStatrStation())
            .append("endStation", getEndStation())
            .append("dayVehicle", getDayVehicle())
            .append("permitDate", getPermitDate())
            .append("permitValidityDate", getPermitValidityDate())
            .append("shiftsType", getShiftsType())
            .append("dayMileage", getDayMileage())
            .append("passByStation", getPassByStation())
            .append("stopStation", getStopStation())
            .append("filePath", getFilePath())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("businessId", getBusinessId())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
