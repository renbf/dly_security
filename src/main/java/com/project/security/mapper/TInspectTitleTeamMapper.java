package com.project.security.mapper;

import com.project.security.domain.TInspectTitleTeam;
import java.util.List;	

/**
 * 标题和检查项目关系 数据层
 * 
 * @author rbf
 * @date 2019-04-17
 */
public interface TInspectTitleTeamMapper 
{
	/**
     * 查询标题和检查项目关系信息
     * 
     * @param titleId 标题和检查项目关系ID
     * @return 标题和检查项目关系信息
     */
	public TInspectTitleTeam selectTInspectTitleTeamById(String titleId);
	
	/**
     * 查询标题和检查项目关系列表
     * 
     * @param tInspectTitleTeam 标题和检查项目关系信息
     * @return 标题和检查项目关系集合
     */
	public List<TInspectTitleTeam> selectTInspectTitleTeamList(TInspectTitleTeam tInspectTitleTeam);
	
	/**
     * 新增标题和检查项目关系
     * 
     * @param tInspectTitleTeam 标题和检查项目关系信息
     * @return 结果
     */
	public int insertTInspectTitleTeam(TInspectTitleTeam tInspectTitleTeam);
	
	/**
     * 修改标题和检查项目关系
     * 
     * @param tInspectTitleTeam 标题和检查项目关系信息
     * @return 结果
     */
	public int updateTInspectTitleTeam(TInspectTitleTeam tInspectTitleTeam);
	
	/**
     * 删除标题和检查项目关系
     * 
     * @param titleId 标题和检查项目关系ID
     * @return 结果
     */
	public int deleteTInspectTitleTeamById(String titleId);
	
	/**
     * 批量删除标题和检查项目关系
     * 
     * @param titleIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTInspectTitleTeamByIds(String[] titleIds);
	//以上自动生成的尽量别动
}