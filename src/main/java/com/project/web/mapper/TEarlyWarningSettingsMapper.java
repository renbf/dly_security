package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TEarlyWarningSettings;	

/**
 * 预警设置 数据层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface TEarlyWarningSettingsMapper 
{
	/**
     * 查询预警设置信息
     * 
     * @param id 预警设置ID
     * @return 预警设置信息
     */
	public TEarlyWarningSettings selectTEarlyWarningSettingsById(String id);
	
	/**
     * 查询预警设置列表
     * 
     * @param tEarlyWarningSettings 预警设置信息
     * @return 预警设置集合
     */
	public List<TEarlyWarningSettings> selectTEarlyWarningSettingsList(TEarlyWarningSettings tEarlyWarningSettings);
	
	/**
     * 新增预警设置
     * 
     * @param tEarlyWarningSettings 预警设置信息
     * @return 结果
     */
	public int insertTEarlyWarningSettings(TEarlyWarningSettings tEarlyWarningSettings);
	
	/**
     * 修改预警设置
     * 
     * @param tEarlyWarningSettings 预警设置信息
     * @return 结果
     */
	public int updateTEarlyWarningSettings(TEarlyWarningSettings tEarlyWarningSettings);
	
	/**
     * 删除预警设置
     * 
     * @param id 预警设置ID
     * @return 结果
     */
	public int deleteTEarlyWarningSettingsById(String id);
	
	/**
     * 批量删除预警设置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTEarlyWarningSettingsByIds(String[] ids);
	
}