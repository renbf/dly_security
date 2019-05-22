package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 预警统计表 t_early_warning_report
 *
 * @author rbf
 * @date 2019-05-14
 */
public class TEarlyWarningReport extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;
    /**
     * 报警对象
     */
    private String alarmObj;
    /**
     * 初次报警时间
     */
    private Date firstAlarmDate;
    /**
     * 持续天数
     */
    private Integer numbers;
    /**
     * 风险因子
     */
    private Integer factor;
    /**
     * 报警描述
     */
    private String alarmDesc;
    /**
     * 解决人
     */
    private String solveUserId;
    /**
     * 解决时间
     */
    private Date solveDate;
    /**
     * 解决原因
     */
    private String solveReason;
    /**
     * 部门ID(所属机构)
     */
    private Long deptId;
    /**
     * 报警ID
     */
    private String alarmId;
    /**
     * 报警类型
     */
    private String alarmType;
    /**
     * 预警类型1：安全预警2风险预警
     */
    private String earlyWarningType;
    /**
     * 状态（1已解除 0未解除）
     */
    private String status;
    /**
     * 企业id
     */
    private String businessId;
    /**
     * 创建人id
     */
    private String addUserId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 备用
     */
    private String meno;
    /**
     * 备用1
     */
    private String meno1;
    /**
     * 备用2
     */
    private String meno2;
    /**
     * 备用3
     */
    private String meno3;
    /**
     * 修改时间
     */
    private Date updateDate;
    /**
     * 修改人id
     */
    private String updateUserId;


    /*查询输入新增*/
    private Date firstAlarmDate1;

    /*查询输出新增*/


    /*selectDangerWarningSum 业务 新增 输入和输出*/
    /*输入*/
    private Date leftDate;
    private Date rightDate;

    /*输出*/


    public Date getFirstAlarmDate1() {
        return firstAlarmDate1;
    }

    public TEarlyWarningReport setFirstAlarmDate1(Date firstAlarmDate1) {
        this.firstAlarmDate1 = firstAlarmDate1;
        return this;
    }

    public Date getLeftDate() {
        return leftDate;
    }

    public TEarlyWarningReport setLeftDate(Date leftDate) {
        this.leftDate = leftDate;
        return this;
    }

    public Date getRightDate() {
        return rightDate;
    }

    public TEarlyWarningReport setRightDate(Date rightDate) {
        this.rightDate = rightDate;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlarmObj() {
        return alarmObj;
    }

    public void setAlarmObj(String alarmObj) {
        this.alarmObj = alarmObj;
    }

    public Date getFirstAlarmDate() {
        return firstAlarmDate;
    }

    public void setFirstAlarmDate(Date firstAlarmDate) {
        this.firstAlarmDate = firstAlarmDate;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    public Integer getFactor() {
        return factor;
    }

    public void setFactor(Integer factor) {
        this.factor = factor;
    }

    public String getAlarmDesc() {
        return alarmDesc;
    }

    public void setAlarmDesc(String alarmDesc) {
        this.alarmDesc = alarmDesc;
    }

    public String getSolveUserId() {
        return solveUserId;
    }

    public void setSolveUserId(String solveUserId) {
        this.solveUserId = solveUserId;
    }

    public Date getSolveDate() {
        return solveDate;
    }

    public void setSolveDate(Date solveDate) {
        this.solveDate = solveDate;
    }

    public String getSolveReason() {
        return solveReason;
    }

    public void setSolveReason(String solveReason) {
        this.solveReason = solveReason;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getEarlyWarningType() {
        return earlyWarningType;
    }

    public void setEarlyWarningType(String earlyWarningType) {
        this.earlyWarningType = earlyWarningType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
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

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getMeno1() {
        return meno1;
    }

    public void setMeno1(String meno1) {
        this.meno1 = meno1;
    }

    public String getMeno2() {
        return meno2;
    }

    public void setMeno2(String meno2) {
        this.meno2 = meno2;
    }

    public String getMeno3() {
        return meno3;
    }

    public void setMeno3(String meno3) {
        this.meno3 = meno3;
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
                .append("alarmObj", getAlarmObj())
                .append("firstAlarmDate", getFirstAlarmDate())
                .append("numbers", getNumbers())
                .append("factor", getFactor())
                .append("alarmDesc", getAlarmDesc())
                .append("solveUserId", getSolveUserId())
                .append("solveDate", getSolveDate())
                .append("solveReason", getSolveReason())
                .append("deptId", getDeptId())
                .append("alarmId", getAlarmId())
                .append("alarmType", getAlarmType())
                .append("earlyWarningType", getEarlyWarningType())
                .append("status", getStatus())
                .append("businessId", getBusinessId())
                .append("addUserId", getAddUserId())
                .append("createDate", getCreateDate())
                .append("meno", getMeno())
                .append("meno1", getMeno1())
                .append("meno2", getMeno2())
                .append("meno3", getMeno3())
                .append("updateDate", getUpdateDate())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}