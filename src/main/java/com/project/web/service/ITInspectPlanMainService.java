package com.project.web.service;

import java.util.List;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TInspectPlanMain;

/**
 * 检查计划主 服务层
 * 
 * @author rbf
 * @date 2019-05-05
 */
public interface ITInspectPlanMainService 
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
	public AjaxResult insertTInspectPlanMain(TInspectPlanMain tInspectPlanMain);
	
	/**
     * 修改检查计划主
     * 
     * @param tInspectPlanMain 检查计划主信息
     * @return 结果
     */
	public AjaxResult updateTInspectPlanMain(TInspectPlanMain tInspectPlanMain);
		
	/**
     * 删除检查计划主信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTInspectPlanMainByIds(String ids);
	
}
