package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TLabourGoodsDetail;	

/**
 * 劳动防护物品明细 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface TLabourGoodsDetailMapper 
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
     * 删除劳动防护物品明细
     * 
     * @param id 劳动防护物品明细ID
     * @return 结果
     */
	public int deleteTLabourGoodsDetailById(String id);
	
	/**
     *	根据主键ID  删除劳动防护物品明细
     * 
     * @param id 劳动防护物品明细ID
     * @return 结果
     */
	public int deleteTLabourGoodsDetailByGoodsId(String labourGoodsId);
	
	
	/**
     * 批量删除劳动防护物品明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTLabourGoodsDetailByIds(String[] ids);
	
}