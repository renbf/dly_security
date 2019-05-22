package com.project.security.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.common.result.DataResult;
import com.project.common.result.Result;
import com.project.security.domain.TBanner;
import com.project.security.domain.TIndustryDynamics;
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
			@ApiParam(name="pageNumber",value="第几页",required=true) @RequestParam(value="pageNumber",required=true) Integer pageNumber,
			@ApiParam(name="total",value="总行数",required=false) Long total,
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
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
			@ApiParam(name="userCourseId",value="用户课程id",required=true) @RequestParam(value="userCourseId",required=true) String userCourseId,
			@ApiParam(name="progress",value="进度",required=true) @RequestParam(value="progress",required=true) Long progress,
			@ApiParam(name="type",value="类型1开始2结束",required=true) @RequestParam(value="type",required=true) int type
	){
		DataResult result=new DataResult();
		try {
			result = trainService.uploadVideoProgress(userCourseId,progress,type);
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
			@ApiParam(name="pageNumber",value="第几页",required=true) @RequestParam(value="pageNumber",required=true) Integer pageNumber,
			@ApiParam(name="total",value="总行数",required=false) Long total,
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
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
			@ApiParam(name="userPaperId",value="用户考卷id",required=true) @RequestParam(value="userPaperId",required=true) String userPaperId
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
	
	@RequestMapping(value="/queryExamPaperDetail",method=RequestMethod.GET)
	@ApiOperation(value="查询考试试卷详情接口",notes="查询考试试卷详情接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result queryExamPaperDetail(HttpServletRequest request,
			@ApiParam(name="userPaperId",value="用户考卷id",required=true) @RequestParam(value="userPaperId",required=true) String userPaperId
	){
		DataResult result=new DataResult();
		try {
			result = trainService.queryExamPaperDetail(userPaperId);
			return result;
		} catch (Exception e) {
			log.error("查询考试试卷详情接口失败",e);
			result.setMessage("查询考试试卷详情接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/submitSubject",method=RequestMethod.POST)
	@ApiOperation(value="提交题目接口",notes="提交题目接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result submitSubject(HttpServletRequest request,
			@ApiParam(name="userSubjectJson",value="用户考题json字符串",required=true) @RequestParam(value="userSubjectJson",required=true) String userSubjectJson
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
			@ApiParam(name="userPaperId",value="用户考卷id",required=true) @RequestParam(value="userPaperId",required=true) String userPaperId
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
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
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
			@ApiParam(name="userCourseId",value="用户课程id",required=true) @RequestParam(value="userCourseId",required=true) String userCourseId,
			@ApiParam(name="isCollect",value="是否收藏",required=true) @RequestParam(value="isCollect",required=true) String isCollect
	){
		DataResult result=new DataResult();
		try {
			result = trainService.videoCollection(userCourseId,isCollect);
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
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId,
			@ApiParam(name="isCollect",value="是否收藏",required=true) @RequestParam(value="isCollect",required=true) String isCollect,
			@ApiParam(name="subjectId",value="题目id",required=true) @RequestParam(value="subjectId",required=true) String subjectId
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
	
	@RequestMapping(value="/imgAuthentication",method=RequestMethod.POST)
	@ApiOperation(value="人脸图片识别认证接口",notes="人脸图片识别认证接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result imgAuthentication(HttpServletRequest request,
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId,
			@ApiParam(name="file",value="图片",required=false) @RequestParam(value="file",required=true) MultipartFile file
	){
		DataResult result=new DataResult();
		try {
			result = trainService.imgAuthentication(userId,file);
			return result;
		} catch (Exception e) {
			log.error("人脸图片识别认证失败",e);
			result.setMessage("人脸图片识别认证失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/queryIsVerifyOn",method=RequestMethod.GET)
	@ApiOperation(value="查询是否开启认证接口",notes="图片认证接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result queryIsVerifyOn(HttpServletRequest request,
			@ApiParam(name="businessId",value="企业id",required=true) @RequestParam(value="businessId",required=true) String businessId
	){
		DataResult result=new DataResult();
		try {
			result = trainService.queryIsVerifyOn(businessId);
			return result;
		} catch (Exception e) {
			log.error("查询是否开启认证失败",e);
			result.setMessage("查询是否开启认证失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/sendVideoTotalTimes",method=RequestMethod.POST)
	@ApiOperation(value="发送视频时长接口",notes="发送视频时长接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result sendVideoTotalTimes(HttpServletRequest request,
			@ApiParam(name="courseId",value="课程id",required=true) @RequestParam(value="courseId",required=true) String courseId,
			@ApiParam(name="totalTimes",value="视频毫秒",required=true) @RequestParam(value="totalTimes",required=true) Long totalTimes
	){
		DataResult result=new DataResult();
		try {
			result = trainService.sendVideoTotalTimes(courseId,totalTimes);
			return result;
		} catch (Exception e) {
			log.error("发送视频时长失败",e);
			result.setMessage("发送视频时长失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@ApiOperation(value="课程weburl",notes="行业动态weburl接口",httpMethod="GET",response=Result.class)
	@GetMapping("/introductionUrl/{courseId}")
	public String introductionUrl(@PathVariable("courseId") String courseId,ModelMap mmap)
	{
		String introduction = trainService.introductionUrl(courseId);
		if(StringUtils.isNotEmpty(introduction)) {
			mmap.put("introduction", introduction);
		}
	    return "security/weburl/kecheng";
	}
	
	@ApiOperation(value="行业动态weburl",notes="行业动态weburl接口",httpMethod="GET",response=Result.class)
	@GetMapping("/industryDynamicsWebUrl/{industryDynamicsId}")
	public String industryDynamicsWebUrl(@PathVariable("industryDynamicsId") String industryDynamicsId,ModelMap mmap)
	{
		TIndustryDynamics industryDynamics = trainService.industryDynamicsWebUrl(industryDynamicsId);
		if(Objects.nonNull(industryDynamics)) {
			mmap.put("industryDynamics", industryDynamics);
		}
	    return "security/weburl/industryContent";
	}
	
	@ApiOperation(value="轮播图weburl",notes="轮播图weburl接口",httpMethod="GET",response=Result.class)
	@GetMapping("/bannerWebUrl/{bannerId}")
	public String bannerWebUrl(@PathVariable("bannerId") String bannerId,ModelMap mmap)
	{
		TBanner banner = trainService.bannerWebUrl(bannerId);
		if(Objects.nonNull(banner)) {
			mmap.put("industryDynamics", banner);
		}
	    return "security/weburl/swiperDetails";
	}
}
