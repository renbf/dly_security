package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TVehicleCheck;
import com.project.web.mapper.TVehicleCheckMapper;
import com.project.web.service.ITVehicleCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 车辆例检 服务层实现
 *
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TVehicleCheckServiceImpl implements ITVehicleCheckService {
    @Autowired
    private TVehicleCheckMapper tVehicleCheckMapper;

    /**
     * 查询车辆例检信息
     *
     * @param id 车辆例检ID
     * @return 车辆例检信息
     */
    @Override
    public TVehicleCheck selectTVehicleCheckById(Long id) {
        return tVehicleCheckMapper.selectTVehicleCheckById(id);
    }

    /**
     * 查询车辆例检列表
     *
     * @param tVehicleCheck 车辆例检信息
     * @return 车辆例检集合
     */
    @Override
    public List<TVehicleCheck> selectTVehicleCheckList(TVehicleCheck tVehicleCheck) {
        return tVehicleCheckMapper.selectTVehicleCheckList(tVehicleCheck);
    }

    /**
     * 新增车辆例检
     *
     * @param tVehicleCheck 车辆例检信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTVehicleCheck(TVehicleCheck tVehicleCheck) {
        //校验
        AjaxResult result = this.insertValidation(tVehicleCheck);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传 ///没有
        //insert公共属性
        tVehicleCheck.setId(uuid);
        tVehicleCheck.setCreateTime(new Date());
        tVehicleCheck.setUserId(ShiroUtils.getUserId());
        return tVehicleCheckMapper.insertTVehicleCheck(tVehicleCheck) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改车辆例检
     *
     * @param tVehicleCheck 车辆例检信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTVehicleCheck(TVehicleCheck tVehicleCheck) {
        //校验
        AjaxResult result = this.insertValidation(tVehicleCheck);
        if (result != null) {
            return result;
        }
        //文件上传 ///没有
        //update公共属性
        tVehicleCheck.setUpdateTime(new Date());
        tVehicleCheck.setUpdateUserId(ShiroUtils.getUserId());
        return tVehicleCheckMapper.updateTVehicleCheck(tVehicleCheck) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除车辆例检对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTVehicleCheckByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tVehicleCheckMapper.deleteTVehicleCheckByIds(Convert.toStrArray(ids));
        }
        return 0;
    }


    /**
     * insert非空校验
     *
     * @return
     */
    private AjaxResult insertValidation(TVehicleCheck tVehicleCheck) {
        //车辆例检：例检类型、车牌号、驾驶员、例检时间、检查结果、检查有效期、车上例检人员、车下例检人员
        if (ValidationUtils.objIsNull(tVehicleCheck.getCheckType())) {
            return AjaxResult.error(2, "例检类型不能为空");
        }
        if (ValidationUtils.objIsNull(tVehicleCheck.getVehicleLicence())) {
            return AjaxResult.error(2, "车牌号不能为空");
        }
        if (ValidationUtils.objIsNull(tVehicleCheck.getDriver())) {
            return AjaxResult.error(2, "驾驶员不能为空");
        }
        if (ValidationUtils.objIsNull(tVehicleCheck.getCheckDate())) {
            return AjaxResult.error(2, "例检时间不能为空");
        }
        if (ValidationUtils.objIsNull(tVehicleCheck.getCheckResult())) {
            return AjaxResult.error(2, "检查结果不能为空");
        }
        if (ValidationUtils.objIsNull(tVehicleCheck.getCheckValidity())) {
            return AjaxResult.error(2, "检查有效期不能为空");
        }
        if (ValidationUtils.objIsNull(tVehicleCheck.getVehicleUpDriver())) {
            return AjaxResult.error(2, "车上例检人员不能为空");
        }
        if (ValidationUtils.objIsNull(tVehicleCheck.getVehicleDownDriver())) {
            return AjaxResult.error(2, "车下例检人员不能为空");
        }
        return null;
    }

}
