package com.project.web.service;

import java.util.List;

import com.project.web.domian.TOperatingProcedures;

/**
 * 操作规程 服务层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface ITOperatingProceduresService 
{
	/**
     * 查询操作规程信息
     * 
     * @param id 操作规程ID
     * @return 操作规程信息
     */
	public TOperatingProcedures selectTOperatingProceduresById(String id);
	
	/**
     * 查询操作规程列表
     * 
     * @param tOperatingProcedures 操作规程信息
     * @return 操作规程集合
     */
	public List<TOperatingProcedures> selectTOperatingProceduresList(TOperatingProcedures tOperatingProcedures);
	
	/**
     * 新增操作规程
     * 
     * @param tOperatingProcedures 操作规程信息
     * @return 结果
     */
	public int insertTOperatingProcedures(TOperatingProcedures tOperatingProcedures);
	
	/**
     * 修改操作规程
     * 
     * @param tOperatingProcedures 操作规程信息
     * @return 结果
     */
	public int updateTOperatingProcedures(TOperatingProcedures tOperatingProcedures);
		
	/**
     * 删除操作规程信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTOperatingProceduresByIds(String ids);
	
}
