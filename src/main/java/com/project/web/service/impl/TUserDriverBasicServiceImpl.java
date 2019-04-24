package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TUserDriverBasic;
import com.project.web.mapper.TUserDriverBasicMapper;
import com.project.web.service.ITUserDriverBasicService;

/**
 * 驾驶员台账基础 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TUserDriverBasicServiceImpl implements ITUserDriverBasicService 
{
	@Autowired
	private TUserDriverBasicMapper tUserDriverBasicMapper;

	/**
     * 查询驾驶员台账基础信息
     * 
     * @param id 驾驶员台账基础ID
     * @return 驾驶员台账基础信息
     */
    @Override
	public TUserDriverBasic selectTUserDriverBasicById(String id)
	{
	    return tUserDriverBasicMapper.selectTUserDriverBasicById(id);
	}
	
	/**
     * 查询驾驶员台账基础列表
     * 
     * @param tUserDriverBasic 驾驶员台账基础信息
     * @return 驾驶员台账基础集合
     */
	@Override
	public List<TUserDriverBasic> selectTUserDriverBasicList(TUserDriverBasic tUserDriverBasic)
	{
	    return tUserDriverBasicMapper.selectTUserDriverBasicList(tUserDriverBasic);
	}
	
    /**
     * 新增驾驶员台账基础
     * 
     * @param tUserDriverBasic 驾驶员台账基础信息
     * @return 结果
     */
	@Override
	public int insertTUserDriverBasic(TUserDriverBasic tUserDriverBasic)
	{
		//新增
		tUserDriverBasic.setId(UUIDUtil.getUUID());
		tUserDriverBasic.setCreateTime(new Date());
		tUserDriverBasic.setUserId(ShiroUtils.getUserId());	
		return tUserDriverBasicMapper.insertTUserDriverBasic(tUserDriverBasic);
	}
	
	/**
     * 修改驾驶员台账基础
     * 
     * @param tUserDriverBasic 驾驶员台账基础信息
     * @return 结果
     */
	@Override
	public int updateTUserDriverBasic(TUserDriverBasic tUserDriverBasic)
	{
	    return tUserDriverBasicMapper.updateTUserDriverBasic(tUserDriverBasic);
	}

	/**
     * 删除驾驶员台账基础对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTUserDriverBasicByIds(String ids)
	{
		return tUserDriverBasicMapper.deleteTUserDriverBasicByIds(Convert.toStrArray(ids));
	}
	
}
