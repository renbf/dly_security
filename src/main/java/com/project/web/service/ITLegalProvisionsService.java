package com.project.web.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TLegalProvisions;

/**
 * 法律法规 服务层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface ITLegalProvisionsService 
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
	public AjaxResult insertTLegalProvisions(TLegalProvisions tLegalProvisions,MultipartFile legalFile);
	
	/**
     * 修改法律法规
     * 
     * @param tLegalProvisions 法律法规信息
     * @return 结果
     */
	public AjaxResult updateTLegalProvisions(TLegalProvisions tLegalProvisions,MultipartFile legalFile);
		
	/**
     * 删除法律法规信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTLegalProvisionsByIds(String ids);
	
}
