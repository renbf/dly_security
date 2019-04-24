package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TSafetyTarget;
import com.project.web.mapper.TSafetyTargetMapper;
import com.project.web.service.ITSafetyTargetService;

/**
 * 安全目标 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TSafetyTargetServiceImpl implements ITSafetyTargetService 
{
	@Autowired
	private TSafetyTargetMapper tSafetyTargetMapper;

	/**
     * 查询安全目标信息
     * 
     * @param id 安全目标ID
     * @return 安全目标信息
     */
    @Override
	public TSafetyTarget selectTSafetyTargetById(String id)
	{
	    return tSafetyTargetMapper.selectTSafetyTargetById(id);
	}
	
	/**
     * 查询安全目标列表
     * 
     * @param tSafetyTarget 安全目标信息
     * @return 安全目标集合
     */
	@Override
	public List<TSafetyTarget> selectTSafetyTargetList(TSafetyTarget tSafetyTarget)
	{
	    return tSafetyTargetMapper.selectTSafetyTargetList(tSafetyTarget);
	}
	
    /**
     * 新增安全目标
     * 
     * @param tSafetyTarget 安全目标信息
     * @return 结果
     */
	@Override
	public int insertTSafetyTarget(TSafetyTarget tSafetyTarget)
	{
		tSafetyTarget.setId(UUIDUtil.getUUID());
		tSafetyTarget.setCreateTime(new Date());
		return tSafetyTargetMapper.insertTSafetyTarget(tSafetyTarget);
	}
	
	/**
     * 修改安全目标
     * 
     * @param tSafetyTarget 安全目标信息
     * @return 结果
     */
	@Override
	public int updateTSafetyTarget(TSafetyTarget tSafetyTarget)
	{
	    return tSafetyTargetMapper.updateTSafetyTarget(tSafetyTarget);
	}

	/**
     * 删除安全目标对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTSafetyTargetByIds(String ids)
	{
		return tSafetyTargetMapper.deleteTSafetyTargetByIds(Convert.toStrArray(ids));
	}
	
}
