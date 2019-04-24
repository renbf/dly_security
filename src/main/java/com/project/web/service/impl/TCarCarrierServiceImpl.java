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
import com.project.web.mapper.TCarCarrierMapper;
import com.project.web.domian.TCarCarrier;
import com.project.web.service.ITCarCarrierService;
import com.project.common.support.Convert;

/**
 * 承运人责任险 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarCarrierServiceImpl implements ITCarCarrierService 
{
	private static final Logger log = LoggerFactory.getLogger(TCarCarrierServiceImpl.class);
	@Autowired
	@Qualifier("tCarCarrierMapper")
	private TCarCarrierMapper tCarCarrierMapper;

	/**
     * 查询承运人责任险信息
     * 
     * @param id 承运人责任险ID
     * @return 承运人责任险信息
     */
    @Override
	public TCarCarrier selectTCarCarrierById(String id)
	{
	    return tCarCarrierMapper.selectTCarCarrierById(id);
	}
	
	/**
     * 查询承运人责任险列表
     * 
     * @param tCarCarrier 承运人责任险信息
     * @return 承运人责任险集合
     */
	@Override
	public List<TCarCarrier> selectTCarCarrierList(TCarCarrier tCarCarrier)
	{
	    return tCarCarrierMapper.selectTCarCarrierList(tCarCarrier);
	}
	
    /**
     * 新增承运人责任险
     * 
     * @param tCarCarrier 承运人责任险信息
     * @return 结果
     */
	@Override
	public int insertTCarCarrier(TCarCarrier tCarCarrier)
	{
		tCarCarrier.setId(UUIDUtil.getUUID());
		tCarCarrier.setCreateDate(new Date());
		tCarCarrier.setAddUserId(ShiroUtils.getUserId().toString());
	    return tCarCarrierMapper.insertTCarCarrier(tCarCarrier);
	}
	
	/**
     * 修改承运人责任险
     * 
     * @param tCarCarrier 承运人责任险信息
     * @return 结果
     */
	@Override
	public int updateTCarCarrier(TCarCarrier tCarCarrier)
	{
	    return tCarCarrierMapper.updateTCarCarrier(tCarCarrier);
	}

	/**
     * 删除承运人责任险对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCarCarrierByIds(String ids)
	{
		return tCarCarrierMapper.deleteTCarCarrierByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
