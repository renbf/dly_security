package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TBehaviorObservation;
import com.project.web.mapper.TBehaviorObservationMapper;
import com.project.web.service.ITBehaviorObservationService;

/**
 * 行为观察 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TBehaviorObservationServiceImpl implements ITBehaviorObservationService 
{
	@Autowired
	private TBehaviorObservationMapper tBehaviorObservationMapper;

	/**
     * 查询行为观察信息
     * 
     * @param id 行为观察ID
     * @return 行为观察信息
     */
    @Override
	public TBehaviorObservation selectTBehaviorObservationById(String id)
	{
	    return tBehaviorObservationMapper.selectTBehaviorObservationById(id);
	}
	
	/**
     * 查询行为观察列表
     * 
     * @param tBehaviorObservation 行为观察信息
     * @return 行为观察集合
     */
	@Override
	public List<TBehaviorObservation> selectTBehaviorObservationList(TBehaviorObservation tBehaviorObservation)
	{
	    return tBehaviorObservationMapper.selectTBehaviorObservationList(tBehaviorObservation);
	}
	
    /**
     * 新增行为观察
     * 
     * @param tBehaviorObservation 行为观察信息
     * @return 结果
     */
	@Override
	public int insertTBehaviorObservation(TBehaviorObservation tBehaviorObservation)
	{
		tBehaviorObservation.setId(UUIDUtil.getUUID());
		tBehaviorObservation.setCreateTime(new Date());
		tBehaviorObservation.setUserId(ShiroUtils.getUserId());
		return tBehaviorObservationMapper.insertTBehaviorObservation(tBehaviorObservation);
	}
	
	/**
     * 修改行为观察
     * 
     * @param tBehaviorObservation 行为观察信息
     * @return 结果
     */
	@Override
	public int updateTBehaviorObservation(TBehaviorObservation tBehaviorObservation)
	{
	    return tBehaviorObservationMapper.updateTBehaviorObservation(tBehaviorObservation);
	}

	/**
     * 删除行为观察对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTBehaviorObservationByIds(String ids)
	{
		return tBehaviorObservationMapper.deleteTBehaviorObservationByIds(Convert.toStrArray(ids));
	}
	
}
