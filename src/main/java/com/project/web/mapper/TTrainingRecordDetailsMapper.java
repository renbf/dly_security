package com.project.web.mapper;

import com.project.web.domian.TTrainingRecordDetails;

import java.util.List;

/**
 * 培训记录详情 数据层
 *
 * @author rbf
 * @date 2019-04-26
 */
public interface TTrainingRecordDetailsMapper {
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
     * 删除培训记录详情
     *
     * @param id 培训记录详情ID
     * @return 结果
     */
    public int deleteTTrainingRecordDetailsById(String id);

    /**
     * 批量删除培训记录详情
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTTrainingRecordDetailsByIds(String[] ids);

    /**
     * 批量删除培训记录详情,根据培训记录ID
     * @param trainingIds
     * @return
     */
    public int deleteTTrainingRecordDetailsByTrainingIds(String[] trainingIds);



    /**
     * 批量删除培训记录详情,根据培训记录ID
     * @param trainingIds
     * @return
     */
    public List<TTrainingRecordDetails> selectTTrainingRecordDetailsByTrainingIds(List<String> trainingIds);


}