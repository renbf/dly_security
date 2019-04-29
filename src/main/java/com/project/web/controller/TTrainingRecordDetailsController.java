package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TTrainingRecordDetails;
import com.project.web.service.ITTrainingRecordDetailsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 培训记录详情 信息操作处理
 *
 * @author rbf
 * @date 2019-04-26
 */
//注释掉注解,该类不用....属于培训记录中的一个子表
//@Controller
@RequestMapping("/web/tTrainingRecordDetails")
public class TTrainingRecordDetailsController extends BaseController {
    private String prefix = "web/tTrainingRecordDetails";

    @Autowired
    private ITTrainingRecordDetailsService tTrainingRecordDetailsService;

    @RequiresPermissions("web:tTrainingRecordDetails:view")
    @GetMapping()
    public String tTrainingRecordDetails() {
        return prefix + "/tTrainingRecordDetails";
    }

    /**
     * 查询培训记录详情列表
     */
    @RequiresPermissions("web:tTrainingRecordDetails:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TTrainingRecordDetails tTrainingRecordDetails) {
        startPage();
        List<TTrainingRecordDetails> list = tTrainingRecordDetailsService.selectTTrainingRecordDetailsList(tTrainingRecordDetails);
        return getDataTable(list);
    }

    /**
     * 新增培训记录详情
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存培训记录详情
     */
    @RequiresPermissions("web:tTrainingRecordDetails:add")
    @Log(title = "培训记录详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TTrainingRecordDetails tTrainingRecordDetails) {
        return toAjax(tTrainingRecordDetailsService.insertTTrainingRecordDetails(tTrainingRecordDetails));
    }

    /**
     * 修改培训记录详情
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TTrainingRecordDetails tTrainingRecordDetails = tTrainingRecordDetailsService.selectTTrainingRecordDetailsById(id);
        mmap.put("tTrainingRecordDetails", tTrainingRecordDetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存培训记录详情
     */
    @RequiresPermissions("web:tTrainingRecordDetails:edit")
    @Log(title = "培训记录详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TTrainingRecordDetails tTrainingRecordDetails) {
        return toAjax(tTrainingRecordDetailsService.updateTTrainingRecordDetails(tTrainingRecordDetails));
    }

    /**
     * 删除培训记录详情
     */
    @RequiresPermissions("web:tTrainingRecordDetails:remove")
    @Log(title = "培训记录详情", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tTrainingRecordDetailsService.deleteTTrainingRecordDetailsByIds(ids));
    }

}
