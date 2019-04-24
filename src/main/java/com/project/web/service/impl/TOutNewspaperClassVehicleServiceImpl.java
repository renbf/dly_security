package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TOutNewspaperClassVehicle;
import com.project.web.mapper.TOutNewspaperClassVehicleMapper;
import com.project.web.service.ITOutNewspaperClassVehicleService;

/**
 * 未报班车辆 服务层实现
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TOutNewspaperClassVehicleServiceImpl implements ITOutNewspaperClassVehicleService 
{
	@Autowired
	private TOutNewspaperClassVehicleMapper tOutNewspaperClassVehicleMapper;

	/**
     * 查询未报班车辆信息
     * 
     * @param id 未报班车辆ID
     * @return 未报班车辆信息
     */
    @Override
	public TOutNewspaperClassVehicle selectTOutNewspaperClassVehicleById(Long id)
	{
	    return tOutNewspaperClassVehicleMapper.selectTOutNewspaperClassVehicleById(id);
	}
	
	/**
     * 查询未报班车辆列表
     * 
     * @param tOutNewspaperClassVehicle 未报班车辆信息
     * @return 未报班车辆集合
     */
	@Override
	public List<TOutNewspaperClassVehicle> selectTOutNewspaperClassVehicleList(TOutNewspaperClassVehicle tOutNewspaperClassVehicle)
	{
	    return tOutNewspaperClassVehicleMapper.selectTOutNewspaperClassVehicleList(tOutNewspaperClassVehicle);
	}
	
    /**
     * 新增未报班车辆
     * 
     * @param tOutNewspaperClassVehicle 未报班车辆信息
     * @return 结果
     */
	@Override
	public int insertTOutNewspaperClassVehicle(TOutNewspaperClassVehicle tOutNewspaperClassVehicle)
	{
		tOutNewspaperClassVehicle.setId(UUIDUtil.getUUID());
		tOutNewspaperClassVehicle.setCreateTime(new Date());
		return tOutNewspaperClassVehicleMapper.insertTOutNewspaperClassVehicle(tOutNewspaperClassVehicle);
	}
	
	/**
     * 修改未报班车辆
     * 
     * @param tOutNewspaperClassVehicle 未报班车辆信息
     * @return 结果
     */
	@Override
	public int updateTOutNewspaperClassVehicle(TOutNewspaperClassVehicle tOutNewspaperClassVehicle)
	{
	    return tOutNewspaperClassVehicleMapper.updateTOutNewspaperClassVehicle(tOutNewspaperClassVehicle);
	}

	/**
     * 删除未报班车辆对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTOutNewspaperClassVehicleByIds(String ids)
	{
		return tOutNewspaperClassVehicleMapper.deleteTOutNewspaperClassVehicleByIds(Convert.toStrArray(ids));
	}
	
}
