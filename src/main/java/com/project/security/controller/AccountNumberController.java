package com.project.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.result.DataResult;
import com.project.common.result.Result;
import com.project.security.service.IAccountNumberService;
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
	@Autowired
	private IAccountNumberService accountNumberService;
	
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
	
	@RequestMapping(value="/auth",method=RequestMethod.POST)
	@ApiOperation(value="上传认证",httpMethod="POST",response=Result.class)
	public @ResponseBody Result auth(HttpServletRequest request,
										 @ApiParam(name="userId",value="密码",required=true) String userId,
										 @ApiParam(name="authImg",value="上传图片",required=true) MultipartFile authImg
	){
		DataResult result=new DataResult();
		try {
			result = userInfoService.uploadAuthUrl(userId, authImg);
			return result;
		} catch (Exception e) {
			log.error("用户登录失败",e);
			result.setMessage("用户登录失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	
	@RequestMapping(value="/bannerAndNotice",method=RequestMethod.GET)
	@ApiOperation(value="轮播图和公告以及消息",httpMethod="GET",response=Result.class)
	public @ResponseBody Result bannerAndNotice(HttpServletRequest request,
										 @ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.bannerAndNotice(userId);
			return result;
		} catch (Exception e) {
			log.error("查询轮播图和公告以及消息失败",e);
			result.setMessage("查询轮播图和公告以及消息失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
}
