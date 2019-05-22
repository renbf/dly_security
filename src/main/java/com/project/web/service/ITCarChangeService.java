package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TCarChange;

import java.util.List;

/**
 * 车辆变更登记 服务层
 *
 * @author rbf
 * @date 2019-04-23
 */
public interface ITCarChangeService {
    /**
     * 查询车辆变更登记信息
     *
     * @param id 车辆变更登记ID
     * @return 车辆变更登记信息
     */
    public TCarChange selectTCarChangeById(String id);

    /**
     * 查询车辆变更登记列表
     *
     * @param tCarChange 车辆变更登记信息
     * @return 车辆变更登记集合
     */
    public List<TCarChange> selectTCarChangeList(TCarChange tCarChange);

    /**
     * 新增车辆变更登记
     *
     * @param tCarChange 车辆变更登记信息
     * @return 结果
     */
    public AjaxResult insertTCarChange(TCarChange tCarChange);

    /**
     * 修改车辆变更登记
     *
     * @param tCarChange 车辆变更登记信息
     * @return 结果
     */
    public AjaxResult updateTCarChange(TCarChange tCarChange);

    /**
     * 删除车辆变更登记信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTCarChangeByIds(String ids);
    //以上自动生成的尽量别动
}
