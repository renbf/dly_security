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
@Api(value="路航登录首页和个人",description="登录首页和个人")
public class AccountNumberController {
	
	private static final Logger log = LoggerFactory.getLogger(AccountNumberController.class);
	
	@Autowired
	private IUserInfoService userInfoService;
	@Autowired
	private IAccountNumberService accountNumberService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ApiOperation(value="登录",notes="登录",httpMethod="POST",response=Result.class)
	public @ResponseBody Result login(HttpServletRequest request,
										 @ApiParam(name="userName",value="用户名",required=true) @RequestParam(value="userName",required=true) String userName,
										 @ApiParam(name="passWord",value="密码",required=true) @RequestParam(value="passWord",required=true) String passWord
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
	@ApiOperation(value="上传认证",notes="上传认证",httpMethod="POST",response=Result.class)
	public @ResponseBody Result auth(HttpServletRequest request,
										 @ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId,
										 @ApiParam(name="authImg",value="上传图片",required=true) @RequestParam(value="authImg",required=true) MultipartFile authImg
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
	@ApiOperation(value="轮播图和公告以及消息",notes="轮播图和公告以及消息",httpMethod="GET",response=Result.class)
	public @ResponseBody Result bannerAndNotice(HttpServletRequest request
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.bannerAndNotice();
			return result;
		} catch (Exception e) {
			log.error("查询轮播图和公告以及消息失败",e);
			result.setMessage("查询轮播图和公告以及消息失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/checkIsHaveMsg",method=RequestMethod.GET)
	@ApiOperation(value="是否有新消息",notes="是否有新消息",httpMethod="GET",response=Result.class)
	public @ResponseBody Result checkIsHaveMsg(HttpServletRequest request,
										 @ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.checkIsHaveMsg(userId);
			return result;
		} catch (Exception e) {
			log.error("查询是否有新消息失败",e);
			result.setMessage("查询是否有新消息失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/industryDynamic",method=RequestMethod.GET)
	@ApiOperation(value="行业动态",notes="行业动态",httpMethod="GET",response=Result.class)
	public @ResponseBody Result industryDynamic(HttpServletRequest request,
										 @ApiParam(name="pageNumber",value="第几页",required=true) @RequestParam(value="pageNumber",required=true) Integer pageNumber,
										 @ApiParam(name="total",value="总行数",required=false) Long total
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.industryDynamic(pageNumber,total);
			return result;
		} catch (Exception e) {
			log.error("查询行业动态失败",e);
			result.setMessage("查询行业动态失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/littleKnowledge",method=RequestMethod.GET)
	@ApiOperation(value="小知识",notes="小知识",httpMethod="GET",response=Result.class)
	public @ResponseBody Result littleKnowledge(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) @RequestParam(value="pageNumber",required=true) Integer pageNumber,
			@ApiParam(name="total",value="总行数",required=false) Long total,
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.littleKnowledge(pageNumber,total,userId);
			return result;
		} catch (Exception e) {
			log.error("查询小知识失败",e);
			result.setMessage("查询小知识失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/userMessage",method=RequestMethod.GET)
	@ApiOperation(value="消息查询接口",notes="消息查询接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result userMessage(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) @RequestParam(value="pageNumber",required=true) Integer pageNumber,
			@ApiParam(name="total",value="总行数",required=false) Long total,
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.userMessage(pageNumber,total,userId);
			return result;
		} catch (Exception e) {
			log.error("消息查询失败",e);
			result.setMessage("消息查询失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/readMessage",method=RequestMethod.POST)
	@ApiOperation(value="消息已读接口",notes="消息已读接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result readMessage(HttpServletRequest request,
			@ApiParam(name="messageId",value="消息id",required=true) @RequestParam(value="messageId",required=true) String messageId,
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
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
	@ApiOperation(value="消息全部已读接口",notes="消息全部已读接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result readAllMessage(HttpServletRequest request,
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
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
	
	@RequestMapping(value="/myExam",method=RequestMethod.GET)
	@ApiOperation(value="我的考卷接口",notes="我的考卷接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result myExam(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) @RequestParam(value="pageNumber",required=true) Integer pageNumber,
			@ApiParam(name="total",value="总行数",required=false) Long total,
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.myExam(pageNumber,total,userId);
			return result;
		} catch (Exception e) {
			log.error("查询我的考卷失败",e);
			result.setMessage("查询我的考卷接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/courseCollection",method=RequestMethod.GET)
	@ApiOperation(value="我的课程收藏接口",notes="我的课程收藏接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result courseCollection(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) @RequestParam(value="pageNumber",required=true) Integer pageNumber,
			@ApiParam(name="total",value="总行数",required=false) Long total,
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.courseCollection(pageNumber,total,userId);
			return result;
		} catch (Exception e) {
			log.error("查询我的课程收藏失败",e);
			result.setMessage("查询我的课程收藏接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/examCollection",method=RequestMethod.GET)
	@ApiOperation(value="我的考题收藏接口",notes="我的考题收藏接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result examCollection(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) @RequestParam(value="pageNumber",required=true) Integer pageNumber,
			@ApiParam(name="total",value="总行数",required=false) Long total,
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.examCollection(pageNumber,total,userId);
			return result;
		} catch (Exception e) {
			log.error("查询我的考题收藏失败",e);
			result.setMessage("查询我的考题收藏接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}

	@RequestMapping(value="/myCourse",method=RequestMethod.GET)
	@ApiOperation(value="我的课程接口",notes="我的课程接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result myCourse(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) @RequestParam(value="pageNumber",required=true) Integer pageNumber,
			@ApiParam(name="total",value="总行数",required=false) Long total,
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.myCourse(pageNumber,total,userId);
			return result;
		} catch (Exception e) {
			log.error("查询我的课程失败",e);
			result.setMessage("查询我的课程接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/getUserInfo",method=RequestMethod.GET)
	@ApiOperation(value="个人信息接口",notes="个人信息接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result getUserInfo(HttpServletRequest request,
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.getUserInfo(userId);
			return result;
		} catch (Exception e) {
			log.error("查询个人信息失败",e);
			result.setMessage("查询个人信息接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/changePassword",method=RequestMethod.POST)
	@ApiOperation(value="修改密码接口",notes="修改密码接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result changePassword(HttpServletRequest request,
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId,
			@ApiParam(name="oldPassword",value="原始登录密码",required=true) @RequestParam(value="oldPassword",required=true) String oldPassword,
			@ApiParam(name="newPassword",value="新登录密码",required=true) @RequestParam(value="newPassword",required=true) String newPassword,
			@ApiParam(name="confirmPassword",value="确认登录密码",required=true) @RequestParam(value="confirmPassword",required=true) String confirmPassword
	){
		DataResult result=new DataResult();
		try {
			result = userInfoService.changePassword(userId,oldPassword,newPassword,confirmPassword);
			return result;
		} catch (Exception e) {
			log.error("修改密码失败",e);
			result.setMessage("修改密码接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
}
