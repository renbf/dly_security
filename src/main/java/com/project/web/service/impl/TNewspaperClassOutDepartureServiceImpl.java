package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TNewspaperClassOutDeparture;
import com.project.web.mapper.TNewspaperClassOutDepartureMapper;
import com.project.web.service.ITNewspaperClassOutDepartureService;

/**
 * 报班未出站车辆 服务层实现
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TNewspaperClassOutDepartureServiceImpl implements ITNewspaperClassOutDepartureService 
{
	@Autowired
	private TNewspaperClassOutDepartureMapper tNewspaperClassOutDepartureMapper;

	/**
     * 查询报班未出站车辆信息
     * 
     * @param id 报班未出站车辆ID
     * @return 报班未出站车辆信息
     */
    @Override
	public TNewspaperClassOutDeparture selectTNewspaperClassOutDepartureById(Long id)
	{
	    return tNewspaperClassOutDepartureMapper.selectTNewspaperClassOutDepartureById(id);
	}
	
	/**
     * 查询报班未出站车辆列表
     * 
     * @param tNewspaperClassOutDeparture 报班未出站车辆信息
     * @return 报班未出站车辆集合
     */
	@Override
	public List<TNewspaperClassOutDeparture> selectTNewspaperClassOutDepartureList(TNewspaperClassOutDeparture tNewspaperClassOutDeparture)
	{
	    return tNewspaperClassOutDepartureMapper.selectTNewspaperClassOutDepartureList(tNewspaperClassOutDeparture);
	}
	
    /**
     * 新增报班未出站车辆
     * 
     * @param tNewspaperClassOutDeparture 报班未出站车辆信息
     * @return 结果
     */
	@Override
	public int insertTNewspaperClassOutDeparture(TNewspaperClassOutDeparture tNewspaperClassOutDeparture)
	{
		tNewspaperClassOutDeparture.setId(UUIDUtil.getUUID());
		tNewspaperClassOutDeparture.setCreateTime(new Date());
		return tNewspaperClassOutDepartureMapper.insertTNewspaperClassOutDeparture(tNewspaperClassOutDeparture);
	}
	
	/**
     * 修改报班未出站车辆
     * 
     * @param tNewspaperClassOutDeparture 报班未出站车辆信息
     * @return 结果
     */
	@Override
	public int updateTNewspaperClassOutDeparture(TNewspaperClassOutDeparture tNewspaperClassOutDeparture)
	{
	    return tNewspaperClassOutDepartureMapper.updateTNewspaperClassOutDeparture(tNewspaperClassOutDeparture);
	}

	/**
     * 删除报班未出站车辆对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTNewspaperClassOutDepartureByIds(String ids)
	{
		return tNewspaperClassOutDepartureMapper.deleteTNewspaperClassOutDepartureByIds(Convert.toStrArray(ids));
	}
	
}
