package com.project.security.domain.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author rbf
 *
 */
public class UserPaperDetailVo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 考卷ID */
	private String paperId;
	/** 考卷时间 */
	private Integer paperTimes;
	/** 题库ID */
	private String subjectId;
	/** 题目 */
	private String subject;
	/** 注释 */
	private String annotation;
	/** 正确答案 */
	private String trueAnswer;
	/** 考卷类型 */
	private String subjectType;
	/** 题目分数 */
	private Integer subjectScore;
	/** 顺序 */
	private Integer subjectSort;
	/** 题目选项信息 */
	private List<Map<String,Object>> optionContents;
	/** 用户考卷ID */
	private String userPaperId;
	/** 状态0未答题，1已答题 */
	private String status;
	/** 考试分数 */
	private Integer paperScore;
	/** 答题开始时间 */
	private Date startDate;
	/** 交卷时间时间 */
	private Date commitDate;
	/** 用户答案 */
	private String userAnswer;
	/** 是否答对0否1是 */
	private String isTrue;
	/** 是否收藏本题1是0否 */
	private String isCollect;
	/** 题目选项 */
	private String optionValue;
	/** 题目内容 */
	private String content;
	/** 题目顺序 */
	private Integer optionSort;
	public String getPaperId() {
		return paperId;
	}
	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}
	public Integer getPaperTimes() {
		return paperTimes;
	}
	public void setPaperTimes(Integer paperTimes) {
		this.paperTimes = paperTimes;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAnnotation() {
		return annotation;
	}
	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
	public String getTrueAnswer() {
		return trueAnswer;
	}
	public void setTrueAnswer(String trueAnswer) {
		this.trueAnswer = trueAnswer;
	}
	public Integer getSubjectScore() {
		return subjectScore;
	}
	public void setSubjectScore(Integer subjectScore) {
		this.subjectScore = subjectScore;
	}
	public Integer getSubjectSort() {
		return subjectSort;
	}
	public void setSubjectSort(Integer subjectSort) {
		this.subjectSort = subjectSort;
	}
	
	public List<Map<String, Object>> getOptionContents() {
		return optionContents;
	}
	public void setOptionContents(List<Map<String, Object>> optionContents) {
		this.optionContents = optionContents;
	}
	public String getUserPaperId() {
		return userPaperId;
	}
	public void setUserPaperId(String userPaperId) {
		this.userPaperId = userPaperId;
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
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	public String getIsTrue() {
		return isTrue;
	}
	public void setIsTrue(String isTrue) {
		this.isTrue = isTrue;
	}
	public String getIsCollect() {
		return isCollect;
	}
	public void setIsCollect(String isCollect) {
		this.isCollect = isCollect;
	}
	public String getOptionValue() {
		return optionValue;
	}
	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getOptionSort() {
		return optionSort;
	}
	public void setOptionSort(Integer optionSort) {
		this.optionSort = optionSort;
	}
	public String getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}
	
	
}
