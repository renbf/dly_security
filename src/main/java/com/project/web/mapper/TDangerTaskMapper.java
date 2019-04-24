package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TDangerTask;	

/**
 * 危险作业 数据层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface TDangerTaskMapper 
{
	/**
     * 查询危险作业信息
     * 
     * @param id 危险作业ID
     * @return 危险作业信息
     */
	public TDangerTask selectTDangerTaskById(Long id);
	
	/**
     * 查询危险作业列表
     * 
     * @param tDangerTask 危险作业信息
     * @return 危险作业集合
     */
	public List<TDangerTask> selectTDangerTaskList(TDangerTask tDangerTask);
	
	/**
     * 新增危险作业
     * 
     * @param tDangerTask 危险作业信息
     * @return 结果
     */
	public int insertTDangerTask(TDangerTask tDangerTask);
	
	/**
     * 修改危险作业
     * 
     * @param tDangerTask 危险作业信息
     * @return 结果
     */
	public int updateTDangerTask(TDangerTask tDangerTask);
	
	/**
     * 删除危险作业
     * 
     * @param id 危险作业ID
     * @return 结果
     */
	public int deleteTDangerTaskById(Long id);
	
	/**
     * 批量删除危险作业
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDangerTaskByIds(String[] ids);
	
}