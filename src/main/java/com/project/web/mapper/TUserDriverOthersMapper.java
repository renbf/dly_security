package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TUserDriverOthers;	

/**
 * 驾驶员其他 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface TUserDriverOthersMapper 
{
	/**
     * 查询驾驶员其他信息
     * 
     * @param id 驾驶员其他ID
     * @return 驾驶员其他信息
     */
	public TUserDriverOthers selectTUserDriverOthersById(String id);
	
	/**
     * 查询驾驶员其他列表
     * 
     * @param tUserDriverOthers 驾驶员其他信息
     * @return 驾驶员其他集合
     */
	public List<TUserDriverOthers> selectTUserDriverOthersList(TUserDriverOthers tUserDriverOthers);
	
	/**
     * 新增驾驶员其他
     * 
     * @param tUserDriverOthers 驾驶员其他信息
     * @return 结果
     */
	public int insertTUserDriverOthers(TUserDriverOthers tUserDriverOthers);
	
	/**
     * 修改驾驶员其他
     * 
     * @param tUserDriverOthers 驾驶员其他信息
     * @return 结果
     */
	public int updateTUserDriverOthers(TUserDriverOthers tUserDriverOthers);
	
	/**
     * 删除驾驶员其他
     * 
     * @param id 驾驶员其他ID
     * @return 结果
     */
	public int deleteTUserDriverOthersById(String id);
	
	/**
     * 批量删除驾驶员其他
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserDriverOthersByIds(String[] ids);
	
}