package com.project.web.service;

import com.project.web.domian.TRoadTransportLog;
import java.util.List;

/**
 * 道路运输证变更 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITRoadTransportLogService 
{
	/**
     * 查询道路运输证变更信息
     * 
     * @param id 道路运输证变更ID
     * @return 道路运输证变更信息
     */
	public TRoadTransportLog selectTRoadTransportLogById(String id);
	
	/**
     * 查询道路运输证变更列表
     * 
     * @param tRoadTransportLog 道路运输证变更信息
     * @return 道路运输证变更集合
     */
	public List<TRoadTransportLog> selectTRoadTransportLogList(TRoadTransportLog tRoadTransportLog);
	
	/**
     * 新增道路运输证变更
     * 
     * @param tRoadTransportLog 道路运输证变更信息
     * @return 结果
     */
	public int insertTRoadTransportLog(TRoadTransportLog tRoadTransportLog);
	
	/**
     * 修改道路运输证变更
     * 
     * @param tRoadTransportLog 道路运输证变更信息
     * @return 结果
     */
	public int updateTRoadTransportLog(TRoadTransportLog tRoadTransportLog);
		
	/**
     * 删除道路运输证变更信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTRoadTransportLogByIds(String ids);
	//以上自动生成的尽量别动
}
