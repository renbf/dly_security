package com.project.web.mapper;

import com.project.web.domian.TCarLog;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 车牌号牌变更 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("tCarLogMapper")
public interface TCarLogMapper 
{
	/**
     * 查询车牌号牌变更信息
     * 
     * @param id 车牌号牌变更ID
     * @return 车牌号牌变更信息
     */
	public TCarLog selectTCarLogById(String id);
	
	/**
     * 查询车牌号牌变更列表
     * 
     * @param tCarLog 车牌号牌变更信息
     * @return 车牌号牌变更集合
     */
	public List<TCarLog> selectTCarLogList(TCarLog tCarLog);
	
	/**
     * 新增车牌号牌变更
     * 
     * @param tCarLog 车牌号牌变更信息
     * @return 结果
     */
	public int insertTCarLog(TCarLog tCarLog);
	
	/**
     * 修改车牌号牌变更
     * 
     * @param tCarLog 车牌号牌变更信息
     * @return 结果
     */
	public int updateTCarLog(TCarLog tCarLog);
	
	/**
     * 删除车牌号牌变更
     * 
     * @param id 车牌号牌变更ID
     * @return 结果
     */
	public int deleteTCarLogById(String id);
	
	/**
     * 批量删除车牌号牌变更
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCarLogByIds(String[] ids);
	//以上自动生成的尽量别动

	/**
	 * 批量删除  根据车辆信息id
	 * @param ids
	 * @return
	 */
	public int deleteByCarInfoId(String[] ids);
}