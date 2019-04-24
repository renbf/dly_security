package com.project.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Date;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.project.web.mapper.TDrivingLicenseLogMapper;
import com.project.web.domian.TDrivingLicenseLog;
import com.project.web.service.ITDrivingLicenseLogService;
import com.project.common.support.Convert;

/**
 * 行驶证变更 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TDrivingLicenseLogServiceImpl implements ITDrivingLicenseLogService 
{
	private static final Logger log = LoggerFactory.getLogger(TDrivingLicenseLogServiceImpl.class);
	@Autowired
	@Qualifier("tDrivingLicenseLogMapper")
	private TDrivingLicenseLogMapper tDrivingLicenseLogMapper;

	/**
     * 查询行驶证变更信息
     * 
     * @param id 行驶证变更ID
     * @return 行驶证变更信息
     */
    @Override
	public TDrivingLicenseLog selectTDrivingLicenseLogById(String id)
	{
	    return tDrivingLicenseLogMapper.selectTDrivingLicenseLogById(id);
	}
	
	/**
     * 查询行驶证变更列表
     * 
     * @param tDrivingLicenseLog 行驶证变更信息
     * @return 行驶证变更集合
     */
	@Override
	public List<TDrivingLicenseLog> selectTDrivingLicenseLogList(TDrivingLicenseLog tDrivingLicenseLog)
	{
	    return tDrivingLicenseLogMapper.selectTDrivingLicenseLogList(tDrivingLicenseLog);
	}
	
    /**
     * 新增行驶证变更
     * 
     * @param tDrivingLicenseLog 行驶证变更信息
     * @return 结果
     */
	@Override
	public int insertTDrivingLicenseLog(TDrivingLicenseLog tDrivingLicenseLog)
	{
		tDrivingLicenseLog.setId(UUIDUtil.getUUID());
	    return tDrivingLicenseLogMapper.insertTDrivingLicenseLog(tDrivingLicenseLog);
	}
	
	/**
     * 修改行驶证变更
     * 
     * @param tDrivingLicenseLog 行驶证变更信息
     * @return 结果
     */
	@Override
	public int updateTDrivingLicenseLog(TDrivingLicenseLog tDrivingLicenseLog)
	{
	    return tDrivingLicenseLogMapper.updateTDrivingLicenseLog(tDrivingLicenseLog);
	}

	/**
     * 删除行驶证变更对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTDrivingLicenseLogByIds(String ids)
	{
		return tDrivingLicenseLogMapper.deleteTDrivingLicenseLogByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
