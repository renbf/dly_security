package com.project.web.service;

import java.util.List;

import com.project.common.base.AjaxResult;
import com.project.web.domian.Dept;

/**
 * 部门 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface IDeptService 
{
	/**
     * 查询部门信息
     * 
     * @param deptId 部门ID
     * @return 部门信息
     */
	public Dept selectDeptById(Long deptId);
	
	/**
     * 查询部门列表
     * 
     * @param dept 部门信息
     * @return 部门集合
     */
	public List<Dept> selectDeptList(Dept dept);
	
	/**
     * 根据企业ID查询部门列表
     * 
     * @param dept 部门信息
     * @return 部门集合
     */
	public List<Dept> selectDeptListByBus(Dept dept);
	
	/**
     * 新增部门
     * 
     * @param dept 部门信息
     * @return 结果
     */
	public AjaxResult insertDept(Dept dept);
	
	/**
     * 修改部门
     * 
     * @param dept 部门信息
     * @return 结果
     */
	public AjaxResult updateDept(Dept dept);
		
	/**
     * 删除部门信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public AjaxResult deleteDeptByIds(String ids);
	
}
