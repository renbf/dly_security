package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 课程安排表 t_user_course
 *
 * @author rbf
 * @date 2019-04-23
 */
public class TUserCourse extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 课程安排表id      #
     */
    private String courseArrangeId;
    /**
     * 开始时间
     */
    private Date startDate;
    /**
     * 课程id
     */
    private String courseId;
    /**
     * 级别类型
     */
    private String levelType;
    /**
     * 学习状态0未学习1学习中2已完成         #
     */
    private String status;
    /**
     * 课时（秒）
     */
    private Long classHour;
    /**
     * 已观看秒数
     */
    private Long progress;
    /**
     * 是否收藏1是0否
     */
    private String isCollect;
    /**
     * 发布人id
     */
    private String addUserId;
    /**
     * 发布日期
     */
    private Date publishDate;
    /**
     * 修改时间
     */
    private Date updateDate;
    /**
     * 修改人id
     */
    private String updateUserId;


    /*查询输入新增*/
    private List<String> courseArrangeIds;
    //姓名        #$
    private String userName;
    //性别        #
    private String sex;
    //手机号       #$
    private String phonenumber;
    //岗位        #
    private String postId;
    //部门        #
    private String deptId;


    /*查询输出新增*/
    private String postName;
    //private String deptName;
    private String progressStr;
    private String courseName;


    public String getCourseName() {
        return courseName;
    }

    public TUserCourse setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public TUserCourse setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public TUserCourse setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public TUserCourse setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }

    public String getPostId() {
        return postId;
    }

    public TUserCourse setPostId(String postId) {
        this.postId = postId;
        return this;
    }

    public String getDeptId() {
        return deptId;
    }

    public TUserCourse setDeptId(String deptId) {
        this.deptId = deptId;
        return this;
    }

    public String getPostName() {
        return postName;
    }

    public TUserCourse setPostName(String postName) {
        this.postName = postName;
        return this;
    }

    //public String getDeptName() {
    //    return deptName;
    //}
    //
    //public TUserCourse setDeptName(String deptName) {
    //    this.deptName = deptName;
    //    return this;
    //}

    public String getProgressStr() {
        return progressStr;
    }

    public TUserCourse setProgressStr(String progressStr) {
        this.progressStr = progressStr;
        return this;
    }

    public List<String> getCourseArrangeIds() {
        return courseArrangeIds;
    }

    public TUserCourse setCourseArrangeIds(List<String> courseArrangeIds) {
        this.courseArrangeIds = courseArrangeIds;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCourseArrangeId() {
        return courseArrangeId;
    }

    public void setCourseArrangeId(String courseArrangeId) {
        this.courseArrangeId = courseArrangeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getClassHour() {
        return classHour;
    }

    public void setClassHour(Long classHour) {
        this.classHour = classHour;
    }

    public Long getProgress() {
        return progress;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }

    public String getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(String isCollect) {
        this.isCollect = isCollect;
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
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
                .append("userId", getUserId())
                .append("courseArrangeId", getCourseArrangeId())
                .append("startDate", getStartDate())
                .append("courseId", getCourseId())
                .append("levelType", getLevelType())
                .append("status", getStatus())
                .append("classHour", getClassHour())
                .append("progress", getProgress())
                .append("isCollect", getIsCollect())
                .append("addUserId", getAddUserId())
                .append("publishDate", getPublishDate())
                .append("updateDate", getUpdateDate())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
