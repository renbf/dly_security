package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TDriverLog;
import java.util.List;

/**
 * 行车日志基础 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITDriverLogService 
{
	/**
     * 查询行车日志基础信息
     * 
     * @param id 行车日志基础ID
     * @return 行车日志基础信息
     */
	public TDriverLog selectTDriverLogById(String id);
	
	/**
     * 查询行车日志基础列表
     * 
     * @param tDriverLog 行车日志基础信息
     * @return 行车日志基础集合
     */
	public List<TDriverLog> selectTDriverLogList(TDriverLog tDriverLog);
	
	/**
     * 新增行车日志基础
     * 
     * @param tDriverLog 行车日志基础信息
     * @return 结果
     */
	public int insertTDriverLog(TDriverLog tDriverLog);
	
	/**
     * 修改行车日志基础
     * 
     * @param tDriverLog 行车日志基础信息
     * @return 结果
     */
	public AjaxResult updateTDriverLog(TDriverLog tDriverLog);
		
	/**
     * 删除行车日志基础信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDriverLogByIds(String ids);
	//以上自动生成的尽量别动
}
