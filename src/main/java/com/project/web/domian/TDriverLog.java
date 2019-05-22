package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 行车日志基础表 t_driver_log
 *
 * @author rbf
 * @date 2019-04-23
 */
public class TDriverLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;
    /**
     * 填报日期
     */
    private Date writeTime;
    /**
     * 车牌号      #$
     */
    private String carNumber;
    /**
     * 核载吨位
     */
    private String idealTonnage;
    /**
     * 实载吨位
     */
    private String actualTonnage;
    /**
     * 货物名称
     */
    private String goodsName;
    /**
     * 类项
     */
    private String type;
    /**
     * 启运地      #$
     */
    private String transporAddress;
    /**
     * 目的地
     */
    private String goalAddress;
    /**
     * 启运日期
     */
    private Date transportDate;
    /**
     * 到达日期
     */
    private Date arriveDate;
    /**
     * 里程
     */
    private String km;
    /**
     * 车辆状态0行车前1行车中2行车后     #
     */
    private String status;
    /**
     * 驾驶员1
     */
    private String firstDriverId;
    /**
     * 驾驶员2
     */
    private String secondDriverId;
    /**
     * 押运员
     */
    private String escortId;
    /**
     * 气温
     */
    private String temperature;
    /**
     * 天气
     */
    private String weather;
    /**
     * 创建人id
     */
    private String addUserId;
    /**
     * 创建时间     ##
     */
    private Date createDate;
    /**
     * 修改时间
     */
    private Date updateDate;
    /**
     * 修改人id
     */
    private String updateUserId;


    /*查询输入新增*/
    //汽车类型  #$
    private String carModel;
    /*查询输出新增*/
    private String writeTimeStr;
    private String transportDateStr;
    private String arriveDateStr;
    private String createDateStr;
    private TDriverBeforeLog driverBeforeLog;
    private TDriverMiddleLog driverMiddleLog;
    private TDriverAfterLog driverAfterLog;


    /**
     * 修改输入新增,由于修改为一次修改多表,把附属表的实体类存进来
     */
    //private TDriverBeforeLog driverBeforeLog;
    //private TDriverMiddleLog driverMiddleLog;
    //private TDriverAfterLog driverAfterLog;
    //在查询输出中有了,所以直接用吧...




    public String getCarModel() {
        return carModel;
    }

    public TDriverLog setCarModel(String carModel) {
        this.carModel = carModel;
        return this;
    }

    public String getWriteTimeStr() {
        return writeTimeStr;
    }

    public TDriverLog setWriteTimeStr(String writeTimeStr) {
        this.writeTimeStr = writeTimeStr;
        return this;
    }

    public String getTransportDateStr() {
        return transportDateStr;
    }

    public TDriverLog setTransportDateStr(String transportDateStr) {
        this.transportDateStr = transportDateStr;
        return this;
    }

    public String getArriveDateStr() {
        return arriveDateStr;
    }

    public TDriverLog setArriveDateStr(String arriveDateStr) {
        this.arriveDateStr = arriveDateStr;
        return this;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public TDriverLog setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
        return this;
    }

    public TDriverBeforeLog getDriverBeforeLog() {
        return driverBeforeLog;
    }

    public TDriverLog setDriverBeforeLog(TDriverBeforeLog driverBeforeLog) {
        this.driverBeforeLog = driverBeforeLog;
        return this;
    }

    public TDriverMiddleLog getDriverMiddleLog() {
        return driverMiddleLog;
    }

    public TDriverLog setDriverMiddleLog(TDriverMiddleLog driverMiddleLog) {
        this.driverMiddleLog = driverMiddleLog;
        return this;
    }

    public TDriverAfterLog getDriverAfterLog() {
        return driverAfterLog;
    }

    public TDriverLog setDriverAfterLog(TDriverAfterLog driverAfterLog) {
        this.driverAfterLog = driverAfterLog;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(Date writeTime) {
        this.writeTime = writeTime;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getIdealTonnage() {
        return idealTonnage;
    }

    public void setIdealTonnage(String idealTonnage) {
        this.idealTonnage = idealTonnage;
    }

    public String getActualTonnage() {
        return actualTonnage;
    }

    public void setActualTonnage(String actualTonnage) {
        this.actualTonnage = actualTonnage;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransporAddress() {
        return transporAddress;
    }

    public void setTransporAddress(String transporAddress) {
        this.transporAddress = transporAddress;
    }

    public String getGoalAddress() {
        return goalAddress;
    }

    public void setGoalAddress(String goalAddress) {
        this.goalAddress = goalAddress;
    }

    public Date getTransportDate() {
        return transportDate;
    }

    public void setTransportDate(Date transportDate) {
        this.transportDate = transportDate;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstDriverId() {
        return firstDriverId;
    }

    public void setFirstDriverId(String firstDriverId) {
        this.firstDriverId = firstDriverId;
    }

    public String getSecondDriverId() {
        return secondDriverId;
    }

    public void setSecondDriverId(String secondDriverId) {
        this.secondDriverId = secondDriverId;
    }

    public String getEscortId() {
        return escortId;
    }

    public void setEscortId(String escortId) {
        this.escortId = escortId;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
