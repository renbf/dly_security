package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TEmergencyPlanRelease;
import com.project.web.service.ITEmergencyPlanReleaseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 应急预案发布 信息操作处理
 *
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/web/tEmergencyPlanRelease")
public class TEmergencyPlanReleaseController extends BaseController {
    private String prefix = "web/tEmergencyPlanRelease";

    @Autowired
    private ITEmergencyPlanReleaseService tEmergencyPlanReleaseService;

    @RequiresPermissions("web:tEmergencyPlanRelease:view")
    @GetMapping()
    public String tEmergencyPlanRelease() {
        return prefix + "/tEmergencyPlanRelease";
    }

    /**
     * 查询应急预案发布列表
     */
    //@RequiresPermissions("web:tEmergencyPlanRelease:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TEmergencyPlanRelease tEmergencyPlanRelease) {
        startPage();
        List<TEmergencyPlanRelease> list = tEmergencyPlanReleaseService.selectTEmergencyPlanReleaseList(tEmergencyPlanRelease);
        return getDataTable(list);
    }

    /**
     * 新增应急预案发布
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存应急预案发布
     */
    //@RequiresPermissions("web:tEmergencyPlanRelease:add")
    @Log(title = "应急预案发布", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TEmergencyPlanRelease tEmergencyPlanRelease, MultipartFile planReleaseFile) {
        return tEmergencyPlanReleaseService.insertTEmergencyPlanRelease(tEmergencyPlanRelease, planReleaseFile);
    }

    /**
     * 修改应急预案发布
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TEmergencyPlanRelease tEmergencyPlanRelease = tEmergencyPlanReleaseService.selectTEmergencyPlanReleaseById(id);
        mmap.put("tEmergencyPlanRelease", tEmergencyPlanRelease);
        return prefix + "/edit";
    }

    /**
     * 修改保存应急预案发布
     */
    //@RequiresPermissions("web:tEmergencyPlanRelease:edit")
    @Log(title = "应急预案发布", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TEmergencyPlanRelease tEmergencyPlanRelease, MultipartFile planReleaseFile) {
        return tEmergencyPlanReleaseService.updateTEmergencyPlanRelease(tEmergencyPlanRelease, planReleaseFile);
    }

    /**
     * 删除应急预案发布
     */
    //@RequiresPermissions("web:tEmergencyPlanRelease:remove")
    @Log(title = "应急预案发布", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tEmergencyPlanReleaseService.deleteTEmergencyPlanReleaseByIds(ids));
    }

}
