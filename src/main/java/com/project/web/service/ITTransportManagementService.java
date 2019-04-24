package com.project.web.service;

import java.util.List;

import com.project.web.domian.TTransportManagement;

/**
 * 客运管理 服务层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface ITTransportManagementService 
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
     * 删除客运管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTTransportManagementByIds(String ids);
	
}
