package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TTaskManagement;
import com.project.web.mapper.TTaskManagementMapper;
import com.project.web.service.ITTaskManagementService;

/**
 * 作业管理 服务层实现
 * 
 * @author rbf
 * @date 2019-04-15
 */
@Service
public class TTaskManagementServiceImpl implements ITTaskManagementService 
{
	@Autowired
	private TTaskManagementMapper tTaskManagementMapper;

	/**
     * 查询作业管理信息
     * 
     * @param id 作业管理ID
     * @return 作业管理信息
     */
    @Override
	public TTaskManagement selectTTaskManagementById(Long id)
	{
	    return tTaskManagementMapper.selectTTaskManagementById(id);
	}
	
	/**
     * 查询作业管理列表
     * 
     * @param tTaskManagement 作业管理信息
     * @return 作业管理集合
     */
	@Override
	public List<TTaskManagement> selectTTaskManagementList(TTaskManagement tTaskManagement)
	{
	    return tTaskManagementMapper.selectTTaskManagementList(tTaskManagement);
	}
	
    /**
     * 新增作业管理
     * 
     * @param tTaskManagement 作业管理信息
     * @return 结果
     */
	@Override
	public int insertTTaskManagement(TTaskManagement tTaskManagement)
	{
		tTaskManagement.setId(UUIDUtil.getUUID());
		tTaskManagement.setCreateTime(new Date());
		return tTaskManagementMapper.insertTTaskManagement(tTaskManagement);
	}
	
	/**
     * 修改作业管理
     * 
     * @param tTaskManagement 作业管理信息
     * @return 结果
     */
	@Override
	public int updateTTaskManagement(TTaskManagement tTaskManagement)
	{
	    return tTaskManagementMapper.updateTTaskManagement(tTaskManagement);
	}

	/**
     * 删除作业管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTTaskManagementByIds(String ids)
	{
		return tTaskManagementMapper.deleteTTaskManagementByIds(Convert.toStrArray(ids));
	}
	
}
