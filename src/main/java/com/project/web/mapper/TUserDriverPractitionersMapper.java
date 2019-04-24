package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TUserDriverPractitioners;	

/**
 * 驾驶员从业资格证 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface TUserDriverPractitionersMapper 
{
	/**
     * 查询驾驶员从业资格证信息
     * 
     * @param id 驾驶员从业资格证ID
     * @return 驾驶员从业资格证信息
     */
	public TUserDriverPractitioners selectTUserDriverPractitionersById(String id);
	
	/**
     * 查询驾驶员从业资格证列表
     * 
     * @param tUserDriverPractitioners 驾驶员从业资格证信息
     * @return 驾驶员从业资格证集合
     */
	public List<TUserDriverPractitioners> selectTUserDriverPractitionersList(TUserDriverPractitioners tUserDriverPractitioners);
	
	/**
     * 新增驾驶员从业资格证
     * 
     * @param tUserDriverPractitioners 驾驶员从业资格证信息
     * @return 结果
     */
	public int insertTUserDriverPractitioners(TUserDriverPractitioners tUserDriverPractitioners);
	
	/**
     * 修改驾驶员从业资格证
     * 
     * @param tUserDriverPractitioners 驾驶员从业资格证信息
     * @return 结果
     */
	public int updateTUserDriverPractitioners(TUserDriverPractitioners tUserDriverPractitioners);
	
	/**
     * 删除驾驶员从业资格证
     * 
     * @param id 驾驶员从业资格证ID
     * @return 结果
     */
	public int deleteTUserDriverPractitionersById(String id);
	
	/**
     * 批量删除驾驶员从业资格证
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserDriverPractitionersByIds(String[] ids);
	
}