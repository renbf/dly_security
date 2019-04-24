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
import com.project.web.mapper.TCarInsuranceMapper;
import com.project.web.domian.TCarInsurance;
import com.project.web.service.ITCarInsuranceService;
import com.project.common.support.Convert;

/**
 * 车辆保险情况 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TCarInsuranceServiceImpl implements ITCarInsuranceService 
{
	private static final Logger log = LoggerFactory.getLogger(TCarInsuranceServiceImpl.class);
	@Autowired
	@Qualifier("tCarInsuranceMapper")
	private TCarInsuranceMapper tCarInsuranceMapper;

	/**
     * 查询车辆保险情况信息
     * 
     * @param id 车辆保险情况ID
     * @return 车辆保险情况信息
     */
    @Override
	public TCarInsurance selectTCarInsuranceById(String id)
	{
	    return tCarInsuranceMapper.selectTCarInsuranceById(id);
	}
	
	/**
     * 查询车辆保险情况列表
     * 
     * @param tCarInsurance 车辆保险情况信息
     * @return 车辆保险情况集合
     */
	@Override
	public List<TCarInsurance> selectTCarInsuranceList(TCarInsurance tCarInsurance)
	{
	    return tCarInsuranceMapper.selectTCarInsuranceList(tCarInsurance);
	}
	
    /**
     * 新增车辆保险情况
     * 
     * @param tCarInsurance 车辆保险情况信息
     * @return 结果
     */
	@Override
	public int insertTCarInsurance(TCarInsurance tCarInsurance)
	{
		tCarInsurance.setId(UUIDUtil.getUUID());
		tCarInsurance.setCreateDate(new Date());
		tCarInsurance.setAddUserId(ShiroUtils.getUserId().toString());
	    return tCarInsuranceMapper.insertTCarInsurance(tCarInsurance);
	}
	
	/**
     * 修改车辆保险情况
     * 
     * @param tCarInsurance 车辆保险情况信息
     * @return 结果
     */
	@Override
	public int updateTCarInsurance(TCarInsurance tCarInsurance)
	{
	    return tCarInsuranceMapper.updateTCarInsurance(tCarInsurance);
	}

	/**
     * 删除车辆保险情况对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCarInsuranceByIds(String ids)
	{
		return tCarInsuranceMapper.deleteTCarInsuranceByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
