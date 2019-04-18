package com.project.security.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 行车日志基础表 t_driver_log
 * 
 * @author rbf
 * @date 2019-04-18
 */
public class TDriverLogForm implements Serializable
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

	/** 检查事项 */
	private String carCheckProject;
	/** 不符合项 */
	private String noAccord;
	/** 确认评论 */
	private String sureComment;
	/** 行车照片 */
	private String drivePhotoUrl;
	/** 签名照片 */
	private String autograph;
	/** 备注 */
	private String remark;
	/** 交接备注 */
	private String exchangeRemark;
	
	/** 行车中填报日期 */
	private Date middleWriteTime;
	/** 行车中检查事项 */
	private String middleCarCheckProject;
	/** 换驾休息地点 */
	private String changeAddress;
	/** 停车时间 */
	private Date stopCarTime;
	/** 发车时间 */
	private Date startCarTime;
	/** 故障处理 */
	private String troubleShooting;
	/** 行车中行车照片 */
	private String drivingPhoto;
	/** 行车中签名照片 */
	private String middleAutograph;
	/** 行车中备注 */
	private String middleRemark;
	
	/** 行车后填报日期 */
	private Date afterWriteTime;
	/** 行车后检查事项 */
	private String afterCarCheckProject;
	/** 故障处理 */
	private String faultHandling;
	/** 行车后签名照片 */
	private String afterAutograph;
	/** 行车后行车照片 */
	private String afterDrivingPhoto;
	/** 始发站 */
	private String startFromStation;
	/** 始发检查情况 */
	private String startFromCheck;
	/** 途中检查地点 */
	private String enRouteAddress;
	/** 途中检查情况 */
	private String enRouteCheck;
	
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

	public String getCarCheckProject() {
		return carCheckProject;
	}

	public void setCarCheckProject(String carCheckProject) {
		this.carCheckProject = carCheckProject;
	}

	public String getNoAccord() {
		return noAccord;
	}

	public void setNoAccord(String noAccord) {
		this.noAccord = noAccord;
	}

	public String getSureComment() {
		return sureComment;
	}

	public void setSureComment(String sureComment) {
		this.sureComment = sureComment;
	}

	public String getDrivePhotoUrl() {
		return drivePhotoUrl;
	}

	public void setDrivePhotoUrl(String drivePhotoUrl) {
		this.drivePhotoUrl = drivePhotoUrl;
	}

	public String getAutograph() {
		return autograph;
	}

	public void setAutograph(String autograph) {
		this.autograph = autograph;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getExchangeRemark() {
		return exchangeRemark;
	}

	public void setExchangeRemark(String exchangeRemark) {
		this.exchangeRemark = exchangeRemark;
	}

	public Date getMiddleWriteTime() {
		return middleWriteTime;
	}

	public void setMiddleWriteTime(Date middleWriteTime) {
		this.middleWriteTime = middleWriteTime;
	}

	public String getMiddleCarCheckProject() {
		return middleCarCheckProject;
	}

	public void setMiddleCarCheckProject(String middleCarCheckProject) {
		this.middleCarCheckProject = middleCarCheckProject;
	}

	public String getChangeAddress() {
		return changeAddress;
	}

	public void setChangeAddress(String changeAddress) {
		this.changeAddress = changeAddress;
	}

	public Date getStopCarTime() {
		return stopCarTime;
	}

	public void setStopCarTime(Date stopCarTime) {
		this.stopCarTime = stopCarTime;
	}

	public Date getStartCarTime() {
		return startCarTime;
	}

	public void setStartCarTime(Date startCarTime) {
		this.startCarTime = startCarTime;
	}

	public String getTroubleShooting() {
		return troubleShooting;
	}

	public void setTroubleShooting(String troubleShooting) {
		this.troubleShooting = troubleShooting;
	}

	public String getDrivingPhoto() {
		return drivingPhoto;
	}

	public void setDrivingPhoto(String drivingPhoto) {
		this.drivingPhoto = drivingPhoto;
	}

	public String getMiddleAutograph() {
		return middleAutograph;
	}

	public void setMiddleAutograph(String middleAutograph) {
		this.middleAutograph = middleAutograph;
	}

	public String getMiddleRemark() {
		return middleRemark;
	}

	public void setMiddleRemark(String middleRemark) {
		this.middleRemark = middleRemark;
	}

	public Date getAfterWriteTime() {
		return afterWriteTime;
	}

	public void setAfterWriteTime(Date afterWriteTime) {
		this.afterWriteTime = afterWriteTime;
	}

	public String getAfterCarCheckProject() {
		return afterCarCheckProject;
	}

	public void setAfterCarCheckProject(String afterCarCheckProject) {
		this.afterCarCheckProject = afterCarCheckProject;
	}

	public String getFaultHandling() {
		return faultHandling;
	}

	public void setFaultHandling(String faultHandling) {
		this.faultHandling = faultHandling;
	}

	public String getAfterAutograph() {
		return afterAutograph;
	}

	public void setAfterAutograph(String afterAutograph) {
		this.afterAutograph = afterAutograph;
	}

	public String getAfterDrivingPhoto() {
		return afterDrivingPhoto;
	}

	public void setAfterDrivingPhoto(String afterDrivingPhoto) {
		this.afterDrivingPhoto = afterDrivingPhoto;
	}

	public String getStartFromStation() {
		return startFromStation;
	}

	public void setStartFromStation(String startFromStation) {
		this.startFromStation = startFromStation;
	}

	public String getStartFromCheck() {
		return startFromCheck;
	}

	public void setStartFromCheck(String startFromCheck) {
		this.startFromCheck = startFromCheck;
	}

	public String getEnRouteAddress() {
		return enRouteAddress;
	}

	public void setEnRouteAddress(String enRouteAddress) {
		this.enRouteAddress = enRouteAddress;
	}

	public String getEnRouteCheck() {
		return enRouteCheck;
	}

	public void setEnRouteCheck(String enRouteCheck) {
		this.enRouteCheck = enRouteCheck;
	}

    
}
