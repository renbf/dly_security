package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 报班未出站车辆表 t_newspaper_class_out_departure
 *
 * @author rbf
 * @date 2019-04-17
 */
public class TNewspaperClassOutDeparture extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 报班车辆     #$
     */
    private String shiftsVehicle;
    /**
     * 报班驾驶员   #$
     */
    private String shiftsDriver;
    /**
     * 班次类型     #$
     */
    private String shiftsType;
    /**
     * 班次号      #$
     */
    private String shiftsNum;
    /**
     * 运行路线
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
     * 所属机构     #$
     */
    private String deptId;
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


    /*查询出参增加*/
    private String newspaperClassDateStr;
    private String createTimeStr;


    public String getNewspaperClassDateStr() {
        return newspaperClassDateStr;
    }

    public TNewspaperClassOutDeparture setNewspaperClassDateStr(String newspaperClassDateStr) {
        this.newspaperClassDateStr = newspaperClassDateStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TNewspaperClassOutDeparture setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShiftsVehicle() {
        return shiftsVehicle;
    }

    public void setShiftsVehicle(String shiftsVehicle) {
        this.shiftsVehicle = shiftsVehicle;
    }

    public String getShiftsDriver() {
        return shiftsDriver;
    }

    public void setShiftsDriver(String shiftsDriver) {
        this.shiftsDriver = shiftsDriver;
    }

    public String getShiftsType() {
        return shiftsType;
    }

    public void setShiftsType(String shiftsType) {
        this.shiftsType = shiftsType;
    }

    public String getShiftsNum() {
        return shiftsNum;
    }

    public void setShiftsNum(String shiftsNum) {
        this.shiftsNum = shiftsNum;
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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
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
                .append("shiftsVehicle", getShiftsVehicle())
                .append("shiftsDriver", getShiftsDriver())
                .append("shiftsType", getShiftsType())
                .append("shiftsNum", getShiftsNum())
                .append("lineName", getLineName())
                .append("newspaperClassDate", getNewspaperClassDate())
                .append("newspaperClassPer", getNewspaperClassPer())
                .append("deptId", getDeptId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("userId", getUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
