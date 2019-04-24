package com.project.security.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.security.domain.TUserMessage;
import com.project.security.domain.vo.TUserMessageVo;	

/**
 * 用户消息 数据层
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Repository("userMessageMapper")
public interface TUserMessageMapper 
{
	/**
     * 查询用户消息信息
     * 
     * @param id 用户消息ID
     * @return 用户消息信息
     */
	public TUserMessage selectTUserMessageById(String id);
	
	/**
     * 查询用户消息列表
     * 
     * @param tUserMessage 用户消息信息
     * @return 用户消息集合
     */
	public List<TUserMessage> selectTUserMessageList(TUserMessage tUserMessage);
	
	/**
     * 新增用户消息
     * 
     * @param tUserMessage 用户消息信息
     * @return 结果
     */
	public int insertTUserMessage(TUserMessage tUserMessage);
	
	/**
     * 修改用户消息
     * 
     * @param tUserMessage 用户消息信息
     * @return 结果
     */
	public int updateTUserMessage(TUserMessage tUserMessage);
	
	/**
     * 删除用户消息
     * 
     * @param id 用户消息ID
     * @return 结果
     */
	public int deleteTUserMessageById(String id);
	
	/**
     * 批量删除用户消息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserMessageByIds(String[] ids);
	//以上自动生成的尽量别动
	
	/**
     * 查询用户消息列表
     * 
     * @param tUserMessage 用户消息信息
     * @return 用户消息集合
     */
	public List<TUserMessageVo> selectTUserMessageVos(TUserMessage tUserMessage);
	
	/**
     * 设为已读消息
     * 
     * @param tUserMessage 用户消息信息
     * @return 结果
     */
	public int updateTUserMessageByWhere(TUserMessage tUserMessage);
}