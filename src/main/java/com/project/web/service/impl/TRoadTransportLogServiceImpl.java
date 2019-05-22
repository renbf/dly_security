package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TCarInfo;
import com.project.web.domian.TRoadTransportLog;
import com.project.web.mapper.TRoadTransportLogMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITCarInfoService;
import com.project.web.service.ITRoadTransportLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 道路运输证变更 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TRoadTransportLogServiceImpl implements ITRoadTransportLogService {
    @Autowired
    private TRoadTransportLogMapper tRoadTransportLogMapper;
    @Autowired
    private IFileService fileService;
    @Autowired
    private ITCarInfoService carInfoService;


    /**
     * 查询道路运输证变更信息
     *
     * @param id 道路运输证变更ID
     * @return 道路运输证变更信息
     */
    @Override
    public TRoadTransportLog selectTRoadTransportLogById(String id) {
        return tRoadTransportLogMapper.selectTRoadTransportLogById(id);
    }

    /**
     * 查询道路运输证变更列表
     *
     * @param tRoadTransportLog 道路运输证变更信息
     * @return 道路运输证变更集合
     */
    @Override
    public List<TRoadTransportLog> selectTRoadTransportLogList(TRoadTransportLog tRoadTransportLog) {
        List<TRoadTransportLog> list = tRoadTransportLogMapper.selectTRoadTransportLogList(tRoadTransportLog);
        Collections.sort(list, (e, e1) -> e.getCreateTime().compareTo(e1.getCreateTime()));
        return list;
    }

    /**
     * 新增道路运输证变更
     *
     * @param tRoadTransportLog 道路运输证变更信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTRoadTransportLog(TRoadTransportLog tRoadTransportLog) {
        //校验
        AjaxResult result = this.insertValidation(tRoadTransportLog);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传
        try {
            if (Objects.nonNull(tRoadTransportLog.getPhotoFile()) && StringUtils.isNotEmpty(tRoadTransportLog.getPhotoFile().getOriginalFilename())) {
                String upolad = this.fileService.upolad("daoluyunshuzheng", uuid, "车辆信息>道路运输证附件文件", tRoadTransportLog.getPhotoFile(), 0, tRoadTransportLog.getBusinessId());
                tRoadTransportLog.setPhotoFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //insert公共
        tRoadTransportLog.setId(uuid);
        tRoadTransportLog.setCreateTime(new Date());
        tRoadTransportLog.setAddUserId(ShiroUtils.getUserId().toString());
        return tRoadTransportLogMapper.insertTRoadTransportLog(tRoadTransportLog) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改道路运输证变更
     *
     * @param tRoadTransportLog 道路运输证变更信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTRoadTransportLog(TRoadTransportLog tRoadTransportLog) {
        //校验
        AjaxResult result = this.updateValidation(tRoadTransportLog);
        if (result != null) {
            return result;
        }
        //文件上传
        try {
            if (Objects.nonNull(tRoadTransportLog.getPhotoFile()) && StringUtils.isNotEmpty(tRoadTransportLog.getPhotoFile().getOriginalFilename())) {
                String upolad = this.fileService.upolad("daoluyunshuzheng", tRoadTransportLog.getId(), "车辆信息>道路运输证附件文件", tRoadTransportLog.getPhotoFile(), 0, tRoadTransportLog.getBusinessId());
                tRoadTransportLog.setPhotoFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //update公共
        tRoadTransportLog.setUpdateTime(new Date());
        tRoadTransportLog.setUpdateUserId(ShiroUtils.getUserId().toString());
        return tRoadTransportLogMapper.updateTRoadTransportLog(tRoadTransportLog) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除道路运输证变更对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTRoadTransportLogByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tRoadTransportLogMapper.deleteTRoadTransportLogByIds(Convert.toStrArray(ids));
        }
        return 0;
    }


    private AjaxResult insertValidation(TRoadTransportLog tRoadTransportLog) {
        if (tRoadTransportLog.getCarInfoId() == null || tRoadTransportLog.getCarInfoId().trim().isEmpty()) {
            return AjaxResult.error(2, "无车辆信息ID信息,请先保存主表信息,再添加运输证信息");
        }
        TCarInfo carInfo = this.carInfoService.selectTCarInfoById(tRoadTransportLog.getCarInfoId());
        if (carInfo == null || carInfo.getId() == null || !carInfo.getId().trim().equals(tRoadTransportLog.getCarInfoId().trim())) {
            return AjaxResult.error(2, "车辆信息Id无效,请先保存主表信息,再添加运输证信息");
        }
        /*增加发证日期的校验*/
        if (tRoadTransportLog.getStartDate() == null) {
            return AjaxResult.error(2, "请添加发证日期");
        }
        TRoadTransportLog roadTransportLog1 = new TRoadTransportLog();
        roadTransportLog1.setCarInfoId(tRoadTransportLog.getCarInfoId());
        List<TRoadTransportLog> roadTransportLogs = this.selectTRoadTransportLogList(roadTransportLog1);
        if (roadTransportLogs != null && !roadTransportLogs.isEmpty() &&
                roadTransportLogs.get(roadTransportLogs.size() - 1).getStartDate().compareTo(tRoadTransportLog.getStartDate()) >= 0) {
            return AjaxResult.error(2, "新的发证日期不能比旧的发证日期提前.");
        }
        return null;
    }




    /**
     * 修改检验
     * @return
     */
    private AjaxResult updateValidation(TRoadTransportLog tRoadTransportLog) {
        if (tRoadTransportLog.getCarInfoId() == null || tRoadTransportLog.getCarInfoId().trim().isEmpty()) {
            return AjaxResult.error(2, "无车辆信息ID信息!!!!");
        }
        TCarInfo carInfo = this.carInfoService.selectTCarInfoById(tRoadTransportLog.getCarInfoId());
        if (carInfo == null || carInfo.getId() == null || !carInfo.getId().trim().equals(tRoadTransportLog.getCarInfoId().trim())) {
            return AjaxResult.error(2, "车辆信息Id无效,请先保存主表信息,再添加运输证信息");
        }
        /*增加发证日期的校验*/
        if (tRoadTransportLog.getStartDate() == null) {
            return AjaxResult.error(2, "请添加发证日期");
        }
        TRoadTransportLog tRoadTransportLog1 = new TRoadTransportLog();
        tRoadTransportLog1.setCarInfoId(tRoadTransportLog.getCarInfoId());
        List<TRoadTransportLog> carLogs = this.selectTRoadTransportLogList(tRoadTransportLog1);
        if (carLogs.stream().filter(e -> e.getId().trim().equals(tRoadTransportLog.getId().trim())).count() <= 0) {
            return AjaxResult.error(2, "UUID无效");
        }
        if (carLogs.size() > 1) {
            if (carLogs.get(0).getId().trim().equals(tRoadTransportLog.getId().trim())) {
                if (carLogs.get(1).getStartDate().compareTo(tRoadTransportLog.getStartDate()) <= 0) {
                    return AjaxResult.error(2, "初次登记的发证日期不能大于变更后发证日期");
                }
            } else if (carLogs.get(carLogs.size() - 1).getId().trim().equals(tRoadTransportLog.getId().trim())) {
                if (carLogs.get(carLogs.size() - 2).getStartDate().compareTo(tRoadTransportLog.getStartDate()) >= 0) {
                    return AjaxResult.error(2, "最新变更的发证日期不能小于上次的发证日期");
                }
            } else {
                for (int i = 0; i < carLogs.size(); i++) {
                    if (carLogs.get(i).getId().trim().equals(tRoadTransportLog.getId().trim())) {
                        if (carLogs.get(i - 1).getStartDate().compareTo(tRoadTransportLog.getStartDate()) >= 0
                                || carLogs.get(i + 1).getStartDate().compareTo(tRoadTransportLog.getStartDate()) <= 0) {
                            return AjaxResult.error(2, "修改的发证日期时间应该在初次登记和下次变更的发证日期之间");
                        }
                    }
                }
            }
        }
        return null;
    }



}