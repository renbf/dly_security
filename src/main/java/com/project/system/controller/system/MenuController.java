package com.project.system.controller.system;

import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ShiroUtils;
import com.project.system.core.base.BaseController;
import com.project.system.domain.SysMenu;
import com.project.system.domain.SysRole;
import com.project.system.service.ISysMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 菜单信息
 *
 * @author lws
 */
@Controller
@RequestMapping("/system/menu")
public class MenuController extends BaseController {

    @Autowired
    private ISysMenuService menuService;

    @GetMapping("/list")
    @ResponseBody
    public List<SysMenu> list(SysMenu menu) {
        List<SysMenu> menuList = menuService.selectMenuList(menu);
        return menuList;
    }

    /**
     * 删除菜单
     */
    @Log(title = "菜单管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove( Long menuId) {
        if (menuService.selectCountMenuByParentId(menuId) > 0) {
            return error(1, "存在子菜单,不允许删除");
        }
        if (menuService.selectCountRoleMenuByMenuId(menuId) > 0) {
            return error(1, "菜单已分配,不允许删除");
        }
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(menuService.deleteMenuById(menuId));
    }


    /**
     * 新增保存菜单
     */
    @Log(title = "菜单管理", businessType = BusinessType.INSERT)
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(@RequestBody SysMenu menu) {
        if(Objects.isNull(menu.getMenuId())||menu.getMenuId()==0){
            menu.setCreateBy(ShiroUtils.getUser().getUserName());
            ShiroUtils.clearCachedAuthorizationInfo();
            return toAjax(menuService.insertMenu(menu));
        }else{
            menu.setUpdateBy(ShiroUtils.getLoginName());
            ShiroUtils.clearCachedAuthorizationInfo();
            return toAjax(menuService.updateMenu(menu));
        }

    }


    /**
     * 修改保存菜单
     */
    @Log(title = "菜单管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysMenu menu) {
        menu.setUpdateBy(ShiroUtils.getLoginName());
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(menuService.updateMenu(menu));
    }


    /**
     * 校验菜单名称
     */
    @PostMapping("/checkMenuNameUnique")
    @ResponseBody
    public String checkMenuNameUnique(SysMenu menu) {
        return menuService.checkMenuNameUnique(menu);
    }

    /**
     * 加载角色菜单列表树
     */
    @GetMapping("/roleMenuTreeData")
    @ResponseBody
    public List<Map<String, Object>> roleMenuTreeData(SysRole role) {
        List<Map<String, Object>> tree = menuService.roleMenuTreeData(role,getUser());
        return tree;
    }

    /**
     * 加载所有菜单列表树
     */
    @GetMapping("/menuTreeData")
    @ResponseBody
    public List<Map<String, Object>> menuTreeData(SysRole role) {
        List<Map<String, Object>> tree = menuService.menuTreeData();
        return tree;
    }

    /**
     * 查询菜单父级或子级列表
     * @param  menuId 菜单ID
     * @param type 1-父级列表，2-子级列表，3-平级列表
     */
    @GetMapping("/childrens")
    @ResponseBody
    public AjaxResult childrens(@RequestParam(name="menuId",defaultValue = "0") String menuId,@RequestParam(name="type",defaultValue = "2") Integer type)
    {
        AjaxResult ajaxResult=AjaxResult.success();
        ajaxResult.put("data",menuService.childrensMap(Long.valueOf(menuId),type));
        return ajaxResult;
    }

    /**
     * 查询菜单详情
     * @param  menuId 菜单ID
     */
    @GetMapping("/detail")
    @ResponseBody
    public AjaxResult detail(String  menuId)
    {
        AjaxResult ajaxResult=AjaxResult.success();
        ajaxResult.put("data",menuService.selectMenuById(Long.valueOf(menuId)));
        return ajaxResult;
    }





}