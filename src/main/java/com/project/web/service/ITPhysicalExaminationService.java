package com.project.web.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TPhysicalExamination;

/**
 * 体检记录 服务层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface ITPhysicalExaminationService 
{
	/**
     * 查询体检记录信息
     * 
     * @param id 体检记录ID
     * @return 体检记录信息
     */
	public TPhysicalExamination selectTPhysicalExaminationById(Long id);
	
	/**
     * 查询体检记录列表
     * 
     * @param tPhysicalExamination 体检记录信息
     * @return 体检记录集合
     */
	public List<TPhysicalExamination> selectTPhysicalExaminationList(TPhysicalExamination tPhysicalExamination);
	
	/**
     * 新增体检记录
     * 
     * @param tPhysicalExamination 体检记录信息
     * @return 结果
     */
	public AjaxResult insertTPhysicalExamination(TPhysicalExamination tPhysicalExamination,MultipartFile physicalFile);
	
	/**
     * 修改体检记录
     * 
     * @param tPhysicalExamination 体检记录信息
     * @return 结果
     */
	public AjaxResult updateTPhysicalExamination(TPhysicalExamination tPhysicalExamination,MultipartFile physicalFile);
		
	/**
     * 删除体检记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTPhysicalExaminationByIds(String ids);
	
}

