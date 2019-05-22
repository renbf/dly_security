package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TCarTestingEvaluate;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 车辆检测和评定登记 服务层
 *
 * @author rbf
 * @date 2019-04-23
 */
public interface ITCarTestingEvaluateService {
    /**
     * 查询车辆检测和评定登记信息
     *
     * @param id 车辆检测和评定登记ID
     * @return 车辆检测和评定登记信息
     */
    public TCarTestingEvaluate selectTCarTestingEvaluateById(String id);

    /**
     * 查询车辆检测和评定登记列表
     *
     * @param tCarTestingEvaluate 车辆检测和评定登记信息
     * @return 车辆检测和评定登记集合
     */
    public List<TCarTestingEvaluate> selectTCarTestingEvaluateList(TCarTestingEvaluate tCarTestingEvaluate);

    /**
     * 新增车辆检测和评定登记
     *
     * @param tCarTestingEvaluate 车辆检测和评定登记信息
     * @return 结果
     */
    public AjaxResult insertTCarTestingEvaluate(TCarTestingEvaluate tCarTestingEvaluate, MultipartFile file);

    /**
     * 修改车辆检测和评定登记
     *
     * @param tCarTestingEvaluate 车辆检测和评定登记信息
     * @return 结果
     */
    public AjaxResult updateTCarTestingEvaluate(TCarTestingEvaluate tCarTestingEvaluate, MultipartFile file);

    /**
     * 删除车辆检测和评定登记信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTCarTestingEvaluateByIds(String ids);
    //以上自动生成的尽量别动
}
