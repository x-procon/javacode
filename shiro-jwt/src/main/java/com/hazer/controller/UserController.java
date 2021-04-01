package com.hazer.controller;

import com.hazer.entity.Role;
import com.hazer.entity.User;
import com.hazer.model.ResultModel;
import com.hazer.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hazer
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @param user 用户信息
     * @return user
     */
    @RequiresRoles("admin")
    @PostMapping(value = "/addUser")
    public ResultModel<User> addUser(@RequestBody User user) {
        user = userService.addUser(user);
        return ResultModel.ok(user,"添加用户成功!");
    }

    /**
     * 添加角色
     * @param role 角色
     * @return role
     */
    @RequiresRoles("admin")
    @PostMapping(value = "/addRole")
    public ResultModel<Role> addRole(@RequestBody Role role) {
        role = userService.addRole(role);
        return ResultModel.ok(role,"添加角色成功!");
    }

}
