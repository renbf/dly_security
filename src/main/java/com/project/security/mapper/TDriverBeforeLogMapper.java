package com.project.security.mapper;

import com.project.security.domain.TDriverBeforeLog;
import java.util.List;

import org.springframework.stereotype.Repository;	

/**
 * 行车前检查事项 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Repository("driverBeforeLogMapper")
public interface TDriverBeforeLogMapper 
{
	/**
     * 查询行车前检查事项信息
     * 
     * @param driverLogId 行车前检查事项ID
     * @return 行车前检查事项信息
     */
	public TDriverBeforeLog selectTDriverBeforeLogById(String driverLogId);
	
	/**
     * 查询行车前检查事项列表
     * 
     * @param tDriverBeforeLog 行车前检查事项信息
     * @return 行车前检查事项集合
     */
	public List<TDriverBeforeLog> selectTDriverBeforeLogList(TDriverBeforeLog tDriverBeforeLog);
	
	/**
     * 新增行车前检查事项
     * 
     * @param tDriverBeforeLog 行车前检查事项信息
     * @return 结果
     */
	public int insertTDriverBeforeLog(TDriverBeforeLog tDriverBeforeLog);
	
	/**
     * 修改行车前检查事项
     * 
     * @param tDriverBeforeLog 行车前检查事项信息
     * @return 结果
     */
	public int updateTDriverBeforeLog(TDriverBeforeLog tDriverBeforeLog);
	
	/**
     * 删除行车前检查事项
     * 
     * @param driverLogId 行车前检查事项ID
     * @return 结果
     */
	public int deleteTDriverBeforeLogById(String driverLogId);
	
	/**
     * 批量删除行车前检查事项
     * 
     * @param driverLogIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDriverBeforeLogByIds(String[] driverLogIds);
	//以上自动生成的尽量别动
}