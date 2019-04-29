package com.project.web.mapper;

import com.project.web.domian.TEmergencyPlanRelease;

import java.util.List;

/**
 * 应急预案发布 数据层
 *
 * @author rbf
 * @date 2019-04-17
 */
public interface TEmergencyPlanReleaseMapper {
    /**
     * 查询应急预案发布信息
     *
     * @param id 应急预案发布ID
     * @return 应急预案发布信息
     */
    public TEmergencyPlanRelease selectTEmergencyPlanReleaseById(String id);

    /**
     * 查询应急预案发布列表
     *
     * @param tEmergencyPlanRelease 应急预案发布信息
     * @return 应急预案发布集合
     */
    public List<TEmergencyPlanRelease> selectTEmergencyPlanReleaseList(TEmergencyPlanRelease tEmergencyPlanRelease);

    /**
     * 新增应急预案发布
     *
     * @param tEmergencyPlanRelease 应急预案发布信息
     * @return 结果
     */
    public int insertTEmergencyPlanRelease(TEmergencyPlanRelease tEmergencyPlanRelease);

    /**
     * 修改应急预案发布
     *
     * @param tEmergencyPlanRelease 应急预案发布信息
     * @return 结果
     */
    public int updateTEmergencyPlanRelease(TEmergencyPlanRelease tEmergencyPlanRelease);

    /**
     * 删除应急预案发布
     *
     * @param id 应急预案发布ID
     * @return 结果
     */
    public int deleteTEmergencyPlanReleaseById(String id);

    /**
     * 批量删除应急预案发布
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTEmergencyPlanReleaseByIds(String[] ids);

}