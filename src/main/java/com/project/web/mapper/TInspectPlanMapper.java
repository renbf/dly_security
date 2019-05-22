package com.project.web.mapper;

import com.project.web.domian.TInspectPlan;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 检查计划 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tInspectPlanMapper")
public interface TInspectPlanMapper 
{
	/**
     * 查询检查计划信息
     * 
     * @param id 检查计划ID
     * @return 检查计划信息
     */
	public TInspectPlan selectTInspectPlanById(String id);
	
	/**
     * 查询检查计划列表
     * 
     * @param tInspectPlan 检查计划信息
     * @return 检查计划集合
     */
	public List<TInspectPlan> selectTInspectPlanList(TInspectPlan tInspectPlan);
	
	/**
     * 新增检查计划
     * 
     * @param tInspectPlan 检查计划信息
     * @return 结果
     */
	public int insertTInspectPlan(TInspectPlan tInspectPlan);
	
	/**
     * 修改检查计划
     * 
     * @param tInspectPlan 检查计划信息
     * @return 结果
     */
	public int updateTInspectPlan(TInspectPlan tInspectPlan);
	
	/**
     * 删除检查计划
     * 
     * @param id 检查计划ID
     * @return 结果
     */
	public int deleteTInspectPlanById(String id);
	
	/**
     * 批量删除检查计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTInspectPlanByIds(String[] ids);
	//以上自动生成的尽量别动

	/**
	 * 删除检查计划根据 标题ID (该模块主表的主键)
	 * @param titleId
	 * @return
	 */
	public int deleteTInspectPlanByTitleId(String[] titleIds);


	/**
	 *修改检查计划根据  检查计划主表id
	 */
	public int updateTInspectPlanByTitleId(TInspectPlan tInspectPlan);
}