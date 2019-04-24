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
import com.project.web.mapper.TDangerLogMapper;
import com.project.web.domian.TDangerLog;
import com.project.web.service.ITDangerLogService;
import com.project.common.support.Convert;

/**
 * 隐患日志 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TDangerLogServiceImpl implements ITDangerLogService 
{
	private static final Logger log = LoggerFactory.getLogger(TDangerLogServiceImpl.class);
	@Autowired
	@Qualifier("tDangerLogMapper")
	private TDangerLogMapper tDangerLogMapper;

	/**
     * 查询隐患日志信息
     * 
     * @param id 隐患日志ID
     * @return 隐患日志信息
     */
    @Override
	public TDangerLog selectTDangerLogById(String id)
	{
	    return tDangerLogMapper.selectTDangerLogById(id);
	}
	
	/**
     * 查询隐患日志列表
     * 
     * @param tDangerLog 隐患日志信息
     * @return 隐患日志集合
     */
	@Override
	public List<TDangerLog> selectTDangerLogList(TDangerLog tDangerLog)
	{
	    return tDangerLogMapper.selectTDangerLogList(tDangerLog);
	}
	
    /**
     * 新增隐患日志
     * 
     * @param tDangerLog 隐患日志信息
     * @return 结果
     */
	@Override
	public int insertTDangerLog(TDangerLog tDangerLog)
	{
		tDangerLog.setId(UUIDUtil.getUUID());
		tDangerLog.setCreateDate(new Date());
		tDangerLog.setAddUserId(ShiroUtils.getUserId().toString());
	    return tDangerLogMapper.insertTDangerLog(tDangerLog);
	}
	
	/**
     * 修改隐患日志
     * 
     * @param tDangerLog 隐患日志信息
     * @return 结果
     */
	@Override
	public int updateTDangerLog(TDangerLog tDangerLog)
	{
	    return tDangerLogMapper.updateTDangerLog(tDangerLog);
	}

	/**
     * 删除隐患日志对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTDangerLogByIds(String ids)
	{
		return tDangerLogMapper.deleteTDangerLogByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
