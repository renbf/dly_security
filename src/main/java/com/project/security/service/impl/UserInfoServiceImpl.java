package com.project.security.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.project.common.constant.Constants;
import com.project.common.constant.UserConstants;
import com.project.common.enums.UserStatus;
import com.project.common.result.DataResult;
import com.project.common.result.Result;
import com.project.framework.manager.AsyncManager;
import com.project.framework.manager.factory.AsyncFactory;
import com.project.framework.shiro.service.LoginService;
import com.project.framework.shiro.service.PasswordService;
import com.project.framework.util.MessageUtils;
import com.project.framework.web.exception.user.UserBlockedException;
import com.project.framework.web.exception.user.UserDeleteException;
import com.project.framework.web.exception.user.UserNotExistsException;
import com.project.security.service.IUserInfoService;
import com.project.system.domain.SysUser;
import com.project.system.service.ISysUserService;

/**
 * 
 * @author rbf
 *
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
	private static final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	@Autowired
	private ISysUserService userService;
	@Autowired
	private PasswordService passwordService;
	@Autowired
	private LoginService loginService;

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

			SysUser user = userService.selectUserByLoginName(userName);
			if (user == null) {
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
			mapResult.put("userId", user.getUserId());
			mapResult.put("isAuth", user.getIsAuth());
			result.setResult(mapResult);
			result.setMessage("登陆成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			throw new RuntimeException("登录接口异常");
		}
	}

}
