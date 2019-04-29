package com.project.web.mapper;

import com.project.web.domian.TTrainingRecord;

import java.util.List;

/**
 * 培训记录 数据层
 *
 * @author rbf
 * @date 2019-04-17
 */
public interface TTrainingRecordMapper {
    /**
     * 查询培训记录信息
     *
     * @param id 培训记录ID
     * @return 培训记录信息
     */
    public TTrainingRecord selectTTrainingRecordById(String id);

    /**
     * 查询培训记录列表
     *
     * @param tTrainingRecord 培训记录信息
     * @return 培训记录集合
     */
    public List<TTrainingRecord> selectTTrainingRecordList(TTrainingRecord tTrainingRecord);

    /**
     * 新增培训记录
     *
     * @param tTrainingRecord 培训记录信息
     * @return 结果
     */
    public int insertTTrainingRecord(TTrainingRecord tTrainingRecord);

    /**
     * 修改培训记录
     *
     * @param tTrainingRecord 培训记录信息
     * @return 结果
     */
    public int updateTTrainingRecord(TTrainingRecord tTrainingRecord);

    /**
     * 删除培训记录
     *
     * @param id 培训记录ID
     * @return 结果
     */
    public int deleteTTrainingRecordById(String id);

    /**
     * 批量删除培训记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTTrainingRecordByIds(String[] ids);

}