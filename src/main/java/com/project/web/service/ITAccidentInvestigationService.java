package com.project.web.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.web.domian.TAccidentInvestigation;

/**
 * 事故调查 服务层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface ITAccidentInvestigationService 
{
	/**
     * 查询事故调查信息
     * 
     * @param id 事故调查ID
     * @return 事故调查信息
     */
	public TAccidentInvestigation selectTAccidentInvestigationById(String id);
	
	/**
     * 查询事故调查列表
     * 
     * @param tAccidentInvestigation 事故调查信息
     * @return 事故调查集合
     */
	public List<TAccidentInvestigation> selectTAccidentInvestigationList(TAccidentInvestigation tAccidentInvestigation);
	
	/**
     * 新增事故调查
     * 
     * @param tAccidentInvestigation 事故调查信息
     * @return 结果
     */
	public int insertTAccidentInvestigation(TAccidentInvestigation tAccidentInvestigation,MultipartFile accidentInvestigationFile);
	
	/**
     * 修改事故调查
     * 
     * @param tAccidentInvestigation 事故调查信息
     * @return 结果
     */
	public int updateTAccidentInvestigation(TAccidentInvestigation tAccidentInvestigation,MultipartFile accidentInvestigationFile);
		
	/**
     * 删除事故调查信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTAccidentInvestigationByIds(String ids);
	
}
