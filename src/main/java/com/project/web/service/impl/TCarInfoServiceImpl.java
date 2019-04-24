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
import com.project.web.mapper.TCarInfoMapper;
import com.project.web.domian.TCarInfo;
import com.project.web.service.ITCarInfoService;
import com.project.common.support.Convert;

/**
 * 车辆 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarInfoServiceImpl implements ITCarInfoService 
{
	private static final Logger log = LoggerFactory.getLogger(TCarInfoServiceImpl.class);
	@Autowired
	@Qualifier("tCarInfoMapper")
	private TCarInfoMapper tCarInfoMapper;

	/**
     * 查询车辆信息
     * 
     * @param id 车辆ID
     * @return 车辆信息
     */
    @Override
	public TCarInfo selectTCarInfoById(String id)
	{
	    return tCarInfoMapper.selectTCarInfoById(id);
	}
	
	/**
     * 查询车辆列表
     * 
     * @param tCarInfo 车辆信息
     * @return 车辆集合
     */
	@Override
	public List<TCarInfo> selectTCarInfoList(TCarInfo tCarInfo)
	{
	    return tCarInfoMapper.selectTCarInfoList(tCarInfo);
	}
	
    /**
     * 新增车辆
     * 
     * @param tCarInfo 车辆信息
     * @return 结果
     */
	@Override
	public int insertTCarInfo(TCarInfo tCarInfo)
	{
		tCarInfo.setId(UUIDUtil.getUUID());
		tCarInfo.setCreateDate(new Date());
		tCarInfo.setAddUserId(ShiroUtils.getUserId().toString());
	    return tCarInfoMapper.insertTCarInfo(tCarInfo);
	}
	
	/**
     * 修改车辆
     * 
     * @param tCarInfo 车辆信息
     * @return 结果
     */
	@Override
	public int updateTCarInfo(TCarInfo tCarInfo)
	{
	    return tCarInfoMapper.updateTCarInfo(tCarInfo);
	}

	/**
     * 删除车辆对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCarInfoByIds(String ids)
	{
		return tCarInfoMapper.deleteTCarInfoByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
