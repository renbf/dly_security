package com.project.web.controller;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.web.domian.TThreeProducts;
import com.project.web.service.ITThreeProductsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 三品查处记录 信息操作处理
 *
 * @author rbf
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/web/tThreeProducts")
public class TThreeProductsController extends BaseController {
    private String prefix = "web/tThreeProducts";

    @Autowired
    private ITThreeProductsService tThreeProductsService;

    @RequiresPermissions("web:tThreeProducts:view")
    @GetMapping()
    public String tThreeProducts() {
        return prefix + "/tThreeProducts";
    }

    /**
     * 查询三品查处记录列表
     */
    //@RequiresPermissions("web:tThreeProducts:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TThreeProducts tThreeProducts) {
        startPage();
        List<TThreeProducts> list = tThreeProductsService.selectTThreeProductsList(tThreeProducts);
        return getDataTable(list);
    }

    /**
     * 新增三品查处记录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存三品查处记录
     */
    //@RequiresPermissions("web:tThreeProducts:add")
    @Log(title = "三品查处记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TThreeProducts tThreeProducts) {
        return tThreeProductsService.insertTThreeProducts(tThreeProducts);
    }

    /**
     * 修改三品查处记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        TThreeProducts tThreeProducts = tThreeProductsService.selectTThreeProductsById(id);
        mmap.put("tThreeProducts", tThreeProducts);
        return prefix + "/edit";
    }

    /**
     * 修改保存三品查处记录
     */
    //@RequiresPermissions("web:tThreeProducts:edit")
    @Log(title = "三品查处记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TThreeProducts tThreeProducts) {
        return tThreeProductsService.updateTThreeProducts(tThreeProducts);
    }

    /**
     * 删除三品查处记录
     */
    //@RequiresPermissions("web:tThreeProducts:remove")
    @Log(title = "三品查处记录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(tThreeProductsService.deleteTThreeProductsByIds(ids));
    }

}
