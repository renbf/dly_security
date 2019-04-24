package com.project.web.mapper;

import com.project.web.domian.TCarInfo;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 车辆 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tCarInfoMapper")
public interface TCarInfoMapper 
{
	/**
     * 查询车辆信息
     * 
     * @param id 车辆ID
     * @return 车辆信息
     */
	public TCarInfo selectTCarInfoById(String id);
	
	/**
     * 查询车辆列表
     * 
     * @param tCarInfo 车辆信息
     * @return 车辆集合
     */
	public List<TCarInfo> selectTCarInfoList(TCarInfo tCarInfo);
	
	/**
     * 新增车辆
     * 
     * @param tCarInfo 车辆信息
     * @return 结果
     */
	public int insertTCarInfo(TCarInfo tCarInfo);
	
	/**
     * 修改车辆
     * 
     * @param tCarInfo 车辆信息
     * @return 结果
     */
	public int updateTCarInfo(TCarInfo tCarInfo);
	
	/**
     * 删除车辆
     * 
     * @param id 车辆ID
     * @return 结果
     */
	public int deleteTCarInfoById(String id);
	
	/**
     * 批量删除车辆
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCarInfoByIds(String[] ids);
	//以上自动生成的尽量别动
}