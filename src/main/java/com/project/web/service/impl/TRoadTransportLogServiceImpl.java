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
import com.project.web.mapper.TRoadTransportLogMapper;
import com.project.web.domian.TRoadTransportLog;
import com.project.web.service.ITRoadTransportLogService;
import com.project.common.support.Convert;

/**
 * 道路运输证变更 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TRoadTransportLogServiceImpl implements ITRoadTransportLogService 
{
	private static final Logger log = LoggerFactory.getLogger(TRoadTransportLogServiceImpl.class);
	@Autowired
	@Qualifier("tRoadTransportLogMapper")
	private TRoadTransportLogMapper tRoadTransportLogMapper;

	/**
     * 查询道路运输证变更信息
     * 
     * @param id 道路运输证变更ID
     * @return 道路运输证变更信息
     */
    @Override
	public TRoadTransportLog selectTRoadTransportLogById(String id)
	{
	    return tRoadTransportLogMapper.selectTRoadTransportLogById(id);
	}
	
	/**
     * 查询道路运输证变更列表
     * 
     * @param tRoadTransportLog 道路运输证变更信息
     * @return 道路运输证变更集合
     */
	@Override
	public List<TRoadTransportLog> selectTRoadTransportLogList(TRoadTransportLog tRoadTransportLog)
	{
	    return tRoadTransportLogMapper.selectTRoadTransportLogList(tRoadTransportLog);
	}
	
    /**
     * 新增道路运输证变更
     * 
     * @param tRoadTransportLog 道路运输证变更信息
     * @return 结果
     */
	@Override
	public int insertTRoadTransportLog(TRoadTransportLog tRoadTransportLog)
	{
		tRoadTransportLog.setId(UUIDUtil.getUUID());
	    return tRoadTransportLogMapper.insertTRoadTransportLog(tRoadTransportLog);
	}
	
	/**
     * 修改道路运输证变更
     * 
     * @param tRoadTransportLog 道路运输证变更信息
     * @return 结果
     */
	@Override
	public int updateTRoadTransportLog(TRoadTransportLog tRoadTransportLog)
	{
	    return tRoadTransportLogMapper.updateTRoadTransportLog(tRoadTransportLog);
	}

	/**
     * 删除道路运输证变更对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTRoadTransportLogByIds(String ids)
	{
		return tRoadTransportLogMapper.deleteTRoadTransportLogByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
