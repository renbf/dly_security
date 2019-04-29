package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.common.utils.ValidationUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TSafetyDuty;
import com.project.web.mapper.TSafetyDutyMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITSafetyDutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 安全值班 服务层实现
 *
 * @author rbf
 * @date 2019-04-18
 */
@Service
public class TSafetyDutyServiceImpl implements ITSafetyDutyService {
    @Autowired
    private TSafetyDutyMapper tSafetyDutyMapper;
    @Autowired
    private IFileService fileService;

    /**
     * 查询安全值班信息
     *
     * @param id 安全值班ID
     * @return 安全值班信息
     */
    @Override
    public TSafetyDuty selectTSafetyDutyById(String id) {
        return tSafetyDutyMapper.selectTSafetyDutyById(id);
    }

    /**
     * 查询安全值班列表
     *
     * @param tSafetyDuty 安全值班信息
     * @return 安全值班集合
     */
    @Override
    public List<TSafetyDuty> selectTSafetyDutyList(TSafetyDuty tSafetyDuty) {
        return tSafetyDutyMapper.selectTSafetyDutyList(tSafetyDuty);
    }

    /**
     * 新增安全值班
     *
     * @param tSafetyDuty 安全值班信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTSafetyDuty(TSafetyDuty tSafetyDuty, MultipartFile dutyFile) {
        //校验
        AjaxResult result = this.inputValidation(tSafetyDuty);
        if (result != null) {
            return result;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传
        try {
            if (Objects.nonNull(dutyFile) && StringUtils.isNotEmpty(dutyFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("anquanzhiban", uuid, "安全值班附件文件", dutyFile, 0);
                tSafetyDuty.setDutyFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //insert公共属性
        tSafetyDuty.setId(uuid);
        tSafetyDuty.setCreateTime(new Date());
        tSafetyDuty.setUserId(ShiroUtils.getUserId());
        return tSafetyDutyMapper.insertTSafetyDuty(tSafetyDuty) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改安全值班
     *
     * @param tSafetyDuty 安全值班信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTSafetyDuty(TSafetyDuty tSafetyDuty, MultipartFile dutyFile) {
        //校验
        //文件上传
        try {
            if (Objects.nonNull(dutyFile) && StringUtils.isNotEmpty(dutyFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("anquanzhiban", tSafetyDuty.getId(), "安全值班附件文件", dutyFile, 0);
                tSafetyDuty.setDutyFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //update公共属性
        tSafetyDuty.setUpdateTime(new Date());
        tSafetyDuty.setUpdateUserId(ShiroUtils.getUserId());
        return tSafetyDutyMapper.updateTSafetyDuty(tSafetyDuty) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除安全值班对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTSafetyDutyByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tSafetyDutyMapper.deleteTSafetyDutyByIds(Convert.toStrArray(ids));
        }
        return 0;
    }


    private AjaxResult inputValidation(TSafetyDuty tSafetyDuty) {
        //安全值班：值班人员   值班类型   值班日期
        if (ValidationUtils.objIsNull(tSafetyDuty.getDutyPerson())) {
            return AjaxResult.error(2, "值班人员不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyDuty.getDutyType())) {
            return AjaxResult.error(2, "值班类型不能为空");
        }
        if (ValidationUtils.objIsNull(tSafetyDuty.getDutyDate())) {
            return AjaxResult.error(2, "值班日期不能为空");
        }
        return null;
    }

}