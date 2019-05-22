package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TAccidentAnalysisTopic;
import com.project.web.domian.TAccidentInvestigation;
import com.project.web.mapper.TAccidentAnalysisTopicMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITAccidentAnalysisTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 事故分析专题会议 服务层实现
 *
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TAccidentAnalysisTopicServiceImpl implements ITAccidentAnalysisTopicService {
    @Autowired
    private TAccidentAnalysisTopicMapper tAccidentAnalysisTopicMapper;
    @Autowired
    private IFileService fileService;
    /**
     * 查询事故分析专题会议信息
     *
     * @param id 事故分析专题会议ID
     * @return 事故分析专题会议信息
     */
    @Override
    public TAccidentAnalysisTopic selectTAccidentAnalysisTopicById(String id) {
        return tAccidentAnalysisTopicMapper.selectTAccidentAnalysisTopicById(id);
    }

    /**
     * 查询事故分析专题会议列表
     *
     * @param tAccidentAnalysisTopic 事故分析专题会议信息
     * @return 事故分析专题会议集合
     */
    @Override
    public List<TAccidentAnalysisTopic> selectTAccidentAnalysisTopicList(TAccidentAnalysisTopic tAccidentAnalysisTopic) {
        return tAccidentAnalysisTopicMapper.selectTAccidentAnalysisTopicList(tAccidentAnalysisTopic);
    }

    /**
     * 新增事故分析专题会议
     *
     * @param tAccidentAnalysisTopic 事故分析专题会议信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTAccidentAnalysisTopic(TAccidentAnalysisTopic tAccidentAnalysisTopic, MultipartFile file) {
        //校验
        AjaxResult result = this.insertValidation(tAccidentAnalysisTopic);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("shigufenxizhuantihuiyi", uuid, "事故分析专题会议附件文件", file, 0,tAccidentAnalysisTopic.getBusinessId());
                tAccidentAnalysisTopic.setFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //insert公共
        tAccidentAnalysisTopic.setId(uuid);
        tAccidentAnalysisTopic.setCreateTime(new Date());
        tAccidentAnalysisTopic.setUserId(ShiroUtils.getUserId());
        return tAccidentAnalysisTopicMapper.insertTAccidentAnalysisTopic(tAccidentAnalysisTopic) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }


    /**
     * 查询事故报告根据基础id
     *
     * @param basicsId 基础表id
     * @return 结果
     */
    @Override
    public AjaxResult selectTAccidentAnalysisTopicByBasicsId(String basicsId) {
        TAccidentAnalysisTopic accidentAnalysisTopic = new TAccidentAnalysisTopic();
        accidentAnalysisTopic.setAccidentBasiscId(basicsId);
        List<TAccidentAnalysisTopic> tAccidentAnalysisTopics = this.tAccidentAnalysisTopicMapper.selectTAccidentAnalysisTopicList(accidentAnalysisTopic);
        if (tAccidentAnalysisTopics.isEmpty()) {
            return AjaxResult.error(2, "查询失败");
        }
        TAccidentAnalysisTopic analysisTopic = tAccidentAnalysisTopics.get(0);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("data", analysisTopic);
        return ajaxResult;
    }

    /**
     * 修改事故分析专题会议
     *
     * @param tAccidentAnalysisTopic 事故分析专题会议信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTAccidentAnalysisTopic(TAccidentAnalysisTopic tAccidentAnalysisTopic, MultipartFile file) {
        //校验
        AjaxResult result = this.insertValidation(tAccidentAnalysisTopic);
        if (result != null) {
            return result;
        }
        //文件上传
        try {
            if (Objects.nonNull(file) && StringUtils.isNotEmpty(file.getOriginalFilename())) {
                String upolad = this.fileService.upolad("shigufenxizhuantihuiyi", tAccidentAnalysisTopic.getId(), "事故分析专题会议附件文件", file, 0,tAccidentAnalysisTopic.getBusinessId());
                tAccidentAnalysisTopic.setFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //update公共
        tAccidentAnalysisTopic.setUpdateTime(new Date());
        tAccidentAnalysisTopic.setUpdateUserId(ShiroUtils.getUserId());
        return tAccidentAnalysisTopicMapper.updateTAccidentAnalysisTopic(tAccidentAnalysisTopic) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除事故分析专题会议对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTAccidentAnalysisTopicByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tAccidentAnalysisTopicMapper.deleteTAccidentAnalysisTopicByIds(Convert.toStrArray(ids));
        }
        return 0;
    }

    private AjaxResult insertValidation(TAccidentAnalysisTopic obj) {
        //分析专题会议：会议名称 会议日期  会议地点  主持人
        if (ValidationUtils.objIsNull(obj.getTopicName())) {
            return AjaxResult.error(2, "会议名称不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getTopicDate())) {
            return AjaxResult.error(2, "会议日期不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getTopicPlace())) {
            return AjaxResult.error(2, "会议地点不能为空");
        }
        if (ValidationUtils.objIsNull(obj.getTopicHost())) {
            return AjaxResult.error(2, "主持人不能为空");
        }
        return null;
    }

}
