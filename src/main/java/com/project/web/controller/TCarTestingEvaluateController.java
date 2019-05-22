package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TCarTestingEvaluate;
import com.project.web.service.ITCarTestingEvaluateService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 车辆检测和评定登记 信息操作处理
 *
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tCarTestingEvaluate")
public class TCarTestingEvaluateController extends BaseController {
    private String prefix = "web/tCarTestingEvaluate";

    @Autowired
    private ITCarTestingEvaluateService tCarTestingEvaluateService;

    @RequiresPermissions("web:tCarTestingEvaluate:view")
    @GetMapping()
    public String tCarTestingEvaluate() {
        return prefix + "/tCarTestingEvaluate";
    }

    /**
     * 查询车辆检测和评定登记列表
     */
    //@RequiresPermissions("web:tCarTestingEvaluate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TCarTestingEvaluate tCarTestingEvaluate) {
        startPage();
        List<TCarTestingEvaluate> list = tCarTestingEvaluateService.selectTCarTestingEvaluateList(tCarTestingEvaluate);
        return getDataTable(list);
    }

    /**
     * 新增车辆检测和评定登记
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存车辆检测和评定登记
     */
    //@RequiresPermissions("web:tCarTestingEvaluate:add")
    @Log(title = "车辆检测和评定登记", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TCarTestingEvaluate tCarTestingEvaluate, MultipartFile file) {
        return tCarTestingEvaluateService.insertTCarTestingEvaluate(tCarTestingEvaluate,file);
    }

    /**
     * 修改车辆检测和评定登记
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TCarTestingEvaluate tCarTestingEvaluate = tCarTestingEvaluateService.selectTCarTestingEvaluateById(id);
        mmap.put("tCarTestingEvaluate", tCarTestingEvaluate);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆检测和评定登记
     */
    //@RequiresPermissions("web:tCarTestingEvaluate:edit")
    @Log(title = "车辆检测和评定登记", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TCarTestingEvaluate tCarTestingEvaluate,MultipartFile file) {
        return tCarTestingEvaluateService.updateTCarTestingEvaluate(tCarTestingEvaluate,file);
    }

    /**
     * 删除车辆检测和评定登记
     */
    //@RequiresPermissions("web:tCarTestingEvaluate:remove")
    @Log(title = "车辆检测和评定登记", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tCarTestingEvaluateService.deleteTCarTestingEvaluateByIds(ids));
    }

}
