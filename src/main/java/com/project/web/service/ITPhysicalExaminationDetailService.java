package com.project.web.service;

import java.util.List;

import com.project.web.domian.TPhysicalExaminationDetail;

/**
 * 体检记录明细 服务层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface ITPhysicalExaminationDetailService 
{
	/**
     * 查询体检记录明细信息
     * 
     * @param id 体检记录明细ID
     * @return 体检记录明细信息
     */
	public TPhysicalExaminationDetail selectTPhysicalExaminationDetailById(String id);
	
	/**
     * 查询体检记录明细列表
     * 
     * @param tPhysicalExaminationDetail 体检记录明细信息
     * @return 体检记录明细集合
     */
	public List<TPhysicalExaminationDetail> selectTPhysicalExaminationDetailList(TPhysicalExaminationDetail tPhysicalExaminationDetail);
	
	/**
     *	根据体检表主键查询体检记录明细列表
     * 
     * @param tPhysicalExaminationDetail 体检记录明细信息
     * @return 体检记录明细集合
     */
	public List<TPhysicalExaminationDetail> selectTPhysicalExaminationDetailListById(TPhysicalExaminationDetail tPhysicalExaminationDetail);
	
	
	/**
     * 新增体检记录明细
     * 
     * @param tPhysicalExaminationDetail 体检记录明细信息
     * @return 结果
     */
	public int insertTPhysicalExaminationDetail(TPhysicalExaminationDetail tPhysicalExaminationDetail);
	
	/**
     * 修改体检记录明细
     * 
     * @param tPhysicalExaminationDetail 体检记录明细信息
     * @return 结果
     */
	public int updateTPhysicalExaminationDetail(TPhysicalExaminationDetail tPhysicalExaminationDetail);
		
	/**
     * 删除体检记录明细信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTPhysicalExaminationDetailByIds(String ids);
	
	/**
     * 删除体检记录明细信息
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
	public int deleteTPhysicalExaminationDetailByexaminationIds(String examinationId);
	
}

