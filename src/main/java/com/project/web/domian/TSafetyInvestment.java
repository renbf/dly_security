package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 安全投入表 t_safety_investment
 *
 * @author rbf
 * @date 2019-04-23
 */
public class TSafetyInvestment extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 文件名称
     */
    private String responsibilityName;
    /**
     * 投入年份     #
     */
    private Integer investmentYear;
    /**
     * 投入月份     #
     */
    private Integer investmentMonth;
    /**
     * 投入比例
     */
    private String investmentRatio;
    /**
     * 投入金额
     */
    private Long investmentAmt;
    /**
     * 投入类型     #
     */
    private String investmentType;
    /**
     * 部门id     #
     */
    private String deptId;
    /**
     * 用途       #$
     */
    private String investmentPurpose;
    /**
     * 备注
     */
    private String investmentRemark;
    /**
     * 文件路径
     */
    private String investmentFilePath;
    /**
     * 创建日期     ##
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


    /*查询搜索添加的值*/
    //创建时间
    private Date createTime1;

    /*查询返回的字段添加*/
    private String createTimeStr;
    //投入类型数据字典字段
    private String investmentTypeName;


    public String getInvestmentTypeName() {
        return investmentTypeName;
    }

    public TSafetyInvestment setInvestmentTypeName(String investmentTypeName) {
        this.investmentTypeName = investmentTypeName;
        return this;
    }

    public Date getCreateTime1() {
        return createTime1;
    }

    public TSafetyInvestment setCreateTime1(Date createTime1) {
        this.createTime1 = createTime1;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TSafetyInvestment setCreateTimeStr(String createTimeStr) {
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

    public Integer getInvestmentYear() {
        return investmentYear;
    }

    public void setInvestmentYear(Integer investmentYear) {
        this.investmentYear = investmentYear;
    }

    public Integer getInvestmentMonth() {
        return investmentMonth;
    }

    public void setInvestmentMonth(Integer investmentMonth) {
        this.investmentMonth = investmentMonth;
    }

    public String getInvestmentRatio() {
        return investmentRatio;
    }

    public void setInvestmentRatio(String investmentRatio) {
        this.investmentRatio = investmentRatio;
    }

    public Long getInvestmentAmt() {
        return investmentAmt;
    }

    public void setInvestmentAmt(Long investmentAmt) {
        this.investmentAmt = investmentAmt;
    }

    public String getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(String investmentType) {
        this.investmentType = investmentType;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getInvestmentPurpose() {
        return investmentPurpose;
    }

    public void setInvestmentPurpose(String investmentPurpose) {
        this.investmentPurpose = investmentPurpose;
    }

    public String getInvestmentRemark() {
        return investmentRemark;
    }

    public void setInvestmentRemark(String investmentRemark) {
        this.investmentRemark = investmentRemark;
    }

    public String getInvestmentFilePath() {
        return investmentFilePath;
    }

    public void setInvestmentFilePath(String investmentFilePath) {
        this.investmentFilePath = investmentFilePath;
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
                .append("investmentYear", getInvestmentYear())
                .append("investmentMonth", getInvestmentMonth())
                .append("investmentRatio", getInvestmentRatio())
                .append("investmentAmt", getInvestmentAmt())
                .append("investmentType", getInvestmentType())
                .append("deptId", getDeptId())
                .append("investmentPurpose", getInvestmentPurpose())
                .append("investmentRemark", getInvestmentRemark())
                .append("investmentFilePath", getInvestmentFilePath())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("userId", getUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
