package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TSafetyResponsibility;
import com.project.web.mapper.TSafetyResponsibilityMapper;
import com.project.web.service.ITSafetyResponsibilityService;

/**
 * 安全责任 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TSafetyResponsibilityServiceImpl implements ITSafetyResponsibilityService 
{
	@Autowired
	private TSafetyResponsibilityMapper tSafetyResponsibilityMapper;

	/**
     * 查询安全责任信息
     * 
     * @param id 安全责任ID
     * @return 安全责任信息
     */
    @Override
	public TSafetyResponsibility selectTSafetyResponsibilityById(String id)
	{
	    return tSafetyResponsibilityMapper.selectTSafetyResponsibilityById(id);
	}
	
	/**
     * 查询安全责任列表
     * 
     * @param tSafetyResponsibility 安全责任信息
     * @return 安全责任集合
     */
	@Override
	public List<TSafetyResponsibility> selectTSafetyResponsibilityList(TSafetyResponsibility tSafetyResponsibility)
	{
	    return tSafetyResponsibilityMapper.selectTSafetyResponsibilityList(tSafetyResponsibility);
	}
	
    /**
     * 新增安全责任
     * 
     * @param tSafetyResponsibility 安全责任信息
     * @return 结果
     */
	@Override
	public int insertTSafetyResponsibility(TSafetyResponsibility tSafetyResponsibility)
	{
		tSafetyResponsibility.setId(UUIDUtil.getUUID());
		tSafetyResponsibility.setCreateTime(new Date());
		return tSafetyResponsibilityMapper.insertTSafetyResponsibility(tSafetyResponsibility);
	}
	
	/**
     * 修改安全责任
     * 
     * @param tSafetyResponsibility 安全责任信息
     * @return 结果
     */
	@Override
	public int updateTSafetyResponsibility(TSafetyResponsibility tSafetyResponsibility)
	{
	    return tSafetyResponsibilityMapper.updateTSafetyResponsibility(tSafetyResponsibility);
	}

	/**
     * 删除安全责任对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTSafetyResponsibilityByIds(String ids)
	{
		return tSafetyResponsibilityMapper.deleteTSafetyResponsibilityByIds(Convert.toStrArray(ids));
	}
	
}
