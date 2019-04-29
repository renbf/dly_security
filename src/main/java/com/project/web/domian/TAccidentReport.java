package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 事故报告表 t_accident_report
 *
 * @author rbf
 * @date 2019-04-17
 */
public class TAccidentReport extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 事故基础表主键ID t_accident_basics
     */
    private String accidentBasiscId;
    /**
     * 事故名称
     */
    private String accidentName;
    /**
     * 事故日期
     */
    private Date accidentDate;
    /**
     * 事故时间
     */
    private Date accidentTime;
    /**
     * 驾驶员
     */
    private String accidentDriver;
    /**
     * 车牌号
     */
    private String licenseNumber;
    /**
     * 运行路线(客运管理表ID t_transport_management )
     */
    private String transportId;
    /**
     * 事故地点
     */
    private String accidentPlace;
    /**
     * 事故等级
     */
    private String accidentLevl;
    /**
     * 事故原因
     */
    private String accidentReason;
    /**
     * 超速比例
     */
    private String speedingProportion;
    /**
     * 事故分类
     */
    private String accidentType;
    /**
     * 事故责任
     */
    private String accidentResponsibility;
    /**
     * 实载人数
     */
    private Integer actualNum;
    /**
     * 实载吨位
     */
    private Integer actualTon;
    /**
     * 失踪人数
     */
    private Integer missingNum;
    /**
     * 轻伤人数
     */
    private Integer minorWoundNum;
    /**
     * 重伤人数
     */
    private Integer seriousInjuryNum;
    /**
     * 死亡人数
     */
    private Integer deathNum;
    /**
     * 赔偿比例
     */
    private String compensateProportion;
    /**
     * 三者车牌
     */
    private String threeLicensePlate;
    /**
     * 三者伤数
     */
    private Integer threeInjuredNum;
    /**
     * 三者死亡
     */
    private Integer threeDeathNum;
    /**
     * 经济损失
     */
    private Long economicsLoss;
    /**
     * 报案人
     */
    private String reportPerson;
    /**
     * 报案电话
     */
    private String reportPhone;
    /**
     * 记录人
     */
    private String noteTaker;
    /**
     * 记录人 user_id
     */
    private Long noteTakerUserId;
    /**
     * 所属部门 （部门ID）
     */
    private Long deptId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 死伤情况
     */
    private String casualtyInfo;
    /**
     * 车辆损失情况
     */
    private String carLossInfo;
    /**
     * 事故经过
     */
    private String accidentAfter;
    /**
     * 备注
     */
    private String remark;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 创建日期
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建人id
     */
    private Long userId;
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
    private Long updateUserId;


    /*查询输出增加*/
    private String accidentDateStr;
    private String accidentTimeStr;
    private String createTimeStr;


    public String getAccidentDateStr() {
        return accidentDateStr;
    }

    public TAccidentReport setAccidentDateStr(String accidentDateStr) {
        this.accidentDateStr = accidentDateStr;
        return this;
    }

    public String getAccidentTimeStr() {
        return accidentTimeStr;
    }

    public TAccidentReport setAccidentTimeStr(String accidentTimeStr) {
        this.accidentTimeStr = accidentTimeStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TAccidentReport setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccidentBasiscId() {
        return accidentBasiscId;
    }

    public void setAccidentBasiscId(String accidentBasiscId) {
        this.accidentBasiscId = accidentBasiscId;
    }

    public String getAccidentName() {
        return accidentName;
    }

    public void setAccidentName(String accidentName) {
        this.accidentName = accidentName;
    }

    public Date getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(Date accidentDate) {
        this.accidentDate = accidentDate;
    }

    public Date getAccidentTime() {
        return accidentTime;
    }

    public void setAccidentTime(Date accidentTime) {
        this.accidentTime = accidentTime;
    }

    public String getAccidentDriver() {
        return accidentDriver;
    }

    public void setAccidentDriver(String accidentDriver) {
        this.accidentDriver = accidentDriver;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public String getAccidentPlace() {
        return accidentPlace;
    }

    public void setAccidentPlace(String accidentPlace) {
        this.accidentPlace = accidentPlace;
    }

    public String getAccidentLevl() {
        return accidentLevl;
    }

    public void setAccidentLevl(String accidentLevl) {
        this.accidentLevl = accidentLevl;
    }

    public String getAccidentReason() {
        return accidentReason;
    }

    public void setAccidentReason(String accidentReason) {
        this.accidentReason = accidentReason;
    }

    public String getSpeedingProportion() {
        return speedingProportion;
    }

    public void setSpeedingProportion(String speedingProportion) {
        this.speedingProportion = speedingProportion;
    }

    public String getAccidentType() {
        return accidentType;
    }

    public void setAccidentType(String accidentType) {
        this.accidentType = accidentType;
    }

    public String getAccidentResponsibility() {
        return accidentResponsibility;
    }

    public void setAccidentResponsibility(String accidentResponsibility) {
        this.accidentResponsibility = accidentResponsibility;
    }

    public Integer getActualNum() {
        return actualNum;
    }

    public void setActualNum(Integer actualNum) {
        this.actualNum = actualNum;
    }

    public Integer getActualTon() {
        return actualTon;
    }

    public void setActualTon(Integer actualTon) {
        this.actualTon = actualTon;
    }

    public Integer getMissingNum() {
        return missingNum;
    }

    public void setMissingNum(Integer missingNum) {
        this.missingNum = missingNum;
    }

    public Integer getMinorWoundNum() {
        return minorWoundNum;
    }

    public void setMinorWoundNum(Integer minorWoundNum) {
        this.minorWoundNum = minorWoundNum;
    }

    public Integer getSeriousInjuryNum() {
        return seriousInjuryNum;
    }

    public void setSeriousInjuryNum(Integer seriousInjuryNum) {
        this.seriousInjuryNum = seriousInjuryNum;
    }

    public Integer getDeathNum() {
        return deathNum;
    }

    public void setDeathNum(Integer deathNum) {
        this.deathNum = deathNum;
    }

    public String getCompensateProportion() {
        return compensateProportion;
    }

    public void setCompensateProportion(String compensateProportion) {
        this.compensateProportion = compensateProportion;
    }

    public String getThreeLicensePlate() {
        return threeLicensePlate;
    }

    public void setThreeLicensePlate(String threeLicensePlate) {
        this.threeLicensePlate = threeLicensePlate;
    }

    public Integer getThreeInjuredNum() {
        return threeInjuredNum;
    }

    public void setThreeInjuredNum(Integer threeInjuredNum) {
        this.threeInjuredNum = threeInjuredNum;
    }

    public Integer getThreeDeathNum() {
        return threeDeathNum;
    }

    public void setThreeDeathNum(Integer threeDeathNum) {
        this.threeDeathNum = threeDeathNum;
    }

    public Long getEconomicsLoss() {
        return economicsLoss;
    }

    public void setEconomicsLoss(Long economicsLoss) {
        this.economicsLoss = economicsLoss;
    }

    public String getReportPerson() {
        return reportPerson;
    }

    public void setReportPerson(String reportPerson) {
        this.reportPerson = reportPerson;
    }

    public String getReportPhone() {
        return reportPhone;
    }

    public void setReportPhone(String reportPhone) {
        this.reportPhone = reportPhone;
    }

    public String getNoteTaker() {
        return noteTaker;
    }

    public void setNoteTaker(String noteTaker) {
        this.noteTaker = noteTaker;
    }

    public Long getNoteTakerUserId() {
        return noteTakerUserId;
    }

    public void setNoteTakerUserId(Long noteTakerUserId) {
        this.noteTakerUserId = noteTakerUserId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCasualtyInfo() {
        return casualtyInfo;
    }

    public void setCasualtyInfo(String casualtyInfo) {
        this.casualtyInfo = casualtyInfo;
    }

    public String getCarLossInfo() {
        return carLossInfo;
    }

    public void setCarLossInfo(String carLossInfo) {
        this.carLossInfo = carLossInfo;
    }

    public String getAccidentAfter() {
        return accidentAfter;
    }

    public void setAccidentAfter(String accidentAfter) {
        this.accidentAfter = accidentAfter;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
                .append("accidentBasiscId", getAccidentBasiscId())
                .append("accidentName", getAccidentName())
                .append("accidentDate", getAccidentDate())
                .append("accidentTime", getAccidentTime())
                .append("accidentDriver", getAccidentDriver())
                .append("licenseNumber", getLicenseNumber())
                .append("transportId", getTransportId())
                .append("accidentPlace", getAccidentPlace())
                .append("accidentLevl", getAccidentLevl())
                .append("accidentReason", getAccidentReason())
                .append("speedingProportion", getSpeedingProportion())
                .append("accidentType", getAccidentType())
                .append("accidentResponsibility", getAccidentResponsibility())
                .append("actualNum", getActualNum())
                .append("actualTon", getActualTon())
                .append("missingNum", getMissingNum())
                .append("minorWoundNum", getMinorWoundNum())
                .append("seriousInjuryNum", getSeriousInjuryNum())
                .append("deathNum", getDeathNum())
                .append("compensateProportion", getCompensateProportion())
                .append("threeLicensePlate", getThreeLicensePlate())
                .append("threeInjuredNum", getThreeInjuredNum())
                .append("threeDeathNum", getThreeDeathNum())
                .append("economicsLoss", getEconomicsLoss())
                .append("reportPerson", getReportPerson())
                .append("reportPhone", getReportPhone())
                .append("noteTaker", getNoteTaker())
                .append("noteTakerUserId", getNoteTakerUserId())
                .append("deptId", getDeptId())
                .append("deptName", getDeptName())
                .append("casualtyInfo", getCasualtyInfo())
                .append("carLossInfo", getCarLossInfo())
                .append("accidentAfter", getAccidentAfter())
                .append("remark", getRemark())
                .append("filePath", getFilePath())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("userId", getUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}