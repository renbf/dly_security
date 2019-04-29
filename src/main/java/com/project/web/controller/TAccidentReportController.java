package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TAccidentReport;
import com.project.web.service.ITAccidentReportService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 事故报告 信息操作处理
 *
 * @author rbf
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/web/tAccidentReport")
public class TAccidentReportController extends BaseController {
    private String prefix = "web/tAccidentReport";

    @Autowired
    private ITAccidentReportService tAccidentReportService;

    @RequiresPermissions("web:tAccidentReport:view")
    @GetMapping()
    public String tAccidentReport() {
        return prefix + "/tAccidentReport";
    }

    /**
     * 查询事故报告列表
     */
    //@RequiresPermissions("web:tAccidentReport:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TAccidentReport tAccidentReport) {
        startPage();
        List<TAccidentReport> list = tAccidentReportService.selectTAccidentReportList(tAccidentReport);
        return getDataTable(list);
    }

    /**
     * 查询事故报告根据基础表id
     */
    //@RequiresPermissions("web:tAccidentReport:list")
    @PostMapping("/selectByBasicsId")
    @ResponseBody
    public AjaxResult list(String basicsId) {
        return tAccidentReportService.selectTAccidentReportByBasicsId(basicsId);
    }





    /**
     * 新增事故报告
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存事故报告
     */
    //@RequiresPermissions("web:tAccidentReport:add")
    @Log(title = "事故报告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TAccidentReport tAccidentReport, MultipartFile file) {
        return tAccidentReportService.insertTAccidentReport(tAccidentReport, file);
    }

    /**
     * 修改事故报告
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TAccidentReport tAccidentReport = tAccidentReportService.selectTAccidentReportById(id);
        mmap.put("tAccidentReport", tAccidentReport);
        return prefix + "/edit";
    }

    /**
     * 修改保存事故报告
     */
    //@RequiresPermissions("web:tAccidentReport:edit")
    @Log(title = "事故报告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TAccidentReport tAccidentReport, MultipartFile file) {
        return tAccidentReportService.updateTAccidentReport(tAccidentReport, file);
    }

    /**
     * 删除事故报告
     */
    //@RequiresPermissions("web:tAccidentReport:remove")
    @Log(title = "事故报告", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tAccidentReportService.deleteTAccidentReportByIds(ids));
    }

}
