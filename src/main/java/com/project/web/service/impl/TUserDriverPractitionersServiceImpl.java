package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TUserDriverPractitioners;
import com.project.web.mapper.TUserDriverPractitionersMapper;
import com.project.web.service.ITUserDriverPractitionersService;

/**
 * 驾驶员从业资格证 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TUserDriverPractitionersServiceImpl implements ITUserDriverPractitionersService 
{
	@Autowired
	private TUserDriverPractitionersMapper tUserDriverPractitionersMapper;

	/**
     * 查询驾驶员从业资格证信息
     * 
     * @param id 驾驶员从业资格证ID
     * @return 驾驶员从业资格证信息
     */
    @Override
	public TUserDriverPractitioners selectTUserDriverPractitionersById(String id)
	{
	    return tUserDriverPractitionersMapper.selectTUserDriverPractitionersById(id);
	}
	
	/**
     * 查询驾驶员从业资格证列表
     * 
     * @param tUserDriverPractitioners 驾驶员从业资格证信息
     * @return 驾驶员从业资格证集合
     */
	@Override
	public List<TUserDriverPractitioners> selectTUserDriverPractitionersList(TUserDriverPractitioners tUserDriverPractitioners)
	{
	    return tUserDriverPractitionersMapper.selectTUserDriverPractitionersList(tUserDriverPractitioners);
	}
	
    /**
     * 新增驾驶员从业资格证
     * 
     * @param tUserDriverPractitioners 驾驶员从业资格证信息
     * @return 结果
     */
	@Override
	public int insertTUserDriverPractitioners(TUserDriverPractitioners tUserDriverPractitioners)
	{
		tUserDriverPractitioners.setId(UUIDUtil.getUUID());
		tUserDriverPractitioners.setCreateTime(new Date());
		return tUserDriverPractitionersMapper.insertTUserDriverPractitioners(tUserDriverPractitioners);
	}
	
	/**
     * 修改驾驶员从业资格证
     * 
     * @param tUserDriverPractitioners 驾驶员从业资格证信息
     * @return 结果
     */
	@Override
	public int updateTUserDriverPractitioners(TUserDriverPractitioners tUserDriverPractitioners)
	{
	    return tUserDriverPractitionersMapper.updateTUserDriverPractitioners(tUserDriverPractitioners);
	}

	/**
     * 删除驾驶员从业资格证对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTUserDriverPractitionersByIds(String ids)
	{
		return tUserDriverPractitionersMapper.deleteTUserDriverPractitionersByIds(Convert.toStrArray(ids));
	}
	
}
