package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TGoodsNameType;
import java.util.List;

/**
 * 货物名称类项关系 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITGoodsNameTypeService 
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
	public AjaxResult insertTGoodsNameType(TGoodsNameType tGoodsNameType);
	
	/**
     * 修改货物名称类项关系
     * 
     * @param tGoodsNameType 货物名称类项关系信息
     * @return 结果
     */
	public AjaxResult updateTGoodsNameType(TGoodsNameType tGoodsNameType);
		
	/**
     * 删除货物名称类项关系信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTGoodsNameTypeByIds(String ids);
	//以上自动生成的尽量别动
}
