package com.project.web.mapper;

import com.project.web.domian.TDriverLog;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 行车日志基础 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tDriverLogMapper")
public interface TDriverLogMapper 
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
	public int updateTDriverLog(TDriverLog tDriverLog);
	
	/**
     * 删除行车日志基础
     * 
     * @param id 行车日志基础ID
     * @return 结果
     */
	public int deleteTDriverLogById(String id);
	
	/**
     * 批量删除行车日志基础
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTDriverLogByIds(String[] ids);
	//以上自动生成的尽量别动
}