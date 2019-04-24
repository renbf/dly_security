package com.project.web.mapper;

import com.project.web.domian.TCoursePlan;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 课程计划 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tCoursePlanMapper")
public interface TCoursePlanMapper 
{
	/**
     * 查询课程计划信息
     * 
     * @param id 课程计划ID
     * @return 课程计划信息
     */
	public TCoursePlan selectTCoursePlanById(String id);
	
	/**
     * 查询课程计划列表
     * 
     * @param tCoursePlan 课程计划信息
     * @return 课程计划集合
     */
	public List<TCoursePlan> selectTCoursePlanList(TCoursePlan tCoursePlan);
	
	/**
     * 新增课程计划
     * 
     * @param tCoursePlan 课程计划信息
     * @return 结果
     */
	public int insertTCoursePlan(TCoursePlan tCoursePlan);
	
	/**
     * 修改课程计划
     * 
     * @param tCoursePlan 课程计划信息
     * @return 结果
     */
	public int updateTCoursePlan(TCoursePlan tCoursePlan);
	
	/**
     * 删除课程计划
     * 
     * @param id 课程计划ID
     * @return 结果
     */
	public int deleteTCoursePlanById(String id);
	
	/**
     * 批量删除课程计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCoursePlanByIds(String[] ids);
	//以上自动生成的尽量别动
}