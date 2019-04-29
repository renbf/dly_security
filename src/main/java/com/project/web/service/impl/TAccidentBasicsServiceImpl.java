package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TAccidentAnalysisTopic;
import com.project.web.domian.TAccidentBasics;
import com.project.web.domian.TAccidentInvestigation;
import com.project.web.domian.TAccidentReport;
import com.project.web.mapper.TAccidentAnalysisTopicMapper;
import com.project.web.mapper.TAccidentBasicsMapper;
import com.project.web.mapper.TAccidentInvestigationMapper;
import com.project.web.mapper.TAccidentReportMapper;
import com.project.web.service.ITAccidentBasicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 事故基础 服务层实现
 *
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TAccidentBasicsServiceImpl implements ITAccidentBasicsService {
    @Autowired
    protected TAccidentAnalysisTopicMapper accidentAnalysisTopicMapper;
    @Autowired
    private TAccidentBasicsMapper tAccidentBasicsMapper;
    @Autowired
    private TAccidentInvestigationMapper accidentInvestigationMapper;
    @Autowired
    private TAccidentReportMapper accidentReportMapper;

    /**
     * 查询事故基础信息
     *
     * @param id 事故基础ID
     * @return 事故基础信息
     */
    @Override
    public TAccidentBasics selectTAccidentBasicsById(String id) {
        return tAccidentBasicsMapper.selectTAccidentBasicsById(id);
    }

    /**
     * 查询事故基础列表
     *
     * @param tAccidentBasics 事故基础信息
     * @return 事故基础集合
     */
    @Override
    public List<TAccidentBasics> selectTAccidentBasicsList(TAccidentBasics tAccidentBasics) {
        return tAccidentBasicsMapper.selectTAccidentBasicsList(tAccidentBasics);
    }

    /**
     * 新增事故基础
     *
     * @param tAccidentBasics 事故基础信息
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult insertTAccidentBasics(TAccidentBasics tAccidentBasics) {
        //校验
        AjaxResult result = this.insertValidation(tAccidentBasics);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传 //没有
        //insert公共
        tAccidentBasics.setId(uuid);
        tAccidentBasics.setCreateTime(new Date());
        tAccidentBasics.setUserId(ShiroUtils.getUserId());
        /*添加附表信息*/
        //报告表
        TAccidentReport accidentReport = new TAccidentReport();
        accidentReport.setId(UUIDUtil.getUUID());
        accidentReport.setAccidentBasiscId(uuid);
        int i = this.accidentReportMapper.insertTAccidentReport(accidentReport);
        //调查表
        TAccidentInvestigation accidentInvestigation = new TAccidentInvestigation();
        accidentInvestigation.setId(UUIDUtil.getUUID());
        accidentInvestigation.setAccidentBasiscId(uuid);
        int i1 = this.accidentInvestigationMapper.insertTAccidentInvestigation(accidentInvestigation);
        //事故分析专题会议表
        TAccidentAnalysisTopic accidentAnalysisTopic = new TAccidentAnalysisTopic();
        accidentAnalysisTopic.setId(UUIDUtil.getUUID());
        accidentAnalysisTopic.setAccidentBasiscId(uuid);
        int i2 = this.accidentAnalysisTopicMapper.insertTAccidentAnalysisTopic(accidentAnalysisTopic);
        //添加主表
        int i3 = tAccidentBasicsMapper.insertTAccidentBasics(tAccidentBasics);
        if (i <= 0 || i1 <= 0 || i2 <= 0 || i3 <= 0) {
            throw new RuntimeException();
        }
        return AjaxResult.success();
    }

    /**
     * 修改事故基础
     *
     * @param tAccidentBasics 事故基础信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTAccidentBasics(TAccidentBasics tAccidentBasics) {
        //校验
        AjaxResult result = this.insertValidation(tAccidentBasics);
        if (result != null) {
            return result;
        }
        //文件上传 //没有
        //update公共
        tAccidentBasics.setUpdateTime(new Date());
        tAccidentBasics.setUpdateUserId(ShiroUtils.getUserId());
        return tAccidentBasicsMapper.updateTAccidentBasics(tAccidentBasics) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除事故基础对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTAccidentBasicsByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tAccidentBasicsMapper.deleteTAccidentBasicsByIds(Convert.toStrArray(ids));
        }
        return 0;
    }


    private AjaxResult insertValidation(TAccidentBasics obj) {
        //基础信息：事故名称  事故类型   发生时间    责任人  责任部门
        if (ValidationUtils.objIsNull(obj.getAccidentName())) {
            return AjaxResult.error(2, "事故名称不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getAccidentType())) {
            return AjaxResult.error(2, "事故类型不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getHappenTime())) {
            return AjaxResult.error(2, "发生时间不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getAccidentResponsibility())) {
            return AjaxResult.error(2, "责任人不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getResponsibilityDeptName())) {
            return AjaxResult.error(2, "责任部门不能为空");
        }
        return null;
    }


}
