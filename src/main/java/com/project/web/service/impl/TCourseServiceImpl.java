package com.project.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Date;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.project.web.mapper.TCourseMapper;
import com.project.web.domian.TCourse;
import com.project.web.service.ITCourseService;
import com.project.common.support.Convert;

/**
 * 课程 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCourseServiceImpl implements ITCourseService 
{
	private static final Logger log = LoggerFactory.getLogger(TCourseServiceImpl.class);
	@Autowired
	@Qualifier("tCourseMapper")
	private TCourseMapper tCourseMapper;

	/**
     * 查询课程信息
     * 
     * @param id 课程ID
     * @return 课程信息
     */
    @Override
	public TCourse selectTCourseById(String id)
	{
	    return tCourseMapper.selectTCourseById(id);
	}
	
	/**
     * 查询课程列表
     * 
     * @param tCourse 课程信息
     * @return 课程集合
     */
	@Override
	public List<TCourse> selectTCourseList(TCourse tCourse)
	{
	    return tCourseMapper.selectTCourseList(tCourse);
	}
	
    /**
     * 新增课程
     * 
     * @param tCourse 课程信息
     * @return 结果
     */
	@Override
	public int insertTCourse(TCourse tCourse)
	{
		tCourse.setId(UUIDUtil.getUUID());
		tCourse.setCreateDate(new Date());
		tCourse.setAddUserId(ShiroUtils.getUserId().toString());
	    return tCourseMapper.insertTCourse(tCourse);
	}
	
	/**
     * 修改课程
     * 
     * @param tCourse 课程信息
     * @return 结果
     */
	@Override
	public int updateTCourse(TCourse tCourse)
	{
	    return tCourseMapper.updateTCourse(tCourse);
	}

	/**
     * 删除课程对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCourseByIds(String ids)
	{
		return tCourseMapper.deleteTCourseByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
