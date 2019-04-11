package com.project.system.controller.system;

import com.github.pagehelper.PageInfo;
import com.project.common.annotation.Log;
import com.project.common.base.AjaxResult;
import com.project.common.enums.BusinessType;
import com.project.common.utils.ExcelUtil;
import com.project.common.utils.StringUtils;
import com.project.framework.shiro.service.PasswordService;
import com.project.framework.util.ShiroUtils;
import com.project.framework.web.page.TableDataInfo;
import com.project.system.core.base.BaseController;
import com.project.system.domain.SysUser;
import com.project.system.service.ISysPostService;
import com.project.system.service.ISysRoleService;
import com.project.system.service.ISysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * 用户信息
 *
 * @author lws
 */
@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysPostService postService;

    @Autowired
    private PasswordService passwordService;

    @GetMapping("/list")
    @ResponseBody
    public AjaxResult list(SysUser user) {
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        AjaxResult ajaxResult= AjaxResult.success();
        ajaxResult.put("data",new PageInfo(list));
        return ajaxResult;
    }
    @GetMapping("/detail")
    @ResponseBody
    public AjaxResult detail( String userId) {
        AjaxResult ajaxResult= AjaxResult.success();
        ajaxResult.put("data",userService.selectUserById(Long.valueOf(userId)));
        return ajaxResult;
    }
    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysUser user) {
        List<SysUser> list = userService.selectUserList(user);
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增保存用户
     */
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/save")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(SysUser user) {
        if (StringUtils.isNotNull(user.getUserId()) && SysUser.isAdmin(user.getUserId())) {
            return error("不允许修改超级管理员用户");
        }

        if(Objects.isNull(user.getUserId())||user.getUserId()==0){
            user.setPassword("123456");//初始密码
            user.setSalt(ShiroUtils.randomSalt());
            user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
            user.setCreateBy(ShiroUtils.getLoginName());
            return toAjax(userService.insertUser(user));
        }else{

            user.setUpdateBy(ShiroUtils.getLoginName());
            return toAjax(userService.updateUser(user));
        }
    }





    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwdSave(SysUser user) {
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        return toAjax(userService.resetUserPwd(user));
    }

    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(Long userId) {
        try {
            return toAjax(userService.deleteUserById(userId));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 校验用户名
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(SysUser user) {
        return userService.checkLoginNameUnique(user.getLoginName());
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(SysUser user) {
        return userService.checkPhoneUnique(user);
    }

    /**
     * 校验email邮箱
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(SysUser user) {
        return userService.checkEmailUnique(user);
    }
}