package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TCarSatellitePosition;
import com.project.web.service.ITCarSatellitePositionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 卫星定位 信息操作处理
 *
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tCarSatellitePosition")
public class TCarSatellitePositionController extends BaseController {
    private String prefix = "web/tCarSatellitePosition";

    @Autowired
    private ITCarSatellitePositionService tCarSatellitePositionService;

    @RequiresPermissions("web:tCarSatellitePosition:view")
    @GetMapping()
    public String tCarSatellitePosition() {
        return prefix + "/tCarSatellitePosition";
    }

    /**
     * 查询卫星定位列表
     */
    //@RequiresPermissions("web:tCarSatellitePosition:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TCarSatellitePosition tCarSatellitePosition) {
        startPage();
        List<TCarSatellitePosition> list = tCarSatellitePositionService.selectTCarSatellitePositionList(tCarSatellitePosition);
        return getDataTable(list);
    }

    /**
     * 新增卫星定位
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存卫星定位
     */
    //@RequiresPermissions("web:tCarSatellitePosition:add")
    @Log(title = "卫星定位", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TCarSatellitePosition tCarSatellitePosition, MultipartFile file) {
        return tCarSatellitePositionService.insertTCarSatellitePosition(tCarSatellitePosition,file);
    }

    /**
     * 修改卫星定位
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TCarSatellitePosition tCarSatellitePosition = tCarSatellitePositionService.selectTCarSatellitePositionById(id);
        mmap.put("tCarSatellitePosition", tCarSatellitePosition);
        return prefix + "/edit";
    }

    /**
     * 修改保存卫星定位
     */
    //@RequiresPermissions("web:tCarSatellitePosition:edit")
    @Log(title = "卫星定位", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TCarSatellitePosition tCarSatellitePosition,MultipartFile file) {
        return tCarSatellitePositionService.updateTCarSatellitePosition(tCarSatellitePosition,file);
    }

    /**
     * 删除卫星定位
     */
    //@RequiresPermissions("web:tCarSatellitePosition:remove")
    @Log(title = "卫星定位", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tCarSatellitePositionService.deleteTCarSatellitePositionByIds(ids));
    }

}
