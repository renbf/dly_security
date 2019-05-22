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
	public DataResult bannerAndNotice();
	/**
	 * 是否有新消息
	 * @param userId
	 * @return
	 */
	public DataResult checkIsHaveMsg(String userId);
	/**
	 * 行业动态
	 * @param pageNumber
	 * @return
	 */
	public DataResult industryDynamic(Integer pageNumber,Long total);
	
	/**
	 * 小知识查询
	 * @return
	 */
	public DataResult littleKnowledge(Integer pageNumber,Long total,String userId);
	
	/**
	 * 消息查询
	 * @return
	 */
	public DataResult userMessage(Integer pageNumber,Long total,String userId);
	
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
	 * 我的考卷接口
	 * @return
	 */
	public DataResult myExam(Integer pageNumber,Long total,String userId);
	
	/**
	 * 我的课程收藏接口
	 * @return
	 */
	public DataResult courseCollection(Integer pageNumber,Long total,String userId);
	
	/**
	 * 我的考题收藏接口
	 * @return
	 */
	public DataResult examCollection(Integer pageNumber,Long total,String userId);
	/**
	 * 我的课程接口
	 * @return
	 */
	public DataResult myCourse(Integer pageNumber,Long total,String userId);
	/**
	 * 个人信息接口
	 * @return
	 */
	public DataResult getUserInfo(String userId);
	/**
	 * 搜索课程接口
	 * @return
	 */
	public DataResult searchCource(Integer pageNumber,Long total,String userId,String searchKey);
}
