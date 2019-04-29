package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * 安全会议表 t_safety_meet
 *
 * @author rbf
 * @date 2019-04-24
 */
public class TSafetyMeet extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 会议类型ID_字典(t_dict)(safety_meet_type)    #
     */
    private String meetType;
    /**
     * 会议名称     #$
     */
    private String meetName;
    /**
     * 应到人数
     */
    private Integer meetShouldNum;
    /**
     * 实到人数
     */
    private Integer meetActNum;
    /**
     * 会议日期     ##
     */
    private Date meetDate;
    /**
     * 会议地点
     */
    private String meetPlace;
    /**
     * 会议形式ID_字典(t_dict)(safety_meet_form)    #
     */
    private String meetForm;
    /**
     * 会议部门ID_(sys_dept)
     */
    private Long meetDeptId;
    /**
     * 主持人      #$
     */
    private String hostPer;
    /**
     * 标注
     */
    private String tagging;
    /**
     * 记录人
     */
    private String noteTaker;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 会议内容
     */
    private String meetInfo;
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


    /*关联会议人员详情表*/
    private List<TSafetyMeetDetail> safetyMeetDetails;


    /*查询入参增加*/
    private Date meetDate1;
    private Date createTime1;
    /*查询出参增加*/
    private String meetDateStr;
    private String createTimeStr;
    //出参的表join内容
    private String meetTypeName;
    private String meetFormName;
    private String meetDeptName;



    public String getMeetTypeName() {
        return meetTypeName;
    }

    public TSafetyMeet setMeetTypeName(String meetTypeName) {
        this.meetTypeName = meetTypeName;
        return this;
    }

    public String getMeetFormName() {
        return meetFormName;
    }

    public TSafetyMeet setMeetFormName(String meetFormName) {
        this.meetFormName = meetFormName;
        return this;
    }

    public String getMeetDeptName() {
        return meetDeptName;
    }

    public TSafetyMeet setMeetDeptName(String meetDeptName) {
        this.meetDeptName = meetDeptName;
        return this;
    }

    public Date getMeetDate1() {
        return meetDate1;
    }

    public TSafetyMeet setMeetDate1(Date meetDate1) {
        this.meetDate1 = meetDate1;
        return this;
    }

    public Date getCreateTime1() {
        return createTime1;
    }

    public TSafetyMeet setCreateTime1(Date createTime1) {
        this.createTime1 = createTime1;
        return this;
    }

    public String getMeetDateStr() {
        return meetDateStr;
    }

    public TSafetyMeet setMeetDateStr(String meetDateStr) {
        this.meetDateStr = meetDateStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TSafetyMeet setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public List<TSafetyMeetDetail> getSafetyMeetDetails() {
        return safetyMeetDetails;
    }

    public TSafetyMeet setSafetyMeetDetails(List<TSafetyMeetDetail> safetyMeetDetails) {
        this.safetyMeetDetails = safetyMeetDetails;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMeetType() {
        return meetType;
    }

    public void setMeetType(String meetType) {
        this.meetType = meetType;
    }

    public String getMeetName() {
        return meetName;
    }

    public void setMeetName(String meetName) {
        this.meetName = meetName;
    }

    public Integer getMeetShouldNum() {
        return meetShouldNum;
    }

    public void setMeetShouldNum(Integer meetShouldNum) {
        this.meetShouldNum = meetShouldNum;
    }

    public Integer getMeetActNum() {
        return meetActNum;
    }

    public void setMeetActNum(Integer meetActNum) {
        this.meetActNum = meetActNum;
    }

    public Date getMeetDate() {
        return meetDate;
    }

    public void setMeetDate(Date meetDate) {
        this.meetDate = meetDate;
    }

    public String getMeetPlace() {
        return meetPlace;
    }

    public void setMeetPlace(String meetPlace) {
        this.meetPlace = meetPlace;
    }

    public String getMeetForm() {
        return meetForm;
    }

    public void setMeetForm(String meetForm) {
        this.meetForm = meetForm;
    }

    public Long getMeetDeptId() {
        return meetDeptId;
    }

    public void setMeetDeptId(Long meetDeptId) {
        this.meetDeptId = meetDeptId;
    }

    public String getHostPer() {
        return hostPer;
    }

    public void setHostPer(String hostPer) {
        this.hostPer = hostPer;
    }

    public String getTagging() {
        return tagging;
    }

    public void setTagging(String tagging) {
        this.tagging = tagging;
    }

    public String getNoteTaker() {
        return noteTaker;
    }

    public void setNoteTaker(String noteTaker) {
        this.noteTaker = noteTaker;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getMeetInfo() {
        return meetInfo;
    }

    public void setMeetInfo(String meetInfo) {
        this.meetInfo = meetInfo;
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
                .append("meetType", getMeetType())
                .append("meetName", getMeetName())
                .append("meetShouldNum", getMeetShouldNum())
                .append("meetActNum", getMeetActNum())
                .append("meetDate", getMeetDate())
                .append("meetPlace", getMeetPlace())
                .append("meetForm", getMeetForm())
                .append("meetDeptId", getMeetDeptId())
                .append("hostPer", getHostPer())
                .append("tagging", getTagging())
                .append("noteTaker", getNoteTaker())
                .append("filePath", getFilePath())
                .append("meetInfo", getMeetInfo())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("userId", getUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}