package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 培训记录详情表 t_training_record_details
 *
 * @author rbf
 * @date 2019-04-26
 */
public class TTrainingRecordDetails extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 培训记录表 主键id
     */
    private String trainingId;
    /**
     * 参与部门
     */
    private Long participateDeptId;
    /**
     * 参与岗位
     */
    private Long participatePost;
    /**
     * 参与人员 id
     */
    private Long participateUser;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public Long getParticipateDeptId() {
        return participateDeptId;
    }

    public void setParticipateDeptId(Long participateDeptId) {
        this.participateDeptId = participateDeptId;
    }

    public Long getParticipatePost() {
        return participatePost;
    }

    public void setParticipatePost(Long participatePost) {
        this.participatePost = participatePost;
    }

    public Long getParticipateUser() {
        return participateUser;
    }

    public void setParticipateUser(Long participateUser) {
        this.participateUser = participateUser;
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
                .append("trainingId", getTrainingId())
                .append("participateDeptId", getParticipateDeptId())
                .append("participatePost", getParticipatePost())
                .append("participateUser", getParticipateUser())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("userId", getUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
