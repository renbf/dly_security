package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 事故分析专题会议表 t_accident_analysis_topic
 *
 * @author rbf
 * @date 2019-04-17
 */
public class TAccidentAnalysisTopic extends BaseEntity {
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
     * 会议名称
     */
    private String topicName;
    /**
     * 会议编号
     */
    private String topicCode;
    /**
     * 会议形式
     */
    private String topicType;
    /**
     * 会议日期
     */
    private Date topicDate;
    /**
     * 会议主持人
     */
    private String topicHost;
    /**
     * 会议记录人
     */
    private String topicNoteTaker;
    /**
     * 应到人数
     */
    private Integer shouldNum;
    /**
     * 实到人数
     */
    private Integer actNum;
    /**
     * 所属部门ID
     */
    private Long deptId;
    /**
     * 所属部门名称
     */
    private String deptName;
    /**
     * 会议地点
     */
    private String topicPlace;
    /**
     * 会议内容
     */
    private String topicInfo;
    /**
     * 事故原因
     */
    private String accidentReason;
    /**
     * 企业存在问题
     */
    private String enterpriseProblem;
    /**
     * 整改以及防范措施
     */
    private String rectificationPreventiveMeasures;
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
     * 系统分类 默认0:陆航系统
     */
    private String systemType;
    /**
     * 修改用户ID
     */
    private Long updateUserId;


    /*查询输出新增*/
    private String topicDateStr;
    private String createTimeStr;


    public String getTopicDateStr() {
        return topicDateStr;
    }

    public TAccidentAnalysisTopic setTopicDateStr(String topicDateStr) {
        this.topicDateStr = topicDateStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TAccidentAnalysisTopic setCreateTimeStr(String createTimeStr) {
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

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicCode() {
        return topicCode;
    }

    public void setTopicCode(String topicCode) {
        this.topicCode = topicCode;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public Date getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(Date topicDate) {
        this.topicDate = topicDate;
    }

    public String getTopicHost() {
        return topicHost;
    }

    public void setTopicHost(String topicHost) {
        this.topicHost = topicHost;
    }

    public String getTopicNoteTaker() {
        return topicNoteTaker;
    }

    public void setTopicNoteTaker(String topicNoteTaker) {
        this.topicNoteTaker = topicNoteTaker;
    }

    public Integer getShouldNum() {
        return shouldNum;
    }

    public void setShouldNum(Integer shouldNum) {
        this.shouldNum = shouldNum;
    }

    public Integer getActNum() {
        return actNum;
    }

    public void setActNum(Integer actNum) {
        this.actNum = actNum;
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

    public String getTopicPlace() {
        return topicPlace;
    }

    public void setTopicPlace(String topicPlace) {
        this.topicPlace = topicPlace;
    }

    public String getTopicInfo() {
        return topicInfo;
    }

    public void setTopicInfo(String topicInfo) {
        this.topicInfo = topicInfo;
    }

    public String getAccidentReason() {
        return accidentReason;
    }

    public void setAccidentReason(String accidentReason) {
        this.accidentReason = accidentReason;
    }

    public String getEnterpriseProblem() {
        return enterpriseProblem;
    }

    public void setEnterpriseProblem(String enterpriseProblem) {
        this.enterpriseProblem = enterpriseProblem;
    }

    public String getRectificationPreventiveMeasures() {
        return rectificationPreventiveMeasures;
    }

    public void setRectificationPreventiveMeasures(String rectificationPreventiveMeasures) {
        this.rectificationPreventiveMeasures = rectificationPreventiveMeasures;
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

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
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
                .append("topicName", getTopicName())
                .append("topicCode", getTopicCode())
                .append("topicType", getTopicType())
                .append("topicDate", getTopicDate())
                .append("topicHost", getTopicHost())
                .append("topicNoteTaker", getTopicNoteTaker())
                .append("shouldNum", getShouldNum())
                .append("actNum", getActNum())
                .append("deptId", getDeptId())
                .append("deptName", getDeptName())
                .append("topicPlace", getTopicPlace())
                .append("topicInfo", getTopicInfo())
                .append("accidentReason", getAccidentReason())
                .append("enterpriseProblem", getEnterpriseProblem())
                .append("rectificationPreventiveMeasures", getRectificationPreventiveMeasures())
                .append("remark", getRemark())
                .append("filePath", getFilePath())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("userId", getUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("systemType", getSystemType())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}