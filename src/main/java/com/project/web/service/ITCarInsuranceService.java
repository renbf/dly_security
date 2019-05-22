package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TCarInsurance;

import java.util.List;

/**
 * 车辆保险情况 服务层
 *
 * @author rbf
 * @date 2019-04-23
 */
public interface ITCarInsuranceService {
    /**
     * 查询车辆保险情况信息
     *
     * @param id 车辆保险情况ID
     * @return 车辆保险情况信息
     */
    public TCarInsurance selectTCarInsuranceById(String id);

    /**
     * 查询车辆保险情况列表
     *
     * @param tCarInsurance 车辆保险情况信息
     * @return 车辆保险情况集合
     */
    public List<TCarInsurance> selectTCarInsuranceList(TCarInsurance tCarInsurance);

    /**
     * 新增车辆保险情况
     *
     * @param tCarInsurance 车辆保险情况信息
     * @return 结果
     */
    public AjaxResult insertTCarInsurance(TCarInsurance tCarInsurance);

    /**
     * 修改车辆保险情况
     *
     * @param tCarInsurance 车辆保险情况信息
     * @return 结果
     */
    public AjaxResult updateTCarInsurance(TCarInsurance tCarInsurance);

    /**
     * 删除车辆保险情况信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTCarInsuranceByIds(String ids);
    //以上自动生成的尽量别动
}
