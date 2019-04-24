package com.project.web.service;

import java.util.List;

import com.project.web.domian.TDepartureCheck;

/**
 * 出站例检 服务层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface ITDepartureCheckService 
{
	/**
     * 查询出站例检信息
     * 
     * @param id 出站例检ID
     * @return 出站例检信息
     */
	public TDepartureCheck selectTDepartureCheckById(Long id);
	
	/**
     * 查询出站例检列表
     * 
     * @param tDepartureCheck 出站例检信息
     * @return 出站例检集合
     */
	public List<TDepartureCheck> selectTDepartureCheckList(TDepartureCheck tDepartureCheck);
	
	/**
     * 新增出站例检
     * 
     * @param tDepartureCheck 出站例检信息
     * @return 结果
     */
	public int insertTDepartureCheck(TDepartureCheck tDepartureCheck);
	
	/**
     * 修改出站例检
     * 
     * @param tDepartureCheck 出站例检信息
     * @return 结果
     */
	public int updateTDepartureCheck(TDepartureCheck tDepartureCheck);
		
	/**
     * 删除出站例检信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDepartureCheckByIds(String ids);
	
}
