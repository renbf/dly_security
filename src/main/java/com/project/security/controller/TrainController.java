package com.project.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.common.result.DataResult;
import com.project.common.result.Result;
import com.project.security.service.ITrainService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("safety/train")
@Api(value="路航培训",description="培训")
public class TrainController {
	
	private static final Logger log = LoggerFactory.getLogger(TrainController.class);
	
	@Autowired
	private ITrainService trainService;
	
	@RequestMapping(value="/courseArrange",method=RequestMethod.GET)
	@ApiOperation(value="课程安排接口",notes="课程安排接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result courseArrange(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber,
			@ApiParam(name="total",value="总行数",required=false) Long total,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = trainService.courseArrange(pageNumber,total,userId);
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
			result = trainService.uploadVideoProgress(courseId,userId,progress);
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
			@ApiParam(name="total",value="总行数",required=false) Long total,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = trainService.examPaper(pageNumber,total,userId);
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
			result = trainService.examPaperDetail(userPaperId);
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
			result = trainService.submitSubject(userSubjectJson);
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
			result = trainService.submitPaper(userPaperId);
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
			result = trainService.courseRanking(userId);
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
			result = trainService.videoCollection(userId,courseId,isCollect);
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
			result = trainService.subjectCollection(userId,subjectId,isCollect);
			return result;
		} catch (Exception e) {
			log.error("收藏题目接口失败",e);
			result.setMessage("收藏题目接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
}
