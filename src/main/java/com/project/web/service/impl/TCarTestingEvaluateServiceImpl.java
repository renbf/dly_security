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
import com.project.web.mapper.TCarTestingEvaluateMapper;
import com.project.web.domian.TCarTestingEvaluate;
import com.project.web.service.ITCarTestingEvaluateService;
import com.project.common.support.Convert;

/**
 * 车辆检测和评定登记 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarTestingEvaluateServiceImpl implements ITCarTestingEvaluateService 
{
	private static final Logger log = LoggerFactory.getLogger(TCarTestingEvaluateServiceImpl.class);
	@Autowired
	@Qualifier("tCarTestingEvaluateMapper")
	private TCarTestingEvaluateMapper tCarTestingEvaluateMapper;

	/**
     * 查询车辆检测和评定登记信息
     * 
     * @param id 车辆检测和评定登记ID
     * @return 车辆检测和评定登记信息
     */
    @Override
	public TCarTestingEvaluate selectTCarTestingEvaluateById(String id)
	{
	    return tCarTestingEvaluateMapper.selectTCarTestingEvaluateById(id);
	}
	
	/**
     * 查询车辆检测和评定登记列表
     * 
     * @param tCarTestingEvaluate 车辆检测和评定登记信息
     * @return 车辆检测和评定登记集合
     */
	@Override
	public List<TCarTestingEvaluate> selectTCarTestingEvaluateList(TCarTestingEvaluate tCarTestingEvaluate)
	{
	    return tCarTestingEvaluateMapper.selectTCarTestingEvaluateList(tCarTestingEvaluate);
	}
	
    /**
     * 新增车辆检测和评定登记
     * 
     * @param tCarTestingEvaluate 车辆检测和评定登记信息
     * @return 结果
     */
	@Override
	public int insertTCarTestingEvaluate(TCarTestingEvaluate tCarTestingEvaluate)
	{
		tCarTestingEvaluate.setId(UUIDUtil.getUUID());
		tCarTestingEvaluate.setCreateDate(new Date());
		tCarTestingEvaluate.setAddUserId(ShiroUtils.getUserId().toString());
	    return tCarTestingEvaluateMapper.insertTCarTestingEvaluate(tCarTestingEvaluate);
	}
	
	/**
     * 修改车辆检测和评定登记
     * 
     * @param tCarTestingEvaluate 车辆检测和评定登记信息
     * @return 结果
     */
	@Override
	public int updateTCarTestingEvaluate(TCarTestingEvaluate tCarTestingEvaluate)
	{
	    return tCarTestingEvaluateMapper.updateTCarTestingEvaluate(tCarTestingEvaluate);
	}

	/**
     * 删除车辆检测和评定登记对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCarTestingEvaluateByIds(String ids)
	{
		return tCarTestingEvaluateMapper.deleteTCarTestingEvaluateByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
