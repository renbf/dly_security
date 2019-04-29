package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TAccidentAnalysisTopic;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 事故分析专题会议 服务层
 *
 * @author rbf
 * @date 2019-04-17
 */
public interface ITAccidentAnalysisTopicService {
    /**
     * 查询事故分析专题会议信息
     *
     * @param id 事故分析专题会议ID
     * @return 事故分析专题会议信息
     */
    public TAccidentAnalysisTopic selectTAccidentAnalysisTopicById(String id);

    /**
     * 查询事故分析专题会议列表
     *
     * @param tAccidentAnalysisTopic 事故分析专题会议信息
     * @return 事故分析专题会议集合
     */
    public List<TAccidentAnalysisTopic> selectTAccidentAnalysisTopicList(TAccidentAnalysisTopic tAccidentAnalysisTopic);

    /**
     * 新增事故分析专题会议
     *
     * @param tAccidentAnalysisTopic 事故分析专题会议信息
     * @return 结果
     */
    public AjaxResult insertTAccidentAnalysisTopic(TAccidentAnalysisTopic tAccidentAnalysisTopic, MultipartFile file);

    /**
     * 查询事故报告根据基础id
     *
     * @param basicsId 基础表id
     * @return 结果
     */
    public AjaxResult selectTAccidentAnalysisTopicByBasicsId(String basicsId);

    /**
     * 修改事故分析专题会议
     *
     * @param tAccidentAnalysisTopic 事故分析专题会议信息
     * @return 结果
     */
    public AjaxResult updateTAccidentAnalysisTopic(TAccidentAnalysisTopic tAccidentAnalysisTopic, MultipartFile file);

    /**
     * 删除事故分析专题会议信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTAccidentAnalysisTopicByIds(String ids);

}
