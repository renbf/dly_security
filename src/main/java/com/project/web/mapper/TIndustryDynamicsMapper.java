package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TIndustryDynamics;	

/**
 * 行业动态 数据层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface TIndustryDynamicsMapper 
{
	/**
     * 查询行业动态信息
     * 
     * @param id 行业动态ID
     * @return 行业动态信息
     */
	public TIndustryDynamics selectTIndustryDynamicsById(String id);
	
	/**
     * 查询行业动态列表
     * 
     * @param tIndustryDynamics 行业动态信息
     * @return 行业动态集合
     */
	public List<TIndustryDynamics> selectTIndustryDynamicsList(TIndustryDynamics tIndustryDynamics);
	
	/**
     * 新增行业动态
     * 
     * @param tIndustryDynamics 行业动态信息
     * @return 结果
     */
	public int insertTIndustryDynamics(TIndustryDynamics tIndustryDynamics);
	
	/**
     * 修改行业动态
     * 
     * @param tIndustryDynamics 行业动态信息
     * @return 结果
     */
	public int updateTIndustryDynamics(TIndustryDynamics tIndustryDynamics);
	
	/**
     * 删除行业动态
     * 
     * @param id 行业动态ID
     * @return 结果
     */
	public int deleteTIndustryDynamicsById(String id);
	
	/**
     * 批量删除行业动态
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTIndustryDynamicsByIds(String[] ids);
	
}