package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TSafetyDuty;
import com.project.web.mapper.TSafetyDutyMapper;
import com.project.web.service.ITSafetyDutyService;

/**
 * 安全值班 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TSafetyDutyServiceImpl implements ITSafetyDutyService 
{
	@Autowired
	private TSafetyDutyMapper tSafetyDutyMapper;

	/**
     * 查询安全值班信息
     * 
     * @param id 安全值班ID
     * @return 安全值班信息
     */
    @Override
	public TSafetyDuty selectTSafetyDutyById(String id)
	{
	    return tSafetyDutyMapper.selectTSafetyDutyById(id);
	}
	
	/**
     * 查询安全值班列表
     * 
     * @param tSafetyDuty 安全值班信息
     * @return 安全值班集合
     */
	@Override
	public List<TSafetyDuty> selectTSafetyDutyList(TSafetyDuty tSafetyDuty)
	{
	    return tSafetyDutyMapper.selectTSafetyDutyList(tSafetyDuty);
	}
	
    /**
     * 新增安全值班
     * 
     * @param tSafetyDuty 安全值班信息
     * @return 结果
     */
	@Override
	public int insertTSafetyDuty(TSafetyDuty tSafetyDuty)
	{
		tSafetyDuty.setId(UUIDUtil.getUUID());
		tSafetyDuty.setCreateTime(new Date());
		return tSafetyDutyMapper.insertTSafetyDuty(tSafetyDuty);
	}
	
	/**
     * 修改安全值班
     * 
     * @param tSafetyDuty 安全值班信息
     * @return 结果
     */
	@Override
	public int updateTSafetyDuty(TSafetyDuty tSafetyDuty)
	{
	    return tSafetyDutyMapper.updateTSafetyDuty(tSafetyDuty);
	}

	/**
     * 删除安全值班对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTSafetyDutyByIds(String ids)
	{
		return tSafetyDutyMapper.deleteTSafetyDutyByIds(Convert.toStrArray(ids));
	}
	
}
