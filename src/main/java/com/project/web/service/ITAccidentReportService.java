package com.project.web.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.web.domian.TAccidentReport;

/**
 * 事故报告 服务层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface ITAccidentReportService 
{
	/**
     * 查询事故报告信息
     * 
     * @param id 事故报告ID
     * @return 事故报告信息
     */
	public TAccidentReport selectTAccidentReportById(String id);
	
	/**
     * 查询事故报告列表
     * 
     * @param tAccidentReport 事故报告信息
     * @return 事故报告集合
     */
	public List<TAccidentReport> selectTAccidentReportList(TAccidentReport tAccidentReport);
	
	/**
     * 新增事故报告
     * 
     * @param tAccidentReport 事故报告信息
     * @return 结果
     */
	public int insertTAccidentReport(TAccidentReport tAccidentReport);
	
	/**
     * 修改事故报告
     * 
     * @param tAccidentReport 事故报告信息
     * @return 结果
     */
	public int updateTAccidentReport(TAccidentReport tAccidentReport);
		
	/**
     * 删除事故报告信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTAccidentReportByIds(String ids);
	
}
