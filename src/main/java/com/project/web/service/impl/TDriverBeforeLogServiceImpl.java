package com.project.web.service.impl;

import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.web.domian.TDriverBeforeLog;
import com.project.web.mapper.TDriverBeforeLogMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITDriverBeforeLogService;
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
 * 行车前检查事项 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TDriverBeforeLogServiceImpl implements ITDriverBeforeLogService {
    private static final Logger log = LoggerFactory.getLogger(TDriverBeforeLogServiceImpl.class);
    @Autowired
    @Qualifier("tDriverBeforeLogMapper")
    private TDriverBeforeLogMapper tDriverBeforeLogMapper;

    @Autowired
    private IFileService fileService;

    /**
     * 查询行车前检查事项信息
     *
     * @param driverLogId 行车前检查事项ID
     * @return 行车前检查事项信息
     */
    @Override
    public TDriverBeforeLog selectTDriverBeforeLogById(String driverLogId) {
        return tDriverBeforeLogMapper.selectTDriverBeforeLogById(driverLogId);
    }

    /**
     * 查询行车前检查事项列表
     *
     * @param tDriverBeforeLog 行车前检查事项信息
     * @return 行车前检查事项集合
     */
    @Override
    public List<TDriverBeforeLog> selectTDriverBeforeLogList(TDriverBeforeLog tDriverBeforeLog) {
        return tDriverBeforeLogMapper.selectTDriverBeforeLogList(tDriverBeforeLog);
    }

    /**
     * 新增行车前检查事项
     *
     * @param tDriverBeforeLog 行车前检查事项信息
     * @return 结果
     */
    @Override
    public int insertTDriverBeforeLog(TDriverBeforeLog tDriverBeforeLog) {
        tDriverBeforeLog.setCreateDate(new Date());
        tDriverBeforeLog.setAddUserId(ShiroUtils.getUserId().toString());
        return tDriverBeforeLogMapper.insertTDriverBeforeLog(tDriverBeforeLog);
    }

    /**
     * 修改行车前检查事项
     *
     * @param tDriverBeforeLog 行车前检查事项信息
     * @return 结果
     */
    @Override
    public int updateTDriverBeforeLog(TDriverBeforeLog tDriverBeforeLog) {
        /*文件上传*/
        //签名图片上传
        try {
            if (Objects.nonNull(tDriverBeforeLog.getNewAutographFile()) && StringUtils.isNotEmpty(tDriverBeforeLog.getNewAutographFile().getOriginalFilename())) {
                String upolad = this.fileService.upolad("xingcheqianqianming", tDriverBeforeLog.getDriverLogId(), "行车日志行车前签名附件文件", tDriverBeforeLog.getNewAutographFile(), 0,tDriverBeforeLog.getBusinessId());
                tDriverBeforeLog.setAutograph(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //照片文件上传
        List<String> newPhotoUrl = new ArrayList<>();
        if (tDriverBeforeLog.getNewPhotoFiles() != null && !tDriverBeforeLog.getNewPhotoFiles().isEmpty()) {
            tDriverBeforeLog.getNewPhotoFiles().forEach(e -> {
                try {
                    if (Objects.nonNull(e) && StringUtils.isNotEmpty(e.getOriginalFilename())) {
                        String upolad = this.fileService.upolad("xingcheqianzhaopian", tDriverBeforeLog.getDriverLogId(), "行车日志行车前照片附件文件", tDriverBeforeLog.getNewAutographFile(), 0,tDriverBeforeLog.getBusinessId());
                        newPhotoUrl.add(upolad);
                    }
                } catch (IOException i) {
                    i.printStackTrace();
                }
            });
        }
        //拼接最终的照片图片(思考了一番,前端入参中有之前存在且本次修改依旧存在的urls,和本次新增的图片的url一拼接,把数据库的覆盖了,,不就是最新的吗???)
        StringBuffer finalPhotoUrl = new StringBuffer();
        if (tDriverBeforeLog.getUpdatePhotoUrls() != null && !tDriverBeforeLog.getUpdatePhotoUrls().isEmpty()) {
            //拼接原有的url
            tDriverBeforeLog.getUpdatePhotoUrls().forEach(e -> {
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
        tDriverBeforeLog.setDrivePhotoUrl(
                finalPhotoUrl.length() > 0 ?
                        finalPhotoUrl.substring(0, finalPhotoUrl.length() - 1) : "");
        //update公共
        tDriverBeforeLog.setUpdateTime(new Date());
        tDriverBeforeLog.setUpdateUserId(ShiroUtils.getUserId().toString());
        return tDriverBeforeLogMapper.updateTDriverBeforeLog(tDriverBeforeLog);
    }

    /**
     * 删除行车前检查事项对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTDriverBeforeLogByIds(String ids) {
        return tDriverBeforeLogMapper.deleteTDriverBeforeLogByIds(Convert.toStrArray(ids));
    }
    //以上自动生成的尽量别动
}
