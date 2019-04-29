package com.project.web.service;

import com.project.common.base.AjaxResult;
import com.project.web.domian.TSafetyInvestment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 安全投入 服务层
 *
 * @author rbf
 * @date 2019-04-23
 */
public interface ITSafetyInvestmentService {
    /**
     * 查询安全投入信息
     *
     * @param id 安全投入ID
     * @return 安全投入信息
     */
    public TSafetyInvestment selectTSafetyInvestmentById(String id);

    /**
     * 查询安全投入列表
     *
     * @param tSafetyInvestment 安全投入信息
     * @return 安全投入集合
     */
    public List<TSafetyInvestment> selectTSafetyInvestmentList(TSafetyInvestment tSafetyInvestment);

    /**
     * 新增安全投入
     *
     * @param tSafetyInvestment 安全投入信息
     * @return 结果
     */
    public AjaxResult insertTSafetyInvestment(TSafetyInvestment tSafetyInvestment, MultipartFile investmentFile);

    /**
     * 修改安全投入
     *
     * @param tSafetyInvestment 安全投入信息
     * @return 结果
     */
    public AjaxResult updateTSafetyInvestment(TSafetyInvestment tSafetyInvestment,MultipartFile investmentFile);

    /**
     * 删除安全投入信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTSafetyInvestmentByIds(String ids);

}
