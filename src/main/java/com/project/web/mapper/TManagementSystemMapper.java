package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TManagementSystem;	

/**
 * 管理制度 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface TManagementSystemMapper 
{
	/**
     * 查询管理制度信息
     * 
     * @param id 管理制度ID
     * @return 管理制度信息
     */
	public TManagementSystem selectTManagementSystemById(String id);
	
	/**
     * 查询管理制度列表
     * 
     * @param tManagementSystem 管理制度信息
     * @return 管理制度集合
     */
	public List<TManagementSystem> selectTManagementSystemList(TManagementSystem tManagementSystem);
	
	/**
     * 新增管理制度
     * 
     * @param tManagementSystem 管理制度信息
     * @return 结果
     */
	public int insertTManagementSystem(TManagementSystem tManagementSystem);
	
	/**
     * 修改管理制度
     * 
     * @param tManagementSystem 管理制度信息
     * @return 结果
     */
	public int updateTManagementSystem(TManagementSystem tManagementSystem);
	
	/**
     * 删除管理制度
     * 
     * @param id 管理制度ID
     * @return 结果
     */
	public int deleteTManagementSystemById(String id);
	
	/**
     * 批量删除管理制度
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTManagementSystemByIds(String[] ids);
	
}