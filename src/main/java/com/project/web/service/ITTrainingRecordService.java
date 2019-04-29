package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TTrainingRecord;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 培训记录 服务层
 *
 * @author rbf
 * @date 2019-04-17
 */
public interface ITTrainingRecordService {
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
    public AjaxResult insertTTrainingRecord(TTrainingRecord tTrainingRecord, MultipartFile trainFile);

    /**
     * 修改培训记录
     *
     * @param tTrainingRecord 培训记录信息
     * @return 结果
     */
    public AjaxResult updateTTrainingRecord(TTrainingRecord tTrainingRecord, MultipartFile trainFile);

    /**
     * 删除培训记录信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTTrainingRecordByIds(String ids);

}