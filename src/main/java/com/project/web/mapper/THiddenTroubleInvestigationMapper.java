package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.THiddenTroubleInvestigation;	

/**
 * 隐患排查 数据层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface THiddenTroubleInvestigationMapper 
{
	/**
     * 查询隐患排查信息
     * 
     * @param id 隐患排查ID
     * @return 隐患排查信息
     */
	public THiddenTroubleInvestigation selectTHiddenTroubleInvestigationById(String id);
	
	/**
     * 查询隐患排查列表
     * 
     * @param tHiddenTroubleInvestigation 隐患排查信息
     * @return 隐患排查集合
     */
	public List<THiddenTroubleInvestigation> selectTHiddenTroubleInvestigationList(THiddenTroubleInvestigation tHiddenTroubleInvestigation);
	
	/**
     * 新增隐患排查
     * 
     * @param tHiddenTroubleInvestigation 隐患排查信息
     * @return 结果
     */
	public int insertTHiddenTroubleInvestigation(THiddenTroubleInvestigation tHiddenTroubleInvestigation);
	
	/**
     * 修改隐患排查
     * 
     * @param tHiddenTroubleInvestigation 隐患排查信息
     * @return 结果
     */
	public int updateTHiddenTroubleInvestigation(THiddenTroubleInvestigation tHiddenTroubleInvestigation);
	
	/**
     * 删除隐患排查
     * 
     * @param id 隐患排查ID
     * @return 结果
     */
	public int deleteTHiddenTroubleInvestigationById(String id);
	
	/**
     * 批量删除隐患排查
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTHiddenTroubleInvestigationByIds(String[] ids);
	
}