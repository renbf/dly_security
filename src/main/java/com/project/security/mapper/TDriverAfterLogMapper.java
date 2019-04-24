package com.project.security.mapper;

import com.project.security.domain.TDriverAfterLog;
import java.util.List;

import org.springframework.stereotype.Repository;	

/**
 * 行车后检查事项 数据层
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Repository("driverAfterLogMapper")
public interface TDriverAfterLogMapper 
{
	/**
     * 查询行车后检查事项信息
     * 
     * @param driverLogId 行车后检查事项ID
     * @return 行车后检查事项信息
     */
	public TDriverAfterLog selectTDriverAfterLogById(String driverLogId);
	
	/**
     * 查询行车后检查事项列表
     * 
     * @param tDriverAfterLog 行车后检查事项信息
     * @return 行车后检查事项集合
     */
	public List<TDriverAfterLog> selectTDriverAfterLogList(TDriverAfterLog tDriverAfterLog);
	
	/**
     * 新增行车后检查事项
     * 
     * @param tDriverAfterLog 行车后检查事项信息
     * @return 结果
     */
	public int insertTDriverAfterLog(TDriverAfterLog tDriverAfterLog);
	
	/**
     * 修改行车后检查事项
     * 
     * @param tDriverAfterLog 行车后检查事项信息
     * @return 结果
     */
	public int updateTDriverAfterLog(TDriverAfterLog tDriverAfterLog);
	
	/**
     * 删除行车后检查事项
     * 
     * @param driverLogId 行车后检查事项ID
     * @return 结果
     */
	public int deleteTDriverAfterLogById(String driverLogId);
	
	/**
     * 批量删除行车后检查事项
     * 
     * @param driverLogIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDriverAfterLogByIds(String[] driverLogIds);
	//以上自动生成的尽量别动
}