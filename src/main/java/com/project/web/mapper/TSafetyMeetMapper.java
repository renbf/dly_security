package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TSafetyMeet;	

/**
 * 安全会议 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface TSafetyMeetMapper 
{
	/**
     * 查询安全会议信息
     * 
     * @param id 安全会议ID
     * @return 安全会议信息
     */
	public TSafetyMeet selectTSafetyMeetById(String id);
	
	/**
     * 查询安全会议列表
     * 
     * @param tSafetyMeet 安全会议信息
     * @return 安全会议集合
     */
	public List<TSafetyMeet> selectTSafetyMeetList(TSafetyMeet tSafetyMeet);
	
	/**
     * 新增安全会议
     * 
     * @param tSafetyMeet 安全会议信息
     * @return 结果
     */
	public int insertTSafetyMeet(TSafetyMeet tSafetyMeet);
	
	/**
     * 修改安全会议
     * 
     * @param tSafetyMeet 安全会议信息
     * @return 结果
     */
	public int updateTSafetyMeet(TSafetyMeet tSafetyMeet);
	
	/**
     * 删除安全会议
     * 
     * @param id 安全会议ID
     * @return 结果
     */
	public int deleteTSafetyMeetById(String id);
	
	/**
     * 批量删除安全会议
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSafetyMeetByIds(String[] ids);
	
}