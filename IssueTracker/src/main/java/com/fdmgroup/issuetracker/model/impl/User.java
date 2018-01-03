package com.fdmgroup.issuetracker.model.impl;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fdmgroup.issuetracker.model.IUser;

@Entity
@Table(name = "Users")
@NamedQueries({ 
@NamedQuery(name = "User.findAll", query = "SELECT u from User u"),
@NamedQuery(name = "User.findByName", 
query = "SELECT u FROM User u WHERE u.username = :username") })

public class User implements IUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "User_id")
	private int userId;
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="Dept_id")
	private Department department;
	@Column(unique = true)
	private String username;
	private String password;
	private String email;
	
	public User(){}
	public User(Department department, String username, String password, String email) {
		this.setDepartment(department);
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
	}
	
	public int getUserId() {
		return userId;
	}

	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
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
