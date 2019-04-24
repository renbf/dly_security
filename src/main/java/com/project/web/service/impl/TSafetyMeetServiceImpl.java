package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TSafetyMeet;
import com.project.web.mapper.TSafetyMeetMapper;
import com.project.web.service.ITSafetyMeetService;

/**
 * 安全会议 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TSafetyMeetServiceImpl implements ITSafetyMeetService 
{
	@Autowired
	private TSafetyMeetMapper tSafetyMeetMapper;

	/**
     * 查询安全会议信息
     * 
     * @param id 安全会议ID
     * @return 安全会议信息
     */
    @Override
	public TSafetyMeet selectTSafetyMeetById(String id)
	{
	    return tSafetyMeetMapper.selectTSafetyMeetById(id);
	}
	
	/**
     * 查询安全会议列表
     * 
     * @param tSafetyMeet 安全会议信息
     * @return 安全会议集合
     */
	@Override
	public List<TSafetyMeet> selectTSafetyMeetList(TSafetyMeet tSafetyMeet)
	{
	    return tSafetyMeetMapper.selectTSafetyMeetList(tSafetyMeet);
	}
	
    /**
     * 新增安全会议
     * 
     * @param tSafetyMeet 安全会议信息
     * @return 结果
     */
	@Override
	public int insertTSafetyMeet(TSafetyMeet tSafetyMeet)
	{
		tSafetyMeet.setId(UUIDUtil.getUUID());
		tSafetyMeet.setCreateTime(new Date());
		return tSafetyMeetMapper.insertTSafetyMeet(tSafetyMeet);
	}
	
	/**
     * 修改安全会议
     * 
     * @param tSafetyMeet 安全会议信息
     * @return 结果
     */
	@Override
	public int updateTSafetyMeet(TSafetyMeet tSafetyMeet)
	{
	    return tSafetyMeetMapper.updateTSafetyMeet(tSafetyMeet);
	}

	/**
     * 删除安全会议对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTSafetyMeetByIds(String ids)
	{
		return tSafetyMeetMapper.deleteTSafetyMeetByIds(Convert.toStrArray(ids));
	}
	
}
