package org.springboot.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "need login";
    }

    /**
     * 登录
     */
    @GetMapping("/doLogin")
    public String doLogin(String username, String password) {
        // 添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            // 进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(token);
        } catch (Exception e) {
            e.printStackTrace();
            return "login failed";
        }
        return "login success";
    }

    /**
     * 登出
     */
    @RequestMapping(value = "/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "logout";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping("/error")
    public String error() {
        return "error ok!";
    }

    @RequiresPermissions("shiro:create")
    @RequestMapping(value = "/create")
    public String create() {
        return "Create success!";
    }

    @RequiresPermissions("detail")
    @RequestMapping(value = "/detail")
    public String detail() {
        return "uid";
    }
}
