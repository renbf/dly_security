package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TAccidentBasics;	

/**
 * 事故基础 数据层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface TAccidentBasicsMapper 
{
	/**
     * 查询事故基础信息
     * 
     * @param id 事故基础ID
     * @return 事故基础信息
     */
	public TAccidentBasics selectTAccidentBasicsById(String id);
	
	/**
     * 查询事故基础列表
     * 
     * @param tAccidentBasics 事故基础信息
     * @return 事故基础集合
     */
	public List<TAccidentBasics> selectTAccidentBasicsList(TAccidentBasics tAccidentBasics);
	
	/**
     * 新增事故基础
     * 
     * @param tAccidentBasics 事故基础信息
     * @return 结果
     */
	public int insertTAccidentBasics(TAccidentBasics tAccidentBasics);
	
	/**
     * 修改事故基础
     * 
     * @param tAccidentBasics 事故基础信息
     * @return 结果
     */
	public int updateTAccidentBasics(TAccidentBasics tAccidentBasics);
	
	/**
     * 删除事故基础
     * 
     * @param id 事故基础ID
     * @return 结果
     */
	public int deleteTAccidentBasicsById(String id);
	
	/**
     * 批量删除事故基础
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTAccidentBasicsByIds(String[] ids);
	
}