package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TNewspaperClassOutDeparture;	

/**
 * 报班未出站车辆 数据层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface TNewspaperClassOutDepartureMapper
{
	/**
	 * 查询报班未出站车辆信息
	 *
	 * @param id 报班未出站车辆ID
	 * @return 报班未出站车辆信息
	 */
	public TNewspaperClassOutDeparture selectTNewspaperClassOutDepartureById(String id);

	/**
	 * 查询报班未出站车辆列表
	 *
	 * @param tNewspaperClassOutDeparture 报班未出站车辆信息
	 * @return 报班未出站车辆集合
	 */
	public List<TNewspaperClassOutDeparture> selectTNewspaperClassOutDepartureList(TNewspaperClassOutDeparture tNewspaperClassOutDeparture);

	/**
	 * 新增报班未出站车辆
	 *
	 * @param tNewspaperClassOutDeparture 报班未出站车辆信息
	 * @return 结果
	 */
	public int insertTNewspaperClassOutDeparture(TNewspaperClassOutDeparture tNewspaperClassOutDeparture);

	/**
	 * 修改报班未出站车辆
	 *
	 * @param tNewspaperClassOutDeparture 报班未出站车辆信息
	 * @return 结果
	 */
	public int updateTNewspaperClassOutDeparture(TNewspaperClassOutDeparture tNewspaperClassOutDeparture);

	/**
	 * 删除报班未出站车辆
	 *
	 * @param id 报班未出站车辆ID
	 * @return 结果
	 */
	public int deleteTNewspaperClassOutDepartureById(String id);

	/**
	 * 批量删除报班未出站车辆
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteTNewspaperClassOutDepartureByIds(String[] ids);

}