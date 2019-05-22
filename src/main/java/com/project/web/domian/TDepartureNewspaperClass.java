package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 车辆报班表 t_departure_newspaper_class
 *
 * @author rbf
 * @date 2019-04-17
 */
public class TDepartureNewspaperClass extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 班次日期     ##
     */
    private Date shiftsDate;
    /**
     * 班次号      #$
     */
    private String shiftsNum;
    /**
     * 班次类型     #$
     */
    private String shiftsType;
    /**
     * 车牌类型
     */
    private String vehicleLicenseType;
    /**
     * 驾驶员      #$
     */
    private String driver;
    /**
     * 线路名称
     */
    private String lineName;
    /**
     * 报班时间
     */
    private Date newspaperClassDate;
    /**
     * 报班人      #$
     */
    private String newspaperClassPer;
    /**
     * 最后一次同步时间
     */
    private Date lastSynchroDate;
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
     * 修改人id
     */
    private Long updateUserId;

    /*查询入参增加*/
    private Date shiftsDate1;
    /*查询出参增加*/
    private String shiftsDateStr;
    private String newspaperClassDateStr;
    private String createTimeStr;
    private String vehicleLicenseTypeName;
    /**
     * 最后一次同步时间
     */
    private String lastSynchroDateStr;




    public String getLastSynchroDateStr() {
		return lastSynchroDateStr;
	}

	public void setLastSynchroDateStr(String lastSynchroDateStr) {
		this.lastSynchroDateStr = lastSynchroDateStr;
	}

	public Date getShiftsDate1() {
        return shiftsDate1;
    }

    public TDepartureNewspaperClass setShiftsDate1(Date shiftsDate1) {
        this.shiftsDate1 = shiftsDate1;
        return this;
    }

    public String getShiftsDateStr() {
        return shiftsDateStr;
    }

    public TDepartureNewspaperClass setShiftsDateStr(String shiftsDateStr) {
        this.shiftsDateStr = shiftsDateStr;
        return this;
    }

    public String getNewspaperClassDateStr() {
        return newspaperClassDateStr;
    }

    public TDepartureNewspaperClass setNewspaperClassDateStr(String newspaperClassDateStr) {
        this.newspaperClassDateStr = newspaperClassDateStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TDepartureNewspaperClass setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public String getVehicleLicenseTypeName() {
        return vehicleLicenseTypeName;
    }

    public TDepartureNewspaperClass setVehicleLicenseTypeName(String vehicleLicenseTypeName) {
        this.vehicleLicenseTypeName = vehicleLicenseTypeName;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getShiftsDate() {
        return shiftsDate;
    }

    public void setShiftsDate(Date shiftsDate) {
        this.shiftsDate = shiftsDate;
    }

    public String getShiftsNum() {
        return shiftsNum;
    }

    public void setShiftsNum(String shiftsNum) {
        this.shiftsNum = shiftsNum;
    }

    public String getShiftsType() {
        return shiftsType;
    }

    public void setShiftsType(String shiftsType) {
        this.shiftsType = shiftsType;
    }

    public String getVehicleLicenseType() {
        return vehicleLicenseType;
    }

    public void setVehicleLicenseType(String vehicleLicenseType) {
        this.vehicleLicenseType = vehicleLicenseType;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Date getNewspaperClassDate() {
        return newspaperClassDate;
    }

    public void setNewspaperClassDate(Date newspaperClassDate) {
        this.newspaperClassDate = newspaperClassDate;
    }

    public String getNewspaperClassPer() {
        return newspaperClassPer;
    }

    public void setNewspaperClassPer(String newspaperClassPer) {
        this.newspaperClassPer = newspaperClassPer;
    }

    public Date getLastSynchroDate() {
        return lastSynchroDate;
    }

    public void setLastSynchroDate(Date lastSynchroDate) {
        this.lastSynchroDate = lastSynchroDate;
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
                .append("shiftsDate", getShiftsDate())
                .append("shiftsNum", getShiftsNum())
                .append("shiftsType", getShiftsType())
                .append("vehicleLicenseType", getVehicleLicenseType())
                .append("driver", getDriver())
                .append("lineName", getLineName())
                .append("newspaperClassDate", getNewspaperClassDate())
                .append("newspaperClassPer", getNewspaperClassPer())
                .append("lastSynchroDate", getLastSynchroDate())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("userId", getUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}