package com.project.web.mapper;

import com.project.web.domian.TCarSatellitePosition;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 卫星定位 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tCarSatellitePositionMapper")
public interface TCarSatellitePositionMapper 
{
	/**
     * 查询卫星定位信息
     * 
     * @param id 卫星定位ID
     * @return 卫星定位信息
     */
	public TCarSatellitePosition selectTCarSatellitePositionById(String id);
	
	/**
     * 查询卫星定位列表
     * 
     * @param tCarSatellitePosition 卫星定位信息
     * @return 卫星定位集合
     */
	public List<TCarSatellitePosition> selectTCarSatellitePositionList(TCarSatellitePosition tCarSatellitePosition);
	
	/**
     * 新增卫星定位
     * 
     * @param tCarSatellitePosition 卫星定位信息
     * @return 结果
     */
	public int insertTCarSatellitePosition(TCarSatellitePosition tCarSatellitePosition);
	
	/**
     * 修改卫星定位
     * 
     * @param tCarSatellitePosition 卫星定位信息
     * @return 结果
     */
	public int updateTCarSatellitePosition(TCarSatellitePosition tCarSatellitePosition);
	
	/**
     * 删除卫星定位
     * 
     * @param id 卫星定位ID
     * @return 结果
     */
	public int deleteTCarSatellitePositionById(String id);
	
	/**
     * 批量删除卫星定位
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCarSatellitePositionByIds(String[] ids);
	//以上自动生成的尽量别动
}