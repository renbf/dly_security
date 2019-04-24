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
import com.project.web.mapper.TCarKmMapper;
import com.project.web.domian.TCarKm;
import com.project.web.service.ITCarKmService;
import com.project.common.support.Convert;

/**
 * 车辆行驶里程登记 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarKmServiceImpl implements ITCarKmService 
{
	private static final Logger log = LoggerFactory.getLogger(TCarKmServiceImpl.class);
	@Autowired
	@Qualifier("tCarKmMapper")
	private TCarKmMapper tCarKmMapper;

	/**
     * 查询车辆行驶里程登记信息
     * 
     * @param id 车辆行驶里程登记ID
     * @return 车辆行驶里程登记信息
     */
    @Override
	public TCarKm selectTCarKmById(String id)
	{
	    return tCarKmMapper.selectTCarKmById(id);
	}
	
	/**
     * 查询车辆行驶里程登记列表
     * 
     * @param tCarKm 车辆行驶里程登记信息
     * @return 车辆行驶里程登记集合
     */
	@Override
	public List<TCarKm> selectTCarKmList(TCarKm tCarKm)
	{
	    return tCarKmMapper.selectTCarKmList(tCarKm);
	}
	
    /**
     * 新增车辆行驶里程登记
     * 
     * @param tCarKm 车辆行驶里程登记信息
     * @return 结果
     */
	@Override
	public int insertTCarKm(TCarKm tCarKm)
	{
		tCarKm.setId(UUIDUtil.getUUID());
		tCarKm.setCreateDate(new Date());
		tCarKm.setAddUserId(ShiroUtils.getUserId().toString());
	    return tCarKmMapper.insertTCarKm(tCarKm);
	}
	
	/**
     * 修改车辆行驶里程登记
     * 
     * @param tCarKm 车辆行驶里程登记信息
     * @return 结果
     */
	@Override
	public int updateTCarKm(TCarKm tCarKm)
	{
	    return tCarKmMapper.updateTCarKm(tCarKm);
	}

	/**
     * 删除车辆行驶里程登记对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCarKmByIds(String ids)
	{
		return tCarKmMapper.deleteTCarKmByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
