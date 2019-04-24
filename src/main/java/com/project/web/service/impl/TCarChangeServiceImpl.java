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
import com.project.web.mapper.TCarChangeMapper;
import com.project.web.domian.TCarChange;
import com.project.web.service.ITCarChangeService;
import com.project.common.support.Convert;

/**
 * 车辆变更登记 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarChangeServiceImpl implements ITCarChangeService 
{
	private static final Logger log = LoggerFactory.getLogger(TCarChangeServiceImpl.class);
	@Autowired
	@Qualifier("tCarChangeMapper")
	private TCarChangeMapper tCarChangeMapper;

	/**
     * 查询车辆变更登记信息
     * 
     * @param id 车辆变更登记ID
     * @return 车辆变更登记信息
     */
    @Override
	public TCarChange selectTCarChangeById(String id)
	{
	    return tCarChangeMapper.selectTCarChangeById(id);
	}
	
	/**
     * 查询车辆变更登记列表
     * 
     * @param tCarChange 车辆变更登记信息
     * @return 车辆变更登记集合
     */
	@Override
	public List<TCarChange> selectTCarChangeList(TCarChange tCarChange)
	{
	    return tCarChangeMapper.selectTCarChangeList(tCarChange);
	}
	
    /**
     * 新增车辆变更登记
     * 
     * @param tCarChange 车辆变更登记信息
     * @return 结果
     */
	@Override
	public int insertTCarChange(TCarChange tCarChange)
	{
		tCarChange.setId(UUIDUtil.getUUID());
		tCarChange.setCreateDate(new Date());
		tCarChange.setAddUserId(ShiroUtils.getUserId().toString());
	    return tCarChangeMapper.insertTCarChange(tCarChange);
	}
	
	/**
     * 修改车辆变更登记
     * 
     * @param tCarChange 车辆变更登记信息
     * @return 结果
     */
	@Override
	public int updateTCarChange(TCarChange tCarChange)
	{
	    return tCarChangeMapper.updateTCarChange(tCarChange);
	}

	/**
     * 删除车辆变更登记对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCarChangeByIds(String ids)
	{
		return tCarChangeMapper.deleteTCarChangeByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
