package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TCarInfo;
import com.project.web.domian.TCarLog;
import com.project.web.domian.TDrivingLicenseLog;
import com.project.web.domian.TRoadTransportLog;
import com.project.web.mapper.*;
import com.project.web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 车辆 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarInfoServiceImpl implements ITCarInfoService {
    @Autowired
    private TCarInfoMapper tCarInfoMapper;

    @Autowired
    private ITCarLogService carLogService;

    @Autowired
    private ITRoadTransportLogService roadTransportLogService;

    @Autowired
    private ITDrivingLicenseLogService drivingLicenseLogService;

    @Autowired
    private IFileService fileService;


    /*更多的附属表mapper*/
    @Autowired
    private TCarLogMapper carLogMapper;
    @Autowired
    private TRoadTransportLogMapper roadTransportLogMapper;
    @Autowired
    private TDrivingLicenseLogMapper drivingLicenseLogMapper;

    @Autowired
    private TCarTestingEvaluateMapper carTestingEvaluateMapper;
    @Autowired
    private TCarRepairMapper carRepairMapper;
    @Autowired
    private TCarPartsChangeMapper carPartsChangeMapper;
    @Autowired
    private TCarChangeMapper carChangeMapper;
    @Autowired
    private TCarKmMapper carKmMapper;
    @Autowired
    private TCarTroubleMapper carTroubleMapper;
    @Autowired
    private TCarInsuranceMapper carInsuranceMapper;
    @Autowired
    private TCarCarrierMapper carCarrierMapper;
    @Autowired
    private TCarSpecialUseMapper carSpecialUseMapper;
    @Autowired
    private TCarSatellitePositionMapper carSatellitePositionMapper;


    /**
     * 查询车辆信息
     *
     * @param id 车辆ID
     * @return 车辆信息
     */
    @Override
    public TCarInfo selectTCarInfoById(String id) {
        return tCarInfoMapper.selectTCarInfoById(id);
    }

    /**
     * 查询车辆列表
     *
     * @param tCarInfo 车辆信息
     * @return 车辆集合
     */
    @Override
    public List<TCarInfo> selectTCarInfoList(TCarInfo tCarInfo) {
        List<TCarInfo> list = tCarInfoMapper.selectTCarInfoList(tCarInfo);
        if (tCarInfo.getId() != null && !tCarInfo.getId().isEmpty() && !list.isEmpty()) {
            list.forEach(e -> {
                TCarLog carLog = new TCarLog();
                carLog.setCarInfoId(tCarInfo.getId());
                TRoadTransportLog roadTransportLog = new TRoadTransportLog();
                roadTransportLog.setCarInfoId(tCarInfo.getId());
                TDrivingLicenseLog drivingLicenseLog = new TDrivingLicenseLog();
                drivingLicenseLog.setCarInfoId(tCarInfo.getId());
                /*添加附属三表的数据*/
                e.setCarLogs(this.carLogService.selectTCarLogList(carLog));
                e.setRoadTransportLogs(this.roadTransportLogService.selectTRoadTransportLogList(roadTransportLog));
                e.setDrivingLicenseLogs(this.drivingLicenseLogService.selectTDrivingLicenseLogList(drivingLicenseLog));
            });
        }
        return list;
    }

    /**
     * 新增车辆
     * v1.0  一次性新增4个表.
     * v2.0  一次只新增一个表.关于v1.0的代码,冗余的没有删除,而是注释了
     *
     * @param tCarInfo 车辆信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult insertTCarInfo(TCarInfo tCarInfo) {
        /*校验*/
        AjaxResult result = this.insertValidation(tCarInfo);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        /*文件上传*/
        //文件上传在存储数据库中实现.
        /*存储数据库*/
        //存储信息表
        try {
            if (Objects.nonNull(tCarInfo.getPhotoFile()) && StringUtils.isNotEmpty(tCarInfo.getPhotoFile().getOriginalFilename())) {
                String upolad = this.fileService.upolad("cheliangxinxi", uuid, "车辆信息附件文件", tCarInfo.getPhotoFile(), 0, tCarInfo.getBusinessId());
                tCarInfo.setPhotoFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tCarInfo.setId(uuid);
        tCarInfo.setCreateTime(new Date());
        tCarInfo.setAddUserId(ShiroUtils.getUserId().toString());
        tCarInfo.setBusinessId(ShiroUtils.getBusinessId());
        return this.tCarInfoMapper.insertTCarInfo(tCarInfo) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
        //保存最新的车牌号
/*        if (tCarInfo.getCarLogs() != null && !tCarInfo.getCarLogs().isEmpty()) {
            tCarInfo.setCarNumber(tCarInfo.getCarLogs().get(tCarInfo.getCarLogs().size()-1).getCarNumber());
        }*/
/*        if (this.tCarInfoMapper.insertTCarInfo(tCarInfo) <= 0) {
            throw new RuntimeException();
        }*/
        //存储附属3表
        //this.insertCarInfoSubsidiaryTable(tCarInfo, uuid);
        //return AjaxResult.success();
    }


    /**
     * 修改车辆
     * v1.0  一次性修改4个表.
     * v2.0  一次只修改一个表.关于v1.0的代码,冗余的没有删除,而是注释了
     *
     * @param tCarInfo 车辆信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult updateTCarInfo(TCarInfo tCarInfo) {
        /*校验*/
        AjaxResult result = this.insertValidation(tCarInfo);
        if (result != null) {
            return result;
        }
        /*文件上传*/
        try {
            if (Objects.nonNull(tCarInfo.getPhotoFile()) && StringUtils.isNotEmpty(tCarInfo.getPhotoFile().getOriginalFilename())) {
                String upolad = this.fileService.upolad("cheliangxinxi", tCarInfo.getId(), "车辆信息附件文件", tCarInfo.getPhotoFile(), 0, tCarInfo.getBusinessId());
                tCarInfo.setPhotoFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*存储数据库*/
        tCarInfo.setUpdateTime(new Date());
        tCarInfo.setUpdateUserId(ShiroUtils.getUserId().toString());
        return this.tCarInfoMapper.updateTCarInfo(tCarInfo) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
        //添加车牌号
        /*if (tCarInfo.getCarLogs() != null && !tCarInfo.getCarLogs().isEmpty()) {
            tCarInfo.setCarNumber(tCarInfo.getCarLogs().get(tCarInfo.getCarLogs().size() - 1).getCarNumber());
        }
        if (this.tCarInfoMapper.updateTCarInfo(tCarInfo) <= 0) {
            throw new RuntimeException();
        }*/
        /*修改车牌号表*//*
        List<TCarLog> carLogByCarInfoId = this.getTCarLogByCarInfoId(tCarInfo.getId());
        //如果入参没有 数据库有则删除
        StringBuffer sb1 = new StringBuffer();
        for (TCarLog databaseInfo : carLogByCarInfoId) {
            boolean temp = false;
            for (TCarLog info : tCarInfo.getCarLogs()) {
                if (databaseInfo.getId().equals(info.getId())) {
                    temp = true;
                }
            }
            if (!temp) {
                sb1.append(databaseInfo.getId() + ",");
            }
        }
        if (sb1.length() > 0) {
            this.carLogService.deleteTCarLogByIds(sb1.substring(0, sb1.length() - 1));
        }
        //如果入参有 数据库有则修改
        for (TCarLog carLog : tCarInfo.getCarLogs()) {
            boolean temp = false;
            for (TCarLog log : carLogByCarInfoId) {
                if (carLog.getId().equals(log.getId())) {
                    //修改
                    this.carLogService.updateTCarLog(carLog);
                }
            }
            if (!temp) {
                //如果入参有 数据库没有则新增
                //新增
                carLog.setCarInfoId(tCarInfo.getId());
                this.carLogService.insertTCarLog(carLog);
            }
        }
        *//*修改道路运输证表*//*
        List<TRoadTransportLog> roadTransportLogByCarInfoId = this.getTRoadTransportLogByCarInfoId(tCarInfo.getId());
        //如果入参没有 数据库有则删除
        StringBuffer sb2 = new StringBuffer();
        for (TRoadTransportLog databaseInfo : roadTransportLogByCarInfoId) {
            boolean temp = false;
            for (TRoadTransportLog info : tCarInfo.getRoadTransportLogs()) {
                if (databaseInfo.getId().equals(info.getId())) {
                    temp = true;
                }
            }
            if (!temp) {
                sb2.append(databaseInfo.getId() + ",");
            }
        }
        if (sb2.length() > 0) {
            this.roadTransportLogService.deleteTRoadTransportLogByIds(sb2.substring(0, sb2.length() - 1));
        }
        //如果入参有 数据库有则修改
        for (TRoadTransportLog roadTransportLog : tCarInfo.getRoadTransportLogs()) {
            boolean temp = false;
            for (TRoadTransportLog transportLog : roadTransportLogByCarInfoId) {
                if (roadTransportLog.getId().equals(transportLog.getId())) {
                    //修改
                    this.roadTransportLogService.updateTRoadTransportLog(roadTransportLog);
                }
            }
            if (!temp) {
                //如果入参有 数据库没有则新增
                //新增
                roadTransportLog.setCarInfoId(tCarInfo.getId());
                this.roadTransportLogService.insertTRoadTransportLog(roadTransportLog);
            }
        }
        *//*修改行驶证表*//*
        List<TDrivingLicenseLog> drivingLicenseLogByCarInfoId = this.getTDrivingLicenseLogByCarInfoId(tCarInfo.getId());
        //如果入参没有 数据库有则删除
        StringBuffer sb3 = new StringBuffer();
        for (TDrivingLicenseLog databaseInfo : drivingLicenseLogByCarInfoId) {
            boolean temp = false;
            for (TDrivingLicenseLog info : tCarInfo.getDrivingLicenseLogs()) {
                if (databaseInfo.getId().equals(info.getId())) {
                    temp = true;
                }
            }
            if (!temp) {
                sb3.append(databaseInfo.getId() + ",");
            }
        }
        if (sb3.length() > 0) {
            this.drivingLicenseLogService.deleteTDrivingLicenseLogByIds(sb3.substring(0, sb3.length() - 1));
        }
        //如果入参有 数据库有则修改
        for (TDrivingLicenseLog drivingLicenseLog : tCarInfo.getDrivingLicenseLogs()) {
            boolean temp = false;
            for (TDrivingLicenseLog licenseLog : drivingLicenseLogByCarInfoId) {
                if (drivingLicenseLog.getId().equals(licenseLog.getId())) {
                    //修改
                    this.drivingLicenseLogService.updateTDrivingLicenseLog(drivingLicenseLog);
                }
            }
            if (!temp) {
                //如果入参有 数据库没有则新增
                //新增
                drivingLicenseLog.setCarInfoId(tCarInfo.getId());
                this.drivingLicenseLogService.insertTDrivingLicenseLog(drivingLicenseLog);
            }
        }
        return AjaxResult.success();*/
    }

    /**
     * 删除车辆对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteTCarInfoByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            if (tCarInfoMapper.deleteTCarInfoByIds(Convert.toStrArray(ids)) <= 0) {
                throw new RuntimeException();
            }
            this.carLogMapper.deleteByCarInfoId(Convert.toStrArray(ids));
            this.roadTransportLogMapper.deleteByCarInfoId(Convert.toStrArray(ids));
            this.drivingLicenseLogMapper.deleteByCarInfoId(Convert.toStrArray(ids));
            this.carTestingEvaluateMapper.deleteByCarInfoId(Convert.toStrArray(ids));
            this.carRepairMapper.deleteByCarInfoId(Convert.toStrArray(ids));
            this.carPartsChangeMapper.deleteByCarInfoId(Convert.toStrArray(ids));
            this.carChangeMapper.deleteByCarInfoId(Convert.toStrArray(ids));
            this.carKmMapper.deleteByCarInfoId(Convert.toStrArray(ids));
            this.carTroubleMapper.deleteByCarInfoId(Convert.toStrArray(ids));
            this.carInsuranceMapper.deleteByCarInfoId(Convert.toStrArray(ids));
            this.carCarrierMapper.deleteByCarInfoId(Convert.toStrArray(ids));
            this.carSpecialUseMapper.deleteByCarInfoId(Convert.toStrArray(ids));
            this.carSatellitePositionMapper.deleteByCarInfoId(Convert.toStrArray(ids));

        }
        return 0;
    }


    private AjaxResult insertValidation(TCarInfo tCarInfo) {
        /*if (tCarInfo.getCarLogs() != null && !tCarInfo.getCarLogs().isEmpty() && tCarInfo.getCarLogs().size() >= 2) {
            for (int i = 1; i < tCarInfo.getCarLogs().size(); i++) {
                if (tCarInfo.getCarLogs().get(i - 1).getUpdateDate().getTime() >= tCarInfo.getCarLogs().get(i).getUpdateDate().getTime()) {
                    return AjaxResult.error(2, "变更后的车牌号信息中变更时间不能小于变更前的变更时间");
                }
            }
        }
        if (tCarInfo.getRoadTransportLogs() != null && !tCarInfo.getRoadTransportLogs().isEmpty() && tCarInfo.getRoadTransportLogs().size() >= 2) {
            for (int i = 1; i < tCarInfo.getCarLogs().size(); i++) {
                if (tCarInfo.getRoadTransportLogs().get(i - 1).getStartDate().getTime() >= tCarInfo.getRoadTransportLogs().get(i).getStartDate().getTime()) {
                    return AjaxResult.error(2, "变更后的道路运输证信息中变更时间不能小于变更前的变更时间");
                }
            }
        }
        if (tCarInfo.getDrivingLicenseLogs() != null && !tCarInfo.getDrivingLicenseLogs().isEmpty() && tCarInfo.getDrivingLicenseLogs().size() >= 2) {
            for (int i = 1; i < tCarInfo.getCarLogs().size(); i++) {
                if (tCarInfo.getDrivingLicenseLogs().get(i - 1).getStartDate().getTime() >= tCarInfo.getDrivingLicenseLogs().get(i).getStartDate().getTime()) {
                    return AjaxResult.error(2, "变更后的行驶证信息中变更时间不能小于变更前的变更时间");
                }
            }
        }*/
        return null;
    }


    /**
     * insert操作中 附属表的新增
     *
     * @param tCarInfo
     * @param uuid
     */
    /*private void insertCarInfoSubsidiaryTable(TCarInfo tCarInfo, String uuid) {
        //存储车牌表
        for (TCarLog carLog : tCarInfo.getCarLogs()) {
            carLog.setCarInfoId(uuid);
            if (this.carLogService.insertTCarLog(carLog) <= 0) {
                throw new RuntimeException();
            }
        }
        //存储道路运输证表
        for (TRoadTransportLog roadTransportLog : tCarInfo.getRoadTransportLogs()) {
            roadTransportLog.setCarInfoId(uuid);
            if (this.roadTransportLogService.insertTRoadTransportLog(roadTransportLog) <= 0) {
                throw new RuntimeException();
            }
        }
        //存储行驶证
        for (TDrivingLicenseLog drivingLicenseLog : tCarInfo.getDrivingLicenseLogs()) {
            drivingLicenseLog.setCarInfoId(uuid);
            if (this.drivingLicenseLogService.insertTDrivingLicenseLog(drivingLicenseLog) <= 0) {
                throw new RuntimeException();
            }
        }
    }*/


    /**
     * 根据主表的id查询车牌号表
     *
     * @param carInfoId
     * @return
     */
    private List<TCarLog> getTCarLogByCarInfoId(String carInfoId) {
        TCarLog carLog = new TCarLog();
        carLog.setCarInfoId(carInfoId);
        return this.carLogService.selectTCarLogList(carLog);
    }

    /**
     * 根据主表的id查询运输证表
     *
     * @param carInfoId
     * @return
     */
    private List<TRoadTransportLog> getTRoadTransportLogByCarInfoId(String carInfoId) {
        TRoadTransportLog roadTransportLog = new TRoadTransportLog();
        roadTransportLog.setCarInfoId(carInfoId);
        return this.roadTransportLogService.selectTRoadTransportLogList(roadTransportLog);
    }

    /**
     * 根据主表的id查询行驶证表
     *
     * @param carInfoId
     * @return
     */
    private List<TDrivingLicenseLog> getTDrivingLicenseLogByCarInfoId(String carInfoId) {
        TDrivingLicenseLog drivingLicenseLog = new TDrivingLicenseLog();
        drivingLicenseLog.setCarInfoId(carInfoId);
        return this.drivingLicenseLogService.selectTDrivingLicenseLogList(drivingLicenseLog);
    }

}