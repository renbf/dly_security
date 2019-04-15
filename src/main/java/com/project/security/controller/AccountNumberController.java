package com.project.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.common.result.DataResult;
import com.project.common.result.Result;
import com.project.security.service.IUserInfoService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("safety/accountNumber")
@Api(value="路航登录",description="登录")
public class AccountNumberController {
	private static final Logger log = LoggerFactory.getLogger(AccountNumberController.class);
	@Autowired
	private IUserInfoService userInfoService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ApiOperation(value="登录",httpMethod="POST",response=Result.class)
	public @ResponseBody Result login(HttpServletRequest request,
										 @ApiParam(name="userName",value="用户名",required=true) String userName,
										 @ApiParam(name="passWord",value="密码",required=true) String passWord
	){
		DataResult result=new DataResult();
		try {
			result = userInfoService.login(userName, passWord);
			return result;
		} catch (Exception e) {
			log.error("用户登录失败",e);
			result.setMessage("用户登录失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
}
