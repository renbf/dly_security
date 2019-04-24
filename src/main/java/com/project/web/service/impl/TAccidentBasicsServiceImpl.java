package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TAccidentBasics;
import com.project.web.mapper.TAccidentBasicsMapper;
import com.project.web.service.ITAccidentBasicsService;

/**
 * 事故基础 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TAccidentBasicsServiceImpl implements ITAccidentBasicsService 
{
	@Autowired
	private TAccidentBasicsMapper tAccidentBasicsMapper;

	/**
     * 查询事故基础信息
     * 
     * @param id 事故基础ID
     * @return 事故基础信息
     */
    @Override
	public TAccidentBasics selectTAccidentBasicsById(String id)
	{
	    return tAccidentBasicsMapper.selectTAccidentBasicsById(id);
	}
	
	/**
     * 查询事故基础列表
     * 
     * @param tAccidentBasics 事故基础信息
     * @return 事故基础集合
     */
	@Override
	public List<TAccidentBasics> selectTAccidentBasicsList(TAccidentBasics tAccidentBasics)
	{
	    return tAccidentBasicsMapper.selectTAccidentBasicsList(tAccidentBasics);
	}
	
    /**
     * 新增事故基础
     * 
     * @param tAccidentBasics 事故基础信息
     * @return 结果
     */
	@Override
	public int insertTAccidentBasics(TAccidentBasics tAccidentBasics)
	{
		tAccidentBasics.setId(UUIDUtil.getUUID());
		tAccidentBasics.setCreateTime(new Date());
		tAccidentBasics.setUserId(ShiroUtils.getUserId());
	    return tAccidentBasicsMapper.insertTAccidentBasics(tAccidentBasics);
	}
	
	/**
     * 修改事故基础
     * 
     * @param tAccidentBasics 事故基础信息
     * @return 结果
     */
	@Override
	public int updateTAccidentBasics(TAccidentBasics tAccidentBasics)
	{
		tAccidentBasics.setUpdateTime(new Date());
		tAccidentBasics.setUpdateUserId(ShiroUtils.getUserId());
	    return tAccidentBasicsMapper.updateTAccidentBasics(tAccidentBasics);
	}

	/**
     * 删除事故基础对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTAccidentBasicsByIds(String ids)
	{
		return tAccidentBasicsMapper.deleteTAccidentBasicsByIds(Convert.toStrArray(ids));
	}
	
}
