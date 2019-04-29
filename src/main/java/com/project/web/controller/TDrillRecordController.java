package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TDrillRecord;
import com.project.web.service.ITDrillRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 演练记录 信息操作处理
 *
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/web/tDrillRecord")
public class TDrillRecordController extends BaseController {
    private String prefix = "web/tDrillRecord";

    @Autowired
    private ITDrillRecordService tDrillRecordService;

    @RequiresPermissions("web:tDrillRecord:view")
    @GetMapping()
    public String tDrillRecord() {
        return prefix + "/tDrillRecord";
    }

    /**
     * 查询演练记录列表
     */
    //@RequiresPermissions("web:tDrillRecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TDrillRecord tDrillRecord) {
        startPage();
        List<TDrillRecord> list = tDrillRecordService.selectTDrillRecordList(tDrillRecord);
        return getDataTable(list);
    }

    /**
     * 新增演练记录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存演练记录
     */
    //@RequiresPermissions("web:tDrillRecord:add")
    @Log(title = "演练记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TDrillRecord tDrillRecord, MultipartFile photoFile) {
        return tDrillRecordService.insertTDrillRecord(tDrillRecord,photoFile);
    }

    /**
     * 修改演练记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TDrillRecord tDrillRecord = tDrillRecordService.selectTDrillRecordById(id);
        mmap.put("tDrillRecord", tDrillRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存演练记录
     */
    //@RequiresPermissions("web:tDrillRecord:edit")
    @Log(title = "演练记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TDrillRecord tDrillRecord,MultipartFile photoFile) {
        return tDrillRecordService.updateTDrillRecord(tDrillRecord,photoFile);
    }

    /**
     * 删除演练记录
     */
    //@RequiresPermissions("web:tDrillRecord:remove")
    @Log(title = "演练记录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tDrillRecordService.deleteTDrillRecordByIds(ids));
    }

}
