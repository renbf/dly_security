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
	
	
}
