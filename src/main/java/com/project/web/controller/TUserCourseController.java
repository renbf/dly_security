package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TUserCourse;
import com.project.web.service.ITUserCourseService;
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
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tUserCourse")
public class TUserCourseController extends BaseController {
    private String prefix = "web/tUserCourse";

    @Autowired
    private ITUserCourseService tUserCourseService;

    @RequiresPermissions("web:tUserCourse:view")
    @GetMapping()
    public String tUserCourse() {
        return prefix + "/tUserCourse";
    }

    /**
     * 查询课程安排(详情)列表
     */
    //@RequiresPermissions("web:tUserCourse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TUserCourse tUserCourse) {
        startPage();
        List<TUserCourse> list = tUserCourseService.selectTUserCourseList(tUserCourse);
        return getDataTable(list);
    }

    /**
     * 新增课程安排(详情)
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存课程安排(详情)
     */
    //@RequiresPermissions("web:tUserCourse:add")
    @Log(title = "课程安排(详情)", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TUserCourse tUserCourse) {
        return toAjax(tUserCourseService.insertTUserCourse(tUserCourse));
    }

    /**
     * 修改课程安排(详情)
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TUserCourse tUserCourse = tUserCourseService.selectTUserCourseById(id);
        mmap.put("tUserCourse", tUserCourse);
        return prefix + "/edit";
    }

    /**
     * 修改保存课程安排(详情)
     */
    //@RequiresPermissions("web:tUserCourse:edit")
    @Log(title = "课程安排(详情)", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TUserCourse tUserCourse) {
        return toAjax(tUserCourseService.updateTUserCourse(tUserCourse));
    }

    /**
     * 删除课程安排(详情)
     */
    //@RequiresPermissions("web:tUserCourse:remove")
    @Log(title = "课程安排(详情)", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tUserCourseService.deleteTUserCourseByIds(ids));
    }


    /**
     * 增加提醒功能
     */
    @PostMapping("/remind")
    @ResponseBody
    public AjaxResult remind(String userCourseId) {
        AjaxResult remind = this.tUserCourseService.remind(userCourseId);
        return remind;
    }


}