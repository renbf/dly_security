package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TNewspaperClassOutDeparture;
import com.project.web.service.ITNewspaperClassOutDepartureService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 报班未出站车辆 信息操作处理
 *
 * @author rbf
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/web/tNewspaperClassOutDeparture")
public class TNewspaperClassOutDepartureController extends BaseController {
    private String prefix = "web/tNewspaperClassOutDeparture";

    @Autowired
    private ITNewspaperClassOutDepartureService tNewspaperClassOutDepartureService;

    @RequiresPermissions("web:tNewspaperClassOutDeparture:view")
    @GetMapping()
    public String tNewspaperClassOutDeparture() {
        return prefix + "/tNewspaperClassOutDeparture";
    }

    /**
     * 查询报班未出站车辆列表
     */
    //@RequiresPermissions("web:tNewspaperClassOutDeparture:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TNewspaperClassOutDeparture tNewspaperClassOutDeparture) {
        startPage();
        List<TNewspaperClassOutDeparture> list = tNewspaperClassOutDepartureService.selectTNewspaperClassOutDepartureList(tNewspaperClassOutDeparture);
        return getDataTable(list);
    }

    /**
     * 新增报班未出站车辆
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存报班未出站车辆
     */
    //@RequiresPermissions("web:tNewspaperClassOutDeparture:add")
    @Log(title = "报班未出站车辆", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TNewspaperClassOutDeparture tNewspaperClassOutDeparture) {
        return tNewspaperClassOutDepartureService.insertTNewspaperClassOutDeparture(tNewspaperClassOutDeparture);
    }

    /**
     * 修改报班未出站车辆
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TNewspaperClassOutDeparture tNewspaperClassOutDeparture = tNewspaperClassOutDepartureService.selectTNewspaperClassOutDepartureById(id);
        mmap.put("tNewspaperClassOutDeparture", tNewspaperClassOutDeparture);
        return prefix + "/edit";
    }

    /**
     * 修改保存报班未出站车辆
     */
    //@RequiresPermissions("web:tNewspaperClassOutDeparture:edit")
    @Log(title = "报班未出站车辆", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TNewspaperClassOutDeparture tNewspaperClassOutDeparture) {
        return tNewspaperClassOutDepartureService.updateTNewspaperClassOutDeparture(tNewspaperClassOutDeparture);
    }

    /**
     * 删除报班未出站车辆
     */
    //@RequiresPermissions("web:tNewspaperClassOutDeparture:remove")
    @Log(title = "报班未出站车辆", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tNewspaperClassOutDepartureService.deleteTNewspaperClassOutDepartureByIds(ids));
    }

}
