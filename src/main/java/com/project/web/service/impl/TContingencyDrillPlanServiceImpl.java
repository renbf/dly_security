package com.project.web.service.impl;

import com.project.common.support.Convert;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.util.UUIDUtil;
import com.project.web.domian.TContingencyDrillPlan;
import com.project.web.mapper.TContingencyDrillPlanMapper;
import com.project.web.service.IFileService;
import com.project.web.service.ITContingencyDrillPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 应急演练计划 服务层实现
 *
 * @author rbf
 * @date 2019-04-23
 */
@Service
public class TContingencyDrillPlanServiceImpl implements ITContingencyDrillPlanService {
    @Autowired
    private TContingencyDrillPlanMapper tContingencyDrillPlanMapper;
    @Autowired
    private IFileService fileService;

    /**
     * 查询应急演练计划信息
     *
     * @param id 应急演练计划ID
     * @return 应急演练计划信息
     */
    @Override
    public TContingencyDrillPlan selectTContingencyDrillPlanById(String id) {
        return tContingencyDrillPlanMapper.selectTContingencyDrillPlanById(id);
    }

    /**
     * 查询应急演练计划列表
     *
     * @param tContingencyDrillPlan 应急演练计划信息
     * @return 应急演练计划集合
     */
    @Override
    public List<TContingencyDrillPlan> selectTContingencyDrillPlanList(TContingencyDrillPlan tContingencyDrillPlan) {
        return tContingencyDrillPlanMapper.selectTContingencyDrillPlanList(tContingencyDrillPlan);
    }

    /**
     * 新增应急演练计划
     *
     * @param tContingencyDrillPlan 应急演练计划信息
     * @return 结果
     */
    @Override
    public int insertTContingencyDrillPlan(TContingencyDrillPlan tContingencyDrillPlan, MultipartFile drillPlanFile) {
        String uuid = UUIDUtil.getUUID();
        //校验
        //目标文件上传和保存
        try {
            if (Objects.nonNull(drillPlanFile) && StringUtils.isNotEmpty(drillPlanFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("yingjiyanlianjihua", uuid, "应急演练计划附件文件", drillPlanFile, 0);
                tContingencyDrillPlan.setDrillPlanFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tContingencyDrillPlan.setId(uuid);
        tContingencyDrillPlan.setCreateTime(new Date());
        tContingencyDrillPlan.setUserId(ShiroUtils.getUserId());
        return tContingencyDrillPlanMapper.insertTContingencyDrillPlan(tContingencyDrillPlan);
    }

    /**
     * 修改应急演练计划
     *
     * @param tContingencyDrillPlan 应急演练计划信息
     * @return 结果
     */
    @Override
    public int updateTContingencyDrillPlan(TContingencyDrillPlan tContingencyDrillPlan, MultipartFile drillPlanFile) {
        //校验
        //目标文件上传和保存
        try {
            if (Objects.nonNull(drillPlanFile) && StringUtils.isNotEmpty(drillPlanFile.getOriginalFilename())) {
                String upolad = this.fileService.upolad("yingjiyanlianjihua", tContingencyDrillPlan.getId(), "应急演练计划附件文件", drillPlanFile, 0);
                tContingencyDrillPlan.setDrillPlanFilePath(upolad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tContingencyDrillPlan.setUpdateTime(new Date());
        tContingencyDrillPlan.setUpdateUserId(ShiroUtils.getUserId());
        return tContingencyDrillPlanMapper.updateTContingencyDrillPlan(tContingencyDrillPlan);
    }

    /**
     * 删除应急演练计划对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTContingencyDrillPlanByIds(String ids) {
        if (ids != null && !ids.equals("")) {
            return tContingencyDrillPlanMapper.deleteTContingencyDrillPlanByIds(Convert.toStrArray(ids));
        }
        return 0;
    }

}
