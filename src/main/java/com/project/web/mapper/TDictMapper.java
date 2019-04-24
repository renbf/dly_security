package com.project.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.web.domian.TDict;


/**
 * 字典 数据层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface TDictMapper 
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
	public List<TDict> selectTDictList(TDict tDict);
	
	/**
     * 新增字典
     * 
     * @param tDict 字典信息
     * @return 结果
     */
	public int insertTDict(TDict tDict);
	
	/**
     * 修改字典
     * 
     * @param tDict 字典信息
     * @return 结果
     */
	public int updateTDict(TDict tDict);
	
	/**
     * 删除字典
     * 
     * @param id 字典ID
     * @return 结果
     */
	public int deleteTDictById(String id);
	
	/**
     * 批量删除字典
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDictByIds(String[] ids);
	
	/**
     * 批量将参数更新为不可用
     * 
     * @param ids 
     * @return 结果
     */
	public int updateNotStausTDictByids(TDict tDict);
	/**
     * 批量将参数更新为可用
     * 
     * @param ids 
     * @return 结果
     */
	public int updateYesStausTDictByids(TDict tDict);
	

}