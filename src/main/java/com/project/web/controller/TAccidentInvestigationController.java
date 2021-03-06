package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TAccidentInvestigation;
import com.project.web.service.ITAccidentInvestigationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 事故调查 信息操作处理
 *
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/web/tAccidentInvestigation")
public class TAccidentInvestigationController extends BaseController {
    private String prefix = "web/tAccidentInvestigation";

    @Autowired
    private ITAccidentInvestigationService tAccidentInvestigationService;

    @RequiresPermissions("web:tAccidentInvestigation:view")
    @GetMapping()
    public String tAccidentInvestigation() {
        return prefix + "/tAccidentInvestigation";
    }

    /**
     * 查询事故调查列表
     */
    //@RequiresPermissions("web:tAccidentInvestigation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TAccidentInvestigation tAccidentInvestigation) {
        startPage();
        List<TAccidentInvestigation> list = tAccidentInvestigationService.selectTAccidentInvestigationList(tAccidentInvestigation);
        return getDataTable(list);
    }


    /**
     * 查询事故报告根据基础表id
     */
    //@RequiresPermissions("web:tAccidentReport:list")
    @PostMapping("/selectByBasicsId")
    @ResponseBody
    public AjaxResult list(String basicsId) {
        return this.tAccidentInvestigationService.selectTAccidentInvestigationByBasicsId(basicsId);
    }


    /**
     * 新增事故调查
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存事故调查
     */
    //@RequiresPermissions("web:tAccidentInvestigation:add")
    @Log(title = "事故调查", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TAccidentInvestigation tAccidentInvestigation, MultipartFile file) {
        return tAccidentInvestigationService.insertTAccidentInvestigation(tAccidentInvestigation, file);
    }





    /**
     * 修改事故调查
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TAccidentInvestigation tAccidentInvestigation = tAccidentInvestigationService.selectTAccidentInvestigationById(id);
        mmap.put("tAccidentInvestigation", tAccidentInvestigation);
        return prefix + "/edit";
    }

    /**
     * 修改保存事故调查
     */
    //@RequiresPermissions("web:tAccidentInvestigation:edit")
    @Log(title = "事故调查", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TAccidentInvestigation tAccidentInvestigation, MultipartFile file) {
        return tAccidentInvestigationService.updateTAccidentInvestigation(tAccidentInvestigation, file);
    }

    /**
     * 删除事故调查
     */
    //@RequiresPermissions("web:tAccidentInvestigation:remove")
    @Log(title = "事故调查", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tAccidentInvestigationService.deleteTAccidentInvestigationByIds(ids));
    }

}