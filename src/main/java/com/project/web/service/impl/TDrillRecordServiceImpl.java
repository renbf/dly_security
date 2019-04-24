package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TDrillRecord;
import com.project.web.mapper.TDrillRecordMapper;
import com.project.web.service.ITDrillRecordService;

/**
 * 演练记录 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TDrillRecordServiceImpl implements ITDrillRecordService 
{
	@Autowired
	private TDrillRecordMapper tDrillRecordMapper;

	/**
     * 查询演练记录信息
     * 
     * @param id 演练记录ID
     * @return 演练记录信息
     */
    @Override
	public TDrillRecord selectTDrillRecordById(String id)
	{
	    return tDrillRecordMapper.selectTDrillRecordById(id);
	}
	
	/**
     * 查询演练记录列表
     * 
     * @param tDrillRecord 演练记录信息
     * @return 演练记录集合
     */
	@Override
	public List<TDrillRecord> selectTDrillRecordList(TDrillRecord tDrillRecord)
	{
	    return tDrillRecordMapper.selectTDrillRecordList(tDrillRecord);
	}
	
    /**
     * 新增演练记录
     * 
     * @param tDrillRecord 演练记录信息
     * @return 结果
     */
	@Override
	public int insertTDrillRecord(TDrillRecord tDrillRecord)
	{
		tDrillRecord.setId(UUIDUtil.getUUID());
		tDrillRecord.setCreateTime(new Date());
		return tDrillRecordMapper.insertTDrillRecord(tDrillRecord);
	}
	
	/**
     * 修改演练记录
     * 
     * @param tDrillRecord 演练记录信息
     * @return 结果
     */
	@Override
	public int updateTDrillRecord(TDrillRecord tDrillRecord)
	{
	    return tDrillRecordMapper.updateTDrillRecord(tDrillRecord);
	}

	/**
     * 删除演练记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTDrillRecordByIds(String ids)
	{
		return tDrillRecordMapper.deleteTDrillRecordByIds(Convert.toStrArray(ids));
	}
	
}
