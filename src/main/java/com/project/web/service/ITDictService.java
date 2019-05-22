package com.project.web.service;

import java.util.List;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TDict;

/**
 * 字典 服务层
 * 
 * @author rbf
 * @date 2019-04-22
 */
public interface ITDictService 
{
	/**
     * 查询字典信息
     * 
     * @param id 字典ID
     * @return 字典信息
     */
	public TDict selectTDictById(String id);
	
	/**
     * 查询字典列表
     * 
     * @param tDict 字典信息
     * @return 字典集合
     */
	public AjaxResult selectTDictListCar(TDict tDict);
	
	
	public List<TDict> selectTDictList(TDict tDict);
	
	/**
     * 新增字典
     * 
     * @param tDict 字典信息
     * @return 结果
     */
	public int insertTDict(TDict tDict);

	/**
     * 新增字典
     * 
     * @param tDict 字典信息
     * @return 结果
     */
	public AjaxResult insertTDictNew(TDict tDict);
	
	/**
     * 修改字典
     * 
     * @param tDict 字典信息
     * @return 结果
     */
	public int updateTDict(TDict tDict);
		
	/**
     * 删除字典信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDictByIds(String ids);
	
}
