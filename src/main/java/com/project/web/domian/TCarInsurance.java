package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 车辆保险情况表 t_car_insurance
 *
 * @author rbf
 * @date 2019-04-23
 */
public class TCarInsurance extends BaseEntity {
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
     * 保险有效期        ##
     */
    private Date validityDate;
    /**
     * 保险类型     #
     */
    private String insuranceType;
    /**
     * 投保单位     #$
     */
    private String insuranceUnit;
    /**
     * 保单号      #$
     */
    private String insuranceNumber;
    /**
     * 保险金额
     */
    private String insurancePrice;
    /**
     * 保险费
     */
    private String insuranceCost;
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
    private Date validityDate1;
    /*查询输出新增*/
    private String validityDateStr;
    private String createDateStr;


    public Date getValidityDate1() {
        return validityDate1;
    }

    public TCarInsurance setValidityDate1(Date validityDate1) {
        this.validityDate1 = validityDate1;
        return this;
    }

    public String getValidityDateStr() {
        return validityDateStr;
    }

    public TCarInsurance setValidityDateStr(String validityDateStr) {
        this.validityDateStr = validityDateStr;
        return this;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public TCarInsurance setCreateDateStr(String createDateStr) {
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

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceUnit() {
        return insuranceUnit;
    }

    public void setInsuranceUnit(String insuranceUnit) {
        this.insuranceUnit = insuranceUnit;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(String insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public String getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(String insuranceCost) {
        this.insuranceCost = insuranceCost;
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
                .append("insuranceType", getInsuranceType())
                .append("insuranceUnit", getInsuranceUnit())
                .append("insuranceNumber", getInsuranceNumber())
                .append("insurancePrice", getInsurancePrice())
                .append("insuranceCost", getInsuranceCost())
                .append("remark", getRemark())
                .append("fileUrl", getFileUrl())
                .append("addUserId", getAddUserId())
                .append("createDate", getCreateDate())
                .append("updateDate", getUpdateDate())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
