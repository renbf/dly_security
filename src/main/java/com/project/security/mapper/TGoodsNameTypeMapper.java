package com.project.security.mapper;

import com.project.security.domain.TGoodsNameType;
import java.util.List;

import org.springframework.stereotype.Repository;	

/**
 * 货物名称类项关系 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Repository("goodsNameTypeMapper")
public interface TGoodsNameTypeMapper 
{
	/**
     * 查询货物名称类项关系信息
     * 
     * @param id 货物名称类项关系ID
     * @return 货物名称类项关系信息
     */
	public TGoodsNameType selectTGoodsNameTypeById(String id);
	
	/**
     * 查询货物名称类项关系列表
     * 
     * @param tGoodsNameType 货物名称类项关系信息
     * @return 货物名称类项关系集合
     */
	public List<TGoodsNameType> selectTGoodsNameTypeList(TGoodsNameType tGoodsNameType);
	
	/**
     * 新增货物名称类项关系
     * 
     * @param tGoodsNameType 货物名称类项关系信息
     * @return 结果
     */
	public int insertTGoodsNameType(TGoodsNameType tGoodsNameType);
	
	/**
     * 修改货物名称类项关系
     * 
     * @param tGoodsNameType 货物名称类项关系信息
     * @return 结果
     */
	public int updateTGoodsNameType(TGoodsNameType tGoodsNameType);
	
	/**
     * 删除货物名称类项关系
     * 
     * @param id 货物名称类项关系ID
     * @return 结果
     */
	public int deleteTGoodsNameTypeById(String id);
	
	/**
     * 批量删除货物名称类项关系
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTGoodsNameTypeByIds(String[] ids);
	//以上自动生成的尽量别动
}