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
import com.project.web.mapper.TInspectPlanMapper;
import com.project.web.domian.TInspectPlan;
import com.project.web.service.ITInspectPlanService;
import com.project.common.support.Convert;

/**
 * 检查计划 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TInspectPlanServiceImpl implements ITInspectPlanService 
{
	private static final Logger log = LoggerFactory.getLogger(TInspectPlanServiceImpl.class);
	@Autowired
	@Qualifier("tInspectPlanMapper")
	private TInspectPlanMapper tInspectPlanMapper;

	/**
     * 查询检查计划信息
     * 
     * @param id 检查计划ID
     * @return 检查计划信息
     */
    @Override
	public TInspectPlan selectTInspectPlanById(String id)
	{
	    return tInspectPlanMapper.selectTInspectPlanById(id);
	}
	
	/**
     * 查询检查计划列表
     * 
     * @param tInspectPlan 检查计划信息
     * @return 检查计划集合
     */
	@Override
	public List<TInspectPlan> selectTInspectPlanList(TInspectPlan tInspectPlan)
	{
	    return tInspectPlanMapper.selectTInspectPlanList(tInspectPlan);
	}
	
    /**
     * 新增检查计划
     * 
     * @param tInspectPlan 检查计划信息
     * @return 结果
     */
	@Override
	public int insertTInspectPlan(TInspectPlan tInspectPlan)
	{
		tInspectPlan.setId(UUIDUtil.getUUID());
		tInspectPlan.setCreateDate(new Date());
		tInspectPlan.setAddUserId(ShiroUtils.getUserId().toString());
	    return tInspectPlanMapper.insertTInspectPlan(tInspectPlan);
	}
	
	/**
     * 修改检查计划
     * 
     * @param tInspectPlan 检查计划信息
     * @return 结果
     */
	@Override
	public int updateTInspectPlan(TInspectPlan tInspectPlan)
	{
	    return tInspectPlanMapper.updateTInspectPlan(tInspectPlan);
	}

	/**
     * 删除检查计划对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTInspectPlanByIds(String ids)
	{
		return tInspectPlanMapper.deleteTInspectPlanByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
