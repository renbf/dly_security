package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TAccidentInvestigation;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 事故调查 服务层
 *
 * @author rbf
 * @date 2019-04-17
 */
public interface ITAccidentInvestigationService {
    /**
     * 查询事故调查信息
     *
     * @param id 事故调查ID
     * @return 事故调查信息
     */
    public TAccidentInvestigation selectTAccidentInvestigationById(String id);

    /**
     * 查询事故调查列表
     *
     * @param tAccidentInvestigation 事故调查信息
     * @return 事故调查集合
     */
    public List<TAccidentInvestigation> selectTAccidentInvestigationList(TAccidentInvestigation tAccidentInvestigation);

    /**
     * 查询事故报告根据基础id
     *
     * @param basicsId 基础表id
     * @return 结果
     */
    public AjaxResult selectTAccidentInvestigationByBasicsId(String basicsId);

    /**
     * 新增事故调查
     *
     * @param tAccidentInvestigation 事故调查信息
     * @return 结果
     */
    public AjaxResult insertTAccidentInvestigation(TAccidentInvestigation tAccidentInvestigation, MultipartFile file);

    /**
     * 修改事故调查
     *
     * @param tAccidentInvestigation 事故调查信息
     * @return 结果
     */
    public AjaxResult updateTAccidentInvestigation(TAccidentInvestigation tAccidentInvestigation, MultipartFile file);

    /**
     * 删除事故调查信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTAccidentInvestigationByIds(String ids);

}