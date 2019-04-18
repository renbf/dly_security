package com.project.security.mapper;

import com.project.security.domain.TDriverMiddleLog;
import java.util.List;	

/**
 * 行车中检查事项 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
public interface TDriverMiddleLogMapper 
{
	/**
     * 查询行车中检查事项信息
     * 
     * @param driverLogId 行车中检查事项ID
     * @return 行车中检查事项信息
     */
	public TDriverMiddleLog selectTDriverMiddleLogById(String driverLogId);
	
	/**
     * 查询行车中检查事项列表
     * 
     * @param tDriverMiddleLog 行车中检查事项信息
     * @return 行车中检查事项集合
     */
	public List<TDriverMiddleLog> selectTDriverMiddleLogList(TDriverMiddleLog tDriverMiddleLog);
	
	/**
     * 新增行车中检查事项
     * 
     * @param tDriverMiddleLog 行车中检查事项信息
     * @return 结果
     */
	public int insertTDriverMiddleLog(TDriverMiddleLog tDriverMiddleLog);
	
	/**
     * 修改行车中检查事项
     * 
     * @param tDriverMiddleLog 行车中检查事项信息
     * @return 结果
     */
	public int updateTDriverMiddleLog(TDriverMiddleLog tDriverMiddleLog);
	
	/**
     * 删除行车中检查事项
     * 
     * @param driverLogId 行车中检查事项ID
     * @return 结果
     */
	public int deleteTDriverMiddleLogById(String driverLogId);
	
	/**
     * 批量删除行车中检查事项
     * 
     * @param driverLogIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDriverMiddleLogByIds(String[] driverLogIds);
	//以上自动生成的尽量别动
}