package com.hazer.service.impl;

import com.hazer.dao.RoleDao;
import com.hazer.dao.UserDao;
import com.hazer.entity.Permission;
import com.hazer.entity.Role;
import com.hazer.entity.User;
import com.hazer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;



/**
 * @author hazer
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final RoleDao roleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    /**
     * 添加用户
     * @param user 用户
     * @return com.bairuitech.anychat.website.entity.User
     */
    @Override
    public User addUser(User user) {
        userDao.save(user);
        return user;
    }

    /**
     * 添加角色
     * @param role 角色
     * @return com.bairuitech.anychat.website.entity.Role
     */
    @Override
    public Role addRole(Role role) {
        User user = userDao.findByUsername(role.getUser().getUsername());
        role.setUser(user);
        Permission permission1 = new Permission();
        permission1.setPermission("create");
        permission1.setRole(role);
        Permission permission2 = new Permission();
        permission2.setPermission("update");
        permission2.setRole(role);
        List<Permission> permissions = new ArrayList<>();
        permissions.add(permission1);
        permissions.add(permission2);
        role.setPermissions(permissions);
        roleDao.save(role);
        return role;
    }

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return com.bairuitech.anychat.website.entity.User
     */
    @Override
    public User findByUsername(String username) {

        return userDao.findByUsername(username);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userDao.findByUsernameAndPassword(username,password);
    }
}