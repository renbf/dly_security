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
import com.project.web.mapper.TDriverLogMapper;
import com.project.web.domian.TDriverLog;
import com.project.web.service.ITDriverLogService;
import com.project.common.support.Convert;

/**
 * 行车日志基础 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TDriverLogServiceImpl implements ITDriverLogService 
{
	private static final Logger log = LoggerFactory.getLogger(TDriverLogServiceImpl.class);
	@Autowired
	@Qualifier("tDriverLogMapper")
	private TDriverLogMapper tDriverLogMapper;

	/**
     * 查询行车日志基础信息
     * 
     * @param id 行车日志基础ID
     * @return 行车日志基础信息
     */
    @Override
	public TDriverLog selectTDriverLogById(String id)
	{
	    return tDriverLogMapper.selectTDriverLogById(id);
	}
	
	/**
     * 查询行车日志基础列表
     * 
     * @param tDriverLog 行车日志基础信息
     * @return 行车日志基础集合
     */
	@Override
	public List<TDriverLog> selectTDriverLogList(TDriverLog tDriverLog)
	{
	    return tDriverLogMapper.selectTDriverLogList(tDriverLog);
	}
	
    /**
     * 新增行车日志基础
     * 
     * @param tDriverLog 行车日志基础信息
     * @return 结果
     */
	@Override
	public int insertTDriverLog(TDriverLog tDriverLog)
	{
		tDriverLog.setId(UUIDUtil.getUUID());
		tDriverLog.setCreateDate(new Date());
		tDriverLog.setAddUserId(ShiroUtils.getUserId().toString());
	    return tDriverLogMapper.insertTDriverLog(tDriverLog);
	}
	
	/**
     * 修改行车日志基础
     * 
     * @param tDriverLog 行车日志基础信息
     * @return 结果
     */
	@Override
	public int updateTDriverLog(TDriverLog tDriverLog)
	{
	    return tDriverLogMapper.updateTDriverLog(tDriverLog);
	}

	/**
     * 删除行车日志基础对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTDriverLogByIds(String ids)
	{
		return tDriverLogMapper.deleteTDriverLogByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
