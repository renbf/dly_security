package com.project.web.mapper;

import com.project.web.domian.TCarKm;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 车辆行驶里程登记 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tCarKmMapper")
public interface TCarKmMapper 
{
	/**
     * 查询车辆行驶里程登记信息
     * 
     * @param id 车辆行驶里程登记ID
     * @return 车辆行驶里程登记信息
     */
	public TCarKm selectTCarKmById(String id);
	
	/**
     * 查询车辆行驶里程登记列表
     * 
     * @param tCarKm 车辆行驶里程登记信息
     * @return 车辆行驶里程登记集合
     */
	public List<TCarKm> selectTCarKmList(TCarKm tCarKm);
	
	/**
     * 新增车辆行驶里程登记
     * 
     * @param tCarKm 车辆行驶里程登记信息
     * @return 结果
     */
	public int insertTCarKm(TCarKm tCarKm);
	
	/**
     * 修改车辆行驶里程登记
     * 
     * @param tCarKm 车辆行驶里程登记信息
     * @return 结果
     */
	public int updateTCarKm(TCarKm tCarKm);
	
	/**
     * 删除车辆行驶里程登记
     * 
     * @param id 车辆行驶里程登记ID
     * @return 结果
     */
	public int deleteTCarKmById(String id);
	
	/**
     * 批量删除车辆行驶里程登记
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCarKmByIds(String[] ids);
	//以上自动生成的尽量别动
	/**
	 * 批量删除  根据车辆信息id
	 * @param ids
	 * @return
	 */
	public int deleteByCarInfoId(String[] ids);
}