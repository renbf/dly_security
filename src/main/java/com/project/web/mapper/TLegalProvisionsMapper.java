package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TLegalProvisions;


/**
 * 法律法规 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface TLegalProvisionsMapper 
{
	/**
     * 查询法律法规信息
     * 
     * @param id 法律法规ID
     * @return 法律法规信息
     */
	public TLegalProvisions selectTLegalProvisionsById(String id);
	
	/**
     * 查询法律法规列表
     * 
     * @param tLegalProvisions 法律法规信息
     * @return 法律法规集合
     */
	public List<TLegalProvisions> selectTLegalProvisionsList(TLegalProvisions tLegalProvisions);
	
	/**
     * 新增法律法规
     * 
     * @param tLegalProvisions 法律法规信息
     * @return 结果
     */
	public int insertTLegalProvisions(TLegalProvisions tLegalProvisions);
	
	/**
     * 修改法律法规
     * 
     * @param tLegalProvisions 法律法规信息
     * @return 结果
     */
	public int updateTLegalProvisions(TLegalProvisions tLegalProvisions);
	
	/**
     * 删除法律法规
     * 
     * @param id 法律法规ID
     * @return 结果
     */
	public int deleteTLegalProvisionsById(String id);
	
	/**
     * 批量删除法律法规
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTLegalProvisionsByIds(String[] ids);
	
}