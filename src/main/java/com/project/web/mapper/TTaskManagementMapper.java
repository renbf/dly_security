package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TTaskManagement;	

/**
 * 作业管理 数据层
 * 
 * @author rbf
 * @date 2019-04-15
 */
public interface TTaskManagementMapper 
{
	/**
     * 查询作业管理信息
     * 
     * @param id 作业管理ID
     * @return 作业管理信息
     */
	public TTaskManagement selectTTaskManagementById(Long id);
	
	/**
     * 查询作业管理列表
     * 
     * @param tTaskManagement 作业管理信息
     * @return 作业管理集合
     */
	public List<TTaskManagement> selectTTaskManagementList(TTaskManagement tTaskManagement);
	
	/**
     * 新增作业管理
     * 
     * @param tTaskManagement 作业管理信息
     * @return 结果
     */
	public int insertTTaskManagement(TTaskManagement tTaskManagement);
	
	/**
     * 修改作业管理
     * 
     * @param tTaskManagement 作业管理信息
     * @return 结果
     */
	public int updateTTaskManagement(TTaskManagement tTaskManagement);
	
	/**
     * 删除作业管理
     * 
     * @param id 作业管理ID
     * @return 结果
     */
	public int deleteTTaskManagementById(Long id);
	
	/**
     * 批量删除作业管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTTaskManagementByIds(String[] ids);
	
}