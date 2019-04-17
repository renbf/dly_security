package com.project.security.mapper;

import com.project.security.domain.TBusiness;
import java.util.List;	

/**
 * 企业管理 数据层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface TBusinessMapper 
{
	/**
     * 查询企业管理信息
     * 
     * @param id 企业管理ID
     * @return 企业管理信息
     */
	public TBusiness selectTBusinessById(String id);
	
	/**
     * 查询企业管理列表
     * 
     * @param tBusiness 企业管理信息
     * @return 企业管理集合
     */
	public List<TBusiness> selectTBusinessList(TBusiness tBusiness);
	
	/**
     * 新增企业管理
     * 
     * @param tBusiness 企业管理信息
     * @return 结果
     */
	public int insertTBusiness(TBusiness tBusiness);
	
	/**
     * 修改企业管理
     * 
     * @param tBusiness 企业管理信息
     * @return 结果
     */
	public int updateTBusiness(TBusiness tBusiness);
	
	/**
     * 删除企业管理
     * 
     * @param id 企业管理ID
     * @return 结果
     */
	public int deleteTBusinessById(String id);
	
	/**
     * 批量删除企业管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTBusinessByIds(String[] ids);
	//以上自动生成的尽量别动
}