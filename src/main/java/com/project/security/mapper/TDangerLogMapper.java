package com.project.security.mapper;

import com.project.security.domain.TDangerLog;
import java.util.List;	

/**
 * 隐患日志 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface TDangerLogMapper 
{
	/**
     * 查询隐患日志信息
     * 
     * @param id 隐患日志ID
     * @return 隐患日志信息
     */
	public TDangerLog selectTDangerLogById(String id);
	
	/**
     * 查询隐患日志列表
     * 
     * @param tDangerLog 隐患日志信息
     * @return 隐患日志集合
     */
	public List<TDangerLog> selectTDangerLogList(TDangerLog tDangerLog);
	
	/**
     * 新增隐患日志
     * 
     * @param tDangerLog 隐患日志信息
     * @return 结果
     */
	public int insertTDangerLog(TDangerLog tDangerLog);
	
	/**
     * 修改隐患日志
     * 
     * @param tDangerLog 隐患日志信息
     * @return 结果
     */
	public int updateTDangerLog(TDangerLog tDangerLog);
	
	/**
     * 删除隐患日志
     * 
     * @param id 隐患日志ID
     * @return 结果
     */
	public int deleteTDangerLogById(String id);
	
	/**
     * 批量删除隐患日志
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDangerLogByIds(String[] ids);
	//以上自动生成的尽量别动
}