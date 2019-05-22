package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TInspectRecord;
import com.project.web.service.ITInspectRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 检查记录 信息操作处理
 *
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tInspectRecord")
public class TInspectRecordController extends BaseController {
    private String prefix = "web/tInspectRecord";

    @Autowired
    private ITInspectRecordService tInspectRecordService;

    @RequiresPermissions("web:tInspectRecord:view")
    @GetMapping()
    public String tInspectRecord() {
        return prefix + "/tInspectRecord";
    }

    /**
     * 查询检查记录列表
     */
    @RequiresPermissions("web:tInspectRecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TInspectRecord tInspectRecord) {
        startPage();
        List<TInspectRecord> list = tInspectRecordService.selectTInspectRecordList(tInspectRecord);
        return getDataTable(list);
    }

    /**
     * 新增检查记录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存检查记录
     */
    @RequiresPermissions("web:tInspectRecord:add")
    @Log(title = "检查记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TInspectRecord tInspectRecord) {
        return toAjax(tInspectRecordService.insertTInspectRecord(tInspectRecord));
    }

    /**
     * 修改检查记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TInspectRecord tInspectRecord = tInspectRecordService.selectTInspectRecordById(id);
        mmap.put("tInspectRecord", tInspectRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存检查记录
     */
    @RequiresPermissions("web:tInspectRecord:edit")
    @Log(title = "检查记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TInspectRecord tInspectRecord) {
        return toAjax(tInspectRecordService.updateTInspectRecord(tInspectRecord));
    }

    /**
     * 删除检查记录
     */
    @RequiresPermissions("web:tInspectRecord:remove")
    @Log(title = "检查记录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tInspectRecordService.deleteTInspectRecordByIds(ids));
    }

}
