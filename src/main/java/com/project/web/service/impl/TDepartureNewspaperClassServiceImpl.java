package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TDepartureNewspaperClass;
import com.project.web.mapper.TDepartureNewspaperClassMapper;
import com.project.web.service.ITDepartureNewspaperClassService;

/**
 * 车辆报班 服务层实现
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TDepartureNewspaperClassServiceImpl implements ITDepartureNewspaperClassService 
{
	@Autowired
	private TDepartureNewspaperClassMapper tDepartureNewspaperClassMapper;

	/**
     * 查询车辆报班信息
     * 
     * @param id 车辆报班ID
     * @return 车辆报班信息
     */
    @Override
	public TDepartureNewspaperClass selectTDepartureNewspaperClassById(Long id)
	{
	    return tDepartureNewspaperClassMapper.selectTDepartureNewspaperClassById(id);
	}
	
	/**
     * 查询车辆报班列表
     * 
     * @param tDepartureNewspaperClass 车辆报班信息
     * @return 车辆报班集合
     */
	@Override
	public List<TDepartureNewspaperClass> selectTDepartureNewspaperClassList(TDepartureNewspaperClass tDepartureNewspaperClass)
	{
	    return tDepartureNewspaperClassMapper.selectTDepartureNewspaperClassList(tDepartureNewspaperClass);
	}
	
    /**
     * 新增车辆报班
     * 
     * @param tDepartureNewspaperClass 车辆报班信息
     * @return 结果
     */
	@Override
	public int insertTDepartureNewspaperClass(TDepartureNewspaperClass tDepartureNewspaperClass)
	{
		tDepartureNewspaperClass.setId(UUIDUtil.getUUID());
		tDepartureNewspaperClass.setCreateTime(new Date());
		tDepartureNewspaperClass.setUserId(ShiroUtils.getUserId());
		return tDepartureNewspaperClassMapper.insertTDepartureNewspaperClass(tDepartureNewspaperClass);
	}
	
	/**
     * 修改车辆报班
     * 
     * @param tDepartureNewspaperClass 车辆报班信息
     * @return 结果
     */
	@Override
	public int updateTDepartureNewspaperClass(TDepartureNewspaperClass tDepartureNewspaperClass)
	{
	    return tDepartureNewspaperClassMapper.updateTDepartureNewspaperClass(tDepartureNewspaperClass);
	}

	/**
     * 删除车辆报班对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTDepartureNewspaperClassByIds(String ids)
	{
		return tDepartureNewspaperClassMapper.deleteTDepartureNewspaperClassByIds(Convert.toStrArray(ids));
	}
	
}
