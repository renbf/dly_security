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
import com.project.web.mapper.TUserCourseMapper;
import com.project.web.domian.TUserCourse;
import com.project.web.service.ITUserCourseService;
import com.project.common.support.Convert;

/**
 * 课程安排 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TUserCourseServiceImpl implements ITUserCourseService 
{
	private static final Logger log = LoggerFactory.getLogger(TUserCourseServiceImpl.class);
	@Autowired
	@Qualifier("tUserCourseMapper")
	private TUserCourseMapper tUserCourseMapper;

	/**
     * 查询课程安排信息
     * 
     * @param id 课程安排ID
     * @return 课程安排信息
     */
    @Override
	public TUserCourse selectTUserCourseById(String id)
	{
	    return tUserCourseMapper.selectTUserCourseById(id);
	}
	
	/**
     * 查询课程安排列表
     * 
     * @param tUserCourse 课程安排信息
     * @return 课程安排集合
     */
	@Override
	public List<TUserCourse> selectTUserCourseList(TUserCourse tUserCourse)
	{
	    return tUserCourseMapper.selectTUserCourseList(tUserCourse);
	}
	
    /**
     * 新增课程安排
     * 
     * @param tUserCourse 课程安排信息
     * @return 结果
     */
	@Override
	public int insertTUserCourse(TUserCourse tUserCourse)
	{
		tUserCourse.setId(UUIDUtil.getUUID());
		tUserCourse.setAddUserId(ShiroUtils.getUserId().toString());
	    return tUserCourseMapper.insertTUserCourse(tUserCourse);
	}
	
	/**
     * 修改课程安排
     * 
     * @param tUserCourse 课程安排信息
     * @return 结果
     */
	@Override
	public int updateTUserCourse(TUserCourse tUserCourse)
	{
	    return tUserCourseMapper.updateTUserCourse(tUserCourse);
	}

	/**
     * 删除课程安排对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTUserCourseByIds(String ids)
	{
		return tUserCourseMapper.deleteTUserCourseByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
