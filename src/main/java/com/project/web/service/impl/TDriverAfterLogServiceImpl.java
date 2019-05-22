package com.project.web.service.impl;

import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.web.domian.TDriverAfterLog;
import com.project.web.domian.TDriverMiddleLog;
import com.project.web.mapper.TDriverAfterLogMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITDriverAfterLogService;
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
 * 行车后检查事项 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TDriverAfterLogServiceImpl implements ITDriverAfterLogService {
    private static final Logger log = LoggerFactory.getLogger(TDriverAfterLogServiceImpl.class);
    @Autowired
    @Qualifier("tDriverAfterLogMapper")
    private TDriverAfterLogMapper tDriverAfterLogMapper;

    @Autowired
    private IFileService fileService;
    /**
     * 查询行车后检查事项信息
     *
     * @param driverLogId 行车后检查事项ID
     * @return 行车后检查事项信息
     */
    @Override
    public TDriverAfterLog selectTDriverAfterLogById(String driverLogId) {
        return tDriverAfterLogMapper.selectTDriverAfterLogById(driverLogId);
    }

    /**
     * 查询行车后检查事项列表
     *
     * @param tDriverAfterLog 行车后检查事项信息
     * @return 行车后检查事项集合
     */
    @Override
    public List<TDriverAfterLog> selectTDriverAfterLogList(TDriverAfterLog tDriverAfterLog) {
        return tDriverAfterLogMapper.selectTDriverAfterLogList(tDriverAfterLog);
    }

    /**
     * 新增行车后检查事项
     *
     * @param tDriverAfterLog 行车后检查事项信息
     * @return 结果
     */
    @Override
    public int insertTDriverAfterLog(TDriverAfterLog tDriverAfterLog) {
        tDriverAfterLog.setCreateDate(new Date());
        tDriverAfterLog.setAddUserId(ShiroUtils.getUserId().toString());
        return tDriverAfterLogMapper.insertTDriverAfterLog(tDriverAfterLog);
    }

    /**
     * 修改行车后检查事项
     *
     * @param tDriverAfterLog 行车后检查事项信息
     * @return 结果
     */
    @Override
    public int updateTDriverAfterLog(TDriverAfterLog tDriverAfterLog) {
        /*文件上传*/
        //签名图片上传
        try {
            if (Objects.nonNull(tDriverAfterLog.getNewAutographFile()) && StringUtils.isNotEmpty(tDriverAfterLog.getNewAutographFile().getOriginalFilename())) {
                String upolad = this.fileService.upolad("xingchehouqianming", tDriverAfterLog.getDriverLogId(), "行车日志行车后签名附件文件", tDriverAfterLog.getNewAutographFile(), 0,tDriverAfterLog.getBusinessId());
                tDriverAfterLog.setAutograph(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //照片文件上传
        List<String> newPhotoUrl = new ArrayList<>();
        if (tDriverAfterLog.getNewPhotoFiles() != null && !tDriverAfterLog.getNewPhotoFiles().isEmpty()) {
            tDriverAfterLog.getNewPhotoFiles().forEach(e -> {
                try {
                    if (Objects.nonNull(e) && StringUtils.isNotEmpty(e.getOriginalFilename())) {
                        String upolad = this.fileService.upolad("xingchehouzhaopian", tDriverAfterLog.getDriverLogId(), "行车日志行车后照片附件文件", tDriverAfterLog.getNewAutographFile(), 0,tDriverAfterLog.getBusinessId());
                        newPhotoUrl.add(upolad);
                    }
                } catch (IOException i) {
                    i.printStackTrace();
                }
            });
        }
        //拼接最终的照片图片(思考了一番,前端入参中有之前存在且本次修改依旧存在的urls,和本次新增的图片的url一拼接,把数据库的覆盖了,,不就是最新的吗???)
        StringBuffer finalPhotoUrl = new StringBuffer();
        if (tDriverAfterLog.getUpdatePhotoUrls() != null && !tDriverAfterLog.getUpdatePhotoUrls().isEmpty()) {
            //拼接原有的url
            tDriverAfterLog.getUpdatePhotoUrls().forEach(e -> {
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
        tDriverAfterLog.setDrivingPhoto(
                finalPhotoUrl.length() > 0 ?
                        finalPhotoUrl.substring(0, finalPhotoUrl.length() - 1) : "");
        //update公共
        tDriverAfterLog.setUpdateTime(new Date());
        tDriverAfterLog.setUpdateUserId(ShiroUtils.getUserId().toString());
        return tDriverAfterLogMapper.updateTDriverAfterLog(tDriverAfterLog);
    }

    /**
     * 删除行车后检查事项对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTDriverAfterLogByIds(String ids) {
        return tDriverAfterLogMapper.deleteTDriverAfterLogByIds(Convert.toStrArray(ids));
    }
    //以上自动生成的尽量别动
}
