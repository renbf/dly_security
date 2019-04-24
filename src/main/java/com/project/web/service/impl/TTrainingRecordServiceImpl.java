package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TTrainingRecord;
import com.project.web.mapper.TTrainingRecordMapper;
import com.project.web.service.ITTrainingRecordService;

/**
 * 培训记录 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TTrainingRecordServiceImpl implements ITTrainingRecordService 
{
	@Autowired
	private TTrainingRecordMapper tTrainingRecordMapper;

	/**
     * 查询培训记录信息
     * 
     * @param id 培训记录ID
     * @return 培训记录信息
     */
    @Override
	public TTrainingRecord selectTTrainingRecordById(String id)
	{
	    return tTrainingRecordMapper.selectTTrainingRecordById(id);
	}
	
	/**
     * 查询培训记录列表
     * 
     * @param tTrainingRecord 培训记录信息
     * @return 培训记录集合
     */
	@Override
	public List<TTrainingRecord> selectTTrainingRecordList(TTrainingRecord tTrainingRecord)
	{
	    return tTrainingRecordMapper.selectTTrainingRecordList(tTrainingRecord);
	}
	
    /**
     * 新增培训记录
     * 
     * @param tTrainingRecord 培训记录信息
     * @return 结果
     */
	@Override
	public int insertTTrainingRecord(TTrainingRecord tTrainingRecord)
	{
		tTrainingRecord.setId(UUIDUtil.getUUID());
		tTrainingRecord.setCreateTime(new Date());
		return tTrainingRecordMapper.insertTTrainingRecord(tTrainingRecord);
	}
	
	/**
     * 修改培训记录
     * 
     * @param tTrainingRecord 培训记录信息
     * @return 结果
     */
	@Override
	public int updateTTrainingRecord(TTrainingRecord tTrainingRecord)
	{
	    return tTrainingRecordMapper.updateTTrainingRecord(tTrainingRecord);
	}

	/**
     * 删除培训记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTTrainingRecordByIds(String ids)
	{
		return tTrainingRecordMapper.deleteTTrainingRecordByIds(Convert.toStrArray(ids));
	}
	
}
