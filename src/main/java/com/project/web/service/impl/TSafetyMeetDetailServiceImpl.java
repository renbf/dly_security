package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TSafetyMeetDetail;
import com.project.web.mapper.TSafetyMeetDetailMapper;
import com.project.web.service.ITSafetyMeetDetailService;

/**
 * 安全会议详细 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TSafetyMeetDetailServiceImpl implements ITSafetyMeetDetailService 
{
	@Autowired
	private TSafetyMeetDetailMapper tSafetyMeetDetailMapper;

	/**
     * 查询安全会议详细信息
     * 
     * @param id 安全会议详细ID
     * @return 安全会议详细信息
     */
    @Override
	public TSafetyMeetDetail selectTSafetyMeetDetailById(String id)
	{
	    return tSafetyMeetDetailMapper.selectTSafetyMeetDetailById(id);
	}
	
	/**
     * 查询安全会议详细列表
     * 
     * @param tSafetyMeetDetail 安全会议详细信息
     * @return 安全会议详细集合
     */
	@Override
	public List<TSafetyMeetDetail> selectTSafetyMeetDetailList(TSafetyMeetDetail tSafetyMeetDetail)
	{
	    return tSafetyMeetDetailMapper.selectTSafetyMeetDetailList(tSafetyMeetDetail);
	}
	
    /**
     * 新增安全会议详细
     * 
     * @param tSafetyMeetDetail 安全会议详细信息
     * @return 结果
     */
	@Override
	public int insertTSafetyMeetDetail(TSafetyMeetDetail tSafetyMeetDetail)
	{
		tSafetyMeetDetail.setId(UUIDUtil.getUUID());
		tSafetyMeetDetail.setCreateTime(new Date());
		return tSafetyMeetDetailMapper.insertTSafetyMeetDetail(tSafetyMeetDetail);
	}
	
	/**
     * 修改安全会议详细
     * 
     * @param tSafetyMeetDetail 安全会议详细信息
     * @return 结果
     */
	@Override
	public int updateTSafetyMeetDetail(TSafetyMeetDetail tSafetyMeetDetail)
	{
	    return tSafetyMeetDetailMapper.updateTSafetyMeetDetail(tSafetyMeetDetail);
	}

	/**
     * 删除安全会议详细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTSafetyMeetDetailByIds(String ids)
	{
		return tSafetyMeetDetailMapper.deleteTSafetyMeetDetailByIds(Convert.toStrArray(ids));
	}
	
}
