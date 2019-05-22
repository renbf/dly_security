package com.project.web.mapper;

import com.project.web.domian.TEarlyWarningReport;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 预警统计 数据层
 * 
 * @author rbf
 * @date 2019-05-14
 */
 @Repository("tEarlyWarningReportMapper")
public interface TEarlyWarningReportMapper 
{
	/**
     * 查询预警统计信息
     * 
     * @param id 预警统计ID
     * @return 预警统计信息
     */
	public TEarlyWarningReport selectTEarlyWarningReportById(String id);
	
	/**
     * 查询预警统计列表
     * 
     * @param tEarlyWarningReport 预警统计信息
     * @return 预警统计集合
     */
	public List<TEarlyWarningReport> selectTEarlyWarningReportList(TEarlyWarningReport tEarlyWarningReport);
	
	/**
     * 新增预警统计
     * 
     * @param tEarlyWarningReport 预警统计信息
     * @return 结果
     */
	public int insertTEarlyWarningReport(TEarlyWarningReport tEarlyWarningReport);
	
	/**
     * 修改预警统计
     * 
     * @param tEarlyWarningReport 预警统计信息
     * @return 结果
     */
	public int updateTEarlyWarningReport(TEarlyWarningReport tEarlyWarningReport);
	
	/**
     * 删除预警统计
     * 
     * @param id 预警统计ID
     * @return 结果
     */
	public int deleteTEarlyWarningReportById(String id);
	
	/**
     * 批量删除预警统计
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTEarlyWarningReportByIds(String[] ids);
	//以上自动生成的尽量别动


	/**
	 * 查询所有预警的sql
	 * @return
	 */
	public List<TEarlyWarningReport> selectEarlyWarningTask();

	/**
	 * 查询所有预警的sql
	 * @return
	 */
	public List<TEarlyWarningReport> selectEarlyWarningOverTask();
	
	public List<TEarlyWarningReport> selectEarlyWarningSolveInfo();
	
	/**
     * 修改预警统计
     * 
     * @param tEarlyWarningReport 预警统计信息
     * @return 结果
     */
	public int updateTEarlyWarningReportByFactor();
	
}