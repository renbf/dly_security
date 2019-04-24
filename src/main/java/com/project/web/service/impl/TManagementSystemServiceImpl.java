package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TManagementSystem;
import com.project.web.mapper.TManagementSystemMapper;
import com.project.web.service.ITManagementSystemService;

/**
 * 管理制度 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TManagementSystemServiceImpl implements ITManagementSystemService 
{
	@Autowired
	private TManagementSystemMapper tManagementSystemMapper;

	/**
     * 查询管理制度信息
     * 
     * @param id 管理制度ID
     * @return 管理制度信息
     */
    @Override
	public TManagementSystem selectTManagementSystemById(String id)
	{
	    return tManagementSystemMapper.selectTManagementSystemById(id);
	}
	
	/**
     * 查询管理制度列表
     * 
     * @param tManagementSystem 管理制度信息
     * @return 管理制度集合
     */
	@Override
	public List<TManagementSystem> selectTManagementSystemList(TManagementSystem tManagementSystem)
	{
	    return tManagementSystemMapper.selectTManagementSystemList(tManagementSystem);
	}
	
    /**
     * 新增管理制度
     * 
     * @param tManagementSystem 管理制度信息
     * @return 结果
     */
	@Override
	public int insertTManagementSystem(TManagementSystem tManagementSystem)
	{
		tManagementSystem.setId(UUIDUtil.getUUID());
		tManagementSystem.setCreateTime(new Date());
		return tManagementSystemMapper.insertTManagementSystem(tManagementSystem);
	}
	
	/**
     * 修改管理制度
     * 
     * @param tManagementSystem 管理制度信息
     * @return 结果
     */
	@Override
	public int updateTManagementSystem(TManagementSystem tManagementSystem)
	{
	    return tManagementSystemMapper.updateTManagementSystem(tManagementSystem);
	}

	/**
     * 删除管理制度对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTManagementSystemByIds(String ids)
	{
		return tManagementSystemMapper.deleteTManagementSystemByIds(Convert.toStrArray(ids));
	}
	
}
