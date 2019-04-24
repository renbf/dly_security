package com.project.web.domian;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.project.common.base.BaseEntity;
import java.util.Date;

/**
 * 车辆表 t_car_info
 * 
 * @author rbf
 * @date 2019-04-23
 */
public class TCarInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private String id;
	/** 车牌号 */
	private String carNumber;
	/** 车辆类型 */
	private String carType;
	/** 厂牌型号 */
	private String brandModel;
	/** 制造厂名 */
	private String factoryName;
	/** 出厂日期 */
	private Date completeDate;
	/** 国产/进口 */
	private String inOrOut;
	/** VIN(或车架)号 */
	private String vinNumber;
	/** 底盘型号 */
	private String chassisModel;
	/** 车辆外廓尺寸 */
	private String outsideSize;
	/** 货箱内尺寸或容积 */
	private String insideSize;
	/** 总质量 */
	private String totalKg;
	/** 整备质量 */
	private String equipmentKg;
	/** 准牵引质量 */
	private String towKg;
	/** 核定载质量 */
	private String idealKg;
	/** 核定载客 */
	private String idealCount;
	/** 发动机型号 */
	private String motorModel;
	/** 发动机号码 */
	private String motorNumber;
	/** 发动机排量 */
	private String motorOutputVolume;
	/** 发动机净功率 */
	private String motorCleanPower;
	/** 排放标准 */
	private String dischargeStandard;
	/** 电池类型 */
	private String batteryType;
	/** 驱动电机型号 */
	private String drivingMotorModel;
	/** 电机功率 */
	private String motorPower;
	/** 动力类型 */
	private String powerType;
	/** 车轴数量 */
	private Integer axleNum;
	/** 轴距mm */
	private String axleDistance;
	/** 轮胎数/规格 */
	private String tyreNum;
	/** 车制动方式 */
	private String brakingType;
	/** 制动器形式前轮 */
	private String isFrontWheel;
	/** 制动器形式后轮 */
	private String isRearWheel;
	/** 制动防抱死系统（ABS） */
	private String isAbs;
	/** 变速器形式 */
	private String transmissionType;
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
	public void setCarNumber(String carNumber) 
	{
		this.carNumber = carNumber;
	}

	public String getCarNumber() 
	{
		return carNumber;
	}
	public void setCarType(String carType) 
	{
		this.carType = carType;
	}

	public String getCarType() 
	{
		return carType;
	}
	public void setBrandModel(String brandModel) 
	{
		this.brandModel = brandModel;
	}

	public String getBrandModel() 
	{
		return brandModel;
	}
	public void setFactoryName(String factoryName) 
	{
		this.factoryName = factoryName;
	}

	public String getFactoryName() 
	{
		return factoryName;
	}
	public void setCompleteDate(Date completeDate) 
	{
		this.completeDate = completeDate;
	}

	public Date getCompleteDate() 
	{
		return completeDate;
	}
	public void setInOrOut(String inOrOut) 
	{
		this.inOrOut = inOrOut;
	}

	public String getInOrOut() 
	{
		return inOrOut;
	}
	public void setVinNumber(String vinNumber) 
	{
		this.vinNumber = vinNumber;
	}

	public String getVinNumber() 
	{
		return vinNumber;
	}
	public void setChassisModel(String chassisModel) 
	{
		this.chassisModel = chassisModel;
	}

	public String getChassisModel() 
	{
		return chassisModel;
	}
	public void setOutsideSize(String outsideSize) 
	{
		this.outsideSize = outsideSize;
	}

	public String getOutsideSize() 
	{
		return outsideSize;
	}
	public void setInsideSize(String insideSize) 
	{
		this.insideSize = insideSize;
	}

	public String getInsideSize() 
	{
		return insideSize;
	}
	public void setTotalKg(String totalKg) 
	{
		this.totalKg = totalKg;
	}

	public String getTotalKg() 
	{
		return totalKg;
	}
	public void setEquipmentKg(String equipmentKg) 
	{
		this.equipmentKg = equipmentKg;
	}

	public String getEquipmentKg() 
	{
		return equipmentKg;
	}
	public void setTowKg(String towKg) 
	{
		this.towKg = towKg;
	}

	public String getTowKg() 
	{
		return towKg;
	}
	public void setIdealKg(String idealKg) 
	{
		this.idealKg = idealKg;
	}

	public String getIdealKg() 
	{
		return idealKg;
	}
	public void setIdealCount(String idealCount) 
	{
		this.idealCount = idealCount;
	}

	public String getIdealCount() 
	{
		return idealCount;
	}
	public void setMotorModel(String motorModel) 
	{
		this.motorModel = motorModel;
	}

	public String getMotorModel() 
	{
		return motorModel;
	}
	public void setMotorNumber(String motorNumber) 
	{
		this.motorNumber = motorNumber;
	}

	public String getMotorNumber() 
	{
		return motorNumber;
	}
	public void setMotorOutputVolume(String motorOutputVolume) 
	{
		this.motorOutputVolume = motorOutputVolume;
	}

	public String getMotorOutputVolume() 
	{
		return motorOutputVolume;
	}
	public void setMotorCleanPower(String motorCleanPower) 
	{
		this.motorCleanPower = motorCleanPower;
	}

	public String getMotorCleanPower() 
	{
		return motorCleanPower;
	}
	public void setDischargeStandard(String dischargeStandard) 
	{
		this.dischargeStandard = dischargeStandard;
	}

	public String getDischargeStandard() 
	{
		return dischargeStandard;
	}
	public void setBatteryType(String batteryType) 
	{
		this.batteryType = batteryType;
	}

	public String getBatteryType() 
	{
		return batteryType;
	}
	public void setDrivingMotorModel(String drivingMotorModel) 
	{
		this.drivingMotorModel = drivingMotorModel;
	}

	public String getDrivingMotorModel() 
	{
		return drivingMotorModel;
	}
	public void setMotorPower(String motorPower) 
	{
		this.motorPower = motorPower;
	}

	public String getMotorPower() 
	{
		return motorPower;
	}
	public void setPowerType(String powerType) 
	{
		this.powerType = powerType;
	}

	public String getPowerType() 
	{
		return powerType;
	}
	public void setAxleNum(Integer axleNum) 
	{
		this.axleNum = axleNum;
	}

	public Integer getAxleNum() 
	{
		return axleNum;
	}
	public void setAxleDistance(String axleDistance) 
	{
		this.axleDistance = axleDistance;
	}

	public String getAxleDistance() 
	{
		return axleDistance;
	}
	public void setTyreNum(String tyreNum) 
	{
		this.tyreNum = tyreNum;
	}

	public String getTyreNum() 
	{
		return tyreNum;
	}
	public void setBrakingType(String brakingType) 
	{
		this.brakingType = brakingType;
	}

	public String getBrakingType() 
	{
		return brakingType;
	}
	public void setIsFrontWheel(String isFrontWheel) 
	{
		this.isFrontWheel = isFrontWheel;
	}

	public String getIsFrontWheel() 
	{
		return isFrontWheel;
	}
	public void setIsRearWheel(String isRearWheel) 
	{
		this.isRearWheel = isRearWheel;
	}

	public String getIsRearWheel() 
	{
		return isRearWheel;
	}
	public void setIsAbs(String isAbs) 
	{
		this.isAbs = isAbs;
	}

	public String getIsAbs() 
	{
		return isAbs;
	}
	public void setTransmissionType(String transmissionType) 
	{
		this.transmissionType = transmissionType;
	}

	public String getTransmissionType() 
	{
		return transmissionType;
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
            .append("carNumber", getCarNumber())
            .append("carType", getCarType())
            .append("brandModel", getBrandModel())
            .append("factoryName", getFactoryName())
            .append("completeDate", getCompleteDate())
            .append("inOrOut", getInOrOut())
            .append("vinNumber", getVinNumber())
            .append("chassisModel", getChassisModel())
            .append("outsideSize", getOutsideSize())
            .append("insideSize", getInsideSize())
            .append("totalKg", getTotalKg())
            .append("equipmentKg", getEquipmentKg())
            .append("towKg", getTowKg())
            .append("idealKg", getIdealKg())
            .append("idealCount", getIdealCount())
            .append("motorModel", getMotorModel())
            .append("motorNumber", getMotorNumber())
            .append("motorOutputVolume", getMotorOutputVolume())
            .append("motorCleanPower", getMotorCleanPower())
            .append("dischargeStandard", getDischargeStandard())
            .append("batteryType", getBatteryType())
            .append("drivingMotorModel", getDrivingMotorModel())
            .append("motorPower", getMotorPower())
            .append("powerType", getPowerType())
            .append("axleNum", getAxleNum())
            .append("axleDistance", getAxleDistance())
            .append("tyreNum", getTyreNum())
            .append("brakingType", getBrakingType())
            .append("isFrontWheel", getIsFrontWheel())
            .append("isRearWheel", getIsRearWheel())
            .append("isAbs", getIsAbs())
            .append("transmissionType", getTransmissionType())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .toString();
    }
}
