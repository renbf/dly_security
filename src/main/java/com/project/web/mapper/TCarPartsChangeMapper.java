package com.project.web.mapper;

import com.project.web.domian.TCarPartsChange;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 车辆主要部件更换登记 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tCarPartsChangeMapper")
public interface TCarPartsChangeMapper 
{
	/**
     * 查询车辆主要部件更换登记信息
     * 
     * @param id 车辆主要部件更换登记ID
     * @return 车辆主要部件更换登记信息
     */
	public TCarPartsChange selectTCarPartsChangeById(String id);
	
	/**
     * 查询车辆主要部件更换登记列表
     * 
     * @param tCarPartsChange 车辆主要部件更换登记信息
     * @return 车辆主要部件更换登记集合
     */
	public List<TCarPartsChange> selectTCarPartsChangeList(TCarPartsChange tCarPartsChange);
	
	/**
     * 新增车辆主要部件更换登记
     * 
     * @param tCarPartsChange 车辆主要部件更换登记信息
     * @return 结果
     */
	public int insertTCarPartsChange(TCarPartsChange tCarPartsChange);
	
	/**
     * 修改车辆主要部件更换登记
     * 
     * @param tCarPartsChange 车辆主要部件更换登记信息
     * @return 结果
     */
	public int updateTCarPartsChange(TCarPartsChange tCarPartsChange);
	
	/**
     * 删除车辆主要部件更换登记
     * 
     * @param id 车辆主要部件更换登记ID
     * @return 结果
     */
	public int deleteTCarPartsChangeById(String id);
	
	/**
     * 批量删除车辆主要部件更换登记
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCarPartsChangeByIds(String[] ids);
	//以上自动生成的尽量别动
}