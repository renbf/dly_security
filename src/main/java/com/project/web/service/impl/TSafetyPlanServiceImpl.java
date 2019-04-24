package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TSafetyPlan;
import com.project.web.mapper.TSafetyPlanMapper;
import com.project.web.service.ITSafetyPlanService;

/**
 * 安全计划 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TSafetyPlanServiceImpl implements ITSafetyPlanService 
{
	@Autowired
	private TSafetyPlanMapper tSafetyPlanMapper;

	/**
     * 查询安全计划信息
     * 
     * @param id 安全计划ID
     * @return 安全计划信息
     */
    @Override
	public TSafetyPlan selectTSafetyPlanById(String id)
	{
	    return tSafetyPlanMapper.selectTSafetyPlanById(id);
	}
	
	/**
     * 查询安全计划列表
     * 
     * @param tSafetyPlan 安全计划信息
     * @return 安全计划集合
     */
	@Override
	public List<TSafetyPlan> selectTSafetyPlanList(TSafetyPlan tSafetyPlan)
	{
	    return tSafetyPlanMapper.selectTSafetyPlanList(tSafetyPlan);
	}
	
    /**
     * 新增安全计划
     * 
     * @param tSafetyPlan 安全计划信息
     * @return 结果
     */
	@Override
	public int insertTSafetyPlan(TSafetyPlan tSafetyPlan)
	{
		tSafetyPlan.setId(UUIDUtil.getUUID());
		tSafetyPlan.setCreateTime(new Date());
		return tSafetyPlanMapper.insertTSafetyPlan(tSafetyPlan);
	}
	
	/**
     * 修改安全计划
     * 
     * @param tSafetyPlan 安全计划信息
     * @return 结果
     */
	@Override
	public int updateTSafetyPlan(TSafetyPlan tSafetyPlan)
	{
	    return tSafetyPlanMapper.updateTSafetyPlan(tSafetyPlan);
	}

	/**
     * 删除安全计划对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTSafetyPlanByIds(String ids)
	{
		return tSafetyPlanMapper.deleteTSafetyPlanByIds(Convert.toStrArray(ids));
	}
	
}
