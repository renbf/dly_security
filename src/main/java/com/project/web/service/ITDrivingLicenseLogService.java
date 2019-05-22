package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TDrivingLicenseLog;
import java.util.List;

/**
 * 行驶证变更 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITDrivingLicenseLogService 
{
	/**
     * 查询行驶证变更信息
     * 
     * @param id 行驶证变更ID
     * @return 行驶证变更信息
     */
	public TDrivingLicenseLog selectTDrivingLicenseLogById(String id);
	
	/**
     * 查询行驶证变更列表
     * 
     * @param tDrivingLicenseLog 行驶证变更信息
     * @return 行驶证变更集合
     */
	public List<TDrivingLicenseLog> selectTDrivingLicenseLogList(TDrivingLicenseLog tDrivingLicenseLog);
	
	/**
     * 新增行驶证变更
     * 
     * @param tDrivingLicenseLog 行驶证变更信息
     * @return 结果
     */
	public AjaxResult insertTDrivingLicenseLog(TDrivingLicenseLog tDrivingLicenseLog);
	
	/**
     * 修改行驶证变更
     * 
     * @param tDrivingLicenseLog 行驶证变更信息
     * @return 结果
     */
	public AjaxResult updateTDrivingLicenseLog(TDrivingLicenseLog tDrivingLicenseLog);
		
	/**
     * 删除行驶证变更信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDrivingLicenseLogByIds(String ids);
	//以上自动生成的尽量别动
}
