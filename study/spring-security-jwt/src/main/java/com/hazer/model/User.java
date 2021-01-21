package com.hazer.model;

/**
 * 用户模型
 * @author hazer
 * Created on 2021/1/21
 */
public class User {

    private Long id;
    
    private String username;

    private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}