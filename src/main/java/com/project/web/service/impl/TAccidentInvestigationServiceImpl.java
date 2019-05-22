package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TAccidentInvestigation;
import com.project.web.domian.TAccidentReport;
import com.project.web.mapper.TAccidentInvestigationMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITAccidentInvestigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 事故调查 服务层实现
 *
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TAccidentInvestigationServiceImpl implements ITAccidentInvestigationService {
    @Autowired
    private TAccidentInvestigationMapper tAccidentInvestigationMapper;

    @Autowired
    private IFileService fileService;

    /**
     * 查询事故调查信息
     *
     * @param id 事故调查ID
     * @return 事故调查信息
     */
    @Override
    public TAccidentInvestigation selectTAccidentInvestigationById(String id) {
        return tAccidentInvestigationMapper.selectTAccidentInvestigationById(id);
    }

    /**
     * 查询事故调查列表
     *
     * @param tAccidentInvestigation 事故调查信息
     * @return 事故调查集合
     */
    @Override
    public List<TAccidentInvestigation> selectTAccidentInvestigationList(TAccidentInvestigation tAccidentInvestigation) {
        return tAccidentInvestigationMapper.selectTAccidentInvestigationList(tAccidentInvestigation);
    }

    @Override
    public AjaxResult selectTAccidentInvestigationByBasicsId(String basicsId) {
        TAccidentInvestigation accidentInvestigation = new TAccidentInvestigation();
        accidentInvestigation.setAccidentBasiscId(basicsId);
        List<TAccidentInvestigation> accidentReports = this.tAccidentInvestigationMapper.selectTAccidentInvestigationList(accidentInvestigation);
        if (accidentReports.isEmpty()) {
            return AjaxResult.error(2, "查询失败");
        }
        TAccidentInvestigation investigation = accidentReports.get(0);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("data", investigation);
        return ajaxResult;
    }

    /**
     * 新增事故调查
     *
     * @param tAccidentInvestigation 事故调查信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTAccidentInvestigation(TAccidentInvestigation tAccidentInvestigation, MultipartFile file) {
        //校验
        AjaxResult result = this.insertValidation(tAccidentInvestigation);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("shigudiaocha", uuid, "事故调查附件文件", file, 0,tAccidentInvestigation.getBusinessId());
                tAccidentInvestigation.setFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //insert公共
        tAccidentInvestigation.setId(uuid);
        tAccidentInvestigation.setCreateTime(new Date());
        tAccidentInvestigation.setUserId(ShiroUtils.getUserId());
        return tAccidentInvestigationMapper.insertTAccidentInvestigation(tAccidentInvestigation) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改事故调查
     *
     * @param tAccidentInvestigation 事故调查信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTAccidentInvestigation(TAccidentInvestigation tAccidentInvestigation, MultipartFile file) {
        //校验
        AjaxResult result = this.insertValidation(tAccidentInvestigation);
        if (result != null) {
            return result;
        }
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("shigudiaocha", tAccidentInvestigation.getId(), "事故调查附件文件", file, 0,tAccidentInvestigation.getBusinessId());
                tAccidentInvestigation.setFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //update公共
        tAccidentInvestigation.setUpdateTime(new Date());
        tAccidentInvestigation.setUpdateUserId(ShiroUtils.getUserId());
        return tAccidentInvestigationMapper.updateTAccidentInvestigation(tAccidentInvestigation) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除事故调查对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTAccidentInvestigationByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tAccidentInvestigationMapper.deleteTAccidentInvestigationByIds(Convert.toStrArray(ids));
        }
        return 0;
    }

    private AjaxResult insertValidation(TAccidentInvestigation obj) {
        //事故调查：事故名称  所属部门   事故原因
        if (ValidationUtils.objIsNull(obj.getAccidentName())) {
            return AjaxResult.error(2, "事故名称不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getDeptName())) {
            return AjaxResult.error(2, "所属部门不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getAccidentReason())) {
            return AjaxResult.error(2, "事故原因不能为空");
        }
        return null;
    }

}
