package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TEmergencyPlanRelease;
import com.project.web.mapper.TEmergencyPlanReleaseMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITEmergencyPlanReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 应急预案发布 服务层实现
 *
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TEmergencyPlanReleaseServiceImpl implements ITEmergencyPlanReleaseService {
    @Autowired
    private TEmergencyPlanReleaseMapper tEmergencyPlanReleaseMapper;
    @Autowired
    private IFileService fileService;
    /**
     * 查询应急预案发布信息
     *
     * @param id 应急预案发布ID
     * @return 应急预案发布信息
     */
    @Override
    public TEmergencyPlanRelease selectTEmergencyPlanReleaseById(String id) {
        return tEmergencyPlanReleaseMapper.selectTEmergencyPlanReleaseById(id);
    }

    /**
     * 查询应急预案发布列表
     *
     * @param tEmergencyPlanRelease 应急预案发布信息
     * @return 应急预案发布集合
     */
    @Override
    public List<TEmergencyPlanRelease> selectTEmergencyPlanReleaseList(TEmergencyPlanRelease tEmergencyPlanRelease) {
        return tEmergencyPlanReleaseMapper.selectTEmergencyPlanReleaseList(tEmergencyPlanRelease);
    }

    /**
     * 新增应急预案发布
     *
     * @param tEmergencyPlanRelease 应急预案发布信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTEmergencyPlanRelease(TEmergencyPlanRelease tEmergencyPlanRelease, MultipartFile planReleaseFile) {
        //校验
        AjaxResult result = this.insertValidation(tEmergencyPlanRelease);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传
        try {
            if (Objects.nonNull(planReleaseFile) && StringUtils.isNotEmpty(planReleaseFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("yingjiyuanfabu", uuid, "应急预案发布附件文件", planReleaseFile, 0);
                tEmergencyPlanRelease.setFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //insert公共
        tEmergencyPlanRelease.setId(uuid);
        tEmergencyPlanRelease.setCreateTime(new Date());
        tEmergencyPlanRelease.setUserId(ShiroUtils.getUserId());
        return tEmergencyPlanReleaseMapper.insertTEmergencyPlanRelease(tEmergencyPlanRelease) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改应急预案发布
     *
     * @param tEmergencyPlanRelease 应急预案发布信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTEmergencyPlanRelease(TEmergencyPlanRelease tEmergencyPlanRelease, MultipartFile planReleaseFile) {
        //校验
        AjaxResult result = this.insertValidation(tEmergencyPlanRelease);
        if (result != null) {
            return result;
        }
        //文件上传
        try {
            if (Objects.nonNull(planReleaseFile) && StringUtils.isNotEmpty(planReleaseFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("yingjiyuanfabu", tEmergencyPlanRelease.getId(), "应急预案发布附件文件", planReleaseFile, 0);
                tEmergencyPlanRelease.setFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //update公共
        tEmergencyPlanRelease.setUpdateTime(new Date());
        tEmergencyPlanRelease.setUpdateUserId(ShiroUtils.getUserId());
        return tEmergencyPlanReleaseMapper.updateTEmergencyPlanRelease(tEmergencyPlanRelease) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除应急预案发布对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTEmergencyPlanReleaseByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tEmergencyPlanReleaseMapper.deleteTEmergencyPlanReleaseByIds(Convert.toStrArray(ids));
        }
        return 0;
    }



    private AjaxResult insertValidation(TEmergencyPlanRelease tEmergencyPlanRelease) {
        //应急预案发布：预案名称   预案类型(没有这个字段)  发布日期
        if (ValidationUtils.objIsNull(tEmergencyPlanRelease.getPlanName())) {
            return AjaxResult.error(2, "预案名称不能为空");
        }
        if (ValidationUtils.objIsNull(tEmergencyPlanRelease.getReleaseDate())) {
            return AjaxResult.error(2, "发布日期不能为空");
        }
        return null;
    }

}
