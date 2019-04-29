package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TOutNewspaperClassVehicle;



/**
 * 未报班车辆 数据层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface TOutNewspaperClassVehicleMapper
{
	/**
	 * 查询未报班车辆信息
	 *
	 * @param id 未报班车辆ID
	 * @return 未报班车辆信息
	 */
	public TOutNewspaperClassVehicle selectTOutNewspaperClassVehicleById(String id);

	/**
	 * 查询未报班车辆列表
	 *
	 * @param tOutNewspaperClassVehicle 未报班车辆信息
	 * @return 未报班车辆集合
	 */
	public List<TOutNewspaperClassVehicle> selectTOutNewspaperClassVehicleList(TOutNewspaperClassVehicle tOutNewspaperClassVehicle);

	/**
	 * 新增未报班车辆
	 *
	 * @param tOutNewspaperClassVehicle 未报班车辆信息
	 * @return 结果
	 */
	public int insertTOutNewspaperClassVehicle(TOutNewspaperClassVehicle tOutNewspaperClassVehicle);

	/**
	 * 修改未报班车辆
	 *
	 * @param tOutNewspaperClassVehicle 未报班车辆信息
	 * @return 结果
	 */
	public int updateTOutNewspaperClassVehicle(TOutNewspaperClassVehicle tOutNewspaperClassVehicle);

	/**
	 * 删除未报班车辆
	 *
	 * @param id 未报班车辆ID
	 * @return 结果
	 */
	public int deleteTOutNewspaperClassVehicleById(String id);

	/**
	 * 批量删除未报班车辆
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteTOutNewspaperClassVehicleByIds(String[] ids);

}