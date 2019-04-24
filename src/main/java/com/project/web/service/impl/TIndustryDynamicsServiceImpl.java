package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TIndustryDynamics;
import com.project.web.mapper.TIndustryDynamicsMapper;
import com.project.web.service.ITIndustryDynamicsService;

/**
 * 行业动态 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TIndustryDynamicsServiceImpl implements ITIndustryDynamicsService 
{
	@Autowired
	private TIndustryDynamicsMapper tIndustryDynamicsMapper;

	/**
     * 查询行业动态信息
     * 
     * @param id 行业动态ID
     * @return 行业动态信息
     */
    @Override
	public TIndustryDynamics selectTIndustryDynamicsById(String id)
	{
	    return tIndustryDynamicsMapper.selectTIndustryDynamicsById(id);
	}
	
	/**
     * 查询行业动态列表
     * 
     * @param tIndustryDynamics 行业动态信息
     * @return 行业动态集合
     */
	@Override
	public List<TIndustryDynamics> selectTIndustryDynamicsList(TIndustryDynamics tIndustryDynamics)
	{
	    return tIndustryDynamicsMapper.selectTIndustryDynamicsList(tIndustryDynamics);
	}
	
    /**
     * 新增行业动态
     * 
     * @param tIndustryDynamics 行业动态信息
     * @return 结果
     */
	@Override
	public int insertTIndustryDynamics(TIndustryDynamics tIndustryDynamics)
	{
		tIndustryDynamics.setId(UUIDUtil.getUUID());
		tIndustryDynamics.setCreateTime(new Date());
		return tIndustryDynamicsMapper.insertTIndustryDynamics(tIndustryDynamics);
	}
	
	/**
     * 修改行业动态
     * 
     * @param tIndustryDynamics 行业动态信息
     * @return 结果
     */
	@Override
	public int updateTIndustryDynamics(TIndustryDynamics tIndustryDynamics)
	{
	    return tIndustryDynamicsMapper.updateTIndustryDynamics(tIndustryDynamics);
	}

	/**
     * 删除行业动态对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTIndustryDynamicsByIds(String ids)
	{
		return tIndustryDynamicsMapper.deleteTIndustryDynamicsByIds(Convert.toStrArray(ids));
	}
	
}
