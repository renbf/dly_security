package com.project.system.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.project.common.base.AjaxResult;
import com.project.common.utils.StringUtils;
import com.project.framework.util.ServletUtils;
import com.project.framework.util.ShiroUtils;
import com.project.system.core.base.BaseController;
import com.project.system.domain.SysMenu;
import com.project.system.domain.SysUser;
import com.project.system.service.ISysMenuService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 登录验证
 *
 * @author lws
 */
@Controller
public class LoginController extends BaseController {
    @Autowired
    ISysRoleService roleService;
    @Autowired
    private ISysMenuService menuService;
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
        AjaxResult ajaxResult=AjaxResult.success();
        try {
            subject.login(token);
            SysUser user = ShiroUtils.getUser(subject);
            user.setJbdms(roleService.queryDataScopeJbdmByUserId(user.getUserId()));
            ShiroUtils.setUser(user);
            ajaxResult.put("token",subject.getSession().getId());
            List<Map<String,Object>> mapList=new ArrayList<>();
            menuService.selectMenusByUser(user).forEach(sysMenu -> {
                String json=JSONObject.toJSONString(sysMenu);
                //删除为空的子级列表
                json=json.replaceAll("\"childrens\":\\[]","");
                json=json.replaceAll("\"menuName\"","title");
                json=json.replaceAll("\"url\"","index");
                json=json.replaceAll("\"childrens\"","subs");
                //转换map
                mapList.add(JSONObject.parseObject(json));
            });

            ajaxResult.put("menuTree",mapList);//返回用户菜单树
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
    @ResponseBody
    public AjaxResult unauth() {
        AjaxResult ajaxResult=AjaxResult.error(10000,"未登录");
        return ajaxResult;

    }


}
