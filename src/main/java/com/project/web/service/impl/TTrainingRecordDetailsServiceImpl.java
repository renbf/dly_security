package com.project.web.service.impl;

import com.project.common.support.Convert;
import com.project.web.domian.TTrainingRecordDetails;
import com.project.web.mapper.TTrainingRecordDetailsMapper;
import com.project.web.service.ITTrainingRecordDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 培训记录详情 服务层实现
 *
 * @author rbf
 * @date 2019-04-26
 */
@Service
public class TTrainingRecordDetailsServiceImpl implements ITTrainingRecordDetailsService {
    @Autowired
    private TTrainingRecordDetailsMapper tTrainingRecordDetailsMapper;

    /**
     * 查询培训记录详情信息
     *
     * @param id 培训记录详情ID
     * @return 培训记录详情信息
     */
    @Override
    public TTrainingRecordDetails selectTTrainingRecordDetailsById(String id) {
        return tTrainingRecordDetailsMapper.selectTTrainingRecordDetailsById(id);
    }

    /**
     * 查询培训记录详情列表
     *
     * @param tTrainingRecordDetails 培训记录详情信息
     * @return 培训记录详情集合
     */
    @Override
    public List<TTrainingRecordDetails> selectTTrainingRecordDetailsList(TTrainingRecordDetails tTrainingRecordDetails) {
        return tTrainingRecordDetailsMapper.selectTTrainingRecordDetailsList(tTrainingRecordDetails);
    }

    /**
     * 新增培训记录详情
     *
     * @param tTrainingRecordDetails 培训记录详情信息
     * @return 结果
     */
    @Override
    public int insertTTrainingRecordDetails(TTrainingRecordDetails tTrainingRecordDetails) {
        return tTrainingRecordDetailsMapper.insertTTrainingRecordDetails(tTrainingRecordDetails);
    }

    /**
     * 修改培训记录详情
     *
     * @param tTrainingRecordDetails 培训记录详情信息
     * @return 结果
     */
    @Override
    public int updateTTrainingRecordDetails(TTrainingRecordDetails tTrainingRecordDetails) {
        return tTrainingRecordDetailsMapper.updateTTrainingRecordDetails(tTrainingRecordDetails);
    }

    /**
     * 删除培训记录详情对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTTrainingRecordDetailsByIds(String ids) {
        return tTrainingRecordDetailsMapper.deleteTTrainingRecordDetailsByIds(Convert.toStrArray(ids));
    }

}
