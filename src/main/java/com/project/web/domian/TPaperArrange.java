package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 考试安排表 t_paper_arrange
 *
 * @author rbf
 * @date 2019-05-06
 */
public class TPaperArrange extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;
    /**
     * 考卷类型
     */
    private String paperType;
    /**
     * 考卷id
     */
    private String paperId;
    /**
     * 考卷名称     #$
     */
    private String paperName;
    /**
     * 考试开始时间      ##
     */
    private Date startDate;
    /**
     * 考试结束时间
     */
    private Date endDate;
    /**
     * 创建时间     ##
     */
    private Date createDate;
    /**
     * 修改时间
     */
    private Date updateDate;
    /**
     * 创建人id
     */
    private String addUserId;
    /**
     * 修改人id
     */
    private String updateUserId;
    /**
     * 备用
     */
    private String meno;
    /**
     * 企业ID
     */
    private String businessId;


    /*查询输入新增*/
    private Date startDate1;
    private Date createDate1;

    /*查询输出新增*/
    //时间字符串
    private String startDateStr;
    private String endDateStr;
    private String createDateStr;
    //用户部门字符串 费用
    private String userDepts;
    //用户岗位字符串
    private String userPosts;
    //数量统计:考试用户数量,没考试数量,考完试数量.
    private String paperNum;
    private Integer notPaperNum;
    private Integer finishPaperNum;


    /*添加输入新增*/
    private List<String> userIds;
    //关联附表
    private List<TUserPaper> userPapers;


    public String getUserPosts() {
        return userPosts;
    }

    public TPaperArrange setUserPosts(String userPosts) {
        this.userPosts = userPosts;
        return this;
    }

    public Integer getNotPaperNum() {
        return notPaperNum;
    }

    public TPaperArrange setNotPaperNum(Integer notPaperNum) {
        this.notPaperNum = notPaperNum;
        return this;
    }

    public Integer getFinishPaperNum() {
        return finishPaperNum;
    }

    public TPaperArrange setFinishPaperNum(Integer finishPaperNum) {
        this.finishPaperNum = finishPaperNum;
        return this;
    }

    public Date getStartDate1() {
        return startDate1;
    }

    public TPaperArrange setStartDate1(Date startDate1) {
        this.startDate1 = startDate1;
        return this;
    }

    public Date getCreateDate1() {
        return createDate1;
    }

    public TPaperArrange setCreateDate1(Date createDate1) {
        this.createDate1 = createDate1;
        return this;
    }

    public String getUserDepts() {
        return userDepts;
    }

    public TPaperArrange setUserDepts(String userDepts) {
        this.userDepts = userDepts;
        return this;
    }

    public String getPaperNum() {
        return paperNum;
    }

    public TPaperArrange setPaperNum(String paperNum) {
        this.paperNum = paperNum;
        return this;
    }

    public List<TUserPaper> getUserPapers() {
        return userPapers;
    }

    public TPaperArrange setUserPapers(List<TUserPaper> userPapers) {
        this.userPapers = userPapers;
        return this;
    }

    public String getStartDateStr() {
        return startDateStr;
    }

    public TPaperArrange setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
        return this;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    public TPaperArrange setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
        return this;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public TPaperArrange setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
        return this;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public TPaperArrange setUserIds(List<String> userIds) {
        this.userIds = userIds;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
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

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("paperType", getPaperType())
                .append("paperId", getPaperId())
                .append("paperName", getPaperName())
                .append("startDate", getStartDate())
                .append("endDate", getEndDate())
                .append("createDate", getCreateDate())
                .append("updateDate", getUpdateDate())
                .append("addUserId", getAddUserId())
                .append("updateUserId", getUpdateUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .toString();
    }
}
