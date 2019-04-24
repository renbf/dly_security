package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TVehicleCheck;
import com.project.web.mapper.TVehicleCheckMapper;
import com.project.web.service.ITVehicleCheckService;

/**
 * 车辆例检 服务层实现
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TVehicleCheckServiceImpl implements ITVehicleCheckService 
{
	@Autowired
	private TVehicleCheckMapper tVehicleCheckMapper;

	/**
     * 查询车辆例检信息
     * 
     * @param id 车辆例检ID
     * @return 车辆例检信息
     */
    @Override
	public TVehicleCheck selectTVehicleCheckById(Long id)
	{
	    return tVehicleCheckMapper.selectTVehicleCheckById(id);
	}
	
	/**
     * 查询车辆例检列表
     * 
     * @param tVehicleCheck 车辆例检信息
     * @return 车辆例检集合
     */
	@Override
	public List<TVehicleCheck> selectTVehicleCheckList(TVehicleCheck tVehicleCheck)
	{
	    return tVehicleCheckMapper.selectTVehicleCheckList(tVehicleCheck);
	}
	
    /**
     * 新增车辆例检
     * 
     * @param tVehicleCheck 车辆例检信息
     * @return 结果
     */
	@Override
	public int insertTVehicleCheck(TVehicleCheck tVehicleCheck)
	{
		tVehicleCheck.setId(UUIDUtil.getUUID());
		tVehicleCheck.setCreateTime(new Date());
		return tVehicleCheckMapper.insertTVehicleCheck(tVehicleCheck);
	}
	
	/**
     * 修改车辆例检
     * 
     * @param tVehicleCheck 车辆例检信息
     * @return 结果
     */
	@Override
	public int updateTVehicleCheck(TVehicleCheck tVehicleCheck)
	{
	    return tVehicleCheckMapper.updateTVehicleCheck(tVehicleCheck);
	}

	/**
     * 删除车辆例检对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTVehicleCheckByIds(String ids)
	{
		return tVehicleCheckMapper.deleteTVehicleCheckByIds(Convert.toStrArray(ids));
	}
	
}
