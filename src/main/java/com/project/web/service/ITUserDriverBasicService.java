package com.project.web.service;

import java.util.List;

import com.project.web.domian.TUserDriverBasic;

/**
 * 驾驶员台账基础 服务层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface ITUserDriverBasicService 
{
	/**
     * 查询驾驶员台账基础信息
     * 
     * @param id 驾驶员台账基础ID
     * @return 驾驶员台账基础信息
     */
	public TUserDriverBasic selectTUserDriverBasicById(String id);
	
	/**
     * 查询驾驶员台账基础列表
     * 
     * @param tUserDriverBasic 驾驶员台账基础信息
     * @return 驾驶员台账基础集合
     */
	public List<TUserDriverBasic> selectTUserDriverBasicList(TUserDriverBasic tUserDriverBasic);
	
	/**
     * 新增驾驶员台账基础
     * 
     * @param tUserDriverBasic 驾驶员台账基础信息
     * @return 结果
     */
	public int insertTUserDriverBasic(TUserDriverBasic tUserDriverBasic);
	
	/**
     * 修改驾驶员台账基础
     * 
     * @param tUserDriverBasic 驾驶员台账基础信息
     * @return 结果
     */
	public int updateTUserDriverBasic(TUserDriverBasic tUserDriverBasic);
		
	/**
     * 删除驾驶员台账基础信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserDriverBasicByIds(String ids);
	
}
