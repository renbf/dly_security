package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TCourseArrange;
import com.project.web.service.ITCourseArrangeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 课程安排 信息操作处理
 *
 * @author rbf
 * @date 2019-04-30
 */
@Controller
@RequestMapping("/web/tCourseArrange")
public class TCourseArrangeController extends BaseController {
    private String prefix = "web/tCourseArrange";

    @Autowired
    private ITCourseArrangeService tCourseArrangeService;

    @RequiresPermissions("web:tCourseArrange:view")
    @GetMapping()
    public String tCourseArrange() {
        return prefix + "/tCourseArrange";
    }

    /**
     * 查询课程安排列表
     */
    //@RequiresPermissions("web:tCourseArrange:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TCourseArrange tCourseArrange) {
        startPage();
        List<TCourseArrange> list = tCourseArrangeService.selectTCourseArrangeList(tCourseArrange);
        return getDataTable(list);
    }

    /**
     * 新增课程安排
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存课程安排
     */
    //@RequiresPermissions("web:tCourseArrange:add")
    @Log(title = "课程安排", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TCourseArrange tCourseArrange) {
        try {
            return tCourseArrangeService.insertTCourseArrange(tCourseArrange);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return AjaxResult.error(2, "操作失败");
        }
    }

    /**
     * 修改课程安排
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TCourseArrange tCourseArrange = tCourseArrangeService.selectTCourseArrangeById(id);
        mmap.put("tCourseArrange", tCourseArrange);
        return prefix + "/edit";
    }

    /**
     * 修改保存课程安排
     */
    //@RequiresPermissions("web:tCourseArrange:edit")
    @Log(title = "课程安排", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TCourseArrange tCourseArrange) {
        try {
            return tCourseArrangeService.updateTCourseArrange(tCourseArrange);
        } catch (RuntimeException e) {
            return AjaxResult.error(2, "操作失败");
        }
    }

    /**
     * 删除课程安排
     */
    //@RequiresPermissions("web:tCourseArrange:remove")
    @Log(title = "课程安排", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(tCourseArrangeService.deleteTCourseArrangeByIds(ids));
        } catch (RuntimeException e) {
            e.printStackTrace();
            return AjaxResult.error(2, "操作失败");
        }
    }





}
