package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TContingencyDrillPlan;
import com.project.web.service.ITContingencyDrillPlanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 应急演练计划 信息操作处理
 *
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/security/tContingencyDrillPlan")
public class TContingencyDrillPlanController extends BaseController {
    private String prefix = "security/tContingencyDrillPlan";

    @Autowired
    private ITContingencyDrillPlanService tContingencyDrillPlanService;

    @RequiresPermissions("system:tContingencyDrillPlan:view")
    @GetMapping()
    public String tContingencyDrillPlan() {
        return prefix + "/tContingencyDrillPlan";
    }

    /**
     * 查询应急演练计划列表
     */
    //@RequiresPermissions("system:tContingencyDrillPlan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TContingencyDrillPlan tContingencyDrillPlan) {
        startPage();
        List<TContingencyDrillPlan> list = tContingencyDrillPlanService.selectTContingencyDrillPlanList(tContingencyDrillPlan);
        return getDataTable(list);
    }

    /**
     * 新增应急演练计划
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存应急演练计划
     */
    //@RequiresPermissions("system:tContingencyDrillPlan:add")
    @Log(title = "应急演练计划", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TContingencyDrillPlan tContingencyDrillPlan, MultipartFile drillPlanFile) {
        return toAjax(tContingencyDrillPlanService.insertTContingencyDrillPlan(tContingencyDrillPlan, drillPlanFile));
    }

    /**
     * 修改应急演练计划
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TContingencyDrillPlan tContingencyDrillPlan = tContingencyDrillPlanService.selectTContingencyDrillPlanById(id);
        mmap.put("tContingencyDrillPlan", tContingencyDrillPlan);
        return prefix + "/edit";
    }

    /**
     * 修改保存应急演练计划
     */
    //@RequiresPermissions("system:tContingencyDrillPlan:edit")
    @Log(title = "应急演练计划", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TContingencyDrillPlan tContingencyDrillPlan,MultipartFile drillPlanFile) {
        return toAjax(tContingencyDrillPlanService.updateTContingencyDrillPlan(tContingencyDrillPlan,drillPlanFile));
    }

    /**
     * 删除应急演练计划
     */
    //@RequiresPermissions("system:tContingencyDrillPlan:remove")
    @Log(title = "应急演练计划", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tContingencyDrillPlanService.deleteTContingencyDrillPlanByIds(ids));
    }

}
