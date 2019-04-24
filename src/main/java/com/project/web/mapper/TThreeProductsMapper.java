package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TThreeProducts;	

/**
 * 三品查处记录 数据层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface TThreeProductsMapper 
{
	/**
     * 查询三品查处记录信息
     * 
     * @param id 三品查处记录ID
     * @return 三品查处记录信息
     */
	public TThreeProducts selectTThreeProductsById(Long id);
	
	/**
     * 查询三品查处记录列表
     * 
     * @param tThreeProducts 三品查处记录信息
     * @return 三品查处记录集合
     */
	public List<TThreeProducts> selectTThreeProductsList(TThreeProducts tThreeProducts);
	
	/**
     * 新增三品查处记录
     * 
     * @param tThreeProducts 三品查处记录信息
     * @return 结果
     */
	public int insertTThreeProducts(TThreeProducts tThreeProducts);
	
	/**
     * 修改三品查处记录
     * 
     * @param tThreeProducts 三品查处记录信息
     * @return 结果
     */
	public int updateTThreeProducts(TThreeProducts tThreeProducts);
	
	/**
     * 删除三品查处记录
     * 
     * @param id 三品查处记录ID
     * @return 结果
     */
	public int deleteTThreeProductsById(Long id);
	
	/**
     * 批量删除三品查处记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTThreeProductsByIds(String[] ids);
	
}