package com.project.web.domian;

import com.project.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 培训记录表 t_training_record
 *
 * @author rbf
 * @date 2019-04-17
 */
public class TTrainingRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 培训主题     #$
     */
    private String trainTheme;
    /**
     * 培训地点
     */
    private String trainPlace;
    /**
     * 培训讲师
     */
    private String trainLecturer;
    /**
     * 培训应到人数
     */
    private Integer trainSholudNum;
    /**
     * 培训实到人数
     */
    private Integer trainActNum;
    /**
     * 培训内容
     */
    private String trainInfo;
    /**
     * 培训日期     ##
     */
    private Date trainDate;
    /**
     * 是否考试 0:未安排考试  1:安排考试     #
     */
    private String isExamination;
    /**
     * 培训级别 1:公司  2:部门   3:岗位
     */
    private String trainLevel;
    /**
     * 培训时长
     */
    private Integer trainHour;
    /**
     * 效果评价
     */
    private String trainEffect;
    /**
     * 评价人
     */
    private String trainEffectPer;
    /**
     * 评价时间
     */
    private Date trainEffectDate;
    /**
     * 组织单位
     */
    private String formUnit;
    /**
     * 级别类型     字典项(train_level_type)
     */
    private String levelType;
    /**
     * 完成课时
     */
    private Integer finishClassHour;
    /**
     * 培训附件地址
     */
    private String trainFilePath;
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


    /*详情表关联*/
    private List<TTrainingRecordDetails> trainingRecordDetails;

    /*查询入参增加*/
    private Date trainDate1;
    /*查询出参增加*/
    private String trainDateStr;
    private String createTimeStr;
    private String levelTypeName;


    public Date getTrainDate1() {
        return trainDate1;
    }

    public TTrainingRecord setTrainDate1(Date trainDate1) {
        this.trainDate1 = trainDate1;
        return this;
    }

    public String getTrainDateStr() {
        return trainDateStr;
    }

    public TTrainingRecord setTrainDateStr(String trainDateStr) {
        this.trainDateStr = trainDateStr;
        return this;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public TTrainingRecord setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
        return this;
    }

    public String getLevelTypeName() {
        return levelTypeName;
    }

    public TTrainingRecord setLevelTypeName(String levelTypeName) {
        this.levelTypeName = levelTypeName;
        return this;
    }

    public List<TTrainingRecordDetails> getTrainingRecordDetails() {
        return trainingRecordDetails;
    }

    public TTrainingRecord setTrainingRecordDetails(List<TTrainingRecordDetails> trainingRecordDetails) {
        this.trainingRecordDetails = trainingRecordDetails;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainTheme() {
        return trainTheme;
    }

    public void setTrainTheme(String trainTheme) {
        this.trainTheme = trainTheme;
    }

    public String getTrainPlace() {
        return trainPlace;
    }

    public void setTrainPlace(String trainPlace) {
        this.trainPlace = trainPlace;
    }

    public String getTrainLecturer() {
        return trainLecturer;
    }

    public void setTrainLecturer(String trainLecturer) {
        this.trainLecturer = trainLecturer;
    }

    public Integer getTrainSholudNum() {
        return trainSholudNum;
    }

    public void setTrainSholudNum(Integer trainSholudNum) {
        this.trainSholudNum = trainSholudNum;
    }

    public Integer getTrainActNum() {
        return trainActNum;
    }

    public void setTrainActNum(Integer trainActNum) {
        this.trainActNum = trainActNum;
    }

    public String getTrainInfo() {
        return trainInfo;
    }

    public void setTrainInfo(String trainInfo) {
        this.trainInfo = trainInfo;
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public String getIsExamination() {
        return isExamination;
    }

    public void setIsExamination(String isExamination) {
        this.isExamination = isExamination;
    }

    public String getTrainLevel() {
        return trainLevel;
    }

    public void setTrainLevel(String trainLevel) {
        this.trainLevel = trainLevel;
    }

    public Integer getTrainHour() {
        return trainHour;
    }

    public void setTrainHour(Integer trainHour) {
        this.trainHour = trainHour;
    }

    public String getTrainEffect() {
        return trainEffect;
    }

    public void setTrainEffect(String trainEffect) {
        this.trainEffect = trainEffect;
    }

    public String getTrainEffectPer() {
        return trainEffectPer;
    }

    public void setTrainEffectPer(String trainEffectPer) {
        this.trainEffectPer = trainEffectPer;
    }

    public Date getTrainEffectDate() {
        return trainEffectDate;
    }

    public void setTrainEffectDate(Date trainEffectDate) {
        this.trainEffectDate = trainEffectDate;
    }

    public String getFormUnit() {
        return formUnit;
    }

    public void setFormUnit(String formUnit) {
        this.formUnit = formUnit;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public Integer getFinishClassHour() {
        return finishClassHour;
    }

    public void setFinishClassHour(Integer finishClassHour) {
        this.finishClassHour = finishClassHour;
    }

    public String getTrainFilePath() {
        return trainFilePath;
    }

    public void setTrainFilePath(String trainFilePath) {
        this.trainFilePath = trainFilePath;
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
                .append("trainTheme", getTrainTheme())
                .append("trainPlace", getTrainPlace())
                .append("trainLecturer", getTrainLecturer())
                .append("trainSholudNum", getTrainSholudNum())
                .append("trainActNum", getTrainActNum())
                .append("trainInfo", getTrainInfo())
                .append("trainDate", getTrainDate())
                .append("isExamination", getIsExamination())
                .append("trainLevel", getTrainLevel())
                .append("trainHour", getTrainHour())
                .append("trainEffect", getTrainEffect())
                .append("trainEffectPer", getTrainEffectPer())
                .append("trainEffectDate", getTrainEffectDate())
                .append("formUnit", getFormUnit())
                .append("levelType", getLevelType())
                .append("finishClassHour", getFinishClassHour())
                .append("trainFilePath", getTrainFilePath())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("userId", getUserId())
                .append("meno", getMeno())
                .append("businessId", getBusinessId())
                .append("updateUserId", getUpdateUserId())
                .toString();
    }
}
