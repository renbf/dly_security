package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TCheckPlan;
import com.project.web.mapper.TCheckPlanMapper;
import com.project.web.service.ITCheckPlanService;

/**
 * 检查计划 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TCheckPlanServiceImpl implements ITCheckPlanService 
{
	@Autowired
	private TCheckPlanMapper tCheckPlanMapper;

	/**
     * 查询检查计划信息
     * 
     * @param id 检查计划ID
     * @return 检查计划信息
     */
    @Override
	public TCheckPlan selectTCheckPlanById(String id)
	{
	    return tCheckPlanMapper.selectTCheckPlanById(id);
	}
	
	/**
     * 查询检查计划列表
     * 
     * @param tCheckPlan 检查计划信息
     * @return 检查计划集合
     */
	@Override
	public List<TCheckPlan> selectTCheckPlanList(TCheckPlan tCheckPlan)
	{
	    return tCheckPlanMapper.selectTCheckPlanList(tCheckPlan);
	}
	
    /**
     * 新增检查计划
     * 
     * @param tCheckPlan 检查计划信息
     * @return 结果
     */
	@Override
	public int insertTCheckPlan(TCheckPlan tCheckPlan)
	{
		tCheckPlan.setId(UUIDUtil.getUUID());
		tCheckPlan.setCreateTime(new Date());
		tCheckPlan.setUserId(ShiroUtils.getUserId());
		return tCheckPlanMapper.insertTCheckPlan(tCheckPlan);
	}
	
	/**
     * 修改检查计划
     * 
     * @param tCheckPlan 检查计划信息
     * @return 结果
     */
	@Override
	public int updateTCheckPlan(TCheckPlan tCheckPlan)
	{
	    return tCheckPlanMapper.updateTCheckPlan(tCheckPlan);
	}

	/**
     * 删除检查计划对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCheckPlanByIds(String ids)
	{
		return tCheckPlanMapper.deleteTCheckPlanByIds(Convert.toStrArray(ids));
	}
	
}
