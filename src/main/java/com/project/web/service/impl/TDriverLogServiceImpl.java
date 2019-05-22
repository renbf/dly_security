package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TDriverAfterLog;
import com.project.web.domian.TDriverBeforeLog;
import com.project.web.domian.TDriverLog;
import com.project.web.domian.TDriverMiddleLog;
import com.project.web.mapper.TDriverAfterLogMapper;
import com.project.web.mapper.TDriverBeforeLogMapper;
import com.project.web.mapper.TDriverLogMapper;
import com.project.web.mapper.TDriverMiddleLogMapper;
import com.project.web.service.ITDriverLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 行车日志基础 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TDriverLogServiceImpl implements ITDriverLogService {
    private static final Logger log = LoggerFactory.getLogger(TDriverLogServiceImpl.class);
    @Autowired
    @Qualifier("tDriverLogMapper")
    private TDriverLogMapper tDriverLogMapper;

    @Autowired
    private TDriverBeforeLogMapper driverBeforeLogMapper;

    @Autowired
    private TDriverMiddleLogMapper driverMiddleLogMapper;

    @Autowired
    private TDriverAfterLogMapper driverAfterLogMapper;

    /**
     * 查询行车日志基础信息
     *
     * @param id 行车日志基础ID
     * @return 行车日志基础信息
     */
    @Override
    public TDriverLog selectTDriverLogById(String id) {
        /*查询主表*/
        TDriverLog driverLog = this.tDriverLogMapper.selectTDriverLogById(id);
        if (driverLog != null) {
            if (driverLog.getStatus() != null && !driverLog.getStatus().isEmpty()) {
                int status = Integer.parseInt(driverLog.getStatus());
                if (status > 0) {
                    /*查询之前表*/
                    TDriverBeforeLog driverBeforeLog = this.driverBeforeLogMapper.selectTDriverBeforeLogById(id);
                    driverLog.setDriverBeforeLog(driverBeforeLog);
                }
                if (status > 1) {
                    /*查询之中表*/
                    TDriverMiddleLog driverMiddleLog = this.driverMiddleLogMapper.selectTDriverMiddleLogById(id);
                    driverLog.setDriverMiddleLog(driverMiddleLog);
                }
                if (status > 2) {
                    /*查询之后表*/
                    TDriverAfterLog driverAfterLog = this.driverAfterLogMapper.selectTDriverAfterLogById(id);
                    driverLog.setDriverAfterLog(driverAfterLog);
                }
            }
        }
        return driverLog;
    }

    /**
     * 查询行车日志基础列表
     *
     * @param tDriverLog 行车日志基础信息
     * @return 行车日志基础集合
     */
    @Override
    public List<TDriverLog> selectTDriverLogList(TDriverLog tDriverLog) {
        return tDriverLogMapper.selectTDriverLogList(tDriverLog);
    }

    /**
     * 新增行车日志基础
     *
     * @param tDriverLog 行车日志基础信息
     * @return 结果
     */
    @Override
    public int insertTDriverLog(TDriverLog tDriverLog) {
        //新增功能在app端
        tDriverLog.setId(UUIDUtil.getUUID());
        tDriverLog.setCreateDate(new Date());
        tDriverLog.setAddUserId(ShiroUtils.getUserId().toString());
        return tDriverLogMapper.insertTDriverLog(tDriverLog);
    }

    /**
     * 修改行车日志基础
     *
     * @param tDriverLog 行车日志基础信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult updateTDriverLog(TDriverLog tDriverLog) {
        //校验
        //文件上传 //没有
        //update公共
        tDriverLog.setUpdateTime(new Date());
        tDriverLog.setUpdateUserId(ShiroUtils.getUserId().toString());
        if (tDriverLogMapper.updateTDriverLog(tDriverLog) <= 0) {
            throw new RuntimeException();
        }
        /*修改附属表*/
        if (tDriverLog.getDriverBeforeLog() != null) {
            tDriverLog.getDriverBeforeLog().setDriverLogId(tDriverLog.getId());
            int i = this.driverBeforeLogMapper.updateTDriverBeforeLog(tDriverLog.getDriverBeforeLog());
        }
        if (tDriverLog.getDriverMiddleLog() != null) {
            tDriverLog.getDriverMiddleLog().setDriverLogId(tDriverLog.getId());
            int i1 = this.driverMiddleLogMapper.updateTDriverMiddleLog(tDriverLog.getDriverMiddleLog());
        }
        if (tDriverLog.getDriverAfterLog() != null) {
            tDriverLog.getDriverAfterLog().setDriverLogId(tDriverLog.getId());
            int i2 = this.driverAfterLogMapper.updateTDriverAfterLog(tDriverLog.getDriverAfterLog());
        }
        return AjaxResult.success();
    }

    /**
     * 删除行车日志基础对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTDriverLogByIds(String ids) {
        return tDriverLogMapper.deleteTDriverLogByIds(Convert.toStrArray(ids));
    }
    //以上自动生成的尽量别动
}
