package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 出站例检表 t_departure_check
 *
 * @author rbf
 * @date 2019-04-17
 */
public class TDepartureCheck extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 车辆牌照     #$
     */
    private String vehicleLicence;
    /**
     * 驾驶员      #$
     */
    private String driver;
    /**
     * 打单时间     ##
     */
    private Date intimidateDate;
    /**
     * 售票座位数
     */
    private Integer ticketingSeatNum;
    /**
     * 实载人数
     */
    private Integer actualNum;
    /**
     * 半票人数
     */
    private Integer halfTicketNum;
    /**
     * 免票人数
     */
    private Integer freeTicketNum;
    /**
     * 线路名称     #$
     */
    private String lineName;
    /**
     * 班次日期     ##
     */
    private Date shiftsDate;
    /**
     * 班次号
     */
    private String shiftsNum;
    /**
     * 班次类型         字典项(vehicle_Shifts_type)
     */
    private String shiftsType;
    /**
     * 天气
     */
    private String weather;
    /**
     * 检查结果
     */
    private String checkResult;
    /**
     * 不合格内容
     */
    private String unqualifiedInfo;
    /**
     * 出站时间
     */
    private Date outStationDate;
    /**
     * 出站操作人        #$
     */
    private String outStationOperator;
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
    private Date intimidateDate1;
    private Date shiftsDate1;
    /*查询出参增加*/
    private String intimidateDateStr;
    private String shiftsDateStr;
    private String outStationDateStr;
    private String lastSynchroDateStr;
    private String createTimeStr;
    //private String shiftsTypeName;


    public Date getShiftsDate1() {
        return shiftsDate1;
    }

    public TDepartureCheck setShiftsDate1(Date shiftsDate1) {
        this.shiftsDate1 = shiftsDate1;
        return this;
    }

    //public String getShiftsTypeName() {
    //    return shiftsTypeName;
    //}
    //
    //public TDepartureCheck setShiftsTypeName(String shiftsTypeName) {
    //    this.shiftsTypeName = shiftsTypeName;
    //    return this;
    //}

    public Date getIntimidateDate1() {
        return intimidateDate1;
    }

    public TDepartureCheck setIntimidateDate1(Date intimidateDate1) {
        this.intimidateDate1 = intimidateDate1;
        return this;
    }

    public String getIntimidateDateStr() {
        return intimidateDateStr;
    }

    public TDepartureCheck setIntimidateDateStr(String intimidateDateStr) {
        this.intimidateDateStr = intimidateDateStr;
        return this;
    }

    public String getShiftsDateStr() {
        return shiftsDateStr;
    }

    public TDepartureCheck setShiftsDateStr(String shiftsDateStr) {
        this.shiftsDateStr = shiftsDateStr;
        return this;
    }

    public String getOutStationDateStr() {
        return outStationDateStr;
    }

    public TDepartureCheck setOutStationDateStr(String outStationDateStr) {
        this.outStationDateStr = outStationDateStr;
        return this;
    }

    public String getLastSynchroDateStr() {
        return lastSynchroDateStr;
    }

    public TDepartureCheck setLastSynchroDateStr(String lastSynchroDateStr) {
        this.lastSynchroDateStr = lastSynchroDateStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TDepartureCheck setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getIntimidateDate() {
        return intimidateDate;
    }

    public void setIntimidateDate(Date intimidateDate) {
        this.intimidateDate = intimidateDate;
    }

    public Integer getTicketingSeatNum() {
        return ticketingSeatNum;
    }

    public void setTicketingSeatNum(Integer ticketingSeatNum) {
        this.ticketingSeatNum = ticketingSeatNum;
    }

    public Integer getActualNum() {
        return actualNum;
    }

    public void setActualNum(Integer actualNum) {
        this.actualNum = actualNum;
    }

    public Integer getHalfTicketNum() {
        return halfTicketNum;
    }

    public void setHalfTicketNum(Integer halfTicketNum) {
        this.halfTicketNum = halfTicketNum;
    }

    public Integer getFreeTicketNum() {
        return freeTicketNum;
    }

    public void setFreeTicketNum(Integer freeTicketNum) {
        this.freeTicketNum = freeTicketNum;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
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

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getUnqualifiedInfo() {
        return unqualifiedInfo;
    }

    public void setUnqualifiedInfo(String unqualifiedInfo) {
        this.unqualifiedInfo = unqualifiedInfo;
    }

    public Date getOutStationDate() {
        return outStationDate;
    }

    public void setOutStationDate(Date outStationDate) {
        this.outStationDate = outStationDate;
    }

    public String getOutStationOperator() {
        return outStationOperator;
    }

    public void setOutStationOperator(String outStationOperator) {
        this.outStationOperator = outStationOperator;
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
                .append("vehicleLicence", getVehicleLicence())
                .append("driver", getDriver())
                .append("intimidateDate", getIntimidateDate())
                .append("ticketingSeatNum", getTicketingSeatNum())
                .append("actualNum", getActualNum())
                .append("halfTicketNum", getHalfTicketNum())
                .append("freeTicketNum", getFreeTicketNum())
                .append("lineName", getLineName())
                .append("shiftsDate", getShiftsDate())
                .append("shiftsNum", getShiftsNum())
                .append("shiftsType", getShiftsType())
                .append("weather", getWeather())
                .append("checkResult", getCheckResult())
                .append("unqualifiedInfo", getUnqualifiedInfo())
                .append("outStationDate", getOutStationDate())
                .append("outStationOperator", getOutStationOperator())
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

