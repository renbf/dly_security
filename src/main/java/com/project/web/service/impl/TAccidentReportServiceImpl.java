package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TAccidentReport;
import com.project.web.mapper.TAccidentReportMapper;
import com.project.web.service.ITAccidentReportService;

/**
 * 事故报告 服务层实现
 * 
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TAccidentReportServiceImpl implements ITAccidentReportService 
{
	@Autowired
	private TAccidentReportMapper tAccidentReportMapper;

	/**
     * 查询事故报告信息
     * 
     * @param id 事故报告ID
     * @return 事故报告信息
     */
    @Override
	public TAccidentReport selectTAccidentReportById(String id)
	{
	    return tAccidentReportMapper.selectTAccidentReportById(id);
	}
	
	/**
     * 查询事故报告列表
     * 
     * @param tAccidentReport 事故报告信息
     * @return 事故报告集合
     */
	@Override
	public List<TAccidentReport> selectTAccidentReportList(TAccidentReport tAccidentReport)
	{
	    return tAccidentReportMapper.selectTAccidentReportList(tAccidentReport);
	}
	
    /**
     * 新增事故报告
     * 
     * @param tAccidentReport 事故报告信息
     * @return 结果
     */
	@Override
	public int insertTAccidentReport(TAccidentReport tAccidentReport)
	{
		tAccidentReport.setId(UUIDUtil.getUUID());
		tAccidentReport.setCreateTime(new Date());
		tAccidentReport.setUserId(ShiroUtils.getUserId());
		return tAccidentReportMapper.insertTAccidentReport(tAccidentReport);
	}
	
	/**
     * 修改事故报告
     * 
     * @param tAccidentReport 事故报告信息
     * @return 结果
     */
	@Override
	public int updateTAccidentReport(TAccidentReport tAccidentReport)
	{
	    return tAccidentReportMapper.updateTAccidentReport(tAccidentReport);
	}

	/**
     * 删除事故报告对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTAccidentReportByIds(String ids)
	{
		return tAccidentReportMapper.deleteTAccidentReportByIds(Convert.toStrArray(ids));
	}
	
}
