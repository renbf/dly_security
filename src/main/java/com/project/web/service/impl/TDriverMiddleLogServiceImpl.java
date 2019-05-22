package com.project.web.service.impl;

import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.web.domian.TDriverMiddleLog;
import com.project.web.mapper.TDriverMiddleLogMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITDriverMiddleLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 行车中检查事项 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TDriverMiddleLogServiceImpl implements ITDriverMiddleLogService {
    private static final Logger log = LoggerFactory.getLogger(TDriverMiddleLogServiceImpl.class);
    @Autowired
    @Qualifier("tDriverMiddleLogMapper")
    private TDriverMiddleLogMapper tDriverMiddleLogMapper;

    @Autowired
    private IFileService fileService;

    /**
     * 查询行车中检查事项信息
     *
     * @param driverLogId 行车中检查事项ID
     * @return 行车中检查事项信息
     */
    @Override
    public TDriverMiddleLog selectTDriverMiddleLogById(String driverLogId) {
        return tDriverMiddleLogMapper.selectTDriverMiddleLogById(driverLogId);
    }

    /**
     * 查询行车中检查事项列表
     *
     * @param tDriverMiddleLog 行车中检查事项信息
     * @return 行车中检查事项集合
     */
    @Override
    public List<TDriverMiddleLog> selectTDriverMiddleLogList(TDriverMiddleLog tDriverMiddleLog) {
        return tDriverMiddleLogMapper.selectTDriverMiddleLogList(tDriverMiddleLog);
    }

    /**
     * 新增行车中检查事项
     *
     * @param tDriverMiddleLog 行车中检查事项信息
     * @return 结果
     */
    @Override
    public int insertTDriverMiddleLog(TDriverMiddleLog tDriverMiddleLog) {
        tDriverMiddleLog.setCreateDate(new Date());
        tDriverMiddleLog.setAddUserId(ShiroUtils.getUserId().toString());
        return tDriverMiddleLogMapper.insertTDriverMiddleLog(tDriverMiddleLog);
    }

    /**
     * 修改行车中检查事项
     *
     * @param tDriverMiddleLog 行车中检查事项信息
     * @return 结果
     */
    @Override
    public int updateTDriverMiddleLog(TDriverMiddleLog tDriverMiddleLog) {
        /*文件上传*/
        //签名图片上传
        try {
            if (Objects.nonNull(tDriverMiddleLog.getNewAutographFile()) && StringUtils.isNotEmpty(tDriverMiddleLog.getNewAutographFile().getOriginalFilename())) {
                String upolad = this.fileService.upolad("xingchezhongqianming", tDriverMiddleLog.getDriverLogId(), "行车日志行车中签名附件文件", tDriverMiddleLog.getNewAutographFile(), 0,tDriverMiddleLog.getBusinessId());
                tDriverMiddleLog.setAutograph(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //照片文件上传
        List<String> newPhotoUrl = new ArrayList<>();
        if (tDriverMiddleLog.getNewPhotoFiles() != null && !tDriverMiddleLog.getNewPhotoFiles().isEmpty()) {
            tDriverMiddleLog.getNewPhotoFiles().forEach(e -> {
                try {
                    if (Objects.nonNull(e) && StringUtils.isNotEmpty(e.getOriginalFilename())) {
                        String upolad = this.fileService.upolad("xingchezhongzhaopian", tDriverMiddleLog.getDriverLogId(), "行车日志行车中照片附件文件", tDriverMiddleLog.getNewAutographFile(), 0, tDriverMiddleLog.getBusinessId());
                        newPhotoUrl.add(upolad);
                    }
                } catch (IOException i) {
                    i.printStackTrace();
                }
            });
        }
        //拼接最终的照片图片(思考了一番,前端入参中有之前存在且本次修改依旧存在的urls,和本次新增的图片的url一拼接,把数据库的覆盖了,,不就是最新的吗???)
        StringBuffer finalPhotoUrl = new StringBuffer();
        if (tDriverMiddleLog.getUpdatePhotoUrls() != null && !tDriverMiddleLog.getUpdatePhotoUrls().isEmpty()) {
            //拼接原有的url
            tDriverMiddleLog.getUpdatePhotoUrls().forEach(e -> {
                if (e != null && !e.trim().equals("")) {
                    finalPhotoUrl.append(e.trim() + ",");
                }
            });
        }
        if (!newPhotoUrl.isEmpty()) {
            //拼接新增的url
            newPhotoUrl.forEach(e -> {
                if (e != null && !e.trim().equals("")) {
                    finalPhotoUrl.append(e.trim() + ",");
                }
            });
        }
        //最终的图片url去结尾的,
        tDriverMiddleLog.setDrivingPhoto(
                finalPhotoUrl.length() > 0 ?
                        finalPhotoUrl.substring(0, finalPhotoUrl.length() - 1) : "");
        //update公共
        tDriverMiddleLog.setUpdateTime(new Date());
        tDriverMiddleLog.setUpdateUserId(ShiroUtils.getUserId().toString());
        return tDriverMiddleLogMapper.updateTDriverMiddleLog(tDriverMiddleLog);
    }

    /**
     * 删除行车中检查事项对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTDriverMiddleLogByIds(String ids) {
        return tDriverMiddleLogMapper.deleteTDriverMiddleLogByIds(Convert.toStrArray(ids));
    }
    //以上自动生成的尽量别动
}
