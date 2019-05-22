package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TCarLog;
import java.util.List;

/**
 * 车牌号牌变更 服务层
 * 
 * @author rbf
 * @date 2019-04-23
 */
public interface ITCarLogService 
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
	public AjaxResult insertTCarLog(TCarLog tCarLog);
	
	/**
     * 修改车牌号牌变更
     * 
     * @param tCarLog 车牌号牌变更信息
     * @return 结果
     */
	public AjaxResult updateTCarLog(TCarLog tCarLog);
		
	/**
     * 删除车牌号牌变更信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCarLogByIds(String ids);
	//以上自动生成的尽量别动
}
