package com.project.web.service;

import java.util.List;

import com.project.web.domian.TDepartureNewspaperClass;

/**
 * 车辆报班 服务层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface ITDepartureNewspaperClassService 
{
	/**
     * 查询车辆报班信息
     * 
     * @param id 车辆报班ID
     * @return 车辆报班信息
     */
	public TDepartureNewspaperClass selectTDepartureNewspaperClassById(Long id);
	
	/**
     * 查询车辆报班列表
     * 
     * @param tDepartureNewspaperClass 车辆报班信息
     * @return 车辆报班集合
     */
	public List<TDepartureNewspaperClass> selectTDepartureNewspaperClassList(TDepartureNewspaperClass tDepartureNewspaperClass);
	
	/**
     * 新增车辆报班
     * 
     * @param tDepartureNewspaperClass 车辆报班信息
     * @return 结果
     */
	public int insertTDepartureNewspaperClass(TDepartureNewspaperClass tDepartureNewspaperClass);
	
	/**
     * 修改车辆报班
     * 
     * @param tDepartureNewspaperClass 车辆报班信息
     * @return 结果
     */
	public int updateTDepartureNewspaperClass(TDepartureNewspaperClass tDepartureNewspaperClass);
		
	/**
     * 删除车辆报班信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDepartureNewspaperClassByIds(String ids);
	
}
