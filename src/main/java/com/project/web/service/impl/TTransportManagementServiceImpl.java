package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TTransportManagement;
import com.project.web.mapper.TTransportManagementMapper;
import com.project.web.service.ITTransportManagementService;

/**
 * 客运管理 服务层实现
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TTransportManagementServiceImpl implements ITTransportManagementService 
{
	@Autowired
	private TTransportManagementMapper tTransportManagementMapper;

	/**
     * 查询客运管理信息
     * 
     * @param id 客运管理ID
     * @return 客运管理信息
     */
    @Override
	public TTransportManagement selectTTransportManagementById(Long id)
	{
	    return tTransportManagementMapper.selectTTransportManagementById(id);
	}
	
	/**
     * 查询客运管理列表
     * 
     * @param tTransportManagement 客运管理信息
     * @return 客运管理集合
     */
	@Override
	public List<TTransportManagement> selectTTransportManagementList(TTransportManagement tTransportManagement)
	{
	    return tTransportManagementMapper.selectTTransportManagementList(tTransportManagement);
	}
	
    /**
     * 新增客运管理
     * 
     * @param tTransportManagement 客运管理信息
     * @return 结果
     */
	@Override
	public int insertTTransportManagement(TTransportManagement tTransportManagement)
	{
		tTransportManagement.setId(UUIDUtil.getUUID());
		tTransportManagement.setCreateTime(new Date());
		return tTransportManagementMapper.insertTTransportManagement(tTransportManagement);
	}
	
	/**
     * 修改客运管理
     * 
     * @param tTransportManagement 客运管理信息
     * @return 结果
     */
	@Override
	public int updateTTransportManagement(TTransportManagement tTransportManagement)
	{
	    return tTransportManagementMapper.updateTTransportManagement(tTransportManagement);
	}

	/**
     * 删除客运管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTTransportManagementByIds(String ids)
	{
		return tTransportManagementMapper.deleteTTransportManagementByIds(Convert.toStrArray(ids));
	}
	
}
