package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TLegalProvisions;
import com.project.web.mapper.TLegalProvisionsMapper;
import com.project.web.service.ITLegalProvisionsService;

/**
 * 法律法规 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TLegalProvisionsServiceImpl implements ITLegalProvisionsService 
{
	@Autowired
	private TLegalProvisionsMapper tLegalProvisionsMapper;

	/**
     * 查询法律法规信息
     * 
     * @param id 法律法规ID
     * @return 法律法规信息
     */
    @Override
	public TLegalProvisions selectTLegalProvisionsById(String id)
	{
	    return tLegalProvisionsMapper.selectTLegalProvisionsById(id);
	}
	
	/**
     * 查询法律法规列表
     * 
     * @param tLegalProvisions 法律法规信息
     * @return 法律法规集合
     */
	@Override
	public List<TLegalProvisions> selectTLegalProvisionsList(TLegalProvisions tLegalProvisions)
	{
	    return tLegalProvisionsMapper.selectTLegalProvisionsList(tLegalProvisions);
	}
	
    /**
     * 新增法律法规
     * 
     * @param tLegalProvisions 法律法规信息
     * @return 结果
     */
	@Override
	public int insertTLegalProvisions(TLegalProvisions tLegalProvisions)
	{
		tLegalProvisions.setId(UUIDUtil.getUUID());
		tLegalProvisions.setCreateTime(new Date());
		return tLegalProvisionsMapper.insertTLegalProvisions(tLegalProvisions);
	}
	
	/**
     * 修改法律法规
     * 
     * @param tLegalProvisions 法律法规信息
     * @return 结果
     */
	@Override
	public int updateTLegalProvisions(TLegalProvisions tLegalProvisions)
	{
	    return tLegalProvisionsMapper.updateTLegalProvisions(tLegalProvisions);
	}

	/**
     * 删除法律法规对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTLegalProvisionsByIds(String ids)
	{
		return tLegalProvisionsMapper.deleteTLegalProvisionsByIds(Convert.toStrArray(ids));
	}
	
}
