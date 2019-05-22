package com.project.security.service;

import org.springframework.web.multipart.MultipartFile;

import com.project.common.result.DataResult;

/**
 * 
 * @author rbf
 *
 */
public interface IUserInfoService {
	/**
	 * 登录接口
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public DataResult login(String userName,String passWord);
	/**
	 * 上传认证接口
	 * @param userId
	 * @param authImg
	 * @return
	 */
	public DataResult uploadAuthUrl(String userId,MultipartFile authImg);
	
	/**
	 * 修改密码
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @param confirmPassword
	 * @return
	 */
	public DataResult changePassword(String userId,String oldPassword,String newPassword,String confirmPassword);
	/**
	 * 绑定用户cid
	 * @param userId
	 * @param clientId
	 * @return
	 */
	public DataResult bindingCid(String userId,String clientId,String source);
}
