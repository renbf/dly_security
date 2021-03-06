package com.project.security.service;

import org.springframework.web.multipart.MultipartFile;

import com.project.common.result.DataResult;

/**
 * 
 * @author rbf
 *
 */
public interface IDriveLogService {
	/**
	 * 查询行车前需要日志参数接口
	 * @return
	 */
	public DataResult queryLogParamBefore(String userId);
	/**
	 * 查询行车中需要日志参数接口
	 * @return
	 */
	public DataResult queryLogParamMiddle(String userId);
	
	/**
	 * 查询行车后需要日志参数接口
	 * @return
	 */
	public DataResult queryLogParamAfter(String userId);
	/**
	 * 添加行车前日志接口
	 * @return
	 */
	public DataResult addBeforeLog(String driverLogJson,String driverBeforeLogJson,MultipartFile[] files,MultipartFile file);
	/**
	 * 添加行车中日志接口
	 * @return
	 */
	public DataResult addMiddleLog(String driverLogJson,MultipartFile[] files,MultipartFile file);
	/**
	 * 添加行车后日志接口
	 * @return
	 */
	public DataResult addAfterLog(String driverLogJson,MultipartFile[] files,MultipartFile file);
	
	/**
	 * 查询日志详情——行车前接口
	 * @return
	 */
	public DataResult queryLogBeforeDetail(String driverLogId);
	/**
	 * 查询日志详情——行车中接口
	 * @return
	 */
	public DataResult queryLogMiddleDetail(String driverLogId);
	/**
	 * 查询日志详情——行车后接口
	 * @return
	 */
	public DataResult queryLogAfterDetail(String driverLogId);
	
	/**
	 * 查询日志接口
	 * @return
	 */
	public DataResult queryLog(Integer pageNumber,Long total,String userId);
	
	/**
	 * 交接日志接口
	 * @return
	 */
	public DataResult handover(String driverLogId,String exchangeRemark);
}
