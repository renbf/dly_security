package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TCarInfo;
import com.project.web.domian.TDrivingLicenseLog;
import com.project.web.mapper.TDrivingLicenseLogMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITCarInfoService;
import com.project.web.service.ITDrivingLicenseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 行驶证变更 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TDrivingLicenseLogServiceImpl implements ITDrivingLicenseLogService {
    @Autowired
    private TDrivingLicenseLogMapper tDrivingLicenseLogMapper;
    @Autowired
    private IFileService fileService;
    @Autowired
    private ITCarInfoService carInfoService;

    /**
     * 查询行驶证变更信息
     *
     * @param id 行驶证变更ID
     * @return 行驶证变更信息
     */
    @Override
    public TDrivingLicenseLog selectTDrivingLicenseLogById(String id) {
        return tDrivingLicenseLogMapper.selectTDrivingLicenseLogById(id);
    }

    /**
     * 查询行驶证变更列表
     *
     * @param tDrivingLicenseLog 行驶证变更信息
     * @return 行驶证变更集合
     */
    @Override
    public List<TDrivingLicenseLog> selectTDrivingLicenseLogList(TDrivingLicenseLog tDrivingLicenseLog) {
        List<TDrivingLicenseLog> list = tDrivingLicenseLogMapper.selectTDrivingLicenseLogList(tDrivingLicenseLog);
        Collections.sort(list, (e, e1) -> e.getCreateTime().compareTo(e1.getCreateTime()));
        return list;
    }

    /**
     * 新增行驶证变更
     *
     * @param tDrivingLicenseLog 行驶证变更信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTDrivingLicenseLog(TDrivingLicenseLog tDrivingLicenseLog) {
        //校验
        AjaxResult result = this.insertValidation(tDrivingLicenseLog);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传
        try {
            if (Objects.nonNull(tDrivingLicenseLog.getPhotoFile()) && StringUtils.isNotEmpty(tDrivingLicenseLog.getPhotoFile().getOriginalFilename())) {
                String upolad = this.fileService.upolad("xingshizheng", uuid, "车辆信息>行驶证附件文件", tDrivingLicenseLog.getPhotoFile(), 0, tDrivingLicenseLog.getBusinessId());
                tDrivingLicenseLog.setPhotoFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //insert公共
        tDrivingLicenseLog.setId(uuid);
        tDrivingLicenseLog.setCreateTime(new Date());
        tDrivingLicenseLog.setAddUserId(ShiroUtils.getUserId().toString());
        return tDrivingLicenseLogMapper.insertTDrivingLicenseLog(tDrivingLicenseLog) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改行驶证变更
     *
     * @param tDrivingLicenseLog 行驶证变更信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTDrivingLicenseLog(TDrivingLicenseLog tDrivingLicenseLog) {
        //校验
        AjaxResult result = this.updateValidation(tDrivingLicenseLog);
        if (result != null) {
            return result;
        }
        //文件上传
        try {
            if (Objects.nonNull(tDrivingLicenseLog.getPhotoFile()) && StringUtils.isNotEmpty(tDrivingLicenseLog.getPhotoFile().getOriginalFilename())) {
                String upolad = this.fileService.upolad("xingshizheng", tDrivingLicenseLog.getId(), "车辆信息>行驶证附件文件", tDrivingLicenseLog.getPhotoFile(), 0, tDrivingLicenseLog.getBusinessId());
                tDrivingLicenseLog.setPhotoFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //update公共
        tDrivingLicenseLog.setUpdateTime(new Date());
        tDrivingLicenseLog.setUpdateUserId(ShiroUtils.getUserId().toString());
        return tDrivingLicenseLogMapper.updateTDrivingLicenseLog(tDrivingLicenseLog) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除行驶证变更对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTDrivingLicenseLogByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tDrivingLicenseLogMapper.deleteTDrivingLicenseLogByIds(Convert.toStrArray(ids));
        }
        return 0;
    }


    private AjaxResult insertValidation(TDrivingLicenseLog tDrivingLicenseLog) {
        if (tDrivingLicenseLog.getCarInfoId() == null || tDrivingLicenseLog.getCarInfoId().trim().isEmpty()) {
            return AjaxResult.error(2, "无车辆信息ID信息,请先保存主表信息,再添加行驶证信息");
        }
        TCarInfo carInfo = this.carInfoService.selectTCarInfoById(tDrivingLicenseLog.getCarInfoId());
        if (carInfo == null || carInfo.getId() == null || !carInfo.getId().trim().equals(tDrivingLicenseLog.getCarInfoId().trim())) {
            return AjaxResult.error(2, "车辆信息Id无效,请先保存主表信息,在添加运输证信息");
        }
        /*增加发证日期的校验*/
        if (tDrivingLicenseLog.getStartDate() == null) {
            return AjaxResult.error(2, "请添加发证日期");
        }
        TDrivingLicenseLog drivingLicenseLog1 = new TDrivingLicenseLog();
        drivingLicenseLog1.setCarInfoId(tDrivingLicenseLog.getCarInfoId());
        List<TDrivingLicenseLog> drivingLicenseLogs = this.selectTDrivingLicenseLogList(drivingLicenseLog1);
        if (drivingLicenseLogs != null && !drivingLicenseLogs.isEmpty() &&
                drivingLicenseLogs.get(drivingLicenseLogs.size() - 1).getStartDate().compareTo(tDrivingLicenseLog.getStartDate()) >= 0) {
            return AjaxResult.error(2, "新的发证日期不能比旧的发证日期提前.");
        }
        return null;
    }






    /**
     * 修改检验
     * @return
     */
    private AjaxResult updateValidation(TDrivingLicenseLog tDrivingLicenseLog) {
        if (tDrivingLicenseLog.getCarInfoId() == null || tDrivingLicenseLog.getCarInfoId().trim().isEmpty()) {
            return AjaxResult.error(2, "无车辆信息ID信息!!!!");
        }
        TCarInfo carInfo = this.carInfoService.selectTCarInfoById(tDrivingLicenseLog.getCarInfoId());
        if (carInfo == null || carInfo.getId() == null || !carInfo.getId().trim().equals(tDrivingLicenseLog.getCarInfoId().trim())) {
            return AjaxResult.error(2, "车辆信息Id无效,请先保存主表信息,再添加运输证信息");
        }
        /*增加发证日期的校验*/
        if (tDrivingLicenseLog.getStartDate() == null) {
            return AjaxResult.error(2, "请添加发证日期");
        }
        TDrivingLicenseLog tDrivingLicenseLog1 = new TDrivingLicenseLog();
        tDrivingLicenseLog1.setCarInfoId(tDrivingLicenseLog.getCarInfoId());
        List<TDrivingLicenseLog> carLogs = this.selectTDrivingLicenseLogList(tDrivingLicenseLog1);
        if (carLogs.stream().filter(e -> e.getId().trim().equals(tDrivingLicenseLog.getId().trim())).count() <= 0) {
            return AjaxResult.error(2, "UUID无效");
        }
        if (carLogs.size() > 1) {
            if (carLogs.get(0).getId().trim().equals(tDrivingLicenseLog.getId().trim())) {
                if (carLogs.get(1).getStartDate().compareTo(tDrivingLicenseLog.getStartDate()) <= 0) {
                    return AjaxResult.error(2, "初次登记的发证日期不能大于变更后发证日期");
                }
            } else if (carLogs.get(carLogs.size() - 1).getId().trim().equals(tDrivingLicenseLog.getId().trim())) {
                if (carLogs.get(carLogs.size() - 2).getStartDate().compareTo(tDrivingLicenseLog.getStartDate()) >= 0) {
                    return AjaxResult.error(2, "最新变更的发证日期不能小于上次的发证日期");
                }
            } else {
                for (int i = 0; i < carLogs.size(); i++) {
                    if (carLogs.get(i).getId().trim().equals(tDrivingLicenseLog.getId().trim())) {
                        if (carLogs.get(i - 1).getStartDate().compareTo(tDrivingLicenseLog.getStartDate()) >= 0
                                || carLogs.get(i + 1).getStartDate().compareTo(tDrivingLicenseLog.getStartDate()) <= 0) {
                            return AjaxResult.error(2, "修改的发证日期时间应该在初次登记和下次变更的发证日期之间");
                        }
                    }
                }
            }
        }
        return null;
    }

}
