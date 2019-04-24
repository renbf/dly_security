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
import com.project.web.mapper.TDriverBeforeLogMapper;
import com.project.web.domian.TDriverBeforeLog;
import com.project.web.service.ITDriverBeforeLogService;
import com.project.common.support.Convert;

/**
 * 行车前检查事项 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TDriverBeforeLogServiceImpl implements ITDriverBeforeLogService 
{
	private static final Logger log = LoggerFactory.getLogger(TDriverBeforeLogServiceImpl.class);
	@Autowired
	@Qualifier("tDriverBeforeLogMapper")
	private TDriverBeforeLogMapper tDriverBeforeLogMapper;

	/**
     * 查询行车前检查事项信息
     * 
     * @param driverLogId 行车前检查事项ID
     * @return 行车前检查事项信息
     */
    @Override
	public TDriverBeforeLog selectTDriverBeforeLogById(String driverLogId)
	{
	    return tDriverBeforeLogMapper.selectTDriverBeforeLogById(driverLogId);
	}
	
	/**
     * 查询行车前检查事项列表
     * 
     * @param tDriverBeforeLog 行车前检查事项信息
     * @return 行车前检查事项集合
     */
	@Override
	public List<TDriverBeforeLog> selectTDriverBeforeLogList(TDriverBeforeLog tDriverBeforeLog)
	{
	    return tDriverBeforeLogMapper.selectTDriverBeforeLogList(tDriverBeforeLog);
	}
	
    /**
     * 新增行车前检查事项
     * 
     * @param tDriverBeforeLog 行车前检查事项信息
     * @return 结果
     */
	@Override
	public int insertTDriverBeforeLog(TDriverBeforeLog tDriverBeforeLog)
	{
		tDriverBeforeLog.setCreateDate(new Date());
		tDriverBeforeLog.setAddUserId(ShiroUtils.getUserId().toString());
	    return tDriverBeforeLogMapper.insertTDriverBeforeLog(tDriverBeforeLog);
	}
	
	/**
     * 修改行车前检查事项
     * 
     * @param tDriverBeforeLog 行车前检查事项信息
     * @return 结果
     */
	@Override
	public int updateTDriverBeforeLog(TDriverBeforeLog tDriverBeforeLog)
	{
	    return tDriverBeforeLogMapper.updateTDriverBeforeLog(tDriverBeforeLog);
	}

	/**
     * 删除行车前检查事项对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTDriverBeforeLogByIds(String ids)
	{
		return tDriverBeforeLogMapper.deleteTDriverBeforeLogByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
