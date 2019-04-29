
package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TUsersManagement;	

/**
 * 人员台账 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface TUsersManagementMapper 
{
	/**
     * 查询人员台账信息
     * 
     * @param id 人员台账ID
     * @return 人员台账信息
     */
	public TUsersManagement selectTUsersManagementById(String id);
	
	/**
     * 查询人员台账列表
     * 
     * @param tUsersManagement 人员台账信息
     * @return 人员台账集合
     */
	public List<TUsersManagement> selectTUsersManagementList(TUsersManagement tUsersManagement);
	
	/**
     * 根据岗位查询人员列表
     * 
     * @param tUsersManagement 根据岗位查询人员列表
     * @return 人员台账集合
     */
	public List<TUsersManagement> selectTUsersManagementListByPostId(TUsersManagement tUsersManagement);
	
	/**
     * 新增人员台账
     * 
     * @param tUsersManagement 人员台账信息
     * @return 结果
     */
	public int insertTUsersManagement(TUsersManagement tUsersManagement);
	
	/**
     * 修改人员台账
     * 
     * @param tUsersManagement 人员台账信息
     * @return 结果
     */
	public int updateTUsersManagement(TUsersManagement tUsersManagement);
	
	/**
     * 删除人员台账
     * 
     * @param id 人员台账ID
     * @return 结果
     */
	public int deleteTUsersManagementById(String id);
	
	/**
     * 批量删除人员台账
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUsersManagementByIds(String[] ids);
	
}