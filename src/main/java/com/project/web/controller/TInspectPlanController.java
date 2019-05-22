package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TInspectPlan;
import com.project.web.service.ITInspectPlanService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 检查计划 信息操作处理
 *
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/system/tInspectPlan")
public class TInspectPlanController extends BaseController {
    private String prefix = "system/tInspectPlan";

    @Autowired
    private ITInspectPlanService tInspectPlanService;

    @RequiresPermissions("system:tInspectPlan:view")
    @GetMapping()
    public String tInspectPlan() {
        return prefix + "/tInspectPlan";
    }

    /**
     * 查询检查计划列表
     */
    @RequiresPermissions("system:tInspectPlan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TInspectPlan tInspectPlan) {
        startPage();
        List<TInspectPlan> list = tInspectPlanService.selectTInspectPlanList(tInspectPlan);
        return getDataTable(list);
    }

    /**
     * 新增检查计划
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存检查计划
     */
    @RequiresPermissions("system:tInspectPlan:add")
    @Log(title = "检查计划", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TInspectPlan tInspectPlan) {
        return toAjax(tInspectPlanService.insertTInspectPlan(tInspectPlan));
    }

    /**
     * 修改检查计划
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TInspectPlan tInspectPlan = tInspectPlanService.selectTInspectPlanById(id);
        mmap.put("tInspectPlan", tInspectPlan);
        return prefix + "/edit";
    }

    /**
     * 修改保存检查计划
     */
    @RequiresPermissions("system:tInspectPlan:edit")
    @Log(title = "检查计划", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TInspectPlan tInspectPlan) {
        return toAjax(tInspectPlanService.updateTInspectPlan(tInspectPlan));
    }

    /**
     * 删除检查计划
     */
    @RequiresPermissions("system:tInspectPlan:remove")
    @Log(title = "检查计划", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tInspectPlanService.deleteTInspectPlanByIds(ids));
    }

}
