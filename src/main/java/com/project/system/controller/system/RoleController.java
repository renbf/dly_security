package com.project.system.controller.system;

import com.github.pagehelper.PageInfo;
import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.common.utils.ExcelUtil;
import com.project.framework.util.ShiroUtils;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.system.domain.SysRole;
import com.project.system.service.ISysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * 角色信息
 *
 * @author lws
 */
@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController {

    @Autowired
    private ISysRoleService roleService;

    @GetMapping("/list")
    @ResponseBody
    public AjaxResult list(SysRole role) {
        startPage();
        List<SysRole> list = roleService.selectRoleList(role);
        AjaxResult ajaxResult=AjaxResult.success();
        ajaxResult.put("data",new PageInfo(list));
        return ajaxResult;
    }

    @GetMapping("/detail")
    @ResponseBody
    public AjaxResult detail(String  roleId) {
        AjaxResult ajaxResult=AjaxResult.success();
        ajaxResult.put("data",roleService.selectRoleById(Long.valueOf(roleId)));
        return ajaxResult;
    }


    @Log(title = "角色管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:role:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysRole role) {
        List<SysRole> list = roleService.selectRoleList(role);
        ExcelUtil<SysRole> util = new ExcelUtil<SysRole>(SysRole.class);
        return util.exportExcel(list, "role");
    }


    /**
     * 新增保存角色
     */
    @Log(title = "角色管理", businessType = BusinessType.INSERT)
    @PostMapping("/save")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(SysRole role) {
        if(Objects.isNull(role.getRoleId())||role.getRoleId()==0){
            role.setCreateBy(ShiroUtils.getUser().getUserName());
            ShiroUtils.clearCachedAuthorizationInfo();
            return toAjax(roleService.insertRole(role));
        }else{
            role.setUpdateBy(ShiroUtils.getUser().getUserName());
            return toAjax(roleService.updateRole(role));
        }
    }

//
//    /**
//     * 修改保存角色
//     */
//    @RequiresPermissions("system:role:edit")
//    @Log(title = "角色管理", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @Transactional(rollbackFor = Exception.class)
//    @ResponseBody
//    public AjaxResult editSave(SysRole role) {
//        role.setUpdateBy(ShiroUtils.getLoginName());
//        ShiroUtils.clearCachedAuthorizationInfo();
//        return toAjax(roleService.updateRole(role));
//    }
//
//
//    /**
//     * 修改保存数据权限
//     */
//    @RequiresPermissions("system:role:edit")
//    @Log(title = "角色管理", businessType = BusinessType.UPDATE)
//    @PostMapping("/rule")
//    @Transactional(rollbackFor = Exception.class)
//    @ResponseBody
//    public AjaxResult ruleSave(SysRole role) {
//        role.setUpdateBy(ShiroUtils.getLoginName());
//        return toAjax(roleService.updateRule(role));
//    }

    @Log(title = "角色管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(roleService.deleteRoleByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 校验角色名称
     */
    @PostMapping("/checkRoleNameUnique")
    @ResponseBody
    public String checkRoleNameUnique(SysRole role) {
        return roleService.checkRoleNameUnique(role);
    }

    /**
     * 校验角色权限
     */
    @PostMapping("/checkRoleKeyUnique")
    @ResponseBody
    public String checkRoleKeyUnique(SysRole role) {
        return roleService.checkRoleKeyUnique(role);
    }

}