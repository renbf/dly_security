package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TUserDriverOthers;
import com.project.web.mapper.TUserDriverOthersMapper;
import com.project.web.service.ITUserDriverOthersService;

/**
 * 驾驶员其他 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TUserDriverOthersServiceImpl implements ITUserDriverOthersService 
{
	@Autowired
	private TUserDriverOthersMapper tUserDriverOthersMapper;

	/**
     * 查询驾驶员其他信息
     * 
     * @param id 驾驶员其他ID
     * @return 驾驶员其他信息
     */
    @Override
	public TUserDriverOthers selectTUserDriverOthersById(String id)
	{
	    return tUserDriverOthersMapper.selectTUserDriverOthersById(id);
	}
	
	/**
     * 查询驾驶员其他列表
     * 
     * @param tUserDriverOthers 驾驶员其他信息
     * @return 驾驶员其他集合
     */
	@Override
	public List<TUserDriverOthers> selectTUserDriverOthersList(TUserDriverOthers tUserDriverOthers)
	{
	    return tUserDriverOthersMapper.selectTUserDriverOthersList(tUserDriverOthers);
	}
	
    /**
     * 新增驾驶员其他
     * 
     * @param tUserDriverOthers 驾驶员其他信息
     * @return 结果
     */
	@Override
	public int insertTUserDriverOthers(TUserDriverOthers tUserDriverOthers)
	{
		tUserDriverOthers.setId(UUIDUtil.getUUID());
		tUserDriverOthers.setCreateTime(new Date());
		return tUserDriverOthersMapper.insertTUserDriverOthers(tUserDriverOthers);
	}
	
	/**
     * 修改驾驶员其他
     * 
     * @param tUserDriverOthers 驾驶员其他信息
     * @return 结果
     */
	@Override
	public int updateTUserDriverOthers(TUserDriverOthers tUserDriverOthers)
	{
	    return tUserDriverOthersMapper.updateTUserDriverOthers(tUserDriverOthers);
	}

	/**
     * 删除驾驶员其他对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTUserDriverOthersByIds(String ids)
	{
		return tUserDriverOthersMapper.deleteTUserDriverOthersByIds(Convert.toStrArray(ids));
	}
	
}
