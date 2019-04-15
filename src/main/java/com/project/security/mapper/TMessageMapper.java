package com.project.security.mapper;

import com.project.security.domain.TMessage;
import java.util.List;	

/**
 * 用户消息 数据层
 * 
 * @author rbf
 * @date 2019-04-15
 */
public interface TMessageMapper 
{
	/**
     * 查询用户消息信息
     * 
     * @param id 用户消息ID
     * @return 用户消息信息
     */
	public TMessage selectTMessageById(String id);
	
	/**
     * 查询用户消息列表
     * 
     * @param tMessage 用户消息信息
     * @return 用户消息集合
     */
	public List<TMessage> selectTMessageList(TMessage tMessage);
	
	/**
     * 新增用户消息
     * 
     * @param tMessage 用户消息信息
     * @return 结果
     */
	public int insertTMessage(TMessage tMessage);
	
	/**
     * 修改用户消息
     * 
     * @param tMessage 用户消息信息
     * @return 结果
     */
	public int updateTMessage(TMessage tMessage);
	
	/**
     * 删除用户消息
     * 
     * @param id 用户消息ID
     * @return 结果
     */
	public int deleteTMessageById(String id);
	
	/**
     * 批量删除用户消息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTMessageByIds(String[] ids);
	//以上自动生成的尽量别动
}