package com.project.web.mapper;

import com.project.web.domian.TDrivingLicenseLog;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 行驶证变更 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tDrivingLicenseLogMapper")
public interface TDrivingLicenseLogMapper 
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
	public int insertTDrivingLicenseLog(TDrivingLicenseLog tDrivingLicenseLog);
	
	/**
     * 修改行驶证变更
     * 
     * @param tDrivingLicenseLog 行驶证变更信息
     * @return 结果
     */
	public int updateTDrivingLicenseLog(TDrivingLicenseLog tDrivingLicenseLog);
	
	/**
     * 删除行驶证变更
     * 
     * @param id 行驶证变更ID
     * @return 结果
     */
	public int deleteTDrivingLicenseLogById(String id);
	
	/**
     * 批量删除行驶证变更
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDrivingLicenseLogByIds(String[] ids);
	//以上自动生成的尽量别动

	/**
	 * 批量删除  根据车辆信息id
	 * @param ids
	 * @return
	 */
	public int deleteByCarInfoId(String[] ids);
}