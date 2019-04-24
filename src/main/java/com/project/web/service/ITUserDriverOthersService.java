package com.project.web.service;

import java.util.List;

import com.project.web.domian.TUserDriverOthers;

/**
 * 驾驶员其他 服务层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface ITUserDriverOthersService 
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
     * 删除驾驶员其他信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserDriverOthersByIds(String ids);
	
}
