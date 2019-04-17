package com.project.security.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.security.domain.TCourse;
import com.project.security.domain.vo.TCourseVo;	

/**
 * 课程 数据层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface TCourseMapper 
{
	/**
     * 查询课程信息
     * 
     * @param id 课程ID
     * @return 课程信息
     */
	public TCourse selectTCourseById(String id);
	
	/**
     * 查询课程列表
     * 
     * @param tCourse 课程信息
     * @return 课程集合
     */
	public List<TCourse> selectTCourseList(TCourse tCourse);
	
	/**
     * 新增课程
     * 
     * @param tCourse 课程信息
     * @return 结果
     */
	public int insertTCourse(TCourse tCourse);
	
	/**
     * 修改课程
     * 
     * @param tCourse 课程信息
     * @return 结果
     */
	public int updateTCourse(TCourse tCourse);
	
	/**
     * 删除课程
     * 
     * @param id 课程ID
     * @return 结果
     */
	public int deleteTCourseById(String id);
	
	/**
     * 批量删除课程
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCourseByIds(String[] ids);
	//以上自动生成的尽量别动
	/**
	 * 小知识
	 * @param userId
	 * @param courseType
	 * @return
	 */
	public List<TCourseVo> littleKnowledge(@Param("userId") String userId,@Param("courseType") String courseType);
	/**
	 * 课程安排
	 * @param userId
	 * @return
	 */
	public List<TCourseVo> courseArrange(@Param("userId") String userId);
	
}