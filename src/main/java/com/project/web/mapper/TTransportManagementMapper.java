package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TTransportManagement;	

/**
 * 客运管理 数据层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface TTransportManagementMapper 
{
	/**
     * 查询客运管理信息
     * 
     * @param id 客运管理ID
     * @return 客运管理信息
     */
	public TTransportManagement selectTTransportManagementById(Long id);
	
	/**
     * 查询客运管理列表
     * 
     * @param tTransportManagement 客运管理信息
     * @return 客运管理集合
     */
	public List<TTransportManagement> selectTTransportManagementList(TTransportManagement tTransportManagement);
	
	/**
     * 新增客运管理
     * 
     * @param tTransportManagement 客运管理信息
     * @return 结果
     */
	public int insertTTransportManagement(TTransportManagement tTransportManagement);
	
	/**
     * 修改客运管理
     * 
     * @param tTransportManagement 客运管理信息
     * @return 结果
     */
	public int updateTTransportManagement(TTransportManagement tTransportManagement);
	
	/**
     * 删除客运管理
     * 
     * @param id 客运管理ID
     * @return 结果
     */
	public int deleteTTransportManagementById(Long id);
	
	/**
     * 批量删除客运管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTTransportManagementByIds(String[] ids);
	
}