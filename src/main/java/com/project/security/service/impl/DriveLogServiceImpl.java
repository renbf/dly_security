package com.project.security.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.project.common.result.DataResult;
import com.project.common.result.Result;
import com.project.framework.util.FileUploadUtils;
import com.project.security.domain.TDriverAfterLog;
import com.project.security.domain.TDriverBeforeLog;
import com.project.security.domain.TDriverLog;
import com.project.security.domain.TDriverMiddleLog;
import com.project.security.domain.TGoodsNameType;
import com.project.security.domain.vo.TDictView;
import com.project.security.domain.vo.TDriverAfterLogVo;
import com.project.security.domain.vo.TDriverBeforeLogVo;
import com.project.security.domain.vo.TDriverMiddleLogVo;
import com.project.security.mapper.TDictMapper;
import com.project.security.mapper.TDriverAfterLogMapper;
import com.project.security.mapper.TDriverBeforeLogMapper;
import com.project.security.mapper.TDriverLogMapper;
import com.project.security.mapper.TDriverMiddleLogMapper;
import com.project.security.mapper.TGoodsNameTypeMapper;
import com.project.security.mapper.UserMapper;
import com.project.security.service.IDriveLogService;
import com.project.security.service.IFileSystemService;
import com.project.security.utils.page.PageInfoUtil;
import com.project.security.utils.page.TableDataView;
import com.project.system.domain.SysUser;
/**
 * 
 * @author rbf
 *
 */
@Service
public class DriveLogServiceImpl implements IDriveLogService {
	private static final Logger log = LoggerFactory.getLogger(DriveLogServiceImpl.class);
	@Autowired
	private IFileSystemService fileSystemService;
	@Autowired
	@Qualifier("dictMapper")
	private TDictMapper dictMapper;
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;
	@Autowired
	@Qualifier("driverLogMapper")
	private TDriverLogMapper driverLogMapper;
	@Autowired
	@Qualifier("driverBeforeLogMapper")
	private TDriverBeforeLogMapper driverBeforeLogMapper;
	@Autowired
	@Qualifier("driverMiddleLogMapper")
	private TDriverMiddleLogMapper driverMiddleLogMapper;
	@Autowired
	@Qualifier("driverAfterLogMapper")
	private TDriverAfterLogMapper driverAfterLogMapper;
	@Autowired
	@Qualifier("goodsNameTypeMapper")
	private TGoodsNameTypeMapper goodsNameTypeMapper;
	
