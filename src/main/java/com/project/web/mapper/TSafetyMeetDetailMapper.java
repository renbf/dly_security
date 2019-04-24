package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TSafetyMeetDetail;	

/**
 * 安全会议详细 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface TSafetyMeetDetailMapper 
{
	/**
     * 查询安全会议详细信息
     * 
     * @param id 安全会议详细ID
     * @return 安全会议详细信息
     */
	public TSafetyMeetDetail selectTSafetyMeetDetailById(String id);
	
	/**
     * 查询安全会议详细列表
     * 
     * @param tSafetyMeetDetail 安全会议详细信息
     * @return 安全会议详细集合
     */
	public List<TSafetyMeetDetail> selectTSafetyMeetDetailList(TSafetyMeetDetail tSafetyMeetDetail);
	
	/**
     * 新增安全会议详细
     * 
     * @param tSafetyMeetDetail 安全会议详细信息
     * @return 结果
     */
	public int insertTSafetyMeetDetail(TSafetyMeetDetail tSafetyMeetDetail);
	
	/**
     * 修改安全会议详细
     * 
     * @param tSafetyMeetDetail 安全会议详细信息
     * @return 结果
     */
	public int updateTSafetyMeetDetail(TSafetyMeetDetail tSafetyMeetDetail);
	
	/**
     * 删除安全会议详细
     * 
     * @param id 安全会议详细ID
     * @return 结果
     */
	public int deleteTSafetyMeetDetailById(String id);
	
	/**
     * 批量删除安全会议详细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSafetyMeetDetailByIds(String[] ids);
	
}