package com.project.security.domain.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 行车后检查事项表 t_driver_after_log
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TDriverAfterLogVo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 行车日志ID */
	private String driverLogId;
	/** 填报日期 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date writeTime;
	/** 检查事项 */
	private String carCheckProject;
	/** 故障处理 */
	private String faultHandling;
	/** 签名照片 */
	private String autograph;
	/** 行车照片 */
	private String drivingPhoto;
	/** 始发站 */
	private String startFromStation;
	/** 始发检查情况 */
	private String startFromCheck;
	/** 途中检查地点 */
	private String enRouteAddress;
	/** 途中检查情况 */
	private String enRouteCheck;
	/** 创建人id */
	private String addUserId;
	/** 创建时间 */
	private Date createDate;
	/** 修改时间 */
	private Date updateDate;
	/** 修改人id */
	private String updateUserId;
	/** 检查事项 */
	private List<TDictView> carCheckProjectList;
	
	public void setDriverLogId(String driverLogId) 
	{
		this.driverLogId = driverLogId;
	}

	public String getDriverLogId() 
	{
		return driverLogId;
	}
	public void setWriteTime(Date writeTime) 
	{
		this.writeTime = writeTime;
	}

	public Date getWriteTime() 
	{
		return writeTime;
	}
	public void setCarCheckProject(String carCheckProject) 
	{
		this.carCheckProject = carCheckProject;
	}

	public String getCarCheckProject() 
	{
		return carCheckProject;
	}
	public void setFaultHandling(String faultHandling) 
	{
		this.faultHandling = faultHandling;
	}

	public String getFaultHandling() 
	{
		return faultHandling;
	}
	public void setAutograph(String autograph) 
	{
		this.autograph = autograph;
	}

	public String getAutograph() 
	{
		return autograph;
	}
	public void setDrivingPhoto(String drivingPhoto) 
	{
		this.drivingPhoto = drivingPhoto;
	}

	public String getDrivingPhoto() 
	{
		return drivingPhoto;
	}
	public void setStartFromStation(String startFromStation) 
	{
		this.startFromStation = startFromStation;
	}

	public String getStartFromStation() 
	{
		return startFromStation;
	}
	public void setStartFromCheck(String startFromCheck) 
	{
		this.startFromCheck = startFromCheck;
	}

	public String getStartFromCheck() 
	{
		return startFromCheck;
	}
	public void setEnRouteAddress(String enRouteAddress) 
	{
		this.enRouteAddress = enRouteAddress;
	}

	public String getEnRouteAddress() 
	{
		return enRouteAddress;
	}
	public void setEnRouteCheck(String enRouteCheck) 
	{
		this.enRouteCheck = enRouteCheck;
	}

	public String getEnRouteCheck() 
	{
		return enRouteCheck;
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

    public List<TDictView> getCarCheckProjectList() {
		return carCheckProjectList;
	}

	public void setCarCheckProjectList(List<TDictView> carCheckProjectList) {
		this.carCheckProjectList = carCheckProjectList;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("driverLogId", getDriverLogId())
            .append("writeTime", getWriteTime())
            .append("carCheckProject", getCarCheckProject())
            .append("faultHandling", getFaultHandling())
            .append("autograph", getAutograph())
            .append("drivingPhoto", getDrivingPhoto())
            .append("startFromStation", getStartFromStation())
            .append("startFromCheck", getStartFromCheck())
            .append("enRouteAddress", getEnRouteAddress())
            .append("enRouteCheck", getEnRouteCheck())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
