package com.hazer.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author hazer
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 20)
    private Long id;
    @Column(unique = true,length = 50)
    private String username;
    private String password;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}