package com.project.security.mapper;

import com.project.security.domain.TRiskLevelControl;
import java.util.List;	
import org.springframework.stereotype.Repository;
/**
 * 风险分级管控 数据层
 * 
 * @author rbf
 * @date 2019-04-23
 */
 @Repository("riskLevelControlMapper")
public interface TRiskLevelControlMapper 
{
	/**
     * 查询风险分级管控信息
     * 
     * @param id 风险分级管控ID
     * @return 风险分级管控信息
     */
	public TRiskLevelControl selectTRiskLevelControlById(String id);
	
	/**
     * 查询风险分级管控列表
     * 
     * @param tRiskLevelControl 风险分级管控信息
     * @return 风险分级管控集合
     */
	public List<TRiskLevelControl> selectTRiskLevelControlList(TRiskLevelControl tRiskLevelControl);
	
	/**
     * 新增风险分级管控
     * 
     * @param tRiskLevelControl 风险分级管控信息
     * @return 结果
     */
	public int insertTRiskLevelControl(TRiskLevelControl tRiskLevelControl);
	
	/**
     * 修改风险分级管控
     * 
     * @param tRiskLevelControl 风险分级管控信息
     * @return 结果
     */
	public int updateTRiskLevelControl(TRiskLevelControl tRiskLevelControl);
	
	/**
     * 删除风险分级管控
     * 
     * @param id 风险分级管控ID
     * @return 结果
     */
	public int deleteTRiskLevelControlById(String id);
	
	/**
     * 批量删除风险分级管控
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTRiskLevelControlByIds(String[] ids);
	//以上自动生成的尽量别动
}