package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TEarlyWarningSettings;
import com.project.web.mapper.TEarlyWarningSettingsMapper;
import com.project.web.service.ITEarlyWarningSettingsService;

/**
 * 预警设置 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TEarlyWarningSettingsServiceImpl implements ITEarlyWarningSettingsService 
{
	@Autowired
	private TEarlyWarningSettingsMapper tEarlyWarningSettingsMapper;

	/**
     * 查询预警设置信息
     * 
     * @param id 预警设置ID
     * @return 预警设置信息
     */
    @Override
	public TEarlyWarningSettings selectTEarlyWarningSettingsById(String id)
	{
	    return tEarlyWarningSettingsMapper.selectTEarlyWarningSettingsById(id);
	}
	
	/**
     * 查询预警设置列表
     * 
     * @param tEarlyWarningSettings 预警设置信息
     * @return 预警设置集合
     */
	@Override
	public List<TEarlyWarningSettings> selectTEarlyWarningSettingsList(TEarlyWarningSettings tEarlyWarningSettings)
	{
	    return tEarlyWarningSettingsMapper.selectTEarlyWarningSettingsList(tEarlyWarningSettings);
	}
	
    /**
     * 新增预警设置
     * 
     * @param tEarlyWarningSettings 预警设置信息
     * @return 结果
     */
	@Override
	public int insertTEarlyWarningSettings(TEarlyWarningSettings tEarlyWarningSettings)
	{
		tEarlyWarningSettings.setId(UUIDUtil.getUUID());
		tEarlyWarningSettings.setCreateTime(new Date());
		return tEarlyWarningSettingsMapper.insertTEarlyWarningSettings(tEarlyWarningSettings);
	}
	
	/**
     * 修改预警设置
     * 
     * @param tEarlyWarningSettings 预警设置信息
     * @return 结果
     */
	@Override
	public int updateTEarlyWarningSettings(TEarlyWarningSettings tEarlyWarningSettings)
	{
	    return tEarlyWarningSettingsMapper.updateTEarlyWarningSettings(tEarlyWarningSettings);
	}

	/**
     * 删除预警设置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTEarlyWarningSettingsByIds(String ids)
	{
		return tEarlyWarningSettingsMapper.deleteTEarlyWarningSettingsByIds(Convert.toStrArray(ids));
	}
	
}
