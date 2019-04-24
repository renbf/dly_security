package com.project.web.service;

import java.util.List;

import com.project.web.domian.TAccidentAnalysisTopic;

/**
 * 事故分析专题会议 服务层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface ITAccidentAnalysisTopicService 
{
	/**
     * 查询事故分析专题会议信息
     * 
     * @param id 事故分析专题会议ID
     * @return 事故分析专题会议信息
     */
	public TAccidentAnalysisTopic selectTAccidentAnalysisTopicById(String id);
	
	/**
     * 查询事故分析专题会议列表
     * 
     * @param tAccidentAnalysisTopic 事故分析专题会议信息
     * @return 事故分析专题会议集合
     */
	public List<TAccidentAnalysisTopic> selectTAccidentAnalysisTopicList(TAccidentAnalysisTopic tAccidentAnalysisTopic);
	
	/**
     * 新增事故分析专题会议
     * 
     * @param tAccidentAnalysisTopic 事故分析专题会议信息
     * @return 结果
     */
	public int insertTAccidentAnalysisTopic(TAccidentAnalysisTopic tAccidentAnalysisTopic);
	
	/**
     * 修改事故分析专题会议
     * 
     * @param tAccidentAnalysisTopic 事故分析专题会议信息
     * @return 结果
     */
	public int updateTAccidentAnalysisTopic(TAccidentAnalysisTopic tAccidentAnalysisTopic);
		
	/**
     * 删除事故分析专题会议信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTAccidentAnalysisTopicByIds(String ids);
	
}
