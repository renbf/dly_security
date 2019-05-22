package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TUserPaper;
import com.project.web.service.ITUserPaperService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户考试安排 信息操作处理
 *
 * @author rbf
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/web/tUserPaper")
public class TUserPaperController extends BaseController {
    private String prefix = "web/tUserPaper";

    @Autowired
    private ITUserPaperService tUserPaperService;

    @RequiresPermissions("web:tUserPaper:view")
    @GetMapping()
    public String tUserPaper() {
        return prefix + "/tUserPaper";
    }

    /**
     * 查询用户考试安排列表
     */
    @RequiresPermissions("web:tUserPaper:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TUserPaper tUserPaper) {
        startPage();
        List<TUserPaper> list = tUserPaperService.selectTUserPaperList(tUserPaper);
        return getDataTable(list);
    }

    /**
     * 新增用户考试安排
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存用户考试安排
     */
    @RequiresPermissions("web:tUserPaper:add")
    @Log(title = "用户考试安排", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TUserPaper tUserPaper) {
        return toAjax(tUserPaperService.insertTUserPaper(tUserPaper));
    }

    /**
     * 修改用户考试安排
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TUserPaper tUserPaper = tUserPaperService.selectTUserPaperById(id);
        mmap.put("tUserPaper", tUserPaper);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户考试安排
     */
    @RequiresPermissions("web:tUserPaper:edit")
    @Log(title = "用户考试安排", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TUserPaper tUserPaper) {
        return toAjax(tUserPaperService.updateTUserPaper(tUserPaper));
    }

    /**
     * 删除用户考试安排
     */
    @RequiresPermissions("web:tUserPaper:remove")
    @Log(title = "用户考试安排", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tUserPaperService.deleteTUserPaperByIds(ids));
    }


    /**
     * 增加提醒考试功能
     */
    @PostMapping("/remind")
    @ResponseBody
    public AjaxResult remind(String userCourseId) {
        AjaxResult remind = this.tUserPaperService.remind(userCourseId);
        return remind;
    }


    /**
     * 考试不及格,重考
     */
    @PostMapping("/repaper")
    @ResponseBody
    public AjaxResult repaper(String userCourseId) {
        return this.tUserPaperService.repaper(userCourseId);
    }


}
