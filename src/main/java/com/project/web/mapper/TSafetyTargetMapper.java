package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TSafetyTarget;	

/**
 * 安全目标 数据层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface TSafetyTargetMapper 
{
	/**
     * 查询安全目标信息
     * 
     * @param id 安全目标ID
     * @return 安全目标信息
     */
	public TSafetyTarget selectTSafetyTargetById(String id);
	
	/**
     * 查询安全目标列表
     * 
     * @param tSafetyTarget 安全目标信息
     * @return 安全目标集合
     */
	public List<TSafetyTarget> selectTSafetyTargetList(TSafetyTarget tSafetyTarget);
	
	/**
     * 新增安全目标
     * 
     * @param tSafetyTarget 安全目标信息
     * @return 结果
     */
	public int insertTSafetyTarget(TSafetyTarget tSafetyTarget);
	
	/**
     * 修改安全目标
     * 
     * @param tSafetyTarget 安全目标信息
     * @return 结果
     */
	public int updateTSafetyTarget(TSafetyTarget tSafetyTarget);
	
	/**
     * 删除安全目标
     * 
     * @param id 安全目标ID
     * @return 结果
     */
	public int deleteTSafetyTargetById(String id);
	
	/**
     * 批量删除安全目标
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSafetyTargetByIds(String[] ids);
	
}