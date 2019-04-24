package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TUsersManagement;
import com.project.web.mapper.TUsersManagementMapper;
import com.project.web.service.ITUsersManagementService;

/**
 * 人员台账 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TUsersManagementServiceImpl implements ITUsersManagementService 
{
	@Autowired
	private TUsersManagementMapper tUsersManagementMapper;

	/**
     * 查询人员台账信息
     * 
     * @param id 人员台账ID
     * @return 人员台账信息
     */
    @Override
	public TUsersManagement selectTUsersManagementById(String id)
	{
	    return tUsersManagementMapper.selectTUsersManagementById(id);
	}
	
	/**
     * 查询人员台账列表
     * 
     * @param tUsersManagement 人员台账信息
     * @return 人员台账集合
     */
	@Override
	public List<TUsersManagement> selectTUsersManagementList(TUsersManagement tUsersManagement)
	{
	    return tUsersManagementMapper.selectTUsersManagementList(tUsersManagement);
	}
	
    /**
     * 新增人员台账
     * 
     * @param tUsersManagement 人员台账信息
     * @return 结果
     */
	@Override
	public int insertTUsersManagement(TUsersManagement tUsersManagement)
	{
		tUsersManagement.setId(UUIDUtil.getUUID());
		tUsersManagement.setCreateTime(new Date());
		return tUsersManagementMapper.insertTUsersManagement(tUsersManagement);
	}
	
	/**
     * 修改人员台账
     * 
     * @param tUsersManagement 人员台账信息
     * @return 结果
     */
	@Override
	public int updateTUsersManagement(TUsersManagement tUsersManagement)
	{
	    return tUsersManagementMapper.updateTUsersManagement(tUsersManagement);
	}

	/**
     * 删除人员台账对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTUsersManagementByIds(String ids)
	{
		return tUsersManagementMapper.deleteTUsersManagementByIds(Convert.toStrArray(ids));
	}
	
}
