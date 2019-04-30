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
import com.project.security.service.IDriveLogService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("safety/driveLog")
@Api(value="路航行车日志",description="行车日志")
public class DriveLogController {
	
	private static final Logger log = LoggerFactory.getLogger(DriveLogController.class);
	
	@Autowired
	private IDriveLogService driveLogService;
	
	@RequestMapping(value="/queryLogParamBefore",method=RequestMethod.GET)
	@ApiOperation(value="行车前需要日志参数接口",notes="行车前需要日志参数接口",httpMethod="GET",response=Result.class)
	public @ResponseBody Result queryLogParamBefore(HttpServletRequest request,
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = driveLogService.queryLogParamBefore(userId);
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
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = driveLogService.queryLogParamMiddle(userId);
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
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = driveLogService.queryLogParamAfter(userId);
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
			@ApiParam(name="driverLogJson",value="添加日志json字符串",required=true) @RequestParam(value="driverLogJson",required=true) String driverLogJson,
			@ApiParam(name="driverBeforeLogJson",value="添加行车前日志json字符串",required=true) @RequestParam(value="driverBeforeLogJson",required=true) String driverBeforeLogJson,
			@ApiParam(name="files",value="行车图片",required=false) MultipartFile[] files,
			@ApiParam(name="file",value="签名图片",required=false) @RequestParam(value="file",required=true) MultipartFile file
	){
		DataResult result=new DataResult();
		try {
			result = driveLogService.addBeforeLog(driverLogJson,driverBeforeLogJson,files,file);
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
			@ApiParam(name="driverLogJson",value="添加日志json字符串",required=true) @RequestParam(value="driverLogJson",required=true) String driverLogJson,
			@ApiParam(name="files",value="行车图片",required=false) MultipartFile[] files,
			@ApiParam(name="file",value="签名图片",required=true) @RequestParam(value="file",required=true) MultipartFile file
	){
		DataResult result=new DataResult();
		try {
			result = driveLogService.addMiddleLog(driverLogJson,files,file);
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
			@ApiParam(name="driverLogJson",value="添加日志json字符串",required=true) @RequestParam(value="driverLogJson",required=true) String driverLogJson,
			@ApiParam(name="files",value="行车图片",required=false) MultipartFile[] files,
			@ApiParam(name="file",value="签名图片",required=true) @RequestParam(value="file",required=true) MultipartFile file
	){
		DataResult result=new DataResult();
		try {
			result = driveLogService.addAfterLog(driverLogJson,files,file);
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
			@ApiParam(name="driverLogId",value="行车日志id",required=true) @RequestParam(value="driverLogId",required=true) String driverLogId
	){
		DataResult result=new DataResult();
		try {
			result = driveLogService.queryLogBeforeDetail(driverLogId);
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
			@ApiParam(name="driverLogId",value="行车日志id",required=true) @RequestParam(value="driverLogId",required=true) String driverLogId
	){
		DataResult result=new DataResult();
		try {
			result = driveLogService.queryLogMiddleDetail(driverLogId);
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
			@ApiParam(name="driverLogId",value="行车日志id",required=true) @RequestParam(value="driverLogId",required=true) String driverLogId
	){
		DataResult result=new DataResult();
		try {
			result = driveLogService.queryLogAfterDetail(driverLogId);
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
			@ApiParam(name="pageNumber",value="第几页",required=true) @RequestParam(value="pageNumber",required=true) Integer pageNumber,
			@ApiParam(name="total",value="总行数",required=false) Long total,
			@ApiParam(name="userId",value="用户id",required=true) @RequestParam(value="userId",required=true) String userId
	){
		DataResult result=new DataResult();
		try {
			result = driveLogService.queryLog(pageNumber,total,userId);
			return result;
		} catch (Exception e) {
			log.error("查询日志失败",e);
			result.setMessage("查询日志接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
	
	@RequestMapping(value="/handover",method=RequestMethod.POST)
	@ApiOperation(value="交接日志接口",notes="交接日志接口",httpMethod="POST",response=Result.class)
	public @ResponseBody Result handover(HttpServletRequest request,
			@ApiParam(name="driverLogId",value="行车日志id",required=true) @RequestParam(value="driverLogId",required=true) String driverLogId,
			@ApiParam(name="exchangeRemark",value="交接备注",required=true) @RequestParam(value="exchangeRemark",required=true) String exchangeRemark
	){
		DataResult result=new DataResult();
		try {
			result = driveLogService.handover(driverLogId,exchangeRemark);
			return result;
		} catch (Exception e) {
			log.error("交接日志失败",e);
			result.setMessage("交接日志接口失败");
			result.setStatus(Result.FAILED);
			return result;
		}
	}
}
