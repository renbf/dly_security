package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TVehicleCheck;
import com.project.web.service.ITVehicleCheckService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 车辆例检 信息操作处理
 *
 * @author rbf
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/web/tVehicleCheck")
public class TVehicleCheckController extends BaseController {
    private String prefix = "web/tVehicleCheck";

    @Autowired
    private ITVehicleCheckService tVehicleCheckService;

    @RequiresPermissions("web:tVehicleCheck:view")
    @GetMapping()
    public String tVehicleCheck() {
        return prefix + "/tVehicleCheck";
    }

    /**
     * 查询车辆例检列表
     */
    //@RequiresPermissions("web:tVehicleCheck:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TVehicleCheck tVehicleCheck) {
        startPage();
        List<TVehicleCheck> list = tVehicleCheckService.selectTVehicleCheckList(tVehicleCheck);
        return getDataTable(list);
    }

    /**
     * 新增车辆例检
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存车辆例检
     */
    //@RequiresPermissions("web:tVehicleCheck:add")
    @Log(title = "车辆例检", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TVehicleCheck tVehicleCheck) {
        return tVehicleCheckService.insertTVehicleCheck(tVehicleCheck);
    }

    /**
     * 修改车辆例检
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TVehicleCheck tVehicleCheck = tVehicleCheckService.selectTVehicleCheckById(id);
        mmap.put("tVehicleCheck", tVehicleCheck);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆例检
     */
    //@RequiresPermissions("web:tVehicleCheck:edit")
    @Log(title = "车辆例检", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TVehicleCheck tVehicleCheck) {
        return tVehicleCheckService.updateTVehicleCheck(tVehicleCheck);
    }

    /**
     * 删除车辆例检
     */
    //@RequiresPermissions("web:tVehicleCheck:remove")
    @Log(title = "车辆例检", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tVehicleCheckService.deleteTVehicleCheckByIds(ids));
    }

}
