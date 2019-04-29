package com.project.web.service;

import java.util.List;

import com.project.web.domian.TLabourGoodsDetail;

/**
 * 劳动防护物品明细 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITLabourGoodsDetailService 
{
	/**
     * 查询劳动防护物品明细信息
     * 
     * @param id 劳动防护物品明细ID
     * @return 劳动防护物品明细信息
     */
	public TLabourGoodsDetail selectTLabourGoodsDetailById(String id);
	
	/**
     * 查询劳动防护物品明细列表
     * 
     * @param tLabourGoodsDetail 劳动防护物品明细信息
     * @return 劳动防护物品明细集合
     */
	public List<TLabourGoodsDetail> selectTLabourGoodsDetailList(TLabourGoodsDetail tLabourGoodsDetail);
	
	/**
     * 新增劳动防护物品明细
     * 
     * @param tLabourGoodsDetail 劳动防护物品明细信息
     * @return 结果
     */
	public int insertTLabourGoodsDetail(TLabourGoodsDetail tLabourGoodsDetail);
	
	/**
     * 修改劳动防护物品明细
     * 
     * @param tLabourGoodsDetail 劳动防护物品明细信息
     * @return 结果
     */
	public int updateTLabourGoodsDetail(TLabourGoodsDetail tLabourGoodsDetail);
		
	/**
     * 删除劳动防护物品明细信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTLabourGoodsDetailByIds(String ids);
	
	/**
     * 删除劳动防护物品明细信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTLabourGoodsDetailByByGoodsId(String labourGoodsId);
	
}
