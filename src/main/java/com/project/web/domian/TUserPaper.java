package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 用户考试安排(附属)表 t_user_paper
 *
 * @author rbf
 * @date 2019-05-06
 */
public class TUserPaper extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;
    /**
     * (主表)考试安排ID
     */
    private String paperArrangeId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 考卷ID
     */
    private String paperId;
    /**
     * 考试开始日期
     */
    private Date beginDate;
    /**
     * 考试结束日期
     */
    private Date endDate;
    /**
     * 状态0未答题，1已答题,2已答完
     */
    private String status;
    /**
     * 考试分数
     */
    private Integer paperScore;
    /**
     * 答题开始时间
     */
    private Date startDate;
    /**
     * 交卷时间时间
     */
    private Date commitDate;
    /**
     * 发布人id
     */
    private String addUserId;
    /**
     * 发布时间
     */
    private Date createDate;
    /**
     * 修改时间
     */
    private Date updateDate;
    /**
     * 修改人id
     */
    private String updateUserId;


    /*查询输入新增*/
    //姓名    #$
    private String userName;
    //性别    #
    private String sex;
    //手机号   #$
    private String phonenumber;
    //岗位    #
    private String deptId;
    //部门    #
    private String postId;
    private List<String> paperArrangeIds;

    /*查询输出新增*/
    private String postName;
    private String paperName;


    public String getPaperName() {
        return paperName;
    }

    public TUserPaper setPaperName(String paperName) {
        this.paperName = paperName;
        return this;
    }



    public String getPostName() {
        return postName;
    }

    public TUserPaper setPostName(String postName) {
        this.postName = postName;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public TUserPaper setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public TUserPaper setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public TUserPaper setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }

    public String getDeptId() {
        return deptId;
    }

    public TUserPaper setDeptId(String deptId) {
        this.deptId = deptId;
        return this;
    }

    public String getPostId() {
        return postId;
    }

    public TUserPaper setPostId(String postId) {
        this.postId = postId;
        return this;
    }

    public List<String> getPaperArrangeIds() {
        return paperArrangeIds;
    }

    public TUserPaper setPaperArrangeIds(List<String> paperArrangeIds) {
        this.paperArrangeIds = paperArrangeIds;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaperArrangeId() {
        return paperArrangeId;
    }

    public void setPaperArrangeId(String paperArrangeId) {
        this.paperArrangeId = paperArrangeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(Integer paperScore) {
        this.paperScore = paperScore;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(Date commitDate) {
        this.commitDate = commitDate;
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("paperArrangeId", getPaperArrangeId())
                .append("userId", getUserId())
                .append("paperId", getPaperId())
                .append("beginDate", getBeginDate())
                .append("endDate", getEndDate())
                .append("status", getStatus())
                .append("paperScore", getPaperScore())
                .append("startDate", getStartDate())
                .append("commitDate", getCommitDate())
                .append("addUserId", getAddUserId())
                .append("createDate", getCreateDate())
                .append("updateDate", getUpdateDate())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
