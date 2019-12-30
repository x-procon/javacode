package com.hazer.controller;

import com.hazer.model.ResultModel;
import com.hazer.realms.ShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: LoginController
 * @Author: Hazer
 * @Description: shiro登录
 * @Date: 2019/12/30 17:03
 * @Version: 1.0
 */
@Controller
@RequestMapping(value = "/admin")
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class.getName());

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultModel login(@RequestParam(value = "username") String username,
                             @RequestParam(value = "password")String password){

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // rememberme
            token.setRememberMe(true);
            try {
                // 执行登录.
                currentUser.login(token);
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            // 所有认证时异常的父类.
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
               LOGGER.info("登录失败: " + ae.getMessage());
            }
        }
        return ResultModel.success();
    }
}