	@Override
	public DataResult queryLogParamBefore(String userId) {
		DataResult result = new DataResult();
        try {
        	SysUser driver = userMapper.selectDriverUser(userId);
        	if(driver == null) {
        		result.setMessage("当前用户不是驾驶员");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
        	String businessId = driver.getBusinessId();
        	//货物名称
        	TGoodsNameType tGoodsNameType = new TGoodsNameType();
        	tGoodsNameType.setBusinessId(businessId);
        	List<TGoodsNameType> goodsNameTypeList = goodsNameTypeMapper.selectTGoodsNameTypeList(tGoodsNameType);
        	//货物类项
        	List<TDictView> type = dictMapper.selectTDictsByGoodsType("");
        	//驾驶员
        	List<SysUser> drivers = userMapper.selectUserByDriver(businessId);
        	//行车前事项
        	List<TDictView> carCheckProject = dictMapper.selectTDictListBybusinessId("",businessId);
        	//确认结论
        	List<TDictView> sureComment = dictMapper.selectTDictListBybusinessId("",businessId);
        	Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("goodsNameTypeList", goodsNameTypeList);
			mapResult.put("type", type);
			mapResult.put("drivers", drivers);
			mapResult.put("carCheckProject", carCheckProject);
			mapResult.put("sureComment", sureComment);
        	result.setResult(mapResult);
			result.setMessage("查询行车前需要日志参数成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询行车前需要日志参数接口异常",e);
			throw new RuntimeException("查询行车前需要日志参数接口异常");
		}
	}
	
	@Override
	public DataResult queryLogParamMiddle(String businessId) {
		DataResult result = new DataResult();
        try {
        	//行车中事项
        	List<TDictView> carCheckProject = dictMapper.selectTDictListBybusinessId("",businessId);
        	Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("carCheckProject", carCheckProject);
        	result.setResult(mapResult);
			result.setMessage("查询行车中需要日志参数成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询行车中需要日志参数接口异常",e);
			throw new RuntimeException("查询行车中需要日志参数接口异常");
		}
	}
	
	@Override
	public DataResult queryLogParamAfter(String businessId) {
		DataResult result = new DataResult();
        try {
        	//行车后事项
        	List<TDictView> carCheckProject = dictMapper.selectTDictListBybusinessId("",businessId);
        	Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("carCheckProject", carCheckProject);
        	result.setResult(mapResult);
			result.setMessage("查询行车后需要日志参数成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询行车后需要日志参数接口异常",e);
			throw new RuntimeException("查询行车后需要日志参数接口异常");
		}
	}
	
	@Override
	public DataResult addBeforeLog(String driverLogJson, MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	boolean fileType = FileUploadUtils.checkImgFile(file);
			if(!fileType) {
				result.setMessage("上传图片类型错误");
				result.setStatus(Result.FAILED);
				return result;
			}
        	String drivePhotoUrl = fileSystemService.uploadFile(file);
			if(StringUtils.isEmpty(drivePhotoUrl)) {
				result.setMessage("上传图片失败");
				result.setStatus(Result.FAILED);
				return result;
			}
        	TDriverBeforeLogVo driverLog = JSON.parseObject(driverLogJson, TDriverBeforeLogVo.class);
        	TDriverLog tDriverLog = new TDriverLog();
        	TDriverBeforeLog tDriverBeforeLog = new TDriverBeforeLog();
        	BeanUtils.copyProperties(tDriverLog, driverLog);
        	BeanUtils.copyProperties(tDriverBeforeLog, driverLog);
        	List<TDictView> carCheckProjectList = driverLog.getCarCheckProjectList();
        	tDriverBeforeLog.setCarCheckProject(JSON.toJSONString(carCheckProjectList));
        	tDriverBeforeLog.setDrivePhotoUrl(drivePhotoUrl);
        	driverLogMapper.insertTDriverLog(tDriverLog);
        	driverBeforeLogMapper.insertTDriverBeforeLog(tDriverBeforeLog);
			result.setMessage("添加行车前日志成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("添加行车前日志接口异常",e);
			throw new RuntimeException("添加行车前日志接口异常");
		}
	}
	
	@Override
	public DataResult addMiddleLog(String driverLogJson, MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	boolean fileType = FileUploadUtils.checkImgFile(file);
			if(!fileType) {
				result.setMessage("上传图片类型错误");
				result.setStatus(Result.FAILED);
				return result;
			}
        	String drivePhotoUrl = fileSystemService.uploadFile(file);
			if(StringUtils.isEmpty(drivePhotoUrl)) {
				result.setMessage("上传图片失败");
				result.setStatus(Result.FAILED);
				return result;
			}
        	TDriverMiddleLog tDriverMiddleLog = JSON.parseObject(driverLogJson, TDriverMiddleLog.class);
        	tDriverMiddleLog.setDrivingPhoto(drivePhotoUrl);
        	driverMiddleLogMapper.insertTDriverMiddleLog(tDriverMiddleLog);
			result.setMessage("添加行车中日志成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("添加行车中日志接口异常",e);
			throw new RuntimeException("添加行车中日志接口异常");
		}
	}
	
	@Override
	public DataResult addAfterLog(String driverLogJson, MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	boolean fileType = FileUploadUtils.checkImgFile(file);
			if(!fileType) {
				result.setMessage("上传图片类型错误");
				result.setStatus(Result.FAILED);
				return result;
			}
        	String drivePhotoUrl = fileSystemService.uploadFile(file);
			if(StringUtils.isEmpty(drivePhotoUrl)) {
				result.setMessage("上传图片失败");
				result.setStatus(Result.FAILED);
				return result;
			}
        	TDriverAfterLog tDriverAfterLog = JSON.parseObject(driverLogJson, TDriverAfterLog.class);
        	tDriverAfterLog.setDrivingPhoto(drivePhotoUrl);
        	driverAfterLogMapper.insertTDriverAfterLog(tDriverAfterLog);
			result.setMessage("添加行车后日志成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("添加行车后日志接口异常",e);
			throw new RuntimeException("添加行车后日志接口异常");
		}
	}
	
	@Override
	public DataResult queryLogBeforeDetail(String driverLogId) {
		DataResult result = new DataResult();
        try {
        	TDriverBeforeLogVo driverBeforeLogVo = driverLogMapper.queryLogBeforeDetail(driverLogId);
        	String carCheckProject = driverBeforeLogVo.getCarCheckProject();
        	List<TDictView> carCheckProjectList = JSONArray.parseArray(carCheckProject, TDictView.class);
        	driverBeforeLogVo.setCarCheckProjectList(carCheckProjectList);
        	result.setResult(driverBeforeLogVo);
			result.setMessage("查询日志详情——行车前成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询日志详情——行车前接口异常",e);
			throw new RuntimeException("查询日志详情——行车前接口异常");
		}
	}
	
	@Override
	public DataResult queryLogMiddleDetail(String driverLogId) {
		DataResult result = new DataResult();
        try {
        	TDriverMiddleLogVo driverMiddleLogVo = driverLogMapper.queryLogMiddleDetail(driverLogId);
        	String carCheckProject = driverMiddleLogVo.getCarCheckProject();
        	List<TDictView> carCheckProjectList = JSONArray.parseArray(carCheckProject, TDictView.class);
        	driverMiddleLogVo.setCarCheckProjectList(carCheckProjectList);
        	result.setResult(driverMiddleLogVo);
			result.setMessage("查询日志详情——行车中成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询日志详情——行车中接口异常",e);
			throw new RuntimeException("查询日志详情——行车中接口异常");
		}
	}
	
	@Override
	public DataResult queryLogAfterDetail(String driverLogId) {
		DataResult result = new DataResult();
        try {
        	TDriverAfterLogVo driverAfterLogVo = driverLogMapper.queryLogAfterDetail(driverLogId);
        	String carCheckProject = driverAfterLogVo.getCarCheckProject();
        	List<TDictView> carCheckProjectList = JSONArray.parseArray(carCheckProject, TDictView.class);
        	driverAfterLogVo.setCarCheckProjectList(carCheckProjectList);
        	result.setResult(driverAfterLogVo);
			result.setMessage("查询日志详情——行车后成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询日志详情——行车后接口异常",e);
			throw new RuntimeException("查询日志详情——行车后接口异常");
		}
	}
	
	@Override
	public DataResult queryLog(Integer pageNumber,Long total,String userId) {
		DataResult result = new DataResult();
        try {
        	DataResult pageResult = PageInfoUtil.startPage(pageNumber, total,null);
        	if(Result.SUCCESS.equals(pageResult.getStatus())) {
    			return pageResult;
        	}
        	List<TDriverLog> driverLogs = driverLogMapper.selectTDriverLogsByUserId(userId);
    		TableDataView<TDriverLog> tableDataView = PageInfoUtil.addPageInfo(driverLogs);
			result.setResult(tableDataView);
			result.setMessage("查询日志成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("查询日志接口异常",e);
			throw new RuntimeException("查询日志接口异常");
		}
	}
}
