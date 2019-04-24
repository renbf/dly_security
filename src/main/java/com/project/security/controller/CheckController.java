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
import com.project.security.service.ICheckService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("safety/check")
@Api(value="路航检查",description="检查")
public class CheckController {
	
	private static final Logger log = LoggerFactory.getLogger(CheckController.class);
	
	@Autowired
	private ICheckService checkService;
	
	@RequestMapping(value="/checkPlan",method=RequestMethod.GET)
	@ApiOperation(value="检查计划接口",notes="检查计划接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result checkPlan(HttpServletRequest request,
			@ApiParam(name="userId",value="用户id",required=true) String userId,
			@ApiParam(name="total",value="总行数",required=false) Long total,
			@ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber
	){
		DataResult result=new DataResult();
		try {
			result = checkService.checkPlan(userId,pageNumber,total);
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
			result = checkService.queryCheckProject(inspectPlanId,projectId);
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
			result = checkService.saveCheckProject(inspectTeamProjectJson);
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
			result = checkService.completeCheck(inspectRecordJson,file);
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
			result = checkService.queryHiddenDanger(businessId);
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
			@ApiParam(name="dangerJson",value="上报隐患json字符串",required=true) @RequestParam(value="dangerJson",required=true) String dangerJson,
			@ApiParam(name="inspectPlanId",value="检查计划id",required=true) String inspectPlanId,
			@ApiParam(name="photoFile",value="隐患图片",required=false) MultipartFile[] photoFile
	){
		DataResult result=new DataResult();
		try {
			result = checkService.uploadHiddenDanger(dangerJson,photoFile,inspectPlanId);
			return result;
		} catch (Exception e) {
			log.error("上报隐患失败",e);
			result.setMessage("上报隐患接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/rectification",method=RequestMethod.GET)
	@ApiOperation(value="隐患整改接口接口",notes="隐患整改接口接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result rectification(HttpServletRequest request,
			@ApiParam(name="pageNumber",value="第几页",required=true) Integer pageNumber,
			@ApiParam(name="total",value="总行数",required=false) Long total,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = checkService.rectification(pageNumber,total,userId);
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
			result = checkService.queryHiddenDangerDetail(dangerId);
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
			result = checkService.rectificationDetail(dangerJson,file);
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
			result = checkService.refuseDochange(dangerId,refuseText);
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
			@ApiParam(name="total",value="总行数",required=false) Long total,
			@ApiParam(name="userId",value="用户id",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = checkService.rectificationCheck(pageNumber,total,userId);
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
			result = checkService.rectificationClose(dangerJson,file);
			return result;
		} catch (Exception e) {
			log.error("提交隐患验收失败",e);
			result.setMessage("提交隐患验收接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
}
