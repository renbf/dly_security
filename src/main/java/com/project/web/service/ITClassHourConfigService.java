package com.project.web.service;

import com.project.web.domian.TClassHourConfig;
import java.util.List;

/**
 * 课时配置 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITClassHourConfigService 
{
	/**
     * 查询课时配置信息
     * 
     * @param id 课时配置ID
     * @return 课时配置信息
     */
	public TClassHourConfig selectTClassHourConfigById(String id);
	
	/**
     * 查询课时配置列表
     * 
     * @param tClassHourConfig 课时配置信息
     * @return 课时配置集合
     */
	public List<TClassHourConfig> selectTClassHourConfigList(TClassHourConfig tClassHourConfig);
	
	/**
     * 新增课时配置
     * 
     * @param tClassHourConfig 课时配置信息
     * @return 结果
     */
	public int insertTClassHourConfig(TClassHourConfig tClassHourConfig);
	
	/**
     * 修改课时配置
     * 
     * @param tClassHourConfig 课时配置信息
     * @return 结果
     */
	public int updateTClassHourConfig(TClassHourConfig tClassHourConfig);
		
	/**
     * 删除课时配置信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTClassHourConfigByIds(String ids);
	//以上自动生成的尽量别动
}
