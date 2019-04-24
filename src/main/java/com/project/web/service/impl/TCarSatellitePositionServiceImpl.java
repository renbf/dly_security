package com.project.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Date;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.project.web.mapper.TCarSatellitePositionMapper;
import com.project.web.domian.TCarSatellitePosition;
import com.project.web.service.ITCarSatellitePositionService;
import com.project.common.support.Convert;

/**
 * 卫星定位 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarSatellitePositionServiceImpl implements ITCarSatellitePositionService 
{
	private static final Logger log = LoggerFactory.getLogger(TCarSatellitePositionServiceImpl.class);
	@Autowired
	@Qualifier("tCarSatellitePositionMapper")
	private TCarSatellitePositionMapper tCarSatellitePositionMapper;

	/**
     * 查询卫星定位信息
     * 
     * @param id 卫星定位ID
     * @return 卫星定位信息
     */
    @Override
	public TCarSatellitePosition selectTCarSatellitePositionById(String id)
	{
	    return tCarSatellitePositionMapper.selectTCarSatellitePositionById(id);
	}
	
	/**
     * 查询卫星定位列表
     * 
     * @param tCarSatellitePosition 卫星定位信息
     * @return 卫星定位集合
     */
	@Override
	public List<TCarSatellitePosition> selectTCarSatellitePositionList(TCarSatellitePosition tCarSatellitePosition)
	{
	    return tCarSatellitePositionMapper.selectTCarSatellitePositionList(tCarSatellitePosition);
	}
	
    /**
     * 新增卫星定位
     * 
     * @param tCarSatellitePosition 卫星定位信息
     * @return 结果
     */
	@Override
	public int insertTCarSatellitePosition(TCarSatellitePosition tCarSatellitePosition)
	{
		tCarSatellitePosition.setId(UUIDUtil.getUUID());
		tCarSatellitePosition.setCreateDate(new Date());
		tCarSatellitePosition.setAddUserId(ShiroUtils.getUserId().toString());
	    return tCarSatellitePositionMapper.insertTCarSatellitePosition(tCarSatellitePosition);
	}
	
	/**
     * 修改卫星定位
     * 
     * @param tCarSatellitePosition 卫星定位信息
     * @return 结果
     */
	@Override
	public int updateTCarSatellitePosition(TCarSatellitePosition tCarSatellitePosition)
	{
	    return tCarSatellitePositionMapper.updateTCarSatellitePosition(tCarSatellitePosition);
	}

	/**
     * 删除卫星定位对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCarSatellitePositionByIds(String ids)
	{
		return tCarSatellitePositionMapper.deleteTCarSatellitePositionByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
