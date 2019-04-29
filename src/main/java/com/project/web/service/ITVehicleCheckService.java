package com.project.web.service;

import java.util.List;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TVehicleCheck;

/**
 * 车辆例检 服务层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface ITVehicleCheckService 
{
	/**
     * 查询车辆例检信息
     * 
     * @param id 车辆例检ID
     * @return 车辆例检信息
     */
	public TVehicleCheck selectTVehicleCheckById(Long id);
	
	/**
     * 查询车辆例检列表
     * 
     * @param tVehicleCheck 车辆例检信息
     * @return 车辆例检集合
     */
	public List<TVehicleCheck> selectTVehicleCheckList(TVehicleCheck tVehicleCheck);
	
	/**
     * 新增车辆例检
     * 
     * @param tVehicleCheck 车辆例检信息
     * @return 结果
     */
	public AjaxResult insertTVehicleCheck(TVehicleCheck tVehicleCheck);
	
	/**
     * 修改车辆例检
     * 
     * @param tVehicleCheck 车辆例检信息
     * @return 结果
     */
	public AjaxResult updateTVehicleCheck(TVehicleCheck tVehicleCheck);
		
	/**
     * 删除车辆例检信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTVehicleCheckByIds(String ids);
	
}
