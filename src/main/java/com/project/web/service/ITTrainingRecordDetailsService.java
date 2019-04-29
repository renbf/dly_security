package com.project.web.service;

import com.project.web.domian.TTrainingRecordDetails;

import java.util.List;

/**
 * 培训记录详情 服务层
 *
 * @author rbf
 * @date 2019-04-26
 */
public interface ITTrainingRecordDetailsService {
    /**
     * 查询培训记录详情信息
     *
     * @param id 培训记录详情ID
     * @return 培训记录详情信息
     */
    public TTrainingRecordDetails selectTTrainingRecordDetailsById(String id);

    /**
     * 查询培训记录详情列表
     *
     * @param tTrainingRecordDetails 培训记录详情信息
     * @return 培训记录详情集合
     */
    public List<TTrainingRecordDetails> selectTTrainingRecordDetailsList(TTrainingRecordDetails tTrainingRecordDetails);

    /**
     * 新增培训记录详情
     *
     * @param tTrainingRecordDetails 培训记录详情信息
     * @return 结果
     */
    public int insertTTrainingRecordDetails(TTrainingRecordDetails tTrainingRecordDetails);

    /**
     * 修改培训记录详情
     *
     * @param tTrainingRecordDetails 培训记录详情信息
     * @return 结果
     */
    public int updateTTrainingRecordDetails(TTrainingRecordDetails tTrainingRecordDetails);

    /**
     * 删除培训记录详情信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTTrainingRecordDetailsByIds(String ids);

}
