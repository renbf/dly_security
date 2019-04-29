package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 安全值班表 t_safety_duty
 *
 * @author rbf
 * @date 2019-04-18
 */
public class TSafetyDuty extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 值班类型     #
     */
    private String dutyType;
    /**
     * 值班人员     #$
     */
    private String dutyPerson;
    /**
     * 值班日期     ##
     */
    private Date dutyDate;
    /**
     * 登记日期
     */
    private Date registerDate;
    /**
     * 记录       #$
     */
    private String dutyRecord;
    /**
     * 部门id     #
     */
    private String deptId;
    /**
     * 附件文件路径
     */
    private String dutyFilePath;
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


    /*查询入参增加*/
    private Date dutyDate1;

    /*查询出参增加*/
    private String dutyDateStr;
    private String createTimeStr;



    public Date getDutyDate1() {
        return dutyDate1;
    }

    public TSafetyDuty setDutyDate1(Date dutyDate1) {
        this.dutyDate1 = dutyDate1;
        return this;
    }

    public String getDutyDateStr() {
        return dutyDateStr;
    }

    public TSafetyDuty setDutyDateStr(String dutyDateStr) {
        this.dutyDateStr = dutyDateStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TSafetyDuty setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDutyType() {
        return dutyType;
    }

    public void setDutyType(String dutyType) {
        this.dutyType = dutyType;
    }

    public String getDutyPerson() {
        return dutyPerson;
    }

    public void setDutyPerson(String dutyPerson) {
        this.dutyPerson = dutyPerson;
    }

    public Date getDutyDate() {
        return dutyDate;
    }

    public void setDutyDate(Date dutyDate) {
        this.dutyDate = dutyDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getDutyRecord() {
        return dutyRecord;
    }

    public void setDutyRecord(String dutyRecord) {
        this.dutyRecord = dutyRecord;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDutyFilePath() {
        return dutyFilePath;
    }

    public void setDutyFilePath(String dutyFilePath) {
        this.dutyFilePath = dutyFilePath;
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
                .append("dutyType", getDutyType())
                .append("dutyPerson", getDutyPerson())
                .append("dutyDate", getDutyDate())
                .append("registerDate", getRegisterDate())
                .append("dutyRecord", getDutyRecord())
                .append("deptId", getDeptId())
                .append("dutyFilePath", getDutyFilePath())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("userId", getUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}