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
import com.project.web.mapper.TCoursePlanMapper;
import com.project.web.domian.TCoursePlan;
import com.project.web.service.ITCoursePlanService;
import com.project.common.support.Convert;

/**
 * 课程计划 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCoursePlanServiceImpl implements ITCoursePlanService 
{
	private static final Logger log = LoggerFactory.getLogger(TCoursePlanServiceImpl.class);
	@Autowired
	@Qualifier("tCoursePlanMapper")
	private TCoursePlanMapper tCoursePlanMapper;

	/**
     * 查询课程计划信息
     * 
     * @param id 课程计划ID
     * @return 课程计划信息
     */
    @Override
	public TCoursePlan selectTCoursePlanById(String id)
	{
	    return tCoursePlanMapper.selectTCoursePlanById(id);
	}
	
	/**
     * 查询课程计划列表
     * 
     * @param tCoursePlan 课程计划信息
     * @return 课程计划集合
     */
	@Override
	public List<TCoursePlan> selectTCoursePlanList(TCoursePlan tCoursePlan)
	{
	    return tCoursePlanMapper.selectTCoursePlanList(tCoursePlan);
	}
	
    /**
     * 新增课程计划
     * 
     * @param tCoursePlan 课程计划信息
     * @return 结果
     */
	@Override
	public int insertTCoursePlan(TCoursePlan tCoursePlan)
	{
		tCoursePlan.setId(UUIDUtil.getUUID());
		tCoursePlan.setCreateDate(new Date());
		tCoursePlan.setAddUserId(ShiroUtils.getUserId().toString());
	    return tCoursePlanMapper.insertTCoursePlan(tCoursePlan);
	}
	
	/**
     * 修改课程计划
     * 
     * @param tCoursePlan 课程计划信息
     * @return 结果
     */
	@Override
	public int updateTCoursePlan(TCoursePlan tCoursePlan)
	{
	    return tCoursePlanMapper.updateTCoursePlan(tCoursePlan);
	}

	/**
     * 删除课程计划对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCoursePlanByIds(String ids)
	{
		return tCoursePlanMapper.deleteTCoursePlanByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
