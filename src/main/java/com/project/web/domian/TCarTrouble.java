package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 车辆机损事故登记表 t_car_trouble
 *
 * @author rbf
 * @date 2019-04-23
 */
public class TCarTrouble extends BaseEntity {
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
     * 事故时间     ##
     */
    private Date troubleDate;
    /**
     * 事故地点     #$
     */
    private String troubleAddress;
    /**
     * 事故性质
     */
    private String troubleType;
    /**
     * 事故责任     #$
     */
    private String troubleDuty;
    /**
     * 车辆损坏情况
     */
    private String lossSituation;
    /**
     * 登记人员id   #$
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
    private Date troubleDate1;
    /*查询输出新增*/
    private String troubleDateStr;
    private String createDateStr;


    public Date getTroubleDate1() {
        return troubleDate1;
    }

    public TCarTrouble setTroubleDate1(Date troubleDate1) {
        this.troubleDate1 = troubleDate1;
        return this;
    }

    public String getTroubleDateStr() {
        return troubleDateStr;
    }

    public TCarTrouble setTroubleDateStr(String troubleDateStr) {
        this.troubleDateStr = troubleDateStr;
        return this;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public TCarTrouble setCreateDateStr(String createDateStr) {
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

    public Date getTroubleDate() {
        return troubleDate;
    }

    public void setTroubleDate(Date troubleDate) {
        this.troubleDate = troubleDate;
    }

    public String getTroubleAddress() {
        return troubleAddress;
    }

    public void setTroubleAddress(String troubleAddress) {
        this.troubleAddress = troubleAddress;
    }

    public String getTroubleType() {
        return troubleType;
    }

    public void setTroubleType(String troubleType) {
        this.troubleType = troubleType;
    }

    public String getTroubleDuty() {
        return troubleDuty;
    }

    public void setTroubleDuty(String troubleDuty) {
        this.troubleDuty = troubleDuty;
    }

    public String getLossSituation() {
        return lossSituation;
    }

    public void setLossSituation(String lossSituation) {
        this.lossSituation = lossSituation;
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
                .append("troubleDate", getTroubleDate())
                .append("troubleAddress", getTroubleAddress())
                .append("troubleType", getTroubleType())
                .append("troubleDuty", getTroubleDuty())
                .append("lossSituation", getLossSituation())
                .append("addUserId", getAddUserId())
                .append("createDate", getCreateDate())
                .append("updateDate", getUpdateDate())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
