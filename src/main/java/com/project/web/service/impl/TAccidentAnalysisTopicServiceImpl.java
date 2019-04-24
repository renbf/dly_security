package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TAccidentAnalysisTopic;
import com.project.web.mapper.TAccidentAnalysisTopicMapper;
import com.project.web.service.ITAccidentAnalysisTopicService;

/**
 * 事故分析专题会议 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TAccidentAnalysisTopicServiceImpl implements ITAccidentAnalysisTopicService 
{
	@Autowired
	private TAccidentAnalysisTopicMapper tAccidentAnalysisTopicMapper;

	/**
     * 查询事故分析专题会议信息
     * 
     * @param id 事故分析专题会议ID
     * @return 事故分析专题会议信息
     */
    @Override
	public TAccidentAnalysisTopic selectTAccidentAnalysisTopicById(String id)
	{
	    return tAccidentAnalysisTopicMapper.selectTAccidentAnalysisTopicById(id);
	}
	
	/**
     * 查询事故分析专题会议列表
     * 
     * @param tAccidentAnalysisTopic 事故分析专题会议信息
     * @return 事故分析专题会议集合
     */
	@Override
	public List<TAccidentAnalysisTopic> selectTAccidentAnalysisTopicList(TAccidentAnalysisTopic tAccidentAnalysisTopic)
	{
	    return tAccidentAnalysisTopicMapper.selectTAccidentAnalysisTopicList(tAccidentAnalysisTopic);
	}
	
    /**
     * 新增事故分析专题会议
     * 
     * @param tAccidentAnalysisTopic 事故分析专题会议信息
     * @return 结果
     */
	@Override
	public int insertTAccidentAnalysisTopic(TAccidentAnalysisTopic tAccidentAnalysisTopic)
	{
		tAccidentAnalysisTopic.setId(UUIDUtil.getUUID());
		tAccidentAnalysisTopic.setCreateTime(new Date());
		tAccidentAnalysisTopic.setUserId(ShiroUtils.getUserId());
	    return tAccidentAnalysisTopicMapper.insertTAccidentAnalysisTopic(tAccidentAnalysisTopic);
	}
	
	/**
     * 修改事故分析专题会议
     * 
     * @param tAccidentAnalysisTopic 事故分析专题会议信息
     * @return 结果
     */
	@Override
	public int updateTAccidentAnalysisTopic(TAccidentAnalysisTopic tAccidentAnalysisTopic)
	{
		tAccidentAnalysisTopic.setUpdateTime(new Date());
		tAccidentAnalysisTopic.setUpdateUserId(ShiroUtils.getUserId());
	    return tAccidentAnalysisTopicMapper.updateTAccidentAnalysisTopic(tAccidentAnalysisTopic);
	}

	/**
     * 删除事故分析专题会议对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTAccidentAnalysisTopicByIds(String ids)
	{
		return tAccidentAnalysisTopicMapper.deleteTAccidentAnalysisTopicByIds(Convert.toStrArray(ids));
	}
	
}
