package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TSafetyFeeAccount;
import com.project.web.mapper.TSafetyFeeAccountMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITSafetyFeeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 安全费用台账 服务层实现
 *
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TSafetyFeeAccountServiceImpl implements ITSafetyFeeAccountService {
    @Autowired
    private TSafetyFeeAccountMapper tSafetyFeeAccountMapper;
    @Autowired
    private IFileService fileService;

    /**
     * 查询安全费用台账信息
     *
     * @param id 安全费用台账ID
     * @return 安全费用台账信息
     */
    @Override
    public TSafetyFeeAccount selectTSafetyFeeAccountById(String id) {
        return tSafetyFeeAccountMapper.selectTSafetyFeeAccountById(id);
    }

    /**
     * 查询安全费用台账列表
     *
     * @param tSafetyFeeAccount 安全费用台账信息
     * @return 安全费用台账集合
     */
    @Override
    public List<TSafetyFeeAccount> selectTSafetyFeeAccountList(TSafetyFeeAccount tSafetyFeeAccount) {
        return tSafetyFeeAccountMapper.selectTSafetyFeeAccountList(tSafetyFeeAccount);
    }

    /**
     * 新增安全费用台账
     *
     * @param tSafetyFeeAccount 安全费用台账信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTSafetyFeeAccount(TSafetyFeeAccount tSafetyFeeAccount, MultipartFile feeFile) {
        //校验
        AjaxResult result = this.insertValidation(tSafetyFeeAccount);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传
        try {
            if (Objects.nonNull(feeFile) && StringUtils.isNotEmpty(feeFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("anquanfeiyongtaizhang", uuid, "安全费用台账附件文件", feeFile, 0);
                tSafetyFeeAccount.setFeeFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //insert公共属性
        tSafetyFeeAccount.setId(uuid);
        tSafetyFeeAccount.setCreateTime(new Date());
        tSafetyFeeAccount.setUserId(ShiroUtils.getUserId());
        return tSafetyFeeAccountMapper.insertTSafetyFeeAccount(tSafetyFeeAccount) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改安全费用台账
     *
     * @param tSafetyFeeAccount 安全费用台账信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTSafetyFeeAccount(TSafetyFeeAccount tSafetyFeeAccount, MultipartFile feeFile) {
        //校验
        //文件上传
        try {
            if (Objects.nonNull(feeFile) && StringUtils.isNotEmpty(feeFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("anquanfeiyongtaizhang", tSafetyFeeAccount.getId(), "安全费用台账附件文件", feeFile, 0);
                tSafetyFeeAccount.setFeeFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //update公共属性
        tSafetyFeeAccount.setUpdateTime(new Date());
        tSafetyFeeAccount.setUpdateUserId(ShiroUtils.getUserId());
        return tSafetyFeeAccountMapper.updateTSafetyFeeAccount(tSafetyFeeAccount) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除安全费用台账对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTSafetyFeeAccountByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tSafetyFeeAccountMapper.deleteTSafetyFeeAccountByIds(Convert.toStrArray(ids));
        }
        return 0;
    }


    //空值校验
    private AjaxResult insertValidation(TSafetyFeeAccount tSafetyFeeAccount) {
        //安全费用台账：投入类别   使用日期  经办人   金额   投入部门  用途
        if (ValidationUtils.objIsNull(tSafetyFeeAccount.getInvestmentType())) {
            return AjaxResult.error(2, "投入类别不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyFeeAccount.getUseDate())) {
            return AjaxResult.error(2, "使用日期不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyFeeAccount.getChargePerson())) {
            return AjaxResult.error(2, "经办人不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyFeeAccount.getAmt())) {
            return AjaxResult.error(2, "金额不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyFeeAccount.getInvestmentDeptId())) {
            return AjaxResult.error(2, "投入部门不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyFeeAccount.getFeePurpose())) {
            return AjaxResult.error(2, "用途不能为空");
        }
        return null;
    }

}