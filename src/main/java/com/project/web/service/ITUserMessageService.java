package com.project.web.service;

import com.project.web.domian.TUserMessage;
import java.util.List;

/**
 * 用户消息 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITUserMessageService 
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
     * 删除用户消息信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserMessageByIds(String ids);
	//以上自动生成的尽量别动
}
