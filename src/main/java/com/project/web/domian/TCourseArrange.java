package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 课程安排表 t_course_arrange
 *
 * @author rbf
 * @date 2019-04-30
 */
public class TCourseArrange extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 开始时间
     */
    private Date startDate;
    /**
     * 课程类型     #
     */
    private String courseType;
    /**
     * 课程id
     */
    private String courseId;
    /**
     * 级别类型
     */
    private String levelType;
    /**
     * 创建时间     ##
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 创建人id
     */
    private String addUserId;
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
    private String updateUserId;

    /*查询输入新增*/
    //^^课程名称        #$
    private String courseName;
    //安排学习人数        #$?#?>?<
    private String studyNum;
    private String studyNum1;
    /*查询输出新增*/
    private Integer notStudyNum;
    private Integer StudyingNum;
    private Integer finishStudyNum;
    private List<TUserCourse> userCourses;

    private String startDateStr;
    private String createTimeStr;

    /*添加输入新增*/
    private List<String> userIds;


    public String getStudyNum1() {
        return studyNum1;
    }

    public TCourseArrange setStudyNum1(String studyNum1) {
        this.studyNum1 = studyNum1;
        return this;
    }

    public String getStartDateStr() {
        return startDateStr;
    }

    public TCourseArrange setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TCourseArrange setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public List<TUserCourse> getUserCourses() {
        return userCourses;
    }

    public TCourseArrange setUserCourses(List<TUserCourse> userCourses) {
        this.userCourses = userCourses;
        return this;
    }

    public String getCourseName() {
        return courseName;
    }

    public TCourseArrange setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public String getStudyNum() {
        return studyNum;
    }

    public TCourseArrange setStudyNum(String studyNum) {
        this.studyNum = studyNum;
        return this;
    }

    public Integer getNotStudyNum() {
        return notStudyNum;
    }

    public TCourseArrange setNotStudyNum(Integer notStudyNum) {
        this.notStudyNum = notStudyNum;
        return this;
    }

    public Integer getStudyingNum() {
        return StudyingNum;
    }

    public TCourseArrange setStudyingNum(Integer studyingNum) {
        StudyingNum = studyingNum;
        return this;
    }

    public Integer getFinishStudyNum() {
        return finishStudyNum;
    }

    public TCourseArrange setFinishStudyNum(Integer finishStudyNum) {
        this.finishStudyNum = finishStudyNum;
        return this;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public TCourseArrange setUserIds(List<String> userIds) {
        this.userIds = userIds;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
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

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
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

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("startDate", getStartDate())
                .append("courseType", getCourseType())
                .append("courseId", getCourseId())
                .append("levelType", getLevelType())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("addUserId", getAddUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
