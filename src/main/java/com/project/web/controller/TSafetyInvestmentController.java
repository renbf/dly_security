package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TSafetyInvestment;
import com.project.web.service.ITSafetyInvestmentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 安全投入 信息操作处理
 *
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/security/tSafetyInvestment")
public class TSafetyInvestmentController extends BaseController {
    private String prefix = "security/tSafetyInvestment";

    @Autowired
    private ITSafetyInvestmentService tSafetyInvestmentService;

    @RequiresPermissions("security:tSafetyInvestment:view")
    @GetMapping()
    public String tSafetyInvestment() {
        return prefix + "/tSafetyInvestment";
    }

    /**
     * 查询安全投入列表
     */
    //@RequiresPermissions("security:tSafetyInvestment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TSafetyInvestment tSafetyInvestment) {
        startPage();
        List<TSafetyInvestment> list = tSafetyInvestmentService.selectTSafetyInvestmentList(tSafetyInvestment);
        return getDataTable(list);
    }

    /**
     * 新增安全投入
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存安全投入
     */
    //@RequiresPermissions("security:tSafetyInvestment:add")
    @Log(title = "安全投入", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TSafetyInvestment tSafetyInvestment, MultipartFile investmentFile) {
        return tSafetyInvestmentService.insertTSafetyInvestment(tSafetyInvestment,investmentFile);
    }

    /**
     * 修改安全投入
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TSafetyInvestment tSafetyInvestment = tSafetyInvestmentService.selectTSafetyInvestmentById(id);
        mmap.put("tSafetyInvestment", tSafetyInvestment);
        return prefix + "/edit";
    }

    /**
     * 修改保存安全投入
     */
    //@RequiresPermissions("security:tSafetyInvestment:edit")
    @Log(title = "安全投入", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TSafetyInvestment tSafetyInvestment,MultipartFile investmentFile) {
        return tSafetyInvestmentService.updateTSafetyInvestment(tSafetyInvestment,investmentFile);
    }

    /**
     * 删除安全投入
     */
    //@RequiresPermissions("security:tSafetyInvestment:remove")
    @Log(title = "安全投入", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tSafetyInvestmentService.deleteTSafetyInvestmentByIds(ids));
    }

}
