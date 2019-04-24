package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TUserDriverInfo;
import com.project.web.mapper.TUserDriverInfoMapper;
import com.project.web.service.ITUserDriverInfoService;

/**
 * 驾驶员驾驶 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TUserDriverInfoServiceImpl implements ITUserDriverInfoService 
{
	@Autowired
	private TUserDriverInfoMapper tUserDriverInfoMapper;

	/**
     * 查询驾驶员驾驶信息
     * 
     * @param id 驾驶员驾驶ID
     * @return 驾驶员驾驶信息
     */
    @Override
	public TUserDriverInfo selectTUserDriverInfoById(String id)
	{
	    return tUserDriverInfoMapper.selectTUserDriverInfoById(id);
	}
	
	/**
     * 查询驾驶员驾驶列表
     * 
     * @param tUserDriverInfo 驾驶员驾驶信息
     * @return 驾驶员驾驶集合
     */
	@Override
	public List<TUserDriverInfo> selectTUserDriverInfoList(TUserDriverInfo tUserDriverInfo)
	{
	    return tUserDriverInfoMapper.selectTUserDriverInfoList(tUserDriverInfo);
	}
	
    /**
     * 新增驾驶员驾驶
     * 
     * @param tUserDriverInfo 驾驶员驾驶信息
     * @return 结果
     */
	@Override
	public int insertTUserDriverInfo(TUserDriverInfo tUserDriverInfo)
	{
		tUserDriverInfo.setId(UUIDUtil.getUUID());
		tUserDriverInfo.setCreateTime(new Date());
		
	    return tUserDriverInfoMapper.insertTUserDriverInfo(tUserDriverInfo);
	}
	
	/**
     * 修改驾驶员驾驶
     * 
     * @param tUserDriverInfo 驾驶员驾驶信息
     * @return 结果
     */
	@Override
	public int updateTUserDriverInfo(TUserDriverInfo tUserDriverInfo)
	{
	    return tUserDriverInfoMapper.updateTUserDriverInfo(tUserDriverInfo);
	}

	/**
     * 删除驾驶员驾驶对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTUserDriverInfoByIds(String ids)
	{
		return tUserDriverInfoMapper.deleteTUserDriverInfoByIds(Convert.toStrArray(ids));
	}
	
}
