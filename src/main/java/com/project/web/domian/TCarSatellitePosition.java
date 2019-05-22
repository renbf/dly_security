package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 卫星定位表 t_car_satellite_position
 *
 * @author rbf
 * @date 2019-04-23
 */
public class TCarSatellitePosition extends BaseEntity {
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
     * 时间       ##
     */
    private Date positionTime;
    /**
     * 终端类型     #
     */
    private String terminalType;
    /**
     * 安装日期     ##
     */
    private Date setupDate;
    /**
     * 接入系统     #
     */
    private String system;
    /**
     * 费用到期时间
     */
    private Date endDate;
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
    private Date positionTime1;
    private Date setupDate1;
    /*查询输出新增*/
    private String positionTimeStr;
    private String setupDateStr;
    private String endDateStr;
    private String createDateStr;


    public Date getPositionTime1() {
        return positionTime1;
    }

    public TCarSatellitePosition setPositionTime1(Date positionTime1) {
        this.positionTime1 = positionTime1;
        return this;
    }

    public Date getSetupDate1() {
        return setupDate1;
    }

    public TCarSatellitePosition setSetupDate1(Date setupDate1) {
        this.setupDate1 = setupDate1;
        return this;
    }

    public String getPositionTimeStr() {
        return positionTimeStr;
    }

    public TCarSatellitePosition setPositionTimeStr(String positionTimeStr) {
        this.positionTimeStr = positionTimeStr;
        return this;
    }

    public String getSetupDateStr() {
        return setupDateStr;
    }

    public TCarSatellitePosition setSetupDateStr(String setupDateStr) {
        this.setupDateStr = setupDateStr;
        return this;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    public TCarSatellitePosition setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
        return this;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public TCarSatellitePosition setCreateDateStr(String createDateStr) {
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

    public Date getPositionTime() {
        return positionTime;
    }

    public void setPositionTime(Date positionTime) {
        this.positionTime = positionTime;
    }

    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    public Date getSetupDate() {
        return setupDate;
    }

    public void setSetupDate(Date setupDate) {
        this.setupDate = setupDate;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
                .append("positionTime", getPositionTime())
                .append("terminalType", getTerminalType())
                .append("setupDate", getSetupDate())
                .append("system", getSystem())
                .append("endDate", getEndDate())
                .append("remark", getRemark())
                .append("fileUrl", getFileUrl())
                .append("addUserId", getAddUserId())
                .append("createDate", getCreateDate())
                .append("updateDate", getUpdateDate())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
