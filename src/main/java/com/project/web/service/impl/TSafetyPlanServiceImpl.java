package com.project.web.service.impl;

import com.project.common.base.AjaxResult;
import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TSafetyPlan;
import com.project.web.mapper.TSafetyPlanMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITSafetyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 安全计划 服务层实现
 *
 * @author rbf
 * @date 2019-04-17
 */
@Service
public class TSafetyPlanServiceImpl implements ITSafetyPlanService {
    @Autowired
    private TSafetyPlanMapper tSafetyPlanMapper;
    @Autowired
    private IFileService fileService;

    /**
     * 查询安全计划信息
     *
     * @param id 安全计划ID
     * @return 安全计划信息
     */
    @Override
    public TSafetyPlan selectTSafetyPlanById(String id) {
        return tSafetyPlanMapper.selectTSafetyPlanById(id);
    }

    /**
     * 查询安全计划列表
     *
     * @param tSafetyPlan 安全计划信息
     * @return 安全计划集合
     */
    @Override
    public List<TSafetyPlan> selectTSafetyPlanList(TSafetyPlan tSafetyPlan) {
        return tSafetyPlanMapper.selectTSafetyPlanList(tSafetyPlan);
    }

    /**
     * 新增安全计划
     *
     * @param tSafetyPlan 安全计划信息
     * @return 结果
     */
    @Override
    public AjaxResult insertTSafetyPlan(TSafetyPlan tSafetyPlan, MultipartFile planFile) {
        String uuid = UUIDUtil.getUUID();
        //校验

        //目标文件上传和保存
        try {
            if (Objects.nonNull(planFile) && StringUtils.isNotEmpty(planFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("anquanjihua", uuid, "安全计划附件文件", planFile, 0,tSafetyPlan.getBusinessId());
                tSafetyPlan.setPlanFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tSafetyPlan.setId(uuid);
        tSafetyPlan.setCreateTime(new Date());
        tSafetyPlan.setUserId(ShiroUtils.getUserId());
        return tSafetyPlanMapper.insertTSafetyPlan(tSafetyPlan) > 0 ?
                AjaxResult.success() : AjaxResult.error(1, "操作失败");
    }

    /**
     * 修改安全计划
     *
     * @param tSafetyPlan 安全计划信息
     * @return 结果
     */
    @Override
    public AjaxResult updateTSafetyPlan(TSafetyPlan tSafetyPlan, MultipartFile planFile) {
        //校验
        //目标文件上传和保存
        try {
            if (Objects.nonNull(planFile) && StringUtils.isNotEmpty(planFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("anquanjihua", tSafetyPlan.getId(), "安全计划附件文件", planFile, 0,tSafetyPlan.getBusinessId());
                tSafetyPlan.setPlanFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tSafetyPlan.setUpdateTime(new Date());
        tSafetyPlan.setUpdateUserId(ShiroUtils.getUserId());
        return tSafetyPlanMapper.updateTSafetyPlan(tSafetyPlan) > 0 ?
                AjaxResult.success() : AjaxResult.error(1, "操作失败");
    }

    /**
     * 删除安全计划对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTSafetyPlanByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tSafetyPlanMapper.deleteTSafetyPlanByIds(Convert.toStrArray(ids));
        }
        return 0;
    }

}
