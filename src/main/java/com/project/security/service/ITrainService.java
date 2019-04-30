package com.project.security.service;

import org.springframework.web.multipart.MultipartFile;

import com.project.common.result.DataResult;

public interface ITrainService {
	/**
	 * 课程安排接口
	 * @return
	 */
	public DataResult courseArrange(Integer pageNumber,Long total,String userId);
	
	/**
	 * 上传视频进度接口
	 * @return
	 */
	public DataResult uploadVideoProgress(String userCourseId,Long progress);
	
	/**
	 * 考试试卷接口
	 * @return
	 */
	public DataResult examPaper(Integer pageNumber,Long total,String userId);
	/**
	 * 考试试卷详情接口
	 * @return
	 */
	public DataResult examPaperDetail(String userPaperId);
	/**
	 * 考试试卷详情接口
	 * @return
	 */
	public DataResult queryExamPaperDetail(String userPaperId);
	
	/**
	 * 提交题目接口
	 * @return
	 */
	public DataResult submitSubject(String userSubjectJson);
	
	/**
	 * 提交考卷接口
	 * @return
	 */
	public DataResult submitPaper(String userPaperId);
	/**
	 * 课时排名接口
	 * @return
	 */
	public DataResult courseRanking(String userId);
	
	/**
	 * 收藏视频接口
	 * @return
	 */
	public DataResult videoCollection(String userCourseId,String isCollect);
	
	/**
	 * 收藏试题接口
	 * @return
	 */
	public DataResult subjectCollection(String userId,String subjectId,String isCollect);
	
	/**
	 * 人脸图片识别认证接口
	 * @return
	 */
	public DataResult imgAuthentication(String userId,MultipartFile file);
	/**
	 * 查询是否开启认证接口
	 * @return
	 */
	public DataResult queryIsVerifyOn(String businessId);
	
	/**
	 * 课程简介h5
	 * @param courseId
	 * @return
	 */
	public String introductionUrl(String courseId);
}
