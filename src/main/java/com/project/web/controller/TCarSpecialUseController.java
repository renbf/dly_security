package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TCarSpecialUse;
import com.project.web.service.ITCarSpecialUseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 压力容器和罐式专用车辆的罐体检测报告 信息操作处理
 *
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tCarSpecialUse")
public class TCarSpecialUseController extends BaseController {
    private String prefix = "web/tCarSpecialUse";

    @Autowired
    private ITCarSpecialUseService tCarSpecialUseService;

    @RequiresPermissions("web:tCarSpecialUse:view")
    @GetMapping()
    public String tCarSpecialUse() {
        return prefix + "/tCarSpecialUse";
    }

    /**
     * 查询压力容器和罐式专用车辆的罐体检测报告列表
     */
    //@RequiresPermissions("web:tCarSpecialUse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TCarSpecialUse tCarSpecialUse) {
        startPage();
        List<TCarSpecialUse> list = tCarSpecialUseService.selectTCarSpecialUseList(tCarSpecialUse);
        return getDataTable(list);
    }

    /**
     * 新增压力容器和罐式专用车辆的罐体检测报告
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存压力容器和罐式专用车辆的罐体检测报告
     */
    //@RequiresPermissions("web:tCarSpecialUse:add")
    @Log(title = "压力容器和罐式专用车辆的罐体检测报告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TCarSpecialUse tCarSpecialUse, MultipartFile file) {
        return tCarSpecialUseService.insertTCarSpecialUse(tCarSpecialUse, file);
    }

    /**
     * 修改压力容器和罐式专用车辆的罐体检测报告
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TCarSpecialUse tCarSpecialUse = tCarSpecialUseService.selectTCarSpecialUseById(id);
        mmap.put("tCarSpecialUse", tCarSpecialUse);
        return prefix + "/edit";
    }

    /**
     * 修改保存压力容器和罐式专用车辆的罐体检测报告
     */
    //@RequiresPermissions("web:tCarSpecialUse:edit")
    @Log(title = "压力容器和罐式专用车辆的罐体检测报告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TCarSpecialUse tCarSpecialUse, MultipartFile file) {
        return tCarSpecialUseService.updateTCarSpecialUse(tCarSpecialUse, file);
    }

    /**
     * 删除压力容器和罐式专用车辆的罐体检测报告
     */
    //@RequiresPermissions("web:tCarSpecialUse:remove")
    @Log(title = "压力容器和罐式专用车辆的罐体检测报告", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tCarSpecialUseService.deleteTCarSpecialUseByIds(ids));
    }

}
