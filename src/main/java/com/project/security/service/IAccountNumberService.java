package com.project.security.service;

import org.springframework.web.multipart.MultipartFile;

import com.project.common.result.DataResult;

/**
 * 
 * @author rbf
 *
 */
public interface IAccountNumberService {
	/**
	 * 轮播图和公告以及消息
	 * @param userId
	 * @return
	 */
	public DataResult bannerAndNotice(String userId);
	/**
	 * 行业动态
	 * @param pageNumber
	 * @return
	 */
	public DataResult industryDynamic(Integer pageNumber);
	
	/**
	 * 小知识查询
	 * @return
	 */
	public DataResult littleKnowledge(Integer pageNumber,String userId);
	
	/**
	 * 消息查询
	 * @return
	 */
	public DataResult userMessage(Integer pageNumber,String userId);
	
	/**
	 * 消息已读接口
	 * @return
	 */
	public DataResult readMessage(String messageId,String userId);
	
	/**
	 * 消息全部已读接口
	 * @return
	 */
	public DataResult readAllMessage(String userId);
	
	/**
	 * 课程安排接口
	 * @return
	 */
	public DataResult courseArrange(Integer pageNumber,String userId);
	
	/**
	 * 上传视频进度接口
	 * @return
	 */
	public DataResult uploadVideoProgress(String courseId,String userId,Long progress);
	
	/**
	 * 考试试卷接口
	 * @return
	 */
	public DataResult examPaper(Integer pageNumber,String userId);
	/**
	 * 考试试卷详情接口
	 * @return
	 */
	public DataResult examPaperDetail(String userPaperId);
	
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
	public DataResult videoCollection(String userId,String courseId);
	
	/**
	 * 收藏试题接口
	 * @return
	 */
	public DataResult subjectCollection(String userId,String subjectId);
	
	/**
	 * 检查计划接口
	 * @return
	 */
	public DataResult checkPlan(String userId,Integer pageNumber);
	
	/**
	 * 查询检查项接口
	 * @return
	 */
	public DataResult queryCheckProject(String inspectPlanId,String projectId);
	
	/**
	 * 保存检查项接口
	 * @return
	 */
	public DataResult saveCheckProject(String inspectTeamProjectJson);
	/**
	 * 完成检查计划接口
	 * @return
	 */
	public DataResult completeCheck(String inspectRecordJson,MultipartFile file);
	
	/**
	 * 上传隐患——查询部门等接口
	 * @return
	 */
	public DataResult queryHiddenDanger(String businessId);
	
	/**
	 * 上报隐患接口
	 * @return
	 */
	public DataResult uploadHiddenDanger(String dangerJson,MultipartFile file);
}
