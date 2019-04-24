package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TRelevantMessage;
import com.project.web.mapper.TRelevantMessageMapper;
import com.project.web.service.ITRelevantMessageService;

/**
 * 相关方 服务层实现
 * 
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TRelevantMessageServiceImpl implements ITRelevantMessageService 
{
	@Autowired
	private TRelevantMessageMapper tRelevantMessageMapper;

	/**
     * 查询相关方信息
     * 
     * @param id 相关方ID
     * @return 相关方信息
     */
    @Override
	public TRelevantMessage selectTRelevantMessageById(Long id)
	{
	    return tRelevantMessageMapper.selectTRelevantMessageById(id);
	}
	
	/**
     * 查询相关方列表
     * 
     * @param tRelevantMessage 相关方信息
     * @return 相关方集合
     */
	@Override
	public List<TRelevantMessage> selectTRelevantMessageList(TRelevantMessage tRelevantMessage)
	{
	    return tRelevantMessageMapper.selectTRelevantMessageList(tRelevantMessage);
	}
	
    /**
     * 新增相关方
     * 
     * @param tRelevantMessage 相关方信息
     * @return 结果
     */
	@Override
	public int insertTRelevantMessage(TRelevantMessage tRelevantMessage)
	{
		tRelevantMessage.setId(UUIDUtil.getUUID());
		tRelevantMessage.setCreateTime(new Date());
		return tRelevantMessageMapper.insertTRelevantMessage(tRelevantMessage);
	}
	
	/**
     * 修改相关方
     * 
     * @param tRelevantMessage 相关方信息
     * @return 结果
     */
	@Override
	public int updateTRelevantMessage(TRelevantMessage tRelevantMessage)
	{
	    return tRelevantMessageMapper.updateTRelevantMessage(tRelevantMessage);
	}

	/**
     * 删除相关方对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTRelevantMessageByIds(String ids)
	{
		return tRelevantMessageMapper.deleteTRelevantMessageByIds(Convert.toStrArray(ids));
	}
	
}
