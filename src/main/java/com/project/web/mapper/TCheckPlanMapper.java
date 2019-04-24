package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TCheckPlan;	

/**
 * 检查计划 数据层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface TCheckPlanMapper 
{
	/**
     * 查询检查计划信息
     * 
     * @param id 检查计划ID
     * @return 检查计划信息
     */
	public TCheckPlan selectTCheckPlanById(String id);
	
	/**
     * 查询检查计划列表
     * 
     * @param tCheckPlan 检查计划信息
     * @return 检查计划集合
     */
	public List<TCheckPlan> selectTCheckPlanList(TCheckPlan tCheckPlan);
	
	/**
     * 新增检查计划
     * 
     * @param tCheckPlan 检查计划信息
     * @return 结果
     */
	public int insertTCheckPlan(TCheckPlan tCheckPlan);
	
	/**
     * 修改检查计划
     * 
     * @param tCheckPlan 检查计划信息
     * @return 结果
     */
	public int updateTCheckPlan(TCheckPlan tCheckPlan);
	
	/**
     * 删除检查计划
     * 
     * @param id 检查计划ID
     * @return 结果
     */
	public int deleteTCheckPlanById(String id);
	
	/**
     * 批量删除检查计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCheckPlanByIds(String[] ids);
	
}