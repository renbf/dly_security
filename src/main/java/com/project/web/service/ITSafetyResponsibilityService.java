package com.project.web.service;

import java.util.List;

import com.project.web.domian.TSafetyResponsibility;

/**
 * 安全责任 服务层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface ITSafetyResponsibilityService 
{
	/**
     * 查询安全责任信息
     * 
     * @param id 安全责任ID
     * @return 安全责任信息
     */
	public TSafetyResponsibility selectTSafetyResponsibilityById(String id);
	
	/**
     * 查询安全责任列表
     * 
     * @param tSafetyResponsibility 安全责任信息
     * @return 安全责任集合
     */
	public List<TSafetyResponsibility> selectTSafetyResponsibilityList(TSafetyResponsibility tSafetyResponsibility);
	
	/**
     * 新增安全责任
     * 
     * @param tSafetyResponsibility 安全责任信息
     * @return 结果
     */
	public int insertTSafetyResponsibility(TSafetyResponsibility tSafetyResponsibility);
	
	/**
     * 修改安全责任
     * 
     * @param tSafetyResponsibility 安全责任信息
     * @return 结果
     */
	public int updateTSafetyResponsibility(TSafetyResponsibility tSafetyResponsibility);
		
	/**
     * 删除安全责任信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSafetyResponsibilityByIds(String ids);
	
}
