package com.project.security.mapper;

import com.project.security.domain.TUserCourse;
import java.util.List;	

/**
 * 课程安排 数据层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface TUserCourseMapper 
{
	/**
     * 查询课程安排信息
     * 
     * @param id 课程安排ID
     * @return 课程安排信息
     */
	public TUserCourse selectTUserCourseById(String id);
	
	/**
     * 查询课程安排列表
     * 
     * @param tUserCourse 课程安排信息
     * @return 课程安排集合
     */
	public List<TUserCourse> selectTUserCourseList(TUserCourse tUserCourse);
	
	/**
     * 新增课程安排
     * 
     * @param tUserCourse 课程安排信息
     * @return 结果
     */
	public int insertTUserCourse(TUserCourse tUserCourse);
	
	/**
     * 修改课程安排
     * 
     * @param tUserCourse 课程安排信息
     * @return 结果
     */
	public int updateTUserCourse(TUserCourse tUserCourse);
	
	/**
     * 删除课程安排
     * 
     * @param id 课程安排ID
     * @return 结果
     */
	public int deleteTUserCourseById(String id);
	
	/**
     * 批量删除课程安排
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserCourseByIds(String[] ids);
	//以上自动生成的尽量别动
	
	/**
     * 修改课程安排
     * 
     * @param tUserCourse 课程安排信息
     * @return 结果
     */
	public int updateTUserCourseByUser(TUserCourse tUserCourse);
}