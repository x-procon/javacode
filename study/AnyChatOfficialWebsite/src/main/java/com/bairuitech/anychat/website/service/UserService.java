package com.bairuitech.anychat.website.service;

import com.bairuitech.anychat.website.model.User;

import java.util.Set;



/**
 * 用户管理
 * @author Louis
 * @date Jun 29, 2019
 */
public interface UserService {

	/**
	 * 根据用户名查找用户
	 * @param userName 用户名
	 * @return 用户
	 */
	User findByUsername(String userName);

	/**
	 * 查找用户的菜单权限标识集合
	 * @param userName 用户名
	 * @return 权限列表
	 */
	Set<String> findPermissions(String userName);

}
