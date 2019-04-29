package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TDepartureNewspaperClass;
import com.project.web.mapper.TDepartureNewspaperClassMapper;
import com.project.web.service.ITDepartureNewspaperClassService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 车辆报班 服务层实现
 *
 * @author rbf
 * @date 2019-04-16
 */
@Service
public class TDepartureNewspaperClassServiceImpl implements ITDepartureNewspaperClassService {
    @Autowired
    private TDepartureNewspaperClassMapper tDepartureNewspaperClassMapper;

    /**
     * 查询车辆报班信息
     *
     * @param id 车辆报班ID
     * @return 车辆报班信息
     */
    @Override
    public TDepartureNewspaperClass selectTDepartureNewspaperClassById(String id) {
        return tDepartureNewspaperClassMapper.selectTDepartureNewspaperClassById(id);
    }

    /**
     * 查询车辆报班列表
     *
     * @param tDepartureNewspaperClass 车辆报班信息
     * @return 车辆报班集合
     */
    @Override
    public List<TDepartureNewspaperClass> selectTDepartureNewspaperClassList(TDepartureNewspaperClass tDepartureNewspaperClass) {
        return tDepartureNewspaperClassMapper.selectTDepartureNewspaperClassList(tDepartureNewspaperClass);
    }

    /**
     * 新增车辆报班
     *
     * @param tDepartureNewspaperClass 车辆报班信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTDepartureNewspaperClass(TDepartureNewspaperClass tDepartureNewspaperClass) {
        //校验
        AjaxResult result = this.insertValidation(tDepartureNewspaperClass);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传 //没有
        //insert公共
        tDepartureNewspaperClass.setId(uuid);
        tDepartureNewspaperClass.setCreateTime(new Date());
        tDepartureNewspaperClass.setUserId(ShiroUtils.getUserId());
        return tDepartureNewspaperClassMapper.insertTDepartureNewspaperClass(tDepartureNewspaperClass) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改车辆报班
     *
     * @param tDepartureNewspaperClass 车辆报班信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTDepartureNewspaperClass(TDepartureNewspaperClass tDepartureNewspaperClass) {
        //校验
        AjaxResult result = this.insertValidation(tDepartureNewspaperClass);
        if (result != null) {
            return result;
        }
        //文件上传 //没有
        //update公共
        tDepartureNewspaperClass.setUpdateTime(new Date());
        tDepartureNewspaperClass.setUpdateUserId(ShiroUtils.getUserId());
        return tDepartureNewspaperClassMapper.updateTDepartureNewspaperClass(tDepartureNewspaperClass) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除车辆报班对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTDepartureNewspaperClassByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tDepartureNewspaperClassMapper.deleteTDepartureNewspaperClassByIds(Convert.toStrArray(ids));
        }
        return 0;
    }


    /**
     * 非空校验
     * @param tDepartureNewspaperClass
     * @return
     */
    private AjaxResult insertValidation(TDepartureNewspaperClass tDepartureNewspaperClass) {
        //车辆报班：日期、班次号、驾驶员、报班时间、报班人
        if (ValidationUtils.objIsNull(tDepartureNewspaperClass.getShiftsDate())) {
            return AjaxResult.error(2, "班次日期不能为空");
        }
        if (ValidationUtils.objIsNull(tDepartureNewspaperClass.getNewspaperClassDate())) {
            return AjaxResult.error(2, "报班时间不能为空");
        }
        if (ValidationUtils.objIsNull(tDepartureNewspaperClass.getShiftsNum())) {
            return AjaxResult.error(2, "班次号不能为空");
        }
        if (ValidationUtils.objIsNull(tDepartureNewspaperClass.getDriver())) {
            return AjaxResult.error(2, "驾驶员不能为空");
        }
        if (ValidationUtils.objIsNull(tDepartureNewspaperClass.getNewspaperClassPer())) {
            return AjaxResult.error(2, "报班人不能为空");
        }
        return null;
    }


}