package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 三品查处记录表 t_three_products
 *
 * @author rbf
 * @date 2019-04-17
 */
public class TThreeProducts extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 检查日期     ##
     */
    private Date checkDate;
    /**
     * 物品名称     #$
     */
    private String goodsName;
    /**
     * 物品类型     #       字典项(three_products_goods_type)
     */
    private String goodsType;
    /**
     * 检查人员     #$
     */
    private String checkPersonnel;
    /**
     * 检查结果     #$
     */
    private String resultInfo;
    /**
     * 备注
     */
    private String remark;
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


    /*查询入参新增*/
    private Date checkDate1;


    /*查询出参新增*/
    private String checkDateStr;
    private String createTimeStr;
    private String goodsTypeName;



    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public TThreeProducts setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
        return this;
    }

    public Date getCheckDate1() {
        return checkDate1;
    }

    public TThreeProducts setCheckDate1(Date checkDate1) {
        this.checkDate1 = checkDate1;
        return this;
    }

    public String getCheckDateStr() {
        return checkDateStr;
    }

    public TThreeProducts setCheckDateStr(String checkDateStr) {
        this.checkDateStr = checkDateStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TThreeProducts setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getCheckPersonnel() {
        return checkPersonnel;
    }

    public void setCheckPersonnel(String checkPersonnel) {
        this.checkPersonnel = checkPersonnel;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
                .append("checkDate", getCheckDate())
                .append("goodsName", getGoodsName())
                .append("goodsType", getGoodsType())
                .append("checkPersonnel", getCheckPersonnel())
                .append("resultInfo", getResultInfo())
                .append("remark", getRemark())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("userId", getUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
