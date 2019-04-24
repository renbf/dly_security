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
import com.project.web.mapper.TInspectTeamProjectMapper;
import com.project.web.domian.TInspectTeamProject;
import com.project.web.service.ITInspectTeamProjectService;
import com.project.common.support.Convert;

/**
 * 检查计划和检查项关系 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TInspectTeamProjectServiceImpl implements ITInspectTeamProjectService 
{
	private static final Logger log = LoggerFactory.getLogger(TInspectTeamProjectServiceImpl.class);
	@Autowired
	@Qualifier("tInspectTeamProjectMapper")
	private TInspectTeamProjectMapper tInspectTeamProjectMapper;

	/**
     * 查询检查计划和检查项关系信息
     * 
     * @param inspectPlanId 检查计划和检查项关系ID
     * @return 检查计划和检查项关系信息
     */
    @Override
	public TInspectTeamProject selectTInspectTeamProjectById(String inspectPlanId)
	{
	    return tInspectTeamProjectMapper.selectTInspectTeamProjectById(inspectPlanId);
	}
	
	/**
     * 查询检查计划和检查项关系列表
     * 
     * @param tInspectTeamProject 检查计划和检查项关系信息
     * @return 检查计划和检查项关系集合
     */
	@Override
	public List<TInspectTeamProject> selectTInspectTeamProjectList(TInspectTeamProject tInspectTeamProject)
	{
	    return tInspectTeamProjectMapper.selectTInspectTeamProjectList(tInspectTeamProject);
	}
	
    /**
     * 新增检查计划和检查项关系
     * 
     * @param tInspectTeamProject 检查计划和检查项关系信息
     * @return 结果
     */
	@Override
	public int insertTInspectTeamProject(TInspectTeamProject tInspectTeamProject)
	{
	    return tInspectTeamProjectMapper.insertTInspectTeamProject(tInspectTeamProject);
	}
	
	/**
     * 修改检查计划和检查项关系
     * 
     * @param tInspectTeamProject 检查计划和检查项关系信息
     * @return 结果
     */
	@Override
	public int updateTInspectTeamProject(TInspectTeamProject tInspectTeamProject)
	{
	    return tInspectTeamProjectMapper.updateTInspectTeamProject(tInspectTeamProject);
	}

	/**
     * 删除检查计划和检查项关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTInspectTeamProjectByIds(String ids)
	{
		return tInspectTeamProjectMapper.deleteTInspectTeamProjectByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
