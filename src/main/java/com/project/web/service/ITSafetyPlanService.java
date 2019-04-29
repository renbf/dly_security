package com.project.web.service;

import java.util.List;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TSafetyPlan;
import org.springframework.web.multipart.MultipartFile;

/**
 * 安全计划 服务层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface ITSafetyPlanService 
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
	public AjaxResult insertTSafetyPlan(TSafetyPlan tSafetyPlan, MultipartFile planFile);
	
	/**
     * 修改安全计划
     * 
     * @param tSafetyPlan 安全计划信息
     * @return 结果
     */
	public AjaxResult updateTSafetyPlan(TSafetyPlan tSafetyPlan,MultipartFile planFile);
		
	/**
     * 删除安全计划信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSafetyPlanByIds(String ids);
	
}
