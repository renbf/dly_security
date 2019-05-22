package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TInspectTeamProject;
import com.project.web.service.ITInspectTeamProjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 检查计划和检查项关系 信息操作处理
 *
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tInspectTeamProject")
public class TInspectTeamProjectController extends BaseController {
    private String prefix = "web/tInspectTeamProject";

    @Autowired
    private ITInspectTeamProjectService tInspectTeamProjectService;

    @RequiresPermissions("web:tInspectTeamProject:view")
    @GetMapping()
    public String tInspectTeamProject() {
        return prefix + "/tInspectTeamProject";
    }

    /**
     * 查询检查计划和检查项关系列表
     */
    @RequiresPermissions("web:tInspectTeamProject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TInspectTeamProject tInspectTeamProject) {
        startPage();
        List<TInspectTeamProject> list = tInspectTeamProjectService.selectTInspectTeamProjectList(tInspectTeamProject);
        return getDataTable(list);
    }

    /**
     * 新增检查计划和检查项关系
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存检查计划和检查项关系
     */
    @RequiresPermissions("web:tInspectTeamProject:add")
    @Log(title = "检查计划和检查项关系", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TInspectTeamProject tInspectTeamProject) {
        return toAjax(tInspectTeamProjectService.insertTInspectTeamProject(tInspectTeamProject));
    }

    /**
     * 修改检查计划和检查项关系
     */
    @GetMapping("/edit/{inspectPlanId}")
    public String edit(@PathVariable("inspectPlanId") String inspectPlanId, ModelMap mmap) {
        TInspectTeamProject tInspectTeamProject = tInspectTeamProjectService.selectTInspectTeamProjectById(inspectPlanId);
        mmap.put("tInspectTeamProject", tInspectTeamProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存检查计划和检查项关系
     */
    @RequiresPermissions("web:tInspectTeamProject:edit")
    @Log(title = "检查计划和检查项关系", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TInspectTeamProject tInspectTeamProject) {
        return toAjax(tInspectTeamProjectService.updateTInspectTeamProject(tInspectTeamProject));
    }

    /**
     * 删除检查计划和检查项关系
     */
    @RequiresPermissions("web:tInspectTeamProject:remove")
    @Log(title = "检查计划和检查项关系", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tInspectTeamProjectService.deleteTInspectTeamProjectByIds(ids));
    }

}
