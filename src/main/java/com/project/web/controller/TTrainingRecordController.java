package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TTrainingRecord;
import com.project.web.service.ITTrainingRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 培训记录 信息操作处理
 *
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/web/tTrainingRecord")
public class TTrainingRecordController extends BaseController {
    private String prefix = "web/tTrainingRecord";

    @Autowired
    private ITTrainingRecordService tTrainingRecordService;

    @RequiresPermissions("web:tTrainingRecord:view")
    @GetMapping()
    public String tTrainingRecord() {
        return prefix + "/tTrainingRecord";
    }

    /**
     * 查询培训记录列表
     */
    //@RequiresPermissions("web:tTrainingRecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TTrainingRecord tTrainingRecord) {
        startPage();
        List<TTrainingRecord> list = tTrainingRecordService.selectTTrainingRecordList(tTrainingRecord);
        return getDataTable(list);
    }

    /**
     * 新增培训记录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存培训记录
     */
    //@RequiresPermissions("web:tTrainingRecord:add")
    @Log(title = "培训记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TTrainingRecord tTrainingRecord,MultipartFile trainFile) {
        try {
            return tTrainingRecordService.insertTTrainingRecord(tTrainingRecord,trainFile);
        } catch (RuntimeException e) {
            //回滚了.....
            e.printStackTrace();
            return AjaxResult.error(2, "操作失败");
        }

    }

    /**
     * 修改培训记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TTrainingRecord tTrainingRecord = tTrainingRecordService.selectTTrainingRecordById(id);
        mmap.put("tTrainingRecord", tTrainingRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存培训记录
     */
    //@RequiresPermissions("web:tTrainingRecord:edit")
    @Log(title = "培训记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TTrainingRecord tTrainingRecord, MultipartFile trainFile) {
        try {
            return tTrainingRecordService.updateTTrainingRecord(tTrainingRecord,trainFile);
        } catch (RuntimeException e) {
            //回滚了
            e.printStackTrace();
            return AjaxResult.error(2, "操作失败");
        }
    }

    /**
     * 删除培训记录
     */
    //@RequiresPermissions("web:tTrainingRecord:remove")
    @Log(title = "培训记录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tTrainingRecordService.deleteTTrainingRecordByIds(ids));
    }

}