package com.project.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Date;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.project.web.mapper.TUserMessageMapper;
import com.project.web.domian.TUserMessage;
import com.project.web.service.ITUserMessageService;
import com.project.common.support.Convert;

/**
 * 用户消息 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TUserMessageServiceImpl implements ITUserMessageService 
{
	private static final Logger log = LoggerFactory.getLogger(TUserMessageServiceImpl.class);
	@Autowired
	@Qualifier("tUserMessageMapper")
	private TUserMessageMapper tUserMessageMapper;

	/**
     * 查询用户消息信息
     * 
     * @param id 用户消息ID
     * @return 用户消息信息
     */
    @Override
	public TUserMessage selectTUserMessageById(String id)
	{
	    return tUserMessageMapper.selectTUserMessageById(id);
	}
	
	/**
     * 查询用户消息列表
     * 
     * @param tUserMessage 用户消息信息
     * @return 用户消息集合
     */
	@Override
	public List<TUserMessage> selectTUserMessageList(TUserMessage tUserMessage)
	{
	    return tUserMessageMapper.selectTUserMessageList(tUserMessage);
	}
	
    /**
     * 新增用户消息
     * 
     * @param tUserMessage 用户消息信息
     * @return 结果
     */
	@Override
	public int insertTUserMessage(TUserMessage tUserMessage)
	{
		tUserMessage.setId(UUIDUtil.getUUID());
		tUserMessage.setCreateDate(new Date());
		tUserMessage.setAddUserId(ShiroUtils.getUserId().toString());
	    return tUserMessageMapper.insertTUserMessage(tUserMessage);
	}
	
	/**
     * 修改用户消息
     * 
     * @param tUserMessage 用户消息信息
     * @return 结果
     */
	@Override
	public int updateTUserMessage(TUserMessage tUserMessage)
	{
	    return tUserMessageMapper.updateTUserMessage(tUserMessage);
	}

	/**
     * 删除用户消息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTUserMessageByIds(String ids)
	{
		return tUserMessageMapper.deleteTUserMessageByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
