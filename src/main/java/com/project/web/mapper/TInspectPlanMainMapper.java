package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TInspectPlanMain;	

/**
 * 检查计划主 数据层
 * 
 * @author rbf
 * @date 2019-05-05
 */
public interface TInspectPlanMainMapper 
{
	/**
     * 查询检查计划主信息
     * 
     * @param titleId 检查计划主ID
     * @return 检查计划主信息
     */
	public TInspectPlanMain selectTInspectPlanMainById(String titleId);
	
	/**
     * 查询检查计划主列表
     * 
     * @param tInspectPlanMain 检查计划主信息
     * @return 检查计划主集合
     */
	public List<TInspectPlanMain> selectTInspectPlanMainList(TInspectPlanMain tInspectPlanMain);
	
	/**
     * 新增检查计划主
     * 
     * @param tInspectPlanMain 检查计划主信息
     * @return 结果
     */
	public int insertTInspectPlanMain(TInspectPlanMain tInspectPlanMain);
	
	/**
     * 修改检查计划主
     * 
     * @param tInspectPlanMain 检查计划主信息
     * @return 结果
     */
	public int updateTInspectPlanMain(TInspectPlanMain tInspectPlanMain);
	
	/**
     * 删除检查计划主
     * 
     * @param titleId 检查计划主ID
     * @return 结果
     */
	public int deleteTInspectPlanMainById(String titleId);
	
	/**
     * 批量删除检查计划主
     * 
     * @param titleIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTInspectPlanMainByIds(String[] titleIds);
	
}