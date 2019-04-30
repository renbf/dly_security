package com.project.security.service.impl;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.constant.Constants;
import com.project.common.constant.UserConstants;
import com.project.common.enums.UserStatus;
import com.project.common.result.DataResult;
import com.project.common.result.Result;
import com.project.framework.manager.AsyncManager;
import com.project.framework.manager.factory.AsyncFactory;
import com.project.framework.shiro.service.LoginService;
import com.project.framework.shiro.service.PasswordService;
import com.project.framework.util.FileUploadUtils;
import com.project.framework.util.MessageUtils;
import com.project.framework.util.ShiroUtils;
import com.project.security.domain.TUserClient;
import com.project.security.mapper.TUserClientMapper;
import com.project.security.mapper.UserMapper;
import com.project.security.service.IFileSystemService;
import com.project.security.service.IUserInfoService;
import com.project.system.domain.SysUser;

/**
 * 
 * @author rbf
 *
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
	private static final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	@Autowired
	private PasswordService passwordService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private IFileSystemService fileSystemService;
	@Autowired
	@Qualifier("userClientMapper")
	private TUserClientMapper userClientMapper;
	@Override
	public DataResult login(String userName, String passWord) {
		DataResult result = new DataResult();
		try {
			// 用户名或密码为空 错误
			if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)) {
				result.setMessage("用户名或密码为空");
				result.setStatus(Result.FAILED);
				return result;
			}
			passWord = new String(Base64.getDecoder().decode(passWord),"UTF-8");
			// 密码如果不在指定范围内 错误
			if (passWord.length() < UserConstants.PASSWORD_MIN_LENGTH
					|| passWord.length() > UserConstants.PASSWORD_MAX_LENGTH) {
				result.setMessage("密码不在指定范围内");
				result.setStatus(Result.FAILED);
				return result;
			}
			// 用户名不在指定范围内 错误
			if (userName.length() < UserConstants.USERNAME_MIN_LENGTH
					|| userName.length() > UserConstants.USERNAME_MAX_LENGTH) {
				result.setMessage("用户名不在指定范围内");
				result.setStatus(Result.FAILED);
				return result;
			}

			SysUser user = userMapper.selectUserByLoginName(userName);
			if (user == null) {
				result.setMessage("用户不存在");
				result.setStatus(Result.FAILED);
				return result;
			}
			if("00".equals(user.getUserType())) {
				result.setMessage("用户不存在");
				result.setStatus(Result.FAILED);
				return result;
			}
			
			if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
				AsyncManager.me().execute(AsyncFactory.recordLogininfor(userName, user.getDeptId(),
						Constants.LOGIN_FAIL, MessageUtils.message("user.password.delete")));
				result.setMessage("用户账号已被删除");
				result.setStatus(Result.FAILED);
				return result;
			}

			if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
				AsyncManager.me().execute(AsyncFactory.recordLogininfor(userName, user.getDeptId(),
						Constants.LOGIN_FAIL, MessageUtils.message("user.blocked", user.getRemark())));
				result.setMessage("用户已锁定");
				result.setStatus(Result.FAILED);
				return result;
			}

			if (!passwordService.matches(user, passWord)) {
				result.setMessage("用户密码错误");
				result.setStatus(Result.FAILED);
				return result;
			}

			AsyncManager.me().execute(AsyncFactory.recordLogininfor(userName, user.getDeptId(), Constants.LOGIN_SUCCESS,
					MessageUtils.message("user.login.success")));
			loginService.recordLoginInfo(user);
			Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("userId", user.getUserId().toString());
			mapResult.put("businessId", user.getBusinessId());
			mapResult.put("isAuth", user.getIsAuth());
			result.setResult(mapResult);
			result.setMessage("登陆成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("登录接口异常",e);
			throw new RuntimeException("登录接口异常");
		}
	}

	@Override
	public DataResult uploadAuthUrl(String userId, MultipartFile authImg) {
		DataResult result = new DataResult();
		try {
			boolean fileType = FileUploadUtils.checkImgFile(authImg);
			if(!fileType) {
				result.setMessage("上传图片类型错误");
				result.setStatus(Result.FAILED);
				return result;
			}
			String authUrl = fileSystemService.uploadFile(authImg);
			if(StringUtils.isEmpty(authUrl)) {
				result.setMessage("上传图片失败");
				result.setStatus(Result.FAILED);
				return result;
			}
			SysUser user = new SysUser();
			user.setIsAuth("1");
			user.setAuthUrl(authUrl);
			user.setUserId(Long.valueOf(userId));
			userMapper.updateUserAuth(user);
			result.setMessage("上传认证成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("上传认证接口异常",e);
			throw new RuntimeException("上传认证接口异常");
		}
	}
	
	@Override
	public DataResult changePassword(String userId, String oldPassword, String newPassword, String confirmPassword) {
		DataResult result = new DataResult();
        try {
        	oldPassword = new String(Base64.getDecoder().decode(oldPassword),"UTF-8");
        	newPassword = new String(Base64.getDecoder().decode(newPassword),"UTF-8");
        	confirmPassword = new String(Base64.getDecoder().decode(confirmPassword),"UTF-8");
        	SysUser user = userMapper.selectUserById(Long.valueOf(userId));
        	if (user == null) {
				result.setMessage("用户不存在");
				result.setStatus(Result.FAILED);
				return result;
			}
        	if (!passwordService.matches(user, oldPassword)) {
				result.setMessage("用户原始密码错误");
				result.setStatus(Result.FAILED);
				return result;
			}
        	// 密码如果不在指定范围内 错误
			if (newPassword.length() < UserConstants.PASSWORD_MIN_LENGTH
					|| newPassword.length() > UserConstants.PASSWORD_MAX_LENGTH) {
				result.setMessage("新密码不在指定范围内");
				result.setStatus(Result.FAILED);
				return result;
			}
			if(!newPassword.equals(confirmPassword)) {
				result.setMessage("新密码和确认密码不相同");
				result.setStatus(Result.FAILED);
				return result;
			}
			SysUser sysUser = new SysUser();
			sysUser.setUserId(user.getUserId());
			sysUser.setSalt(ShiroUtils.randomSalt());
			sysUser.setPassword(passwordService.encryptPassword(user.getLoginName(), newPassword, sysUser.getSalt()));
	        userMapper.updateUser(user);
			result.setMessage("修改密码成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("修改密码接口异常",e);
			throw new RuntimeException("修改密码接口异常");
		}
	}

	@Override
	public DataResult bindingCid(String userId, String clientId) {
		DataResult result = new DataResult();
        try {
        	Long userid = Long.valueOf(userId);
        	TUserClient userClient = userClientMapper.selectTUserClientById(userid);
        	TUserClient tUserClient = new TUserClient();
        	tUserClient.setClientId(clientId);
        	tUserClient.setUserId(userid);
        	if(userClient == null) {
        		userClientMapper.insertTUserClient(tUserClient);
        	}else {
        		userClientMapper.updateTUserClient(tUserClient);
        	}
			result.setMessage("绑定cid成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("绑定cid接口异常",e);
			throw new RuntimeException("绑定cid接口异常");
		}
	}
	
	
}
