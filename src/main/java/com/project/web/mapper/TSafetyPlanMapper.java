package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TSafetyPlan;	

/**
 * 安全计划 数据层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface TSafetyPlanMapper 
{
	/**
     * 查询安全计划信息
     * 
     * @param id 安全计划ID
     * @return 安全计划信息
     */
	public TSafetyPlan selectTSafetyPlanById(String id);
	
	/**
     * 查询安全计划列表
     * 
     * @param tSafetyPlan 安全计划信息
     * @return 安全计划集合
     */
	public List<TSafetyPlan> selectTSafetyPlanList(TSafetyPlan tSafetyPlan);
	
	/**
     * 新增安全计划
     * 
     * @param tSafetyPlan 安全计划信息
     * @return 结果
     */
	public int insertTSafetyPlan(TSafetyPlan tSafetyPlan);
	
	/**
     * 修改安全计划
     * 
     * @param tSafetyPlan 安全计划信息
     * @return 结果
     */
	public int updateTSafetyPlan(TSafetyPlan tSafetyPlan);
	
	/**
     * 删除安全计划
     * 
     * @param id 安全计划ID
     * @return 结果
     */
	public int deleteTSafetyPlanById(String id);
	
	/**
     * 批量删除安全计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSafetyPlanByIds(String[] ids);
	
}