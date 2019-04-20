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
	public DataResult videoCollection(String userId,String courseId,String isCollect);
	
	/**
	 * 收藏试题接口
	 * @return
	 */
	public DataResult subjectCollection(String userId,String subjectId,String isCollect);
	
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
	 * 隐患详情接口
	 * @return
	 */
	public DataResult queryHiddenDangerDetail(String dangerId);
	
	/**
	 * 上报隐患接口
	 * @return
	 */
	public DataResult uploadHiddenDanger(String dangerJson,MultipartFile file);
	/**
	 * 隐患整改接口
	 * @param userId
	 * @return
	 */
	public DataResult rectification(Integer pageNumber,String userId);
	
	/**
	 * 隐患整改提交接口
	 * @return
	 */
	public DataResult rectificationDetail(String dangerJson,MultipartFile file);
	
	/**
	 * 拒绝整改接口
	 * @return
	 */
	public DataResult refuseDochange(String dangerId,String refuseText);
	
	/**
	 * 隐患验收接口
	 * @return
	 */
	public DataResult rectificationCheck(Integer pageNumber,String userId);
	
	/**
	 * 提交隐患验收接口
	 * @return
	 */
	public DataResult rectificationClose(String dangerJson,MultipartFile file);
	/**
	 * 查询行车前需要日志参数接口
	 * @return
	 */
	public DataResult queryLogParamBefore(String businessId);
	/**
	 * 查询行车中需要日志参数接口
	 * @return
	 */
	public DataResult queryLogParamMiddle(String businessId);
	
	/**
	 * 查询行车后需要日志参数接口
	 * @return
	 */
	public DataResult queryLogParamAfter(String businessId);
	/**
	 * 添加行车前日志接口
	 * @return
	 */
	public DataResult addBeforeLog(String driverLogJson,MultipartFile file);
	/**
	 * 添加行车中日志接口
	 * @return
	 */
	public DataResult addMiddleLog(String driverLogJson,MultipartFile file);
	/**
	 * 添加行车后日志接口
	 * @return
	 */
	public DataResult addAfterLog(String driverLogJson,MultipartFile file);
	
	/**
	 * 查询日志详情——行车前接口
	 * @return
	 */
	public DataResult queryLogBeforeDetail(String driverLogId);
	/**
	 * 查询日志详情——行车中接口
	 * @return
	 */
	public DataResult queryLogMiddleDetail(String driverLogId);
	/**
	 * 查询日志详情——行车后接口
	 * @return
	 */
	public DataResult queryLogAfterDetail(String driverLogId);
	
	/**
	 * 查询日志接口
	 * @return
	 */
	public DataResult queryLog(Integer pageNumber,String userId);
	
	/**
	 * 我的考卷接口
	 * @return
	 */
	public DataResult myExam(Integer pageNumber,String userId);
	
	/**
	 * 我的课程收藏接口
	 * @return
	 */
	public DataResult courseCollection(Integer pageNumber,String userId);
	
	/**
	 * 我的考题收藏接口
	 * @return
	 */
	public DataResult examCollection(Integer pageNumber,String userId);
	/**
	 * 我的课程接口
	 * @return
	 */
	public DataResult myCourse(Integer pageNumber,String userId);
	/**
	 * 个人信息接口
	 * @return
	 */
	public DataResult getUserInfo(String userId);
}
