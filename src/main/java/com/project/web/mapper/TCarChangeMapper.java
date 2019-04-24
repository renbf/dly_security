package com.project.web.mapper;

import com.project.web.domian.TCarChange;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 车辆变更登记 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tCarChangeMapper")
public interface TCarChangeMapper 
{
	/**
     * 查询车辆变更登记信息
     * 
     * @param id 车辆变更登记ID
     * @return 车辆变更登记信息
     */
	public TCarChange selectTCarChangeById(String id);
	
	/**
     * 查询车辆变更登记列表
     * 
     * @param tCarChange 车辆变更登记信息
     * @return 车辆变更登记集合
     */
	public List<TCarChange> selectTCarChangeList(TCarChange tCarChange);
	
	/**
     * 新增车辆变更登记
     * 
     * @param tCarChange 车辆变更登记信息
     * @return 结果
     */
	public int insertTCarChange(TCarChange tCarChange);
	
	/**
     * 修改车辆变更登记
     * 
     * @param tCarChange 车辆变更登记信息
     * @return 结果
     */
	public int updateTCarChange(TCarChange tCarChange);
	
	/**
     * 删除车辆变更登记
     * 
     * @param id 车辆变更登记ID
     * @return 结果
     */
	public int deleteTCarChangeById(String id);
	
	/**
     * 批量删除车辆变更登记
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCarChangeByIds(String[] ids);
	//以上自动生成的尽量别动
}