package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TSafetyDuty;	

/**
 * 安全值班 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface TSafetyDutyMapper 
{
	/**
     * 查询安全值班信息
     * 
     * @param id 安全值班ID
     * @return 安全值班信息
     */
	public TSafetyDuty selectTSafetyDutyById(String id);
	
	/**
     * 查询安全值班列表
     * 
     * @param tSafetyDuty 安全值班信息
     * @return 安全值班集合
     */
	public List<TSafetyDuty> selectTSafetyDutyList(TSafetyDuty tSafetyDuty);
	
	/**
     * 新增安全值班
     * 
     * @param tSafetyDuty 安全值班信息
     * @return 结果
     */
	public int insertTSafetyDuty(TSafetyDuty tSafetyDuty);
	
	/**
     * 修改安全值班
     * 
     * @param tSafetyDuty 安全值班信息
     * @return 结果
     */
	public int updateTSafetyDuty(TSafetyDuty tSafetyDuty);
	
	/**
     * 删除安全值班
     * 
     * @param id 安全值班ID
     * @return 结果
     */
	public int deleteTSafetyDutyById(String id);
	
	/**
     * 批量删除安全值班
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSafetyDutyByIds(String[] ids);
	
}