package com.project.security.mapper;

import com.project.security.domain.TMessage;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 消息 数据层
 * 
 * @author rbf
 * @date 2019-04-24
 */
 @Repository("messageMapper")
public interface TMessageMapper 
{
	/**
     * 查询消息信息
     * 
     * @param id 消息ID
     * @return 消息信息
     */
	public TMessage selectTMessageById(String id);
	
	/**
     * 查询消息列表
     * 
     * @param tMessage 消息信息
     * @return 消息集合
     */
	public List<TMessage> selectTMessageList(TMessage tMessage);
	
	/**
     * 新增消息
     * 
     * @param tMessage 消息信息
     * @return 结果
     */
	public int insertTMessage(TMessage tMessage);
	
	/**
     * 修改消息
     * 
     * @param tMessage 消息信息
     * @return 结果
     */
	public int updateTMessage(TMessage tMessage);
	
	/**
     * 删除消息
     * 
     * @param id 消息ID
     * @return 结果
     */
	public int deleteTMessageById(String id);
	
	/**
     * 批量删除消息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTMessageByIds(String[] ids);
	//以上自动生成的尽量别动
}