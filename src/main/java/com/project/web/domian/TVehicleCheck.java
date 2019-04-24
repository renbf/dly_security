package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.project.common.base.BaseEntity;

import java.util.Date;

/**
 * 车辆例检表 t_vehicle_check
 * 
 * @author rbf
 * @date 2019-04-17
 */
public class TVehicleCheck extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private String id;
	/** 例检类型 */
	private String checkType;
	/** 车辆牌照 */
	private String vehicleLicence;
	/** 驾驶员 */
	private String driver;
	/** 例检时间 */
	private Date ckeckDate;
	/** 检查结果 */
	private String checkResult;
	/** 检查有效期 */
	private Date checkValidity;
	/** 车上例检员 */
	private String vehicleUpDriver;
	/** 车下例检员 */
	private String vehicleDownDriver;
	/** 微机操作员 */
	private String microcomputerOperator;
	/** 不合格内容 */
	private String unqualifiedInfo;
	/** 创建日期 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
	/** 创建人ID */
	private Long userId;
	/** 企业ID */
	private String businessId;

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setCheckType(String checkType) 
	{
		this.checkType = checkType;
	}

	public String getCheckType() 
	{
		return checkType;
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
	public void setCkeckDate(Date ckeckDate) 
	{
		this.ckeckDate = ckeckDate;
	}

	public Date getCkeckDate() 
	{
		return ckeckDate;
	}
	public void setCheckResult(String checkResult) 
	{
		this.checkResult = checkResult;
	}

	public String getCheckResult() 
	{
		return checkResult;
	}
	public void setCheckValidity(Date checkValidity) 
	{
		this.checkValidity = checkValidity;
	}

	public Date getCheckValidity() 
	{
		return checkValidity;
	}
	public void setVehicleUpDriver(String vehicleUpDriver) 
	{
		this.vehicleUpDriver = vehicleUpDriver;
	}

	public String getVehicleUpDriver() 
	{
		return vehicleUpDriver;
	}
	public void setVehicleDownDriver(String vehicleDownDriver) 
	{
		this.vehicleDownDriver = vehicleDownDriver;
	}

	public String getVehicleDownDriver() 
	{
		return vehicleDownDriver;
	}
	public void setMicrocomputerOperator(String microcomputerOperator) 
	{
		this.microcomputerOperator = microcomputerOperator;
	}

	public String getMicrocomputerOperator() 
	{
		return microcomputerOperator;
	}
	public void setUnqualifiedInfo(String unqualifiedInfo) 
	{
		this.unqualifiedInfo = unqualifiedInfo;
	}

	public String getUnqualifiedInfo() 
	{
		return unqualifiedInfo;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("checkType", getCheckType())
            .append("vehicleLicence", getVehicleLicence())
            .append("driver", getDriver())
            .append("ckeckDate", getCkeckDate())
            .append("checkResult", getCheckResult())
            .append("checkValidity", getCheckValidity())
            .append("vehicleUpDriver", getVehicleUpDriver())
            .append("vehicleDownDriver", getVehicleDownDriver())
            .append("microcomputerOperator", getMicrocomputerOperator())
            .append("unqualifiedInfo", getUnqualifiedInfo())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("businessId", getBusinessId())
            .toString();
    }
}
