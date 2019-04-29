package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TAccidentBasics;
import com.project.web.service.ITAccidentBasicsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 事故基础 信息操作处理
 *
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/web/tAccidentBasics")
public class TAccidentBasicsController extends BaseController {
    private String prefix = "web/tAccidentBasics";

    @Autowired
    private ITAccidentBasicsService tAccidentBasicsService;

    @RequiresPermissions("web:tAccidentBasics:view")
    @GetMapping()
    public String tAccidentBasics() {
        return prefix + "/tAccidentBasics";
    }

    /**
     * 查询事故基础列表
     */
    //@RequiresPermissions("web:tAccidentBasics:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TAccidentBasics tAccidentBasics) {
        startPage();
        List<TAccidentBasics> list = tAccidentBasicsService.selectTAccidentBasicsList(tAccidentBasics);
        return getDataTable(list);
    }

    /**
     * 新增事故基础
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存事故基础
     */
    //@RequiresPermissions("web:tAccidentBasics:add")
    @Log(title = "事故基础", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TAccidentBasics tAccidentBasics) {
        try {
            return tAccidentBasicsService.insertTAccidentBasics(tAccidentBasics);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return AjaxResult.error(2, "操作失败");
        }
    }

    /**
     * 修改事故基础
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TAccidentBasics tAccidentBasics = tAccidentBasicsService.selectTAccidentBasicsById(id);
        mmap.put("tAccidentBasics", tAccidentBasics);
        return prefix + "/edit";
    }

    /**
     * 修改保存事故基础
     */
    //@RequiresPermissions("web:tAccidentBasics:edit")
    @Log(title = "事故基础", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TAccidentBasics tAccidentBasics) {
        return tAccidentBasicsService.updateTAccidentBasics(tAccidentBasics);
    }

    /**
     * 删除事故基础
     */
    //@RequiresPermissions("web:tAccidentBasics:remove")
    @Log(title = "事故基础", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tAccidentBasicsService.deleteTAccidentBasicsByIds(ids));
    }

}