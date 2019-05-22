package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TSafetyInvestment;
import com.project.web.mapper.TSafetyInvestmentMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITSafetyInvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 安全投入 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TSafetyInvestmentServiceImpl implements ITSafetyInvestmentService {
    @Autowired
    private TSafetyInvestmentMapper tSafetyInvestmentMapper;
    @Autowired
    private IFileService fileService;


    /**
     * 查询安全投入信息
     *
     * @param id 安全投入ID
     * @return 安全投入信息
     */
    @Override
    public TSafetyInvestment selectTSafetyInvestmentById(String id) {
        return tSafetyInvestmentMapper.selectTSafetyInvestmentById(id);
    }

    /**
     * 查询安全投入列表
     *
     * @param tSafetyInvestment 安全投入信息
     * @return 安全投入集合
     */
    @Override
    public List<TSafetyInvestment> selectTSafetyInvestmentList(TSafetyInvestment tSafetyInvestment) {
        return tSafetyInvestmentMapper.selectTSafetyInvestmentList(tSafetyInvestment);
    }

    /**
     * 新增安全投入
     *
     * @param tSafetyInvestment 安全投入信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTSafetyInvestment(TSafetyInvestment tSafetyInvestment, MultipartFile investmentFile) {
        //校验
        AjaxResult ajaxResult = this.insertValidation(tSafetyInvestment);
        if (ajaxResult != null) {
            return ajaxResult;
        }
        String uuid = UUIDUtil.getUUID();
        //上传文件
        try {
            if (Objects.nonNull(investmentFile) && StringUtils.isNotEmpty(investmentFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("anquantouru", uuid, "安全投入附件文件", investmentFile, 0,tSafetyInvestment.getBusinessId());
                tSafetyInvestment.setInvestmentFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //insert公共属性
        tSafetyInvestment.setId(uuid);
        tSafetyInvestment.setCreateTime(new Date());
        tSafetyInvestment.setUserId(ShiroUtils.getUserId());
        return tSafetyInvestmentMapper.insertTSafetyInvestment(tSafetyInvestment) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改安全投入
     *
     * @param tSafetyInvestment 安全投入信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTSafetyInvestment(TSafetyInvestment tSafetyInvestment, MultipartFile investmentFile) {
        //校验
        //无
        //上传文件
        try {
            if (Objects.nonNull(investmentFile) && StringUtils.isNotEmpty(investmentFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("anquantouru", tSafetyInvestment.getId(), "安全投入附件文件", investmentFile, 0,tSafetyInvestment.getBusinessId());
                tSafetyInvestment.setInvestmentFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //update公共属性
        tSafetyInvestment.setUpdateTime(new Date());
        tSafetyInvestment.setUpdateUserId(ShiroUtils.getUserId());
        return tSafetyInvestmentMapper.updateTSafetyInvestment(tSafetyInvestment) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除安全投入对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTSafetyInvestmentByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tSafetyInvestmentMapper.deleteTSafetyInvestmentByIds(Convert.toStrArray(ids));
        }
        return 0;
    }


    private AjaxResult insertValidation(TSafetyInvestment tSafetyInvestment) {
        //安全投入：投入年份  投入月份   投入类别   投入金额
        if (ValidationUtils.objIsNull(tSafetyInvestment.getInvestmentYear())) {
            return AjaxResult.error(2, "投入年份不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyInvestment.getInvestmentMonth())) {
            return AjaxResult.error(2, "投入月份不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyInvestment.getInvestmentType())) {
            return AjaxResult.error(2, "投入类型不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyInvestment.getInvestmentAmt())) {
            return AjaxResult.error(2, "投入金额不能为空");
        }
        return null;
    }


}
