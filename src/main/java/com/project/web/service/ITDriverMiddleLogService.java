package com.project.web.service;

import com.project.web.domian.TDriverMiddleLog;
import java.util.List;

/**
 * 行车中检查事项 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITDriverMiddleLogService 
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
     * 删除行车中检查事项信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDriverMiddleLogByIds(String ids);
	//以上自动生成的尽量别动
}
