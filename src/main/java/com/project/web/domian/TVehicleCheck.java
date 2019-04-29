package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 车辆例检表 t_vehicle_check
 *
 * @author rbf
 * @date 2019-04-17
 */
public class TVehicleCheck extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 例检类型     #   字典()
     */
    private String checkType;
    /**
     * 车辆牌照     #$
     */
    private String vehicleLicence;
    /**
     * 驾驶员      #$
     */
    private String driver;
    /**
     * 例检时间     ##
     */
    private Date ckeckDate;
    /**
     * 检查结果     #$
     */
    private String checkResult;
    /**
     * 检查有效期
     */
    private Date checkValidity;
    /**
     * 车上例检员
     */
    private String vehicleUpDriver;
    /**
     * 车下例检员
     */
    private String vehicleDownDriver;
    /**
     * 微机操作员
     */
    private String microcomputerOperator;
    /**
     * 不合格内容
     */
    private String unqualifiedInfo;
    /**
     * 创建日期
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 创建人ID
     */
    private Long userId;
    /**
     * 备用
     */
    private String meno;
    /**
     * 企业ID
     */
    private String businessId;
    /**
     * 修改人ID
     */
    private Long updateUserId;


    /*查询入参增加*/
    private Date ckeckDate1;


    /*查询出参增加*/
    private String ckeckDateStr;
    private String createTimeStr;
    private String checkTypeStr;


    public String getCheckTypeStr() {
        return checkTypeStr;
    }

    public TVehicleCheck setCheckTypeStr(String checkTypeStr) {
        this.checkTypeStr = checkTypeStr;
        return this;
    }

    public Date getCkeckDate1() {
        return ckeckDate1;
    }

    public TVehicleCheck setCkeckDate1(Date ckeckDate1) {
        this.ckeckDate1 = ckeckDate1;
        return this;
    }

    public String getCkeckDateStr() {
        return ckeckDateStr;
    }

    public TVehicleCheck setCkeckDateStr(String ckeckDateStr) {
        this.ckeckDateStr = ckeckDateStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TVehicleCheck setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getVehicleLicence() {
        return vehicleLicence;
    }

    public void setVehicleLicence(String vehicleLicence) {
        this.vehicleLicence = vehicleLicence;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Date getCkeckDate() {
        return ckeckDate;
    }

    public void setCkeckDate(Date ckeckDate) {
        this.ckeckDate = ckeckDate;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public Date getCheckValidity() {
        return checkValidity;
    }

    public void setCheckValidity(Date checkValidity) {
        this.checkValidity = checkValidity;
    }

    public String getVehicleUpDriver() {
        return vehicleUpDriver;
    }

    public void setVehicleUpDriver(String vehicleUpDriver) {
        this.vehicleUpDriver = vehicleUpDriver;
    }

    public String getVehicleDownDriver() {
        return vehicleDownDriver;
    }

    public void setVehicleDownDriver(String vehicleDownDriver) {
        this.vehicleDownDriver = vehicleDownDriver;
    }

    public String getMicrocomputerOperator() {
        return microcomputerOperator;
    }

    public void setMicrocomputerOperator(String microcomputerOperator) {
        this.microcomputerOperator = microcomputerOperator;
    }

    public String getUnqualifiedInfo() {
        return unqualifiedInfo;
    }

    public void setUnqualifiedInfo(String unqualifiedInfo) {
        this.unqualifiedInfo = unqualifiedInfo;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
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
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}