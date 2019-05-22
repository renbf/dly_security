package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * 车辆表 t_car_info
 *
 * @author rbf
 * @date 2019-04-23
 */
public class TCarInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;
    /**
     * 车牌号      #$
     */
    private String carNumber;
    /**
     * 车辆类型     #$
     */
    private String carType;
    /**
     * 厂牌型号     #$
     */
    private String brandModel;
    /**
     * 制造厂名
     */
    private String factoryName;
    /**
     * 出厂日期     ##
     */
    private Date completeDate;
    /**
     * 国产/进口
     */
    private String inOrOut;
    /**
     * VIN(或车架)号
     */
    private String vinNumber;
    /**
     * 底盘型号
     */
    private String chassisModel;
    /**
     * 车辆外廓尺寸
     */
    private String outsideSize;
    /**
     * 货箱内尺寸或容积
     */
    private String insideSize;
    /**
     * 总质量
     */
    private String totalKg;
    /**
     * 整备质量
     */
    private String equipmentKg;
    /**
     * 准牵引质量
     */
    private String towKg;
    /**
     * 核定载质量
     */
    private String idealKg;
    /**
     * 核定载客
     */
    private String idealCount;
    /**
     * 发动机型号
     */
    private String motorModel;
    /**
     * 发动机号码
     */
    private String motorNumber;
    /**
     * 发动机排量
     */
    private String motorOutputVolume;
    /**
     * 发动机净功率
     */
    private String motorCleanPower;
    /**
     * 排放标准
     */
    private String dischargeStandard;
    /**
     * 电池类型
     */
    private String batteryType;
    /**
     * 驱动电机型号
     */
    private String drivingMotorModel;
    /**
     * 电机功率
     */
    private String motorPower;
    /**
     * 动力类型
     */
    private String powerType;
    /**
     * 车轴数量
     */
    private Integer axleNum;
    /**
     * 轴距mm
     */
    private String axleDistance;
    /**
     * 轮胎数/规格
     */
    private String tyreNum;
    /**
     * 车制动方式
     */
    private String brakingType;
    /**
     * 制动器形式前轮
     */
    private String frontWheelBraking;
    /**
     * 制动器形式后轮
     */
    private String rearWheelBraking;
    /**
     * 制动防抱死系统（ABS）
     */
    private String isAbs;
    /**
     * 变速器形式
     */
    private String transmissionType;
    /**
     * 车辆状态:(0:运营,1:停运,2:报废)
     */
    private String carStatus;
    /**
     * 图片附件地址
     */
    private String photoFilePath;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 创建人id
     */
    private String addUserId;
    /**
     * 备用字段
     */
    private String meno;
    /**
     * 企业ID
     */
    private String businessId;
    /**
     * 修改人id
     */
    private String updateUserId;


    /*查询输入新增*/
    private Date completeDate1;
    /*查询输出新增*/
    //运输证号
    private String roadTransportNumber;
    //运输证发证日期
    private Date roadTransportStartDate;
    private String roadTransportStartDateStr;
    //运输证有效期
    private Date roadTransportValidityDate;
    private String roadTransportValidityDateStr;
    //行驶证检测有效期
    private Date travelValidityDate;
    private String travelValidityDateStr;
    //承运人责任险有效期
    private Date carrierValidityDate;
    private String carrierValidityDateStr;
    //第三方责任险有效期
    private Date thirdPartyValidityDate;
    private String thirdPartyValidityDateStr;
    //交强险有效期
    private Date compulsoryValidityDate;
    private String compulsoryValidityDateStr;
    //车牌号变更表中的车牌号
    private String carLogNumber;

    /*增加输入新增*/
    private MultipartFile photoFile;

    /*增加输出新增*/


    /*一对多表*/
    //车牌号牌变更表
    private List<TCarLog> carLogs;
    //行驶证变更表
    private List<TDrivingLicenseLog> drivingLicenseLogs;
    //道路运输证变更表
    private List<TRoadTransportLog> roadTransportLogs;


    public String getCarLogNumber() {
        return carLogNumber;
    }

    public TCarInfo setCarLogNumber(String carLogNumber) {
        this.carLogNumber = carLogNumber;
        return this;
    }

    public Date getCompleteDate1() {
        return completeDate1;
    }

    public TCarInfo setCompleteDate1(Date completeDate1) {
        this.completeDate1 = completeDate1;
        return this;
    }

    public String getRoadTransportNumber() {
        return roadTransportNumber;
    }

    public TCarInfo setRoadTransportNumber(String roadTransportNumber) {
        this.roadTransportNumber = roadTransportNumber;
        return this;
    }

    public Date getRoadTransportStartDate() {
        return roadTransportStartDate;
    }

    public TCarInfo setRoadTransportStartDate(Date roadTransportStartDate) {
        this.roadTransportStartDate = roadTransportStartDate;
        return this;
    }

    public String getRoadTransportStartDateStr() {
        return roadTransportStartDateStr;
    }

    public TCarInfo setRoadTransportStartDateStr(String roadTransportStartDateStr) {
        this.roadTransportStartDateStr = roadTransportStartDateStr;
        return this;
    }

    public Date getRoadTransportValidityDate() {
        return roadTransportValidityDate;
    }

    public TCarInfo setRoadTransportValidityDate(Date roadTransportValidityDate) {
        this.roadTransportValidityDate = roadTransportValidityDate;
        return this;
    }

    public String getRoadTransportValidityDateStr() {
        return roadTransportValidityDateStr;
    }

    public TCarInfo setRoadTransportValidityDateStr(String roadTransportValidityDateStr) {
        this.roadTransportValidityDateStr = roadTransportValidityDateStr;
        return this;
    }

    public Date getTravelValidityDate() {
        return travelValidityDate;
    }

    public TCarInfo setTravelValidityDate(Date travelValidityDate) {
        this.travelValidityDate = travelValidityDate;
        return this;
    }

    public String getTravelValidityDateStr() {
        return travelValidityDateStr;
    }

    public TCarInfo setTravelValidityDateStr(String travelValidityDateStr) {
        this.travelValidityDateStr = travelValidityDateStr;
        return this;
    }

    public Date getCarrierValidityDate() {
        return carrierValidityDate;
    }

    public TCarInfo setCarrierValidityDate(Date carrierValidityDate) {
        this.carrierValidityDate = carrierValidityDate;
        return this;
    }

    public String getCarrierValidityDateStr() {
        return carrierValidityDateStr;
    }

    public TCarInfo setCarrierValidityDateStr(String carrierValidityDateStr) {
        this.carrierValidityDateStr = carrierValidityDateStr;
        return this;
    }

    public Date getThirdPartyValidityDate() {
        return thirdPartyValidityDate;
    }

    public TCarInfo setThirdPartyValidityDate(Date thirdPartyValidityDate) {
        this.thirdPartyValidityDate = thirdPartyValidityDate;
        return this;
    }

    public String getThirdPartyValidityDateStr() {
        return thirdPartyValidityDateStr;
    }

    public TCarInfo setThirdPartyValidityDateStr(String thirdPartyValidityDateStr) {
        this.thirdPartyValidityDateStr = thirdPartyValidityDateStr;
        return this;
    }

    public Date getCompulsoryValidityDate() {
        return compulsoryValidityDate;
    }

    public TCarInfo setCompulsoryValidityDate(Date compulsoryValidityDate) {
        this.compulsoryValidityDate = compulsoryValidityDate;
        return this;
    }

    public String getCompulsoryValidityDateStr() {
        return compulsoryValidityDateStr;
    }

    public TCarInfo setCompulsoryValidityDateStr(String compulsoryValidityDateStr) {
        this.compulsoryValidityDateStr = compulsoryValidityDateStr;
        return this;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public TCarInfo setCarStatus(String carStatus) {
        this.carStatus = carStatus;
        return this;
    }

    public MultipartFile getPhotoFile() {
        return photoFile;
    }

    public TCarInfo setPhotoFile(MultipartFile photoFile) {
        this.photoFile = photoFile;
        return this;
    }

    public List<TCarLog> getCarLogs() {
        return carLogs;
    }

    public TCarInfo setCarLogs(List<TCarLog> carLogs) {
        this.carLogs = carLogs;
        return this;
    }

    public List<TDrivingLicenseLog> getDrivingLicenseLogs() {
        return drivingLicenseLogs;
    }

    public TCarInfo setDrivingLicenseLogs(List<TDrivingLicenseLog> drivingLicenseLogs) {
        this.drivingLicenseLogs = drivingLicenseLogs;
        return this;
    }

    public List<TRoadTransportLog> getRoadTransportLogs() {
        return roadTransportLogs;
    }

    public TCarInfo setRoadTransportLogs(List<TRoadTransportLog> roadTransportLogs) {
        this.roadTransportLogs = roadTransportLogs;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public String getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(String inOrOut) {
        this.inOrOut = inOrOut;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getChassisModel() {
        return chassisModel;
    }

    public void setChassisModel(String chassisModel) {
        this.chassisModel = chassisModel;
    }

    public String getOutsideSize() {
        return outsideSize;
    }

    public void setOutsideSize(String outsideSize) {
        this.outsideSize = outsideSize;
    }

    public String getInsideSize() {
        return insideSize;
    }

    public void setInsideSize(String insideSize) {
        this.insideSize = insideSize;
    }

    public String getTotalKg() {
        return totalKg;
    }

    public void setTotalKg(String totalKg) {
        this.totalKg = totalKg;
    }

    public String getEquipmentKg() {
        return equipmentKg;
    }

    public void setEquipmentKg(String equipmentKg) {
        this.equipmentKg = equipmentKg;
    }

    public String getTowKg() {
        return towKg;
    }

    public void setTowKg(String towKg) {
        this.towKg = towKg;
    }

    public String getIdealKg() {
        return idealKg;
    }

    public void setIdealKg(String idealKg) {
        this.idealKg = idealKg;
    }

    public String getIdealCount() {
        return idealCount;
    }

    public void setIdealCount(String idealCount) {
        this.idealCount = idealCount;
    }

    public String getMotorModel() {
        return motorModel;
    }

    public void setMotorModel(String motorModel) {
        this.motorModel = motorModel;
    }

    public String getMotorNumber() {
        return motorNumber;
    }

    public void setMotorNumber(String motorNumber) {
        this.motorNumber = motorNumber;
    }

    public String getMotorOutputVolume() {
        return motorOutputVolume;
    }

    public void setMotorOutputVolume(String motorOutputVolume) {
        this.motorOutputVolume = motorOutputVolume;
    }

    public String getMotorCleanPower() {
        return motorCleanPower;
    }

    public void setMotorCleanPower(String motorCleanPower) {
        this.motorCleanPower = motorCleanPower;
    }

    public String getDischargeStandard() {
        return dischargeStandard;
    }

    public void setDischargeStandard(String dischargeStandard) {
        this.dischargeStandard = dischargeStandard;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getDrivingMotorModel() {
        return drivingMotorModel;
    }

    public void setDrivingMotorModel(String drivingMotorModel) {
        this.drivingMotorModel = drivingMotorModel;
    }

    public String getMotorPower() {
        return motorPower;
    }

    public void setMotorPower(String motorPower) {
        this.motorPower = motorPower;
    }

    public String getPowerType() {
        return powerType;
    }

    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

    public Integer getAxleNum() {
        return axleNum;
    }

    public void setAxleNum(Integer axleNum) {
        this.axleNum = axleNum;
    }

    public String getAxleDistance() {
        return axleDistance;
    }

    public void setAxleDistance(String axleDistance) {
        this.axleDistance = axleDistance;
    }

    public String getTyreNum() {
        return tyreNum;
    }

    public void setTyreNum(String tyreNum) {
        this.tyreNum = tyreNum;
    }

    public String getBrakingType() {
        return brakingType;
    }

    public void setBrakingType(String brakingType) {
        this.brakingType = brakingType;
    }

    public String getFrontWheelBraking() {
        return frontWheelBraking;
    }

    public void setFrontWheelBraking(String frontWheelBraking) {
        this.frontWheelBraking = frontWheelBraking;
    }

    public String getRearWheelBraking() {
        return rearWheelBraking;
    }

    public void setRearWheelBraking(String rearWheelBraking) {
        this.rearWheelBraking = rearWheelBraking;
    }

    public String getIsAbs() {
        return isAbs;
    }

    public void setIsAbs(String isAbs) {
        this.isAbs = isAbs;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getPhotoFilePath() {
        return photoFilePath;
    }

    public void setPhotoFilePath(String photoFilePath) {
        this.photoFilePath = photoFilePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
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
                .append("frontWheelBraking", getFrontWheelBraking())
                .append("rearWheelBraking", getRearWheelBraking())
                .append("isAbs", getIsAbs())
                .append("transmissionType", getTransmissionType())
                .append("carStatus", getCarStatus())
                .append("photoFilePath", getPhotoFilePath())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("addUserId", getAddUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}