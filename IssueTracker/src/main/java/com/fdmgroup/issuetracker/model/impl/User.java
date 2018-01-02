package com.fdmgroup.issuetracker.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fdmgroup.issuetracker.model.IUser;

@Entity
@Table(name = "User")
@NamedQueries({ 
@NamedQuery(name = "User.findAll", query = "SELECT u from User u"),
@NamedQuery(name = "User.findByName", 
query = "SELECT u FROM User u WHERE u.username = :username") })

public class User implements IUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int department_id;
	@Column(unique = true)
	private String username;
	private String password;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
