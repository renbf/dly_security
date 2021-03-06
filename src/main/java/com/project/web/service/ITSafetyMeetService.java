package com.project.web.service;

import java.util.List;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TSafetyMeet;
import org.springframework.web.multipart.MultipartFile;

/**
 * 安全会议 服务层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface ITSafetyMeetService 
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
	public AjaxResult insertTSafetyMeet(TSafetyMeet tSafetyMeet, MultipartFile meetFile);
	
	/**
     * 修改安全会议
     * 
     * @param tSafetyMeet 安全会议信息
     * @return 结果
     */
	public AjaxResult updateTSafetyMeet(TSafetyMeet tSafetyMeet,MultipartFile meetFile);
		
	/**
     * 删除安全会议信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTSafetyMeetByIds(String ids);
	
}
