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
import com.project.web.mapper.TDriverAfterLogMapper;
import com.project.web.domian.TDriverAfterLog;
import com.project.web.service.ITDriverAfterLogService;
import com.project.common.support.Convert;

/**
 * 行车后检查事项 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TDriverAfterLogServiceImpl implements ITDriverAfterLogService 
{
	private static final Logger log = LoggerFactory.getLogger(TDriverAfterLogServiceImpl.class);
	@Autowired
	@Qualifier("tDriverAfterLogMapper")
	private TDriverAfterLogMapper tDriverAfterLogMapper;

	/**
     * 查询行车后检查事项信息
     * 
     * @param driverLogId 行车后检查事项ID
     * @return 行车后检查事项信息
     */
    @Override
	public TDriverAfterLog selectTDriverAfterLogById(String driverLogId)
	{
	    return tDriverAfterLogMapper.selectTDriverAfterLogById(driverLogId);
	}
	
	/**
     * 查询行车后检查事项列表
     * 
     * @param tDriverAfterLog 行车后检查事项信息
     * @return 行车后检查事项集合
     */
	@Override
	public List<TDriverAfterLog> selectTDriverAfterLogList(TDriverAfterLog tDriverAfterLog)
	{
	    return tDriverAfterLogMapper.selectTDriverAfterLogList(tDriverAfterLog);
	}
	
    /**
     * 新增行车后检查事项
     * 
     * @param tDriverAfterLog 行车后检查事项信息
     * @return 结果
     */
	@Override
	public int insertTDriverAfterLog(TDriverAfterLog tDriverAfterLog)
	{
		tDriverAfterLog.setCreateDate(new Date());
		tDriverAfterLog.setAddUserId(ShiroUtils.getUserId().toString());
	    return tDriverAfterLogMapper.insertTDriverAfterLog(tDriverAfterLog);
	}
	
	/**
     * 修改行车后检查事项
     * 
     * @param tDriverAfterLog 行车后检查事项信息
     * @return 结果
     */
	@Override
	public int updateTDriverAfterLog(TDriverAfterLog tDriverAfterLog)
	{
	    return tDriverAfterLogMapper.updateTDriverAfterLog(tDriverAfterLog);
	}

	/**
     * 删除行车后检查事项对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTDriverAfterLogByIds(String ids)
	{
		return tDriverAfterLogMapper.deleteTDriverAfterLogByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
