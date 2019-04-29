package com.project.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.support.Convert;
import com.project.web.domian.TLabourGoodsDetail;
import com.project.web.mapper.TLabourGoodsDetailMapper;
import com.project.web.service.ITLabourGoodsDetailService;

/**
 * 劳动防护物品明细 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TLabourGoodsDetailServiceImpl implements ITLabourGoodsDetailService 
{
	@Autowired
	private TLabourGoodsDetailMapper tLabourGoodsDetailMapper;

	/**
     * 查询劳动防护物品明细信息
     * 
     * @param id 劳动防护物品明细ID
     * @return 劳动防护物品明细信息
     */
    @Override
	public TLabourGoodsDetail selectTLabourGoodsDetailById(String id)
	{
	    return tLabourGoodsDetailMapper.selectTLabourGoodsDetailById(id);
	}
	
	/**
     * 查询劳动防护物品明细列表
     * 
     * @param tLabourGoodsDetail 劳动防护物品明细信息
     * @return 劳动防护物品明细集合
     */
	@Override
	public List<TLabourGoodsDetail> selectTLabourGoodsDetailList(TLabourGoodsDetail tLabourGoodsDetail)
	{
	    return tLabourGoodsDetailMapper.selectTLabourGoodsDetailList(tLabourGoodsDetail);
	}
	
    /**
     * 新增劳动防护物品明细
     * 
     * @param tLabourGoodsDetail 劳动防护物品明细信息
     * @return 结果
     */
	@Override
	public int insertTLabourGoodsDetail(TLabourGoodsDetail tLabourGoodsDetail)
	{
	    return tLabourGoodsDetailMapper.insertTLabourGoodsDetail(tLabourGoodsDetail);
	}
	
	/**
     * 修改劳动防护物品明细
     * 
     * @param tLabourGoodsDetail 劳动防护物品明细信息
     * @return 结果
     */
	@Override
	public int updateTLabourGoodsDetail(TLabourGoodsDetail tLabourGoodsDetail)
	{
	    return tLabourGoodsDetailMapper.updateTLabourGoodsDetail(tLabourGoodsDetail);
	}

	/**
     * 删除劳动防护物品明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTLabourGoodsDetailByIds(String ids)
	{
		return tLabourGoodsDetailMapper.deleteTLabourGoodsDetailByIds(Convert.toStrArray(ids));
	}

	@Override
	public int deleteTLabourGoodsDetailByByGoodsId(String labourGoodsId) {
		
		return tLabourGoodsDetailMapper.deleteTLabourGoodsDetailByGoodsId(labourGoodsId);
	}
	
}
