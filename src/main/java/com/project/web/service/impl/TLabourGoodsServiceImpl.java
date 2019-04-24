package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TLabourGoods;
import com.project.web.mapper.TLabourGoodsMapper;
import com.project.web.service.ITLabourGoodsService;

/**
 * 劳动防护物品 服务层实现
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TLabourGoodsServiceImpl implements ITLabourGoodsService 
{
	@Autowired
	private TLabourGoodsMapper tLabourGoodsMapper;

	/**
     * 查询劳动防护物品信息
     * 
     * @param id 劳动防护物品ID
     * @return 劳动防护物品信息
     */
    @Override
	public TLabourGoods selectTLabourGoodsById(Long id)
	{
	    return tLabourGoodsMapper.selectTLabourGoodsById(id);
	}
	
	/**
     * 查询劳动防护物品列表
     * 
     * @param tLabourGoods 劳动防护物品信息
     * @return 劳动防护物品集合
     */
	@Override
	public List<TLabourGoods> selectTLabourGoodsList(TLabourGoods tLabourGoods)
	{
	    return tLabourGoodsMapper.selectTLabourGoodsList(tLabourGoods);
	}
	
    /**
     * 新增劳动防护物品
     * 
     * @param tLabourGoods 劳动防护物品信息
     * @return 结果
     */
	@Override
	public int insertTLabourGoods(TLabourGoods tLabourGoods)
	{
		tLabourGoods.setId(UUIDUtil.getUUID());
		tLabourGoods.setCreateTime(new Date());
		return tLabourGoodsMapper.insertTLabourGoods(tLabourGoods);
	}
	
	/**
     * 修改劳动防护物品
     * 
     * @param tLabourGoods 劳动防护物品信息
     * @return 结果
     */
	@Override
	public int updateTLabourGoods(TLabourGoods tLabourGoods)
	{
	    return tLabourGoodsMapper.updateTLabourGoods(tLabourGoods);
	}

	/**
     * 删除劳动防护物品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTLabourGoodsByIds(String ids)
	{
		return tLabourGoodsMapper.deleteTLabourGoodsByIds(Convert.toStrArray(ids));
	}
	
}
