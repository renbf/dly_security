package com.project.web.service;

import java.util.List;

import com.project.web.domian.TLabourGoods;

/**
 * 劳动防护物品 服务层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface ITLabourGoodsService 
{
	/**
     * 查询劳动防护物品信息
     * 
     * @param id 劳动防护物品ID
     * @return 劳动防护物品信息
     */
	public TLabourGoods selectTLabourGoodsById(Long id);
	
	/**
     * 查询劳动防护物品列表
     * 
     * @param tLabourGoods 劳动防护物品信息
     * @return 劳动防护物品集合
     */
	public List<TLabourGoods> selectTLabourGoodsList(TLabourGoods tLabourGoods);
	
	/**
     * 新增劳动防护物品
     * 
     * @param tLabourGoods 劳动防护物品信息
     * @return 结果
     */
	public int insertTLabourGoods(TLabourGoods tLabourGoods);
	
	/**
     * 修改劳动防护物品
     * 
     * @param tLabourGoods 劳动防护物品信息
     * @return 结果
     */
	public int updateTLabourGoods(TLabourGoods tLabourGoods);
		
	/**
     * 删除劳动防护物品信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTLabourGoodsByIds(String ids);
	
}
