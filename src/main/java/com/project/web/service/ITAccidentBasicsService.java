package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TAccidentBasics;

import java.util.List;

/**
 * 事故基础 服务层
 *
 * @author rbf
 * @date 2019-04-17
 */
public interface ITAccidentBasicsService {
    /**
     * 查询事故基础信息
     *
     * @param id 事故基础ID
     * @return 事故基础信息
     */
    public TAccidentBasics selectTAccidentBasicsById(String id);

    /**
     * 查询事故基础列表
     *
     * @param tAccidentBasics 事故基础信息
     * @return 事故基础集合
     */
    public List<TAccidentBasics> selectTAccidentBasicsList(TAccidentBasics tAccidentBasics);

    /**
     * 新增事故基础
     *
     * @param tAccidentBasics 事故基础信息
     * @return 结果
     */
    public AjaxResult insertTAccidentBasics(TAccidentBasics tAccidentBasics);

    /**
     * 修改事故基础
     *
     * @param tAccidentBasics 事故基础信息
     * @return 结果
     */
    public AjaxResult updateTAccidentBasics(TAccidentBasics tAccidentBasics);

    /**
     * 删除事故基础信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTAccidentBasicsByIds(String ids);

}