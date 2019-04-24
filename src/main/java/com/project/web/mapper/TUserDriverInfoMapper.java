package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TUserDriverInfo;	

/**
 * 驾驶员驾驶 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface TUserDriverInfoMapper 
{
	/**
     * 查询驾驶员驾驶信息
     * 
     * @param id 驾驶员驾驶ID
     * @return 驾驶员驾驶信息
     */
	public TUserDriverInfo selectTUserDriverInfoById(String id);
	
	/**
     * 查询驾驶员驾驶列表
     * 
     * @param tUserDriverInfo 驾驶员驾驶信息
     * @return 驾驶员驾驶集合
     */
	public List<TUserDriverInfo> selectTUserDriverInfoList(TUserDriverInfo tUserDriverInfo);
	
	/**
     * 新增驾驶员驾驶
     * 
     * @param tUserDriverInfo 驾驶员驾驶信息
     * @return 结果
     */
	public int insertTUserDriverInfo(TUserDriverInfo tUserDriverInfo);
	
	/**
     * 修改驾驶员驾驶
     * 
     * @param tUserDriverInfo 驾驶员驾驶信息
     * @return 结果
     */
	public int updateTUserDriverInfo(TUserDriverInfo tUserDriverInfo);
	
	/**
     * 删除驾驶员驾驶
     * 
     * @param id 驾驶员驾驶ID
     * @return 结果
     */
	public int deleteTUserDriverInfoById(String id);
	
	/**
     * 批量删除驾驶员驾驶
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserDriverInfoByIds(String[] ids);
	
}