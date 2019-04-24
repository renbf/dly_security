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
import com.project.web.mapper.TCarRepairMapper;
import com.project.web.domian.TCarRepair;
import com.project.web.service.ITCarRepairService;
import com.project.common.support.Convert;

/**
 * 车辆维护和修理登记 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarRepairServiceImpl implements ITCarRepairService 
{
	private static final Logger log = LoggerFactory.getLogger(TCarRepairServiceImpl.class);
	@Autowired
	@Qualifier("tCarRepairMapper")
	private TCarRepairMapper tCarRepairMapper;

	/**
     * 查询车辆维护和修理登记信息
     * 
     * @param id 车辆维护和修理登记ID
     * @return 车辆维护和修理登记信息
     */
    @Override
	public TCarRepair selectTCarRepairById(String id)
	{
	    return tCarRepairMapper.selectTCarRepairById(id);
	}
	
	/**
     * 查询车辆维护和修理登记列表
     * 
     * @param tCarRepair 车辆维护和修理登记信息
     * @return 车辆维护和修理登记集合
     */
	@Override
	public List<TCarRepair> selectTCarRepairList(TCarRepair tCarRepair)
	{
	    return tCarRepairMapper.selectTCarRepairList(tCarRepair);
	}
	
    /**
     * 新增车辆维护和修理登记
     * 
     * @param tCarRepair 车辆维护和修理登记信息
     * @return 结果
     */
	@Override
	public int insertTCarRepair(TCarRepair tCarRepair)
	{
		tCarRepair.setId(UUIDUtil.getUUID());
		tCarRepair.setCreateDate(new Date());
		tCarRepair.setAddUserId(ShiroUtils.getUserId().toString());
	    return tCarRepairMapper.insertTCarRepair(tCarRepair);
	}
	
	/**
     * 修改车辆维护和修理登记
     * 
     * @param tCarRepair 车辆维护和修理登记信息
     * @return 结果
     */
	@Override
	public int updateTCarRepair(TCarRepair tCarRepair)
	{
	    return tCarRepairMapper.updateTCarRepair(tCarRepair);
	}

	/**
     * 删除车辆维护和修理登记对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCarRepairByIds(String ids)
	{
		return tCarRepairMapper.deleteTCarRepairByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
