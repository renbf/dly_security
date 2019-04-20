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
	@ApiOperation(value="登录",notes="登录",httpMethod="POST",response=Result.class)
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
	@ApiOperation(value="上传认证",notes="上传认证",httpMethod="POST",response=Result.class)
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
	@ApiOperation(value="轮播图和公告以及消息",notes="轮播图和公告以及消息",httpMethod="GET",response=Result.class)
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
	@ApiOperation(value="行业动态",notes="行业动态",httpMethod="GET",response=Result.class)
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
	@ApiOperation(value="小知识",notes="小知识",httpMethod="GET",response=Result.class)
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
	@ApiOperation(value="消息查询接口",notes="消息查询接口",httpMethod="GET",response=Result.class)
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
	@ApiOperation(value="消息已读接口",notes="消息已读接口",httpMethod="POST",response=Result.class)
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
	@ApiOperation(value="消息全部已读接口",notes="消息全部已读接口",httpMethod="POST",response=Result.class)
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
	@ApiOperation(value="课程安排接口",notes="课程安排接口",httpMethod="GET",response=Result.class)
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
	@ApiOperation(value="上传视频进度接口",notes="上传视频进度接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result uploadVideoProgress(HttpServletRequest request,
			@ApiParam(name="courseId",value="课程id",required=true) String courseId,
			@ApiParam(name="progress",value="进度",required=true) Long progress,
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
	@ApiOperation(value="考试试卷接口",notes="考试试卷接口",httpMethod="GET",response=Result.class)
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
	@ApiOperation(value="考试试卷详情接口",notes="考试试卷详情接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result examPaperDetail(HttpServletRequest request,
			@ApiParam(name="userPaperId",value="用户考卷id",required=true) String userPaperId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.examPaperDetail(userPaperId);
			return result;
		} catch (Exception e) {
			log.error("考试试卷详情接口失败",e);
			result.setMessage("考试试卷详情接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/submitSubject",method=RequestMethod.POST)
	@ApiOperation(value="提交题目接口",notes="提交题目接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result submitSubject(HttpServletRequest request,
			@ApiParam(name="userSubjectJson",value="用户考题json字符串",required=true) String userSubjectJson
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.submitSubject(userSubjectJson);
			return result;
		} catch (Exception e) {
			log.error("提交题目接口失败",e);
			result.setMessage("提交题目接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/submitPaper",method=RequestMethod.POST)
	@ApiOperation(value="提交考卷接口",notes="提交考卷接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result submitPaper(HttpServletRequest request,
			@ApiParam(name="userPaperId",value="用户考卷id",required=true) String userPaperId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.submitPaper(userPaperId);
			return result;
		} catch (Exception e) {
			log.error("提交考卷接口失败",e);
			result.setMessage("提交考卷接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/courseRanking",method=RequestMethod.GET)
	@ApiOperation(value="课时排名接口",notes="课时排名接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result courseRanking(HttpServletRequest request,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.courseRanking(userId);
			return result;
		} catch (Exception e) {
			log.error("课时排名接口失败",e);
			result.setMessage("课时排名接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/videoCollection",method=RequestMethod.GET)
	@ApiOperation(value="收藏视频接口",notes="收藏视频接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result videoCollection(HttpServletRequest request,
			@ApiParam(name="userId",value="用户id",required=true) String userId,
			@ApiParam(name="isCollect",value="是否收藏",required=true) String isCollect,
			@ApiParam(name="courseId",value="课程id",required=true) String courseId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.videoCollection(userId,courseId,isCollect);
			return result;
		} catch (Exception e) {
			log.error("收藏视频接口失败",e);
			result.setMessage("收藏视频接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/subjectCollection",method=RequestMethod.GET)
	@ApiOperation(value="收藏题目接口",notes="收藏题目接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result subjectCollection(HttpServletRequest request,
			@ApiParam(name="userId",value="用户id",required=true) String userId,
			@ApiParam(name="isCollect",value="是否收藏",required=true) String isCollect,
			@ApiParam(name="subjectId",value="题目id",required=true) String subjectId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.subjectCollection(userId,subjectId,isCollect);
			return result;
		} catch (Exception e) {
			log.error("收藏题目接口失败",e);
			result.setMessage("收藏题目接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/checkPlan",method=RequestMethod.GET)
	@ApiOperation(value="检查计划接口",notes="检查计划接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result checkPlan(HttpServletRequest request,
			@ApiParam(name="userId",value="用户id",required=true) String userId,
			@ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.checkPlan(userId,pageNumber);
			return result;
		} catch (Exception e) {
			log.error("检查计划接口失败",e);
			result.setMessage("检查计划接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	
	@RequestMapping(value="/queryCheckProject",method=RequestMethod.GET)
	@ApiOperation(value="查询检查项接口",notes="查询检查项接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result queryCheckProject(HttpServletRequest request,
			@ApiParam(name="inspectPlanId",value="检查计划id",required=true) String inspectPlanId,
			@ApiParam(name="projectId",value="检查项目id",required=true) String projectId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.queryCheckProject(inspectPlanId,projectId);
			return result;
		} catch (Exception e) {
			log.error("查询检查项接口失败",e);
			result.setMessage("查询检查项接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/saveCheckProject",method=RequestMethod.POST)
	@ApiOperation(value="保存检查项接口",notes="保存检查项接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result saveCheckProject(HttpServletRequest request,
			@ApiParam(name="inspectTeamProjectJson",value="检查项json字符串",required=true) String inspectTeamProjectJson
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.saveCheckProject(inspectTeamProjectJson);
			return result;
		} catch (Exception e) {
			log.error("保存检查项接口失败",e);
			result.setMessage("保存检查项接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/completeCheck",method=RequestMethod.POST)
	@ApiOperation(value="完成检查计划接口",notes="完成检查计划接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result completeCheck(HttpServletRequest request,
			@ApiParam(name="inspectRecordJson",value="完成检查计划json字符串",required=true) String inspectRecordJson,
			@ApiParam(name="file",value="签名图片",required=true) MultipartFile file
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.completeCheck(inspectRecordJson,file);
			return result;
		} catch (Exception e) {
			log.error("完成检查计划接口失败",e);
			result.setMessage("完成检查计划接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/queryHiddenDanger",method=RequestMethod.GET)
	@ApiOperation(value="上传隐患——查询部门等接口",notes="上传隐患——查询部门等接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result queryHiddenDanger(HttpServletRequest request,
			@ApiParam(name="businessId",value="企业id",required=true) String businessId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.queryHiddenDanger(businessId);
			return result;
		} catch (Exception e) {
			log.error("上传隐患——查询部门接口失败",e);
			result.setMessage("上传隐患——查询部门接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/uploadHiddenDanger",method=RequestMethod.POST)
	@ApiOperation(value="上报隐患接口接口",notes="上报隐患接口接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result uploadHiddenDanger(HttpServletRequest request,
			@ApiParam(name="dangerJson",value="上报隐患json字符串",required=true) String dangerJson,
			@ApiParam(name="file",value="隐患图片",required=true) MultipartFile file
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.uploadHiddenDanger(dangerJson,file);
			return result;
		} catch (Exception e) {
			log.error("上报隐患失败",e);
			result.setMessage("上报隐患接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/rectification ",method=RequestMethod.GET)
	@ApiOperation(value="隐患整改接口接口",notes="隐患整改接口接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result rectification(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.rectification(pageNumber,userId);
			return result;
		} catch (Exception e) {
			log.error("隐患整改失败",e);
			result.setMessage("隐患整改接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/queryHiddenDangerDetail",method=RequestMethod.GET)
	@ApiOperation(value="隐患详情接口",notes="隐患详情接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result queryHiddenDangerDetail(HttpServletRequest request,
			@ApiParam(name="dangerId",value="隐患id",required=true) String dangerId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.queryHiddenDangerDetail(dangerId);
			return result;
		} catch (Exception e) {
			log.error("隐患详情接口失败",e);
			result.setMessage("隐患详情接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/rectificationDetail",method=RequestMethod.POST)
	@ApiOperation(value="隐患整改提交接口",notes="隐患整改提交接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result rectificationDetail(HttpServletRequest request,
			@ApiParam(name="dangerJson",value="隐患整改提交json字符串",required=true) String dangerJson,
			@ApiParam(name="file",value="整改图片",required=true) MultipartFile file
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.rectificationDetail(dangerJson,file);
			return result;
		} catch (Exception e) {
			log.error("隐患整改提交失败",e);
			result.setMessage("隐患整改提交接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/refuseDochange",method=RequestMethod.POST)
	@ApiOperation(value="拒绝整改接口",notes="拒绝整改接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result refuseDochange(HttpServletRequest request,
			@ApiParam(name="dangerId",value="隐患id",required=true) String dangerId,
			@ApiParam(name="refuseText",value="拒绝原因",required=true) String refuseText
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.refuseDochange(dangerId,refuseText);
			return result;
		} catch (Exception e) {
			log.error("拒绝整改失败",e);
			result.setMessage("拒绝整改接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/rectificationCheck",method=RequestMethod.GET)
	@ApiOperation(value="隐患验收接口",notes="隐患验收接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result rectificationCheck(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.rectificationCheck(pageNumber,userId);
			return result;
		} catch (Exception e) {
			log.error("隐患验收失败",e);
			result.setMessage("隐患验收接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	
	@RequestMapping(value="/rectificationClose",method=RequestMethod.POST)
	@ApiOperation(value="提交隐患验收接口",notes="提交隐患验收接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result rectificationClose(HttpServletRequest request,
			@ApiParam(name="dangerJson",value="提交隐患验收json字符串",required=true) String dangerJson,
			@ApiParam(name="file",value="验收图片",required=true) MultipartFile file
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.rectificationClose(dangerJson,file);
			return result;
		} catch (Exception e) {
			log.error("提交隐患验收失败",e);
			result.setMessage("提交隐患验收接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/queryLogParamBefore",method=RequestMethod.GET)
	@ApiOperation(value="行车前需要日志参数接口",notes="行车前需要日志参数接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result queryLogParamBefore(HttpServletRequest request,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.queryLogParamBefore(userId);
			return result;
		} catch (Exception e) {
			log.error("查询行车前需要日志参数失败",e);
			result.setMessage("查询行车前需要日志参数失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/queryLogParamMiddle",method=RequestMethod.GET)
	@ApiOperation(value="行车中需要日志参数接口",notes="行车中需要日志参数接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result queryLogParamMiddle(HttpServletRequest request,
			@ApiParam(name="businessId",value="企业id",required=true) String businessId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.queryLogParamMiddle(businessId);
			return result;
		} catch (Exception e) {
			log.error("查询行车中需要日志参数失败",e);
			result.setMessage("查询行车中需要日志参数失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/queryLogParamAfter",method=RequestMethod.GET)
	@ApiOperation(value="行车后需要日志参数接口",notes="行车后需要日志参数接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result queryLogParamAfter(HttpServletRequest request,
			@ApiParam(name="businessId",value="企业id",required=true) String businessId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.queryLogParamAfter(businessId);
			return result;
		} catch (Exception e) {
			log.error("查询行车后需要日志参数失败",e);
			result.setMessage("查询行车后需要日志参数失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	
	@RequestMapping(value="/addBeforeLog",method=RequestMethod.POST)
	@ApiOperation(value="添加行车前日志接口",notes="添加行车前日志接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result addBeforeLog(HttpServletRequest request,
			@ApiParam(name="driverLogJson",value="添加日志json字符串",required=true) String driverLogJson,
			@ApiParam(name="file",value="验收图片",required=true) MultipartFile file
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.addBeforeLog(driverLogJson,file);
			return result;
		} catch (Exception e) {
			log.error("添加行车前日志失败",e);
			result.setMessage("添加行车前日志接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/addMiddleLog",method=RequestMethod.POST)
	@ApiOperation(value="添加行车中日志接口",notes="添加行车中日志接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result addMiddleLog(HttpServletRequest request,
			@ApiParam(name="driverLogJson",value="添加日志json字符串",required=true) String driverLogJson,
			@ApiParam(name="file",value="验收图片",required=true) MultipartFile file
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.addMiddleLog(driverLogJson,file);
			return result;
		} catch (Exception e) {
			log.error("添加行车中日志失败",e);
			result.setMessage("添加行车中日志接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/addAfterLog",method=RequestMethod.POST)
	@ApiOperation(value="添加行车后日志接口",notes="添加行车后日志接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result addAfterLog(HttpServletRequest request,
			@ApiParam(name="driverLogJson",value="添加日志json字符串",required=true) String driverLogJson,
			@ApiParam(name="file",value="验收图片",required=true) MultipartFile file
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.addAfterLog(driverLogJson,file);
			return result;
		} catch (Exception e) {
			log.error("添加行车后日志失败",e);
			result.setMessage("添加行车后日志接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/queryLogBeforeDetail",method=RequestMethod.GET)
	@ApiOperation(value="查询日志详情——行车前接口",notes="查询日志详情——行车前接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result queryLogBeforeDetail(HttpServletRequest request,
			@ApiParam(name="driverLogId",value="行车日志id",required=true) String driverLogId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.queryLogBeforeDetail(driverLogId);
			return result;
		} catch (Exception e) {
			log.error("查询日志详情——行车前失败",e);
			result.setMessage("查询日志详情——行车前接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/queryLogMiddleDetail",method=RequestMethod.GET)
	@ApiOperation(value="查询日志详情——行车中接口",notes="查询日志详情——行车中接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result queryLogMiddleDetail(HttpServletRequest request,
			@ApiParam(name="driverLogId",value="行车日志id",required=true) String driverLogId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.queryLogMiddleDetail(driverLogId);
			return result;
		} catch (Exception e) {
			log.error("查询日志详情——行车中失败",e);
			result.setMessage("查询日志详情——行车中接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/queryLogAfterDetail",method=RequestMethod.GET)
	@ApiOperation(value="查询日志详情——行车后接口",notes="查询日志详情——行车后接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result queryLogAfterDetail(HttpServletRequest request,
			@ApiParam(name="driverLogId",value="行车日志id",required=true) String driverLogId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.queryLogAfterDetail(driverLogId);
			return result;
		} catch (Exception e) {
			log.error("查询日志详情——行车后失败",e);
			result.setMessage("查询日志详情——行车后接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/queryLog",method=RequestMethod.GET)
	@ApiOperation(value="查询日志接口",notes="查询日志接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result queryLog(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.queryLog(pageNumber,userId);
			return result;
		} catch (Exception e) {
			log.error("查询日志失败",e);
			result.setMessage("查询日志接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/myExam",method=RequestMethod.GET)
	@ApiOperation(value="我的考卷接口",notes="我的考卷接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result myExam(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.myExam(pageNumber,userId);
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
			@ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.courseCollection(pageNumber,userId);
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
			@ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.examCollection(pageNumber,userId);
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
			@ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = accountNumberService.myCourse(pageNumber,userId);
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
			@ApiParam(name="userId",value="用户id",required=true) String userId
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
	
}
