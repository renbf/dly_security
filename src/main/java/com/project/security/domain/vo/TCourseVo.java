package com.project.security.domain.vo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 课程表 t_course
 * 
 * @author rbf
 * @date 2019-04-16
 */
public class TCourseVo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 课程ID */
	private String id;
	/** 培训类型123 */
	private String trainingType;
	/** 课程分类id（字典表） */
	private String courseType;
	/** 课程图片url */
	private String courseUrl;
	/** 课程视频url */
	private String videoUrl;
	/** 课程文件url */
	private String fileUrl;
	/** 课程名称 */
	private String courseName;
	/** 企业分类id */
	private String businessType;
	/** 专业分类id */
	private String majorType;
	/** 是否计时1是0否 */
	private String isTiming;
	/** 是否收费1是0否 */
	private String isCharge;
	/** 价格 */
	private Long price;
	/** 预览分钟（秒） */
	private Long previewTimes;
	/** 视频总时长（秒） */
	private Long totalTimes;
	/** 文件观看时长（秒） */
	private Long watchTimes;
	/** 课程简介 */
	private String introduction;
	/** 课程来源 */
	private String courseSource;
	/** 企业ID */
	private String businessId;
	/** 状态 */
	private String status;
	/** 课程副标题 */
	private String courseTitle;
	/** 创建人id */
	@JsonIgnore
	private String addUserId;
	/** 创建时间 */
	@JsonIgnore
	private Date createDate;
	/** 修改时间 */
	@JsonIgnore
	private Date updateDate;
	/** 修改人id */
	@JsonIgnore
	private String updateUserId;
	//以上自动生成的尽量别动
	/** 用户课程ID */
	private String userCourseId;
	/** 用户ID */
	private String userId;
	/** 学习状态0未学习1学习中2已完成 */
	private String userCourseStatus;
	/** 课时（秒） */
	private Long classHour;
	/** 已观看秒数 */
	private Long progress;
	/** 百分比 */
	private Integer percentage;
	/** 是否收藏1是0否 */
	private String isCollect;
	/** 开始时间 */
	private Date startDate;
	/** 课程简介url */
	private String webUrl;
	
	public String getUserCourseId() {
		return userCourseId;
	}

	public void setUserCourseId(String userCourseId) {
		this.userCourseId = userCourseId;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setTrainingType(String trainingType) 
	{
		this.trainingType = trainingType;
	}

	public String getTrainingType() 
	{
		return trainingType;
	}
	public void setCourseType(String courseType) 
	{
		this.courseType = courseType;
	}

	public String getCourseType() 
	{
		return courseType;
	}
	public void setVideoUrl(String videoUrl) 
	{
		this.videoUrl = videoUrl;
	}

	public String getVideoUrl() 
	{
		return videoUrl;
	}
	public void setFileUrl(String fileUrl) 
	{
		this.fileUrl = fileUrl;
	}

	public String getFileUrl() 
	{
		return fileUrl;
	}
	public void setCourseName(String courseName) 
	{
		this.courseName = courseName;
	}

	public String getCourseName() 
	{
		return courseName;
	}
	public void setBusinessType(String businessType) 
	{
		this.businessType = businessType;
	}

	public String getBusinessType() 
	{
		return businessType;
	}
	public void setMajorType(String majorType) 
	{
		this.majorType = majorType;
	}

	public String getMajorType() 
	{
		return majorType;
	}
	public void setIsTiming(String isTiming) 
	{
		this.isTiming = isTiming;
	}

	public String getIsTiming() 
	{
		return isTiming;
	}
	public void setIsCharge(String isCharge) 
	{
		this.isCharge = isCharge;
	}

	public String getIsCharge() 
	{
		return isCharge;
	}
	public void setPrice(Long price) 
	{
		this.price = price;
	}

	public Long getPrice() 
	{
		return price;
	}
	public void setPreviewTimes(Long previewTimes) 
	{
		this.previewTimes = previewTimes;
	}

	public Long getPreviewTimes() 
	{
		return previewTimes;
	}
	public void setWatchTimes(Long watchTimes) 
	{
		this.watchTimes = watchTimes;
	}

	public Long getWatchTimes() 
	{
		return watchTimes;
	}
	public void setIntroduction(String introduction) 
	{
		this.introduction = introduction;
	}

	public String getIntroduction() 
	{
		return introduction;
	}
	public void setCourseSource(String courseSource) 
	{
		this.courseSource = courseSource;
	}

	public String getCourseSource() 
	{
		return courseSource;
	}
	public void setBusinessId(String businessId) 
	{
		this.businessId = businessId;
	}

	public String getBusinessId() 
	{
		return businessId;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setAddUserId(String addUserId) 
	{
		this.addUserId = addUserId;
	}

	public String getAddUserId() 
	{
		return addUserId;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setUpdateDate(Date updateDate) 
	{
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() 
	{
		return updateDate;
	}
	public void setUpdateUserId(String updateUserId) 
	{
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserId() 
	{
		return updateUserId;
	}

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserCourseStatus() {
		return userCourseStatus;
	}

	public void setUserCourseStatus(String userCourseStatus) {
		this.userCourseStatus = userCourseStatus;
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

	public String getCourseUrl() {
		return courseUrl;
	}

	public void setCourseUrl(String courseUrl) {
		this.courseUrl = courseUrl;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public Long getTotalTimes() {
		return totalTimes;
	}

	public void setTotalTimes(Long totalTimes) {
		this.totalTimes = totalTimes;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("trainingType", getTrainingType())
            .append("courseType", getCourseType())
            .append("videoUrl", getVideoUrl())
            .append("fileUrl", getFileUrl())
            .append("courseName", getCourseName())
            .append("businessType", getBusinessType())
            .append("majorType", getMajorType())
            .append("isTiming", getIsTiming())
            .append("isCharge", getIsCharge())
            .append("price", getPrice())
            .append("previewTimes", getPreviewTimes())
            .append("watchTimes", getWatchTimes())
            .append("introduction", getIntroduction())
            .append("courseSource", getCourseSource())
            .append("businessId", getBusinessId())
            .append("status", getStatus())
            .append("addUserId", getAddUserId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("updateUserId", getUpdateUserId())
            .append("courseUrl", getCourseUrl())
            .toString();
    }
}
