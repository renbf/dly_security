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
import com.project.web.mapper.TMessageMapper;
import com.project.web.domian.TMessage;
import com.project.web.service.ITMessageService;
import com.project.common.support.Convert;

/**
 * 消息 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TMessageServiceImpl implements ITMessageService 
{
	private static final Logger log = LoggerFactory.getLogger(TMessageServiceImpl.class);
	@Autowired
	@Qualifier("tMessageMapper")
	private TMessageMapper tMessageMapper;

	/**
     * 查询消息信息
     * 
     * @param id 消息ID
     * @return 消息信息
     */
    @Override
	public TMessage selectTMessageById(String id)
	{
	    return tMessageMapper.selectTMessageById(id);
	}
	
	/**
     * 查询消息列表
     * 
     * @param tMessage 消息信息
     * @return 消息集合
     */
	@Override
	public List<TMessage> selectTMessageList(TMessage tMessage)
	{
	    return tMessageMapper.selectTMessageList(tMessage);
	}
	
    /**
     * 新增消息
     * 
     * @param tMessage 消息信息
     * @return 结果
     */
	@Override
	public int insertTMessage(TMessage tMessage)
	{
		tMessage.setId(UUIDUtil.getUUID());
		tMessage.setCreateDate(new Date());
		tMessage.setAddUserId(ShiroUtils.getUserId().toString());
	    return tMessageMapper.insertTMessage(tMessage);
	}
	
	/**
     * 修改消息
     * 
     * @param tMessage 消息信息
     * @return 结果
     */
	@Override
	public int updateTMessage(TMessage tMessage)
	{
	    return tMessageMapper.updateTMessage(tMessage);
	}

	/**
     * 删除消息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTMessageByIds(String ids)
	{
		return tMessageMapper.deleteTMessageByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
