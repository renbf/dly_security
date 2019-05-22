package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 行驶证变更表 t_driving_license_log
 *
 * @author rbf
 * @date 2019-04-23
 */
public class TDrivingLicenseLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;
    /**
     * 汽车基础表ID
     */
    private String carInfoId;
    /**
     * 行驶证号
     */
    private String travelNumber;
    /**
     * 有效期
     */
    private Date validityDate;
    /**
     * 发证日期
     */
    private Date startDate;
    /**
     * 证件附件
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
    /*查询输出新增*/
    private String validityDateStr;
    private String createTimeStr;





    /*其他新增*/
    private MultipartFile photoFile;


    public String getValidityDateStr() {
        return validityDateStr;
    }

    public TDrivingLicenseLog setValidityDateStr(String validityDateStr) {
        this.validityDateStr = validityDateStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TDrivingLicenseLog setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public MultipartFile getPhotoFile() {
        return photoFile;
    }

    public TDrivingLicenseLog setPhotoFile(MultipartFile photoFile) {
        this.photoFile = photoFile;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarInfoId() {
        return carInfoId;
    }

    public void setCarInfoId(String carInfoId) {
        this.carInfoId = carInfoId;
    }

    public String getTravelNumber() {
        return travelNumber;
    }

    public void setTravelNumber(String travelNumber) {
        this.travelNumber = travelNumber;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public TDrivingLicenseLog setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
                .append("carInfoId", getCarInfoId())
                .append("travelNumber", getTravelNumber())
                .append("validityDate", getValidityDate())
                .append("startDate", getStartDate())
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