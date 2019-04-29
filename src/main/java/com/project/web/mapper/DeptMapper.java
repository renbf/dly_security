package com.project.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.web.domian.Dept;	

/**
 * 部门 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Repository("webDeptMapper")
public interface DeptMapper 
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
     *	 根据企业ID查询部门列表
     * 
     * @param dept 部门信息
     * @return 部门集合
     */
	public List<Dept> selectDeptListByBusiness(Dept dept);
	
	/**
     * 新增部门
     * 
     * @param dept 部门信息
     * @return 结果
     */
	public int insertDept(Dept dept);
	
	/**
     * 修改部门
     * 
     * @param dept 部门信息
     * @return 结果
     */
	public int updateDept(Dept dept);
	
	/**
     * 删除部门
     * 
     * @param deptId 部门ID
     * @return 结果
     */
	public int deleteDeptById(Long deptId);
	
	/**
     * 批量删除部门
     * 
     * @param deptIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteDeptByIds(String[] deptIds);
	
}