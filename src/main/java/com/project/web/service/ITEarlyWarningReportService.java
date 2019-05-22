package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TEarlyWarningReport;
import java.util.List;

/**
 * 预警统计 服务层
 * 
 * @author rbf
 * @date 2019-05-14
 */
public interface ITEarlyWarningReportService 
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
     * 删除预警统计信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTEarlyWarningReportByIds(String ids);

    void task();
    //以上自动生成的尽量别动
    void taskOver();

    AjaxResult selectDangerWarningSum(TEarlyWarningReport tEarlyWarningReport);
}
