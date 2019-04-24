package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TRiskLevelControl;
import com.project.web.mapper.TRiskLevelControlMapper;
import com.project.web.service.ITRiskLevelControlService;

/**
 * 风险分级管控 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TRiskLevelControlServiceImpl implements ITRiskLevelControlService 
{
	@Autowired
	private TRiskLevelControlMapper tRiskLevelControlMapper;

	/**
     * 查询风险分级管控信息
     * 
     * @param id 风险分级管控ID
     * @return 风险分级管控信息
     */
    @Override
	public TRiskLevelControl selectTRiskLevelControlById(String id)
	{
	    return tRiskLevelControlMapper.selectTRiskLevelControlById(id);
	}
	
	/**
     * 查询风险分级管控列表
     * 
     * @param tRiskLevelControl 风险分级管控信息
     * @return 风险分级管控集合
     */
	@Override
	public List<TRiskLevelControl> selectTRiskLevelControlList(TRiskLevelControl tRiskLevelControl)
	{
	    return tRiskLevelControlMapper.selectTRiskLevelControlList(tRiskLevelControl);
	}
	
    /**
     * 新增风险分级管控
     * 
     * @param tRiskLevelControl 风险分级管控信息
     * @return 结果
     */
	@Override
	public int insertTRiskLevelControl(TRiskLevelControl tRiskLevelControl)
	{
		tRiskLevelControl.setId(UUIDUtil.getUUID());
		tRiskLevelControl.setCreateTime(new Date());
		return tRiskLevelControlMapper.insertTRiskLevelControl(tRiskLevelControl);
	}
	
	/**
     * 修改风险分级管控
     * 
     * @param tRiskLevelControl 风险分级管控信息
     * @return 结果
     */
	@Override
	public int updateTRiskLevelControl(TRiskLevelControl tRiskLevelControl)
	{
	    return tRiskLevelControlMapper.updateTRiskLevelControl(tRiskLevelControl);
	}

	/**
     * 删除风险分级管控对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTRiskLevelControlByIds(String ids)
	{
		return tRiskLevelControlMapper.deleteTRiskLevelControlByIds(Convert.toStrArray(ids));
	}
	
}
