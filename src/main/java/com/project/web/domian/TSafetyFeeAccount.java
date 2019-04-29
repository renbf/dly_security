package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 安全费用台账表 t_safety_fee_account
 *
 * @author rbf
 * @date 2019-04-18
 */
public class TSafetyFeeAccount extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 投入类型     #$
     */
    private String investmentType;
    /**
     * 经办人      #$
     */
    private String chargePerson;
    /**
     * 使用日期     ##
     */
    private Date useDate;
    /**
     * 金额       #
     */
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal amt;
    /**
     * 投入部门id
     */
    private String investmentDeptId;
    /**
     * 用途       #$
     */
    private String feePurpose;
    /**
     * 部门id     #
     */
    private String deptId;
    /**
     * 记录人
     */
    private String noteTaker;
    /**
     * 文件路径
     */
    private String feeFilePath;
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


    /*查询输入增加*/
    private Date useDate1;
    private Date createTime1;

    /*查询输出增加*/
    private String useDateStr;
    private String createTimeStr;


    public Date getUseDate1() {
        return useDate1;
    }

    public TSafetyFeeAccount setUseDate1(Date useDate1) {
        this.useDate1 = useDate1;
        return this;
    }

    public Date getCreateTime1() {
        return createTime1;
    }

    public TSafetyFeeAccount setCreateTime1(Date createTime1) {
        this.createTime1 = createTime1;
        return this;
    }

    public String getUseDateStr() {
        return useDateStr;
    }

    public TSafetyFeeAccount setUseDateStr(String useDateStr) {
        this.useDateStr = useDateStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TSafetyFeeAccount setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(String investmentType) {
        this.investmentType = investmentType;
    }

    public String getChargePerson() {
        return chargePerson;
    }

    public void setChargePerson(String chargePerson) {
        this.chargePerson = chargePerson;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getInvestmentDeptId() {
        return investmentDeptId;
    }

    public void setInvestmentDeptId(String investmentDeptId) {
        this.investmentDeptId = investmentDeptId;
    }

    public String getFeePurpose() {
        return feePurpose;
    }

    public void setFeePurpose(String feePurpose) {
        this.feePurpose = feePurpose;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getNoteTaker() {
        return noteTaker;
    }

    public void setNoteTaker(String noteTaker) {
        this.noteTaker = noteTaker;
    }

    public String getFeeFilePath() {
        return feeFilePath;
    }

    public void setFeeFilePath(String feeFilePath) {
        this.feeFilePath = feeFilePath;
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
                .append("investmentType", getInvestmentType())
                .append("chargePerson", getChargePerson())
                .append("useDate", getUseDate())
                .append("amt", getAmt())
                .append("investmentDeptId", getInvestmentDeptId())
                .append("feePurpose", getFeePurpose())
                .append("deptId", getDeptId())
                .append("noteTaker", getNoteTaker())
                .append("feeFilePath", getFeeFilePath())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("userId", getUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}