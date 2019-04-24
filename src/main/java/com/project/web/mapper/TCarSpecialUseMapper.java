package com.project.web.mapper;

import com.project.web.domian.TCarSpecialUse;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 压力容器和罐式专用车辆的罐体检测报告 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tCarSpecialUseMapper")
public interface TCarSpecialUseMapper 
{
	/**
     * 查询压力容器和罐式专用车辆的罐体检测报告信息
     * 
     * @param id 压力容器和罐式专用车辆的罐体检测报告ID
     * @return 压力容器和罐式专用车辆的罐体检测报告信息
     */
	public TCarSpecialUse selectTCarSpecialUseById(String id);
	
	/**
     * 查询压力容器和罐式专用车辆的罐体检测报告列表
     * 
     * @param tCarSpecialUse 压力容器和罐式专用车辆的罐体检测报告信息
     * @return 压力容器和罐式专用车辆的罐体检测报告集合
     */
	public List<TCarSpecialUse> selectTCarSpecialUseList(TCarSpecialUse tCarSpecialUse);
	
	/**
     * 新增压力容器和罐式专用车辆的罐体检测报告
     * 
     * @param tCarSpecialUse 压力容器和罐式专用车辆的罐体检测报告信息
     * @return 结果
     */
	public int insertTCarSpecialUse(TCarSpecialUse tCarSpecialUse);
	
	/**
     * 修改压力容器和罐式专用车辆的罐体检测报告
     * 
     * @param tCarSpecialUse 压力容器和罐式专用车辆的罐体检测报告信息
     * @return 结果
     */
	public int updateTCarSpecialUse(TCarSpecialUse tCarSpecialUse);
	
	/**
     * 删除压力容器和罐式专用车辆的罐体检测报告
     * 
     * @param id 压力容器和罐式专用车辆的罐体检测报告ID
     * @return 结果
     */
	public int deleteTCarSpecialUseById(String id);
	
	/**
     * 批量删除压力容器和罐式专用车辆的罐体检测报告
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCarSpecialUseByIds(String[] ids);
	//以上自动生成的尽量别动
}