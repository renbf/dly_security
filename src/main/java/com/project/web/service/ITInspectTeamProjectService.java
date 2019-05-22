package com.project.web.service;

import com.project.web.domian.TInspectTeamProject;

import java.util.List;

/**
 * 检查计划和检查项关系 服务层
 *
 * @author rbf
 * @date 2019-04-23
 */
public interface ITInspectTeamProjectService {
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
     * 删除检查计划和检查项关系信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTInspectTeamProjectByIds(String ids);
    //以上自动生成的尽量别动
}
