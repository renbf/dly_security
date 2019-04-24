package com.project.web.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.common.support.Convert;
import com.project.util.UUIDUtil;
import com.project.web.domian.TSafetyFeeAccount;
import com.project.web.mapper.TSafetyFeeAccountMapper;
import com.project.web.service.ITSafetyFeeAccountService;

/**
 * 安全费用台账 服务层实现
 * 
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TSafetyFeeAccountServiceImpl implements ITSafetyFeeAccountService 
{
	@Autowired
	private TSafetyFeeAccountMapper tSafetyFeeAccountMapper;

	/**
     * 查询安全费用台账信息
     * 
     * @param id 安全费用台账ID
     * @return 安全费用台账信息
     */
    @Override
	public TSafetyFeeAccount selectTSafetyFeeAccountById(String id)
	{
	    return tSafetyFeeAccountMapper.selectTSafetyFeeAccountById(id);
	}
	
	/**
     * 查询安全费用台账列表
     * 
     * @param tSafetyFeeAccount 安全费用台账信息
     * @return 安全费用台账集合
     */
	@Override
	public List<TSafetyFeeAccount> selectTSafetyFeeAccountList(TSafetyFeeAccount tSafetyFeeAccount)
	{
	    return tSafetyFeeAccountMapper.selectTSafetyFeeAccountList(tSafetyFeeAccount);
	}
	
    /**
     * 新增安全费用台账
     * 
     * @param tSafetyFeeAccount 安全费用台账信息
     * @return 结果
     */
	@Override
	public int insertTSafetyFeeAccount(TSafetyFeeAccount tSafetyFeeAccount)
	{
		tSafetyFeeAccount.setId(UUIDUtil.getUUID());
		tSafetyFeeAccount.setCreateTime(new Date());
		return tSafetyFeeAccountMapper.insertTSafetyFeeAccount(tSafetyFeeAccount);
	}
	
	/**
     * 修改安全费用台账
     * 
     * @param tSafetyFeeAccount 安全费用台账信息
     * @return 结果
     */
	@Override
	public int updateTSafetyFeeAccount(TSafetyFeeAccount tSafetyFeeAccount)
	{
	    return tSafetyFeeAccountMapper.updateTSafetyFeeAccount(tSafetyFeeAccount);
	}

	/**
     * 删除安全费用台账对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTSafetyFeeAccountByIds(String ids)
	{
		return tSafetyFeeAccountMapper.deleteTSafetyFeeAccountByIds(Convert.toStrArray(ids));
	}
	
}
