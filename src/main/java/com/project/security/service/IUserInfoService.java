package com.project.security.service;

import org.springframework.web.multipart.MultipartFile;

import com.project.common.result.DataResult;

/**
 * 
 * @author rbf
 *
 */
public interface IUserInfoService {
	
	public DataResult login(String userName,String passWord);
	
	public DataResult uploadAuthUrl(String userId,MultipartFile authImg);
}
