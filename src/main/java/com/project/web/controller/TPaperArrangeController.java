package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TPaperArrange;
import com.project.web.service.ITPaperArrangeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 考试安排 信息操作处理
 *
 * @author rbf
 * @date 2019-05-06
 */
@Controller
@RequestMapping("/web/tPaperArrange")
public class TPaperArrangeController extends BaseController {
    private String prefix = "web/tPaperArrange";

    @Autowired
    private ITPaperArrangeService tPaperArrangeService;

    @RequiresPermissions("web:tPaperArrange:view")
    @GetMapping()
    public String tPaperArrange() {
        return prefix + "/tPaperArrange";
    }

    /**
     * 查询考试安排列表
     */
    @RequiresPermissions("web:tPaperArrange:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TPaperArrange tPaperArrange) {
        startPage();
        List<TPaperArrange> list = tPaperArrangeService.selectTPaperArrangeList(tPaperArrange);
        return getDataTable(list);
    }

    /**
     * 新增考试安排
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存考试安排
     */
    @RequiresPermissions("web:tPaperArrange:add")
    @Log(title = "考试安排", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TPaperArrange tPaperArrange) {
        try {
            return tPaperArrangeService.insertTPaperArrange(tPaperArrange);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return AjaxResult.error(2, "操作失败");
        }
    }

    /**
     * 修改考试安排
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap) {
        TPaperArrange tPaperArrange = tPaperArrangeService.selectTPaperArrangeById(id);
        mmap.put("tPaperArrange", tPaperArrange);
        return prefix + "/edit";
    }

    /**
     * 修改保存考试安排
     */
    @RequiresPermissions("web:tPaperArrange:edit")
    @Log(title = "考试安排", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TPaperArrange tPaperArrange) {
        try {
            return tPaperArrangeService.updateTPaperArrange(tPaperArrange);
        } catch (RuntimeException e) {
            return AjaxResult.error(2, "操作失败");
        }
    }

    /**
     * 删除考试安排
     */
    @RequiresPermissions("web:tPaperArrange:remove")
    @Log(title = "考试安排", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(tPaperArrangeService.deleteTPaperArrangeByIds(ids));
        } catch (RuntimeException e) {
            e.printStackTrace();
            return AjaxResult.error(2, "操作失败");
        }
    }

}
