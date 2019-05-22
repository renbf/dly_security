package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TCoursePlan;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * 课程计划 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITCoursePlanService 
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
	public AjaxResult insertTCoursePlan(TCoursePlan tCoursePlan,MultipartFile attachmentFile);
	
	/**
     * 修改课程计划
     * 
     * @param tCoursePlan 课程计划信息
     * @return 结果
     */
	public AjaxResult updateTCoursePlan(TCoursePlan tCoursePlan,MultipartFile attachmentFile);
		
	/**
     * 删除课程计划信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCoursePlanByIds(String ids);
	//以上自动生成的尽量别动
}
