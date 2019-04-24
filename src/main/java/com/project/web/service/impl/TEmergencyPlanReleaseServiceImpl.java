package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TEmergencyPlanRelease;
import com.project.web.mapper.TEmergencyPlanReleaseMapper;
import com.project.web.service.ITEmergencyPlanReleaseService;

/**
 * 应急预案发布 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TEmergencyPlanReleaseServiceImpl implements ITEmergencyPlanReleaseService 
{
	@Autowired
	private TEmergencyPlanReleaseMapper tEmergencyPlanReleaseMapper;

	/**
     * 查询应急预案发布信息
     * 
     * @param id 应急预案发布ID
     * @return 应急预案发布信息
     */
    @Override
	public TEmergencyPlanRelease selectTEmergencyPlanReleaseById(String id)
	{
	    return tEmergencyPlanReleaseMapper.selectTEmergencyPlanReleaseById(id);
	}
	
	/**
     * 查询应急预案发布列表
     * 
     * @param tEmergencyPlanRelease 应急预案发布信息
     * @return 应急预案发布集合
     */
	@Override
	public List<TEmergencyPlanRelease> selectTEmergencyPlanReleaseList(TEmergencyPlanRelease tEmergencyPlanRelease)
	{
	    return tEmergencyPlanReleaseMapper.selectTEmergencyPlanReleaseList(tEmergencyPlanRelease);
	}
	
    /**
     * 新增应急预案发布
     * 
     * @param tEmergencyPlanRelease 应急预案发布信息
     * @return 结果
     */
	@Override
	public int insertTEmergencyPlanRelease(TEmergencyPlanRelease tEmergencyPlanRelease)
	{
		tEmergencyPlanRelease.setId(UUIDUtil.getUUID());
		tEmergencyPlanRelease.setCreateTime(new Date());
		return tEmergencyPlanReleaseMapper.insertTEmergencyPlanRelease(tEmergencyPlanRelease);
	}
	
	/**
     * 修改应急预案发布
     * 
     * @param tEmergencyPlanRelease 应急预案发布信息
     * @return 结果
     */
	@Override
	public int updateTEmergencyPlanRelease(TEmergencyPlanRelease tEmergencyPlanRelease)
	{
	    return tEmergencyPlanReleaseMapper.updateTEmergencyPlanRelease(tEmergencyPlanRelease);
	}

	/**
     * 删除应急预案发布对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTEmergencyPlanReleaseByIds(String ids)
	{
		return tEmergencyPlanReleaseMapper.deleteTEmergencyPlanReleaseByIds(Convert.toStrArray(ids));
	}
	
}
