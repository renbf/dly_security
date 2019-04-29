package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 应急预案发布表 t_emergency_plan_release
 *
 * @author rbf
 * @date 2019-04-17
 */
public class TEmergencyPlanRelease extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 预案名称     #$
     */
    private String planName;
    /**
     * 是否执行  0:不执行  1:执行        #
     */
    private String isImplement;
    /**
     * 备案单位     #
     */
    private String recordUnit;
    /**
     * 备案日期
     */
    private Date recordDate;
    /**
     * 附件文件路径
     */
    private String filePath;
    /**
     * 发布日期
     */
    private Date releaseDate;
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
    private String recordDateStr;
    private String releaseDateStr;
    private String createTimeStr;


    public String getRecordDateStr() {
        return recordDateStr;
    }

    public TEmergencyPlanRelease setRecordDateStr(String recordDateStr) {
        this.recordDateStr = recordDateStr;
        return this;
    }

    public String getReleaseDateStr() {
        return releaseDateStr;
    }

    public TEmergencyPlanRelease setReleaseDateStr(String releaseDateStr) {
        this.releaseDateStr = releaseDateStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TEmergencyPlanRelease setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getIsImplement() {
        return isImplement;
    }

    public void setIsImplement(String isImplement) {
        this.isImplement = isImplement;
    }

    public String getRecordUnit() {
        return recordUnit;
    }

    public void setRecordUnit(String recordUnit) {
        this.recordUnit = recordUnit;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
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
                .append("planName", getPlanName())
                .append("isImplement", getIsImplement())
                .append("recordUnit", getRecordUnit())
                .append("recordDate", getRecordDate())
                .append("filePath", getFilePath())
                .append("releaseDate", getReleaseDate())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("userId", getUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}