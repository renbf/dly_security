package com.project.web.mapper;

import com.project.web.domian.TContingencyDrillPlan;

import java.util.List;

/**
 * 应急演练计划 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface TContingencyDrillPlanMapper 
{
	/**
     * 查询应急演练计划信息
     * 
     * @param id 应急演练计划ID
     * @return 应急演练计划信息
     */
	public TContingencyDrillPlan selectTContingencyDrillPlanById(String id);
	
	/**
     * 查询应急演练计划列表
     * 
     * @param tContingencyDrillPlan 应急演练计划信息
     * @return 应急演练计划集合
     */
	public List<TContingencyDrillPlan> selectTContingencyDrillPlanList(TContingencyDrillPlan tContingencyDrillPlan);
	
	/**
     * 新增应急演练计划
     * 
     * @param tContingencyDrillPlan 应急演练计划信息
     * @return 结果
     */
	public int insertTContingencyDrillPlan(TContingencyDrillPlan tContingencyDrillPlan);
	
	/**
     * 修改应急演练计划
     * 
     * @param tContingencyDrillPlan 应急演练计划信息
     * @return 结果
     */
	public int updateTContingencyDrillPlan(TContingencyDrillPlan tContingencyDrillPlan);
	
	/**
     * 删除应急演练计划
     * 
     * @param id 应急演练计划ID
     * @return 结果
     */
	public int deleteTContingencyDrillPlanById(String id);
	
	/**
     * 批量删除应急演练计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTContingencyDrillPlanByIds(String[] ids);
	
}