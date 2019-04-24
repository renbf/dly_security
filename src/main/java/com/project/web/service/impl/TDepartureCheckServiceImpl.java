package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TDepartureCheck;
import com.project.web.mapper.TDepartureCheckMapper;
import com.project.web.service.ITDepartureCheckService;

/**
 * 出站例检 服务层实现
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TDepartureCheckServiceImpl implements ITDepartureCheckService 
{
	@Autowired
	private TDepartureCheckMapper tDepartureCheckMapper;

	/**
     * 查询出站例检信息
     * 
     * @param id 出站例检ID
     * @return 出站例检信息
     */
    @Override
	public TDepartureCheck selectTDepartureCheckById(Long id)
	{
	    return tDepartureCheckMapper.selectTDepartureCheckById(id);
	}
	
	/**
     * 查询出站例检列表
     * 
     * @param tDepartureCheck 出站例检信息
     * @return 出站例检集合
     */
	@Override
	public List<TDepartureCheck> selectTDepartureCheckList(TDepartureCheck tDepartureCheck)
	{
	    return tDepartureCheckMapper.selectTDepartureCheckList(tDepartureCheck);
	}
	
    /**
     * 新增出站例检
     * 
     * @param tDepartureCheck 出站例检信息
     * @return 结果
     */
	@Override
	public int insertTDepartureCheck(TDepartureCheck tDepartureCheck)
	{
		tDepartureCheck.setId(UUIDUtil.getUUID());
		tDepartureCheck.setCreateTime(new Date());
		tDepartureCheck.setUserId(ShiroUtils.getUserId());
		return tDepartureCheckMapper.insertTDepartureCheck(tDepartureCheck);
	}
	
	/**
     * 修改出站例检
     * 
     * @param tDepartureCheck 出站例检信息
     * @return 结果
     */
	@Override
	public int updateTDepartureCheck(TDepartureCheck tDepartureCheck)
	{
	    return tDepartureCheckMapper.updateTDepartureCheck(tDepartureCheck);
	}

	/**
     * 删除出站例检对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTDepartureCheckByIds(String ids)
	{
		return tDepartureCheckMapper.deleteTDepartureCheckByIds(Convert.toStrArray(ids));
	}
	
}
