package com.project.web.service.impl;

import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TInspectRecord;
import com.project.web.mapper.TInspectRecordMapper;
import com.project.web.service.ITInspectRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 检查记录 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TInspectRecordServiceImpl implements ITInspectRecordService {
    private static final Logger log = LoggerFactory.getLogger(TInspectRecordServiceImpl.class);
    @Autowired
    @Qualifier("tInspectRecordMapper")
    private TInspectRecordMapper tInspectRecordMapper;

    /**
     * 查询检查记录信息
     *
     * @param id 检查记录ID
     * @return 检查记录信息
     */
    @Override
    public TInspectRecord selectTInspectRecordById(String id) {
        return tInspectRecordMapper.selectTInspectRecordById(id);
    }

    /**
     * 查询检查记录列表
     *
     * @param tInspectRecord 检查记录信息
     * @return 检查记录集合
     */
    @Override
    public List<TInspectRecord> selectTInspectRecordList(TInspectRecord tInspectRecord) {
        return tInspectRecordMapper.selectTInspectRecordList(tInspectRecord);
    }

    /**
     * 新增检查记录
     *
     * @param tInspectRecord 检查记录信息
     * @return 结果
     */
    @Override
    public int insertTInspectRecord(TInspectRecord tInspectRecord) {
        tInspectRecord.setId(UUIDUtil.getUUID());
        return tInspectRecordMapper.insertTInspectRecord(tInspectRecord);
    }

    /**
     * 修改检查记录
     *
     * @param tInspectRecord 检查记录信息
     * @return 结果
     */
    @Override
    public int updateTInspectRecord(TInspectRecord tInspectRecord) {
        return tInspectRecordMapper.updateTInspectRecord(tInspectRecord);
    }

    /**
     * 删除检查记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTInspectRecordByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tInspectRecordMapper.deleteTInspectRecordByIds(Convert.toStrArray(ids));
        }
        return 0;
    }
    //以上自动生成的尽量别动
}
