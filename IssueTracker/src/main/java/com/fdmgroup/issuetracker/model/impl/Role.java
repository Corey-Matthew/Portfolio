package com.fdmgroup.issuetracker.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Role")

public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String role_name;
	public static final String ADMIN = "admin";
	public static final String DEPT_ADMIN ="department_admin";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

}
