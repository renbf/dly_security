package com.project.security.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.project.security.domain.TInspectTeamProject;
import com.project.security.domain.vo.TInspectTeamProjectVo;	

/**
 * 检查计划和检查项关系 数据层
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Repository("inspectTeamProjectMapper")
public interface TInspectTeamProjectMapper 
{
	/**
     * 查询检查计划和检查项关系信息
     * 
     * @param inspectPlanId 检查计划和检查项关系ID
     * @return 检查计划和检查项关系信息
     */
	public TInspectTeamProject selectTInspectTeamProjectById(String inspectPlanId);
	
	/**
     * 查询检查计划和检查项关系列表
     * 
     * @param tInspectTeamProject 检查计划和检查项关系信息
     * @return 检查计划和检查项关系集合
     */
	public List<TInspectTeamProject> selectTInspectTeamProjectList(TInspectTeamProject tInspectTeamProject);
	
	/**
     * 新增检查计划和检查项关系
     * 
     * @param tInspectTeamProject 检查计划和检查项关系信息
     * @return 结果
     */
	public int insertTInspectTeamProject(TInspectTeamProject tInspectTeamProject);
	
	/**
     * 修改检查计划和检查项关系
     * 
     * @param tInspectTeamProject 检查计划和检查项关系信息
     * @return 结果
     */
	public int updateTInspectTeamProject(TInspectTeamProject tInspectTeamProject);
	
	/**
     * 删除检查计划和检查项关系
     * 
     * @param inspectPlanId 检查计划和检查项关系ID
     * @return 结果
     */
	public int deleteTInspectTeamProjectById(String inspectPlanId);
	
	/**
     * 批量删除检查计划和检查项关系
     * 
     * @param inspectPlanIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTInspectTeamProjectByIds(String[] inspectPlanIds);
	//以上自动生成的尽量别动
	
	public List<TInspectTeamProjectVo> selectTInspectTeamProjects(@Param("inspectPlanId")String inspectPlanId,@Param("checkTeamId")String checkTeamId);
	
	/**
	 * 删除检查项目相关
	 * @param inspectPlanId
	 * @param checkTeamId
	 * @return
	 */
	public int deleteTInspectTeamProjectByTeamId(@Param("inspectPlanId")String inspectPlanId,@Param("checkTeamId")String checkTeamId);
	/**
	 * 批量新增
	 * @param list
	 * @return
	 */
	public int addBatchTInspectTeamProjects(List<TInspectTeamProject> list);
	
	
	
}