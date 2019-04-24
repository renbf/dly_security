package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.THiddenTroubleInvestigation;
import com.project.web.mapper.THiddenTroubleInvestigationMapper;
import com.project.web.service.ITHiddenTroubleInvestigationService;

/**
 * 隐患排查 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class THiddenTroubleInvestigationServiceImpl implements ITHiddenTroubleInvestigationService 
{
	@Autowired
	private THiddenTroubleInvestigationMapper tHiddenTroubleInvestigationMapper;

	/**
     * 查询隐患排查信息
     * 
     * @param id 隐患排查ID
     * @return 隐患排查信息
     */
    @Override
	public THiddenTroubleInvestigation selectTHiddenTroubleInvestigationById(String id)
	{
	    return tHiddenTroubleInvestigationMapper.selectTHiddenTroubleInvestigationById(id);
	}
	
	/**
     * 查询隐患排查列表
     * 
     * @param tHiddenTroubleInvestigation 隐患排查信息
     * @return 隐患排查集合
     */
	@Override
	public List<THiddenTroubleInvestigation> selectTHiddenTroubleInvestigationList(THiddenTroubleInvestigation tHiddenTroubleInvestigation)
	{
	    return tHiddenTroubleInvestigationMapper.selectTHiddenTroubleInvestigationList(tHiddenTroubleInvestigation);
	}
	
    /**
     * 新增隐患排查
     * 
     * @param tHiddenTroubleInvestigation 隐患排查信息
     * @return 结果
     */
	@Override
	public int insertTHiddenTroubleInvestigation(THiddenTroubleInvestigation tHiddenTroubleInvestigation)
	{
		tHiddenTroubleInvestigation.setId(UUIDUtil.getUUID());
		tHiddenTroubleInvestigation.setCreateTime(new Date());
		return tHiddenTroubleInvestigationMapper.insertTHiddenTroubleInvestigation(tHiddenTroubleInvestigation);
	}
	
	/**
     * 修改隐患排查
     * 
     * @param tHiddenTroubleInvestigation 隐患排查信息
     * @return 结果
     */
	@Override
	public int updateTHiddenTroubleInvestigation(THiddenTroubleInvestigation tHiddenTroubleInvestigation)
	{
	    return tHiddenTroubleInvestigationMapper.updateTHiddenTroubleInvestigation(tHiddenTroubleInvestigation);
	}

	/**
     * 删除隐患排查对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTHiddenTroubleInvestigationByIds(String ids)
	{
		return tHiddenTroubleInvestigationMapper.deleteTHiddenTroubleInvestigationByIds(Convert.toStrArray(ids));
	}
	
}
