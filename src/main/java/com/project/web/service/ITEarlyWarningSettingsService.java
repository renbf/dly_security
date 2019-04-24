package com.project.web.service;

import java.util.List;

import com.project.web.domian.TEarlyWarningSettings;

/**
 * 预警设置 服务层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface ITEarlyWarningSettingsService 
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
     * 删除预警设置信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTEarlyWarningSettingsByIds(String ids);
	
}
