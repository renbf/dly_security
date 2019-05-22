package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 车牌号牌变更表 t_car_log
 *
 * @author rbf
 * @date 2019-04-23
 */
public class TCarLog extends BaseEntity {
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
     * 车牌号码
     */
    private String carNumber;
    /**
     * 颜色
     */
    private String color;
    /**
     * 注册(变更)日期
     */
    private Date updateDate;
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


    /*查询输出新增*/
    private String updateDateStr;
    private String createTimeStr;


    public String getUpdateDateStr() {
        return updateDateStr;
    }

    public TCarLog setUpdateDateStr(String updateDateStr) {
        this.updateDateStr = updateDateStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TCarLog setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
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

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
                .append("carNumber", getCarNumber())
                .append("color", getColor())
                .append("updateDate", getUpdateDate())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("addUserId", getAddUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
