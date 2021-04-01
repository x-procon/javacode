package com.hazer.dao;


import com.hazer.entity.User;

/**
 * @author hazer
 */

public interface UserDao extends BaseDao<User, Long> {

	/**
	 * 根据用户名查询用户
	 * @param username 用户名
	 * @return com.bairuitech.anychat.website.entity.User
	 */
	User findByUsername(String username);
	/**
	 * 根据用户名密码查询用户
	 * @param username 用户名
	 * @param password 密码
	 * @return com.bairuitech.anychat.website.entity.User
	 */
	User findByUsernameAndPassword(String username,String password);
}
