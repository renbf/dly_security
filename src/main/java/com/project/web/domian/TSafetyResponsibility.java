package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 安全责任表 t_safety_responsibility
 *
 * @author rbf
 * @date 2019-04-17
 */
public class TSafetyResponsibility extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * #文件名称*
     */
    private String responsibilityName;
    /**
     * ##日期*
     */
    private Date responsibilityDate;
    /**
     * #类型*
     */
    private String responsibilityType;
    /**
     * #部门id*
     */
    private String deptId;
    /**
     * 附件文件路径
     */
    private String responsibilityFilePath;
    /**
     * ##创建日期
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


    /*查询的入参添加*/
    //日期
    private Date responsibilityDate1;
    //创建日期
    private Date createTime1;


    /*出参的值添加*/
    //日期
    private String responsibilityDateStr;
    //创建日期
    private Date createTimeStr;

    public Date getResponsibilityDate1() {
        return responsibilityDate1;
    }

    public TSafetyResponsibility setResponsibilityDate1(Date responsibilityDate1) {
        this.responsibilityDate1 = responsibilityDate1;
        return this;
    }

    public Date getCreateTime1() {
        return createTime1;
    }

    public TSafetyResponsibility setCreateTime1(Date createTime1) {
        this.createTime1 = createTime1;
        return this;
    }

    public String getResponsibilityDateStr() {
        return responsibilityDateStr;
    }

    public TSafetyResponsibility setResponsibilityDateStr(String responsibilityDateStr) {
        this.responsibilityDateStr = responsibilityDateStr;
        return this;
    }

    public Date getCreateTimeStr() {
        return createTimeStr;
    }

    public TSafetyResponsibility setCreateTimeStr(Date createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResponsibilityName() {
        return responsibilityName;
    }

    public void setResponsibilityName(String responsibilityName) {
        this.responsibilityName = responsibilityName;
    }

    public Date getResponsibilityDate() {
        return responsibilityDate;
    }

    public void setResponsibilityDate(Date responsibilityDate) {
        this.responsibilityDate = responsibilityDate;
    }

    public String getResponsibilityType() {
        return responsibilityType;
    }

    public void setResponsibilityType(String responsibilityType) {
        this.responsibilityType = responsibilityType;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getResponsibilityFilePath() {
        return responsibilityFilePath;
    }

    public void setResponsibilityFilePath(String responsibilityFilePath) {
        this.responsibilityFilePath = responsibilityFilePath;
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
                .append("responsibilityName", getResponsibilityName())
                .append("responsibilityDate", getResponsibilityDate())
                .append("responsibilityType", getResponsibilityType())
                .append("deptId", getDeptId())
                .append("responsibilityFilePath", getResponsibilityFilePath())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("userId", getUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
