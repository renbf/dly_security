package com.project.web.mapper;

import java.util.List;

import com.project.web.domian.TRelevantMessage;	

/**
 * 相关方 数据层
 * 
 * @author rbf
 * @date 2019-04-16
 */
public interface TRelevantMessageMapper 
{
	/**
     * 查询相关方信息
     * 
     * @param id 相关方ID
     * @return 相关方信息
     */
	public TRelevantMessage selectTRelevantMessageById(Long id);
	
	/**
     * 查询相关方列表
     * 
     * @param tRelevantMessage 相关方信息
     * @return 相关方集合
     */
	public List<TRelevantMessage> selectTRelevantMessageList(TRelevantMessage tRelevantMessage);
	
	/**
     * 新增相关方
     * 
     * @param tRelevantMessage 相关方信息
     * @return 结果
     */
	public int insertTRelevantMessage(TRelevantMessage tRelevantMessage);
	
	/**
     * 修改相关方
     * 
     * @param tRelevantMessage 相关方信息
     * @return 结果
     */
	public int updateTRelevantMessage(TRelevantMessage tRelevantMessage);
	
	/**
     * 删除相关方
     * 
     * @param id 相关方ID
     * @return 结果
     */
	public int deleteTRelevantMessageById(Long id);
	
	/**
     * 批量删除相关方
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTRelevantMessageByIds(String[] ids);
	
}