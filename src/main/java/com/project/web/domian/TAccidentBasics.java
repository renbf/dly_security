package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 事故基础表 t_accident_basics
 *
 * @author rbf
 * @date 2019-04-17
 */
public class TAccidentBasics extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 事故名称     #$
     */
    private String accidentName;
    /**
     * 事故类型     #   字典(accident_type)
     */
    private String accidentType;
    /**
     * 事故发生地    #$
     */
    private String accidentPlace;
    /**
     * 发生日期
     */
    private Date happenTime;
    /**
     * 事故损失
     */
    private String accidentLoss;
    /**
     * 责任人      #$
     */
    private String accidentResponsibility;
    /**
     * 责任人user_id
     */
    private Long responsibilityUserId;
    /**
     * 责任部门ID
     */
    private Long responsibilityDeptId;
    /**
     * 部门名称
     */
    private String responsibilityDeptName;
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

    /*查询出参增加*/
    private String happenTimeStr;
    private String createTimeStr;
    private String accidentTypeName;


    public String getHappenTimeStr() {
        return happenTimeStr;
    }

    public TAccidentBasics setHappenTimeStr(String happenTimeStr) {
        this.happenTimeStr = happenTimeStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TAccidentBasics setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public String getAccidentTypeName() {
        return accidentTypeName;
    }

    public TAccidentBasics setAccidentTypeName(String accidentTypeName) {
        this.accidentTypeName = accidentTypeName;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccidentName() {
        return accidentName;
    }

    public void setAccidentName(String accidentName) {
        this.accidentName = accidentName;
    }

    public String getAccidentType() {
        return accidentType;
    }

    public void setAccidentType(String accidentType) {
        this.accidentType = accidentType;
    }

    public String getAccidentPlace() {
        return accidentPlace;
    }

    public void setAccidentPlace(String accidentPlace) {
        this.accidentPlace = accidentPlace;
    }

    public Date getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Date happenTime) {
        this.happenTime = happenTime;
    }

    public String getAccidentLoss() {
        return accidentLoss;
    }

    public void setAccidentLoss(String accidentLoss) {
        this.accidentLoss = accidentLoss;
    }

    public String getAccidentResponsibility() {
        return accidentResponsibility;
    }

    public void setAccidentResponsibility(String accidentResponsibility) {
        this.accidentResponsibility = accidentResponsibility;
    }

    public Long getResponsibilityUserId() {
        return responsibilityUserId;
    }

    public void setResponsibilityUserId(Long responsibilityUserId) {
        this.responsibilityUserId = responsibilityUserId;
    }

    public Long getResponsibilityDeptId() {
        return responsibilityDeptId;
    }

    public void setResponsibilityDeptId(Long responsibilityDeptId) {
        this.responsibilityDeptId = responsibilityDeptId;
    }

    public String getResponsibilityDeptName() {
        return responsibilityDeptName;
    }

    public void setResponsibilityDeptName(String responsibilityDeptName) {
        this.responsibilityDeptName = responsibilityDeptName;
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
                .append("accidentName", getAccidentName())
                .append("accidentType", getAccidentType())
                .append("accidentPlace", getAccidentPlace())
                .append("happenTime", getHappenTime())
                .append("accidentLoss", getAccidentLoss())
                .append("accidentResponsibility", getAccidentResponsibility())
                .append("responsibilityUserId", getResponsibilityUserId())
                .append("responsibilityDeptId", getResponsibilityDeptId())
                .append("responsibilityDeptName", getResponsibilityDeptName())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("userId", getUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
