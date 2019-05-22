package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 检查记录表 t_inspect_record
 *
 * @author rbf
 * @date 2019-04-23
 */
public class TInspectRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;
    /**
     * 检查计划id
     */
    private String inspectPlanId;
    /**
     * 检查人id
     */
    private String checkUserId;
    /**
     * 检查对象     #$
     */
    private String checkObj;
    /**
     * 检查结果1通过0未通过      #
     */
    private String checkResult;
    /**
     * 检查日期     ##
     */
    private Date checkDate;
    /**
     * 检查类型     #
     */
    private String checkType;
    /**
     * 检查人签字
     */
    private String userSignUrl;


    /*查询输入新增*/
    private String checkDate1;
    //检查人姓名     #$
    private String checkUserName;


    /*查询输出新增*/
    private String checkDateStr;


    public String getCheckDateStr() {
        return checkDateStr;
    }

    public TInspectRecord setCheckDateStr(String checkDateStr) {
        this.checkDateStr = checkDateStr;
        return this;
    }

    public String getCheckUserName() {
        return checkUserName;
    }

    public TInspectRecord setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
        return this;
    }

    public String getCheckDate1() {
        return checkDate1;
    }

    public TInspectRecord setCheckDate1(String checkDate1) {
        this.checkDate1 = checkDate1;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInspectPlanId() {
        return inspectPlanId;
    }

    public void setInspectPlanId(String inspectPlanId) {
        this.inspectPlanId = inspectPlanId;
    }

    public String getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(String checkUserId) {
        this.checkUserId = checkUserId;
    }

    public String getCheckObj() {
        return checkObj;
    }

    public void setCheckObj(String checkObj) {
        this.checkObj = checkObj;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getUserSignUrl() {
        return userSignUrl;
    }

    public void setUserSignUrl(String userSignUrl) {
        this.userSignUrl = userSignUrl;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("inspectPlanId", getInspectPlanId())
                .append("checkUserId", getCheckUserId())
                .append("checkObj", getCheckObj())
                .append("checkResult", getCheckResult())
                .append("checkDate", getCheckDate())
                .append("checkType", getCheckType())
                .append("userSignUrl", getUserSignUrl())
                .toString();
    }
}
