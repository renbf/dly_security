package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TSafetyFeeAccount;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 安全费用台账 服务层
 *
 * @author rbf
 * @date 2019-04-18
 */
public interface ITSafetyFeeAccountService {
    /**
     * 查询安全费用台账信息
     *
     * @param id 安全费用台账ID
     * @return 安全费用台账信息
     */
    public TSafetyFeeAccount selectTSafetyFeeAccountById(String id);

    /**
     * 查询安全费用台账列表
     *
     * @param tSafetyFeeAccount 安全费用台账信息
     * @return 安全费用台账集合
     */
    public List<TSafetyFeeAccount> selectTSafetyFeeAccountList(TSafetyFeeAccount tSafetyFeeAccount);

    /**
     * 新增安全费用台账
     *
     * @param tSafetyFeeAccount 安全费用台账信息
     * @return 结果
     */
    public AjaxResult insertTSafetyFeeAccount(TSafetyFeeAccount tSafetyFeeAccount, MultipartFile feeFile);

    /**
     * 修改安全费用台账
     *
     * @param tSafetyFeeAccount 安全费用台账信息
     * @return 结果
     */
    public AjaxResult updateTSafetyFeeAccount(TSafetyFeeAccount tSafetyFeeAccount, MultipartFile feeFile);

    /**
     * 删除安全费用台账信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTSafetyFeeAccountByIds(String ids);

}