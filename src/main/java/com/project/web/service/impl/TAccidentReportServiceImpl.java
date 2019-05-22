package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TAccidentReport;
import com.project.web.mapper.TAccidentReportMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITAccidentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 事故报告 服务层实现
 *
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TAccidentReportServiceImpl implements ITAccidentReportService {
    @Autowired
    private TAccidentReportMapper tAccidentReportMapper;
    @Autowired
    private IFileService fileService;

    /**
     * 查询事故报告信息
     *
     * @param id 事故报告ID
     * @return 事故报告信息
     */
    @Override
    public TAccidentReport selectTAccidentReportById(String id) {
        return tAccidentReportMapper.selectTAccidentReportById(id);
    }

    /**
     * 查询事故报告列表
     *
     * @param tAccidentReport 事故报告信息
     * @return 事故报告集合
     */
    @Override
    public List<TAccidentReport> selectTAccidentReportList(TAccidentReport tAccidentReport) {
        return tAccidentReportMapper.selectTAccidentReportList(tAccidentReport);
    }

    /**
     * 查询事故报告根据基础id
     * @param basicsId 基础表id
     * @return
     */
    @Override
    public AjaxResult selectTAccidentReportByBasicsId(String basicsId) {
        TAccidentReport accidentReport = new TAccidentReport();
        accidentReport.setAccidentBasiscId(basicsId);
        List<TAccidentReport> accidentReports = this.tAccidentReportMapper.selectTAccidentReportList(accidentReport);
        if (accidentReports.isEmpty()) {
            return AjaxResult.error(2, "查询失败");
        }
        TAccidentReport report = accidentReports.get(0);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("data", report);
        return ajaxResult;
    }

    /**
     * 新增事故报告
     *
     * @param tAccidentReport 事故报告信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTAccidentReport(TAccidentReport tAccidentReport, MultipartFile file) {
        //校验
        AjaxResult result = this.insertValidation(tAccidentReport);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("shigubaogao", uuid, "事故报告附件文件", file, 0,tAccidentReport.getBusinessId());
                tAccidentReport.setFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //insert公共
        tAccidentReport.setId(uuid);
        tAccidentReport.setCreateTime(new Date());
        tAccidentReport.setUserId(ShiroUtils.getUserId());
        return tAccidentReportMapper.insertTAccidentReport(tAccidentReport) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改事故报告
     *
     * @param tAccidentReport 事故报告信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTAccidentReport(TAccidentReport tAccidentReport, MultipartFile file) {
        //校验
        AjaxResult result = this.insertValidation(tAccidentReport);
        if (result != null) {
            return result;
        }
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("shigubaogao", tAccidentReport.getId(), "事故报告附件文件", file, 0,tAccidentReport.getBusinessId());
                tAccidentReport.setFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //update公共
        tAccidentReport.setUpdateTime(new Date());
        tAccidentReport.setUpdateUserId(ShiroUtils.getUserId());
        return tAccidentReportMapper.updateTAccidentReport(tAccidentReport) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除事故报告对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTAccidentReportByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tAccidentReportMapper.deleteTAccidentReportByIds(Convert.toStrArray(ids));
        }
        return 0;
    }

    private AjaxResult insertValidation(TAccidentReport obj) {
        //事故报告：事故名称  事故日期   事故时间  驾驶员  车牌号   事故地点   事故原因  所属部门
        if (ValidationUtils.objIsNull(obj.getAccidentName())) {
            return AjaxResult.error(2, "事故名称不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getAccidentDate())) {
            return AjaxResult.error(2, "事故日期不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getAccidentTime())) {
            return AjaxResult.error(2, "事故时间不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getAccidentDriver())) {
            return AjaxResult.error(2, "驾驶员不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getLicenseNumber())) {
            return AjaxResult.error(2, "车牌号不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getAccidentPlace())) {
            return AjaxResult.error(2, "事故地点不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getAccidentReason())) {
            return AjaxResult.error(2, "事故原因不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getDeptName())) {
            return AjaxResult.error(2, "所属部门不能为空");
        }
        return null;
    }

}
