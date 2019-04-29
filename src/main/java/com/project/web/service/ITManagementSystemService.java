package com.project.web.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.web.domian.TManagementSystem;

/**
 * 管理制度 服务层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface ITManagementSystemService 
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
	public int insertTManagementSystem(TManagementSystem tManagementSystem,MultipartFile managementFile);
	
	/**
     * 修改管理制度
     * 
     * @param tManagementSystem 管理制度信息
     * @return 结果
     */
	public int updateTManagementSystem(TManagementSystem tManagementSystem,MultipartFile managementFile);
		
	/**
     * 删除管理制度信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTManagementSystemByIds(String ids);
	
}
