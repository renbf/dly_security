package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TCarChange;
import com.project.web.service.ITCarChangeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 车辆变更登记 信息操作处理
 *
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tCarChange")
public class TCarChangeController extends BaseController {
    private String prefix = "web/tCarChange";

    @Autowired
    private ITCarChangeService tCarChangeService;

    @RequiresPermissions("web:tCarChange:view")
    @GetMapping()
    public String tCarChange() {
        return prefix + "/tCarChange";
    }

    /**
     * 查询车辆变更登记列表
     */
    //@RequiresPermissions("web:tCarChange:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TCarChange tCarChange) {
        startPage();
        List<TCarChange> list = tCarChangeService.selectTCarChangeList(tCarChange);
        return getDataTable(list);
    }

    /**
     * 新增车辆变更登记
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存车辆变更登记
     */
    //@RequiresPermissions("web:tCarChange:add")
    @Log(title = "车辆变更登记", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TCarChange tCarChange) {
        return tCarChangeService.insertTCarChange(tCarChange);
    }

    /**
     * 修改车辆变更登记
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TCarChange tCarChange = tCarChangeService.selectTCarChangeById(id);
        mmap.put("tCarChange", tCarChange);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆变更登记
     */
    //@RequiresPermissions("web:tCarChange:edit")
    @Log(title = "车辆变更登记", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TCarChange tCarChange) {
        return tCarChangeService.updateTCarChange(tCarChange);
    }

    /**
     * 删除车辆变更登记
     */
    @RequiresPermissions("web:tCarChange:remove")
    @Log(title = "车辆变更登记", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tCarChangeService.deleteTCarChangeByIds(ids));
    }

}
