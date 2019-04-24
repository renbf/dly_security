package com.project.system.controller.system;

import com.project.common.base.AjaxResult;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ServletUtils;
import com.project.framework.util.ShiroUtils;
import com.project.system.core.base.BaseController;
import com.project.system.domain.SysUser;
import com.project.system.service.ISysRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录验证
 *
 * @author lws
 */
@Controller
public class LoginController extends BaseController {
    @Autowired
    ISysRoleService roleService;
    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request)) {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }

        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password, Boolean rememberMe) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
        	AjaxResult ajaxResult=AjaxResult.success();
            subject.login(token);
            SysUser user = ShiroUtils.getUser(subject);
            user.setJbdms(roleService.queryDataScopeJbdmByUserId(user.getUserId()));
            ShiroUtils.setUser(user);
            ajaxResult.put("token",subject.getSession().getId());
            ajaxResult.put("businessId",ShiroUtils.getBusinessId());
            return ajaxResult;
        } catch (AuthenticationException e) {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage())) {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }

    @GetMapping("/unauth")
    public String unauth() {
        return "/error/unauth";
    }
}
