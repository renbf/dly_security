package com.project.security.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.security.domain.TInspectPlan;
import com.project.security.domain.vo.TInspectPlanVo;	

/**
 * 检查计划 数据层
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Repository("inspectPlanMapper")
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
	 * 检查计划
	 * @param userId
	 * @return
	 */
	public List<TInspectPlanVo> selectTInspectPlanListByUserId(String userId);
}