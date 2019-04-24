package com.project.web.service;

import com.project.web.domian.TDriverAfterLog;
import java.util.List;

/**
 * 行车后检查事项 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITDriverAfterLogService 
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
     * 删除行车后检查事项信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDriverAfterLogByIds(String ids);
	//以上自动生成的尽量别动
}
