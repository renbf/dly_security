package com.project.web.service;

import com.project.web.domian.TInspectRecord;
import java.util.List;

/**
 * 检查记录 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITInspectRecordService 
{
	/**
     * 查询检查记录信息
     * 
     * @param id 检查记录ID
     * @return 检查记录信息
     */
	public TInspectRecord selectTInspectRecordById(String id);
	
	/**
     * 查询检查记录列表
     * 
     * @param tInspectRecord 检查记录信息
     * @return 检查记录集合
     */
	public List<TInspectRecord> selectTInspectRecordList(TInspectRecord tInspectRecord);
	
	/**
     * 新增检查记录
     * 
     * @param tInspectRecord 检查记录信息
     * @return 结果
     */
	public int insertTInspectRecord(TInspectRecord tInspectRecord);
	
	/**
     * 修改检查记录
     * 
     * @param tInspectRecord 检查记录信息
     * @return 结果
     */
	public int updateTInspectRecord(TInspectRecord tInspectRecord);
		
	/**
     * 删除检查记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTInspectRecordByIds(String ids);
	//以上自动生成的尽量别动
}
