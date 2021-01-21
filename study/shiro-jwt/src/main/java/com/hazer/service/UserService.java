package com.hazer.service;


import com.hazer.entity.Role;
import com.hazer.entity.User;

/**
 * @author hazer
 */
public interface UserService {

	/**
	 * 添加用户
	 * @param user 用户
	 * @return com.bairuitech.anychat.website.entity.User
	 */
	User addUser(User user);
	/**
	 * 添加角色
	 * @param role 角色
	 * @return com.bairuitech.anychat.website.entity.Role
	 */
	Role addRole(Role role);

	/**
	 * 功能描述
	 * @param username 根据用户名查询用户
	 * @return com.bairuitech.anychat.website.entity.User
	 */
	User findByUsername(String username);
	/**
	 * 根据用户名查询用户
	 * @param username 用户名
	 * @param password 密码
	 * @return com.bairuitech.anychat.website.entity.User
	 */
	User findByUsernameAndPassword(String username,String password);
}