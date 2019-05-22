package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 压力容器和罐式专用车辆的罐体检测报告表 t_car_special_use
 *
 * @author rbf
 * @date 2019-04-23
 */
public class TCarSpecialUse extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;
    /**
     * 车辆ID
     */
    private String carId;
    /**
     * 检验有效期
     */
    private Date validityDate;
    /**
     * 设备名称     #$
     */
    private String deviceName;
    /**
     * 设备品种     #$
     */
    private String deviceType;
    /**
     * 设备代码     #$
     */
    private String deviceCode;
    /**
     * 检测类型     #
     */
    private String testingType;
    /**
     * 检验单位     #$
     */
    private String testingUnit;
    /**
     * 备注
     */
    private String remark;
    /**
     * 附件url
     */
    private String fileUrl;
    /**
     * 登记人员id
     */
    private String addUserId;
    /**
     * 登记日期
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
    /*查询输出新增*/
    private String validityDateStr;
    private String createDateStr;


    public String getValidityDateStr() {
        return validityDateStr;
    }

    public TCarSpecialUse setValidityDateStr(String validityDateStr) {
        this.validityDateStr = validityDateStr;
        return this;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public TCarSpecialUse setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getTestingType() {
        return testingType;
    }

    public void setTestingType(String testingType) {
        this.testingType = testingType;
    }

    public String getTestingUnit() {
        return testingUnit;
    }

    public void setTestingUnit(String testingUnit) {
        this.testingUnit = testingUnit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
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
                .append("carId", getCarId())
                .append("validityDate", getValidityDate())
                .append("deviceName", getDeviceName())
                .append("deviceType", getDeviceType())
                .append("deviceCode", getDeviceCode())
                .append("testingType", getTestingType())
                .append("testingUnit", getTestingUnit())
                .append("remark", getRemark())
                .append("fileUrl", getFileUrl())
                .append("addUserId", getAddUserId())
                .append("createDate", getCreateDate())
                .append("updateDate", getUpdateDate())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
