package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TCarInfo;
import com.project.web.domian.TCarLog;
import com.project.web.mapper.TCarInfoMapper;
import com.project.web.mapper.TCarLogMapper;
import com.project.web.service.ITCarInfoService;
import com.project.web.service.ITCarLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 车牌号牌变更 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarLogServiceImpl implements ITCarLogService {
    @Autowired
    private TCarLogMapper tCarLogMapper;
    @Autowired
    private ITCarInfoService carInfoService;

    @Autowired
    private TCarInfoMapper carInfoMapper;


    /**
     * 查询车牌号牌变更信息
     *
     * @param id 车牌号牌变更ID
     * @return 车牌号牌变更信息
     */
    @Override
    public TCarLog selectTCarLogById(String id) {
        return tCarLogMapper.selectTCarLogById(id);
    }

    /**
     * 查询车牌号牌变更列表
     *
     * @param tCarLog 车牌号牌变更信息
     * @return 车牌号牌变更集合
     */
    @Override
    public List<TCarLog> selectTCarLogList(TCarLog tCarLog) {
        List<TCarLog> list = tCarLogMapper.selectTCarLogList(tCarLog);
        Collections.sort(list, (e, e1) -> e.getCreateTime().compareTo(e1.getCreateTime()));
        return list;
    }

    /**
     * 新增车牌号牌变更
     *
     * @param tCarLog 车牌号牌变更信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult insertTCarLog(TCarLog tCarLog) {
        //校验
        AjaxResult result = this.insertValidation(tCarLog);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传 //没有
        //insert公共
        tCarLog.setId(uuid);
        tCarLog.setCreateTime(new Date());
        tCarLog.setAddUserId(ShiroUtils.getUserId().toString());
        /*return tCarLogMapper.insertTCarLog(tCarLog) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");*/
        if (tCarLogMapper.insertTCarLog(tCarLog) <= 0) {
            throw new RuntimeException();
        }
        /*修改主表车牌号信息*/
        if (this.updateCarNumberInCarInfo(tCarLog.getCarInfoId(), tCarLog.getCarNumber()) <= 0) {
            throw new RuntimeException();
        }
        return AjaxResult.success();
    }

    /**
     * 修改车牌号牌变更
     *
     * @param tCarLog 车牌号牌变更信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult updateTCarLog(TCarLog tCarLog) {
        //校验
        AjaxResult result = this.updateValidation(tCarLog);
        if (result != null) {
            return result;
        }
        //文件上传 //没有
        //update公共
        tCarLog.setUpdateTime(new Date());
        tCarLog.setUpdateUserId(ShiroUtils.getUserId().toString());
        if (tCarLogMapper.updateTCarLog(tCarLog) <= 0) {
            throw new RuntimeException();
        }
        /*修改车牌号表*/
        TCarLog tCarLog1 = new TCarLog();
        tCarLog1.setCarInfoId(tCarLog.getCarInfoId());
        List<TCarLog> list = this.selectTCarLogList(tCarLog1);
        this.updateCarNumberInCarInfo(tCarLog.getCarInfoId(), list.get(list.size() - 1).getCarNumber());
        return AjaxResult.success();
    }

    /**
     * 删除车牌号牌变更对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteTCarLogByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            String[] strings = Convert.toStrArray(ids);
            TCarLog carLog = this.selectTCarLogById(strings[0]);
            int i = tCarLogMapper.deleteTCarLogByIds(strings);
            if (i >0) {
                /*修改车牌号*/
                TCarLog carLog1 = new TCarLog();
                carLog1.setCarInfoId(carLog.getCarInfoId());
                List<TCarLog> list = this.selectTCarLogList(carLog1);
                if (!list.isEmpty()) {
                    this.updateCarNumberInCarInfo(carLog.getCarInfoId(), list.get(list.size() - 1).getCarNumber());
                } else {
                    this.updateCarNumberInCarInfo(carLog.getCarInfoId(), " ");
                }
            }
        }
        return 0;
    }


    /**
     * 新增校验
     *
     * @param tCarLog
     * @return
     */
    private AjaxResult insertValidation(TCarLog tCarLog) {
        if (tCarLog.getCarInfoId() == null || tCarLog.getCarInfoId().trim().isEmpty()) {
            return AjaxResult.error(2, "无车辆信息ID信息,请先保存主表信息,再添加车牌号信息");
        }
        TCarInfo carInfo = this.carInfoService.selectTCarInfoById(tCarLog.getCarInfoId());
        if (carInfo == null || carInfo.getId() == null || !carInfo.getId().trim().equals(tCarLog.getCarInfoId().trim())) {
            return AjaxResult.error(2, "车辆信息Id无效,请先保存主表信息,再添加车牌号信息");
        }
        /*增加发证日期的校验*/
        if (tCarLog.getUpdateDate() == null) {
            return AjaxResult.error(2, "请添加注册日期");
        }
        TCarLog tCarLog1 = new TCarLog();
        tCarLog1.setCarInfoId(tCarLog.getCarInfoId());
        List<TCarLog> carLogs = this.selectTCarLogList(tCarLog1);
        if (carLogs != null && !carLogs.isEmpty() &&
                carLogs.get(carLogs.size() - 1).getUpdateDate().compareTo(tCarLog.getUpdateDate()) >= 0) {
            return AjaxResult.error(2, "新的注册日期不能比旧的注册日期提前.");
        }
        return null;
    }


    /**
     * 修改检验
     * @param tCarLog
     * @return
     */
    private AjaxResult updateValidation(TCarLog tCarLog) {
        if (tCarLog.getCarInfoId() == null || tCarLog.getCarInfoId().trim().isEmpty()) {
            return AjaxResult.error(2, "无车辆信息ID信息!!!!");
        }
        TCarInfo carInfo = this.carInfoService.selectTCarInfoById(tCarLog.getCarInfoId());
        if (carInfo == null || carInfo.getId() == null || !carInfo.getId().trim().equals(tCarLog.getCarInfoId().trim())) {
            return AjaxResult.error(2, "车辆信息Id无效,请先保存主表信息,再添加车牌号信息");
        }
        /*增加发证日期的校验*/
        if (tCarLog.getUpdateDate() == null) {
            return AjaxResult.error(2, "请添加注册日期");
        }
        TCarLog tCarLog1 = new TCarLog();
        tCarLog1.setCarInfoId(tCarLog.getCarInfoId());
        List<TCarLog> carLogs = this.selectTCarLogList(tCarLog1);
        if (carLogs.stream().filter(e -> e.getId().trim().equals(tCarLog.getId().trim())).count() <= 0) {
            return AjaxResult.error(2, "UUID无效");
        }
        if (carLogs.size() > 1) {
            if (carLogs.get(0).getId().trim().equals(tCarLog.getId().trim())) {
                if (carLogs.get(1).getUpdateDate().compareTo(tCarLog.getUpdateDate()) <= 0) {
                    return AjaxResult.error(2, "初次登记的注册日期不能大于变更后注册日期");
                }
            } else if (carLogs.get(carLogs.size() - 1).getId().trim().equals(tCarLog.getId().trim())) {
                if (carLogs.get(carLogs.size() - 2).getUpdateDate().compareTo(tCarLog.getUpdateDate()) >= 0) {
                    return AjaxResult.error(2, "最新变更的注册日期不能小于上次的注册日期");
                }
            } else {
                for (int i = 0; i < carLogs.size(); i++) {
                    if (carLogs.get(i).getId().trim().equals(tCarLog.getId().trim())) {
                        if (carLogs.get(i - 1).getUpdateDate().compareTo(tCarLog.getUpdateDate()) >= 0
                                || carLogs.get(i + 1).getUpdateDate().compareTo(tCarLog.getUpdateDate()) <= 0) {
                            return AjaxResult.error(2, "修改的注册日期时间应该在初次登记和下次变更的注册日期之间");
                        }
                    }
                }
            }
        }
        return null;
    }


    /**
     * 由于业务需要,在车牌号表的增删改的过程中,可能涉及到主表(汽车信息表)中车牌号表的更换.
     * 该方法用于更换主表的车牌号
     * @param carInfoId
     * @param carNumber
     * @return
     */
    private int updateCarNumberInCarInfo(String carInfoId, String carNumber) {
        TCarInfo carInfo = new TCarInfo();
        carInfo.setId(carInfoId);
        carInfo.setCarNumber(carNumber);
        return this.carInfoMapper.updateTCarInfo(carInfo);
    }

}