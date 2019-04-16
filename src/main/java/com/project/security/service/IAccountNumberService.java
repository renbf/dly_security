package com.project.security.service;

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
	public DataResult examPaperDetail(String userId);
}
