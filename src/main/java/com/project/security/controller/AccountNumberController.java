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
	
	@RequestMapping(value="/industryDynamic",method=RequestMethod.GET)
	@ApiOperation(value="行业动态",httpMethod="GET",response=Result.class)
	public @ResponseBody Result industryDynamic(HttpServletRequest request,
										 @ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.industryDynamic(pageNumber);
			return result;
		} catch (Exception e) {
			log.error("查询行业动态失败",e);
			result.setMessage("查询行业动态失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/littleKnowledge",method=RequestMethod.GET)
	@ApiOperation(value="小知识",httpMethod="GET",response=Result.class)
	public @ResponseBody Result littleKnowledge(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.littleKnowledge(pageNumber,userId);
			return result;
		} catch (Exception e) {
			log.error("查询小知识失败",e);
			result.setMessage("查询小知识失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/userMessage",method=RequestMethod.GET)
	@ApiOperation(value="消息查询接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result userMessage(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.userMessage(pageNumber,userId);
			return result;
		} catch (Exception e) {
			log.error("消息查询失败",e);
			result.setMessage("消息查询失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/readMessage",method=RequestMethod.POST)
	@ApiOperation(value="消息已读接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result readMessage(HttpServletRequest request,
			@ApiParam(name="messageId",value="消息id",required=true) String messageId,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.readMessage(messageId,userId);
			return result;
		} catch (Exception e) {
			log.error("消息已读接口失败",e);
			result.setMessage("消息已读接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/readAllMessage",method=RequestMethod.POST)
	@ApiOperation(value="消息全部已读接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result readAllMessage(HttpServletRequest request,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.readAllMessage(userId);
			return result;
		} catch (Exception e) {
			log.error("消息全部已读接口失败",e);
			result.setMessage("消息全部已读接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/courseArrange",method=RequestMethod.GET)
	@ApiOperation(value="课程安排接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result courseArrange(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.courseArrange(pageNumber,userId);
			return result;
		} catch (Exception e) {
			log.error("课程安排接口失败",e);
			result.setMessage("课程安排接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	
	@RequestMapping(value="/uploadVideoProgress",method=RequestMethod.POST)
	@ApiOperation(value="上传视频进度接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result uploadVideoProgress(HttpServletRequest request,
			@ApiParam(name="courseId",value="课程id",required=true) String courseId,
			@ApiParam(name="courseId",value="进度",required=true) Long progress,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.uploadVideoProgress(courseId,userId,progress);
			return result;
		} catch (Exception e) {
			log.error("上传视频进度接口失败",e);
			result.setMessage("上传视频进度接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/examPaper",method=RequestMethod.GET)
	@ApiOperation(value="考试试卷接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result examPaper(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.examPaper(pageNumber,userId);
			return result;
		} catch (Exception e) {
			log.error("考试试卷接口失败",e);
			result.setMessage("考试试卷接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/examPaperDetail",method=RequestMethod.GET)
	@ApiOperation(value="考试试卷详情接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result examPaperDetail(HttpServletRequest request,
			@ApiParam(name="userPaperIdId",value="用户考卷id",required=true) String userPaperIdId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.examPaperDetail(userPaperIdId);
			return result;
		} catch (Exception e) {
			log.error("考试试卷详情接口失败",e);
			result.setMessage("考试试卷详情接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
}
