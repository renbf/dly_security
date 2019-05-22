package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TInspectPlanMain;
import com.project.web.service.ITInspectPlanMainService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 检查计划主 信息操作处理
 *
 * @author rbf
 * @date 2019-05-05
 */
@Controller
@RequestMapping("/web/tInspectPlanMain")
public class TInspectPlanMainController extends BaseController {
    private String prefix = "web/tInspectPlanMain";

    @Autowired
    private ITInspectPlanMainService tInspectPlanMainService;

    @RequiresPermissions("web:tInspectPlanMain:view")
    @GetMapping()
    public String tInspectPlanMain() {
        return prefix + "/tInspectPlanMain";
    }

    /**
     * 查询检查计划主列表
     */
    @RequiresPermissions("web:tInspectPlanMain:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TInspectPlanMain tInspectPlanMain) {
        startPage();
        List<TInspectPlanMain> list = tInspectPlanMainService.selectTInspectPlanMainList(tInspectPlanMain);
        return getDataTable(list);
    }

    /**
     * 新增检查计划主
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存检查计划主
     */
    @RequiresPermissions("web:tInspectPlanMain:add")
    @Log(title = "检查计划主", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TInspectPlanMain tInspectPlanMain) {
        return tInspectPlanMainService.insertTInspectPlanMain(tInspectPlanMain);
    }

    /**
     * 修改检查计划主
     */
    @GetMapping("/edit/{titleId}")
    public String edit(@PathVariable("titleId") String titleId, ModelMap mmap) {
        TInspectPlanMain tInspectPlanMain = tInspectPlanMainService.selectTInspectPlanMainById(titleId);
        mmap.put("tInspectPlanMain", tInspectPlanMain);
        return prefix + "/edit";
    }

    /**
     * 修改保存检查计划主
     */
    @RequiresPermissions("web:tInspectPlanMain:edit")
    @Log(title = "检查计划主", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TInspectPlanMain tInspectPlanMain) {
        return tInspectPlanMainService.updateTInspectPlanMain(tInspectPlanMain);
    }

    /**
     * 删除检查计划主
     */
    @RequiresPermissions("web:tInspectPlanMain:remove")
    @Log(title = "检查计划主", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tInspectPlanMainService.deleteTInspectPlanMainByIds(ids));
    }

}
