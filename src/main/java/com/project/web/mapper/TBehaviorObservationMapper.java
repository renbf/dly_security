package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TBehaviorObservation;	

/**
 * 行为观察 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface TBehaviorObservationMapper 
{
	/**
     * 查询行为观察信息
     * 
     * @param id 行为观察ID
     * @return 行为观察信息
     */
	public TBehaviorObservation selectTBehaviorObservationById(String id);
	
	/**
     * 查询行为观察列表
     * 
     * @param tBehaviorObservation 行为观察信息
     * @return 行为观察集合
     */
	public List<TBehaviorObservation> selectTBehaviorObservationList(TBehaviorObservation tBehaviorObservation);
	
	/**
     * 新增行为观察
     * 
     * @param tBehaviorObservation 行为观察信息
     * @return 结果
     */
	public int insertTBehaviorObservation(TBehaviorObservation tBehaviorObservation);
	
	/**
     * 修改行为观察
     * 
     * @param tBehaviorObservation 行为观察信息
     * @return 结果
     */
	public int updateTBehaviorObservation(TBehaviorObservation tBehaviorObservation);
	
	/**
     * 删除行为观察
     * 
     * @param id 行为观察ID
     * @return 结果
     */
	public int deleteTBehaviorObservationById(String id);
	
	/**
     * 批量删除行为观察
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTBehaviorObservationByIds(String[] ids);
	
}