package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TEmergencyPlanRelease;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 应急预案发布 服务层
 *
 * @author rbf
 * @date 2019-04-17
 */
public interface ITEmergencyPlanReleaseService {
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
    public AjaxResult insertTEmergencyPlanRelease(TEmergencyPlanRelease tEmergencyPlanRelease, MultipartFile planReleaseFile);

    /**
     * 修改应急预案发布
     *
     * @param tEmergencyPlanRelease 应急预案发布信息
     * @return 结果
     */
    public AjaxResult updateTEmergencyPlanRelease(TEmergencyPlanRelease tEmergencyPlanRelease, MultipartFile planReleaseFile);

    /**
     * 删除应急预案发布信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTEmergencyPlanReleaseByIds(String ids);

}
