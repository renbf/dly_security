package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TCourse;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * 课程 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITCourseService 
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
	public AjaxResult insertTCourse(TCourse tCourse,MultipartFile courseImg,MultipartFile videoFile,MultipartFile courseFile);
	
	/**
     * 修改课程
     * 
     * @param tCourse 课程信息
     * @return 结果
     */
	public AjaxResult updateTCourse(TCourse tCourse,MultipartFile courseImg,MultipartFile videoFile,MultipartFile courseFile);
		
	/**
     * 删除课程信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCourseByIds(String ids);
	//以上自动生成的尽量别动
}
