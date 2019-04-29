package com.project.security.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
import com.project.security.domain.vo.TDictView;
import com.project.security.domain.vo.TDriverAfterLogVo;
import com.project.security.domain.vo.TDriverBeforeLogVo;
import com.project.security.domain.vo.TDriverMiddleLogVo;
import com.project.security.domain.vo.TGoodsNameTypeVo;
import com.project.security.domain.vo.UserVo;
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
import com.project.util.UUIDUtil;
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
        	UserVo driver = userMapper.selectDriverUser(userId);
        	if(driver == null) {
        		result.setMessage("当前用户不是驾驶员");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
        	String businessId = driver.getBusinessId();
        	//货物名称
        	List<TGoodsNameTypeVo> goodsNameTypeList = goodsNameTypeMapper.selectTGoodsNameTypeDicts(businessId);
        	//货物类项
//        	List<TDictView> type = dictMapper.selectTDictsByGoodsType("");
        	//驾驶员
        	List<TDictView> drivers = userMapper.selectUserByDriver(businessId,"驾驶员");
        	//押运员
        	List<TDictView> escorts = userMapper.selectUserByDriver(businessId,"押运员");
        	//行车前事项
        	List<TDictView> carCheckProject = dictMapper.selectTDictListByDictCodebusinessId("car_info",businessId,0);
        	//确认结论
        	List<TDictView> sureComment = dictMapper.selectTDictListByParentId("600");
        	Map<String, Object> driverMap = new HashMap<>();
        	driverMap.put("firstDriverId", driver.getUserId());
        	driverMap.put("firstDriverName", driver.getUserName());
        	Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("goodsNameTypeList", goodsNameTypeList);
			mapResult.put("drivers", drivers);
			mapResult.put("escorts", escorts);
			mapResult.put("carCheckProject", carCheckProject);
			mapResult.put("sureComment", sureComment);
			mapResult.put("firstDriver", driverMap);
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
	public DataResult queryLogParamMiddle(String userId) {
		DataResult result = new DataResult();
        try {
        	UserVo driver = userMapper.selectDriverUser(userId);
        	if(driver == null) {
        		result.setMessage("当前用户不是驾驶员");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
        	String businessId = driver.getBusinessId();
        	//行车中事项
        	List<TDictView> carCheckProject = dictMapper.selectTDictListByDictCodebusinessId("car_info",businessId,1);
        	Map<String, Object> driverMap = new HashMap<>();
        	driverMap.put("firstDriverId", driver.getUserId());
        	driverMap.put("firstDriverName", driver.getUserName());
        	Map<String, Object> mapResult = new HashMap<>();
			mapResult.put("carCheckProject", carCheckProject);
			mapResult.put("firstDriver", driverMap);
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
	public DataResult queryLogParamAfter(String userId) {
		DataResult result = new DataResult();
        try {
        	UserVo driver = userMapper.selectDriverUser(userId);
        	if(driver == null) {
        		result.setMessage("当前用户不是驾驶员");
    			result.setStatus(Result.FAILED);
    			return result;
        	}
        	String businessId = driver.getBusinessId();
        	//行车后事项
        	List<TDictView> carCheckProject = dictMapper.selectTDictListByDictCodebusinessId("car_info",businessId,2);
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
	@Transactional
	public DataResult addBeforeLog(String driverLogJson,String driverBeforeLogJson, MultipartFile[] files,MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	String drivePhotoUrl = null;
        	if(files != null && files.length > 0) {
	        	boolean fileType = FileUploadUtils.checkImgFiles(files);
				if(!fileType) {
					result.setMessage("上传图片类型错误");
					result.setStatus(Result.FAILED);
					return result;
				}
	        	drivePhotoUrl = fileSystemService.uploadFiles(files);
				if(StringUtils.isEmpty(drivePhotoUrl)) {
					result.setMessage("上传图片失败");
					result.setStatus(Result.FAILED);
					return result;
				}
        	}
        	boolean fileType = FileUploadUtils.checkImgFile(file);
			if(!fileType) {
				result.setMessage("上传图片类型错误");
				result.setStatus(Result.FAILED);
				return result;
			}
			String autograph = fileSystemService.uploadFile(file);
			if(StringUtils.isEmpty(autograph)) {
				result.setMessage("上传图片失败");
				result.setStatus(Result.FAILED);
				return result;
			}
			TDriverLog driverLog = JSON.parseObject(driverLogJson, TDriverLog.class);
			String driverLogId = UUIDUtil.getUUID();
			driverLog.setId(driverLogId);
			driverLog.setCreateDate(new Date());
			driverLog.setStatus("1");
			TDriverBeforeLogVo driverBeforeLogVo = JSON.parseObject(driverBeforeLogJson, TDriverBeforeLogVo.class);
			List<TDictView> carCheckProjectList = driverBeforeLogVo.getCarCheckProjectList();
        	TDriverBeforeLog tDriverBeforeLog = new TDriverBeforeLog();
        	tDriverBeforeLog.setDriverLogId(driverLogId);
        	tDriverBeforeLog.setNoAccord(driverBeforeLogVo.getNoAccord());
        	tDriverBeforeLog.setSureComment(driverBeforeLogVo.getSureComment());
        	tDriverBeforeLog.setRemark(driverBeforeLogVo.getRemark());
        	tDriverBeforeLog.setCarCheckProject(JSON.toJSONString(carCheckProjectList));
        	tDriverBeforeLog.setDrivePhotoUrl(drivePhotoUrl);
        	tDriverBeforeLog.setAutograph(autograph);
        	driverLogMapper.insertTDriverLog(driverLog);
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
	@Transactional
	public DataResult addMiddleLog(String driverLogJson, MultipartFile[] files,MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	String drivePhotoUrl = null;
        	if(files != null) {
	        	boolean fileType = FileUploadUtils.checkImgFiles(files);
				if(!fileType) {
					result.setMessage("上传图片类型错误");
					result.setStatus(Result.FAILED);
					return result;
				}
	        	drivePhotoUrl = fileSystemService.uploadFiles(files);
				if(StringUtils.isEmpty(drivePhotoUrl)) {
					result.setMessage("上传图片失败");
					result.setStatus(Result.FAILED);
					return result;
				}
        	}
        	boolean fileType = FileUploadUtils.checkImgFile(file);
			if(!fileType) {
				result.setMessage("上传图片类型错误");
				result.setStatus(Result.FAILED);
				return result;
			}
			String autograph = fileSystemService.uploadFile(file);
			if(StringUtils.isEmpty(autograph)) {
				result.setMessage("上传图片失败");
				result.setStatus(Result.FAILED);
				return result;
			}
        	TDriverMiddleLog tDriverMiddleLog = JSON.parseObject(driverLogJson, TDriverMiddleLog.class);
        	List<TDictView> carCheckProjectList = tDriverMiddleLog.getCarCheckProjectList();
        	tDriverMiddleLog.setDrivingPhoto(drivePhotoUrl);
        	tDriverMiddleLog.setAutograph(autograph);
        	tDriverMiddleLog.setCarCheckProject(JSON.toJSONString(carCheckProjectList));
        	driverMiddleLogMapper.insertTDriverMiddleLog(tDriverMiddleLog);
        	TDriverLog tDriverLog = new TDriverLog();
			tDriverLog.setId(tDriverMiddleLog.getDriverLogId());
			tDriverLog.setStatus("2");
			driverLogMapper.updateTDriverLog(tDriverLog);
			result.setMessage("添加行车中日志成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("添加行车中日志接口异常",e);
			throw new RuntimeException("添加行车中日志接口异常");
		}
	}
	
	@Override
	@Transactional
	public DataResult addAfterLog(String driverLogJson, MultipartFile[] files,MultipartFile file) {
		DataResult result = new DataResult();
        try {
        	String drivePhotoUrl = null;
        	if(files != null) {
	        	boolean fileType = FileUploadUtils.checkImgFiles(files);
				if(!fileType) {
					result.setMessage("上传图片类型错误");
					result.setStatus(Result.FAILED);
					return result;
				}
	        	drivePhotoUrl = fileSystemService.uploadFiles(files);
				if(StringUtils.isEmpty(drivePhotoUrl)) {
					result.setMessage("上传图片失败");
					result.setStatus(Result.FAILED);
					return result;
				}
        	}
        	boolean fileType = FileUploadUtils.checkImgFile(file);
			if(!fileType) {
				result.setMessage("上传图片类型错误");
				result.setStatus(Result.FAILED);
				return result;
			}
			String autograph = fileSystemService.uploadFile(file);
			if(StringUtils.isEmpty(autograph)) {
				result.setMessage("上传图片失败");
				result.setStatus(Result.FAILED);
				return result;
			}
        	TDriverAfterLog tDriverAfterLog = JSON.parseObject(driverLogJson, TDriverAfterLog.class);
        	List<TDictView> carCheckProjectList = tDriverAfterLog.getCarCheckProjectList();
        	tDriverAfterLog.setDrivingPhoto(drivePhotoUrl);
        	tDriverAfterLog.setAutograph(autograph);
        	tDriverAfterLog.setCarCheckProject(JSON.toJSONString(carCheckProjectList));
        	driverAfterLogMapper.insertTDriverAfterLog(tDriverAfterLog);
        	TDriverLog tDriverLog = new TDriverLog();
			tDriverLog.setId(tDriverAfterLog.getDriverLogId());
			tDriverLog.setStatus("3");
			driverLogMapper.updateTDriverLog(tDriverLog);
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

	@Override
	@Transactional
	public DataResult handover(String driverLogId,String exchangeRemark) {
		DataResult result = new DataResult();
        try {
        	TDriverLog tDriverLog = driverLogMapper.selectTDriverLogById(driverLogId);
        	String secondDriverId = tDriverLog.getSecondDriverId();
        	String firstDriverId = tDriverLog.getFirstDriverId();
        	tDriverLog.setFirstDriverId(secondDriverId);
        	tDriverLog.setSecondDriverId(firstDriverId);
        	tDriverLog.setUpdateDate(new Date());
        	TDriverBeforeLog tDriverBeforeLog = new TDriverBeforeLog();
        	tDriverBeforeLog.setDriverLogId(driverLogId);
        	tDriverBeforeLog.setExchangeRemark(exchangeRemark);
        	driverBeforeLogMapper.updateTDriverBeforeLog(tDriverBeforeLog);
        	driverLogMapper.updateTDriverLog(tDriverLog);
			result.setMessage("交接日志成功");
			result.setStatus(Result.SUCCESS);
			return result;
		} catch (Exception e) {
			log.error("交接接口异常",e);
			throw new RuntimeException("交接接口异常");
		}
	}
	
	
}
