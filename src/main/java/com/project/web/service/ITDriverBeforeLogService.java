package com.project.web.service;

import com.project.web.domian.TDriverBeforeLog;
import java.util.List;

/**
 * 行车前检查事项 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITDriverBeforeLogService 
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
     * 删除行车前检查事项信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDriverBeforeLogByIds(String ids);
	//以上自动生成的尽量别动
}
