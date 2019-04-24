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
import com.project.web.mapper.TDriverMiddleLogMapper;
import com.project.web.domian.TDriverMiddleLog;
import com.project.web.service.ITDriverMiddleLogService;
import com.project.common.support.Convert;

/**
 * 行车中检查事项 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TDriverMiddleLogServiceImpl implements ITDriverMiddleLogService 
{
	private static final Logger log = LoggerFactory.getLogger(TDriverMiddleLogServiceImpl.class);
	@Autowired
	@Qualifier("tDriverMiddleLogMapper")
	private TDriverMiddleLogMapper tDriverMiddleLogMapper;

	/**
     * 查询行车中检查事项信息
     * 
     * @param driverLogId 行车中检查事项ID
     * @return 行车中检查事项信息
     */
    @Override
	public TDriverMiddleLog selectTDriverMiddleLogById(String driverLogId)
	{
	    return tDriverMiddleLogMapper.selectTDriverMiddleLogById(driverLogId);
	}
	
	/**
     * 查询行车中检查事项列表
     * 
     * @param tDriverMiddleLog 行车中检查事项信息
     * @return 行车中检查事项集合
     */
	@Override
	public List<TDriverMiddleLog> selectTDriverMiddleLogList(TDriverMiddleLog tDriverMiddleLog)
	{
	    return tDriverMiddleLogMapper.selectTDriverMiddleLogList(tDriverMiddleLog);
	}
	
    /**
     * 新增行车中检查事项
     * 
     * @param tDriverMiddleLog 行车中检查事项信息
     * @return 结果
     */
	@Override
	public int insertTDriverMiddleLog(TDriverMiddleLog tDriverMiddleLog)
	{
		tDriverMiddleLog.setCreateDate(new Date());
		tDriverMiddleLog.setAddUserId(ShiroUtils.getUserId().toString());
	    return tDriverMiddleLogMapper.insertTDriverMiddleLog(tDriverMiddleLog);
	}
	
	/**
     * 修改行车中检查事项
     * 
     * @param tDriverMiddleLog 行车中检查事项信息
     * @return 结果
     */
	@Override
	public int updateTDriverMiddleLog(TDriverMiddleLog tDriverMiddleLog)
	{
	    return tDriverMiddleLogMapper.updateTDriverMiddleLog(tDriverMiddleLog);
	}

	/**
     * 删除行车中检查事项对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTDriverMiddleLogByIds(String ids)
	{
		return tDriverMiddleLogMapper.deleteTDriverMiddleLogByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
