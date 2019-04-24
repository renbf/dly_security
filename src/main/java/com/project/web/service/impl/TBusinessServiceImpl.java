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
import com.project.web.mapper.TBusinessMapper;
import com.project.web.domian.TBusiness;
import com.project.web.service.ITBusinessService;
import com.project.common.support.Convert;

/**
 * 企业管理 服务层实现
 * 
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TBusinessServiceImpl implements ITBusinessService 
{
	private static final Logger log = LoggerFactory.getLogger(TBusinessServiceImpl.class);
	@Autowired
	@Qualifier("tBusinessMapper")
	private TBusinessMapper tBusinessMapper;

	/**
     * 查询企业管理信息
     * 
     * @param id 企业管理ID
     * @return 企业管理信息
     */
    @Override
	public TBusiness selectTBusinessById(String id)
	{
	    return tBusinessMapper.selectTBusinessById(id);
	}
	
	/**
     * 查询企业管理列表
     * 
     * @param tBusiness 企业管理信息
     * @return 企业管理集合
     */
	@Override
	public List<TBusiness> selectTBusinessList(TBusiness tBusiness)
	{
	    return tBusinessMapper.selectTBusinessList(tBusiness);
	}
	
    /**
     * 新增企业管理
     * 
     * @param tBusiness 企业管理信息
     * @return 结果
     */
	@Override
	public int insertTBusiness(TBusiness tBusiness)
	{
		tBusiness.setId(UUIDUtil.getUUID());
		tBusiness.setCreateDate(new Date());
		tBusiness.setAddUserId(ShiroUtils.getUserId().toString());
	    return tBusinessMapper.insertTBusiness(tBusiness);
	}
	
	/**
     * 修改企业管理
     * 
     * @param tBusiness 企业管理信息
     * @return 结果
     */
	@Override
	public int updateTBusiness(TBusiness tBusiness)
	{
	    return tBusinessMapper.updateTBusiness(tBusiness);
	}

	/**
     * 删除企业管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTBusinessByIds(String ids)
	{
		return tBusinessMapper.deleteTBusinessByIds(Convert.toStrArray(ids));
	}
	//以上自动生成的尽量别动
}
