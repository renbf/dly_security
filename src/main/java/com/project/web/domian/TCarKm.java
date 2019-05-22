package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 车辆行驶里程登记表 t_car_km
 *
 * @author rbf
 * @date 2019-04-23
 */
public class TCarKm extends BaseEntity {
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
     * 当月行驶里程/km
     */
    private String monthKm;
    /**
     * 累计行驶里程/km
     */
    private String totalKm;
    /**
     * 登记人员id
     */
    private String addUserId;
    /**
     * 登记日期     ##
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
    private Date createDate1;
    /*查询输出新增*/
    private String createDateStr;


    public Date getCreateDate1() {
        return createDate1;
    }

    public TCarKm setCreateDate1(Date createDate1) {
        this.createDate1 = createDate1;
        return this;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public TCarKm setCreateDateStr(String createDateStr) {
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

    public String getMonthKm() {
        return monthKm;
    }

    public void setMonthKm(String monthKm) {
        this.monthKm = monthKm;
    }

    public String getTotalKm() {
        return totalKm;
    }

    public void setTotalKm(String totalKm) {
        this.totalKm = totalKm;
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
                .append("monthKm", getMonthKm())
                .append("totalKm", getTotalKm())
                .append("addUserId", getAddUserId())
                .append("createDate", getCreateDate())
                .append("updateDate", getUpdateDate())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
