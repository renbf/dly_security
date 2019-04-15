package com.project.security.service;

import com.project.common.result.DataResult;

/**
 * 
 * @author rbf
 *
 */
public interface IUserInfoService {

	public DataResult login(String userName,String passWord);
}
