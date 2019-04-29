package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TSafetyResponsibility;
import com.project.web.mapper.TSafetyResponsibilityMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITSafetyResponsibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 安全责任 服务层实现
 *
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TSafetyResponsibilityServiceImpl implements ITSafetyResponsibilityService {
    @Autowired
    private TSafetyResponsibilityMapper tSafetyResponsibilityMapper;
    @Autowired
    private IFileService fileService;

    /**
     * 查询安全责任信息
     *
     * @param id 安全责任ID
     * @return 安全责任信息
     */
    @Override
    public TSafetyResponsibility selectTSafetyResponsibilityById(String id) {
        return tSafetyResponsibilityMapper.selectTSafetyResponsibilityById(id);
    }

    /**
     * 查询安全责任列表
     *
     * @param tSafetyResponsibility 安全责任信息
     * @return 安全责任集合
     */
    @Override
    public List<TSafetyResponsibility> selectTSafetyResponsibilityList(TSafetyResponsibility tSafetyResponsibility) {
        return tSafetyResponsibilityMapper.selectTSafetyResponsibilityList(tSafetyResponsibility);
    }

    /**
     * 新增安全责任
     *
     * @param tSafetyResponsibility 安全责任信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTSafetyResponsibility(TSafetyResponsibility tSafetyResponsibility, MultipartFile responsibilityFile) {
        //校验
        AjaxResult ajaxResult = this.commonNotNullValidation(tSafetyResponsibility);
        if (ajaxResult != null) {
            return ajaxResult;
        }
        String uuid = UUIDUtil.getUUID();
        //文件上传
        try {
            if (Objects.nonNull(responsibilityFile) && StringUtils.isNotEmpty(responsibilityFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("anquanzeren", uuid, "安全责任附件文件", responsibilityFile, 0);
                tSafetyResponsibility.setResponsibilityFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //公共属性添加
        tSafetyResponsibility.setId(uuid);
        tSafetyResponsibility.setCreateTime(new Date());
        tSafetyResponsibility.setUserId(ShiroUtils.getUserId());
        return tSafetyResponsibilityMapper.insertTSafetyResponsibility(tSafetyResponsibility) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 修改安全责任
     *
     * @param tSafetyResponsibility 安全责任信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTSafetyResponsibility(TSafetyResponsibility tSafetyResponsibility, MultipartFile responsibilityFile) {
        //校验??
        //文件上传
        try {
            if (Objects.nonNull(responsibilityFile) && StringUtils.isNotEmpty(responsibilityFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("anquanzeren", tSafetyResponsibility.getId(), "安全责任附件文件", responsibilityFile, 0);
                tSafetyResponsibility.setResponsibilityFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //修改公共属性改变
        tSafetyResponsibility.setUpdateTime(new Date());
        tSafetyResponsibility.setUpdateUserId(ShiroUtils.getUserId());
        return tSafetyResponsibilityMapper.updateTSafetyResponsibility(tSafetyResponsibility) > 0 ?
                AjaxResult.success() : AjaxResult.error(2, "操作失败");
    }

    /**
     * 删除安全责任对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTSafetyResponsibilityByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tSafetyResponsibilityMapper.deleteTSafetyResponsibilityByIds(Convert.toStrArray(ids));
        }
        return 0;
    }


    private AjaxResult commonNotNullValidation(TSafetyResponsibility tSafetyResponsibility) {
        if (this.validationNotNull(tSafetyResponsibility.getResponsibilityName())) {
            return AjaxResult.error(2, "文件名称不能为空");
        }
        if (this.validationNotNull(tSafetyResponsibility.getResponsibilityDate())) {
            return AjaxResult.error(2, "日期不能为空");
        }
        if (this.validationNotNull(tSafetyResponsibility.getDeptId())) {
            return AjaxResult.error(2, "部门不能为空");
        }
        if (this.validationNotNull(tSafetyResponsibility.getResponsibilityType())) {
            return AjaxResult.error(2, "类型不能为空");
        }
        return null;
    }


    private boolean validationNotNull(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            if (((String) obj).isEmpty()) {
                return true;
            }
        }
        return false;
    }


}
